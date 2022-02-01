package com.tencent.aelight.camera.aebase.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QIMCameraSegmentCaptureButtonLayoutNew$4
  implements ValueAnimator.AnimatorUpdateListener
{
  QIMCameraSegmentCaptureButtonLayoutNew$4(QIMCameraSegmentCaptureButtonLayoutNew paramQIMCameraSegmentCaptureButtonLayoutNew) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.h.setCenterScaleValue(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.view.QIMCameraSegmentCaptureButtonLayoutNew.4
 * JD-Core Version:    0.7.0.1
 */