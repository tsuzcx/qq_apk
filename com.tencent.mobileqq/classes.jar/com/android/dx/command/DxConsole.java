package com.android.dx.command;

import java.io.PrintStream;

public class DxConsole
{
  public static PrintStream err = System.err;
  public static final PrintStream noop = new PrintStream(new DxConsole.1());
  public static PrintStream out = System.out;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.DxConsole
 * JD-Core Version:    0.7.0.1
 */