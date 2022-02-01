package com.tencent.aelight.camera.ae.view.scrollingheader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat;

public class ScrollingHeaderLayout$BaseBehavior<T extends ScrollingHeaderLayout>
  extends HeaderBehavior<T>
{
  private int b;
  private int c;
  
  public ScrollingHeaderLayout$BaseBehavior() {}
  
  public ScrollingHeaderLayout$BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  @Nullable
  private View a(@NonNull CoordinatorLayout paramCoordinatorLayout)
  {
    int j = paramCoordinatorLayout.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = paramCoordinatorLayout.getChildAt(i);
      if ((!(localView instanceof NestedScrollingChild)) && (!(localView instanceof ListView)))
      {
        if ((localView instanceof ScrollView)) {
          return localView;
        }
        i += 1;
      }
      else
      {
        return localView;
      }
    }
    return null;
  }
  
  private void a(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat paramAccessibilityActionCompat, boolean paramBoolean)
  {
    ViewCompat.replaceAccessibilityAction(paramCoordinatorLayout, paramAccessibilityActionCompat, null, new ScrollingHeaderLayout.BaseBehavior.2(this));
  }
  
  private boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, @NonNull View paramView)
  {
    return (paramT.b()) && (paramCoordinatorLayout.getHeight() - paramView.getHeight() <= paramT.getHeight());
  }
  
  private void b(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT) {}
  
  private void b(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, @NonNull View paramView)
  {
    if ((a() != -paramT.getTotalScrollRange()) && (paramView.canScrollVertically(1))) {
      a(paramCoordinatorLayout, paramT, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
    }
    if (a() != 0) {
      if (paramView.canScrollVertically(-1))
      {
        int i = -paramT.getDownNestedPreScrollRange();
        if (i != 0) {
          ViewCompat.replaceAccessibilityAction(paramCoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new ScrollingHeaderLayout.BaseBehavior.1(this, paramCoordinatorLayout, paramT, paramView, i));
        }
      }
      else
      {
        a(paramCoordinatorLayout, paramT, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
      }
    }
  }
  
  private void c(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT)
  {
    ViewCompat.removeAccessibilityAction(paramCoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
    ViewCompat.removeAccessibilityAction(paramCoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
    View localView = a(paramCoordinatorLayout);
    if (localView != null)
    {
      if (paramT.getTotalScrollRange() == 0) {
        return;
      }
      if (!(((CoordinatorLayout.LayoutParams)localView.getLayoutParams()).getBehavior() instanceof ScrollingHeaderLayout.ScrollingViewBehavior)) {
        return;
      }
      b(paramCoordinatorLayout, paramT, localView);
    }
  }
  
  int a()
  {
    return b() + this.b;
  }
  
  int a(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = a();
    int i = 0;
    if ((paramInt2 != 0) && (j >= paramInt2) && (j <= paramInt3))
    {
      paramInt3 = MathUtils.clamp(paramInt1, paramInt2, paramInt3);
      paramInt1 = i;
      if (j != paramInt3)
      {
        boolean bool = a(paramInt3);
        paramInt2 = j - paramInt3;
        this.b = (paramInt3 - paramInt3);
        paramInt1 = paramInt2;
        if (!bool)
        {
          paramInt1 = paramInt2;
          if (paramT.a())
          {
            paramCoordinatorLayout.dispatchDependentViewsChanged(paramT);
            paramInt1 = paramInt2;
          }
        }
      }
    }
    else
    {
      this.b = 0;
      paramInt1 = i;
    }
    c(paramCoordinatorLayout, paramT);
    return paramInt1;
  }
  
  int a(@NonNull T paramT)
  {
    return -paramT.getDownNestedScrollRange();
  }
  
  void a(CoordinatorLayout paramCoordinatorLayout, T paramT)
  {
    b(paramCoordinatorLayout, paramT);
  }
  
  public void a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, @NonNull View paramView, int paramInt)
  {
    if ((this.c == 0) || (paramInt == 1)) {
      b(paramCoordinatorLayout, paramT);
    }
  }
  
  public void a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, @NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, @NonNull int[] paramArrayOfInt)
  {
    if (paramInt4 < 0) {
      paramArrayOfInt[1] = b(paramCoordinatorLayout, paramT, paramInt4, -paramT.getDownNestedScrollRange(), 0);
    }
    if (paramInt4 == 0) {
      c(paramCoordinatorLayout, paramT);
    }
  }
  
  public void a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, @NonNull View paramView, int paramInt1, int paramInt2, @NonNull int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 < 0)
      {
        paramInt3 = -paramT.getTotalScrollRange();
        int i = paramT.getDownNestedPreScrollRange();
        paramInt1 = paramInt3;
        paramInt3 = i + paramInt3;
      }
      else
      {
        paramInt1 = -paramT.getUpNestedPreScrollRange();
        paramInt3 = 0;
      }
      if (paramInt1 != paramInt3) {
        paramArrayOfInt[1] = b(paramCoordinatorLayout, paramT, paramInt2, paramInt1, paramInt3);
      }
    }
  }
  
  public boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, @NonNull View paramView1, @NonNull View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (((paramInt1 & 0x2) != 0) && (a(paramCoordinatorLayout, paramT, paramView1))) {
      bool = true;
    } else {
      bool = false;
    }
    this.c = paramInt2;
    return bool;
  }
  
  int b(@NonNull T paramT)
  {
    return paramT.getTotalScrollRange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.scrollingheader.ScrollingHeaderLayout.BaseBehavior
 * JD-Core Version:    0.7.0.1
 */