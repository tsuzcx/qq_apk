package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import com.google.android.material.R.styleable;
import java.util.List;

public class AppBarLayout$ScrollingViewBehavior
  extends HeaderScrollingViewBehavior
{
  public AppBarLayout$ScrollingViewBehavior() {}
  
  public AppBarLayout$ScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.fU);
    b(paramContext.getDimensionPixelSize(R.styleable.fV, 0));
    paramContext.recycle();
  }
  
  private static int a(@NonNull AppBarLayout paramAppBarLayout)
  {
    paramAppBarLayout = ((CoordinatorLayout.LayoutParams)paramAppBarLayout.getLayoutParams()).getBehavior();
    if ((paramAppBarLayout instanceof AppBarLayout.BaseBehavior)) {
      return ((AppBarLayout.BaseBehavior)paramAppBarLayout).a();
    }
    return 0;
  }
  
  private void a(@NonNull View paramView1, @NonNull View paramView2)
  {
    Object localObject = ((CoordinatorLayout.LayoutParams)paramView2.getLayoutParams()).getBehavior();
    if ((localObject instanceof AppBarLayout.BaseBehavior))
    {
      localObject = (AppBarLayout.BaseBehavior)localObject;
      ViewCompat.offsetTopAndBottom(paramView1, paramView2.getBottom() - paramView1.getTop() + AppBarLayout.BaseBehavior.a((AppBarLayout.BaseBehavior)localObject) + c() - c(paramView2));
    }
  }
  
  private void b(View paramView1, View paramView2)
  {
    if ((paramView2 instanceof AppBarLayout))
    {
      paramView2 = (AppBarLayout)paramView2;
      if (paramView2.d()) {
        paramView2.a(paramView2.a(paramView1));
      }
    }
  }
  
  float a(View paramView)
  {
    if ((paramView instanceof AppBarLayout))
    {
      paramView = (AppBarLayout)paramView;
      int j = paramView.getTotalScrollRange();
      int k = paramView.getDownNestedPreScrollRange();
      int i = a(paramView);
      if ((k != 0) && (j + i <= k)) {
        return 0.0F;
      }
      j -= k;
      if (j != 0) {
        return i / j + 1.0F;
      }
    }
    return 0.0F;
  }
  
  @Nullable
  AppBarLayout a(@NonNull List<View> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)paramList.get(i);
      if ((localView instanceof AppBarLayout)) {
        return (AppBarLayout)localView;
      }
      i += 1;
    }
    return null;
  }
  
  int b(View paramView)
  {
    if ((paramView instanceof AppBarLayout)) {
      return ((AppBarLayout)paramView).getTotalScrollRange();
    }
    return super.b(paramView);
  }
  
  public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    return paramView2 instanceof AppBarLayout;
  }
  
  public boolean onDependentViewChanged(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2)
  {
    a(paramView1, paramView2);
    b(paramView1, paramView2);
    return false;
  }
  
  public void onDependentViewRemoved(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2)
  {
    if ((paramView2 instanceof AppBarLayout))
    {
      ViewCompat.removeAccessibilityAction(paramCoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
      ViewCompat.removeAccessibilityAction(paramCoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
    }
  }
  
  public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView, @NonNull Rect paramRect, boolean paramBoolean)
  {
    AppBarLayout localAppBarLayout = a(paramCoordinatorLayout.getDependencies(paramView));
    if (localAppBarLayout != null)
    {
      paramRect.offset(paramView.getLeft(), paramView.getTop());
      paramView = this.a;
      paramView.set(0, 0, paramCoordinatorLayout.getWidth(), paramCoordinatorLayout.getHeight());
      if (!paramView.contains(paramRect))
      {
        localAppBarLayout.setExpanded(false, paramBoolean ^ true);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior
 * JD-Core Version:    0.7.0.1
 */