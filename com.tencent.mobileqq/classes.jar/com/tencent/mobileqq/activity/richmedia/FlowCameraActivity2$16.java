package com.tencent.mobileqq.activity.richmedia;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class FlowCameraActivity2$16
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    ViewGroup.LayoutParams localLayoutParams = this.a.c.getLayoutParams();
    localLayoutParams.height = paramValueAnimator.intValue();
    this.a.c.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.16
 * JD-Core Version:    0.7.0.1
 */