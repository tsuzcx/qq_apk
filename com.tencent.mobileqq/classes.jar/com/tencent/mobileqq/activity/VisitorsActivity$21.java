package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;

class VisitorsActivity$21
  implements Runnable
{
  VisitorsActivity$21(VisitorsActivity paramVisitorsActivity, ScaleAnimation paramScaleAnimation, AlphaAnimation paramAlphaAnimation1, AlphaAnimation paramAlphaAnimation2, AnimationSet paramAnimationSet) {}
  
  public void run()
  {
    this.jdField_a_of_type_AndroidViewAnimationScaleAnimation.reset();
    this.jdField_a_of_type_AndroidViewAnimationAlphaAnimation.reset();
    this.b.reset();
    this.jdField_a_of_type_AndroidViewAnimationAnimationSet.reset();
    this.this$0.f.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimationSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.21
 * JD-Core Version:    0.7.0.1
 */