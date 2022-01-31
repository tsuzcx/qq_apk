package com.huawei.hiar;

public class ARCamera
{
  private static final String TAG = ARCamera.class.getSimpleName();
  long mNativeHandle;
  final ARSession mSession;
  
  protected ARCamera()
  {
    this.mSession = null;
    this.mNativeHandle = 0L;
  }
  
  ARCamera(ARSession paramARSession, ARFrame paramARFrame)
  {
    this.mSession = paramARSession;
    this.mNativeHandle = nativeAcquireCamera(paramARSession.mNativeHandle, paramARFrame.mNativeHandle);
  }
  
  private static native long nativeAcquireCamera(long paramLong1, long paramLong2);
  
  private native ARPose nativeDisplayOrientedPose(long paramLong1, long paramLong2);
  
  private native ARPose nativeGetPose(long paramLong1, long paramLong2);
  
  private native void nativeGetProjectionMatrix(long paramLong1, long paramLong2, float[] paramArrayOfFloat, int paramInt, float paramFloat1, float paramFloat2);
  
  private native int nativeGetTrackingState(long paramLong1, long paramLong2);
  
  private native void nativeGetViewMatrix(long paramLong1, long paramLong2, float[] paramArrayOfFloat, int paramInt);
  
  private static native void nativeReleaseCamera(long paramLong);
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.getClass() != getClass())) {}
    while (((ARCamera)paramObject).mNativeHandle != this.mNativeHandle) {
      return false;
    }
    return true;
  }
  
  protected void finalize()
  {
    if (this.mNativeHandle != 0L) {
      nativeReleaseCamera(this.mNativeHandle);
    }
    super.finalize();
  }
  
  public ARPose getDisplayOrientedPose()
  {
    return nativeDisplayOrientedPose(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public ARPose getPose()
  {
    return nativeGetPose(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public void getProjectionMatrix(float[] paramArrayOfFloat, int paramInt, float paramFloat1, float paramFloat2)
  {
    if ((paramArrayOfFloat == null) || (paramInt < 0) || (paramArrayOfFloat.length < paramInt + 16) || (paramFloat1 < 0.0F) || (paramFloat2 < 0.0F) || (Float.compare(paramFloat1, paramFloat2) == 0)) {
      throw new IllegalArgumentException();
    }
    nativeGetProjectionMatrix(this.mSession.mNativeHandle, this.mNativeHandle, paramArrayOfFloat, paramInt, Math.min(paramFloat1, paramFloat2), Math.max(paramFloat1, paramFloat2));
  }
  
  public ARTrackable.TrackingState getTrackingState()
  {
    return ARTrackable.TrackingState.forNumber(nativeGetTrackingState(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  public void getViewMatrix(float[] paramArrayOfFloat, int paramInt)
  {
    if ((paramArrayOfFloat == null) || (paramInt < 0) || (paramArrayOfFloat.length < paramInt + 16)) {
      throw new IllegalArgumentException();
    }
    nativeGetViewMatrix(this.mSession.mNativeHandle, this.mNativeHandle, paramArrayOfFloat, paramInt);
  }
  
  public int hashCode()
  {
    return Long.valueOf(this.mNativeHandle).hashCode();
  }
  
  public String toString()
  {
    return String.format("ARCamera: {handle=0x%x, trackingstate=%s, pose=%s, DisplayOrientedPose=%s}", new Object[] { Long.valueOf(this.mNativeHandle), getTrackingState().name(), getPose().toString(), getDisplayOrientedPose().toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.hiar.ARCamera
 * JD-Core Version:    0.7.0.1
 */