package com.tencent.biz.qqcircle.widgets.dialog;

import android.os.Handler;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;

class QCircleLoadingDialog$1
  implements AnimationDrawableFactory.CreateResultListener
{
  QCircleLoadingDialog$1(QCircleLoadingDialog paramQCircleLoadingDialog) {}
  
  public void a(boolean paramBoolean, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if ((paramBoolean) && (paramQQAnimationDrawable != null))
    {
      QCircleLoadingDialog.a(this.a, paramQQAnimationDrawable);
      RFThreadManager.getUIHandler().post(new QCircleLoadingDialog.1.1(this));
      return;
    }
    RFThreadManager.getUIHandler().post(new QCircleLoadingDialog.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.dialog.QCircleLoadingDialog.1
 * JD-Core Version:    0.7.0.1
 */