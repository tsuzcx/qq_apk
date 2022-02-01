package com.tencent.mm.ui.widget.listview;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class AnimatedExpandableListView$ExpandAnimation
  extends Animation
{
  private int a;
  private int b;
  private View c;
  private AnimatedExpandableListView.GroupInfo d;
  
  private AnimatedExpandableListView$ExpandAnimation(View paramView, int paramInt1, int paramInt2, AnimatedExpandableListView.GroupInfo paramGroupInfo)
  {
    this.a = paramInt1;
    this.b = (paramInt2 - paramInt1);
    this.c = paramView;
    this.d = paramGroupInfo;
    this.c.getLayoutParams().height = paramInt1;
    this.c.requestLayout();
  }
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    super.applyTransformation(paramFloat, paramTransformation);
    if (paramFloat < 1.0F)
    {
      i = this.a + (int)(this.b * paramFloat);
      this.c.getLayoutParams().height = i;
      this.d.d = i;
      this.c.requestLayout();
      return;
    }
    int i = this.a + this.b;
    this.c.getLayoutParams().height = i;
    this.d.d = i;
    this.c.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.AnimatedExpandableListView.ExpandAnimation
 * JD-Core Version:    0.7.0.1
 */