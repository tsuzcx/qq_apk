package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.kandian.biz.common.widget.NativeReadInjoyImageView;
import com.tencent.qphone.base.util.QLog;

class ReadInjoyDoubleImageView$1
  implements URLDrawable.URLDrawableListener
{
  ReadInjoyDoubleImageView$1(ReadInjoyDoubleImageView paramReadInjoyDoubleImageView, String paramString) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadCanceled:");
      paramURLDrawable.append(this.a);
      QLog.d("ReadInjoyDoubleImageView", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("onLoadFialed:");
      paramURLDrawable.append(this.a);
      QLog.d("ReadInjoyDoubleImageView", 2, paramURLDrawable.toString());
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInjoyDoubleImageView", 2, "onLoadProgressed");
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLoadSuccessed:");
      localStringBuilder.append(this.a);
      QLog.d("ReadInjoyDoubleImageView", 2, localStringBuilder.toString());
    }
    if (paramURLDrawable != null)
    {
      ReadInjoyDoubleImageView.a(this.b, new ReadInjoyAdSuperBgDrawable(paramURLDrawable.getCurrDrawable(), ReadInjoyDoubleImageView.a(this.b), ReadInjoyDoubleImageView.b(this.b) - (ReadInjoyDoubleImageView.c(this.b) + ReadInjoyDoubleImageView.d(this.b))));
      ReadInjoyDoubleImageView.f(this.b).setImageDrawable(ReadInjoyDoubleImageView.e(this.b));
      ReadInjoyDoubleImageView.a(this.b, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyDoubleImageView.1
 * JD-Core Version:    0.7.0.1
 */