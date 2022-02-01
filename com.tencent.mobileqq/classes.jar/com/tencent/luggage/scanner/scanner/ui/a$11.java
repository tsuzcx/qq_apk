package com.tencent.luggage.scanner.scanner.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.view.View;
import com.tencent.luggage.wxa.dl.b;

class a$11
  implements Animator.AnimatorListener
{
  a$11(a parama, b paramb) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.b.removeView((View)this.a);
    this.a.g();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.removeView((View)this.a);
    this.a.g();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.a.11
 * JD-Core Version:    0.7.0.1
 */