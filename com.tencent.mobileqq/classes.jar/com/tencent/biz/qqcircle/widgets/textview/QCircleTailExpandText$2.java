package com.tencent.biz.qqcircle.widgets.textview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QCircleTailExpandText$2
  implements ValueAnimator.AnimatorUpdateListener
{
  QCircleTailExpandText$2(QCircleTailExpandText paramQCircleTailExpandText) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.setHeight(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.textview.QCircleTailExpandText.2
 * JD-Core Version:    0.7.0.1
 */