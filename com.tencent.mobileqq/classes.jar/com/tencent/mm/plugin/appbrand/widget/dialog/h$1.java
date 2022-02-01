package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class h$1
  extends AnimatorListenerAdapter
{
  h$1(h paramh, Runnable paramRunnable) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    h.a(this.b, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.a;
    if (paramAnimator != null) {
      paramAnimator.run();
    }
    h.a(this.b, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.h.1
 * JD-Core Version:    0.7.0.1
 */