package com.company;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;


public class Hydra_GUI extends JFrame
{
    private JButton cut;
    private JPanel panel1;
    private JButton noo;
    private JFrame frame[] = new JFrame[1000000];
    private static JFrame test = new JFrame("Hydra.exe");
    private static int zaehler = 0;
    private ImageIcon icon = new ImageIcon(Class.class.getResource("/img/hydra.png"));

    private Hydra_GUI()
    {
        cut.addActionListener(e -> buttonClicked(1));

        noo.addActionListener(e ->
        {
            JOptionPane.showMessageDialog(null, "Du hast Hydra 50 Köpfe abgeschlagen, klasse!","Achtung!",
                    JOptionPane.ERROR_MESSAGE, icon);
            buttonClicked(100);
        });

    }
    public static void main(String[] args)
    {
        test.setContentPane(new Hydra_GUI().panel1);
        test.pack();
        test.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        test.setVisible(true);
    }

    private void buttonClicked(int here)
    {
        if (zaehler < 1)
        {
            test.dispose();
            zaehler++;
        }
        test.dispose();
        neueGUI(here);
    }

    private void neueGUI (int top)
    {
        int zahl2 = zaehler + top;
        Random random = new Random();
        while (zaehler <= zahl2)
        {
            frame[zaehler] = new JFrame("Hydra (" + zaehler + ").exe");
            frame[zaehler].setContentPane(new Hydra_GUI_2().panel1);
            frame[zaehler].pack();
            frame[zaehler].addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    super.windowClosing(e);
                    neueGUI(1);
                }
            });
            frame[zaehler].setLocation(random.nextInt(1500), random.nextInt(1080));
            frame[zaehler].setVisible(true);
            zaehler++;
        }
    }
}