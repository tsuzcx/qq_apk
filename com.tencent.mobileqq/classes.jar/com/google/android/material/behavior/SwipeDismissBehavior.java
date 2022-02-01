package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper.Callback;

public class SwipeDismissBehavior<V extends View>
  extends CoordinatorLayout.Behavior<V>
{
  ViewDragHelper a;
  SwipeDismissBehavior.OnDismissListener b;
  int c = 2;
  float d = 0.5F;
  float e = 0.0F;
  float f = 0.5F;
  private boolean g;
  private float h = 0.0F;
  private boolean i;
  private final ViewDragHelper.Callback j = new SwipeDismissBehavior.1(this);
  
  static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.min(Math.max(paramFloat1, paramFloat2), paramFloat3);
  }
  
  static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  private void a(ViewGroup paramViewGroup)
  {
    if (this.a == null)
    {
      if (this.i) {
        paramViewGroup = ViewDragHelper.create(paramViewGroup, this.h, this.j);
      } else {
        paramViewGroup = ViewDragHelper.create(paramViewGroup, this.j);
      }
      this.a = paramViewGroup;
    }
  }
  
  static float b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (paramFloat3 - paramFloat1) / (paramFloat2 - paramFloat1);
  }
  
  private void b(View paramView)
  {
    ViewCompat.removeAccessibilityAction(paramView, 1048576);
    if (a(paramView)) {
      ViewCompat.replaceAccessibilityAction(paramView, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new SwipeDismissBehavior.2(this));
    }
  }
  
  public void a(float paramFloat)
  {
    this.e = a(0.0F, paramFloat, 1.0F);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(@Nullable SwipeDismissBehavior.OnDismissListener paramOnDismissListener)
  {
    this.b = paramOnDismissListener;
  }
  
  public boolean a(@NonNull View paramView)
  {
    return true;
  }
  
  public void b(float paramFloat)
  {
    this.f = a(0.0F, paramFloat, 1.0F);
  }
  
  public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, @NonNull MotionEvent paramMotionEvent)
  {
    boolean bool = this.g;
    int k = paramMotionEvent.getActionMasked();
    if (k != 0)
    {
      if ((k == 1) || (k == 3)) {
        this.g = false;
      }
    }
    else
    {
      this.g = paramCoordinatorLayout.isPointInChildBounds(paramV, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      bool = this.g;
    }
    if (bool)
    {
      a(paramCoordinatorLayout);
      return this.a.shouldInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onLayoutChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull V paramV, int paramInt)
  {
    boolean bool = super.onLayoutChild(paramCoordinatorLayout, paramV, paramInt);
    if (ViewCompat.getImportantForAccessibility(paramV) == 0)
    {
      ViewCompat.setImportantForAccessibility(paramV, 1);
      b(paramV);
    }
    return bool;
  }
  
  public boolean onTouchEvent(CoordinatorLayout paramCoordinatorLayout, V paramV, MotionEvent paramMotionEvent)
  {
    paramCoordinatorLayout = this.a;
    if (paramCoordinatorLayout != null)
    {
      paramCoordinatorLayout.processTouchEvent(paramMotionEvent);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.behavior.SwipeDismissBehavior
 * JD-Core Version:    0.7.0.1
 */