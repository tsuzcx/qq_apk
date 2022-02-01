package com.tencent.biz.pubaccount.readinjoy.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class SlideActiveAnimController$6
  implements ValueAnimator.AnimatorUpdateListener
{
  SlideActiveAnimController$6(SlideActiveAnimController paramSlideActiveAnimController) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    SlideActiveAnimController.a(this.a).setAlpha(paramValueAnimator.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController.6
 * JD-Core Version:    0.7.0.1
 */