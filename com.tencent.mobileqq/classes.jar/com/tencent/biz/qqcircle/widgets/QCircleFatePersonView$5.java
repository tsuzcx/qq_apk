package com.tencent.biz.qqcircle.widgets;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class QCircleFatePersonView$5
  implements ValueAnimator.AnimatorUpdateListener
{
  QCircleFatePersonView$5(QCircleFatePersonView paramQCircleFatePersonView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if ((((Float)paramValueAnimator.getAnimatedValue()).floatValue() <= -90.0F) && (!QCircleFatePersonView.e(this.a).isStarted()))
    {
      QCircleFatePersonView.f(this.a).setRotationY(89.0F);
      QCircleFatePersonView.e(this.a).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFatePersonView.5
 * JD-Core Version:    0.7.0.1
 */