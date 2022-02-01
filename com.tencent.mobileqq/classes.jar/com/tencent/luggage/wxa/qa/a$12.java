package com.tencent.luggage.wxa.qa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class a$12
  extends AnimatorListenerAdapter
{
  a$12(a parama, Runnable paramRunnable) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    if (paramAnimator != null) {
      this.b.post(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qa.a.12
 * JD-Core Version:    0.7.0.1
 */