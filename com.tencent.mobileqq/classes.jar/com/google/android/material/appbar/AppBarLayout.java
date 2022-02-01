package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.integer;
import com.google.android.material.R.style;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class AppBarLayout
  extends LinearLayout
  implements CoordinatorLayout.AttachedBehavior
{
  private static final int a = R.style.j;
  private int b;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private boolean f;
  private int g = 0;
  @Nullable
  private WindowInsetsCompat h;
  private List<AppBarLayout.BaseOnOffsetChangedListener> i;
  private boolean j;
  private boolean k;
  private boolean l;
  private boolean m;
  @IdRes
  private int n;
  @Nullable
  private WeakReference<View> o;
  @Nullable
  private ValueAnimator p;
  private int[] q;
  @Nullable
  private Drawable r;
  
  public AppBarLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppBarLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.b);
  }
  
  public AppBarLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, a), paramAttributeSet, paramInt);
    paramContext = getContext();
    setOrientation(1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      ViewUtilsLollipop.a(this);
      ViewUtilsLollipop.a(this, paramAttributeSet, paramInt, a);
    }
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.k, paramInt, a, new int[0]);
    ViewCompat.setBackground(this, paramAttributeSet.getDrawable(R.styleable.l));
    if ((getBackground() instanceof ColorDrawable))
    {
      ColorDrawable localColorDrawable = (ColorDrawable)getBackground();
      MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable();
      localMaterialShapeDrawable.g(ColorStateList.valueOf(localColorDrawable.getColor()));
      localMaterialShapeDrawable.a(paramContext);
      ViewCompat.setBackground(this, localMaterialShapeDrawable);
    }
    if (paramAttributeSet.hasValue(R.styleable.p)) {
      a(paramAttributeSet.getBoolean(R.styleable.p, false), false, false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (paramAttributeSet.hasValue(R.styleable.o))) {
      ViewUtilsLollipop.a(this, paramAttributeSet.getDimensionPixelSize(R.styleable.o, 0));
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      if (paramAttributeSet.hasValue(R.styleable.n)) {
        setKeyboardNavigationCluster(paramAttributeSet.getBoolean(R.styleable.n, false));
      }
      if (paramAttributeSet.hasValue(R.styleable.m)) {
        setTouchscreenBlocksFocus(paramAttributeSet.getBoolean(R.styleable.m, false));
      }
    }
    this.m = paramAttributeSet.getBoolean(R.styleable.q, false);
    this.n = paramAttributeSet.getResourceId(R.styleable.r, -1);
    setStatusBarForeground(paramAttributeSet.getDrawable(R.styleable.s));
    paramAttributeSet.recycle();
    ViewCompat.setOnApplyWindowInsetsListener(this, new AppBarLayout.1(this));
  }
  
  private void a(@NonNull MaterialShapeDrawable paramMaterialShapeDrawable, boolean paramBoolean)
  {
    float f1 = getResources().getDimension(R.dimen.a);
    float f2;
    if (paramBoolean) {
      f2 = 0.0F;
    } else {
      f2 = f1;
    }
    if (!paramBoolean) {
      f1 = 0.0F;
    }
    ValueAnimator localValueAnimator = this.p;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.p = ValueAnimator.ofFloat(new float[] { f2, f1 });
    this.p.setDuration(getResources().getInteger(R.integer.a));
    this.p.setInterpolator(AnimationUtils.a);
    this.p.addUpdateListener(new AppBarLayout.2(this, paramMaterialShapeDrawable));
    this.p.start();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i1;
    if (paramBoolean1) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    int i3 = 0;
    int i2;
    if (paramBoolean2) {
      i2 = 4;
    } else {
      i2 = 0;
    }
    if (paramBoolean3) {
      i3 = 8;
    }
    this.g = (i1 | i2 | i3);
    requestLayout();
  }
  
  @Nullable
  private View b(@Nullable View paramView)
  {
    Object localObject1 = this.o;
    Object localObject2 = null;
    if (localObject1 == null)
    {
      int i1 = this.n;
      if (i1 != -1)
      {
        if (paramView != null) {
          paramView = paramView.findViewById(i1);
        } else {
          paramView = null;
        }
        localObject1 = paramView;
        if (paramView == null)
        {
          localObject1 = paramView;
          if ((getParent() instanceof ViewGroup)) {
            localObject1 = ((ViewGroup)getParent()).findViewById(this.n);
          }
        }
        if (localObject1 != null) {
          this.o = new WeakReference(localObject1);
        }
      }
    }
    localObject1 = this.o;
    paramView = localObject2;
    if (localObject1 != null) {
      paramView = (View)((WeakReference)localObject1).get();
    }
    return paramView;
  }
  
  private boolean b(boolean paramBoolean)
  {
    if (this.k != paramBoolean)
    {
      this.k = paramBoolean;
      refreshDrawableState();
      return true;
    }
    return false;
  }
  
  private void f()
  {
    setWillNotDraw(g() ^ true);
  }
  
  private boolean g()
  {
    return (this.r != null) && (getTopInset() > 0);
  }
  
  private boolean h()
  {
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      if (((AppBarLayout.LayoutParams)getChildAt(i1).getLayoutParams()).c()) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private void i()
  {
    this.c = -1;
    this.d = -1;
    this.e = -1;
  }
  
  private void j()
  {
    WeakReference localWeakReference = this.o;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.o = null;
  }
  
  private boolean k()
  {
    int i1 = getChildCount();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i1 > 0)
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
    if (!ObjectsCompat.equals(this.h, localWindowInsetsCompat))
    {
      this.h = localWindowInsetsCompat;
      f();
      requestLayout();
    }
    return paramWindowInsetsCompat;
  }
  
  protected AppBarLayout.LayoutParams a()
  {
    return new AppBarLayout.LayoutParams(-1, -2);
  }
  
  public AppBarLayout.LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new AppBarLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected AppBarLayout.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    if ((Build.VERSION.SDK_INT >= 19) && ((paramLayoutParams instanceof LinearLayout.LayoutParams))) {
      return new AppBarLayout.LayoutParams((LinearLayout.LayoutParams)paramLayoutParams);
    }
    if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
      return new AppBarLayout.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
    }
    return new AppBarLayout.LayoutParams(paramLayoutParams);
  }
  
  void a(int paramInt)
  {
    this.b = paramInt;
    if (!willNotDraw()) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
    Object localObject = this.i;
    if (localObject != null)
    {
      int i1 = 0;
      int i2 = ((List)localObject).size();
      while (i1 < i2)
      {
        localObject = (AppBarLayout.BaseOnOffsetChangedListener)this.i.get(i1);
        if (localObject != null) {
          ((AppBarLayout.BaseOnOffsetChangedListener)localObject).a(this, paramInt);
        }
        i1 += 1;
      }
    }
  }
  
  public void a(@Nullable AppBarLayout.BaseOnOffsetChangedListener paramBaseOnOffsetChangedListener)
  {
    if (this.i == null) {
      this.i = new ArrayList();
    }
    if ((paramBaseOnOffsetChangedListener != null) && (!this.i.contains(paramBaseOnOffsetChangedListener))) {
      this.i.add(paramBaseOnOffsetChangedListener);
    }
  }
  
  public void a(AppBarLayout.OnOffsetChangedListener paramOnOffsetChangedListener)
  {
    a(paramOnOffsetChangedListener);
  }
  
  boolean a(@Nullable View paramView)
  {
    View localView = b(paramView);
    if (localView != null) {
      paramView = localView;
    }
    return (paramView != null) && ((paramView.canScrollVertically(-1)) || (paramView.getScrollY() > 0));
  }
  
  boolean a(boolean paramBoolean)
  {
    if (this.l != paramBoolean)
    {
      this.l = paramBoolean;
      refreshDrawableState();
      if ((this.m) && ((getBackground() instanceof MaterialShapeDrawable))) {
        a((MaterialShapeDrawable)getBackground(), paramBoolean);
      }
      return true;
    }
    return false;
  }
  
  public void b(@Nullable AppBarLayout.BaseOnOffsetChangedListener paramBaseOnOffsetChangedListener)
  {
    List localList = this.i;
    if ((localList != null) && (paramBaseOnOffsetChangedListener != null)) {
      localList.remove(paramBaseOnOffsetChangedListener);
    }
  }
  
  public void b(AppBarLayout.OnOffsetChangedListener paramOnOffsetChangedListener)
  {
    b(paramOnOffsetChangedListener);
  }
  
  boolean b()
  {
    return this.f;
  }
  
  boolean c()
  {
    return getTotalScrollRange() != 0;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof AppBarLayout.LayoutParams;
  }
  
  public boolean d()
  {
    return this.m;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (g())
    {
      int i1 = paramCanvas.save();
      paramCanvas.translate(0.0F, -this.b);
      this.r.draw(paramCanvas);
      paramCanvas.restoreToCount(i1);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = this.r;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(arrayOfInt))) {
      invalidateDrawable(localDrawable);
    }
  }
  
  void e()
  {
    this.g = 0;
  }
  
  @NonNull
  public CoordinatorLayout.Behavior<AppBarLayout> getBehavior()
  {
    return new AppBarLayout.Behavior();
  }
  
  int getDownNestedPreScrollRange()
  {
    int i1 = this.d;
    if (i1 != -1) {
      return i1;
    }
    int i2 = getChildCount() - 1;
    for (int i3 = 0; i2 >= 0; i3 = i1)
    {
      View localView = getChildAt(i2);
      AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
      int i5 = localView.getMeasuredHeight();
      i1 = localLayoutParams.a;
      if ((i1 & 0x5) == 5)
      {
        int i4 = localLayoutParams.topMargin + localLayoutParams.bottomMargin;
        if ((i1 & 0x8) != 0) {}
        for (i1 = ViewCompat.getMinimumHeight(localView);; i1 = i5 - ViewCompat.getMinimumHeight(localView))
        {
          i1 = i4 + i1;
          break label120;
          if ((i1 & 0x2) == 0) {
            break;
          }
        }
        i1 = i4 + i5;
        label120:
        i4 = i1;
        if (i2 == 0)
        {
          i4 = i1;
          if (ViewCompat.getFitsSystemWindows(localView)) {
            i4 = Math.min(i1, i5 - getTopInset());
          }
        }
        i1 = i3 + i4;
      }
      else
      {
        i1 = i3;
        if (i3 > 0) {
          break;
        }
      }
      i2 -= 1;
    }
    i1 = Math.max(0, i3);
    this.d = i1;
    return i1;
  }
  
  int getDownNestedScrollRange()
  {
    int i1 = this.e;
    if (i1 != -1) {
      return i1;
    }
    int i4 = getChildCount();
    int i2 = 0;
    i1 = 0;
    int i3;
    for (;;)
    {
      i3 = i1;
      if (i2 >= i4) {
        break;
      }
      View localView = getChildAt(i2);
      AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
      int i6 = localView.getMeasuredHeight();
      int i7 = localLayoutParams.topMargin;
      int i8 = localLayoutParams.bottomMargin;
      int i5 = localLayoutParams.a;
      i3 = i1;
      if ((i5 & 0x1) == 0) {
        break;
      }
      i1 += i6 + (i7 + i8);
      if ((i5 & 0x2) != 0)
      {
        i3 = i1 - ViewCompat.getMinimumHeight(localView);
        break;
      }
      i2 += 1;
    }
    i1 = Math.max(0, i3);
    this.e = i1;
    return i1;
  }
  
  @IdRes
  public int getLiftOnScrollTargetViewId()
  {
    return this.n;
  }
  
  public final int getMinimumHeightForVisibleOverlappingContent()
  {
    int i2 = getTopInset();
    int i1 = ViewCompat.getMinimumHeight(this);
    if (i1 != 0) {}
    do
    {
      return i1 * 2 + i2;
      i1 = getChildCount();
      if (i1 >= 1) {
        i1 = ViewCompat.getMinimumHeight(getChildAt(i1 - 1));
      } else {
        i1 = 0;
      }
    } while (i1 != 0);
    return getHeight() / 3;
  }
  
  int getPendingAction()
  {
    return this.g;
  }
  
  @Nullable
  public Drawable getStatusBarForeground()
  {
    return this.r;
  }
  
  @Deprecated
  public float getTargetElevation()
  {
    return 0.0F;
  }
  
  @VisibleForTesting
  final int getTopInset()
  {
    WindowInsetsCompat localWindowInsetsCompat = this.h;
    if (localWindowInsetsCompat != null) {
      return localWindowInsetsCompat.getSystemWindowInsetTop();
    }
    return 0;
  }
  
  public final int getTotalScrollRange()
  {
    int i1 = this.c;
    if (i1 != -1) {
      return i1;
    }
    int i4 = getChildCount();
    int i2 = 0;
    i1 = 0;
    int i3;
    for (;;)
    {
      i3 = i1;
      if (i2 >= i4) {
        break;
      }
      View localView = getChildAt(i2);
      AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
      int i6 = localView.getMeasuredHeight();
      int i5 = localLayoutParams.a;
      i3 = i1;
      if ((i5 & 0x1) == 0) {
        break;
      }
      i3 = i1 + (i6 + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
      i1 = i3;
      if (i2 == 0)
      {
        i1 = i3;
        if (ViewCompat.getFitsSystemWindows(localView)) {
          i1 = i3 - getTopInset();
        }
      }
      if ((i5 & 0x2) != 0)
      {
        i3 = i1 - ViewCompat.getMinimumHeight(localView);
        break;
      }
      i2 += 1;
    }
    i1 = Math.max(0, i3);
    this.c = i1;
    return i1;
  }
  
  int getUpNestedPreScrollRange()
  {
    return getTotalScrollRange();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.a(this);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    if (this.q == null) {
      this.q = new int[4];
    }
    int[] arrayOfInt1 = this.q;
    int[] arrayOfInt2 = super.onCreateDrawableState(paramInt + arrayOfInt1.length);
    if (this.k) {
      paramInt = R.attr.W;
    } else {
      paramInt = -R.attr.W;
    }
    arrayOfInt1[0] = paramInt;
    if ((this.k) && (this.l)) {
      paramInt = R.attr.X;
    } else {
      paramInt = -R.attr.X;
    }
    arrayOfInt1[1] = paramInt;
    if (this.k) {
      paramInt = R.attr.U;
    } else {
      paramInt = -R.attr.U;
    }
    arrayOfInt1[2] = paramInt;
    if ((this.k) && (this.l)) {
      paramInt = R.attr.T;
    } else {
      paramInt = -R.attr.T;
    }
    arrayOfInt1[3] = paramInt;
    return mergeDrawableStates(arrayOfInt2, arrayOfInt1);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    j();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((ViewCompat.getFitsSystemWindows(this)) && (k()))
    {
      paramInt2 = getTopInset();
      paramInt1 = getChildCount() - 1;
      while (paramInt1 >= 0)
      {
        ViewCompat.offsetTopAndBottom(getChildAt(paramInt1), paramInt2);
        paramInt1 -= 1;
      }
    }
    i();
    paramBoolean = false;
    this.f = false;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (((AppBarLayout.LayoutParams)getChildAt(paramInt1).getLayoutParams()).b() != null)
      {
        this.f = true;
        break;
      }
      paramInt1 += 1;
    }
    Drawable localDrawable = this.r;
    if (localDrawable != null) {
      localDrawable.setBounds(0, 0, getWidth(), getTopInset());
    }
    if (!this.j)
    {
      if ((this.m) || (h())) {
        paramBoolean = true;
      }
      b(paramBoolean);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    if ((i1 != 1073741824) && (ViewCompat.getFitsSystemWindows(this)) && (k()))
    {
      paramInt1 = getMeasuredHeight();
      if (i1 != -2147483648)
      {
        if (i1 == 0) {
          paramInt1 += getTopInset();
        }
      }
      else {
        paramInt1 = MathUtils.clamp(getMeasuredHeight() + getTopInset(), 0, View.MeasureSpec.getSize(paramInt2));
      }
      setMeasuredDimension(getMeasuredWidth(), paramInt1);
    }
    i();
  }
  
  @RequiresApi(21)
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    MaterialShapeUtils.a(this, paramFloat);
  }
  
  public void setExpanded(boolean paramBoolean)
  {
    setExpanded(paramBoolean, ViewCompat.isLaidOut(this));
  }
  
  public void setExpanded(boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBoolean1, paramBoolean2, true);
  }
  
  public void setLiftOnScroll(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void setLiftOnScrollTargetViewId(@IdRes int paramInt)
  {
    this.n = paramInt;
    j();
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt == 1)
    {
      super.setOrientation(paramInt);
      return;
    }
    throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
  }
  
  public void setStatusBarForeground(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable2 = this.r;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      this.r = localDrawable1;
      paramDrawable = this.r;
      if (paramDrawable != null)
      {
        if (paramDrawable.isStateful()) {
          this.r.setState(getDrawableState());
        }
        DrawableCompat.setLayoutDirection(this.r, ViewCompat.getLayoutDirection(this));
        paramDrawable = this.r;
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramDrawable.setVisible(bool, false);
        this.r.setCallback(this);
      }
      f();
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setStatusBarForegroundColor(@ColorInt int paramInt)
  {
    setStatusBarForeground(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarForegroundResource(@DrawableRes int paramInt)
  {
    setStatusBarForeground(AppCompatResources.getDrawable(getContext(), paramInt));
  }
  
  @Deprecated
  public void setTargetElevation(float paramFloat)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      ViewUtilsLollipop.a(this, paramFloat);
    }
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    boolean bool;
    if (paramInt == 0) {
      bool = true;
    } else {
      bool = false;
    }
    Drawable localDrawable = this.r;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
  }
  
  protected boolean verifyDrawable(@NonNull Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.r);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout
 * JD-Core Version:    0.7.0.1
 */