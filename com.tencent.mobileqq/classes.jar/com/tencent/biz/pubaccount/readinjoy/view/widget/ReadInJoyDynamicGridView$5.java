package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ReadInJoyDynamicGridView$5
  extends AnimatorListenerAdapter
{
  ReadInJoyDynamicGridView$5(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyDynamicGridView.b(this.a, false);
    ReadInJoyDynamicGridView.a(this.a);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyDynamicGridView.b(this.a, true);
    ReadInJoyDynamicGridView.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.5
 * JD-Core Version:    0.7.0.1
 */