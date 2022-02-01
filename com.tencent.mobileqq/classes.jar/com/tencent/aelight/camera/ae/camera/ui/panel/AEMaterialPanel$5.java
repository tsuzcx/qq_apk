package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.aelight.camera.log.AEQLog;

class AEMaterialPanel$5
  implements Animation.AnimationListener
{
  AEMaterialPanel$5(AEMaterialPanel paramAEMaterialPanel, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AEMaterialPanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel, false);
    if (AEMaterialPanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel) != null) {
      AEMaterialPanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel).b();
    }
    paramAnimation = this.jdField_a_of_type_JavaLangRunnable;
    if (paramAnimation != null) {
      paramAnimation.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    AEMaterialPanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel, true);
    if (AEMaterialPanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel) != null)
    {
      AEMaterialPanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel).setAlpha(1.0F);
      AEMaterialPanel.a(this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEMaterialPanel).setVisibility(0);
      return;
    }
    AEQLog.d("AEMaterialPanel", "[openWithAnimation] alpha - onAnimationStart, mContentView == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEMaterialPanel.5
 * JD-Core Version:    0.7.0.1
 */