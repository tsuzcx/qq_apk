package com.jeremyliao.liveeventbus.logger;

import java.util.logging.Level;

public class LoggerManager
  implements Logger
{
  private boolean enable = true;
  private Logger logger;
  
  public LoggerManager(Logger paramLogger)
  {
    this.logger = paramLogger;
  }
  
  public Logger getLogger()
  {
    return this.logger;
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void log(Level paramLevel, String paramString)
  {
    if (this.enable) {
      this.logger.log(paramLevel, paramString);
    }
  }
  
  public void log(Level paramLevel, String paramString, Throwable paramThrowable)
  {
    if (this.enable) {
      this.logger.log(paramLevel, paramString, paramThrowable);
    }
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.enable = paramBoolean;
  }
  
  public void setLogger(Logger paramLogger)
  {
    this.logger = paramLogger;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.jeremyliao.liveeventbus.logger.LoggerManager
 * JD-Core Version:    0.7.0.1
 */