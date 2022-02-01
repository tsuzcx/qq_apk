package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.TextView;

class IndicatorViewController$1
  extends AnimatorListenerAdapter
{
  IndicatorViewController$1(IndicatorViewController paramIndicatorViewController, int paramInt1, TextView paramTextView1, int paramInt2, TextView paramTextView2) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    IndicatorViewController.a(this.e, this.a);
    IndicatorViewController.a(this.e, null);
    paramAnimator = this.b;
    if (paramAnimator != null)
    {
      paramAnimator.setVisibility(4);
      if ((this.c == 1) && (IndicatorViewController.a(this.e) != null)) {
        IndicatorViewController.a(this.e).setText(null);
      }
    }
    paramAnimator = this.d;
    if (paramAnimator != null)
    {
      paramAnimator.setTranslationY(0.0F);
      this.d.setAlpha(1.0F);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    paramAnimator = this.d;
    if (paramAnimator != null) {
      paramAnimator.setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.textfield.IndicatorViewController.1
 * JD-Core Version:    0.7.0.1
 */