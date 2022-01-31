package com.tencent.av.video.effect.utils;

public class LowLightUtils
{
  static
  {
    if (!NativeLoader.mIsSoLoaded) {
      NativeLoader.loadSo();
    }
  }
  
  public static native int[] DetectLowLight(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.video.effect.utils.LowLightUtils
 * JD-Core Version:    0.7.0.1
 */