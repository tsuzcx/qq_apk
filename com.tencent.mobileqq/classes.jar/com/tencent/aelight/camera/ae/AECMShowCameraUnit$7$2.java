package com.tencent.aelight.camera.ae;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.Button;

class AECMShowCameraUnit$7$2
  implements ValueAnimator.AnimatorUpdateListener
{
  AECMShowCameraUnit$7$2(AECMShowCameraUnit.7 param7) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    AECMShowCameraUnit.d(this.a.this$0).setAlpha(paramValueAnimator.floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.AECMShowCameraUnit.7.2
 * JD-Core Version:    0.7.0.1
 */