package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R.attr;
import com.google.android.material.R.id;
import com.google.android.material.R.styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class CollapsingToolbarLayout
  extends FrameLayout
{
  private static final int jdField_b_of_type_Int = com.google.android.material.R.style.k;
  int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  @Nullable
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  @Nullable
  private View jdField_a_of_type_AndroidViewView;
  @Nullable
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  @Nullable
  WindowInsetsCompat jdField_a_of_type_AndroidxCoreViewWindowInsetsCompat;
  private AppBarLayout.OnOffsetChangedListener jdField_a_of_type_ComGoogleAndroidMaterialAppbarAppBarLayout$OnOffsetChangedListener;
  @NonNull
  final CollapsingTextHelper jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper;
  private boolean jdField_a_of_type_Boolean = true;
  @Nullable
  private Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i = -1;
  
  public CollapsingToolbarLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CollapsingToolbarLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.j);
  }
  
  public CollapsingToolbarLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, jdField_b_of_type_Int), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper = new CollapsingTextHelper(this);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(AnimationUtils.e);
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.o, paramInt, jdField_b_of_type_Int, new int[0]);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(paramContext.getInt(R.styleable.bj, 8388691));
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.b(paramContext.getInt(R.styleable.bg, 8388627));
    paramInt = paramContext.getDimensionPixelSize(R.styleable.bk, 0);
    this.g = paramInt;
    this.f = paramInt;
    this.e = paramInt;
    this.jdField_d_of_type_Int = paramInt;
    if (paramContext.hasValue(R.styleable.bn)) {
      this.jdField_d_of_type_Int = paramContext.getDimensionPixelSize(R.styleable.bn, 0);
    }
    if (paramContext.hasValue(R.styleable.bm)) {
      this.f = paramContext.getDimensionPixelSize(R.styleable.bm, 0);
    }
    if (paramContext.hasValue(R.styleable.bo)) {
      this.e = paramContext.getDimensionPixelSize(R.styleable.bo, 0);
    }
    if (paramContext.hasValue(R.styleable.bl)) {
      this.g = paramContext.getDimensionPixelSize(R.styleable.bl, 0);
    }
    this.jdField_b_of_type_Boolean = paramContext.getBoolean(R.styleable.bv, true);
    setTitle(paramContext.getText(R.styleable.bu));
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.d(com.google.android.material.R.style.jdField_d_of_type_Int);
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.c(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
    if (paramContext.hasValue(R.styleable.bp)) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.d(paramContext.getResourceId(R.styleable.bp, 0));
    }
    if (paramContext.hasValue(R.styleable.bh)) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.c(paramContext.getResourceId(R.styleable.bh, 0));
    }
    this.i = paramContext.getDimensionPixelSize(R.styleable.bs, -1);
    if (paramContext.hasValue(R.styleable.bq)) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.e(paramContext.getInt(R.styleable.bq, 1));
    }
    this.jdField_a_of_type_Long = paramContext.getInt(R.styleable.br, 600);
    setContentScrim(paramContext.getDrawable(R.styleable.bi));
    setStatusBarScrim(paramContext.getDrawable(R.styleable.bt));
    this.jdField_c_of_type_Int = paramContext.getResourceId(R.styleable.bw, -1);
    paramContext.recycle();
    setWillNotDraw(false);
    ViewCompat.setOnApplyWindowInsetsListener(this, new CollapsingToolbarLayout.1(this));
  }
  
  @NonNull
  private View a(@NonNull View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    View localView = paramView;
    for (paramView = localViewParent; (paramView != this) && (paramView != null); paramView = paramView.getParent()) {
      if ((paramView instanceof View)) {
        localView = (View)paramView;
      }
    }
    return localView;
  }
  
  @NonNull
  static ViewOffsetHelper a(@NonNull View paramView)
  {
    ViewOffsetHelper localViewOffsetHelper2 = (ViewOffsetHelper)paramView.getTag(R.id.am);
    ViewOffsetHelper localViewOffsetHelper1 = localViewOffsetHelper2;
    if (localViewOffsetHelper2 == null)
    {
      localViewOffsetHelper1 = new ViewOffsetHelper(paramView);
      paramView.setTag(R.id.am, localViewOffsetHelper1);
    }
    return localViewOffsetHelper1;
  }
  
  private static CharSequence a(View paramView)
  {
    if ((paramView instanceof androidx.appcompat.widget.Toolbar)) {
      return ((androidx.appcompat.widget.Toolbar)paramView).getTitle();
    }
    if ((Build.VERSION.SDK_INT >= 21) && ((paramView instanceof android.widget.Toolbar))) {
      return ((android.widget.Toolbar)paramView).getTitle();
    }
    return null;
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView;
    if (localObject == null) {
      localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    }
    int i2 = a((View)localObject);
    DescendantOffsetUtils.b(this, this.jdField_b_of_type_AndroidViewView, this.jdField_a_of_type_AndroidGraphicsRect);
    localObject = this.jdField_a_of_type_AndroidViewViewGroup;
    boolean bool = localObject instanceof androidx.appcompat.widget.Toolbar;
    int k = 0;
    int j;
    int n;
    int m;
    if (bool)
    {
      localObject = (androidx.appcompat.widget.Toolbar)localObject;
      k = ((androidx.appcompat.widget.Toolbar)localObject).getTitleMarginStart();
      j = ((androidx.appcompat.widget.Toolbar)localObject).getTitleMarginEnd();
      n = ((androidx.appcompat.widget.Toolbar)localObject).getTitleMarginTop();
      m = ((androidx.appcompat.widget.Toolbar)localObject).getTitleMarginBottom();
    }
    else
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        localObject = this.jdField_a_of_type_AndroidViewViewGroup;
        if ((localObject instanceof android.widget.Toolbar))
        {
          localObject = (android.widget.Toolbar)localObject;
          k = ((android.widget.Toolbar)localObject).getTitleMarginStart();
          j = ((android.widget.Toolbar)localObject).getTitleMarginEnd();
          n = ((android.widget.Toolbar)localObject).getTitleMarginTop();
          m = ((android.widget.Toolbar)localObject).getTitleMarginBottom();
          break label162;
        }
      }
      m = 0;
      j = 0;
      n = 0;
    }
    label162:
    localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper;
    int i3 = this.jdField_a_of_type_AndroidGraphicsRect.left;
    int i1;
    if (paramBoolean) {
      i1 = j;
    } else {
      i1 = k;
    }
    int i4 = this.jdField_a_of_type_AndroidGraphicsRect.top;
    int i5 = this.jdField_a_of_type_AndroidGraphicsRect.right;
    if (paramBoolean) {
      j = k;
    }
    ((CollapsingTextHelper)localObject).b(i3 + i1, i4 + i2 + n, i5 - j, this.jdField_a_of_type_AndroidGraphicsRect.bottom + i2 - m);
  }
  
  private static boolean a(View paramView)
  {
    return ((paramView instanceof androidx.appcompat.widget.Toolbar)) || ((Build.VERSION.SDK_INT >= 21) && ((paramView instanceof android.widget.Toolbar)));
  }
  
  private static int b(@NonNull View paramView)
  {
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      return paramView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams)localObject).topMargin + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
    }
    return paramView.getMeasuredHeight();
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject2 = null;
    this.jdField_a_of_type_AndroidViewViewGroup = null;
    this.jdField_a_of_type_AndroidViewView = null;
    int j = this.jdField_c_of_type_Int;
    Object localObject1;
    if (j != -1)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(j));
      localObject1 = this.jdField_a_of_type_AndroidViewViewGroup;
      if (localObject1 != null) {
        this.jdField_a_of_type_AndroidViewView = a((View)localObject1);
      }
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup == null)
    {
      int k = getChildCount();
      j = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (j >= k) {
          break;
        }
        localObject1 = getChildAt(j);
        if (a((View)localObject1))
        {
          localObject1 = (ViewGroup)localObject1;
          break;
        }
        j += 1;
      }
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)localObject1);
    }
    c();
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void b(int paramInt)
  {
    b();
    Object localObject = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if (localObject == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(this.jdField_a_of_type_Long);
      ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
      if (paramInt > this.h) {
        localObject = AnimationUtils.c;
      } else {
        localObject = AnimationUtils.d;
      }
      localValueAnimator.setInterpolator((TimeInterpolator)localObject);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new CollapsingToolbarLayout.2(this));
    }
    else if (((ValueAnimator)localObject).isRunning())
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { this.h, paramInt });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
  }
  
  private boolean b(View paramView)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView != null) && (localView != this))
    {
      if (paramView == localView) {
        return true;
      }
    }
    else if (paramView == this.jdField_a_of_type_AndroidViewViewGroup) {
      return true;
    }
    return false;
  }
  
  private void c()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      Object localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null)
      {
        localObject = ((View)localObject).getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(this.jdField_b_of_type_AndroidViewView);
        }
      }
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewViewGroup != null))
    {
      if (this.jdField_b_of_type_AndroidViewView == null) {
        this.jdField_b_of_type_AndroidViewView = new View(getContext());
      }
      if (this.jdField_b_of_type_AndroidViewView.getParent() == null) {
        this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_b_of_type_AndroidViewView, -1, -1);
      }
    }
  }
  
  private void d()
  {
    setContentDescription(a());
  }
  
  public int a()
  {
    int j = this.i;
    if (j >= 0) {
      return j;
    }
    WindowInsetsCompat localWindowInsetsCompat = this.jdField_a_of_type_AndroidxCoreViewWindowInsetsCompat;
    if (localWindowInsetsCompat != null) {
      j = localWindowInsetsCompat.getSystemWindowInsetTop();
    } else {
      j = 0;
    }
    int k = ViewCompat.getMinimumHeight(this);
    if (k > 0) {
      return Math.min(k * 2 + j, getHeight());
    }
    return getHeight() / 3;
  }
  
  final int a(@NonNull View paramView)
  {
    ViewOffsetHelper localViewOffsetHelper = a(paramView);
    CollapsingToolbarLayout.LayoutParams localLayoutParams = (CollapsingToolbarLayout.LayoutParams)paramView.getLayoutParams();
    return getHeight() - localViewOffsetHelper.b() - paramView.getHeight() - localLayoutParams.bottomMargin;
  }
  
  protected FrameLayout.LayoutParams a(ViewGroup.LayoutParams paramLayoutParams)
  {
    return new CollapsingToolbarLayout.LayoutParams(paramLayoutParams);
  }
  
  WindowInsetsCompat a(@NonNull WindowInsetsCompat paramWindowInsetsCompat)
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
      requestLayout();
    }
    return paramWindowInsetsCompat.consumeSystemWindowInsets();
  }
  
  protected CollapsingToolbarLayout.LayoutParams a()
  {
    return new CollapsingToolbarLayout.LayoutParams(-1, -1);
  }
  
  @Nullable
  public CharSequence a()
  {
    if (this.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a();
    }
    return null;
  }
  
  final void a()
  {
    if ((this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) || (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      boolean bool;
      if (getHeight() + this.jdField_a_of_type_Int < a()) {
        bool = true;
      } else {
        bool = false;
      }
      setScrimsShown(bool);
    }
  }
  
  void a(int paramInt)
  {
    if (paramInt != this.h)
    {
      if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        ViewGroup localViewGroup = this.jdField_a_of_type_AndroidViewViewGroup;
        if (localViewGroup != null) {
          ViewCompat.postInvalidateOnAnimation(localViewGroup);
        }
      }
      this.h = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof CollapsingToolbarLayout.LayoutParams;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    b();
    Object localObject;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null)
    {
      localObject = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      if ((localObject != null) && (this.h > 0))
      {
        ((Drawable)localObject).mutate().setAlpha(this.h);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
    if ((this.jdField_b_of_type_Boolean) && (this.jdField_c_of_type_Boolean)) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(paramCanvas);
    }
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (this.h > 0))
    {
      localObject = this.jdField_a_of_type_AndroidxCoreViewWindowInsetsCompat;
      int j;
      if (localObject != null) {
        j = ((WindowInsetsCompat)localObject).getSystemWindowInsetTop();
      } else {
        j = 0;
      }
      if (j > 0)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, -this.jdField_a_of_type_Int, getWidth(), j - this.jdField_a_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.mutate().setAlpha(this.h);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    boolean bool = true;
    int j;
    if ((localDrawable != null) && (this.h > 0) && (b(paramView)))
    {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.mutate().setAlpha(this.h);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      j = 1;
    }
    else
    {
      j = 0;
    }
    if (!super.drawChild(paramCanvas, paramView, paramLong))
    {
      if (j != 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    int[] arrayOfInt = getDrawableState();
    Object localObject = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((Drawable)localObject).isStateful()) {
        bool1 = false | ((Drawable)localObject).setState(arrayOfInt);
      }
    }
    localObject = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (((Drawable)localObject).isStateful()) {
        bool2 = bool1 | ((Drawable)localObject).setState(arrayOfInt);
      }
    }
    localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper;
    bool1 = bool2;
    if (localObject != null) {
      bool1 = bool2 | ((CollapsingTextHelper)localObject).a(arrayOfInt);
    }
    if (bool1) {
      invalidate();
    }
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return new CollapsingToolbarLayout.LayoutParams(getContext(), paramAttributeSet);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof AppBarLayout))
    {
      ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View)localViewParent));
      if (this.jdField_a_of_type_ComGoogleAndroidMaterialAppbarAppBarLayout$OnOffsetChangedListener == null) {
        this.jdField_a_of_type_ComGoogleAndroidMaterialAppbarAppBarLayout$OnOffsetChangedListener = new CollapsingToolbarLayout.OffsetUpdateListener(this);
      }
      ((AppBarLayout)localViewParent).a(this.jdField_a_of_type_ComGoogleAndroidMaterialAppbarAppBarLayout$OnOffsetChangedListener);
      ViewCompat.requestApplyInsets(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    ViewParent localViewParent = getParent();
    AppBarLayout.OnOffsetChangedListener localOnOffsetChangedListener = this.jdField_a_of_type_ComGoogleAndroidMaterialAppbarAppBarLayout$OnOffsetChangedListener;
    if ((localOnOffsetChangedListener != null) && ((localViewParent instanceof AppBarLayout))) {
      ((AppBarLayout)localViewParent).b(localOnOffsetChangedListener);
    }
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = this.jdField_a_of_type_AndroidxCoreViewWindowInsetsCompat;
    int m = 0;
    int n;
    if (localObject != null)
    {
      k = ((WindowInsetsCompat)localObject).getSystemWindowInsetTop();
      n = getChildCount();
      j = 0;
      while (j < n)
      {
        localObject = getChildAt(j);
        if ((!ViewCompat.getFitsSystemWindows((View)localObject)) && (((View)localObject).getTop() < k)) {
          ViewCompat.offsetTopAndBottom((View)localObject, k);
        }
        j += 1;
      }
    }
    int k = getChildCount();
    int j = 0;
    while (j < k)
    {
      a(getChildAt(j)).a();
      j += 1;
    }
    if (this.jdField_b_of_type_Boolean)
    {
      localObject = this.jdField_b_of_type_AndroidViewView;
      if (localObject != null)
      {
        paramBoolean = ViewCompat.isAttachedToWindow((View)localObject);
        boolean bool = true;
        if ((paramBoolean) && (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        this.jdField_c_of_type_Boolean = paramBoolean;
        if (this.jdField_c_of_type_Boolean)
        {
          if (ViewCompat.getLayoutDirection(this) == 1) {
            paramBoolean = bool;
          } else {
            paramBoolean = false;
          }
          a(paramBoolean);
          localObject = this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper;
          if (paramBoolean) {
            j = this.f;
          } else {
            j = this.jdField_d_of_type_Int;
          }
          n = this.jdField_a_of_type_AndroidGraphicsRect.top;
          int i1 = this.e;
          if (paramBoolean) {
            k = this.jdField_d_of_type_Int;
          } else {
            k = this.f;
          }
          ((CollapsingTextHelper)localObject).a(j, n + i1, paramInt3 - paramInt1 - k, paramInt4 - paramInt2 - this.g);
          this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.b();
        }
      }
    }
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_b_of_type_Boolean) && (TextUtils.isEmpty(this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a()))) {
      setTitle(a(this.jdField_a_of_type_AndroidViewViewGroup));
    }
    a();
    paramInt2 = getChildCount();
    paramInt1 = m;
    while (paramInt1 < paramInt2)
    {
      a(getChildAt(paramInt1)).b();
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    b();
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getMode(paramInt2);
    Object localObject = this.jdField_a_of_type_AndroidxCoreViewWindowInsetsCompat;
    if (localObject != null) {
      paramInt2 = ((WindowInsetsCompat)localObject).getSystemWindowInsetTop();
    } else {
      paramInt2 = 0;
    }
    if ((j == 0) && (paramInt2 > 0)) {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + paramInt2, 1073741824));
    }
    if (this.jdField_a_of_type_AndroidViewViewGroup != null)
    {
      localObject = this.jdField_a_of_type_AndroidViewView;
      if ((localObject != null) && (localObject != this))
      {
        setMinimumHeight(b((View)localObject));
        return;
      }
      setMinimumHeight(b(this.jdField_a_of_type_AndroidViewViewGroup));
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable != null) {
      localDrawable.setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  public void setCollapsedTitleGravity(int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.b(paramInt);
  }
  
  public void setCollapsedTitleTextAppearance(@StyleRes int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.c(paramInt);
  }
  
  public void setCollapsedTitleTextColor(@ColorInt int paramInt)
  {
    setCollapsedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setCollapsedTitleTextColor(@NonNull ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(paramColorStateList);
  }
  
  public void setCollapsedTitleTypeface(@Nullable Typeface paramTypeface)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(paramTypeface);
  }
  
  public void setContentScrim(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable2 = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = localDrawable1;
      paramDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
      if (paramDrawable != null)
      {
        paramDrawable.setBounds(0, 0, getWidth(), getHeight());
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setCallback(this);
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.h);
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setContentScrimColor(@ColorInt int paramInt)
  {
    setContentScrim(new ColorDrawable(paramInt));
  }
  
  public void setContentScrimResource(@DrawableRes int paramInt)
  {
    setContentScrim(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setExpandedTitleColor(@ColorInt int paramInt)
  {
    setExpandedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setExpandedTitleGravity(int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(paramInt);
  }
  
  public void setExpandedTitleMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_d_of_type_Int = paramInt1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramInt4;
    requestLayout();
  }
  
  public void setExpandedTitleMarginBottom(int paramInt)
  {
    this.g = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginEnd(int paramInt)
  {
    this.f = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginStart(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginTop(int paramInt)
  {
    this.e = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleTextAppearance(@StyleRes int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.d(paramInt);
  }
  
  public void setExpandedTitleTextColor(@NonNull ColorStateList paramColorStateList)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.b(paramColorStateList);
  }
  
  public void setExpandedTitleTypeface(@Nullable Typeface paramTypeface)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.b(paramTypeface);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setMaxLines(int paramInt)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.e(paramInt);
  }
  
  public void setScrimAnimationDuration(@IntRange(from=0L) long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setScrimVisibleHeightTrigger(@IntRange(from=0L) int paramInt)
  {
    if (this.i != paramInt)
    {
      this.i = paramInt;
      a();
    }
  }
  
  public void setScrimsShown(boolean paramBoolean)
  {
    boolean bool;
    if ((ViewCompat.isLaidOut(this)) && (!isInEditMode())) {
      bool = true;
    } else {
      bool = false;
    }
    setScrimsShown(paramBoolean, bool);
  }
  
  public void setScrimsShown(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_d_of_type_Boolean != paramBoolean1)
    {
      int j = 255;
      if (paramBoolean2)
      {
        if (!paramBoolean1) {
          j = 0;
        }
        b(j);
      }
      else
      {
        if (!paramBoolean1) {
          j = 0;
        }
        a(j);
      }
      this.jdField_d_of_type_Boolean = paramBoolean1;
    }
  }
  
  public void setStatusBarScrim(@Nullable Drawable paramDrawable)
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
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setAlpha(this.h);
      }
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setStatusBarScrimColor(@ColorInt int paramInt)
  {
    setStatusBarScrim(new ColorDrawable(paramInt));
  }
  
  public void setStatusBarScrimResource(@DrawableRes int paramInt)
  {
    setStatusBarScrim(ContextCompat.getDrawable(getContext(), paramInt));
  }
  
  public void setTitle(@Nullable CharSequence paramCharSequence)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialInternalCollapsingTextHelper.a(paramCharSequence);
    d();
  }
  
  public void setTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      d();
      c();
      requestLayout();
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
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(bool, false);
    }
    localDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setVisible(bool, false);
    }
  }
  
  protected boolean verifyDrawable(@NonNull Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.jdField_b_of_type_AndroidGraphicsDrawableDrawable) || (paramDrawable == this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.appbar.CollapsingToolbarLayout
 * JD-Core Version:    0.7.0.1
 */