package com.tencent.mm.ui.widget.listview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class PullDownListView$3
  extends AnimatorListenerAdapter
{
  PullDownListView$3(PullDownListView paramPullDownListView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (PullDownListView.a(this.a) != null) {
      PullDownListView.a(this.a).setVisibility(8);
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (PullDownListView.a(this.a) != null) {
      PullDownListView.a(this.a).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView.3
 * JD-Core Version:    0.7.0.1
 */