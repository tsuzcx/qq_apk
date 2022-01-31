package com.tencent.component.media.image;

class ImageManager$4
  implements PoolParams
{
  ImageManager$4(ImageManager paramImageManager) {}
  
  public PoolParams.BucketParams getBucketParams(int paramInt)
  {
    return ImageDefaultConfig.getArtBitmapBucketParams(ImageManager.access$100(this.this$0), paramInt);
  }
  
  public int getBucketPoolSize()
  {
    return ImageDefaultConfig.getArtBitmapPoolSize(ImageManager.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.4
 * JD-Core Version:    0.7.0.1
 */