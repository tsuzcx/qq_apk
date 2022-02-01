package com.tencent.mobileqq.ar.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class QRScanEntryView$12
  extends AnimatorListenerAdapter
{
  QRScanEntryView$12(QRScanEntryView paramQRScanEntryView, View paramView, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    if (paramAnimator != null)
    {
      paramAnimator.setAlpha(1.0F);
      if (!this.b) {
        this.a.setVisibility(4);
      }
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = this.a;
    if ((paramAnimator != null) && (this.b)) {
      paramAnimator.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.QRScanEntryView.12
 * JD-Core Version:    0.7.0.1
 */