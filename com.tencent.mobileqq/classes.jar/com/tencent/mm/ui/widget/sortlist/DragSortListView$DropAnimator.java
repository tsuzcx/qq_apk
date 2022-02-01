package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Point;
import android.view.View;

class DragSortListView$DropAnimator
  extends DragSortListView.SmoothAnimator
{
  private int d;
  private int e;
  private float f;
  private float g;
  
  private DragSortListView$DropAnimator(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    super(paramDragSortListView, paramFloat, paramInt, null);
  }
  
  private int a()
  {
    int i = this.a.getFirstVisiblePosition();
    int j = (DragSortListView.i(this.a) + this.a.getDividerHeight()) / 2;
    View localView = this.a.getChildAt(this.d - i);
    if (localView != null)
    {
      i = this.d;
      int k = this.e;
      if (i == k) {
        return localView.getTop();
      }
      if (i < k)
      {
        i = localView.getTop();
      }
      else
      {
        i = localView.getBottom() + j;
        j = DragSortListView.j(this.a);
      }
      return i - j;
    }
    cancel();
    return -1;
  }
  
  public void onStart()
  {
    this.d = DragSortListView.g(this.a);
    this.e = DragSortListView.h(this.a);
    DragSortListView.b(this.a, 2);
    this.f = (DragSortListView.e(this.a).y - a());
    this.g = (DragSortListView.e(this.a).x - this.a.getPaddingLeft());
  }
  
  public void onStop()
  {
    DragSortListView.k(this.a);
  }
  
  public void onUpdate(float paramFloat1, float paramFloat2)
  {
    int i = a();
    int j = this.a.getPaddingLeft();
    paramFloat1 = DragSortListView.e(this.a).y - i;
    float f1 = DragSortListView.e(this.a).x - j;
    paramFloat2 = 1.0F - paramFloat2;
    if ((paramFloat2 < Math.abs(paramFloat1 / this.f)) || (paramFloat2 < Math.abs(f1 / this.g)))
    {
      DragSortListView.e(this.a).y = (i + (int)(this.f * paramFloat2));
      DragSortListView.e(this.a).x = (this.a.getPaddingLeft() + (int)(this.g * paramFloat2));
      DragSortListView.a(this.a, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.DropAnimator
 * JD-Core Version:    0.7.0.1
 */