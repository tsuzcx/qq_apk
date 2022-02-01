package com.tencent.av.ui;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;

class AVActivity$8
  implements URLDrawable.URLDrawableListener
{
  AVActivity$8(AVActivity paramAVActivity) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    AVActivity.a(this.a, false);
    QLog.i(this.a.i, 1, "MoreBtnTips. onLoadCanceled().");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    AVActivity.a(this.a, false);
    QLog.i(this.a.i, 1, "MoreBtnTips. onLoadFialed().");
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    paramURLDrawable = this.a.i;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MoreBtnTips. onLoadProgressed(). i = ");
    localStringBuilder.append(paramInt);
    QLog.i(paramURLDrawable, 1, localStringBuilder.toString());
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    AVActivity.a(this.a, true);
    QLog.i(this.a.i, 1, "MoreBtnTips. onLoadSuccessed().");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.8
 * JD-Core Version:    0.7.0.1
 */