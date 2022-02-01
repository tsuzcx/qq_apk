package com.tencent.biz.qqcircle.widgets;

import android.os.Handler;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;

class QCirclePanelLoadingView$1
  implements AnimationDrawableFactory.CreateResultListener
{
  QCirclePanelLoadingView$1(QCirclePanelLoadingView paramQCirclePanelLoadingView) {}
  
  public void a(boolean paramBoolean, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if ((paramBoolean) && (paramQQAnimationDrawable != null))
    {
      paramQQAnimationDrawable.b(false);
      QCirclePanelLoadingView.a(this.a, paramQQAnimationDrawable);
      this.a.getMainHandler().post(new QCirclePanelLoadingView.1.1(this));
      return;
    }
    this.a.getMainHandler().post(new QCirclePanelLoadingView.1.2(this));
    QLog.e("QCirclePanelLoadingView", 1, "fetchAnimDrawable fail! use static logo");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePanelLoadingView.1
 * JD-Core Version:    0.7.0.1
 */