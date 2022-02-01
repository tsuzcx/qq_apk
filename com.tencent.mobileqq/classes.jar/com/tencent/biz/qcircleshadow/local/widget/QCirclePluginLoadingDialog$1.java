package com.tencent.biz.qcircleshadow.local.widget;

import android.os.Handler;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;

class QCirclePluginLoadingDialog$1
  implements AnimationDrawableFactory.CreateResultListener
{
  QCirclePluginLoadingDialog$1(QCirclePluginLoadingDialog paramQCirclePluginLoadingDialog) {}
  
  public void a(boolean paramBoolean, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if ((paramBoolean) && (paramQQAnimationDrawable != null))
    {
      QCirclePluginLoadingDialog.a(this.a, paramQQAnimationDrawable);
      QCirclePluginLoadingDialog.b(this.a).post(new QCirclePluginLoadingDialog.1.1(this));
      return;
    }
    QCirclePluginLoadingDialog.b(this.a).post(new QCirclePluginLoadingDialog.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.local.widget.QCirclePluginLoadingDialog.1
 * JD-Core Version:    0.7.0.1
 */