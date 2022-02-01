package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class AEFlashCameraCaptureButtonLayout$6
  implements ValueAnimator.AnimatorUpdateListener
{
  AEFlashCameraCaptureButtonLayout$6(AEFlashCameraCaptureButtonLayout paramAEFlashCameraCaptureButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    AEFlashCameraCaptureButtonLayout.e(this.a).setCenterScaleValue(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashCameraCaptureButtonLayout.6
 * JD-Core Version:    0.7.0.1
 */