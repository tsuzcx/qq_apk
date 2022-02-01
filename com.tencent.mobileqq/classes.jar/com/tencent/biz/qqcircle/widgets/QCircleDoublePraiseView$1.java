package com.tencent.biz.qqcircle.widgets;

import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;

class QCircleDoublePraiseView$1
  implements Animation.AnimationListener
{
  QCircleDoublePraiseView$1(QCircleDoublePraiseView paramQCircleDoublePraiseView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QCircleDoublePraiseView.a(this.a).setVisibility(8);
    QCircleDoublePraiseView.a(this.a, false);
    RFThreadManager.getUIHandler().post(new QCircleDoublePraiseView.1.1(this));
    QLog.d("QCircleDoublePraiseView", 1, "onAnimationEnd");
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QCircleDoublePraiseView.a(this.a, true);
    QLog.d("QCircleDoublePraiseView", 1, "onAnimationStart");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDoublePraiseView.1
 * JD-Core Version:    0.7.0.1
 */