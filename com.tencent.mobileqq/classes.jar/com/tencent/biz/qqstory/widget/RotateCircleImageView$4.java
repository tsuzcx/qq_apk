package com.tencent.biz.qqstory.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class RotateCircleImageView$4
  extends D8SafeAnimatorListener
{
  RotateCircleImageView$4(RotateCircleImageView paramRotateCircleImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    RotateCircleImageView.a(this.a).start();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.RotateCircleImageView.4
 * JD-Core Version:    0.7.0.1
 */