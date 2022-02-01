package com.tencent.mobileqq.activity.richmedia;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class FlowCameraActivity2$19
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    this.a.c.setBackgroundColor(paramValueAnimator.intValue());
    this.a.b.setBackgroundColor(paramValueAnimator.intValue());
    this.a.a.setBackgroundColor(paramValueAnimator.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.19
 * JD-Core Version:    0.7.0.1
 */