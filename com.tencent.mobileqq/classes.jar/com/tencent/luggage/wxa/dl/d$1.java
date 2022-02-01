package com.tencent.luggage.wxa.dl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;

class d$1
  extends AnimatorListenerAdapter
{
  d$1(d paramd) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    d.a(this.a).setVisibility(8);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = (FrameLayout.LayoutParams)d.a(this.a).getLayoutParams();
    paramAnimator.topMargin = d.b(this.a).getRect().top;
    d.a(this.a).setLayoutParams(paramAnimator);
    d.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dl.d.1
 * JD-Core Version:    0.7.0.1
 */