package com.google.android.filament;

import android.support.annotation.IntRange;
import com.google.android.filament.proguard.UsedByReflection;

public class Skybox
{
  private long mNativeObject;
  
  @UsedByReflection("KtxLoader.java")
  Skybox(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  private static native long nBuilderBuild(long paramLong1, long paramLong2);
  
  private static native void nBuilderEnvironment(long paramLong1, long paramLong2);
  
  private static native void nBuilderIntensity(long paramLong, float paramFloat);
  
  private static native void nBuilderShowSun(long paramLong, boolean paramBoolean);
  
  private static native long nCreateBuilder();
  
  private static native void nDestroyBuilder(long paramLong);
  
  private static native float nGetIntensity(long paramLong);
  
  private static native int nGetLayerMask(long paramLong);
  
  private static native void nSetLayerMask(long paramLong, int paramInt1, int paramInt2);
  
  void clearNativeObject()
  {
    this.mNativeObject = 0L;
  }
  
  public float getIntensity()
  {
    return nGetIntensity(getNativeObject());
  }
  
  public int getLayerMask()
  {
    return nGetLayerMask(getNativeObject());
  }
  
  public long getNativeObject()
  {
    if (this.mNativeObject == 0L) {
      throw new IllegalStateException("Calling method on destroyed Skybox");
    }
    return this.mNativeObject;
  }
  
  public void setLayerMask(@IntRange(from=0L, to=255L) int paramInt1, @IntRange(from=0L, to=255L) int paramInt2)
  {
    nSetLayerMask(getNativeObject(), paramInt1 & 0xFF, paramInt2 & 0xFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.Skybox
 * JD-Core Version:    0.7.0.1
 */