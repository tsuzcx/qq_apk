package com.huawei.hiar;

import java.util.Collection;
import java.util.Locale;

class ARTrackableBase
  implements ARTrackable
{
  private static final String TAG = ARTrackableBase.class.getSimpleName();
  final long mNativeHandle;
  final ARSession mSession;
  
  ARTrackableBase(long paramLong, ARSession paramARSession)
  {
    this.mSession = paramARSession;
    this.mNativeHandle = paramLong;
  }
  
  static int internalGetType(long paramLong1, long paramLong2)
  {
    return nativeGetType(paramLong1, paramLong2);
  }
  
  static void internalReleaseNativeHandle(long paramLong)
  {
    nativeReleaseTrackable(paramLong);
  }
  
  private native long nativeCreateAnchor(long paramLong1, long paramLong2, ARPose paramARPose);
  
  private native long[] nativeGetAnchors(long paramLong1, long paramLong2);
  
  private native int nativeGetTrackingState(long paramLong1, long paramLong2);
  
  private static native int nativeGetType(long paramLong1, long paramLong2);
  
  private static native void nativeReleaseTrackable(long paramLong);
  
  public ARAnchor createAnchor(ARPose paramARPose)
  {
    return new ARAnchor(nativeCreateAnchor(this.mSession.mNativeHandle, this.mNativeHandle, paramARPose), this.mSession);
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {}
    while (((ARTrackableBase)paramObject).mNativeHandle != this.mNativeHandle) {
      return false;
    }
    return true;
  }
  
  protected void finalize()
  {
    if (this.mNativeHandle != 0L) {
      nativeReleaseTrackable(this.mNativeHandle);
    }
    super.finalize();
  }
  
  public Collection<ARAnchor> getAnchors()
  {
    return this.mSession.convertNativeAnchorsToCollection(nativeGetAnchors(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  public ARTrackable.TrackingState getTrackingState()
  {
    return ARTrackable.TrackingState.forNumber(nativeGetTrackingState(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  public int hashCode()
  {
    return Long.valueOf(this.mNativeHandle).hashCode();
  }
  
  public String toString()
  {
    return String.format(Locale.ENGLISH, "trackableHandle= 0x%x, trackingState=%s, anchors=%s", new Object[] { Long.valueOf(this.mNativeHandle), getTrackingState(), getAnchors().toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.ARTrackableBase
 * JD-Core Version:    0.7.0.1
 */