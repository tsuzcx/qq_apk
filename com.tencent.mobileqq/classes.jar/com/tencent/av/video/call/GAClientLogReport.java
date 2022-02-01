package com.tencent.av.video.call;

import bjcq;

public class GAClientLogReport
{
  private static final String TAG = "GAClientLogReport";
  private static GAClientLogReport instance;
  
  static
  {
    try
    {
      cacheMethodIds();
      return;
    }
    catch (Throwable localThrowable)
    {
      bjcq.a("GAClientLogReport", "cacheMethodIds fail.", localThrowable);
    }
  }
  
  private GAClientLogReport()
  {
    try
    {
      init();
      return;
    }
    catch (Throwable localThrowable)
    {
      bjcq.a("GAClientLogReport", "inti fail.", localThrowable);
    }
  }
  
  private static native void cacheMethodIds();
  
  private int callbackSendLog(long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    return ClientLogReport.instance().callbackSendLog(paramLong, paramInt, paramArrayOfByte);
  }
  
  private native void init();
  
  public static GAClientLogReport instance()
  {
    if (instance == null) {
      instance = new GAClientLogReport();
    }
    return instance;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.call.GAClientLogReport
 * JD-Core Version:    0.7.0.1
 */