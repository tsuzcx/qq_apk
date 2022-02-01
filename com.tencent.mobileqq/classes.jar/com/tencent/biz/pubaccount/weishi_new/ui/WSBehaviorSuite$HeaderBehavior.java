package com.tencent.biz.pubaccount.weishi_new.ui;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/ui/WSBehaviorSuite$HeaderBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Landroid/widget/LinearLayout;", "()V", "hasInit", "", "isBeDragging", "lastMotionY", "", "listener", "Lcom/tencent/biz/pubaccount/weishi_new/ui/WSBehaviorSuite$OnViewTranslateListener;", "maximumVelocity", "", "minimumVelocity", "nestedScrollingChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "scroller", "Landroid/widget/OverScroller;", "toolbarHeight", "totalOffset", "touchSlop", "velocityTracker", "Landroid/view/VelocityTracker;", "abortAnimatedScroll", "", "canScrollChildren", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "directTargetChild", "Landroid/view/View;", "fling", "velocityY", "getHeaderMaxOffset", "initConfig", "Landroid/view/ViewGroup;", "initOrResetVelocityTracker", "offsetTopAndBottom", "offset", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onLayoutChild", "layoutDirection", "onNestedPreScroll", "target", "dx", "dy", "consumed", "", "type", "onNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onStartNestedScroll", "nestedScrollAxes", "onTouchEvent", "recycleVelocityTracker", "reset", "setHeaderTopBottomOffset", "offsetDelta", "setOnViewTranslateListener", "setToolbarHeight", "height", "Companion", "FlingRunnable", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSBehaviorSuite$HeaderBehavior
  extends CoordinatorLayout.Behavior<LinearLayout>
{
  public static final WSBehaviorSuite.HeaderBehavior.Companion a = new WSBehaviorSuite.HeaderBehavior.Companion(null);
  private NestedScrollingChildHelper b;
  private VelocityTracker c;
  private OverScroller d;
  private WSBehaviorSuite.OnViewTranslateListener e;
  private boolean f;
  private boolean g;
  private float h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  
  private final void a()
  {
    VelocityTracker localVelocityTracker = this.c;
    if (localVelocityTracker == null)
    {
      this.c = VelocityTracker.obtain();
      return;
    }
    if (localVelocityTracker == null) {
      Intrinsics.throwNpe();
    }
    localVelocityTracker.clear();
  }
  
  private final void a(ViewGroup paramViewGroup)
  {
    if (this.f) {
      return;
    }
    this.f = true;
    Context localContext = paramViewGroup.getContext();
    paramViewGroup = new NestedScrollingChildHelper((View)paramViewGroup);
    paramViewGroup.setNestedScrollingEnabled(true);
    this.b = paramViewGroup;
    paramViewGroup = ViewConfiguration.get(localContext);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "configuration");
    this.i = paramViewGroup.getScaledTouchSlop();
    this.j = paramViewGroup.getScaledMinimumFlingVelocity();
    this.k = paramViewGroup.getScaledMaximumFlingVelocity();
    this.d = new OverScroller(localContext);
  }
  
  private final void a(LinearLayout paramLinearLayout, int paramInt)
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      ((OverScroller)localObject).fling(0, 0, 0, paramInt, 0, 0, -2147483648, 2147483647, 0, 0);
      localObject = new WSBehaviorSuite.HeaderBehavior.FlingRunnable(this, paramLinearLayout, (OverScroller)localObject);
      ViewCompat.postOnAnimation((View)paramLinearLayout, (Runnable)localObject);
    }
  }
  
  private final boolean a(CoordinatorLayout paramCoordinatorLayout, LinearLayout paramLinearLayout, View paramView)
  {
    return paramCoordinatorLayout.getHeight() - paramView.getHeight() <= paramLinearLayout.getHeight();
  }
  
  private final int b(LinearLayout paramLinearLayout)
  {
    paramLinearLayout = paramLinearLayout.getChildAt(0);
    Intrinsics.checkExpressionValueIsNotNull(paramLinearLayout, "child.getChildAt(0)");
    int n = paramLinearLayout.getHeight() - this.l;
    if (n >= 0) {
      return n;
    }
    return 0;
  }
  
  private final void b()
  {
    VelocityTracker localVelocityTracker = this.c;
    if (localVelocityTracker != null)
    {
      if (localVelocityTracker == null) {
        Intrinsics.throwNpe();
      }
      localVelocityTracker.recycle();
      this.c = ((VelocityTracker)null);
    }
  }
  
  private final void b(LinearLayout paramLinearLayout, int paramInt)
  {
    int i1 = b(paramLinearLayout);
    int n;
    if (paramInt < 0)
    {
      n = paramInt;
      if (-paramLinearLayout.getTop() - paramInt > i1) {
        n = -paramLinearLayout.getTop() - i1;
      }
    }
    else if (paramLinearLayout.getTop() + paramInt > 0)
    {
      n = -paramLinearLayout.getTop();
    }
    else
    {
      n = paramInt;
      if (-paramLinearLayout.getTop() == i1) {
        n = 0;
      }
    }
    c(paramLinearLayout, n);
  }
  
  private final void c()
  {
    Object localObject = this.d;
    if (localObject != null) {
      ((OverScroller)localObject).abortAnimation();
    }
    localObject = this.b;
    if (localObject != null) {
      ((NestedScrollingChildHelper)localObject).stopNestedScroll(0);
    }
  }
  
  private final void c(LinearLayout paramLinearLayout, int paramInt)
  {
    ViewCompat.offsetTopAndBottom((View)paramLinearLayout, paramInt);
    this.m += paramInt;
    WSBehaviorSuite.OnViewTranslateListener localOnViewTranslateListener = this.e;
    if (localOnViewTranslateListener != null) {
      localOnViewTranslateListener.a(Math.abs(paramLinearLayout.getTop()) / b(paramLinearLayout), -paramLinearLayout.getTop());
    }
  }
  
  public final void a(int paramInt)
  {
    this.l = paramInt;
  }
  
  public final void a(@NotNull LinearLayout paramLinearLayout)
  {
    Intrinsics.checkParameterIsNotNull(paramLinearLayout, "child");
    int n = this.m;
    if (n == 0) {
      return;
    }
    c(paramLinearLayout, -n);
  }
  
  public void a(@NotNull CoordinatorLayout paramCoordinatorLayout, @NotNull LinearLayout paramLinearLayout, @NotNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCoordinatorLayout, "parent");
    Intrinsics.checkParameterIsNotNull(paramLinearLayout, "child");
    Intrinsics.checkParameterIsNotNull(paramView, "target");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "consumed");
    if (paramInt4 < 0)
    {
      paramInt1 = paramInt4;
      if (paramLinearLayout.getTop() - paramInt4 > 0) {
        paramInt1 = paramLinearLayout.getTop();
      }
      c(paramLinearLayout, -paramInt1);
      paramArrayOfInt[1] = paramInt1;
    }
  }
  
  public void a(@NotNull CoordinatorLayout paramCoordinatorLayout, @NotNull LinearLayout paramLinearLayout, @NotNull View paramView, int paramInt1, int paramInt2, @NotNull int[] paramArrayOfInt, int paramInt3)
  {
    Intrinsics.checkParameterIsNotNull(paramCoordinatorLayout, "parent");
    Intrinsics.checkParameterIsNotNull(paramLinearLayout, "child");
    Intrinsics.checkParameterIsNotNull(paramView, "target");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "consumed");
    if (paramInt2 > 0)
    {
      paramInt1 = paramLinearLayout.getTop();
      paramInt3 = b(paramLinearLayout);
      if (-paramInt1 + paramInt2 >= paramInt3)
      {
        paramInt1 = paramInt3 + paramInt1;
        c(paramLinearLayout, -paramInt1);
        paramArrayOfInt[1] = paramInt1;
        return;
      }
      c(paramLinearLayout, -paramInt2);
      paramArrayOfInt[1] = paramInt2;
    }
  }
  
  public final void a(@NotNull WSBehaviorSuite.OnViewTranslateListener paramOnViewTranslateListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnViewTranslateListener, "listener");
    this.e = paramOnViewTranslateListener;
  }
  
  public boolean a(@NotNull CoordinatorLayout paramCoordinatorLayout, @NotNull LinearLayout paramLinearLayout, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCoordinatorLayout, "parent");
    Intrinsics.checkParameterIsNotNull(paramLinearLayout, "child");
    Object localObject = paramLinearLayout.getLayoutParams();
    if (localObject != null)
    {
      localObject = (CoordinatorLayout.LayoutParams)localObject;
      paramInt = paramCoordinatorLayout.getPaddingLeft() + ((CoordinatorLayout.LayoutParams)localObject).leftMargin;
      int n = ((CoordinatorLayout.LayoutParams)localObject).topMargin + this.m;
      paramLinearLayout.layout(paramInt, n, paramLinearLayout.getMeasuredWidth() + paramInt, paramLinearLayout.getMeasuredHeight() + n);
      return true;
    }
    throw new TypeCastException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
  }
  
  public boolean a(@NotNull CoordinatorLayout paramCoordinatorLayout, @NotNull LinearLayout paramLinearLayout, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramCoordinatorLayout, "parent");
    Intrinsics.checkParameterIsNotNull(paramLinearLayout, "child");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "ev");
    int n = paramMotionEvent.getAction();
    if (n != 0)
    {
      if ((n == 2) && (this.g) && (Math.abs(paramMotionEvent.getY() - this.h) > this.i))
      {
        this.h = paramMotionEvent.getY();
        return true;
      }
    }
    else
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      this.g = paramCoordinatorLayout.isPointInChildBounds((View)paramLinearLayout, (int)f1, (int)f2);
      if (this.g)
      {
        this.h = f2;
        a((ViewGroup)paramLinearLayout);
        c();
        a();
        localObject = this.b;
        if (localObject != null) {
          ((NestedScrollingChildHelper)localObject).startNestedScroll(2);
        }
      }
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((VelocityTracker)localObject).addMovement(paramMotionEvent);
    }
    return super.onInterceptTouchEvent(paramCoordinatorLayout, (View)paramLinearLayout, paramMotionEvent);
  }
  
  public boolean a(@NotNull CoordinatorLayout paramCoordinatorLayout, @NotNull LinearLayout paramLinearLayout, @NotNull View paramView1, @NotNull View paramView2, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramCoordinatorLayout, "parent");
    Intrinsics.checkParameterIsNotNull(paramLinearLayout, "child");
    Intrinsics.checkParameterIsNotNull(paramView1, "directTargetChild");
    Intrinsics.checkParameterIsNotNull(paramView2, "target");
    c();
    return ((Intrinsics.areEqual(paramView2, paramLinearLayout) ^ true)) && ((paramInt1 & 0x2) != 0) && (a(paramCoordinatorLayout, paramLinearLayout, paramView1));
  }
  
  public boolean b(@NotNull CoordinatorLayout paramCoordinatorLayout, @NotNull LinearLayout paramLinearLayout, @NotNull MotionEvent paramMotionEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramCoordinatorLayout, "parent");
    Intrinsics.checkParameterIsNotNull(paramLinearLayout, "child");
    Intrinsics.checkParameterIsNotNull(paramMotionEvent, "ev");
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      int n = 0;
      if (i1 != 1)
      {
        if (i1 != 2)
        {
          if (i1 == 3)
          {
            this.g = false;
            b();
          }
        }
        else
        {
          n = (int)(paramMotionEvent.getY() - this.h);
          this.h = paramMotionEvent.getY();
          paramCoordinatorLayout = this.c;
          if (paramCoordinatorLayout != null) {
            paramCoordinatorLayout.addMovement(paramMotionEvent);
          }
          b(paramLinearLayout, n);
          return true;
        }
      }
      else
      {
        this.g = false;
        VelocityTracker localVelocityTracker = this.c;
        if (localVelocityTracker != null) {
          localVelocityTracker.computeCurrentVelocity(1000, this.k);
        }
        localVelocityTracker = this.c;
        if (localVelocityTracker != null) {
          n = (int)localVelocityTracker.getYVelocity();
        }
        b();
        if (Math.abs(n) >= this.j)
        {
          a(paramLinearLayout, n);
          return true;
        }
      }
      return super.onTouchEvent(paramCoordinatorLayout, (View)paramLinearLayout, paramMotionEvent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.WSBehaviorSuite.HeaderBehavior
 * JD-Core Version:    0.7.0.1
 */