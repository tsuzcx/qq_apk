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
  OverScroller a;
  @Nullable
  private Runnable b;
  private boolean c;
  private int d = -1;
  private int e;
  private int f = -1;
  @Nullable
  private VelocityTracker g;
  
  public HeaderBehavior() {}
  
  public HeaderBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void c()
  {
    if (this.g == null) {
      this.g = VelocityTracker.obtain();
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
  
  final boolean a(CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, int paramInt1, int paramInt2, float paramFloat)
  {
    Runnable localRunnable = this.b;
    if (localRunnable != null)
    {
      paramV.removeCallbacks(localRunnable);
      this.b = null;
    }
    if (this.a == null) {
      this.a = new OverScroller(paramV.getContext());
    }
    this.a.fling(0, b(), 0, Math.round(paramFloat), 0, 0, paramInt1, paramInt2);
    if (this.a.computeScrollOffset())
    {
      this.b = new HeaderBehavior.FlingRunnable(this, paramCoordinatorLayout, paramV);
      ViewCompat.postOnAnimation(paramV, this.b);
      return true;
    }
    a(paramCoordinatorLayout, paramV);
    return false;
  }
  
  int a_(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt)
  {
    return a(paramCoordinatorLayout, paramV, paramInt, -2147483648, 2147483647);
  }
  
  int b(@NonNull V paramV)
  {
    return -paramV.getHeight();
  }
  
  final int b(CoordinatorLayout paramCoordinatorLayout, V paramV, int paramInt1, int paramInt2, int paramInt3)
  {
    return a(paramCoordinatorLayout, paramV, a() - paramInt1, paramInt2, paramInt3);
  }
  
  boolean c(V paramV)
  {
    return false;
  }
  
  public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull MotionEvent paramMotionEvent)
  {
    if (this.f < 0) {
      this.f = ViewConfiguration.get(paramCoordinatorLayout.getContext()).getScaledTouchSlop();
    }
    int i;
    if ((paramMotionEvent.getActionMasked() == 2) && (this.c))
    {
      i = this.d;
      if (i == -1) {
        return false;
      }
      i = paramMotionEvent.findPointerIndex(i);
      if (i == -1) {
        return false;
      }
      i = (int)paramMotionEvent.getY(i);
      if (Math.abs(i - this.e) > this.f)
      {
        this.e = i;
        return true;
      }
    }
    if (paramMotionEvent.getActionMasked() == 0)
    {
      this.d = -1;
      i = (int)paramMotionEvent.getX();
      int j = (int)paramMotionEvent.getY();
      boolean bool;
      if ((c(paramV)) && (paramCoordinatorLayout.isPointInChildBounds(paramV, i, j))) {
        bool = true;
      } else {
        bool = false;
      }
      this.c = bool;
      if (this.c)
      {
        this.e = j;
        this.d = paramMotionEvent.getPointerId(0);
        c();
        paramCoordinatorLayout = this.a;
        if ((paramCoordinatorLayout != null) && (!paramCoordinatorLayout.isFinished()))
        {
          this.a.abortAnimation();
          return true;
        }
      }
    }
    paramCoordinatorLayout = this.g;
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
          this.d = paramMotionEvent.getPointerId(i);
          this.e = ((int)(paramMotionEvent.getY(i) + 0.5F));
        }
      }
      else
      {
        i = paramMotionEvent.findPointerIndex(this.d);
        if (i == -1) {
          return false;
        }
        i = (int)paramMotionEvent.getY(i);
        j = this.e;
        this.e = i;
        b(paramCoordinatorLayout, paramV, j - i, b(paramV), 0);
      }
      j = 0;
      break label244;
    }
    else
    {
      VelocityTracker localVelocityTracker = this.g;
      if (localVelocityTracker != null)
      {
        localVelocityTracker.addMovement(paramMotionEvent);
        this.g.computeCurrentVelocity(1000);
        float f1 = this.g.getYVelocity(this.d);
        a(paramCoordinatorLayout, paramV, -a(paramV), 0, f1);
        i = 1;
        break label208;
      }
    }
    label205:
    i = 0;
    label208:
    this.c = false;
    this.d = -1;
    paramCoordinatorLayout = this.g;
    int j = i;
    if (paramCoordinatorLayout != null)
    {
      paramCoordinatorLayout.recycle();
      this.g = null;
      j = i;
    }
    label244:
    paramCoordinatorLayout = this.g;
    if (paramCoordinatorLayout != null) {
      paramCoordinatorLayout.addMovement(paramMotionEvent);
    }
    if (!this.c)
    {
      if (j != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.appbar.HeaderBehavior
 * JD-Core Version:    0.7.0.1
 */