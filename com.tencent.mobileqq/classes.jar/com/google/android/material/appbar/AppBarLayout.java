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
  private static final int jdField_a_of_type_Int = R.style.h;
  @Nullable
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  @Nullable
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  @Nullable
  private WindowInsetsCompat jdField_a_of_type_AndroidxCoreViewWindowInsetsCompat;
  @Nullable
  private WeakReference<View> jdField_a_of_type_JavaLangRefWeakReference;
  private List<AppBarLayout.BaseOnOffsetChangedListener> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int = -1;
  private boolean jdField_d_of_type_Boolean;
  private int jdField_e_of_type_Int = -1;
  private boolean jdField_e_of_type_Boolean;
  private int f = 0;
  @IdRes
  private int g;
  
  public AppBarLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppBarLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.jdField_a_of_type_Int);
  }
  
  public AppBarLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_a_of_type_Int), paramAttributeSet, paramInt);
    paramContext = getContext();
    setOrientation(1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      ViewUtilsLollipop.a(this);
      ViewUtilsLollipop.a(this, paramAttributeSet, paramInt, jdField_a_of_type_Int);
    }
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.jdField_a_of_type_ArrayOfInt, paramInt, jdField_a_of_type_Int, new int[0]);
    ViewCompat.setBackground(this, paramAttributeSet.getDrawable(R.styleable.jdField_a_of_type_Int));
    if ((getBackground() instanceof ColorDrawable))
    {
      ColorDrawable localColorDrawable = (ColorDrawable)getBackground();
      MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable();
      localMaterialShapeDrawable.g(ColorStateList.valueOf(localColorDrawable.getColor()));
      localMaterialShapeDrawable.a(paramContext);
      ViewCompat.setBackground(this, localMaterialShapeDrawable);
    }
    if (paramAttributeSet.hasValue(R.styleable.jdField_e_of_type_Int)) {
      a(paramAttributeSet.getBoolean(R.styleable.jdField_e_of_type_Int, false), false, false);
    }
    if ((Build.VERSION.SDK_INT >= 21) && (paramAttributeSet.hasValue(R.styleable.jdField_d_of_type_Int))) {
      ViewUtilsLollipop.a(this, paramAttributeSet.getDimensionPixelSize(R.styleable.jdField_d_of_type_Int, 0));
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      if (paramAttributeSet.hasValue(R.styleable.jdField_c_of_type_Int)) {
        setKeyboardNavigationCluster(paramAttributeSet.getBoolean(R.styleable.jdField_c_of_type_Int, false));
      }
      if (paramAttributeSet.hasValue(R.styleable.jdField_b_of_type_Int)) {
        setTouchscreenBlocksFocus(paramAttributeSet.getBoolean(R.styleable.jdField_b_of_type_Int, false));
      }
    }
    this.jdField_e_of_type_Boolean = paramAttributeSet.getBoolean(R.styleable.f, false);
    this.g = paramAttributeSet.getResourceId(R.styleable.g, -1);
    setStatusBarForeground(paramAttributeSet.getDrawable(R.styleable.h));
    paramAttributeSet.recycle();
    ViewCompat.setOnApplyWindowInsetsListener(this, new AppBarLayout.1(this));
  }
  
  @Nullable
  private View a(@Nullable View paramView)
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    Object localObject2 = null;
    if (localObject1 == null)
    {
      int i = this.g;
      if (i != -1)
      {
        if (paramView != null) {
          paramView = paramView.findViewById(i);
        } else {
          paramView = null;
        }
        localObject1 = paramView;
        if (paramView == null)
        {
          localObject1 = paramView;
          if ((getParent() instanceof ViewGroup)) {
            localObject1 = ((ViewGroup)getParent()).findViewById(this.g);
          }
        }
        if (localObject1 != null) {
          this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localObject1);
        }
      }
    }
    localObject1 = this.jdField_a_of_type_JavaLangRefWeakReference;
    paramView = localObject2;
    if (localObject1 != null) {
      paramView = (View)((WeakReference)localObject1).get();
    }
    return paramView;
  }
  
  private void a(@NonNull MaterialShapeDrawable paramMaterialShapeDrawable, boolean paramBoolean)
  {
    float f1 = getResources().getDimension(R.dimen.jdField_a_of_type_Int);
    float f2;
    if (paramBoolean) {
      f2 = 0.0F;
    } else {
      f2 = f1;
    }
    if (!paramBoolean) {
      f1 = 0.0F;
    }
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator = ValueAnimator.ofFloat(new float[] { f2, f1 });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(getResources().getInteger(R.integer.jdField_a_of_type_Int));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(AnimationUtils.a);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new AppBarLayout.2(this, paramMaterialShapeDrawable));
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    int i;
    if (paramBoolean1) {
      i = 1;
    } else {
      i = 2;
    }
    int k = 0;
    int j;
    if (paramBoolean2) {
      j = 4;
    } else {
      j = 0;
    }
    if (paramBoolean3) {
      k = 8;
    }
    this.f = (i | j | k);
    requestLayout();
  }
  
  private void b()
  {
    setWillNotDraw(d() ^ true);
  }
  
  private boolean b(boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Boolean != paramBoolean)
    {
      this.jdField_c_of_type_Boolean = paramBoolean;
      refreshDrawableState();
      return true;
    }
    return false;
  }
  
  private void c()
  {
    this.jdField_c_of_type_Int = -1;
    this.jdField_d_of_type_Int = -1;
    this.jdField_e_of_type_Int = -1;
  }
  
  private void d()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = null;
  }
  
  private boolean d()
  {
    return (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (g() > 0);
  }
  
  private boolean e()
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      if (((AppBarLayout.LayoutParams)getChildAt(i).getLayoutParams()).a()) {
        return true;
      }
      i += 1;
    }
    return false;
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
  
  public final int a()
  {
    int i = this.jdField_c_of_type_Int;
    if (i != -1) {
      return i;
    }
    int m = getChildCount();
    int j = 0;
    i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      View localView = getChildAt(j);
      AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
      int i1 = localView.getMeasuredHeight();
      int n = localLayoutParams.jdField_a_of_type_Int;
      k = i;
      if ((n & 0x1) == 0) {
        break;
      }
      k = i + (i1 + localLayoutParams.topMargin + localLayoutParams.bottomMargin);
      i = k;
      if (j == 0)
      {
        i = k;
        if (ViewCompat.getFitsSystemWindows(localView)) {
          i = k - g();
        }
      }
      if ((n & 0x2) != 0)
      {
        k = i - ViewCompat.getMinimumHeight(localView);
        break;
      }
      j += 1;
    }
    i = Math.max(0, k);
    this.jdField_c_of_type_Int = i;
    return i;
  }
  
  WindowInsetsCompat a(WindowInsetsCompat paramWindowInsetsCompat)
  {
    WindowInsetsCompat localWindowInsetsCompat;
    if (ViewCompat.getFitsSystemWindows(this)) {
      localWindowInsetsCompat = paramWindowInsetsCompat;
    } else {
      localWindowInsetsCompat = null;
    }
    if (!ObjectsCompat.equals(this.jdField_a_of_type_AndroidxCoreViewWindowInsetsCompat, localWindowInsetsCompat))
    {
      this.jdField_a_of_type_AndroidxCoreViewWindowInsetsCompat = localWindowInsetsCompat;
      b();
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
  
  void a()
  {
    this.f = 0;
  }
  
  void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    if (!willNotDraw()) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      int i = 0;
      int j = ((List)localObject).size();
      while (i < j)
      {
        localObject = (AppBarLayout.BaseOnOffsetChangedListener)this.jdField_a_of_type_JavaUtilList.get(i);
        if (localObject != null) {
          ((AppBarLayout.BaseOnOffsetChangedListener)localObject).a(this, paramInt);
        }
        i += 1;
      }
    }
  }
  
  public void a(@Nullable AppBarLayout.BaseOnOffsetChangedListener paramBaseOnOffsetChangedListener)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    if ((paramBaseOnOffsetChangedListener != null) && (!this.jdField_a_of_type_JavaUtilList.contains(paramBaseOnOffsetChangedListener))) {
      this.jdField_a_of_type_JavaUtilList.add(paramBaseOnOffsetChangedListener);
    }
  }
  
  public void a(AppBarLayout.OnOffsetChangedListener paramOnOffsetChangedListener)
  {
    a(paramOnOffsetChangedListener);
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  boolean a(@Nullable View paramView)
  {
    View localView = a(paramView);
    if (localView != null) {
      paramView = localView;
    }
    return (paramView != null) && ((paramView.canScrollVertically(-1)) || (paramView.getScrollY() > 0));
  }
  
  boolean a(boolean paramBoolean)
  {
    if (this.jdField_d_of_type_Boolean != paramBoolean)
    {
      this.jdField_d_of_type_Boolean = paramBoolean;
      refreshDrawableState();
      if ((this.jdField_e_of_type_Boolean) && ((getBackground() instanceof MaterialShapeDrawable))) {
        a((MaterialShapeDrawable)getBackground(), paramBoolean);
      }
      return true;
    }
    return false;
  }
  
  int b()
  {
    return a();
  }
  
  public void b(@Nullable AppBarLayout.BaseOnOffsetChangedListener paramBaseOnOffsetChangedListener)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
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
    return a() != 0;
  }
  
  int c()
  {
    int i = this.jdField_d_of_type_Int;
    if (i != -1) {
      return i;
    }
    int j = getChildCount() - 1;
    for (int k = 0; j >= 0; k = i)
    {
      View localView = getChildAt(j);
      AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
      int n = localView.getMeasuredHeight();
      i = localLayoutParams.jdField_a_of_type_Int;
      if ((i & 0x5) == 5)
      {
        int m = localLayoutParams.topMargin + localLayoutParams.bottomMargin;
        if ((i & 0x8) != 0) {}
        for (i = ViewCompat.getMinimumHeight(localView);; i = n - ViewCompat.getMinimumHeight(localView))
        {
          i = m + i;
          break label120;
          if ((i & 0x2) == 0) {
            break;
          }
        }
        i = m + n;
        label120:
        m = i;
        if (j == 0)
        {
          m = i;
          if (ViewCompat.getFitsSystemWindows(localView)) {
            m = Math.min(i, n - g());
          }
        }
        i = k + m;
      }
      else
      {
        i = k;
        if (k > 0) {
          break;
        }
      }
      j -= 1;
    }
    i = Math.max(0, k);
    this.jdField_d_of_type_Int = i;
    return i;
  }
  
  public boolean c()
  {
    return this.jdField_e_of_type_Boolean;
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof AppBarLayout.LayoutParams;
  }
  
  int d()
  {
    int i = this.jdField_e_of_type_Int;
    if (i != -1) {
      return i;
    }
    int m = getChildCount();
    int j = 0;
    i = 0;
    int k;
    for (;;)
    {
      k = i;
      if (j >= m) {
        break;
      }
      View localView = getChildAt(j);
      AppBarLayout.LayoutParams localLayoutParams = (AppBarLayout.LayoutParams)localView.getLayoutParams();
      int i1 = localView.getMeasuredHeight();
      int i2 = localLayoutParams.topMargin;
      int i3 = localLayoutParams.bottomMargin;
      int n = localLayoutParams.jdField_a_of_type_Int;
      k = i;
      if ((n & 0x1) == 0) {
        break;
      }
      i += i1 + (i2 + i3);
      if ((n & 0x2) != 0)
      {
        k = i - ViewCompat.getMinimumHeight(localView);
        break;
      }
      j += 1;
    }
    i = Math.max(0, k);
    this.jdField_e_of_type_Int = i;
    return i;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (d())
    {
      int i = paramCanvas.save();
      paramCanvas.translate(0.0F, -this.jdField_b_of_type_Int);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if ((localDrawable != null) && (localDrawable.isStateful()) && (localDrawable.setState(arrayOfInt))) {
      invalidateDrawable(localDrawable);
    }
  }
  
  public final int e()
  {
    int j = g();
    int i = ViewCompat.getMinimumHeight(this);
    if (i != 0) {}
    do
    {
      return i * 2 + j;
      i = getChildCount();
      if (i >= 1) {
        i = ViewCompat.getMinimumHeight(getChildAt(i - 1));
      } else {
        i = 0;
      }
    } while (i != 0);
    return getHeight() / 3;
  }
  
  int f()
  {
    return this.f;
  }
  
  @VisibleForTesting
  final int g()
  {
    WindowInsetsCompat localWindowInsetsCompat = this.jdField_a_of_type_AndroidxCoreViewWindowInsetsCompat;
    if (localWindowInsetsCompat != null) {
      return localWindowInsetsCompat.getSystemWindowInsetTop();
    }
    return 0;
  }
  
  @NonNull
  public CoordinatorLayout.Behavior<AppBarLayout> getBehavior()
  {
    return new AppBarLayout.Behavior();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.a(this);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    if (this.jdField_a_of_type_ArrayOfInt == null) {
      this.jdField_a_of_type_ArrayOfInt = new int[4];
    }
    int[] arrayOfInt1 = this.jdField_a_of_type_ArrayOfInt;
    int[] arrayOfInt2 = super.onCreateDrawableState(paramInt + arrayOfInt1.length);
    if (this.jdField_c_of_type_Boolean) {
      paramInt = R.attr.O;
    } else {
      paramInt = -R.attr.O;
    }
    arrayOfInt1[0] = paramInt;
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {
      paramInt = R.attr.P;
    } else {
      paramInt = -R.attr.P;
    }
    arrayOfInt1[1] = paramInt;
    if (this.jdField_c_of_type_Boolean) {
      paramInt = R.attr.M;
    } else {
      paramInt = -R.attr.M;
    }
    arrayOfInt1[2] = paramInt;
    if ((this.jdField_c_of_type_Boolean) && (this.jdField_d_of_type_Boolean)) {
      paramInt = R.attr.L;
    } else {
      paramInt = -R.attr.L;
    }
    arrayOfInt1[3] = paramInt;
    return mergeDrawableStates(arrayOfInt2, arrayOfInt1);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    d();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((ViewCompat.getFitsSystemWindows(this)) && (f()))
    {
      paramInt2 = g();
      paramInt1 = getChildCount() - 1;
      while (paramInt1 >= 0)
      {
        ViewCompat.offsetTopAndBottom(getChildAt(paramInt1), paramInt2);
        paramInt1 -= 1;
      }
    }
    c();
    paramBoolean = false;
    this.jdField_a_of_type_Boolean = false;
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      if (((AppBarLayout.LayoutParams)getChildAt(paramInt1).getLayoutParams()).a() != null)
      {
        this.jdField_a_of_type_Boolean = true;
        break;
      }
      paramInt1 += 1;
    }
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.setBounds(0, 0, getWidth(), g());
    }
    if (!this.jdField_b_of_type_Boolean)
    {
      if ((this.jdField_e_of_type_Boolean) || (e())) {
        paramBoolean = true;
      }
      b(paramBoolean);
    }
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
          paramInt1 += g();
        }
      }
      else {
        paramInt1 = MathUtils.clamp(getMeasuredHeight() + g(), 0, View.MeasureSpec.getSize(paramInt2));
      }
      setMeasuredDimension(getMeasuredWidth(), paramInt1);
    }
    c();
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
    this.jdField_e_of_type_Boolean = paramBoolean;
  }
  
  public void setLiftOnScrollTargetViewId(@IdRes int paramInt)
  {
    this.g = paramInt;
    d();
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
    Drawable localDrawable2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localDrawable1;
      paramDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
      if (paramDrawable != null)
      {
        if (paramDrawable.isStateful()) {
          this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setState(getDrawableState());
        }
        DrawableCompat.setLayoutDirection(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, ViewCompat.getLayoutDirection(this));
        paramDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramDrawable.setVisible(bool, false);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setCallback(this);
      }
      b();
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
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.setVisible(bool, false);
    }
  }
  
  protected boolean verifyDrawable(@NonNull Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.appbar.AppBarLayout
 * JD-Core Version:    0.7.0.1
 */