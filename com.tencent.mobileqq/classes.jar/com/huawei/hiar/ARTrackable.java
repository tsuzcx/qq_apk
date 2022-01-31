package com.huawei.hiar;

import java.util.Collection;

public abstract interface ARTrackable
{
  public abstract ARAnchor createAnchor(ARPose paramARPose);
  
  public abstract Collection<ARAnchor> getAnchors();
  
  public abstract ARTrackable.TrackingState getTrackingState();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.hiar.ARTrackable
 * JD-Core Version:    0.7.0.1
 */