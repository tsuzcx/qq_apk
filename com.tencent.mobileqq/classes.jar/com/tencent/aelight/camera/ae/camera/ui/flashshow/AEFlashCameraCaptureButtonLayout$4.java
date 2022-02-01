package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class AEFlashCameraCaptureButtonLayout$4
  implements ValueAnimator.AnimatorUpdateListener
{
  AEFlashCameraCaptureButtonLayout$4(AEFlashCameraCaptureButtonLayout paramAEFlashCameraCaptureButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashCameraCaptureButtonLayout.4
 * JD-Core Version:    0.7.0.1
 */