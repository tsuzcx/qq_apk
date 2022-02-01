package com.tencent.mobileqq.ar.arcloud;

public class ARCloudImageFilter
{
  public static native boolean nativeFilter(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native int nativeInit(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native int nativeInitOcr(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  public static native int nativeIsNeonOpen();
  
  public static native boolean nativeIsSameScene(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  public static native int nativeSetNeonOpen(int paramInt);
  
  public static native int nativeUninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.ARCloudImageFilter
 * JD-Core Version:    0.7.0.1
 */