package com.tencent.biz.pubaccount.weishi_new.ui;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/ui/WSBehaviorSuite$ScrollingViewBehavior;", "Landroidx/coordinatorlayout/widget/CoordinatorLayout$Behavior;", "Landroid/view/View;", "()V", "scrollableChild", "toolbarHeight", "", "findHeader", "dependencies", "", "getHeaderMaxOffset", "header", "Landroid/view/ViewGroup;", "getScrollableChild", "view", "getViewPagerCurItemView", "hasScrollToEnd", "", "isHeader", "layoutDependsOn", "parent", "Landroidx/coordinatorlayout/widget/CoordinatorLayout;", "child", "dependency", "onDependentViewChanged", "onLayoutChild", "layoutDirection", "onMeasureChild", "parentWidthMeasureSpec", "widthUsed", "parentHeightMeasureSpec", "heightUsed", "onNestedScroll", "", "coordinatorLayout", "target", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "type", "consumed", "", "onNestedScrollAccepted", "directTargetChild", "axes", "onStartNestedScroll", "setToolbarHeight", "height", "Companion", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSBehaviorSuite$ScrollingViewBehavior
  extends CoordinatorLayout.Behavior<View>
{
  public static final WSBehaviorSuite.ScrollingViewBehavior.Companion a = new WSBehaviorSuite.ScrollingViewBehavior.Companion(null);
  private View b;
  private int c;
  
  private final View a(View paramView)
  {
    if ((paramView instanceof RecyclerView)) {
      return paramView;
    }
    if ((paramView instanceof ViewGroup))
    {
      int i;
      int j;
      if ((!(paramView instanceof androidx.viewpager.widget.ViewPager)) && (!(paramView instanceof android.support.v4.view.ViewPager)))
      {
        i = 0;
        paramView = (ViewGroup)paramView;
        j = paramView.getChildCount();
      }
      while (i < j)
      {
        View localView = a(paramView.getChildAt(i));
        if (localView != null) {
          return localView;
        }
        i += 1;
        continue;
        return a(a((ViewGroup)paramView));
      }
    }
    return null;
  }
  
  private final View a(ViewGroup paramViewGroup)
  {
    int i = paramViewGroup.getChildCount();
    View localView = null;
    if (i == 0) {
      return null;
    }
    if ((paramViewGroup instanceof androidx.viewpager.widget.ViewPager)) {
      return paramViewGroup.getChildAt(((androidx.viewpager.widget.ViewPager)paramViewGroup).getCurrentItem());
    }
    if ((paramViewGroup instanceof android.support.v4.view.ViewPager)) {
      localView = paramViewGroup.getChildAt(((android.support.v4.view.ViewPager)paramViewGroup).getCurrentItem());
    }
    return localView;
  }
  
  private final View a(List<? extends View> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      View localView = (View)paramList.next();
      if (c(localView)) {
        return localView;
      }
    }
    return null;
  }
  
  private final int b(ViewGroup paramViewGroup)
  {
    paramViewGroup = paramViewGroup.getChildAt(0);
    if (paramViewGroup != null)
    {
      int i = paramViewGroup.getMeasuredHeight() - this.c;
      if (i >= 0) {
        return i;
      }
      return 0;
    }
    return 0;
  }
  
  private final boolean b(View paramView)
  {
    if ((paramView instanceof NestedScrollView))
    {
      paramView = (NestedScrollView)paramView;
      i = paramView.getScrollY();
      localView = paramView.getChildAt(0);
      Intrinsics.checkExpressionValueIsNotNull(localView, "view.getChildAt(0)");
      if (i == localView.getHeight() - paramView.getHeight()) {
        return true;
      }
    }
    while (((paramView instanceof RecyclerView)) && (paramView.canScrollVertically(1)))
    {
      int i;
      View localView;
      return false;
    }
    return true;
  }
  
  private final boolean c(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    return ((paramView instanceof LinearLayout)) && ((localLayoutParams instanceof CoordinatorLayout.LayoutParams)) && ((((CoordinatorLayout.LayoutParams)localLayoutParams).getBehavior() instanceof WSBehaviorSuite.HeaderBehavior));
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public boolean layoutDependsOn(@NotNull CoordinatorLayout paramCoordinatorLayout, @NotNull View paramView1, @NotNull View paramView2)
  {
    Intrinsics.checkParameterIsNotNull(paramCoordinatorLayout, "parent");
    Intrinsics.checkParameterIsNotNull(paramView1, "child");
    Intrinsics.checkParameterIsNotNull(paramView2, "dependency");
    return c(paramView2);
  }
  
  public boolean onDependentViewChanged(@NotNull CoordinatorLayout paramCoordinatorLayout, @NotNull View paramView1, @NotNull View paramView2)
  {
    Intrinsics.checkParameterIsNotNull(paramCoordinatorLayout, "parent");
    Intrinsics.checkParameterIsNotNull(paramView1, "child");
    Intrinsics.checkParameterIsNotNull(paramView2, "dependency");
    ViewCompat.offsetTopAndBottom(paramView1, paramView2.getBottom() - paramView1.getTop());
    return true;
  }
  
  public boolean onLayoutChild(@NotNull CoordinatorLayout paramCoordinatorLayout, @NotNull View paramView, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCoordinatorLayout, "parent");
    Intrinsics.checkParameterIsNotNull(paramView, "child");
    Object localObject1 = paramCoordinatorLayout.getDependencies(paramView);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "parent.getDependencies(child)");
    localObject1 = a((List)localObject1);
    if (localObject1 == null) {
      return super.onLayoutChild(paramCoordinatorLayout, paramView, paramInt);
    }
    Object localObject2 = paramView.getLayoutParams();
    if (localObject2 != null)
    {
      localObject2 = (CoordinatorLayout.LayoutParams)localObject2;
      paramInt = paramCoordinatorLayout.getPaddingLeft() + ((CoordinatorLayout.LayoutParams)localObject2).leftMargin;
      int i = ((View)localObject1).getBottom() + ((CoordinatorLayout.LayoutParams)localObject2).topMargin;
      paramView.layout(paramInt, i, paramView.getMeasuredWidth() + paramInt, paramView.getMeasuredHeight() + i);
      return true;
    }
    throw new TypeCastException("null cannot be cast to non-null type androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams");
  }
  
  public boolean onMeasureChild(@NotNull CoordinatorLayout paramCoordinatorLayout, @NotNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramCoordinatorLayout, "parent");
    Intrinsics.checkParameterIsNotNull(paramView, "child");
    int i = paramView.getLayoutParams().height;
    if ((i != -1) && (i != -2)) {
      return false;
    }
    paramInt3 = View.MeasureSpec.getSize(paramInt3);
    Object localObject = paramCoordinatorLayout.getDependencies(paramView);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "parent.getDependencies(child)");
    localObject = a((List)localObject);
    if (localObject != null) {
      paramInt3 -= ((View)localObject).getMeasuredHeight() - b((ViewGroup)localObject);
    }
    if (i == -1) {
      i = 1073741824;
    } else {
      i = -2147483648;
    }
    paramCoordinatorLayout.onMeasureChild(paramView, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt3, i), paramInt4);
    return true;
  }
  
  public void onNestedScroll(@NotNull CoordinatorLayout paramCoordinatorLayout, @NotNull View paramView1, @NotNull View paramView2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramCoordinatorLayout, "coordinatorLayout");
    Intrinsics.checkParameterIsNotNull(paramView1, "child");
    Intrinsics.checkParameterIsNotNull(paramView2, "target");
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "consumed");
    if (!b(this.b))
    {
      paramCoordinatorLayout = this.b;
      if (paramCoordinatorLayout == null) {
        Intrinsics.throwNpe();
      }
      paramCoordinatorLayout.scrollBy(0, -paramInt4);
      paramArrayOfInt[1] = paramInt4;
    }
  }
  
  public void onNestedScrollAccepted(@NotNull CoordinatorLayout paramCoordinatorLayout, @NotNull View paramView1, @NotNull View paramView2, @NotNull View paramView3, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramCoordinatorLayout, "coordinatorLayout");
    Intrinsics.checkParameterIsNotNull(paramView1, "child");
    Intrinsics.checkParameterIsNotNull(paramView2, "directTargetChild");
    Intrinsics.checkParameterIsNotNull(paramView3, "target");
    this.b = a(paramView1);
  }
  
  public boolean onStartNestedScroll(@NotNull CoordinatorLayout paramCoordinatorLayout, @NotNull View paramView1, @NotNull View paramView2, @NotNull View paramView3, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramCoordinatorLayout, "coordinatorLayout");
    Intrinsics.checkParameterIsNotNull(paramView1, "child");
    Intrinsics.checkParameterIsNotNull(paramView2, "directTargetChild");
    Intrinsics.checkParameterIsNotNull(paramView3, "target");
    return (c(paramView3)) && (paramInt1 == 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.ui.WSBehaviorSuite.ScrollingViewBehavior
 * JD-Core Version:    0.7.0.1
 */