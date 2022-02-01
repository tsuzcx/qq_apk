package com.tencent.biz.lebasearch.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class ScrolledTabHost$1
  implements Animation.AnimationListener
{
  ScrolledTabHost$1(ScrolledTabHost paramScrolledTabHost, View paramView1, View paramView2, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.a.setVisibility(4);
    this.b.setVisibility(0);
    this.d.d.setVisibility(8);
    this.d.b(this.c);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.lebasearch.widget.ScrolledTabHost.1
 * JD-Core Version:    0.7.0.1
 */