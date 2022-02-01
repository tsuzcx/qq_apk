package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper.Callback;

class SwipeDismissBehavior$1
  extends ViewDragHelper.Callback
{
  private int b;
  private int c = -1;
  
  SwipeDismissBehavior$1(SwipeDismissBehavior paramSwipeDismissBehavior) {}
  
  private boolean a(@NonNull View paramView, float paramFloat)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    if (paramFloat != 0.0F)
    {
      if (ViewCompat.getLayoutDirection(paramView) == 1) {
        i = 1;
      } else {
        i = 0;
      }
      if (this.a.c == 2) {
        return true;
      }
      if (this.a.c == 0)
      {
        if (i != 0 ? paramFloat < 0.0F : paramFloat > 0.0F) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool2;
      if (this.a.c == 1)
      {
        if (i != 0)
        {
          bool1 = bool2;
          if (paramFloat <= 0.0F) {
            break label123;
          }
        }
        else
        {
          bool1 = bool2;
          if (paramFloat >= 0.0F) {
            break label123;
          }
        }
        bool1 = true;
      }
      label123:
      return bool1;
    }
    int i = paramView.getLeft();
    int j = this.b;
    int k = Math.round(paramView.getWidth() * this.a.d);
    bool1 = bool3;
    if (Math.abs(i - j) >= k) {
      bool1 = true;
    }
    return bool1;
  }
  
  public int clampViewPositionHorizontal(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    if (ViewCompat.getLayoutDirection(paramView) == 1) {
      paramInt2 = 1;
    } else {
      paramInt2 = 0;
    }
    int i;
    if (this.a.c == 0)
    {
      if (paramInt2 != 0)
      {
        i = this.b - paramView.getWidth();
        paramInt2 = this.b;
      }
      else
      {
        i = this.b;
      }
    }
    else
    {
      for (paramInt2 = paramView.getWidth();; paramInt2 = paramView.getWidth())
      {
        paramInt2 += i;
        break label138;
        if (this.a.c != 1) {
          break label115;
        }
        if (paramInt2 == 0) {
          break;
        }
        i = this.b;
      }
      i = this.b - paramView.getWidth();
      paramInt2 = this.b;
      break label138;
      label115:
      i = this.b - paramView.getWidth();
      paramInt2 = this.b;
      paramInt2 = paramView.getWidth() + paramInt2;
    }
    label138:
    return SwipeDismissBehavior.a(i, paramInt1, paramInt2);
  }
  
  public int clampViewPositionVertical(@NonNull View paramView, int paramInt1, int paramInt2)
  {
    return paramView.getTop();
  }
  
  public int getViewHorizontalDragRange(@NonNull View paramView)
  {
    return paramView.getWidth();
  }
  
  public void onViewCaptured(@NonNull View paramView, int paramInt)
  {
    this.c = paramInt;
    this.b = paramView.getLeft();
    paramView = paramView.getParent();
    if (paramView != null) {
      paramView.requestDisallowInterceptTouchEvent(true);
    }
  }
  
  public void onViewDragStateChanged(int paramInt)
  {
    if (this.a.b != null) {
      this.a.b.a(paramInt);
    }
  }
  
  public void onViewPositionChanged(@NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f1 = this.b + paramView.getWidth() * this.a.e;
    float f2 = this.b + paramView.getWidth() * this.a.f;
    float f3 = paramInt1;
    if (f3 <= f1)
    {
      paramView.setAlpha(1.0F);
      return;
    }
    if (f3 >= f2)
    {
      paramView.setAlpha(0.0F);
      return;
    }
    paramView.setAlpha(SwipeDismissBehavior.a(0.0F, 1.0F - SwipeDismissBehavior.b(f1, f2, f3), 1.0F));
  }
  
  public void onViewReleased(@NonNull View paramView, float paramFloat1, float paramFloat2)
  {
    this.c = -1;
    int i = paramView.getWidth();
    boolean bool;
    if (a(paramView, paramFloat1))
    {
      int j = paramView.getLeft();
      int k = this.b;
      if (j < k) {
        i = k - i;
      } else {
        i = k + i;
      }
      bool = true;
    }
    else
    {
      i = this.b;
      bool = false;
    }
    if (this.a.a.settleCapturedViewAt(i, paramView.getTop()))
    {
      ViewCompat.postOnAnimation(paramView, new SwipeDismissBehavior.SettleRunnable(this.a, paramView, bool));
      return;
    }
    if ((bool) && (this.a.b != null)) {
      this.a.b.a(paramView);
    }
  }
  
  public boolean tryCaptureView(View paramView, int paramInt)
  {
    int i = this.c;
    return ((i == -1) || (i == paramInt)) && (this.a.a(paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.behavior.SwipeDismissBehavior.1
 * JD-Core Version:    0.7.0.1
 */