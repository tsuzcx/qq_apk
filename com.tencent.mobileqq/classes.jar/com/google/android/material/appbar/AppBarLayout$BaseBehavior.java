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
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private AppBarLayout.BaseBehavior.BaseDragCallback jdField_a_of_type_ComGoogleAndroidMaterialAppbarAppBarLayout$BaseBehavior$BaseDragCallback;
  @Nullable
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c = -1;
  
  public AppBarLayout$BaseBehavior() {}
  
  public AppBarLayout$BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int a(@NonNull T paramT, int paramInt)
  {
    int i1 = paramT.getChildCount();
    int i = 0;
    while (i < i1)
    {
      Object localObject = paramT.getChildAt(i);
      int n = ((View)localObject).getTop();
      int m = ((View)localObject).getBottom();
      localObject = (AppBarLayout.LayoutParams)((View)localObject).getLayoutParams();
      int k = n;
      int j = m;
      if (a(((AppBarLayout.LayoutParams)localObject).a(), 32))
      {
        k = n - ((AppBarLayout.LayoutParams)localObject).topMargin;
        j = m + ((AppBarLayout.LayoutParams)localObject).bottomMargin;
      }
      m = -paramInt;
      if ((k <= m) && (j >= m)) {
        return i;
      }
      i += 1;
    }
    return -1;
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
  
  @Nullable
  private static View a(@NonNull AppBarLayout paramAppBarLayout, int paramInt)
  {
    int i = Math.abs(paramInt);
    int j = paramAppBarLayout.getChildCount();
    paramInt = 0;
    while (paramInt < j)
    {
      View localView = paramAppBarLayout.getChildAt(paramInt);
      if ((i >= localView.getTop()) && (i <= localView.getBottom())) {
        return localView;
      }
      paramInt += 1;
    }
    return null;
  }
  
  private void a(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, int paramInt, float paramFloat)
  {
    int i = Math.abs(a() - paramInt);
    paramFloat = Math.abs(paramFloat);
    if (paramFloat > 0.0F) {
      i = Math.round(i / paramFloat * 1000.0F) * 3;
    } else {
      i = (int)((i / paramT.getHeight() + 1.0F) * 150.0F);
    }
    a(paramCoordinatorLayout, paramT, paramInt, i);
  }
  
  private void a(CoordinatorLayout paramCoordinatorLayout, T paramT, int paramInt1, int paramInt2)
  {
    int i = a();
    if (i == paramInt1)
    {
      paramCoordinatorLayout = this.jdField_a_of_type_AndroidAnimationValueAnimator;
      if ((paramCoordinatorLayout != null) && (paramCoordinatorLayout.isRunning())) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      return;
    }
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(AnimationUtils.e);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new AppBarLayout.BaseBehavior.1(this, paramCoordinatorLayout, paramT));
    }
    else
    {
      localValueAnimator.cancel();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(Math.min(paramInt2, 600));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { i, paramInt1 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    View localView = a(paramT, paramInt1);
    if (localView != null)
    {
      int i = ((AppBarLayout.LayoutParams)localView.getLayoutParams()).a();
      boolean bool2 = false;
      boolean bool1 = bool2;
      if ((i & 0x1) != 0)
      {
        int j = ViewCompat.getMinimumHeight(localView);
        if ((paramInt2 > 0) && ((i & 0xC) != 0))
        {
          bool1 = bool2;
          if (-paramInt1 < localView.getBottom() - j - paramT.g()) {}
        }
        else
        {
          do
          {
            bool1 = true;
            break;
            bool1 = bool2;
            if ((i & 0x2) == 0) {
              break;
            }
            bool1 = bool2;
          } while (-paramInt1 >= localView.getBottom() - j - paramT.g());
        }
      }
      if (paramT.c()) {
        bool1 = paramT.a(a(paramCoordinatorLayout));
      }
      bool1 = paramT.a(bool1);
      if ((paramBoolean) || ((bool1) && (a(paramCoordinatorLayout, paramT)))) {
        paramT.jumpDrawablesToCurrentState();
      }
    }
  }
  
  private void a(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, @NonNull View paramView)
  {
    if ((a() != -paramT.a()) && (paramView.canScrollVertically(1))) {
      a(paramCoordinatorLayout, paramT, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
    }
    if (a() != 0) {
      if (paramView.canScrollVertically(-1))
      {
        int i = -paramT.c();
        if (i != 0) {
          ViewCompat.replaceAccessibilityAction(paramCoordinatorLayout, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AppBarLayout.BaseBehavior.2(this, paramCoordinatorLayout, paramT, paramView, i));
        }
      }
      else
      {
        a(paramCoordinatorLayout, paramT, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
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
  
  private boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT)
  {
    paramCoordinatorLayout = paramCoordinatorLayout.getDependents(paramT);
    int j = paramCoordinatorLayout.size();
    boolean bool = false;
    int i = 0;
    while (i < j)
    {
      paramT = ((CoordinatorLayout.LayoutParams)((View)paramCoordinatorLayout.get(i)).getLayoutParams()).getBehavior();
      if ((paramT instanceof AppBarLayout.ScrollingViewBehavior))
      {
        if (((AppBarLayout.ScrollingViewBehavior)paramT).c() != 0) {
          bool = true;
        }
        return bool;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, @NonNull View paramView)
  {
    return (paramT.b()) && (paramCoordinatorLayout.getHeight() - paramView.getHeight() <= paramT.getHeight());
  }
  
  private int b(@NonNull T paramT, int paramInt)
  {
    int k = Math.abs(paramInt);
    int m = paramT.getChildCount();
    int j = 0;
    int i = 0;
    while (i < m)
    {
      View localView = paramT.getChildAt(i);
      AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
      Interpolator localInterpolator = localLayoutParams.a();
      if ((k >= localView.getTop()) && (k <= localView.getBottom()))
      {
        if (localInterpolator == null) {
          break;
        }
        m = localLayoutParams.a();
        i = j;
        if ((m & 0x1) != 0)
        {
          j = 0 + (localView.getHeight() + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
          i = j;
          if ((m & 0x2) != 0) {
            i = j - ViewCompat.getMinimumHeight(localView);
          }
        }
        j = i;
        if (ViewCompat.getFitsSystemWindows(localView)) {
          j = i - paramT.g();
        }
        if (j <= 0) {
          break;
        }
        i = localView.getTop();
        float f = j;
        i = Math.round(f * localInterpolator.getInterpolation((k - i) / f));
        return Integer.signum(paramInt) * (localView.getTop() + i);
      }
      i += 1;
    }
    return paramInt;
  }
  
  private void b(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT)
  {
    int n = a();
    int k = a(paramT, n);
    if (k >= 0)
    {
      View localView = paramT.getChildAt(k);
      AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
      int i1 = localLayoutParams.a();
      if ((i1 & 0x11) == 17)
      {
        int m = -localView.getTop();
        int i = -localView.getBottom();
        int j = i;
        if (k == paramT.getChildCount() - 1) {
          j = i + paramT.g();
        }
        if (a(i1, 2))
        {
          i = j + ViewCompat.getMinimumHeight(localView);
          k = m;
        }
        else
        {
          k = m;
          i = j;
          if (a(i1, 5))
          {
            i = ViewCompat.getMinimumHeight(localView) + j;
            if (n < i)
            {
              k = i;
              i = j;
            }
            else
            {
              k = m;
            }
          }
        }
        m = k;
        j = i;
        if (a(i1, 32))
        {
          m = k + localLayoutParams.topMargin;
          j = i - localLayoutParams.bottomMargin;
        }
        i = m;
        if (n < (j + m) / 2) {
          i = j;
        }
        a(paramCoordinatorLayout, paramT, MathUtils.clamp(i, -paramT.a(), 0), 0.0F);
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
      if (paramT.a() == 0) {
        return;
      }
      if (!(((CoordinatorLayout.LayoutParams)localView.getLayoutParams()).getBehavior() instanceof AppBarLayout.ScrollingViewBehavior)) {
        return;
      }
      a(paramCoordinatorLayout, paramT, localView);
    }
  }
  
  int a()
  {
    return b() + this.jdField_a_of_type_Int;
  }
  
  int a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, int paramInt1, int paramInt2, int paramInt3)
  {
    int j = a();
    int i = 0;
    if ((paramInt2 != 0) && (j >= paramInt2) && (j <= paramInt3))
    {
      paramInt2 = MathUtils.clamp(paramInt1, paramInt2, paramInt3);
      paramInt1 = i;
      if (j != paramInt2)
      {
        if (paramT.a()) {
          paramInt1 = b(paramT, paramInt2);
        } else {
          paramInt1 = paramInt2;
        }
        boolean bool = a(paramInt1);
        paramInt3 = j - paramInt2;
        this.jdField_a_of_type_Int = (paramInt2 - paramInt1);
        if ((!bool) && (paramT.a())) {
          paramCoordinatorLayout.dispatchDependentViewsChanged(paramT);
        }
        paramT.a(b());
        if (paramInt2 < j) {
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
      this.jdField_a_of_type_Int = 0;
      paramInt1 = i;
    }
    c(paramCoordinatorLayout, paramT);
    return paramInt1;
  }
  
  int a(@NonNull T paramT)
  {
    return -paramT.d();
  }
  
  public Parcelable a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT)
  {
    Object localObject = super.onSaveInstanceState(paramCoordinatorLayout, paramT);
    int j = b();
    int k = paramT.getChildCount();
    boolean bool = false;
    int i = 0;
    while (i < k)
    {
      paramCoordinatorLayout = paramT.getChildAt(i);
      int m = paramCoordinatorLayout.getBottom() + j;
      if ((paramCoordinatorLayout.getTop() + j <= 0) && (m >= 0))
      {
        localObject = new AppBarLayout.BaseBehavior.SavedState((Parcelable)localObject);
        ((AppBarLayout.BaseBehavior.SavedState)localObject).jdField_a_of_type_Int = i;
        if (m == ViewCompat.getMinimumHeight(paramCoordinatorLayout) + paramT.g()) {
          bool = true;
        }
        ((AppBarLayout.BaseBehavior.SavedState)localObject).jdField_a_of_type_Boolean = bool;
        ((AppBarLayout.BaseBehavior.SavedState)localObject).jdField_a_of_type_Float = (m / paramCoordinatorLayout.getHeight());
        return localObject;
      }
      i += 1;
    }
    return localObject;
  }
  
  void a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT)
  {
    b(paramCoordinatorLayout, paramT);
    if (paramT.c()) {
      paramT.a(paramT.a(a(paramCoordinatorLayout)));
    }
  }
  
  public void a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, Parcelable paramParcelable)
  {
    if ((paramParcelable instanceof AppBarLayout.BaseBehavior.SavedState))
    {
      paramParcelable = (AppBarLayout.BaseBehavior.SavedState)paramParcelable;
      super.onRestoreInstanceState(paramCoordinatorLayout, paramT, paramParcelable.getSuperState());
      this.c = paramParcelable.jdField_a_of_type_Int;
      this.jdField_a_of_type_Float = paramParcelable.jdField_a_of_type_Float;
      this.jdField_a_of_type_Boolean = paramParcelable.jdField_a_of_type_Boolean;
      return;
    }
    super.onRestoreInstanceState(paramCoordinatorLayout, paramT, paramParcelable);
    this.c = -1;
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, View paramView, int paramInt)
  {
    if ((this.b == 0) || (paramInt == 1))
    {
      b(paramCoordinatorLayout, paramT);
      if (paramT.c()) {
        paramT.a(paramT.a(paramView));
      }
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int[] paramArrayOfInt)
  {
    if (paramInt4 < 0) {
      paramArrayOfInt[1] = b(paramCoordinatorLayout, paramT, paramInt4, -paramT.d(), 0);
    }
    if (paramInt4 == 0) {
      c(paramCoordinatorLayout, paramT);
    }
  }
  
  public void a(CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 < 0)
      {
        paramInt3 = -paramT.a();
        int i = paramT.c();
        paramInt1 = paramInt3;
        paramInt3 = i + paramInt3;
      }
      else
      {
        paramInt1 = -paramT.b();
        paramInt3 = 0;
      }
      if (paramInt1 != paramInt3) {
        paramArrayOfInt[1] = b(paramCoordinatorLayout, paramT, paramInt2, paramInt1, paramInt3);
      }
    }
    if (paramT.c()) {
      paramT.a(paramT.a(paramView));
    }
  }
  
  public boolean a(@NonNull CoordinatorLayout paramCoordinatorLayout, @NonNull T paramT, int paramInt)
  {
    boolean bool = super.onLayoutChild(paramCoordinatorLayout, paramT, paramInt);
    int i = paramT.f();
    paramInt = this.c;
    if ((paramInt >= 0) && ((i & 0x8) == 0))
    {
      View localView = paramT.getChildAt(paramInt);
      i = -localView.getBottom();
      if (this.jdField_a_of_type_Boolean) {
        paramInt = ViewCompat.getMinimumHeight(localView) + paramT.g();
      } else {
        paramInt = Math.round(localView.getHeight() * this.jdField_a_of_type_Float);
      }
      a(paramCoordinatorLayout, paramT, i + paramInt);
    }
    else if (i != 0)
    {
      if ((i & 0x4) != 0) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      if ((i & 0x2) != 0)
      {
        i = -paramT.b();
        if (paramInt != 0) {
          a(paramCoordinatorLayout, paramT, i, 0.0F);
        } else {
          a(paramCoordinatorLayout, paramT, i);
        }
      }
      else if ((i & 0x1) != 0)
      {
        if (paramInt != 0) {
          a(paramCoordinatorLayout, paramT, 0, 0.0F);
        } else {
          a(paramCoordinatorLayout, paramT, 0);
        }
      }
    }
    paramT.a();
    this.c = -1;
    a(MathUtils.clamp(b(), -paramT.a(), 0));
    a(paramCoordinatorLayout, paramT, b(), 0, true);
    paramT.a(b());
    c(paramCoordinatorLayout, paramT);
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
    if (((paramInt1 & 0x2) != 0) && ((paramT.c()) || (a(paramCoordinatorLayout, paramT, paramView1)))) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      paramCoordinatorLayout = this.jdField_a_of_type_AndroidAnimationValueAnimator;
      if (paramCoordinatorLayout != null) {
        paramCoordinatorLayout.cancel();
      }
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
    this.b = paramInt2;
    return bool;
  }
  
  boolean a(T paramT)
  {
    AppBarLayout.BaseBehavior.BaseDragCallback localBaseDragCallback = this.jdField_a_of_type_ComGoogleAndroidMaterialAppbarAppBarLayout$BaseBehavior$BaseDragCallback;
    if (localBaseDragCallback != null) {
      return localBaseDragCallback.a(paramT);
    }
    paramT = this.jdField_a_of_type_JavaLangRefWeakReference;
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
    return paramT.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout.BaseBehavior
 * JD-Core Version:    0.7.0.1
 */