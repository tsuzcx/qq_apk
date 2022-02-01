package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Point;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

class DragSortListView$RemoveAnimator
  extends DragSortListView.SmoothAnimator
{
  private float d;
  private float e;
  private float f;
  private int g = -1;
  private int h = -1;
  private int i;
  private int j;
  
  private DragSortListView$RemoveAnimator(DragSortListView paramDragSortListView, float paramFloat, int paramInt)
  {
    super(paramDragSortListView, paramFloat, paramInt, null);
  }
  
  public void onStart()
  {
    int k = -1;
    this.g = -1;
    this.h = -1;
    this.i = DragSortListView.l(this.a);
    this.j = DragSortListView.m(this.a);
    DragSortListView.b(this.a, 1);
    this.d = DragSortListView.e(this.a).x;
    if (DragSortListView.n(this.a))
    {
      float f1 = this.a.getWidth() * 2.0F;
      if (DragSortListView.o(this.a) == 0.0F)
      {
        DragSortListView localDragSortListView = this.a;
        if (this.d >= 0.0F) {
          k = 1;
        }
        DragSortListView.a(localDragSortListView, k * f1);
        return;
      }
      f1 *= 2.0F;
      if (DragSortListView.o(this.a) < 0.0F)
      {
        float f2 = DragSortListView.o(this.a);
        float f3 = -f1;
        if (f2 > f3)
        {
          DragSortListView.a(this.a, f3);
          return;
        }
      }
      if ((DragSortListView.o(this.a) > 0.0F) && (DragSortListView.o(this.a) < f1)) {
        DragSortListView.a(this.a, f1);
      }
    }
    else
    {
      DragSortListView.p(this.a);
    }
  }
  
  public void onStop()
  {
    DragSortListView.q(this.a);
  }
  
  public void onUpdate(float paramFloat1, float paramFloat2)
  {
    paramFloat1 = 1.0F - paramFloat2;
    int m = this.a.getFirstVisiblePosition();
    View localView = this.a.getChildAt(this.i - m);
    Object localObject;
    if (DragSortListView.n(this.a))
    {
      float f1 = (float)(SystemClock.uptimeMillis() - this.b) / 1000.0F;
      if (f1 == 0.0F) {
        return;
      }
      float f2 = DragSortListView.o(this.a);
      int n = this.a.getWidth();
      localObject = this.a;
      float f3 = DragSortListView.o((DragSortListView)localObject);
      if (DragSortListView.o(this.a) > 0.0F) {
        k = 1;
      } else {
        k = -1;
      }
      float f4 = k;
      paramFloat2 = n;
      DragSortListView.a((DragSortListView)localObject, f3 + f4 * f1 * paramFloat2);
      this.d += f2 * f1;
      localObject = DragSortListView.e(this.a);
      f1 = this.d;
      ((Point)localObject).x = ((int)f1);
      if ((f1 < paramFloat2) && (f1 > -n))
      {
        this.b = SystemClock.uptimeMillis();
        DragSortListView.a(this.a, true);
        return;
      }
    }
    if (localView != null)
    {
      if (this.g == -1)
      {
        this.g = DragSortListView.b(this.a, this.i, localView, false);
        this.e = (localView.getHeight() - this.g);
      }
      k = Math.max((int)(this.e * paramFloat1), 1);
      localObject = localView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject).height = (this.g + k);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    int k = this.j;
    if (k != this.i)
    {
      localView = this.a.getChildAt(k - m);
      if (localView != null)
      {
        if (this.h == -1)
        {
          this.h = DragSortListView.b(this.a, this.j, localView, false);
          this.f = (localView.getHeight() - this.h);
        }
        k = Math.max((int)(paramFloat1 * this.f), 1);
        localObject = localView.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject).height = (this.h + k);
        localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.sortlist.DragSortListView.RemoveAnimator
 * JD-Core Version:    0.7.0.1
 */