package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class BaseActivity$6
  implements ValueAnimator.AnimatorUpdateListener
{
  BaseActivity$6(BaseActivity paramBaseActivity) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.a.setActionbarHeight(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.BaseActivity.6
 * JD-Core Version:    0.7.0.1
 */