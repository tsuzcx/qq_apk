package com.tencent.mm.ui.widget.listview;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class AnimatedExpandableListView$AnimatedExpandableListAdapter$1
  implements Animation.AnimationListener
{
  AnimatedExpandableListView$AnimatedExpandableListAdapter$1(AnimatedExpandableListView.AnimatedExpandableListAdapter paramAnimatedExpandableListAdapter, int paramInt, AnimatedExpandableListView.DummyView paramDummyView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AnimatedExpandableListView.AnimatedExpandableListAdapter.a(this.c, this.a);
    this.c.notifyDataSetChanged();
    this.b.setTag(Integer.valueOf(0));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.AnimatedExpandableListAdapter.1
 * JD-Core Version:    0.7.0.1
 */