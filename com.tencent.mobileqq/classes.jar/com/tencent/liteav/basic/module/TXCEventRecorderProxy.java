package com.tencent.liteav.basic.module;

public class TXCEventRecorderProxy
{
  private long a;
  
  public static void a(String paramString1, int paramInt1, long paramLong1, long paramLong2, String paramString2, int paramInt2)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return;
      }
      nativeAddEventMsg(paramString1, paramInt1, paramLong1, paramLong2, paramString2, paramInt2);
    }
  }
  
  private static native void nativeAddEventMsg(String paramString1, int paramInt1, long paramLong1, long paramLong2, String paramString2, int paramInt2);
  
  private static native void nativeRelease(long paramLong);
  
  protected void finalize()
  {
    nativeRelease(this.a);
    this.a = 0L;
    super.finalize();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.module.TXCEventRecorderProxy
 * JD-Core Version:    0.7.0.1
 */