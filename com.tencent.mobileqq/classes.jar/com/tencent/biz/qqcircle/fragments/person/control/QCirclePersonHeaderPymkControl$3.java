package com.tencent.biz.qqcircle.fragments.person.control;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QCirclePersonHeaderPymkControl$3
  implements ValueAnimator.AnimatorUpdateListener
{
  QCirclePersonHeaderPymkControl$3(QCirclePersonHeaderPymkControl paramQCirclePersonHeaderPymkControl) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = Float.parseFloat(paramValueAnimator.getAnimatedValue().toString());
    QCirclePersonHeaderPymkControl.a(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.control.QCirclePersonHeaderPymkControl.3
 * JD-Core Version:    0.7.0.1
 */