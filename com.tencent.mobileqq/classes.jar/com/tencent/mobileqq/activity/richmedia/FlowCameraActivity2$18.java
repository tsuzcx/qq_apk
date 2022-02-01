package com.tencent.mobileqq.activity.richmedia;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class FlowCameraActivity2$18
  implements ValueAnimator.AnimatorUpdateListener
{
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    if (FlowCameraActivity2.a(this.a))
    {
      localLayoutParams = this.a.a.getLayoutParams();
      localLayoutParams.height = paramValueAnimator.intValue();
      this.a.a.setLayoutParams(localLayoutParams);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = this.a.b.getLayoutParams();
    localLayoutParams.height = paramValueAnimator.intValue();
    this.a.b.setLayoutParams(localLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.18
 * JD-Core Version:    0.7.0.1
 */