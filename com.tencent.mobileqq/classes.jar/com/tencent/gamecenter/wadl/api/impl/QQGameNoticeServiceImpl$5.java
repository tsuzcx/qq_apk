package com.tencent.gamecenter.wadl.api.impl;

import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class QQGameNoticeServiceImpl$5
  implements URLDrawable.URLDrawableListener
{
  QQGameNoticeServiceImpl$5(QQGameNoticeServiceImpl paramQQGameNoticeServiceImpl, TipsBar paramTipsBar) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadSuccessed urlDrawable=");
    localStringBuilder.append(paramURLDrawable);
    QLog.d("Wadl_QQGameNoticeServiceImpl", 1, localStringBuilder.toString());
    QQGameNoticeServiceImpl.access$200(this.b).post(new QQGameNoticeServiceImpl.5.1(this, paramURLDrawable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.api.impl.QQGameNoticeServiceImpl.5
 * JD-Core Version:    0.7.0.1
 */