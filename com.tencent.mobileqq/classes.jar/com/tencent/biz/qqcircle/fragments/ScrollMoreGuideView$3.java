package com.tencent.biz.qqcircle.fragments;

import android.animation.Animator;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.widget.QCircleD8SafeAnimatorListener;

class ScrollMoreGuideView$3
  extends QCircleD8SafeAnimatorListener
{
  ScrollMoreGuideView$3(ScrollMoreGuideView paramScrollMoreGuideView, RecyclerView paramRecyclerView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.b.b();
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.b();
    if (ScrollMoreGuideView.b(this.b) > 0)
    {
      paramAnimator = this.a;
      if (paramAnimator != null)
      {
        paramAnimator.postDelayed(new ScrollMoreGuideView.3.1(this), 500L);
        return;
      }
    }
    if (ScrollMoreGuideView.a(this.b) != null) {
      ScrollMoreGuideView.a(this.b).a();
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.ScrollMoreGuideView.3
 * JD-Core Version:    0.7.0.1
 */