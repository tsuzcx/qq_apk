package com.tencent.logger.log;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/logger/log/LogLevel;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "VERBOSE", "DEBUG", "INFO", "WARNING", "ERROR", "FATAL", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public enum LogLevel
{
  private final int value;
  
  static
  {
    LogLevel localLogLevel1 = new LogLevel("VERBOSE", 0, 0);
    VERBOSE = localLogLevel1;
    LogLevel localLogLevel2 = new LogLevel("DEBUG", 1, 1);
    DEBUG = localLogLevel2;
    LogLevel localLogLevel3 = new LogLevel("INFO", 2, 2);
    INFO = localLogLevel3;
    LogLevel localLogLevel4 = new LogLevel("WARNING", 3, 3);
    WARNING = localLogLevel4;
    LogLevel localLogLevel5 = new LogLevel("ERROR", 4, 4);
    ERROR = localLogLevel5;
    LogLevel localLogLevel6 = new LogLevel("FATAL", 5, 5);
    FATAL = localLogLevel6;
    $VALUES = new LogLevel[] { localLogLevel1, localLogLevel2, localLogLevel3, localLogLevel4, localLogLevel5, localLogLevel6 };
  }
  
  private LogLevel(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.logger.log.LogLevel
 * JD-Core Version:    0.7.0.1
 */