package com.tencent.biz.qqcircle.bizparts.danmaku.core;

import android.graphics.drawable.Drawable;
import com.tencent.biz.qqcircle.bizparts.danmaku.entity.AbsDanmaku;
import com.tencent.component.media.image.ImageLoader.ImageLoadListener;
import com.tencent.component.media.image.ImageLoader.Options;

class PhotoDanmakuDrawer$4
  implements ImageLoader.ImageLoadListener
{
  PhotoDanmakuDrawer$4(PhotoDanmakuDrawer paramPhotoDanmakuDrawer, AbsDanmaku paramAbsDanmaku) {}
  
  public void onImageCanceled(String paramString, ImageLoader.Options paramOptions) {}
  
  public void onImageFailed(String paramString, ImageLoader.Options paramOptions) {}
  
  public void onImageLoaded(String paramString, Drawable paramDrawable, ImageLoader.Options paramOptions)
  {
    this.a.f(true);
  }
  
  public void onImageProgress(String paramString, float paramFloat, ImageLoader.Options paramOptions) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuDrawer.4
 * JD-Core Version:    0.7.0.1
 */