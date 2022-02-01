package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AEARCakePanel$7
  extends D8SafeAnimatorListener
{
  AEARCakePanel$7(AEARCakePanel paramAEARCakePanel, Runnable paramRunnable) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEARCakePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel, false);
    paramAnimator = this.jdField_a_of_type_JavaLangRunnable;
    if (paramAnimator != null) {
      paramAnimator.run();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEARCakePanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel.7
 * JD-Core Version:    0.7.0.1
 */