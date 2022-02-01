package com.google.android.filament.gltfio;

import androidx.annotation.IntRange;

public class Animator
{
  private long mNativeObject;
  
  Animator(long paramLong)
  {
    this.mNativeObject = paramLong;
  }
  
  private static native void nApplyAnimation(long paramLong, int paramInt, float paramFloat);
  
  private static native int nGetAnimationCount(long paramLong);
  
  private static native float nGetAnimationDuration(long paramLong, int paramInt);
  
  private static native String nGetAnimationName(long paramLong, int paramInt);
  
  private static native void nUpdateBoneMatrices(long paramLong);
  
  public void applyAnimation(@IntRange(from=0L) int paramInt, float paramFloat)
  {
    nApplyAnimation(this.mNativeObject, paramInt, paramFloat);
  }
  
  public int getAnimationCount()
  {
    return nGetAnimationCount(this.mNativeObject);
  }
  
  public float getAnimationDuration(@IntRange(from=0L) int paramInt)
  {
    return nGetAnimationDuration(this.mNativeObject, paramInt);
  }
  
  public String getAnimationName(@IntRange(from=0L) int paramInt)
  {
    return nGetAnimationName(this.mNativeObject, paramInt);
  }
  
  public void updateBoneMatrices()
  {
    nUpdateBoneMatrices(this.mNativeObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.google.android.filament.gltfio.Animator
 * JD-Core Version:    0.7.0.1
 */