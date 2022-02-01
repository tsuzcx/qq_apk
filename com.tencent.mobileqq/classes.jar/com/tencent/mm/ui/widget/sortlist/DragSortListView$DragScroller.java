package com.tencent.mm.ui.widget.sortlist;

import android.os.SystemClock;
import android.view.View;

class DragSortListView$DragScroller
  implements Runnable
{
  public static final int DOWN = 1;
  public static final int STOP = -1;
  public static final int UP = 0;
  private boolean b;
  private long c;
  private long d;
  private int e;
  private float f;
  private long g;
  private int h;
  private float i;
  private boolean j = false;
  
  DragSortListView$DragScroller(DragSortListView paramDragSortListView) {}
  
  public int getScrollDir()
  {
    if (this.j) {
      return this.h;
    }
    return -1;
  }
  
  public boolean isScrolling()
  {
    return this.j;
  }
  
  public void run()
  {
    if (this.b)
    {
      this.j = false;
      return;
    }
    int m = this.a.getFirstVisiblePosition();
    int k = this.a.getLastVisiblePosition();
    int i2 = this.a.getCount();
    int n = this.a.getPaddingTop();
    int i1 = this.a.getHeight() - n - this.a.getPaddingBottom();
    int i3 = Math.min(DragSortListView.f(this.a), DragSortListView.r(this.a) + DragSortListView.d(this.a));
    int i4 = Math.max(DragSortListView.f(this.a), DragSortListView.r(this.a) - DragSortListView.d(this.a));
    if (this.h == 0)
    {
      localView = this.a.getChildAt(0);
      if (localView == null)
      {
        this.j = false;
        return;
      }
      if ((m == 0) && (localView.getTop() == n))
      {
        this.j = false;
        return;
      }
      this.i = DragSortListView.u(this.a).getSpeed((DragSortListView.s(this.a) - i4) / DragSortListView.t(this.a), this.c);
    }
    else
    {
      localView = this.a.getChildAt(k - m);
      if (localView == null)
      {
        this.j = false;
        return;
      }
      if ((k == i2 - 1) && (localView.getBottom() <= i1 + n))
      {
        this.j = false;
        return;
      }
      this.i = (-DragSortListView.u(this.a).getSpeed((i3 - DragSortListView.v(this.a)) / DragSortListView.w(this.a), this.c));
    }
    this.d = SystemClock.uptimeMillis();
    this.f = ((float)(this.d - this.c));
    this.e = Math.round(this.i * this.f);
    i2 = this.e;
    if (i2 >= 0)
    {
      this.e = Math.min(i1, i2);
      k = m;
    }
    else
    {
      this.e = Math.max(-i1, i2);
    }
    View localView = this.a.getChildAt(k - m);
    i1 = localView.getTop() + this.e;
    m = i1;
    if (k == 0)
    {
      m = i1;
      if (i1 > n) {
        m = n;
      }
    }
    DragSortListView.b(this.a, true);
    this.a.setSelectionFromTop(k, m - n);
    this.a.layoutChildren();
    this.a.invalidate();
    DragSortListView.b(this.a, false);
    DragSortListView.c(this.a, k, localView, false);
    this.c = this.d;
    this.a.post(this);
  }
  
  public void startScrolling(int paramInt)
  {
    if (!this.j)
    {
      this.b = false;
      this.j = true;
      this.g = SystemClock.uptimeMillis();
      this.c = this.g;
      this.h = paramInt;
      this.a.post(this);
    }
  }
  
  public void stopScrolling(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.removeCallbacks(this);
      this.j = false;
      return;
    }
    this.b = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.DragScroller
 * JD-Core Version:    0.7.0.1
 */