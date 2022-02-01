package com.huawei.hiar;

import android.util.Log;
import java.nio.FloatBuffer;

public class ARPlane
  extends ARTrackableBase
{
  private static final String TAG = ARPlane.class.getSimpleName();
  
  protected ARPlane()
  {
    super(0L, null);
  }
  
  ARPlane(long paramLong, ARSession paramARSession)
  {
    super(paramLong, paramARSession);
  }
  
  private native long nativeAcquireSubsumedBy(long paramLong1, long paramLong2);
  
  private native ARPose nativeGetCenterPose(long paramLong1, long paramLong2);
  
  private native float nativeGetExtentX(long paramLong1, long paramLong2);
  
  private native float nativeGetExtentZ(long paramLong1, long paramLong2);
  
  private native float[] nativeGetPolygon(long paramLong1, long paramLong2);
  
  private native int nativeGetType(long paramLong1, long paramLong2);
  
  private native boolean nativeIsPoseInExtents(long paramLong1, long paramLong2, ARPose paramARPose);
  
  private native boolean nativeIsPoseInPolygon(long paramLong1, long paramLong2, ARPose paramARPose);
  
  public ARPose getCenterPose()
  {
    return nativeGetCenterPose(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public float getExtentX()
  {
    return nativeGetExtentX(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public float getExtentZ()
  {
    return nativeGetExtentZ(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public FloatBuffer getPlanePolygon()
  {
    return FloatBuffer.wrap(nativeGetPolygon(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  public ARPlane getSubsumedBy()
  {
    long l = nativeAcquireSubsumedBy(this.mSession.mNativeHandle, this.mNativeHandle);
    if (l == 0L) {
      return null;
    }
    return new ARPlane(l, this.mSession);
  }
  
  public ARPlane.PlaneType getType()
  {
    return ARPlane.PlaneType.forNumber(nativeGetType(this.mSession.mNativeHandle, this.mNativeHandle));
  }
  
  public boolean isPoseInExtents(ARPose paramARPose)
  {
    if (paramARPose == null)
    {
      Log.e(TAG, "isPoseInExtents: input pose is null");
      throw new IllegalArgumentException();
    }
    return nativeIsPoseInExtents(this.mSession.mNativeHandle, this.mNativeHandle, paramARPose);
  }
  
  public boolean isPoseInPolygon(ARPose paramARPose)
  {
    if (paramARPose == null)
    {
      Log.e(TAG, "isPoseInPolygon: input pose is null");
      throw new IllegalArgumentException();
    }
    return nativeIsPoseInPolygon(this.mSession.mNativeHandle, this.mNativeHandle, paramARPose);
  }
  
  public String toString()
  {
    return String.format("ARPlane: { %s, plane type=%s, center pose= %s }", new Object[] { super.toString(), getType().name(), getCenterPose().toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.ARPlane
 * JD-Core Version:    0.7.0.1
 */