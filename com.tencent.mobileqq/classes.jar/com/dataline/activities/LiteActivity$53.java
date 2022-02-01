package com.dataline.activities;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.widget.XEditTextEx;

class LiteActivity$53
  implements ValueAnimator.AnimatorUpdateListener
{
  LiteActivity$53(LiteActivity paramLiteActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.q.getLayoutParams().height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.q.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.53
 * JD-Core Version:    0.7.0.1
 */