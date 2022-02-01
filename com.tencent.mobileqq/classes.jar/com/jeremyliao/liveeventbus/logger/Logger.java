package com.jeremyliao.liveeventbus.logger;

import java.util.logging.Level;

public abstract interface Logger
{
  public abstract void log(Level paramLevel, String paramString);
  
  public abstract void log(Level paramLevel, String paramString, Throwable paramThrowable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.logger.Logger
 * JD-Core Version:    0.7.0.1
 */