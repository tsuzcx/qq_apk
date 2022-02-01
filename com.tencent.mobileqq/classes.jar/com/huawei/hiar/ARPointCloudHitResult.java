package com.huawei.hiar;

@Deprecated
public class ARPointCloudHitResult
  extends ARHitResult
{
  private ARPointCloud mPointCloud;
  
  @Deprecated
  protected ARPointCloudHitResult() {}
  
  @Deprecated
  ARPointCloudHitResult(long paramLong, ARSession paramARSession, ARPointCloud paramARPointCloud)
  {
    super(paramLong, paramARSession);
    this.mPointCloud = paramARPointCloud;
  }
  
  @Deprecated
  public ARPointCloud getPointCloud()
  {
    return this.mPointCloud;
  }
  
  @Deprecated
  public ARPose getPointCloudPose()
  {
    return ARPose.IDENTITY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hiar.ARPointCloudHitResult
 * JD-Core Version:    0.7.0.1
 */