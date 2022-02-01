package com.tencent.biz.richframework.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class QCircleRippleAnimView$1
  extends AnimatorListenerAdapter
{
  QCircleRippleAnimView$1(QCircleRippleAnimView paramQCircleRippleAnimView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QCircleRippleAnimView.a(this.a) != null) {
      QCircleRippleAnimView.a(this.a).a();
    }
    QCircleRippleAnimView.a(this.a, false);
    QCircleRippleAnimView.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.widget.QCircleRippleAnimView.1
 * JD-Core Version:    0.7.0.1
 */