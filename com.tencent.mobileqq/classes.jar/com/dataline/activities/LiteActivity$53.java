package com.dataline.activities;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;

class LiteActivity$53
  implements ValueAnimator.AnimatorUpdateListener
{
  LiteActivity$53(LiteActivity paramLiteActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    LiteActivity.a(this.a).getLayoutParams().height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    LiteActivity.a(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.53
 * JD-Core Version:    0.7.0.1
 */