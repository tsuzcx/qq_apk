package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class HintDrawable$4
  extends D8SafeAnimatorListener
{
  HintDrawable$4(HintDrawable paramHintDrawable) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!HintDrawable.c(this.a)) {
      return;
    }
    if (!HintDrawable.d(this.a))
    {
      HintDrawable.a(this.a, false);
      if (HintDrawable.e(this.a) == 1)
      {
        HintDrawable.b(this.a, 3);
        return;
      }
      HintDrawable.b(this.a, 0);
      HintDrawable.a(this.a, "");
      return;
    }
    if (HintDrawable.e(this.a) == 1)
    {
      HintDrawable.b(this.a, 2);
      paramAnimator = this.a;
      HintDrawable.a(paramAnimator, HintDrawable.e(paramAnimator), 1000);
      return;
    }
    HintDrawable.a(this.a, "");
    HintDrawable.b(this.a, 0);
    HintDrawable.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!HintDrawable.c(this.a)) {
      return;
    }
    if (!HintDrawable.d(this.a))
    {
      HintDrawable.a(this.a, false);
      if (HintDrawable.e(this.a) == 1)
      {
        HintDrawable.b(this.a, 3);
        return;
      }
      HintDrawable.b(this.a, 0);
      HintDrawable.a(this.a, "");
      return;
    }
    if (HintDrawable.e(this.a) == 1)
    {
      HintDrawable.b(this.a, 2);
      paramAnimator = this.a;
      HintDrawable.a(paramAnimator, HintDrawable.e(paramAnimator), 1000);
      return;
    }
    HintDrawable.a(this.a, "");
    HintDrawable.b(this.a, 0);
    HintDrawable.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.HintDrawable.4
 * JD-Core Version:    0.7.0.1
 */