package com.tencent.mm.ui.widget.listview;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ExpandableListView;

class AnimatedExpandableListView$AnimatedExpandableListAdapter$2
  implements Animation.AnimationListener
{
  AnimatedExpandableListView$AnimatedExpandableListAdapter$2(AnimatedExpandableListView.AnimatedExpandableListAdapter paramAnimatedExpandableListAdapter, int paramInt, ExpandableListView paramExpandableListView, AnimatedExpandableListView.GroupInfo paramGroupInfo, AnimatedExpandableListView.DummyView paramDummyView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    AnimatedExpandableListView.AnimatedExpandableListAdapter.a(this.e, this.a);
    this.b.collapseGroup(this.a);
    this.e.notifyDataSetChanged();
    this.c.d = -1;
    this.d.setTag(Integer.valueOf(0));
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.AnimatedExpandableListAdapter.2
 * JD-Core Version:    0.7.0.1
 */