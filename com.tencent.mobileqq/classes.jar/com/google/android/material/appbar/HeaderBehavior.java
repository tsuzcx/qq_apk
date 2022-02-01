package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

abstract class HeaderBehavior<V extends View>
  extends ViewOffsetBehavior<V>
{
  private int jdField_a_of_type_Int = -1;
  @Nullable
  private VelocityTracker jdField_a_of_type_AndroidViewVelocityTracker;
  OverScroller jdField_a_of_type_AndroidWidgetOverScroller;
  @Nullable
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c = -1;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidViewVelocityTracker == null) {
      this.jdField_a_of_type_AndroidViewVelocityTracker = VelocityTracker.obtain();
    }
  }
  
  int a()
  {
    return b();
  }
  
  int a(@NonNull V paramV)
  {
    return paramV.getHeight();
  }
  
  int a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return a(paramCoordinatorLayout, paramV, paramInt, -2147483648, 2147483647);
  }
  
  int a(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = b();
    if ((paramInt2 != 0) && (i >= paramInt2) && (i <= paramInt3))
    {
      paramInt1 = MathUtils.clamp(paramInt1, paramInt2, paramInt3);
      if (i != paramInt1)
      {
        a(paramInt1);
        return i - paramInt1;
      }
    }
    return 0;
  }
  
  void a(CoordinatorLayout paramCoordinatorLayout, V paramV) {}
  
  boolean a(V paramV)
  {
    return false;
  }
  
  final boolean a(CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, int paramInt1, int paramInt2, float paramFloat)
  {
    Runnable localRunnable = this.jdField_a_of_type_JavaLangRunnable;
    if (localRunnable != null)
    {
      paramV.removeCallbacks(localRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    if (this.jdField_a_of_type_AndroidWidgetOverScroller == null) {
      this.jdField_a_of_type_AndroidWidgetOverScroller = new OverScroller(paramV.getContext());
    }
    this.jdField_a_of_type_AndroidWidgetOverScroller.fling(0, b(), 0, Math.round(paramFloat), 0, 0, paramInt1, paramInt2);
    if (this.jdField_a_of_type_AndroidWidgetOverScroller.computeScrollOffset())
    {
      this.jdField_a_of_type_JavaLangRunnable = new HeaderBehavior.FlingRunnable(this, paramCoordinatorLayout, paramV);
      ViewCompat.postOnAnimation(paramV, this.jdField_a_of_type_JavaLangRunnable);
      return true;
    }
    a(paramCoordinatorLayout, paramV);
    return false;
  }
  
  int b(@NonNull V paramV)
  {
    return -paramV.getHeight();
  }
  
  final int b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramCoordinatorLayout, paramV, a() - paramInt1, paramInt2, paramInt3);
  }
  
  public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull MotionEvent paramMotionEvent)
  {
    if (this.c < 0) {
      this.c = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    int i;
    if ((paramMotionEvent.getActionMasked() == 2) && (this.jdField_a_of_type_Boolean))
    {
      i = this.jdField_a_of_type_Int;
      if (i == -1) {
        return false;
      }
      i = paramMotionEvent.findPointerIndex(i);
      if (i == -1) {
        return false;
      }
      i = (int)paramMotionEvent.getY(i);
      if (Math.abs(i - this.b) > this.c)
      {
        this.b = i;
        return true;
      }
    }
    if (paramMotionEvent.getActionMasked() == 0)
    {
      this.jdField_a_of_type_Int = -1;
      i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      boolean bool;
      if ((a(paramV)) && (paramCoordinatorLayout.isPointInChildBounds(paramV, i, j))) {
        bool = true;
      } else {
        bool = false;
      }
      this.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_Boolean)
      {
        this.b = j;
        this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
        a();
        paramCoordinatorLayout = this.jdField_a_of_type_AndroidWidgetOverScroller;
        if ((paramCoordinatorLayout != null) && (!paramCoordinatorLayout.isFinished()))
        {
          this.jdField_a_of_type_AndroidWidgetOverScroller.abortAnimation();
          return true;
        }
      }
    }
    paramCoordinatorLayout = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.addMovement(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    boolean bool = true;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 3) {
          break label205;
        }
        if (i == 6)
        {
          if (paramMotionEvent.getActionIndex() == 0) {
            i = 1;
          } else {
            i = 0;
          }
          this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(i);
          this.b = ((int)(paramMotionEvent.getY(i) + 0.5F));
        }
      }
      else
      {
        i = paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int);
        if (i == -1) {
          return false;
        }
        i = (int)paramMotionEvent.getY(i);
        j = this.b;
        this.b = i;
        b(paramCoordinatorLayout, paramV, j - i, b(paramV), 0);
      }
      j = 0;
      break label244;
    }
    else
    {
      VelocityTracker localVelocityTracker = this.jdField_a_of_type_AndroidViewVelocityTracker;
      if (localVelocityTracker != null)
      {
        localVelocityTracker.addMovement(paramMotionEvent);
        this.jdField_a_of_type_AndroidViewVelocityTracker.computeCurrentVelocity(1000);
        float f = this.jdField_a_of_type_AndroidViewVelocityTracker.getYVelocity(this.jdField_a_of_type_Int);
        a(paramCoordinatorLayout, paramV, -a(paramV), 0, f);
        i = 1;
        break label208;
      }
    }
    label205:
    i = 0;
    label208:
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -1;
    paramCoordinatorLayout = this.jdField_a_of_type_AndroidViewVelocityTracker;
    int j = i;
    if (paramCoordinatorLayout != null)
    {
      paramCoordinatorLayout.recycle();
      this.jdField_a_of_type_AndroidViewVelocityTracker = null;
      j = i;
    }
    label244:
    paramCoordinatorLayout = this.jdField_a_of_type_AndroidViewVelocityTracker;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.addMovement(paramMotionEvent);
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      if (j != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.appbar.HeaderBehavior
 * JD-Core Version:    0.7.0.1
 */