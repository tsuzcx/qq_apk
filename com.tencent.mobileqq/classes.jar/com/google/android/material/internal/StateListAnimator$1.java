package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class StateListAnimator$1
  extends AnimatorListenerAdapter
{
  StateListAnimator$1(StateListAnimator paramStateListAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.a.a == paramAnimator) {
      this.a.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.internal.StateListAnimator.1
 * JD-Core Version:    0.7.0.1
 */