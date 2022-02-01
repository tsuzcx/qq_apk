package com.google.android.material.transformation;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.google.android.material.expandable.ExpandableWidget;

class ExpandableBehavior$1
  implements ViewTreeObserver.OnPreDrawListener
{
  ExpandableBehavior$1(ExpandableBehavior paramExpandableBehavior, View paramView, int paramInt, ExpandableWidget paramExpandableWidget) {}
  
  public boolean onPreDraw()
  {
    this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    if (ExpandableBehavior.a(this.d) == this.b)
    {
      ExpandableBehavior localExpandableBehavior = this.d;
      ExpandableWidget localExpandableWidget = this.c;
      localExpandableBehavior.a((View)localExpandableWidget, this.a, localExpandableWidget.a(), false);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transformation.ExpandableBehavior.1
 * JD-Core Version:    0.7.0.1
 */