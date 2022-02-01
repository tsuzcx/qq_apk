package com.dataline.util.widget;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class AsyncImageView$1
  implements URLDrawable.URLDrawableListener
{
  AsyncImageView$1(AsyncImageView paramAsyncImageView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.d("AsyncImageView", 1, "canceled ");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.d("AsyncImageView", 1, "urldrawable load failed ");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    this.a.setImageDrawable(null);
    this.a.setImageDrawable(paramURLDrawable);
    QLog.d("AsyncImageView", 1, "successed ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.util.widget.AsyncImageView.1
 * JD-Core Version:    0.7.0.1
 */