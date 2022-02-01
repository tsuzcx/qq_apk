package com.tencent.aelight.camera.ae.view;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AECMShowFaceScanView$6
  extends D8SafeAnimatorListener
{
  AECMShowFaceScanView$6(AECMShowFaceScanView paramAECMShowFaceScanView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AECMShowFaceScanView.b(this.a, false);
    if (this.a.a != null) {
      this.a.a.y();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AECMShowFaceScanView.b(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AECMShowFaceScanView.6
 * JD-Core Version:    0.7.0.1
 */