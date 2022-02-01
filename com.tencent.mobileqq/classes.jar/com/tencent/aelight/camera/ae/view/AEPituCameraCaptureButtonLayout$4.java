package com.tencent.aelight.camera.ae.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.aelight.camera.aebase.view.AnimationQIMCircleProgress;

class AEPituCameraCaptureButtonLayout$4
  implements ValueAnimator.AnimatorUpdateListener
{
  AEPituCameraCaptureButtonLayout$4(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (!AEPituCameraCaptureButtonLayout.a(this.a))
    {
      this.a.jdField_a_of_type_ComTencentAelightCameraAebaseViewAnimationQIMCircleProgress.setCenterScaleValue(f);
      return;
    }
    this.a.jdField_a_of_type_ComTencentAelightCameraAeViewAECircleCaptureProgressView.setCenterScaleValue(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout.4
 * JD-Core Version:    0.7.0.1
 */