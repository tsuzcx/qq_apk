package com.tencent.luggage.scanner.scanner.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;

class BaseScanUI$2
  implements Animator.AnimatorListener
{
  BaseScanUI$2(BaseScanUI paramBaseScanUI, Animator.AnimatorListener paramAnimatorListener, View paramView, boolean paramBoolean) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    Animator.AnimatorListener localAnimatorListener = this.a;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationCancel(paramAnimator);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    Object localObject = this.b;
    int i;
    if (this.c) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
    localObject = this.a;
    if (localObject != null) {
      ((Animator.AnimatorListener)localObject).onAnimationEnd(paramAnimator);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    Animator.AnimatorListener localAnimatorListener = this.a;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationRepeat(paramAnimator);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    Animator.AnimatorListener localAnimatorListener = this.a;
    if (localAnimatorListener != null) {
      localAnimatorListener.onAnimationStart(paramAnimator);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.BaseScanUI.2
 * JD-Core Version:    0.7.0.1
 */