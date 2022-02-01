package com.tencent.aelight.camera.aebase.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QIMCameraSegmentCaptureButtonLayoutNew$5
  implements ValueAnimator.AnimatorUpdateListener
{
  QIMCameraSegmentCaptureButtonLayoutNew$5(QIMCameraSegmentCaptureButtonLayoutNew paramQIMCameraSegmentCaptureButtonLayoutNew) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.c = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.a;
    paramValueAnimator.a(paramValueAnimator.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.QIMCameraSegmentCaptureButtonLayoutNew.5
 * JD-Core Version:    0.7.0.1
 */