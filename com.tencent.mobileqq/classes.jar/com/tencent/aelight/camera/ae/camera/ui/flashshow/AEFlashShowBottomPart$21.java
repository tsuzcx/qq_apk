package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AEFlashShowBottomPart$21
  extends D8SafeAnimatorListener
{
  AEFlashShowBottomPart$21(AEFlashShowBottomPart paramAEFlashShowBottomPart, Runnable paramRunnable) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEFlashShowBottomPart.a(this.b, false);
    paramAnimator = this.a;
    if (paramAnimator != null) {
      paramAnimator.run();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEFlashShowBottomPart.a(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowBottomPart.21
 * JD-Core Version:    0.7.0.1
 */