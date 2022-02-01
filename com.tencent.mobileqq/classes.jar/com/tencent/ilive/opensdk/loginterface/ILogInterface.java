package com.tencent.ilive.opensdk.loginterface;

public abstract interface ILogInterface
{
  public abstract void d(String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract void e(String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract void i(String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract void printException(String paramString, Throwable paramThrowable);
  
  public abstract void printException(String paramString1, Throwable paramThrowable, String paramString2);
  
  public abstract void printException(Throwable paramThrowable);
  
  public abstract void printStackTrace(Throwable paramThrowable);
  
  public abstract void v(String paramString1, String paramString2, Object... paramVarArgs);
  
  public abstract void w(String paramString1, String paramString2, Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.opensdk.loginterface.ILogInterface
 * JD-Core Version:    0.7.0.1
 */