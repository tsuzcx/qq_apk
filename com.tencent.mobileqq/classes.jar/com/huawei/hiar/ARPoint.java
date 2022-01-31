package com.huawei.hiar;

public class ARPoint
  extends ARTrackableBase
{
  static final int AR_POINT_ORIENTATION_ESTIMATED_SURFACE_NORMAL = 1;
  static final int AR_POINT_ORIENTATION_INITIALIZED_TO_IDENTITY = 0;
  
  protected ARPoint()
  {
    super(0L, null);
  }
  
  ARPoint(long paramLong, ARSession paramARSession)
  {
    super(paramLong, paramARSession);
  }
  
  private native int nativeGetOrientationMode(long paramLong1, long paramLong2);
  
  private native ARPose nativeGetPose(long paramLong1, long paramLong2);
  
  public ARPoint.OrientationMode getOrientationMode()
  {
    return ARPoint.OrientationMode.forNumber(nativeGetOrientationMode(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  ARPose getPose()
  {
    return nativeGetPose(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public String toString()
  {
    return String.format("ARPoint: { %s, pose=%s, orientationMode=%s }", new Object[] { super.toString(), getPose().toString(), getOrientationMode().name() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.ARPoint
 * JD-Core Version:    0.7.0.1
 */