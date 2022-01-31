package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.annotation.Public;

public abstract interface ImageLoader$ImageLoadListener
{
  @Public
  public abstract void onImageCanceled(String paramString, ImageLoader.Options paramOptions);
  
  @Public
  public abstract void onImageFailed(String paramString, ImageLoader.Options paramOptions);
  
  @Public
  public abstract void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions);
  
  @Public
  public abstract void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.ImageLoader.ImageLoadListener
 * JD-Core Version:    0.7.0.1
 */