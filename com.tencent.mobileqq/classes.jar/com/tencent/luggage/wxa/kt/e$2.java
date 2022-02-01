package com.tencent.luggage.wxa.kt;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class e$2
  implements ValueAnimator.AnimatorUpdateListener
{
  e$2(e parame, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    this.a.getLayoutParams().width = paramValueAnimator.intValue();
    this.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kt.e.2
 * JD-Core Version:    0.7.0.1
 */