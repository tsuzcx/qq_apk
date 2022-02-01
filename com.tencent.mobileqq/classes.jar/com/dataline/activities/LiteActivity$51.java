package com.dataline.activities;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.widget.XEditTextEx;

class LiteActivity$51
  implements ValueAnimator.AnimatorUpdateListener
{
  LiteActivity$51(LiteActivity paramLiteActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.a.getLayoutParams().height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.a.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.51
 * JD-Core Version:    0.7.0.1
 */