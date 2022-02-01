package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.aelight.camera.log.AEQLog;

class AEARCakePanel$4
  implements Animation.AnimationListener
{
  AEARCakePanel$4(AEARCakePanel paramAEARCakePanel, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel.jdField_a_of_type_Boolean = false;
    paramAnimation = this.jdField_a_of_type_JavaLangRunnable;
    if (paramAnimation != null) {
      paramAnimation.run();
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation = this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel;
    paramAnimation.jdField_a_of_type_Boolean = true;
    if (paramAnimation.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeProvidewView != null)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeProvidewView.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakePanel.jdField_a_of_type_ComTencentAelightCameraAeCameraUiPanelAEARCakeProvidewView.setVisibility(0);
      return;
    }
    AEQLog.d("AEARCakePanel", "[openWithAnimation] alpha - onAnimationStart, mContentView == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.AEARCakePanel.4
 * JD-Core Version:    0.7.0.1
 */