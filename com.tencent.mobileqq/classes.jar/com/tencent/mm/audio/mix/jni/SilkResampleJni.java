package com.tencent.mm.audio.mix.jni;

public class SilkResampleJni
{
  static
  {
    System.loadLibrary("wechataudiosilk");
  }
  
  public static native int clearResample(String paramString);
  
  public static native int initResample(String paramString, int paramInt1, int paramInt2);
  
  public static native int resamplePcm(String paramString, int paramInt1, int paramInt2, short[] paramArrayOfShort1, int paramInt3, short[] paramArrayOfShort2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.jni.SilkResampleJni
 * JD-Core Version:    0.7.0.1
 */