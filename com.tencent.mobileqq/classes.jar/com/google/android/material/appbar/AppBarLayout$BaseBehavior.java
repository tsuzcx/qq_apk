package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Interpolator;
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
import com.google.android.material.animation.AnimationUtils;
import java.lang.ref.WeakReference;
import java.util.List;

public class AppBarLayout$BaseBehavior<T extends AppBarLayout>
  extends HeaderBehavior<T>
{
  private int b;
  private int c;
  private ValueAnimator d;
  private int e = -1;
  private boolean f;
  private float g;
  @Nullable
  private WeakReference<View> h;
  private AppBarLayout.BaseBehavior.BaseDragCallback i;
  
  public AppBarLayout$BaseBehavior() {}
  
  public AppBarLayout$BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a(@NonNull T paramT, int paramInt)
  {
    int i2 = paramT.getChildCount();
    int j = 0;
    while (j < i2)
    {
      Object localObject = paramT.getChildAt(j);
      int i1 = ((View)localObject).getTop();
      int n = ((View)localObject).getBottom();
      localObject = (AppBarLayout.LayoutParams)((View)localObject).getLayoutParams();
      int m = i1;
      int k = n;
      if (a(((AppBarLayout.LayoutParams)localObject).a(), 32))
      {
        m = i1 - ((AppBarLayout.LayoutParams)localObject).topMargin;
        k = n + ((AppBarLayout.LayoutParams)localObject).bottomMargin;
      }
      n = -paramInt;
      if ((m <= n) && (k >= n)) {
        return j;
      }
      j += 1;
    }
    return -1;
  }
  
  @Nullable
  private View a(@NonNull CoordinatorLayout paramCoordinatorLayout)
  {
    int k = paramCoordinatorLayout.getChildCount();
    int j = 0;
    while (j < k)
    {
      View localView = paramCoordinatorLayout.getChildAt(j);
      if ((!(localView instanceof NestedScrollingChild)) && (!(localView instanceof ListView)))
      {
        if ((localView instanceof ScrollView)) {
          return localView;
        }
        j += 1;
      }
      else
      {
        return localView;
      }
    }
    return null;
  }
  
  private void a(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, int paramInt, float paramFloat)
  {
    int j = Math.abs(a() - paramInt);
    paramFloat = Math.abs(paramFloat);
    if (paramFloat > 0.0F) {
      j = Math.round(j / paramFloat * 1000.0F) * 3;
    } else {
      j = (int)((j / paramT.getHeight() + 1.0F) * 150.0F);
    }
    a(paramCoordinatorLayout, paramT, paramInt, j);
  }
  
  private void a(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2)
  {
    int j = a();
    if (j == paramInt1)
    {
      paramCoordinatorLayout = this.d;
      if ((paramCoordinatorLayout != null) && (paramCoordinatorLayout.isRunning())) {
        this.d.cancel();
      }
      return;
    }
    ValueAnimator localValueAnimator = this.d;
    if (localValueAnimator == null)
    {
      this.d = new ValueAnimator();
      this.d.setInterpolator(AnimationUtils.e);
      this.d.addUpdateListener(new AppBarLayout.BaseBehavior.1(this, paramCoordinatorLayout, paramT));
    }
    else
    {
      localValueAnimator.cancel();
    }
    this.d.setDuration(Math.min(paramInt2, 600));
    this.d.setIntValues(new int[] { j, paramInt1 });
    this.d.start();
  }
  
  private void a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    View localView = c(paramT, paramInt1);
    if (localView != null)
    {
      int j = ((AppBarLayout.LayoutParams)localView.getLayoutParams()).a();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((j & 0x1) != 0)
      {
        int k = ViewCompat.getMinimumHeight(localView);
        if ((paramInt2 > 0) && ((j & 0xC) != 0))
        {
          bool1 = bool2;
          if (-paramInt1 < localView.getBottom() - k - paramT.getTopInset()) {}
        }
        else
        {
          do
          {
            bool1 = true;
            break;
            bool1 = bool2;
            if ((j & 0x2) == 0) {
              break;
            }
            bool1 = bool2;
          } while (-paramInt1 >= localView.getBottom() - k - paramT.getTopInset());
        }
      }
      if (paramT.d()) {
        bool1 = paramT.a(a(paramCoordinatorLayout));
      }
      bool1 = paramT.a(bool1);
      if ((paramBoolean) || ((bool1) && (e(paramCoordinatorLayout, paramT)))) {
        paramT.jumpDrawablesToCurrentState();
      }
    }
  }
  
  private void a(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, @NonNull AccessibilityNodeInfoCompat.AccessibilityActionCompat paramAccessibilityActionCompat, boolean paramBoolean)
  {
    ViewCompat.replaceAccessibilityAction(paramCoordinatorLayout, paramAccessibilityActionCompat, null, new AppBarLayout.BaseBehavior.3(this, paramT, paramBoolean));
  }
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) == paramInt2;
  }
  
  private boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, @NonNull View paramView)
  {
    return (paramT.c()) && (paramCoordinatorLayout.getHeight() - paramView.getHeight() <= paramT.getHeight());
  }
  
  private int b(@NonNull T paramT, int paramInt)
  {
    int m = Math.abs(paramInt);
    int n = paramT.getChildCount();
    int k = 0;
    int j = 0;
    while (j < n)
    {
      View localView = paramT.getChildAt(j);
      AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
      Interpolator localInterpolator = localLayoutParams.b();
      if ((m >= localView.getTop()) && (m <= localView.getBottom()))
      {
        if (localInterpolator == null) {
          break;
        }
        n = localLayoutParams.a();
        j = k;
        if ((n & 0x1) != 0)
        {
          k = 0 + (localView.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
          j = k;
          if ((n & 0x2) != 0) {
            j = k - ViewCompat.getMinimumHeight(localView);
          }
        }
        k = j;
        if (ViewCompat.getFitsSystemWindows(localView)) {
          k = j - paramT.getTopInset();
        }
        if (k <= 0) {
          break;
        }
        j = localView.getTop();
        float f1 = k;
        j = Math.round(f1 * localInterpolator.getInterpolation((m - j) / f1));
        return Integer.signum(paramInt) * (localView.getTop() + j);
      }
      j += 1;
    }
    return paramInt;
  }
  
  private void b(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, @NonNull View paramView)
  {
    if ((a() != -paramT.getTotalScrollRange()) && (paramView.canScrollVertically(1))) {
      a(paramCoordinatorLayout, paramT, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
    }
    if (a() != 0) {
      if (paramView.canScrollVertically(-1))
      {
        int j = -paramT.getDownNestedPreScrollRange();
        if (j != 0) {
          ViewCompat.replaceAccessibilityAction(paramCoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AppBarLayout.BaseBehavior.2(this, paramCoordinatorLayout, paramT, paramView, j));
        }
      }
      else
      {
        a(paramCoordinatorLayout, paramT, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
      }
    }
  }
  
  @Nullable
  private static View c(@NonNull AppBarLayout paramAppBarLayout, int paramInt)
  {
    int j = Math.abs(paramInt);
    int k = paramAppBarLayout.getChildCount();
    paramInt = 0;
    while (paramInt < k)
    {
      View localView = paramAppBarLayout.getChildAt(paramInt);
      if ((j >= localView.getTop()) && (j <= localView.getBottom())) {
        return localView;
      }
      paramInt += 1;
    }
    return null;
  }
  
  private void c(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT)
  {
    int i1 = a();
    int m = a(paramT, i1);
    if (m >= 0)
    {
      View localView = paramT.getChildAt(m);
      AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
      int i2 = localLayoutParams.a();
      if ((i2 & 0x11) == 17)
      {
        int n = -localView.getTop();
        int j = -localView.getBottom();
        int k = j;
        if (m == paramT.getChildCount() - 1) {
          k = j + paramT.getTopInset();
        }
        if (a(i2, 2))
        {
          j = k + ViewCompat.getMinimumHeight(localView);
          m = n;
        }
        else
        {
          m = n;
          j = k;
          if (a(i2, 5))
          {
            j = ViewCompat.getMinimumHeight(localView) + k;
            if (i1 < j)
            {
              m = j;
              j = k;
            }
            else
            {
              m = n;
            }
          }
        }
        n = m;
        k = j;
        if (a(i2, 32))
        {
          n = m + localLayoutParams.topMargin;
          k = j - localLayoutParams.bottomMargin;
        }
        j = n;
        if (i1 < (k + n) / 2) {
          j = k;
        }
        a(paramCoordinatorLayout, paramT, MathUtils.clamp(j, -paramT.getTotalScrollRange(), 0), 0.0F);
      }
    }
  }
  
  private void d(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT)
  {
    ViewCompat.removeAccessibilityAction(paramCoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
    ViewCompat.removeAccessibilityAction(paramCoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
    View localView = a(paramCoordinatorLayout);
    if (localView != null)
    {
      if (paramT.getTotalScrollRange() == 0) {
        return;
      }
      if (!(((CoordinatorLayout.LayoutParams)localView.getLayoutParams()).getBehavior() instanceof AppBarLayout.ScrollingViewBehavior)) {
        return;
      }
      b(paramCoordinatorLayout, paramT, localView);
    }
  }
  
  private boolean e(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT)
  {
    paramCoordinatorLayout = paramCoordinatorLayout.getDependents(paramT);
    int k = paramCoordinatorLayout.size();
    boolean bool = false;
    int j = 0;
    while (j < k)
    {
      paramT = ((CoordinatorLayout.LayoutParams)((View)paramCoordinatorLayout.get(j)).getLayoutParams()).getBehavior();
      if ((paramT instanceof AppBarLayout.ScrollingViewBehavior))
      {
        if (((AppBarLayout.ScrollingViewBehavior)paramT).d() != 0) {
          bool = true;
        }
        return bool;
      }
      j += 1;
    }
    return false;
  }
  
  int a()
  {
    return b() + this.b;
  }
  
  int a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, int paramInt1, int paramInt2, int paramInt3)
  {
    int k = a();
    int j = 0;
    if ((paramInt2 != 0) && (k >= paramInt2) && (k <= paramInt3))
    {
      paramInt2 = MathUtils.clamp(paramInt1, paramInt2, paramInt3);
      paramInt1 = j;
      if (k != paramInt2)
      {
        if (paramT.b()) {
          paramInt1 = b(paramT, paramInt2);
        } else {
          paramInt1 = paramInt2;
        }
        boolean bool = a(paramInt1);
        paramInt3 = k - paramInt2;
        this.b = (paramInt2 - paramInt1);
        if ((!bool) && (paramT.b())) {
          paramCoordinatorLayout.dispatchDependentViewsChanged(paramT);
        }
        paramT.a(b());
        if (paramInt2 < k) {
          paramInt1 = -1;
        } else {
          paramInt1 = 1;
        }
        a(paramCoordinatorLayout, paramT, paramInt2, paramInt1, false);
        paramInt1 = paramInt3;
      }
    }
    else
    {
      this.b = 0;
      paramInt1 = j;
    }
    d(paramCoordinatorLayout, paramT);
    return paramInt1;
  }
  
  void a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT)
  {
    c(paramCoordinatorLayout, paramT);
    if (paramT.d()) {
      paramT.a(paramT.a(a(paramCoordinatorLayout)));
    }
  }
  
  public void a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof AppBarLayout.BaseBehavior.SavedState))
    {
      paramParcelable = (AppBarLayout.BaseBehavior.SavedState)paramParcelable;
      super.onRestoreInstanceState(paramCoordinatorLayout, paramT, paramParcelable.getSuperState());
      this.e = paramParcelable.a;
      this.g = paramParcelable.b;
      this.f = paramParcelable.c;
      return;
    }
    super.onRestoreInstanceState(paramCoordinatorLayout, paramT, paramParcelable);
    this.e = -1;
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, View paramView, int paramInt)
  {
    if ((this.c == 0) || (paramInt == 1))
    {
      c(paramCoordinatorLayout, paramT);
      if (paramT.d()) {
        paramT.a(paramT.a(paramView));
      }
    }
    this.h = new WeakReference(paramView);
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    if (paramInt4 < 0) {
      paramArrayOfInt[1] = b(paramCoordinatorLayout, paramT, paramInt4, -paramT.getDownNestedScrollRange(), 0);
    }
    if (paramInt4 == 0) {
      d(paramCoordinatorLayout, paramT);
    }
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 < 0)
      {
        paramInt3 = -paramT.getTotalScrollRange();
        int j = paramT.getDownNestedPreScrollRange();
        paramInt1 = paramInt3;
        paramInt3 = j + paramInt3;
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
    if (paramT.d()) {
      paramT.a(paramT.a(paramView));
    }
  }
  
  public boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, int paramInt)
  {
    boolean bool = super.onLayoutChild(paramCoordinatorLayout, paramT, paramInt);
    int j = paramT.getPendingAction();
    paramInt = this.e;
    if ((paramInt >= 0) && ((j & 0x8) == 0))
    {
      View localView = paramT.getChildAt(paramInt);
      j = -localView.getBottom();
      if (this.f) {
        paramInt = ViewCompat.getMinimumHeight(localView) + paramT.getTopInset();
      } else {
        paramInt = Math.round(localView.getHeight() * this.g);
      }
      a_(paramCoordinatorLayout, paramT, j + paramInt);
    }
    else if (j != 0)
    {
      if ((j & 0x4) != 0) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if ((j & 0x2) != 0)
      {
        j = -paramT.getUpNestedPreScrollRange();
        if (paramInt != 0) {
          a(paramCoordinatorLayout, paramT, j, 0.0F);
        } else {
          a_(paramCoordinatorLayout, paramT, j);
        }
      }
      else if ((j & 0x1) != 0)
      {
        if (paramInt != 0) {
          a(paramCoordinatorLayout, paramT, 0, 0.0F);
        } else {
          a_(paramCoordinatorLayout, paramT, 0);
        }
      }
    }
    paramT.e();
    this.e = -1;
    a(MathUtils.clamp(b(), -paramT.getTotalScrollRange(), 0));
    a(paramCoordinatorLayout, paramT, b(), 0, true);
    paramT.a(b());
    d(paramCoordinatorLayout, paramT);
    return bool;
  }
  
  public boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((CoordinatorLayout.LayoutParams)paramT.getLayoutParams()).height == -2)
    {
      paramCoordinatorLayout.onMeasureChild(paramT, paramInt1, paramInt2, View.MeasureSpec.makeMeasureSpec(0, 0), paramInt4);
      return true;
    }
    return super.onMeasureChild(paramCoordinatorLayout, paramT, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, @NonNull View paramView1, View paramView2, int paramInt1, int paramInt2)
  {
    boolean bool;
    if (((paramInt1 & 0x2) != 0) && ((paramT.d()) || (a(paramCoordinatorLayout, paramT, paramView1)))) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      paramCoordinatorLayout = this.d;
      if (paramCoordinatorLayout != null) {
        paramCoordinatorLayout.cancel();
      }
    }
    this.h = null;
    this.c = paramInt2;
    return bool;
  }
  
  boolean a(T paramT)
  {
    AppBarLayout.BaseBehavior.BaseDragCallback localBaseDragCallback = this.i;
    if (localBaseDragCallback != null) {
      return localBaseDragCallback.a(paramT);
    }
    paramT = this.h;
    boolean bool = true;
    if (paramT != null)
    {
      paramT = (View)paramT.get();
      if ((paramT != null) && (paramT.isShown()) && (!paramT.canScrollVertically(-1))) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  int b(@NonNull T paramT)
  {
    return -paramT.getDownNestedScrollRange();
  }
  
  public Parcelable b(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT)
  {
    Object localObject = super.onSaveInstanceState(paramCoordinatorLayout, paramT);
    int k = b();
    int m = paramT.getChildCount();
    boolean bool = false;
    int j = 0;
    while (j < m)
    {
      paramCoordinatorLayout = paramT.getChildAt(j);
      int n = paramCoordinatorLayout.getBottom() + k;
      if ((paramCoordinatorLayout.getTop() + k <= 0) && (n >= 0))
      {
        localObject = new AppBarLayout.BaseBehavior.SavedState((Parcelable)localObject);
        ((AppBarLayout.BaseBehavior.SavedState)localObject).a = j;
        if (n == ViewCompat.getMinimumHeight(paramCoordinatorLayout) + paramT.getTopInset()) {
          bool = true;
        }
        ((AppBarLayout.BaseBehavior.SavedState)localObject).c = bool;
        ((AppBarLayout.BaseBehavior.SavedState)localObject).b = (n / paramCoordinatorLayout.getHeight());
        return localObject;
      }
      j += 1;
    }
    return localObject;
  }
  
  int c(@NonNull T paramT)
  {
    return paramT.getTotalScrollRange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout.BaseBehavior
 * JD-Core Version:    0.7.0.1
 */