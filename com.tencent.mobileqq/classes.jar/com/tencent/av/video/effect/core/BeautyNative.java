package com.tencent.av.video.effect.core;

import com.tencent.av.video.effect.utils.NativeLoader;

public class BeautyNative
{
  static
  {
    if (!NativeLoader.mIsSoLoaded) {
      NativeLoader.loadSo();
    }
  }
  
  public static native byte[] beautyProcess20(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public static native byte[] beautyProcess25(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean);
  
  public static native byte[] convertI420ToNV12(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public static native byte[] convertI420ToNV21(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.video.effect.core.BeautyNative
 * JD-Core Version:    0.7.0.1
 */