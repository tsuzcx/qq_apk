package com.tencent.biz.pubaccount.readinjoy.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class SlideActiveAnimController$7
  extends AnimatorListenerAdapter
{
  SlideActiveAnimController$7(SlideActiveAnimController paramSlideActiveAnimController) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    SlideActiveAnimController.a(this.a, false);
    if (QLog.isColorLevel()) {
      QLog.i("SlideActiveAnimController", 1, "hideTitleViewAnim onAnimationCancel");
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    SlideActiveAnimController.a(this.a, false);
    SlideActiveAnimController.a(this.a, SlideActiveAnimController.a());
    SlideActiveAnimController.a(this.a).setVisibility(8);
    if (QLog.isColorLevel()) {
      QLog.i("SlideActiveAnimController", 1, "hideTitleViewAnim onAnimationEnd");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.SlideActiveAnimController.7
 * JD-Core Version:    0.7.0.1
 */