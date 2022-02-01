package com.tencent.luggage.scanner.scanner.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class BaseScanUI$15
  extends AnimatorListenerAdapter
{
  BaseScanUI$15(BaseScanUI paramBaseScanUI) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    BaseScanUI.a(this.a, System.currentTimeMillis());
    BaseScanUI.l(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.BaseScanUI.15
 * JD-Core Version:    0.7.0.1
 */