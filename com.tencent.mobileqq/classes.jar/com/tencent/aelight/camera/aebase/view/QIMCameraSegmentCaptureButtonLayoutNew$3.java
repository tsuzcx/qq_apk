package com.tencent.aelight.camera.aebase.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class QIMCameraSegmentCaptureButtonLayoutNew$3
  extends AnimatorListenerAdapter
{
  QIMCameraSegmentCaptureButtonLayoutNew$3(QIMCameraSegmentCaptureButtonLayoutNew paramQIMCameraSegmentCaptureButtonLayoutNew, boolean paramBoolean, float paramFloat) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.a.forceNextSegmentAnimatorStart();
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraAebaseViewQIMCameraSegmentCaptureButtonLayoutNew.a.startBlinkAnimation(this.jdField_a_of_type_Float);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.QIMCameraSegmentCaptureButtonLayoutNew.3
 * JD-Core Version:    0.7.0.1
 */