package com.tencent.aelight.camera.ae.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class AEPituCameraCaptureButtonLayout$3
  implements ValueAnimator.AnimatorUpdateListener
{
  AEPituCameraCaptureButtonLayout$3(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout.3
 * JD-Core Version:    0.7.0.1
 */