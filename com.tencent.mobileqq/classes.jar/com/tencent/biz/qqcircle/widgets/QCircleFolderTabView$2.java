package com.tencent.biz.qqcircle.widgets;

import android.os.Handler;
import com.tencent.biz.richframework.animation.drawable.AnimationDrawableFactory.CreateResultListener;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;

class QCircleFolderTabView$2
  implements AnimationDrawableFactory.CreateResultListener
{
  QCircleFolderTabView$2(QCircleFolderTabView paramQCircleFolderTabView) {}
  
  public void a(boolean paramBoolean, QQAnimationDrawable paramQQAnimationDrawable)
  {
    if (QCircleFolderTabView.a(this.a))
    {
      QLog.e("QCircleFolderTabView", 1, "fetchAnimDrawable Anim action canceled,direct return!");
      return;
    }
    if ((paramBoolean) && (paramQQAnimationDrawable != null))
    {
      QCircleFolderTabView.a(this.a, paramQQAnimationDrawable);
      RFThreadManager.getUIHandler().post(new QCircleFolderTabView.2.1(this));
      return;
    }
    RFThreadManager.getUIHandler().post(new QCircleFolderTabView.2.2(this));
    QLog.e("QCircleFolderTabView", 1, "fetchAnimDrawable fail !use default image");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFolderTabView.2
 * JD-Core Version:    0.7.0.1
 */