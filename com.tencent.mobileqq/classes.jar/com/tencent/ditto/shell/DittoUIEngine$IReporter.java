package com.tencent.ditto.shell;

public abstract interface DittoUIEngine$IReporter
{
  public abstract void compassReport(int[] paramArrayOfInt);
  
  public abstract void haboReport(String paramString1, int paramInt1, String paramString2, int paramInt2);
  
  public abstract void reportTTTClick(String paramString);
  
  public abstract void reportTTTLongClick(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.shell.DittoUIEngine.IReporter
 * JD-Core Version:    0.7.0.1
 */