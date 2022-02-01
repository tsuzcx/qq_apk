package com.tencent.mobileqq.ar.ARRecord;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class ARVideoRecordButtonView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  ARVideoRecordButtonView$3(ARVideoRecordButtonView paramARVideoRecordButtonView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Float)paramValueAnimator.getAnimatedValue();
    ARVideoRecordButtonView.b(this.a, paramValueAnimator.floatValue());
    ARVideoRecordButtonView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.ARVideoRecordButtonView.3
 * JD-Core Version:    0.7.0.1
 */