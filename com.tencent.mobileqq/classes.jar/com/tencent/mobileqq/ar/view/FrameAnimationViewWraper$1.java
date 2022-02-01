package com.tencent.mobileqq.ar.view;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class FrameAnimationViewWraper$1
  extends D8SafeAnimatorListener
{
  FrameAnimationViewWraper$1(FrameAnimationViewWraper paramFrameAnimationViewWraper) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (FrameAnimationViewWraper.a(this.a) != null) {
      FrameAnimationViewWraper.a(this.a).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.view.FrameAnimationViewWraper.1
 * JD-Core Version:    0.7.0.1
 */