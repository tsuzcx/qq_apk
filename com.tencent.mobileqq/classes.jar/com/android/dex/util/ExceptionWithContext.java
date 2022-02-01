package com.android.dex.util;

import java.io.PrintStream;
import java.io.PrintWriter;

public class ExceptionWithContext
  extends RuntimeException
{
  private StringBuffer context;
  
  public ExceptionWithContext(String paramString)
  {
    this(paramString, null);
  }
  
  public ExceptionWithContext(String paramString, Throwable paramThrowable) {}
  
  public ExceptionWithContext(Throwable paramThrowable)
  {
    this(null, paramThrowable);
  }
  
  public static ExceptionWithContext withContext(Throwable paramThrowable, String paramString)
  {
    if ((paramThrowable instanceof ExceptionWithContext)) {}
    for (paramThrowable = (ExceptionWithContext)paramThrowable;; paramThrowable = new ExceptionWithContext(paramThrowable))
    {
      paramThrowable.addContext(paramString);
      return paramThrowable;
    }
  }
  
  public void addContext(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("str == null");
    }
    this.context.append(paramString);
    if (!paramString.endsWith("\n")) {
      this.context.append('\n');
    }
  }
  
  public String getContext()
  {
    return this.context.toString();
  }
  
  public void printContext(PrintStream paramPrintStream)
  {
    paramPrintStream.println(getMessage());
    paramPrintStream.print(this.context);
  }
  
  public void printContext(PrintWriter paramPrintWriter)
  {
    paramPrintWriter.println(getMessage());
    paramPrintWriter.print(this.context);
  }
  
  public void printStackTrace(PrintStream paramPrintStream)
  {
    super.printStackTrace(paramPrintStream);
    paramPrintStream.println(this.context);
  }
  
  public void printStackTrace(PrintWriter paramPrintWriter)
  {
    super.printStackTrace(paramPrintWriter);
    paramPrintWriter.println(this.context);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dex.util.ExceptionWithContext
 * JD-Core Version:    0.7.0.1
 */