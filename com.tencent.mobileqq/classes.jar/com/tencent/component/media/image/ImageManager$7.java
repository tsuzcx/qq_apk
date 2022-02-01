package com.tencent.component.media.image;

import com.tencent.component.media.image.image.Image;
import com.tencent.component.media.utils.LruCache;

class ImageManager$7
  extends LruCache<Integer, Image>
{
  ImageManager$7(ImageManager paramImageManager, int paramInt)
  {
    super(paramInt);
  }
  
  protected void entryRemoved(boolean paramBoolean, Integer paramInteger, Image paramImage1, Image paramImage2)
  {
    if (paramInteger != null) {
      ImageTaskTracer.addImageLruCacheEvictedRecord(paramInteger.intValue());
    }
  }
  
  protected int sizeOf(Integer paramInteger, Image paramImage)
  {
    return paramImage.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.7
 * JD-Core Version:    0.7.0.1
 */