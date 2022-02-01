package com.tencent.biz.qqstory.storyHome;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

final class QQStoryMainController$1
  implements URLDrawable.URLDrawableListener
{
  QQStoryMainController$1(ImageView paramImageView, Drawable paramDrawable) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    this.a.setImageDrawable(this.b);
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("iconDrawable onLoadFialed, exception: ");
      paramURLDrawable.append(QLog.getStackTraceString(paramThrowable));
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainController.1
 * JD-Core Version:    0.7.0.1
 */