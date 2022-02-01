package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class PickerContainer$2
  implements ValueAnimator.AnimatorUpdateListener
{
  PickerContainer$2(PickerContainer paramPickerContainer) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = this.a;
    paramValueAnimator.setAlpha(PickerContainer.b(paramValueAnimator).floatValue());
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerContainer.2
 * JD-Core Version:    0.7.0.1
 */