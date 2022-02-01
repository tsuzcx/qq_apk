package com.tencent.biz.qqcircle.fragments.person.control;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QCirclePersonHeaderPymkControl$5
  implements ValueAnimator.AnimatorUpdateListener
{
  QCirclePersonHeaderPymkControl$5(QCirclePersonHeaderPymkControl paramQCirclePersonHeaderPymkControl) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = Float.parseFloat(paramValueAnimator.getAnimatedValue().toString());
    QCirclePersonHeaderPymkControl.b(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.control.QCirclePersonHeaderPymkControl.5
 * JD-Core Version:    0.7.0.1
 */