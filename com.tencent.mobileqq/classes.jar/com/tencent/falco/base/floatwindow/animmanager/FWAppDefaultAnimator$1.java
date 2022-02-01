package com.tencent.falco.base.floatwindow.animmanager;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

class FWAppDefaultAnimator$1
  implements ValueAnimator.AnimatorUpdateListener
{
  FWAppDefaultAnimator$1(FWAppDefaultAnimator paramFWAppDefaultAnimator, WindowManager.LayoutParams paramLayoutParams, WindowManager paramWindowManager, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    try
    {
      this.val$params.x = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      this.val$windowManager.updateViewLayout(this.val$view, this.val$params);
      return;
    }
    catch (Exception paramValueAnimator)
    {
      paramValueAnimator.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.animmanager.FWAppDefaultAnimator.1
 * JD-Core Version:    0.7.0.1
 */