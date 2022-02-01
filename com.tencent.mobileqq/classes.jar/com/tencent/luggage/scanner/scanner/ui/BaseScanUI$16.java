package com.tencent.luggage.scanner.scanner.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;

class BaseScanUI$16
  extends AnimatorListenerAdapter
{
  BaseScanUI$16(BaseScanUI paramBaseScanUI, Animator.AnimatorListener paramAnimatorListener) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    Object localObject = this.b;
    BaseScanUI.a((BaseScanUI)localObject, BaseScanUI.m((BaseScanUI)localObject), true);
    localObject = this.a;
    if (localObject != null) {
      ((Animator.AnimatorListener)localObject).onAnimationEnd(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.BaseScanUI.16
 * JD-Core Version:    0.7.0.1
 */