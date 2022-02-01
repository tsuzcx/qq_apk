package com.tencent.component.media.image;

class ReuseBitmapCacheProxy$1
  implements PoolParams
{
  public PoolParams.BucketParams getBucketParams(int paramInt)
  {
    return new PoolParams.BucketParams(1, 1);
  }
  
  public int getBucketPoolSize()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ReuseBitmapCacheProxy.1
 * JD-Core Version:    0.7.0.1
 */