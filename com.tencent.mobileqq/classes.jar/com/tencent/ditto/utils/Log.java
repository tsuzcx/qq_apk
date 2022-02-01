package com.tencent.ditto.utils;

public abstract interface Log
{
  public abstract void d(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void i(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract boolean isColoredLevel();
  
  public abstract void v(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void w(String paramString1, String paramString2, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.utils.Log
 * JD-Core Version:    0.7.0.1
 */