package com.tencent.aelight.camera.ae.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class AECMShowFaceScanView$5
  implements ValueAnimator.AnimatorUpdateListener
{
  AECMShowFaceScanView$5(AECMShowFaceScanView paramAECMShowFaceScanView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    AECMShowFaceScanView.c(this.a, ((Float)paramValueAnimator.getAnimatedValue()).floatValue());
    this.a.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AECMShowFaceScanView.5
 * JD-Core Version:    0.7.0.1
 */