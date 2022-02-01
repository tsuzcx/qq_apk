package com.tencent.biz.videostory.animator;

import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

class ViewAnimator$3
  implements ViewTreeObserver.OnPreDrawListener
{
  ViewAnimator$3(ViewAnimator paramViewAnimator) {}
  
  public boolean onPreDraw()
  {
    ViewAnimator.a(this.a).start();
    ViewAnimator.a(this.a).getViewTreeObserver().removeOnPreDrawListener(this);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.videostory.animator.ViewAnimator.3
 * JD-Core Version:    0.7.0.1
 */