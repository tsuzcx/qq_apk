package com.tencent.hippy.qq.view.tkd.listview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;

class HippyTKDRefreshHeader$6
  extends AnimatorListenerAdapter
{
  HippyTKDRefreshHeader$6(HippyTKDRefreshHeader paramHippyTKDRefreshHeader, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    Runnable localRunnable = this.val$endRunnable;
    if (localRunnable != null) {
      localRunnable.run();
    }
    this.this$0.hideAnimator.removeListener(this);
    super.onAnimationEnd(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.view.tkd.listview.HippyTKDRefreshHeader.6
 * JD-Core Version:    0.7.0.1
 */