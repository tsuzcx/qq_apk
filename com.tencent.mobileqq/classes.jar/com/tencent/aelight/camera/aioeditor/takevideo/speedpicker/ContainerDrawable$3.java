package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class ContainerDrawable$3
  extends D8SafeAnimatorListener
{
  ContainerDrawable$3(ContainerDrawable paramContainerDrawable) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (!ContainerDrawable.b(this.a)) {
      return;
    }
    if (!ContainerDrawable.c(this.a))
    {
      ContainerDrawable.a(this.a, false);
      if (ContainerDrawable.d(this.a) == 2) {
        ContainerDrawable.b(this.a, 0);
      }
    }
    else
    {
      ContainerDrawable.a(this.a, false);
      ContainerDrawable.b(this.a, 0);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (!ContainerDrawable.b(this.a)) {
      return;
    }
    if (!ContainerDrawable.c(this.a))
    {
      ContainerDrawable.a(this.a, false);
      if (ContainerDrawable.d(this.a) == 1)
      {
        ContainerDrawable.b(this.a, 3);
        return;
      }
      ContainerDrawable.b(this.a, 0);
      return;
    }
    if (ContainerDrawable.d(this.a) == 1)
    {
      ContainerDrawable.b(this.a, 2);
      paramAnimator = this.a;
      ContainerDrawable.a(paramAnimator, ContainerDrawable.d(paramAnimator), 1000);
      return;
    }
    ContainerDrawable.a(this.a, false);
    ContainerDrawable.b(this.a, 0);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.ContainerDrawable.3
 * JD-Core Version:    0.7.0.1
 */