package com.tencent.aelight.camera.ae.view.scrollingheader;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;
import java.util.List;

public class ScrollingHeaderLayout$ScrollingViewBehavior
  extends HeaderScrollingViewBehavior
{
  public ScrollingHeaderLayout$ScrollingViewBehavior() {}
  
  public ScrollingHeaderLayout$ScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(@NonNull View paramView1, @NonNull View paramView2)
  {
    Object localObject = ((CoordinatorLayout.LayoutParams)paramView2.getLayoutParams()).getBehavior();
    if ((localObject instanceof ScrollingHeaderLayout.BaseBehavior))
    {
      localObject = (ScrollingHeaderLayout.BaseBehavior)localObject;
      ViewCompat.offsetTopAndBottom(paramView1, paramView2.getBottom() - paramView1.getTop() + ScrollingHeaderLayout.BaseBehavior.a((ScrollingHeaderLayout.BaseBehavior)localObject) + aq_() - b(paramView2));
    }
  }
  
  float a(View paramView)
  {
    return 0.0F;
  }
  
  @Nullable
  public ScrollingHeaderLayout b(List<View> paramList)
  {
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)paramList.get(i);
      if ((localView instanceof ScrollingHeaderLayout)) {
        return (ScrollingHeaderLayout)localView;
      }
      i += 1;
    }
    return null;
  }
  
  int c(View paramView)
  {
    if ((paramView instanceof ScrollingHeaderLayout)) {
      return ((ScrollingHeaderLayout)paramView).getTotalScrollRange();
    }
    return super.c(paramView);
  }
  
  public boolean layoutDependsOn(CoordinatorLayout paramCoordinatorLayout, View paramView1, View paramView2)
  {
    return paramView2 instanceof ScrollingHeaderLayout;
  }
  
  public boolean onDependentViewChanged(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2)
  {
    a(paramView1, paramView2);
    return false;
  }
  
  public void onDependentViewRemoved(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView1, @NonNull View paramView2)
  {
    if ((paramView2 instanceof ScrollingHeaderLayout))
    {
      ViewCompat.removeAccessibilityAction(paramCoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
      ViewCompat.removeAccessibilityAction(paramCoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
    }
  }
  
  public boolean onRequestChildRectangleOnScreen(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView, @NonNull Rect paramRect, boolean paramBoolean)
  {
    if (b(paramCoordinatorLayout.getDependencies(paramView)) != null)
    {
      paramRect.offset(paramView.getLeft(), paramView.getTop());
      this.a.set(0, 0, paramCoordinatorLayout.getWidth(), paramCoordinatorLayout.getHeight());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.scrollingheader.ScrollingHeaderLayout.ScrollingViewBehavior
 * JD-Core Version:    0.7.0.1
 */