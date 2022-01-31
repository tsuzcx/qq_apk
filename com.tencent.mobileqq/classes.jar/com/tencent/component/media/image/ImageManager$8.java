package com.tencent.component.media.image;

import com.tencent.component.media.ImageManagerEnv;

class ImageManager$8
  implements Runnable
{
  ImageManager$8(ImageManager paramImageManager) {}
  
  public void run()
  {
    ImageManagerEnv.g().tryInitSuperResolutionLibrary();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.8
 * JD-Core Version:    0.7.0.1
 */