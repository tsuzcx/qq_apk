package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.List;

abstract class HeaderScrollingViewBehavior
  extends ViewOffsetBehavior<View>
{
  final Rect a = new Rect();
  final Rect b = new Rect();
  private int c = 0;
  private int d;
  
  public HeaderScrollingViewBehavior() {}
  
  public HeaderScrollingViewBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private static int c(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = 8388659;
    }
    return i;
  }
  
  float a(View paramView)
  {
    return 1.0F;
  }
  
  protected void a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView, int paramInt)
  {
    View localView = b(paramCoordinatorLayout.getDependencies(paramView));
    if (localView != null)
    {
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramView.getLayoutParams();
      Rect localRect = this.a;
      localRect.set(paramCoordinatorLayout.getPaddingLeft() + localLayoutParams.leftMargin, localView.getBottom() + localLayoutParams.topMargin, paramCoordinatorLayout.getWidth() - paramCoordinatorLayout.getPaddingRight() - localLayoutParams.rightMargin, paramCoordinatorLayout.getHeight() + localView.getBottom() - paramCoordinatorLayout.getPaddingBottom() - localLayoutParams.bottomMargin);
      WindowInsetsCompat localWindowInsetsCompat = paramCoordinatorLayout.getLastWindowInsets();
      if ((localWindowInsetsCompat != null) && (ViewCompat.getFitsSystemWindows(paramCoordinatorLayout)) && (!ViewCompat.getFitsSystemWindows(paramView)))
      {
        localRect.left += localWindowInsetsCompat.getSystemWindowInsetLeft();
        localRect.right -= localWindowInsetsCompat.getSystemWindowInsetRight();
      }
      paramCoordinatorLayout = this.b;
      GravityCompat.apply(c(localLayoutParams.gravity), paramView.getMeasuredWidth(), paramView.getMeasuredHeight(), localRect, paramCoordinatorLayout, paramInt);
      paramInt = c(localView);
      paramView.layout(paramCoordinatorLayout.left, paramCoordinatorLayout.top - paramInt, paramCoordinatorLayout.right, paramCoordinatorLayout.bottom - paramInt);
      this.c = (paramCoordinatorLayout.top - localView.getBottom());
      return;
    }
    super.a(paramCoordinatorLayout, paramView, paramInt);
    this.c = 0;
  }
  
  protected boolean a()
  {
    return false;
  }
  
  int b(@NonNull View paramView)
  {
    return paramView.getMeasuredHeight();
  }
  
  @Nullable
  abstract View b(List<View> paramList);
  
  public final void b(int paramInt)
  {
    this.d = paramInt;
  }
  
  final int c()
  {
    return this.c;
  }
  
  final int c(View paramView)
  {
    if (this.d == 0) {
      return 0;
    }
    float f = a(paramView);
    int i = this.d;
    return MathUtils.clamp((int)(f * i), 0, i);
  }
  
  public final int d()
  {
    return this.d;
  }
  
  public boolean onMeasureChild(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramView.getLayoutParams().height;
    if ((j == -1) || (j == -2))
    {
      View localView = b(paramCoordinatorLayout.getDependencies(paramView));
      if (localView != null)
      {
        int i = View.MeasureSpec.getSize(paramInt3);
        if (i > 0)
        {
          paramInt3 = i;
          if (ViewCompat.getFitsSystemWindows(localView))
          {
            WindowInsetsCompat localWindowInsetsCompat = paramCoordinatorLayout.getLastWindowInsets();
            paramInt3 = i;
            if (localWindowInsetsCompat != null) {
              paramInt3 = i + (localWindowInsetsCompat.getSystemWindowInsetTop() + localWindowInsetsCompat.getSystemWindowInsetBottom());
            }
          }
        }
        else
        {
          paramInt3 = paramCoordinatorLayout.getHeight();
        }
        paramInt3 += b(localView);
        i = localView.getMeasuredHeight();
        if (a()) {
          paramView.setTranslationY(-i);
        } else {
          paramInt3 -= i;
        }
        if (j == -1) {
          i = 1073741824;
        } else {
          i = -2147483648;
        }
        paramCoordinatorLayout.onMeasureChild(paramView, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt3, i), paramInt4);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.appbar.HeaderScrollingViewBehavior
 * JD-Core Version:    0.7.0.1
 */