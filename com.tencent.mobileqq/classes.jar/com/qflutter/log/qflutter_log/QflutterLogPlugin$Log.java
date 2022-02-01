package com.qflutter.log.qflutter_log;

public abstract interface QflutterLogPlugin$Log
{
  public static final int DEBUG = 4;
  public static final int ERROR = 1;
  public static final int INFO = 3;
  public static final int OFF = 0;
  public static final int VERBOSE = 5;
  public static final int WARN = 2;
  
  public abstract void d(String paramString);
  
  public abstract void e(String paramString);
  
  public abstract int getLogLevel();
  
  public abstract void i(String paramString);
  
  public abstract void v(String paramString);
  
  public abstract void w(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qflutter.log.qflutter_log.QflutterLogPlugin.Log
 * JD-Core Version:    0.7.0.1
 */