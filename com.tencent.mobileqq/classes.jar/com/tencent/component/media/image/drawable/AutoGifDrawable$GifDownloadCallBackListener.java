package com.tencent.component.media.image.drawable;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageLoader.Options;

public abstract interface AutoGifDrawable$GifDownloadCallBackListener
{
  public abstract void onImageCanceled(String paramString, ImageLoader.Options paramOptions);
  
  public abstract void onImageFailed(String paramString, ImageLoader.Options paramOptions);
  
  public abstract void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions);
  
  public abstract void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.AutoGifDrawable.GifDownloadCallBackListener
 * JD-Core Version:    0.7.0.1
 */