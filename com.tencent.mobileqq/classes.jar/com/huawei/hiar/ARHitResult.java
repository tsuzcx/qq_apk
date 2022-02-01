package com.huawei.hiar;

import java.util.Locale;

public class ARHitResult
{
  static final String TAG = ARHitResult.class.getSimpleName();
  long mNativeHandle;
  final ARSession mSession;
  
  protected ARHitResult()
  {
    this.mSession = null;
    this.mNativeHandle = 0L;
  }
  
  ARHitResult(long paramLong, ARSession paramARSession)
  {
    this.mSession = paramARSession;
    this.mNativeHandle = paramLong;
  }
  
  private native long nativeAcquireTrackable(long paramLong1, long paramLong2);
  
  private native long nativeCreateAnchor(long paramLong1, long paramLong2);
  
  private static native void nativeDestroyHitResult(long paramLong);
  
  private native float nativeGetDistance(long paramLong1, long paramLong2);
  
  private native ARPose nativeGetPose(long paramLong1, long paramLong2);
  
  public ARAnchor createAnchor()
  {
    return new ARAnchor(nativeCreateAnchor(this.mSession.mNativeHandle, this.mNativeHandle), this.mSession);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {}
    while (((ARHitResult)paramObject).mNativeHandle != this.mNativeHandle) {
      return false;
    }
    return true;
  }
  
  protected void finalize()
  {
    if (this.mNativeHandle != 0L) {
      nativeDestroyHitResult(this.mNativeHandle);
    }
    super.finalize();
  }
  
  public float getDistance()
  {
    return nativeGetDistance(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public ARPose getHitPose()
  {
    return nativeGetPose(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public ARTrackable getTrackable()
  {
    long l = nativeAcquireTrackable(this.mSession.mNativeHandle, this.mNativeHandle);
    return this.mSession.createTrackable(l);
  }
  
  public int hashCode()
  {
    return Long.valueOf(this.mNativeHandle).hashCode();
  }
  
  public String toString()
  {
    return String.format(Locale.ENGLISH, "hit result: { hit on pose: %s, with distance %f }", new Object[] { getHitPose().toString(), Float.valueOf(getDistance()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.ARHitResult
 * JD-Core Version:    0.7.0.1
 */