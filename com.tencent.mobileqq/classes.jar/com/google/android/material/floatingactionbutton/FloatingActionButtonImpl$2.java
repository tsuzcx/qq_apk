package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class FloatingActionButtonImpl$2
  extends AnimatorListenerAdapter
{
  FloatingActionButtonImpl$2(FloatingActionButtonImpl paramFloatingActionButtonImpl, boolean paramBoolean, FloatingActionButtonImpl.InternalVisibilityChangedListener paramInternalVisibilityChangedListener) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FloatingActionButtonImpl.a(this.c, 0);
    FloatingActionButtonImpl.a(this.c, null);
    paramAnimator = this.b;
    if (paramAnimator != null) {
      paramAnimator.a();
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.c.s.a(0, this.a);
    FloatingActionButtonImpl.a(this.c, 2);
    FloatingActionButtonImpl.a(this.c, paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.2
 * JD-Core Version:    0.7.0.1
 */