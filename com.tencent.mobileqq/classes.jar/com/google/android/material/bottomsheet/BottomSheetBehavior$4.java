package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.math.MathUtils;
import androidx.customview.widget.ViewDragHelper.Callback;
import java.lang.ref.WeakReference;

class BottomSheetBehavior$4
  extends ViewDragHelper.Callback
{
  BottomSheetBehavior$4(BottomSheetBehavior paramBottomSheetBehavior) {}
  
  private boolean a(@NonNull View paramView)
  {
    return paramView.getTop() > (this.a.k + this.a.a()) / 2;
  }
  
  public int clampViewPositionHorizontal(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    return paramView.getLeft();
  }
  
  public int clampViewPositionVertical(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    int i = this.a.a();
    if (this.a.g) {
      paramInt2 = this.a.k;
    } else {
      paramInt2 = this.a.e;
    }
    return MathUtils.clamp(paramInt1, i, paramInt2);
  }
  
  public int getViewVerticalDragRange(@NonNull View paramView)
  {
    if (this.a.g) {
      return this.a.k;
    }
    return this.a.e;
  }
  
  public void onViewDragStateChanged(int paramInt)
  {
    if ((paramInt == 1) && (BottomSheetBehavior.b(this.a))) {
      this.a.e(1);
    }
  }
  
  public void onViewPositionChanged(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a.f(paramInt2);
  }
  
  public void onViewReleased(@NonNull View paramView, float paramFloat1, float paramFloat2)
  {
    int j = 4;
    if (paramFloat2 < 0.0F) {
      if (BottomSheetBehavior.c(this.a)) {
        i = this.a.b;
      }
    }
    for (;;)
    {
      j = 3;
      break label494;
      if (paramView.getTop() > this.a.c)
      {
        i = this.a.c;
        break label302;
      }
      i = this.a.a;
      continue;
      if ((!this.a.g) || (!this.a.a(paramView, paramFloat2))) {
        break label215;
      }
      if (((Math.abs(paramFloat1) < Math.abs(paramFloat2)) && (paramFloat2 > 500.0F)) || (a(paramView)))
      {
        i = this.a.k;
        j = 5;
        break label494;
      }
      if (BottomSheetBehavior.c(this.a))
      {
        i = this.a.b;
      }
      else
      {
        if (Math.abs(paramView.getTop() - this.a.a) >= Math.abs(paramView.getTop() - this.a.c)) {
          break;
        }
        i = this.a.a;
      }
    }
    int i = this.a.c;
    break label302;
    label215:
    if ((paramFloat2 != 0.0F) && (Math.abs(paramFloat1) <= Math.abs(paramFloat2)))
    {
      if (BottomSheetBehavior.c(this.a))
      {
        i = this.a.e;
        break label494;
      }
      i = paramView.getTop();
      if (Math.abs(i - this.a.c) < Math.abs(i - this.a.e)) {
        i = this.a.c;
      }
    }
    for (;;)
    {
      label302:
      j = 6;
      break label494;
      i = this.a.e;
      break label494;
      i = paramView.getTop();
      if (BottomSheetBehavior.c(this.a))
      {
        if (Math.abs(i - this.a.b) < Math.abs(i - this.a.e))
        {
          i = this.a.b;
          break;
        }
        i = this.a.e;
        break label494;
      }
      if (i < this.a.c)
      {
        if (i < Math.abs(i - this.a.e))
        {
          i = this.a.a;
          break;
        }
        i = this.a.c;
        continue;
      }
      if (Math.abs(i - this.a.c) >= Math.abs(i - this.a.e)) {
        break label485;
      }
      i = this.a.c;
    }
    label485:
    i = this.a.e;
    label494:
    this.a.a(paramView, j, i, true);
  }
  
  public boolean tryCaptureView(@NonNull View paramView, int paramInt)
  {
    if (this.a.h == 1) {
      return false;
    }
    if (this.a.o) {
      return false;
    }
    if ((this.a.h == 3) && (this.a.n == paramInt))
    {
      View localView;
      if (this.a.m != null) {
        localView = (View)this.a.m.get();
      } else {
        localView = null;
      }
      if ((localView != null) && (localView.canScrollVertically(-1))) {
        return false;
      }
    }
    return (this.a.l != null) && (this.a.l.get() == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetBehavior.4
 * JD-Core Version:    0.7.0.1
 */