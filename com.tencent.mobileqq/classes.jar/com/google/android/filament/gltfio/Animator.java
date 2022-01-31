package com.google.android.filament.gltfio;

public class Animator
{
  private long mNativeAnimatorObject;
  private long startTime = 0L;
  
  public Animator(long paramLong)
  {
    this.mNativeAnimatorObject = paramLong;
  }
  
  private static native void nApplyAnimation(long paramLong, double paramDouble);
  
  private static native long nGetAnimationCount(long paramLong);
  
  public void applyAnimation()
  {
    long l = System.currentTimeMillis();
    if (this.startTime <= 0L) {
      this.startTime = l;
    }
    double d = (l - this.startTime) / 1000.0D;
    nApplyAnimation(this.mNativeAnimatorObject, d);
  }
  
  public long getAnimationCount()
  {
    return nGetAnimationCount(this.mNativeAnimatorObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.google.android.filament.gltfio.Animator
 * JD-Core Version:    0.7.0.1
 */