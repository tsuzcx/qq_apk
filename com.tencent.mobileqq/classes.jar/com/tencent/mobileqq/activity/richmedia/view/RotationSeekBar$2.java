package com.tencent.mobileqq.activity.richmedia.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class RotationSeekBar$2
  implements ValueAnimator.AnimatorUpdateListener
{
  RotationSeekBar$2(RotationSeekBar paramRotationSeekBar) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    RotationSeekBar.b(this.a, ((Integer)paramValueAnimator.getAnimatedValue()).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.RotationSeekBar.2
 * JD-Core Version:    0.7.0.1
 */