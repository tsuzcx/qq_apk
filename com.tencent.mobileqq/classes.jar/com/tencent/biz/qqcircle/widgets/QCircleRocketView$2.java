package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.qphone.base.util.QLog;

class QCircleRocketView$2
  implements Runnable
{
  QCircleRocketView$2(QCircleRocketView paramQCircleRocketView, FrameAnimationView paramFrameAnimationView, QQAnimationDrawable paramQQAnimationDrawable, int paramInt) {}
  
  public void run()
  {
    QLog.d("QQAnimationDrawable", 1, "postDelay end");
    QLog.d("QQAnimationDrawable", 1, "hide");
    this.a.setVisibility(4);
    this.b.e();
    QCircleRocketView.a(this.this$0, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleRocketView.2
 * JD-Core Version:    0.7.0.1
 */