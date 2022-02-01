package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.LayoutParams;
import androidx.core.view.ViewCompat;
import com.google.android.material.R.styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.util.List;

public class FloatingActionButton$BaseBehavior<T extends FloatingActionButton>
  extends CoordinatorLayout.Behavior<T>
{
  private Rect a;
  private FloatingActionButton.OnVisibilityChangedListener b;
  private boolean c;
  
  public FloatingActionButton$BaseBehavior()
  {
    this.c = true;
  }
  
  public FloatingActionButton$BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cV);
    this.c = paramContext.getBoolean(R.styleable.cW, true);
    paramContext.recycle();
  }
  
  private void a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull FloatingActionButton paramFloatingActionButton)
  {
    Rect localRect = paramFloatingActionButton.b;
    if ((localRect != null) && (localRect.centerX() > 0) && (localRect.centerY() > 0))
    {
      CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams();
      int i = paramFloatingActionButton.getRight();
      int k = paramCoordinatorLayout.getWidth();
      int m = localLayoutParams.rightMargin;
      int j = 0;
      if (i >= k - m) {
        i = localRect.right;
      } else if (paramFloatingActionButton.getLeft() <= localLayoutParams.leftMargin) {
        i = -localRect.left;
      } else {
        i = 0;
      }
      if (paramFloatingActionButton.getBottom() >= paramCoordinatorLayout.getHeight() - localLayoutParams.bottomMargin) {
        j = localRect.bottom;
      } else if (paramFloatingActionButton.getTop() <= localLayoutParams.topMargin) {
        j = -localRect.top;
      }
      if (j != 0) {
        ViewCompat.offsetTopAndBottom(paramFloatingActionButton, j);
      }
      if (i != 0) {
        ViewCompat.offsetLeftAndRight(paramFloatingActionButton, i);
      }
    }
  }
  
  private static boolean a(@NonNull View paramView)
  {
    paramView = paramView.getLayoutParams();
    if ((paramView instanceof CoordinatorLayout.LayoutParams)) {
      return ((CoordinatorLayout.LayoutParams)paramView).getBehavior() instanceof BottomSheetBehavior;
    }
    return false;
  }
  
  private boolean a(@NonNull View paramView, @NonNull FloatingActionButton paramFloatingActionButton)
  {
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams();
    if (!this.c) {
      return false;
    }
    if (localLayoutParams.getAnchorId() != paramView.getId()) {
      return false;
    }
    return paramFloatingActionButton.getUserSetVisibility() == 0;
  }
  
  private boolean a(CoordinatorLayout paramCoordinatorLayout, @NonNull AppBarLayout paramAppBarLayout, @NonNull FloatingActionButton paramFloatingActionButton)
  {
    if (!a(paramAppBarLayout, paramFloatingActionButton)) {
      return false;
    }
    if (this.a == null) {
      this.a = new Rect();
    }
    Rect localRect = this.a;
    DescendantOffsetUtils.b(paramCoordinatorLayout, paramAppBarLayout, localRect);
    if (localRect.bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
      paramFloatingActionButton.b(this.b, false);
    } else {
      paramFloatingActionButton.a(this.b, false);
    }
    return true;
  }
  
  private boolean b(@NonNull View paramView, @NonNull FloatingActionButton paramFloatingActionButton)
  {
    if (!a(paramView, paramFloatingActionButton)) {
      return false;
    }
    CoordinatorLayout.LayoutParams localLayoutParams = (CoordinatorLayout.LayoutParams)paramFloatingActionButton.getLayoutParams();
    if (paramView.getTop() < paramFloatingActionButton.getHeight() / 2 + localLayoutParams.topMargin) {
      paramFloatingActionButton.b(this.b, false);
    } else {
      paramFloatingActionButton.a(this.b, false);
    }
    return true;
  }
  
  public boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull FloatingActionButton paramFloatingActionButton, int paramInt)
  {
    List localList = paramCoordinatorLayout.getDependencies(paramFloatingActionButton);
    int j = localList.size();
    int i = 0;
    while (i < j)
    {
      View localView = (View)localList.get(i);
      if ((localView instanceof AppBarLayout) ? !a(paramCoordinatorLayout, (AppBarLayout)localView, paramFloatingActionButton) : (a(localView)) && (b(localView, paramFloatingActionButton))) {
        break;
      }
      i += 1;
    }
    paramCoordinatorLayout.onLayoutChild(paramFloatingActionButton, paramInt);
    a(paramCoordinatorLayout, paramFloatingActionButton);
    return true;
  }
  
  public boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull FloatingActionButton paramFloatingActionButton, @NonNull Rect paramRect)
  {
    paramCoordinatorLayout = paramFloatingActionButton.b;
    paramRect.set(paramFloatingActionButton.getLeft() + paramCoordinatorLayout.left, paramFloatingActionButton.getTop() + paramCoordinatorLayout.top, paramFloatingActionButton.getRight() - paramCoordinatorLayout.right, paramFloatingActionButton.getBottom() - paramCoordinatorLayout.bottom);
    return true;
  }
  
  public boolean a(CoordinatorLayout paramCoordinatorLayout, @NonNull FloatingActionButton paramFloatingActionButton, View paramView)
  {
    if ((paramView instanceof AppBarLayout)) {
      a(paramCoordinatorLayout, (AppBarLayout)paramView, paramFloatingActionButton);
    } else if (a(paramView)) {
      b(paramView, paramFloatingActionButton);
    }
    return false;
  }
  
  public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams.dodgeInsetEdges == 0) {
      paramLayoutParams.dodgeInsetEdges = 80;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
 * JD-Core Version:    0.7.0.1
 */