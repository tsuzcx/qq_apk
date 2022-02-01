package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AEWaterMarkPanel$3
  extends D8SafeAnimatorListener
{
  AEWaterMarkPanel$3(AEWaterMarkPanel paramAEWaterMarkPanel, Runnable paramRunnable) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEWaterMarkPanel.a(this.b, false);
    paramAnimator = this.a;
    if (paramAnimator != null) {
      paramAnimator.run();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEWaterMarkPanel.a(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEWaterMarkPanel.3
 * JD-Core Version:    0.7.0.1
 */