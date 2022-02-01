package com.android.dx.command.dexer;

import com.android.dx.command.UsageException;
import java.io.PrintStream;

class Main$Arguments$ArgumentsParser
{
  private final String[] arguments;
  private String current;
  private int index;
  private String lastValue;
  
  public Main$Arguments$ArgumentsParser(String[] paramArrayOfString)
  {
    this.arguments = paramArrayOfString;
    this.index = 0;
  }
  
  private boolean getNextValue()
  {
    if (this.index >= this.arguments.length) {
      return false;
    }
    this.current = this.arguments[this.index];
    this.index += 1;
    return true;
  }
  
  public String getCurrent()
  {
    return this.current;
  }
  
  public String getLastValue()
  {
    return this.lastValue;
  }
  
  public boolean getNext()
  {
    if (this.index >= this.arguments.length) {}
    do
    {
      return false;
      this.current = this.arguments[this.index];
    } while ((this.current.equals("--")) || (!this.current.startsWith("--")));
    this.index += 1;
    return true;
  }
  
  public String[] getRemaining()
  {
    int i = this.arguments.length - this.index;
    String[] arrayOfString = new String[i];
    if (i > 0) {
      System.arraycopy(this.arguments, this.index, arrayOfString, 0, i);
    }
    return arrayOfString;
  }
  
  public boolean isArg(String paramString)
  {
    int i = paramString.length();
    if ((i > 0) && (paramString.charAt(i - 1) == '='))
    {
      if (this.current.startsWith(paramString))
      {
        this.lastValue = this.current.substring(i);
        return true;
      }
      paramString = paramString.substring(0, i - 1);
      if (this.current.equals(paramString))
      {
        if (getNextValue())
        {
          this.lastValue = this.current;
          return true;
        }
        System.err.println("Missing value after parameter " + paramString);
        throw new UsageException();
      }
      return false;
    }
    return this.current.equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dexer.Main.Arguments.ArgumentsParser
 * JD-Core Version:    0.7.0.1
 */