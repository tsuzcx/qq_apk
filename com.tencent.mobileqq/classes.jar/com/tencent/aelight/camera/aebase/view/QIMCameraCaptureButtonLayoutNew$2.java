package com.tencent.aelight.camera.aebase.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QIMCameraCaptureButtonLayoutNew$2
  implements ValueAnimator.AnimatorUpdateListener
{
  QIMCameraCaptureButtonLayoutNew$2(QIMCameraCaptureButtonLayoutNew paramQIMCameraCaptureButtonLayoutNew) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.a(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew.2
 * JD-Core Version:    0.7.0.1
 */