package com.tencent.component.media.image;

class ImageManager$2
  implements PoolParams
{
  ImageManager$2(ImageManager paramImageManager, boolean paramBoolean) {}
  
  public PoolParams.BucketParams getBucketParams(int paramInt)
  {
    if (this.val$islocalPhoto) {
      return new PoolParams.BucketParams(ImageDefaultConfig.BYTE_ARRAY_LOCAL[paramInt][1], ImageDefaultConfig.BYTE_ARRAY_LOCAL[paramInt][0]);
    }
    return new PoolParams.BucketParams(ImageDefaultConfig.BYTE_ARRAY[paramInt][1], ImageDefaultConfig.BYTE_ARRAY[paramInt][0]);
  }
  
  public int getBucketPoolSize()
  {
    if (this.val$islocalPhoto) {
      return ImageDefaultConfig.BYTE_ARRAY_LOCAL.length;
    }
    return ImageDefaultConfig.BYTE_ARRAY.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.2
 * JD-Core Version:    0.7.0.1
 */