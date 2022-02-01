package com.tencent.biz.qqcircle.widgets;

import android.os.Handler;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.QQAnimationListener;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;

class QCircleRocketView$1
  implements QQAnimationDrawable.QQAnimationListener
{
  QCircleRocketView$1(QCircleRocketView paramQCircleRocketView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (paramInt == this.a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPlay");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" showRecommendCountAnimation");
      QLog.i("QCircleRocketView", 1, localStringBuilder.toString());
      RFThreadManager.getUIHandler().post(new QCircleRocketView.1.1(this));
    }
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRocketView.1
 * JD-Core Version:    0.7.0.1
 */