package com.tencent.aelight.camera.aebase.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QIMCameraCaptureButtonLayoutNew$4
  implements ValueAnimator.AnimatorUpdateListener
{
  QIMCameraCaptureButtonLayoutNew$4(QIMCameraCaptureButtonLayoutNew paramQIMCameraCaptureButtonLayoutNew) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.h.setCenterScaleValue(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.QIMCameraCaptureButtonLayoutNew.4
 * JD-Core Version:    0.7.0.1
 */