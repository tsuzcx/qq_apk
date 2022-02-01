package com.tencent.av.ui.effect.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QavEffectSlidingTabView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  QavEffectSlidingTabView$2(QavEffectSlidingTabView paramQavEffectSlidingTabView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    QavEffectSlidingTabView.a(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.effect.view.QavEffectSlidingTabView.2
 * JD-Core Version:    0.7.0.1
 */