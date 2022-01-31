package com.tencent.bugly.crashreport;

public abstract interface a
{
  public abstract boolean appendLogToNative(String paramString1, String paramString2, String paramString3);
  
  public abstract String getLogFromNative();
  
  public abstract boolean setNativeIsAppForeground(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.a
 * JD-Core Version:    0.7.0.1
 */