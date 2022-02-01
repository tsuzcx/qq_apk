package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AEMaterialPanel$5
  extends D8SafeAnimatorListener
{
  AEMaterialPanel$5(AEMaterialPanel paramAEMaterialPanel, Runnable paramRunnable) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEMaterialPanel.b(this.b, false);
    if (AEMaterialPanel.d(this.b) != null) {
      AEMaterialPanel.d(this.b).c();
    }
    paramAnimator = this.a;
    if (paramAnimator != null) {
      paramAnimator.run();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEMaterialPanel.b(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.5
 * JD-Core Version:    0.7.0.1
 */