package com.tencent.imsdk.v2;

public class V2TIMSDKConfig
{
  public static final int V2TIM_LOG_DEBUG = 3;
  public static final int V2TIM_LOG_ERROR = 6;
  public static final int V2TIM_LOG_INFO = 4;
  public static final int V2TIM_LOG_NONE = 0;
  public static final int V2TIM_LOG_WARN = 5;
  private int logLevel = 4;
  private V2TIMLogListener v2TIMLogListener;
  
  public int getLogLevel()
  {
    return this.logLevel;
  }
  
  public V2TIMLogListener getLogListener()
  {
    return this.v2TIMLogListener;
  }
  
  public void setLogLevel(int paramInt)
  {
    this.logLevel = paramInt;
  }
  
  public void setLogListener(V2TIMLogListener paramV2TIMLogListener)
  {
    this.v2TIMLogListener = paramV2TIMLogListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSDKConfig
 * JD-Core Version:    0.7.0.1
 */