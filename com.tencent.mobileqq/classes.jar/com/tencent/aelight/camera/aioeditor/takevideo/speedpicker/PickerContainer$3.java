package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class PickerContainer$3
  extends D8SafeAnimatorListener
{
  PickerContainer$3(PickerContainer paramPickerContainer) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (PickerContainer.c(this.a))
    {
      if (PickerContainer.b(this.a).floatValue() < 0.01F) {
        this.a.setVisibility(4);
      }
      PickerContainer.a(this.a, false);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (PickerContainer.c(this.a))
    {
      if (PickerContainer.b(this.a).floatValue() < 0.01F) {
        this.a.setVisibility(4);
      }
      PickerContainer.a(this.a, false);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerContainer.3
 * JD-Core Version:    0.7.0.1
 */