package com.tencent.biz.richframework.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QCircleRippleAnimView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  QCircleRippleAnimView$2(QCircleRippleAnimView paramQCircleRippleAnimView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    QCircleRippleAnimView.a(this.a, (int)((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.widget.QCircleRippleAnimView.2
 * JD-Core Version:    0.7.0.1
 */