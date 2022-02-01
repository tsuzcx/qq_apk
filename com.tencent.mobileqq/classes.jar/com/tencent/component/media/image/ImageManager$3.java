package com.tencent.component.media.image;

import com.tencent.component.media.ImageManagerEnv;

class ImageManager$3
  implements PoolParams
{
  ImageManager$3(ImageManager paramImageManager) {}
  
  public PoolParams.BucketParams getBucketParams(int paramInt)
  {
    return new PoolParams.BucketParams(16384, ImageManagerEnv.g().getDecodeThreadNum(ImageManager.access$000()) + 2);
  }
  
  public int getBucketPoolSize()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.3
 * JD-Core Version:    0.7.0.1
 */