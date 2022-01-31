package com.tencent.mobileqq.armap;

public class JniCommon
{
  public static native void nativeChangeIcon();
  
  public static native void nativeClipWidth(long paramLong, float paramFloat);
  
  public static native int nativeGetPartTwoIndex();
  
  public static native void nativeOnShowLeft(long paramLong, boolean paramBoolean);
  
  public static native void nativeOnSwitchRotateMode(long paramLong, boolean paramBoolean);
  
  public static native void nativeReceiveResult(boolean paramBoolean);
  
  public static native void nativeSetAnswer(int paramInt);
  
  public static native void nativeSetCallback();
  
  public static native void nativeSetIconUin(String paramString);
  
  public static native void nativeSetModelLogo(String paramString);
  
  public static native void nativeSetPossible(boolean paramBoolean);
  
  public static native void nativeSetSuperCellCallback();
  
  public static native void nativeSetVelocity(long paramLong, float paramFloat1, float paramFloat2);
  
  public static native void nativeSuperCellSwitchMode(int paramInt);
  
  public static native void nativeSwitchMode(int paramInt);
  
  public static native void nativeSwitchWireFrame();
  
  public static native void nativeSwitchWireFrame2();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.JniCommon
 * JD-Core Version:    0.7.0.1
 */