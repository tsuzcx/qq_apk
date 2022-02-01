package com.tencent.aelight.camera.ae.view.scrollingheader;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ScrollingHeaderLayout
  extends LinearLayout
  implements CoordinatorLayout.AttachedBehavior
{
  private int a = -1;
  private int b = -1;
  private int c = -1;
  @Nullable
  private WindowInsetsCompat d;
  
  public ScrollingHeaderLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ScrollingHeaderLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ScrollingHeaderLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    ViewCompat.setOnApplyWindowInsetsListener(this, new ScrollingHeaderLayout.1(this));
  }
  
  private void c()
  {
    setWillNotDraw(d() ^ true);
  }
  
  private boolean d()
  {
    return false;
  }
  
  private void e()
  {
    this.a = -1;
    this.b = -1;
    this.c = -1;
  }
  
  private boolean f()
  {
    int i = getChildCount();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i > 0)
    {
      View localView = getChildAt(0);
      bool1 = bool2;
      if (localView.getVisibility() != 8)
      {
        bool1 = bool2;
        if (!ViewCompat.getFitsSystemWindows(localView)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  WindowInsetsCompat a(WindowInsetsCompat paramWindowInsetsCompat)
  {
    WindowInsetsCompat localWindowInsetsCompat;
    if (ViewCompat.getFitsSystemWindows(this)) {
      localWindowInsetsCompat = paramWindowInsetsCompat;
    } else {
      localWindowInsetsCompat = null;
    }
    if (!ObjectsCompat.equals(this.d, localWindowInsetsCompat))
    {
      this.d = localWindowInsetsCompat;
      c();
      requestLayout();
    }
    return paramWindowInsetsCompat;
  }
  
  boolean a()
  {
    return false;
  }
  
  boolean b()
  {
    return getTotalScrollRange() != 0;
  }
  
  @NonNull
  public CoordinatorLayout.Behavior<ScrollingHeaderLayout> getBehavior()
  {
    return new ScrollingHeaderLayout.Behavior();
  }
  
  int getDownNestedPreScrollRange()
  {
    int i = this.b;
    if (i != -1) {
      return i;
    }
    i = Math.max(0, 0);
    this.b = i;
    return i;
  }
  
  int getDownNestedScrollRange()
  {
    int i = this.c;
    if (i != -1) {
      return i;
    }
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = localView.getMeasuredHeight() + (localLayoutParams.topMargin + localLayoutParams.bottomMargin) + 0 - ViewCompat.getMinimumHeight(localView);
    }
    else
    {
      i = 0;
    }
    i = Math.max(0, i);
    this.c = i;
    return i;
  }
  
  @VisibleForTesting
  final int getTopInset()
  {
    WindowInsetsCompat localWindowInsetsCompat = this.d;
    if (localWindowInsetsCompat != null) {
      return localWindowInsetsCompat.getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public final int getTotalScrollRange()
  {
    int i = this.a;
    if (i != -1) {
      return i;
    }
    if (getChildCount() > 0)
    {
      View localView = getChildAt(0);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      i = localView.getMeasuredHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin + 0 - ViewCompat.getMinimumHeight(localView);
    }
    else
    {
      i = 0;
    }
    i = Math.max(0, i);
    this.a = i;
    return i;
  }
  
  int getUpNestedPreScrollRange()
  {
    return getTotalScrollRange();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((ViewCompat.getFitsSystemWindows(this)) && (f()))
    {
      paramInt2 = getTopInset();
      paramInt1 = getChildCount() - 1;
      while (paramInt1 >= 0)
      {
        ViewCompat.offsetTopAndBottom(getChildAt(paramInt1), paramInt2);
        paramInt1 -= 1;
      }
    }
    e();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i = View.MeasureSpec.getMode(paramInt2);
    if ((i != 1073741824) && (ViewCompat.getFitsSystemWindows(this)) && (f()))
    {
      paramInt1 = getMeasuredHeight();
      if (i != -2147483648)
      {
        if (i == 0) {
          paramInt1 += getTopInset();
        }
      }
      else {
        paramInt1 = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(paramInt2));
      }
      setMeasuredDimension(getMeasuredWidth(), paramInt1);
    }
    e();
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt == 1)
    {
      super.setOrientation(paramInt);
      return;
    }
    throw new IllegalArgumentException("ScrollingHeaderLayout is always vertical and does not support horizontal orientation");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.scrollingheader.ScrollingHeaderLayout
 * JD-Core Version:    0.7.0.1
 */