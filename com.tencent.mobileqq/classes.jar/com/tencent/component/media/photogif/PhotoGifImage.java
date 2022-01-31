package com.tencent.component.media.photogif;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.image.Image;

public class PhotoGifImage
  extends Image
{
  private Drawable mDrawable;
  
  public PhotoGifImage(ImageKey paramImageKey)
  {
    if ((ImageManagerEnv.g().isPreferNewAnimationImp()) && (NewAnimationDrawable.isSuitable(paramImageKey.options.photoList, paramImageKey.options.clipWidth, paramImageKey.options.clipHeight)))
    {
      this.mDrawable = new NewAnimationDrawable(paramImageKey.options);
      ((NewAnimationDrawable)this.mDrawable).setDefaultFrame(ImageManagerEnv.g().getPhotoGifDefaultDrawable());
      return;
    }
    this.mDrawable = new PhotoGifDrawable(paramImageKey);
  }
  
  public Drawable getDrawable()
  {
    return this.mDrawable;
  }
  
  public boolean isRecycled()
  {
    return false;
  }
  
  public void recycle() {}
  
  public int size()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.photogif.PhotoGifImage
 * JD-Core Version:    0.7.0.1
 */