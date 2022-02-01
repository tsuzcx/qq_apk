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
    AECMShowFaceScanView.a(this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView, false);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(255);
    this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView.d.setAlpha(255);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    AECMShowFaceScanView.a(this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView, true);
    if (this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView$ScanViewListener != null) {
      this.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView.jdField_a_of_type_ComTencentAelightCameraAeViewAECMShowFaceScanView$ScanViewListener.z();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AECMShowFaceScanView.4
 * JD-Core Version:    0.7.0.1
 */