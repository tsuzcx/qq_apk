package com.tencent.biz.qqstory.utils;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class TranslucentTitleBarHelper$1
  implements ValueAnimator.AnimatorUpdateListener
{
  TranslucentTitleBarHelper$1(TranslucentTitleBarHelper paramTranslucentTitleBarHelper) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    TranslucentTitleBarHelper.a(this.a, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.TranslucentTitleBarHelper.1
 * JD-Core Version:    0.7.0.1
 */