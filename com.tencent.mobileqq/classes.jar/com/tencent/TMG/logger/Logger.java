package com.tencent.TMG.logger;

public abstract interface Logger
{
  public static final int LOG_LEVEL_FAULT = 5;
  public static final int LOG_LEVEL_INFO = 6;
  
  public abstract String getLogDir();
  
  public abstract int getWriteLogLevel();
  
  public abstract void init(String paramString);
  
  public abstract boolean isEnablePrintLog();
  
  public abstract boolean reportKeyLog(String paramString1, int paramInt, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.logger.Logger
 * JD-Core Version:    0.7.0.1
 */