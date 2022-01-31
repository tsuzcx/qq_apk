package com.huawei.hiar;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
public class ARBody
  extends ARTrackableBase
{
  ARBody(long paramLong, ARSession paramARSession)
  {
    super(paramLong, paramARSession);
  }
  
  private native int nativeGetBodyAction(long paramLong1, long paramLong2);
  
  private native int[] nativeGetSkeletonConnection(long paramLong1, long paramLong2);
  
  private native float[] nativeGetSkeletonPoint2D(long paramLong1, long paramLong2);
  
  private native float[] nativeGetSkeletonPoint3D(long paramLong1, long paramLong2);
  
  public int getBodyAction()
  {
    return nativeGetBodyAction(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public int[] getBodySkeletonConnection()
  {
    return nativeGetSkeletonConnection(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public float[] getSkeletonPoint2D()
  {
    return nativeGetSkeletonPoint2D(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public float[] getSkeletonPoint3D()
  {
    return nativeGetSkeletonPoint3D(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  @SuppressLint({"DefaultLocale"})
  public String toString()
  {
    return String.format("HiARBody{skeletonPointExist2D: %sskeletonPointExist3D:%s, bodySkeletonConnection: %s, bodyAction: %d}\n", new Object[] { Arrays.toString(getSkeletonPoint2D()), Arrays.toString(getSkeletonPoint3D()), Arrays.toString(getBodySkeletonConnection()), Integer.valueOf(getBodyAction()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.ARBody
 * JD-Core Version:    0.7.0.1
 */