package com.tencent.biz.qqstory.playvideo.playerwidget;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

final class BannerVideoInfoWidget3$1
  implements URLDrawable.URLDrawableListener
{
  BannerVideoInfoWidget3$1(ImageView paramImageView, Drawable paramDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    paramURLDrawable = new StringBuilder();
    paramURLDrawable.append("failed to parse the url drawable, error ");
    paramURLDrawable.append(paramThrowable);
    SLog.d("BannerVideoInfoWidget", paramURLDrawable.toString());
    this.a.setImageDrawable(this.b);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.setImageDrawable(paramURLDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.playerwidget.BannerVideoInfoWidget3.1
 * JD-Core Version:    0.7.0.1
 */