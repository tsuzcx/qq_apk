package com.tencent.aelight.camera.ae.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.aelight.camera.aebase.view.AnimationQIMCircleProgress;

class AEPituCameraCaptureButtonLayout$5
  implements ValueAnimator.AnimatorUpdateListener
{
  AEPituCameraCaptureButtonLayout$5(AEPituCameraCaptureButtonLayout paramAEPituCameraCaptureButtonLayout) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    if (!AEPituCameraCaptureButtonLayout.a(this.a))
    {
      this.a.B.setCenterScaleValue(f);
      return;
    }
    this.a.D.setCenterScaleValue(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AEPituCameraCaptureButtonLayout.5
 * JD-Core Version:    0.7.0.1
 */