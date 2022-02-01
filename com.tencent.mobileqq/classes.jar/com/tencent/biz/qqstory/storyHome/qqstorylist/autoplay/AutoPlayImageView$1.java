package com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay;

import com.tencent.image.QQLiveDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;

class AutoPlayImageView$1
  implements URLDrawable.URLDrawableListener
{
  AutoPlayImageView$1(AutoPlayImageView paramAutoPlayImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (AutoPlayImageView.a(this.a) == 2)
    {
      if ((paramURLDrawable != null) && ((paramURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))) {
        ((QQLiveDrawable)paramURLDrawable.getCurrDrawable()).pause();
      }
    }
    else if ((AutoPlayImageView.a(this.a) == 3) && (paramURLDrawable != null) && ((paramURLDrawable.getCurrDrawable() instanceof QQLiveDrawable))) {
      ((QQLiveDrawable)paramURLDrawable.getCurrDrawable()).recyleAndKeepPostion();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.autoplay.AutoPlayImageView.1
 * JD-Core Version:    0.7.0.1
 */