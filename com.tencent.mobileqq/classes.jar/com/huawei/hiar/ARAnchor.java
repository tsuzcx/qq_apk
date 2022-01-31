package com.huawei.hiar;

import android.util.Log;

public class ARAnchor
{
  static final String TAG = ARAnchor.class.getSimpleName();
  long mNativeHandle;
  private final ARSession mSession;
  
  protected ARAnchor()
  {
    this.mSession = null;
    this.mNativeHandle = 0L;
  }
  
  ARAnchor(long paramLong, ARSession paramARSession)
  {
    this.mSession = paramARSession;
    this.mNativeHandle = paramLong;
  }
  
  private native void nativeDetach(long paramLong1, long paramLong2);
  
  private native long nativeGetLocalId(long paramLong1, long paramLong2);
  
  private native ARPose nativeGetPose(long paramLong1, long paramLong2);
  
  private native int nativeGetTrackingState(long paramLong1, long paramLong2);
  
  private static native void nativeReleaseAnchor(long paramLong);
  
  public void detach()
  {
    Log.d(TAG, "detach: detach begin & native detach begin");
    nativeDetach(this.mSession.mNativeHandle, this.mNativeHandle);
    Log.d(TAG, "detach: detach end & native detach end");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramObject != null)
    {
      bool1 = bool2;
      if (paramObject.getClass() == getClass())
      {
        bool1 = bool2;
        if (((ARAnchor)paramObject).mNativeHandle == this.mNativeHandle) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected void finalize()
  {
    if (this.mNativeHandle != 0L) {
      nativeReleaseAnchor(this.mNativeHandle);
    }
    super.finalize();
  }
  
  @Deprecated
  public int getId()
  {
    Log.d(TAG, "getId: get id & native get id begin ");
    int i = (int)nativeGetLocalId(this.mSession.mNativeHandle, this.mNativeHandle);
    Log.d(TAG, "getId: get id end & native get id end with value= " + i);
    return i;
  }
  
  public ARPose getPose()
  {
    return nativeGetPose(this.mSession.mNativeHandle, this.mNativeHandle);
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
    return String.format("ARAnchor{ handle=0x%x, tracking state is %s}", new Object[] { Long.valueOf(this.mNativeHandle), getTrackingState().name() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.ARAnchor
 * JD-Core Version:    0.7.0.1
 */