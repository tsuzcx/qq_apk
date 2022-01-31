package com.huawei.hiar;

@Deprecated
public class ARPlaneHitResult
  extends ARHitResult
{
  static final String TAG = ARPlaneHitResult.class.getSimpleName();
  
  @Deprecated
  protected ARPlaneHitResult() {}
  
  @Deprecated
  ARPlaneHitResult(long paramLong, ARSession paramARSession)
  {
    super(paramLong, paramARSession);
  }
  
  @Deprecated
  public ARPlane getPlane()
  {
    ARTrackable localARTrackable = getTrackable();
    if ((localARTrackable instanceof ARPlane)) {
      return (ARPlane)localARTrackable;
    }
    return null;
  }
  
  @Deprecated
  public boolean isHitInExtents()
  {
    ARPlane localARPlane = getPlane();
    if (localARPlane == null) {
      return false;
    }
    return localARPlane.isPoseInExtents(getHitPose());
  }
  
  @Deprecated
  public boolean isHitInPolygon()
  {
    ARPlane localARPlane = getPlane();
    if (localARPlane == null) {
      return false;
    }
    return localARPlane.isPoseInPolygon(getHitPose());
  }
  
  @Deprecated
  public boolean isHitOnFrontFace()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.huawei.hiar.ARPlaneHitResult
 * JD-Core Version:    0.7.0.1
 */