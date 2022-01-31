package com.huawei.hiar;

import java.util.Collection;

public class ARAugmentedImage
  extends ARTrackableBase
{
  static final String TAG = ARAugmentedImage.class.getSimpleName();
  
  ARAugmentedImage(long paramLong, ARSession paramARSession)
  {
    super(paramLong, paramARSession);
  }
  
  private native String nativeAcquireName(long paramLong1, long paramLong2);
  
  private native int nativeGetIndex(long paramLong1, long paramLong2);
  
  public ARAnchor createAnchor(ARPose paramARPose)
  {
    return super.createAnchor(paramARPose);
  }
  
  public boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public Collection<ARAnchor> getAnchors()
  {
    return super.getAnchors();
  }
  
  public int getIndex()
  {
    return nativeGetIndex(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public String getName()
  {
    return nativeAcquireName(this.mSession.mNativeHandle, this.mNativeHandle);
  }
  
  public ARTrackable.TrackingState getTrackingState()
  {
    return super.getTrackingState();
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.huawei.hiar.ARAugmentedImage
 * JD-Core Version:    0.7.0.1
 */