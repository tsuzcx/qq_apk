package com.tencent.aelight.camera.ae.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AECMShowFaceScanView$4
  extends D8SafeAnimatorListener
{
  AECMShowFaceScanView$4(AECMShowFaceScanView paramAECMShowFaceScanView, ValueAnimator paramValueAnimator) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AECMShowFaceScanView.a(this.b, false);
    this.b.e.setAlpha(255);
    this.b.h.setAlpha(255);
    this.a.start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AECMShowFaceScanView.a(this.b, true);
    if (this.b.d != null) {
      this.b.d.U();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AECMShowFaceScanView.4
 * JD-Core Version:    0.7.0.1
 */