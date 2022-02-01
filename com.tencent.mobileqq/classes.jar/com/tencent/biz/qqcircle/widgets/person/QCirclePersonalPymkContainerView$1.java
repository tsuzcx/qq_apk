package com.tencent.biz.qqcircle.widgets.person;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QCirclePersonalPymkContainerView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  QCirclePersonalPymkContainerView$1(QCirclePersonalPymkContainerView paramQCirclePersonalPymkContainerView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue().toString();
    QCirclePersonalPymkContainerView.a(this.a, Float.parseFloat(paramValueAnimator));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.person.QCirclePersonalPymkContainerView.1
 * JD-Core Version:    0.7.0.1
 */