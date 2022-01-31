package com.tencent.maxvideo.activity;

public class CoverNative
{
  public static native void closeFile(long paramLong);
  
  public static native boolean getFrameYuv(long paramLong, String paramString, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3);
  
  public static native int getVfFrameCount(long paramLong);
  
  public static native long openFile(String paramString);
  
  public static native int[] testTran();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.maxvideo.activity.CoverNative
 * JD-Core Version:    0.7.0.1
 */