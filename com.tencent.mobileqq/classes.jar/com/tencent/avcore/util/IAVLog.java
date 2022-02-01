package com.tencent.avcore.util;

public abstract interface IAVLog
{
  public abstract void d(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2);
  
  public abstract void e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract long genDebugSeq();
  
  public abstract String getVersion();
  
  public abstract void i(String paramString1, String paramString2);
  
  public abstract boolean isColorLevel();
  
  public abstract boolean isDebugVersion();
  
  public abstract boolean isDevelopLevel();
  
  public abstract boolean isGrayVersion();
  
  public abstract void printAllUserLog(String paramString1, String paramString2);
  
  public abstract void printColorLog(String paramString1, String paramString2);
  
  public abstract void printDebugLog(String paramString1, String paramString2);
  
  public abstract void printErrorLog(String paramString1, String paramString2);
  
  public abstract void printInfoLog(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.util.IAVLog
 * JD-Core Version:    0.7.0.1
 */