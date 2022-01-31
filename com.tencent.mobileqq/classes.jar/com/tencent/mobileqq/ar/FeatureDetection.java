package com.tencent.mobileqq.ar;

public class FeatureDetection
{
  static
  {
    System.loadLibrary("ArFeatureDetection");
  }
  
  public static native void release();
  
  public static native int[] track(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.FeatureDetection
 * JD-Core Version:    0.7.0.1
 */