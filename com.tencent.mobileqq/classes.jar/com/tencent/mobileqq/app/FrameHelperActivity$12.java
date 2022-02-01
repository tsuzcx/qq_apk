package com.tencent.mobileqq.app;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

class FrameHelperActivity$12
  implements Animation.AnimationListener
{
  FrameHelperActivity$12(FrameHelperActivity paramFrameHelperActivity, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = new AnimationSet(true);
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.3F, 1.2F, 1.3F, 1.2F, 1, 0.5F, 1, 0.5F);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.6F, 0.5F);
    paramAnimation.addAnimation(localScaleAnimation);
    paramAnimation.addAnimation(localAlphaAnimation);
    paramAnimation.setDuration(30L);
    paramAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramAnimation);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FrameHelperActivity.12
 * JD-Core Version:    0.7.0.1
 */