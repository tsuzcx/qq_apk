package com.tencent.liteav.basic.util;

public class TXCTimeUtil
{
  static
  {
    f.f();
  }
  
  public static long generatePtsMS()
  {
    return nativeGeneratePtsMS();
  }
  
  public static long getClockTickInHz()
  {
    return nativeGetClockTickInHz();
  }
  
  public static long getTimeTick()
  {
    return nativeGetTimeTick();
  }
  
  public static long getUtcTimeTick()
  {
    return nativeGetUtcTimeTick();
  }
  
  public static void initAppStartTime() {}
  
  private static native long nativeGeneratePtsMS();
  
  private static native long nativeGetClockTickInHz();
  
  private static native long nativeGetTimeTick();
  
  private static native long nativeGetUtcTimeTick();
  
  private static native void nativeInitAppStartTime();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.basic.util.TXCTimeUtil
 * JD-Core Version:    0.7.0.1
 */