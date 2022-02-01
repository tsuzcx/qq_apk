package com.tencent.gathererga.core;

public abstract interface ILog
{
  public abstract void d(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void i(String paramString1, String paramString2);
  
  public abstract void w(String paramString1, String paramString2);
  
  public abstract void w(String paramString1, String paramString2, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.ILog
 * JD-Core Version:    0.7.0.1
 */