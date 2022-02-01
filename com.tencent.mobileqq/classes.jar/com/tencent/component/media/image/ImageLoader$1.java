package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;

class ImageLoader$1
  implements Runnable
{
  ImageLoader$1(ImageLoader paramImageLoader, ImageUrl paramImageUrl, ImageLoader.ImageLoadListener paramImageLoadListener, Drawable paramDrawable, ImageLoader.Options paramOptions, String paramString) {}
  
  public void run()
  {
    ImageUrl localImageUrl = this.val$imageUrl;
    if (localImageUrl != null)
    {
      this.val$listener.onImageLoaded(localImageUrl.url, this.val$drawable, this.val$options);
      return;
    }
    this.val$listener.onImageLoaded(this.val$url, this.val$drawable, this.val$options);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.ImageLoader.1
 * JD-Core Version:    0.7.0.1
 */