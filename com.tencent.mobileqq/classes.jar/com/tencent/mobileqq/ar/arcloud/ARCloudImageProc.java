package com.tencent.mobileqq.ar.arcloud;

public class ARCloudImageProc
{
  public static native int nativeInit();
  
  public static native int nativeScaleAndRotate(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte2, int paramInt4, int paramInt5);
  
  public static native int nativeUninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.ARCloudImageProc
 * JD-Core Version:    0.7.0.1
 */