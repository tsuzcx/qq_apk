package com.tencent.component.media.photogif;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.image.Image;

public class PhotoGifImage
  extends Image
{
  private Drawable a;
  
  public PhotoGifImage(ImageKey paramImageKey)
  {
    if ((ImageManagerEnv.g().isPreferNewAnimationImp()) && (NewAnimationDrawable.isSuitable(paramImageKey.options.photoList, paramImageKey.options.clipWidth, paramImageKey.options.clipHeight)))
    {
      this.a = new NewAnimationDrawable(paramImageKey.options);
      ((NewAnimationDrawable)this.a).setDefaultFrame(ImageManagerEnv.g().getPhotoGifDefaultDrawable());
      return;
    }
    this.a = new PhotoGifDrawable(paramImageKey);
  }
  
  public Drawable getDrawable()
  {
    return this.a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.photogif.PhotoGifImage
 * JD-Core Version:    0.7.0.1
 */