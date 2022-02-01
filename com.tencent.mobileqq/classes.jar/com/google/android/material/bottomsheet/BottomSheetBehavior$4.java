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
    return paramView.getTop() > (this.a.g + this.a.a()) / 2;
  }
  
  public int clampViewPositionHorizontal(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    return paramView.getLeft();
  }
  
  public int clampViewPositionVertical(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    int i = this.a.a();
    if (this.a.jdField_a_of_type_Boolean) {
      paramInt2 = this.a.g;
    } else {
      paramInt2 = this.a.d;
    }
    return MathUtils.clamp(paramInt1, i, paramInt2);
  }
  
  public int getViewVerticalDragRange(@NonNull View paramView)
  {
    if (this.a.jdField_a_of_type_Boolean) {
      return this.a.g;
    }
    return this.a.d;
  }
  
  public void onViewDragStateChanged(int paramInt)
  {
    if ((paramInt == 1) && (BottomSheetBehavior.a(this.a))) {
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
      if (BottomSheetBehavior.b(this.a)) {
        i = this.a.jdField_b_of_type_Int;
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
      i = this.a.jdField_a_of_type_Int;
      continue;
      if ((!this.a.jdField_a_of_type_Boolean) || (!this.a.a(paramView, paramFloat2))) {
        break label215;
      }
      if (((Math.abs(paramFloat1) < Math.abs(paramFloat2)) && (paramFloat2 > 500.0F)) || (a(paramView)))
      {
        i = this.a.g;
        j = 5;
        break label494;
      }
      if (BottomSheetBehavior.b(this.a))
      {
        i = this.a.jdField_b_of_type_Int;
      }
      else
      {
        if (Math.abs(paramView.getTop() - this.a.jdField_a_of_type_Int) >= Math.abs(paramView.getTop() - this.a.c)) {
          break;
        }
        i = this.a.jdField_a_of_type_Int;
      }
    }
    int i = this.a.c;
    break label302;
    label215:
    if ((paramFloat2 != 0.0F) && (Math.abs(paramFloat1) <= Math.abs(paramFloat2)))
    {
      if (BottomSheetBehavior.b(this.a))
      {
        i = this.a.d;
        break label494;
      }
      i = paramView.getTop();
      if (Math.abs(i - this.a.c) < Math.abs(i - this.a.d)) {
        i = this.a.c;
      }
    }
    for (;;)
    {
      label302:
      j = 6;
      break label494;
      i = this.a.d;
      break label494;
      i = paramView.getTop();
      if (BottomSheetBehavior.b(this.a))
      {
        if (Math.abs(i - this.a.jdField_b_of_type_Int) < Math.abs(i - this.a.d))
        {
          i = this.a.jdField_b_of_type_Int;
          break;
        }
        i = this.a.d;
        break label494;
      }
      if (i < this.a.c)
      {
        if (i < Math.abs(i - this.a.d))
        {
          i = this.a.jdField_a_of_type_Int;
          break;
        }
        i = this.a.c;
        continue;
      }
      if (Math.abs(i - this.a.c) >= Math.abs(i - this.a.d)) {
        break label485;
      }
      i = this.a.c;
    }
    label485:
    i = this.a.d;
    label494:
    this.a.a(paramView, j, i, true);
  }
  
  public boolean tryCaptureView(@NonNull View paramView, int paramInt)
  {
    if (this.a.e == 1) {
      return false;
    }
    if (this.a.jdField_b_of_type_Boolean) {
      return false;
    }
    if ((this.a.e == 3) && (this.a.h == paramInt))
    {
      View localView;
      if (this.a.jdField_b_of_type_JavaLangRefWeakReference != null) {
        localView = (View)this.a.jdField_b_of_type_JavaLangRefWeakReference.get();
      } else {
        localView = null;
      }
      if ((localView != null) && (localView.canScrollVertically(-1))) {
        return false;
      }
    }
    return (this.a.jdField_a_of_type_JavaLangRefWeakReference != null) && (this.a.jdField_a_of_type_JavaLangRefWeakReference.get() == paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.bottomsheet.BottomSheetBehavior.4
 * JD-Core Version:    0.7.0.1
 */