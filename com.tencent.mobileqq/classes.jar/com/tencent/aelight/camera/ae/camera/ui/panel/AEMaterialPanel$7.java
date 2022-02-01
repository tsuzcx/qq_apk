package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class AEMaterialPanel$7
  extends D8SafeAnimatorListener
{
  AEMaterialPanel$7(AEMaterialPanel paramAEMaterialPanel, Runnable paramRunnable) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    AEMaterialPanel.b(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel, false);
    if (AEMaterialPanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel) != null) {
      AEMaterialPanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel).c();
    }
    paramAnimator = this.jdField_a_of_type_JavaLangRunnable;
    if (paramAnimator != null) {
      paramAnimator.run();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AEMaterialPanel.b(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.7
 * JD-Core Version:    0.7.0.1
 */