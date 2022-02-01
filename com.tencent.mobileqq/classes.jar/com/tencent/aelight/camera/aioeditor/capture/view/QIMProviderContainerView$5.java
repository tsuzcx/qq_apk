package com.tencent.aelight.camera.aioeditor.capture.view;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.aelight.camera.aioeditor.capture.AbsQIMCaptureController;

class QIMProviderContainerView$5
  implements Animation.AnimationListener
{
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QIMProviderContainerView.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMProviderContainerView) != null)
    {
      QIMProviderContainerView.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMProviderContainerView).setAlpha(1.0F);
      QIMProviderContainerView.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMProviderContainerView).setVisibility(8);
    }
    if ((!this.jdField_a_of_type_Boolean) && (QIMProviderContainerView.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMProviderContainerView) != null)) {
      QIMProviderContainerView.a(this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMProviderContainerView).a(false, 150);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMProviderContainerView.5
 * JD-Core Version:    0.7.0.1
 */