package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import android.widget.TextView;

class ReadInJoyAdBrandOptimizationView$3
  implements Animator.AnimatorListener
{
  ReadInJoyAdBrandOptimizationView$3(ReadInJoyAdBrandOptimizationView paramReadInJoyAdBrandOptimizationView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    ReadInJoyAdBrandOptimizationView.a(this.a, false);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyAdBrandOptimizationView.a(this.a, false);
  }
  
  public void onAnimationRepeat(Animator paramAnimator)
  {
    ReadInJoyAdBrandOptimizationView.a(this.a, true);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyAdBrandOptimizationView.a(this.a, true);
    ReadInJoyAdBrandOptimizationView.e(this.a).setAlpha(0.0F);
    ReadInJoyAdBrandOptimizationView.f(this.a).setAlpha(0.0F);
    ReadInJoyAdBrandOptimizationView.g(this.a).setAlpha(0.0F);
    ReadInJoyAdBrandOptimizationView.h(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyAdBrandOptimizationView.3
 * JD-Core Version:    0.7.0.1
 */