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
  private static final int e = com.google.android.material.R.style.m;
  @NonNull
  final CollapsingTextHelper a;
  @Nullable
  Drawable b;
  int c;
  @Nullable
  WindowInsetsCompat d;
  private boolean f = true;
  private int g;
  @Nullable
  private ViewGroup h;
  @Nullable
  private View i;
  private View j;
  private int k;
  private int l;
  private int m;
  private int n;
  private final Rect o = new Rect();
  private boolean p;
  private boolean q;
  @Nullable
  private Drawable r;
  private int s;
  private boolean t;
  private ValueAnimator u;
  private long v;
  private int w = -1;
  private AppBarLayout.OnOffsetChangedListener x;
  
  public CollapsingToolbarLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public CollapsingToolbarLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.m);
  }
  
  public CollapsingToolbarLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, e), paramAttributeSet, paramInt);
    paramContext = getContext();
    this.a = new CollapsingTextHelper(this);
    this.a.a(AnimationUtils.e);
    paramContext = ThemeEnforcement.a(paramContext, paramAttributeSet, R.styleable.bR, paramInt, e, new int[0]);
    this.a.a(paramContext.getInt(R.styleable.bV, 8388691));
    this.a.b(paramContext.getInt(R.styleable.bS, 8388627));
    paramInt = paramContext.getDimensionPixelSize(R.styleable.bW, 0);
    this.n = paramInt;
    this.m = paramInt;
    this.l = paramInt;
    this.k = paramInt;
    if (paramContext.hasValue(R.styleable.bZ)) {
      this.k = paramContext.getDimensionPixelSize(R.styleable.bZ, 0);
    }
    if (paramContext.hasValue(R.styleable.bY)) {
      this.m = paramContext.getDimensionPixelSize(R.styleable.bY, 0);
    }
    if (paramContext.hasValue(R.styleable.ca)) {
      this.l = paramContext.getDimensionPixelSize(R.styleable.ca, 0);
    }
    if (paramContext.hasValue(R.styleable.bX)) {
      this.n = paramContext.getDimensionPixelSize(R.styleable.bX, 0);
    }
    this.p = paramContext.getBoolean(R.styleable.ch, true);
    setTitle(paramContext.getText(R.styleable.cg));
    this.a.d(com.google.android.material.R.style.e);
    this.a.c(androidx.appcompat.R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
    if (paramContext.hasValue(R.styleable.cb)) {
      this.a.d(paramContext.getResourceId(R.styleable.cb, 0));
    }
    if (paramContext.hasValue(R.styleable.bT)) {
      this.a.c(paramContext.getResourceId(R.styleable.bT, 0));
    }
    this.w = paramContext.getDimensionPixelSize(R.styleable.ce, -1);
    if (paramContext.hasValue(R.styleable.cc)) {
      this.a.e(paramContext.getInt(R.styleable.cc, 1));
    }
    this.v = paramContext.getInt(R.styleable.cd, 600);
    setContentScrim(paramContext.getDrawable(R.styleable.bU));
    setStatusBarScrim(paramContext.getDrawable(R.styleable.cf));
    this.g = paramContext.getResourceId(R.styleable.ci, -1);
    paramContext.recycle();
    setWillNotDraw(false);
    ViewCompat.setOnApplyWindowInsetsListener(this, new CollapsingToolbarLayout.1(this));
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
  
  private void a(int paramInt)
  {
    c();
    Object localObject = this.u;
    if (localObject == null)
    {
      this.u = new ValueAnimator();
      this.u.setDuration(this.v);
      ValueAnimator localValueAnimator = this.u;
      if (paramInt > this.s) {
        localObject = AnimationUtils.c;
      } else {
        localObject = AnimationUtils.d;
      }
      localValueAnimator.setInterpolator((TimeInterpolator)localObject);
      this.u.addUpdateListener(new CollapsingToolbarLayout.2(this));
    }
    else if (((ValueAnimator)localObject).isRunning())
    {
      this.u.cancel();
    }
    this.u.setIntValues(new int[] { this.s, paramInt });
    this.u.start();
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject = this.i;
    if (localObject == null) {
      localObject = this.h;
    }
    int i6 = b((View)localObject);
    DescendantOffsetUtils.b(this, this.j, this.o);
    localObject = this.h;
    boolean bool = localObject instanceof androidx.appcompat.widget.Toolbar;
    int i2 = 0;
    int i1;
    int i4;
    int i3;
    if (bool)
    {
      localObject = (androidx.appcompat.widget.Toolbar)localObject;
      i2 = ((androidx.appcompat.widget.Toolbar)localObject).getTitleMarginStart();
      i1 = ((androidx.appcompat.widget.Toolbar)localObject).getTitleMarginEnd();
      i4 = ((androidx.appcompat.widget.Toolbar)localObject).getTitleMarginTop();
      i3 = ((androidx.appcompat.widget.Toolbar)localObject).getTitleMarginBottom();
    }
    else
    {
      if (Build.VERSION.SDK_INT >= 24)
      {
        localObject = this.h;
        if ((localObject instanceof android.widget.Toolbar))
        {
          localObject = (android.widget.Toolbar)localObject;
          i2 = ((android.widget.Toolbar)localObject).getTitleMarginStart();
          i1 = ((android.widget.Toolbar)localObject).getTitleMarginEnd();
          i4 = ((android.widget.Toolbar)localObject).getTitleMarginTop();
          i3 = ((android.widget.Toolbar)localObject).getTitleMarginBottom();
          break label162;
        }
      }
      i3 = 0;
      i1 = 0;
      i4 = 0;
    }
    label162:
    localObject = this.a;
    int i7 = this.o.left;
    int i5;
    if (paramBoolean) {
      i5 = i1;
    } else {
      i5 = i2;
    }
    int i8 = this.o.top;
    int i9 = this.o.right;
    if (paramBoolean) {
      i1 = i2;
    }
    ((CollapsingTextHelper)localObject).b(i7 + i5, i8 + i6 + i4, i9 - i1, this.o.bottom + i6 - i3);
  }
  
  private void c()
  {
    if (!this.f) {
      return;
    }
    Object localObject2 = null;
    this.h = null;
    this.i = null;
    int i1 = this.g;
    Object localObject1;
    if (i1 != -1)
    {
      this.h = ((ViewGroup)findViewById(i1));
      localObject1 = this.h;
      if (localObject1 != null) {
        this.i = e((View)localObject1);
      }
    }
    if (this.h == null)
    {
      int i2 = getChildCount();
      i1 = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i1 >= i2) {
          break;
        }
        localObject1 = getChildAt(i1);
        if (c((View)localObject1))
        {
          localObject1 = (ViewGroup)localObject1;
          break;
        }
        i1 += 1;
      }
      this.h = ((ViewGroup)localObject1);
    }
    d();
    this.f = false;
  }
  
  private static boolean c(View paramView)
  {
    return ((paramView instanceof androidx.appcompat.widget.Toolbar)) || ((Build.VERSION.SDK_INT >= 21) && ((paramView instanceof android.widget.Toolbar)));
  }
  
  private void d()
  {
    if (!this.p)
    {
      Object localObject = this.j;
      if (localObject != null)
      {
        localObject = ((View)localObject).getParent();
        if ((localObject instanceof ViewGroup)) {
          ((ViewGroup)localObject).removeView(this.j);
        }
      }
    }
    if ((this.p) && (this.h != null))
    {
      if (this.j == null) {
        this.j = new View(getContext());
      }
      if (this.j.getParent() == null) {
        this.h.addView(this.j, -1, -1);
      }
    }
  }
  
  private boolean d(View paramView)
  {
    View localView = this.i;
    if ((localView != null) && (localView != this))
    {
      if (paramView == localView) {
        return true;
      }
    }
    else if (paramView == this.h) {
      return true;
    }
    return false;
  }
  
  @NonNull
  private View e(@NonNull View paramView)
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
  
  private void e()
  {
    setContentDescription(getTitle());
  }
  
  private static CharSequence f(View paramView)
  {
    if ((paramView instanceof androidx.appcompat.widget.Toolbar)) {
      return ((androidx.appcompat.widget.Toolbar)paramView).getTitle();
    }
    if ((Build.VERSION.SDK_INT >= 21) && ((paramView instanceof android.widget.Toolbar))) {
      return ((android.widget.Toolbar)paramView).getTitle();
    }
    return null;
  }
  
  private static int g(@NonNull View paramView)
  {
    Object localObject = paramView.getLayoutParams();
    if ((localObject instanceof ViewGroup.MarginLayoutParams))
    {
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      return paramView.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams)localObject).topMargin + ((ViewGroup.MarginLayoutParams)localObject).bottomMargin;
    }
    return paramView.getMeasuredHeight();
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
    if (!ObjectsCompat.equals(this.d, localWindowInsetsCompat))
    {
      this.d = localWindowInsetsCompat;
      requestLayout();
    }
    return paramWindowInsetsCompat.consumeSystemWindowInsets();
  }
  
  protected CollapsingToolbarLayout.LayoutParams a()
  {
    return new CollapsingToolbarLayout.LayoutParams(-1, -1);
  }
  
  final int b(@NonNull View paramView)
  {
    ViewOffsetHelper localViewOffsetHelper = a(paramView);
    CollapsingToolbarLayout.LayoutParams localLayoutParams = (CollapsingToolbarLayout.LayoutParams)paramView.getLayoutParams();
    return getHeight() - localViewOffsetHelper.d() - paramView.getHeight() - localLayoutParams.bottomMargin;
  }
  
  final void b()
  {
    if ((this.r != null) || (this.b != null))
    {
      boolean bool;
      if (getHeight() + this.c < getScrimVisibleHeightTrigger()) {
        bool = true;
      } else {
        bool = false;
      }
      setScrimsShown(bool);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return paramLayoutParams instanceof CollapsingToolbarLayout.LayoutParams;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    c();
    Object localObject;
    if (this.h == null)
    {
      localObject = this.r;
      if ((localObject != null) && (this.s > 0))
      {
        ((Drawable)localObject).mutate().setAlpha(this.s);
        this.r.draw(paramCanvas);
      }
    }
    if ((this.p) && (this.q)) {
      this.a.a(paramCanvas);
    }
    if ((this.b != null) && (this.s > 0))
    {
      localObject = this.d;
      int i1;
      if (localObject != null) {
        i1 = ((WindowInsetsCompat)localObject).getSystemWindowInsetTop();
      } else {
        i1 = 0;
      }
      if (i1 > 0)
      {
        this.b.setBounds(0, -this.c, getWidth(), i1 - this.c);
        this.b.mutate().setAlpha(this.s);
        this.b.draw(paramCanvas);
      }
    }
  }
  
  protected boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    Drawable localDrawable = this.r;
    boolean bool = true;
    int i1;
    if ((localDrawable != null) && (this.s > 0) && (d(paramView)))
    {
      this.r.mutate().setAlpha(this.s);
      this.r.draw(paramCanvas);
      i1 = 1;
    }
    else
    {
      i1 = 0;
    }
    if (!super.drawChild(paramCanvas, paramView, paramLong))
    {
      if (i1 != 0) {
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
    Object localObject = this.b;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (((Drawable)localObject).isStateful()) {
        bool1 = false | ((Drawable)localObject).setState(arrayOfInt);
      }
    }
    localObject = this.r;
    bool2 = bool1;
    if (localObject != null)
    {
      bool2 = bool1;
      if (((Drawable)localObject).isStateful()) {
        bool2 = bool1 | ((Drawable)localObject).setState(arrayOfInt);
      }
    }
    localObject = this.a;
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
  
  public int getCollapsedTitleGravity()
  {
    return this.a.f();
  }
  
  @NonNull
  public Typeface getCollapsedTitleTypeface()
  {
    return this.a.g();
  }
  
  @Nullable
  public Drawable getContentScrim()
  {
    return this.r;
  }
  
  public int getExpandedTitleGravity()
  {
    return this.a.e();
  }
  
  public int getExpandedTitleMarginBottom()
  {
    return this.n;
  }
  
  public int getExpandedTitleMarginEnd()
  {
    return this.m;
  }
  
  public int getExpandedTitleMarginStart()
  {
    return this.k;
  }
  
  public int getExpandedTitleMarginTop()
  {
    return this.l;
  }
  
  @NonNull
  public Typeface getExpandedTitleTypeface()
  {
    return this.a.h();
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public int getMaxLines()
  {
    return this.a.n();
  }
  
  int getScrimAlpha()
  {
    return this.s;
  }
  
  public long getScrimAnimationDuration()
  {
    return this.v;
  }
  
  public int getScrimVisibleHeightTrigger()
  {
    int i1 = this.w;
    if (i1 >= 0) {
      return i1;
    }
    WindowInsetsCompat localWindowInsetsCompat = this.d;
    if (localWindowInsetsCompat != null) {
      i1 = localWindowInsetsCompat.getSystemWindowInsetTop();
    } else {
      i1 = 0;
    }
    int i2 = ViewCompat.getMinimumHeight(this);
    if (i2 > 0) {
      return Math.min(i2 * 2 + i1, getHeight());
    }
    return getHeight() / 3;
  }
  
  @Nullable
  public Drawable getStatusBarScrim()
  {
    return this.b;
  }
  
  @Nullable
  public CharSequence getTitle()
  {
    if (this.p) {
      return this.a.m();
    }
    return null;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof AppBarLayout))
    {
      ViewCompat.setFitsSystemWindows(this, ViewCompat.getFitsSystemWindows((View)localViewParent));
      if (this.x == null) {
        this.x = new CollapsingToolbarLayout.OffsetUpdateListener(this);
      }
      ((AppBarLayout)localViewParent).a(this.x);
      ViewCompat.requestApplyInsets(this);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    ViewParent localViewParent = getParent();
    AppBarLayout.OnOffsetChangedListener localOnOffsetChangedListener = this.x;
    if ((localOnOffsetChangedListener != null) && ((localViewParent instanceof AppBarLayout))) {
      ((AppBarLayout)localViewParent).b(localOnOffsetChangedListener);
    }
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    Object localObject = this.d;
    int i3 = 0;
    int i4;
    if (localObject != null)
    {
      i2 = ((WindowInsetsCompat)localObject).getSystemWindowInsetTop();
      i4 = getChildCount();
      i1 = 0;
      while (i1 < i4)
      {
        localObject = getChildAt(i1);
        if ((!ViewCompat.getFitsSystemWindows((View)localObject)) && (((View)localObject).getTop() < i2)) {
          ViewCompat.offsetTopAndBottom((View)localObject, i2);
        }
        i1 += 1;
      }
    }
    int i2 = getChildCount();
    int i1 = 0;
    while (i1 < i2)
    {
      a(getChildAt(i1)).a();
      i1 += 1;
    }
    if (this.p)
    {
      localObject = this.j;
      if (localObject != null)
      {
        paramBoolean = ViewCompat.isAttachedToWindow((View)localObject);
        boolean bool = true;
        if ((paramBoolean) && (this.j.getVisibility() == 0)) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
        this.q = paramBoolean;
        if (this.q)
        {
          if (ViewCompat.getLayoutDirection(this) == 1) {
            paramBoolean = bool;
          } else {
            paramBoolean = false;
          }
          a(paramBoolean);
          localObject = this.a;
          if (paramBoolean) {
            i1 = this.m;
          } else {
            i1 = this.k;
          }
          i4 = this.o.top;
          int i5 = this.l;
          if (paramBoolean) {
            i2 = this.k;
          } else {
            i2 = this.m;
          }
          ((CollapsingTextHelper)localObject).a(i1, i4 + i5, paramInt3 - paramInt1 - i2, paramInt4 - paramInt2 - this.n);
          this.a.l();
        }
      }
    }
    if ((this.h != null) && (this.p) && (TextUtils.isEmpty(this.a.m()))) {
      setTitle(f(this.h));
    }
    b();
    paramInt2 = getChildCount();
    paramInt1 = i3;
    while (paramInt1 < paramInt2)
    {
      a(getChildAt(paramInt1)).b();
      paramInt1 += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    c();
    super.onMeasure(paramInt1, paramInt2);
    int i1 = View.MeasureSpec.getMode(paramInt2);
    Object localObject = this.d;
    if (localObject != null) {
      paramInt2 = ((WindowInsetsCompat)localObject).getSystemWindowInsetTop();
    } else {
      paramInt2 = 0;
    }
    if ((i1 == 0) && (paramInt2 > 0)) {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + paramInt2, 1073741824));
    }
    if (this.h != null)
    {
      localObject = this.i;
      if ((localObject != null) && (localObject != this))
      {
        setMinimumHeight(g((View)localObject));
        return;
      }
      setMinimumHeight(g(this.h));
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    Drawable localDrawable = this.r;
    if (localDrawable != null) {
      localDrawable.setBounds(0, 0, paramInt1, paramInt2);
    }
  }
  
  public void setCollapsedTitleGravity(int paramInt)
  {
    this.a.b(paramInt);
  }
  
  public void setCollapsedTitleTextAppearance(@StyleRes int paramInt)
  {
    this.a.c(paramInt);
  }
  
  public void setCollapsedTitleTextColor(@ColorInt int paramInt)
  {
    setCollapsedTitleTextColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setCollapsedTitleTextColor(@NonNull ColorStateList paramColorStateList)
  {
    this.a.a(paramColorStateList);
  }
  
  public void setCollapsedTitleTypeface(@Nullable Typeface paramTypeface)
  {
    this.a.a(paramTypeface);
  }
  
  public void setContentScrim(@Nullable Drawable paramDrawable)
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
        paramDrawable.setBounds(0, 0, getWidth(), getHeight());
        this.r.setCallback(this);
        this.r.setAlpha(this.s);
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
    this.a.a(paramInt);
  }
  
  public void setExpandedTitleMargin(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.k = paramInt1;
    this.l = paramInt2;
    this.m = paramInt3;
    this.n = paramInt4;
    requestLayout();
  }
  
  public void setExpandedTitleMarginBottom(int paramInt)
  {
    this.n = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginEnd(int paramInt)
  {
    this.m = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginStart(int paramInt)
  {
    this.k = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleMarginTop(int paramInt)
  {
    this.l = paramInt;
    requestLayout();
  }
  
  public void setExpandedTitleTextAppearance(@StyleRes int paramInt)
  {
    this.a.d(paramInt);
  }
  
  public void setExpandedTitleTextColor(@NonNull ColorStateList paramColorStateList)
  {
    this.a.b(paramColorStateList);
  }
  
  public void setExpandedTitleTypeface(@Nullable Typeface paramTypeface)
  {
    this.a.b(paramTypeface);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void setMaxLines(int paramInt)
  {
    this.a.e(paramInt);
  }
  
  void setScrimAlpha(int paramInt)
  {
    if (paramInt != this.s)
    {
      if (this.r != null)
      {
        ViewGroup localViewGroup = this.h;
        if (localViewGroup != null) {
          ViewCompat.postInvalidateOnAnimation(localViewGroup);
        }
      }
      this.s = paramInt;
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  public void setScrimAnimationDuration(@IntRange(from=0L) long paramLong)
  {
    this.v = paramLong;
  }
  
  public void setScrimVisibleHeightTrigger(@IntRange(from=0L) int paramInt)
  {
    if (this.w != paramInt)
    {
      this.w = paramInt;
      b();
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
    if (this.t != paramBoolean1)
    {
      int i1 = 255;
      if (paramBoolean2)
      {
        if (!paramBoolean1) {
          i1 = 0;
        }
        a(i1);
      }
      else
      {
        if (!paramBoolean1) {
          i1 = 0;
        }
        setScrimAlpha(i1);
      }
      this.t = paramBoolean1;
    }
  }
  
  public void setStatusBarScrim(@Nullable Drawable paramDrawable)
  {
    Drawable localDrawable2 = this.b;
    if (localDrawable2 != paramDrawable)
    {
      Drawable localDrawable1 = null;
      if (localDrawable2 != null) {
        localDrawable2.setCallback(null);
      }
      if (paramDrawable != null) {
        localDrawable1 = paramDrawable.mutate();
      }
      this.b = localDrawable1;
      paramDrawable = this.b;
      if (paramDrawable != null)
      {
        if (paramDrawable.isStateful()) {
          this.b.setState(getDrawableState());
        }
        DrawableCompat.setLayoutDirection(this.b, ViewCompat.getLayoutDirection(this));
        paramDrawable = this.b;
        boolean bool;
        if (getVisibility() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        paramDrawable.setVisible(bool, false);
        this.b.setCallback(this);
        this.b.setAlpha(this.s);
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
    this.a.a(paramCharSequence);
    e();
  }
  
  public void setTitleEnabled(boolean paramBoolean)
  {
    if (paramBoolean != this.p)
    {
      this.p = paramBoolean;
      e();
      d();
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
    Drawable localDrawable = this.b;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      this.b.setVisible(bool, false);
    }
    localDrawable = this.r;
    if ((localDrawable != null) && (localDrawable.isVisible() != bool)) {
      this.r.setVisible(bool, false);
    }
  }
  
  protected boolean verifyDrawable(@NonNull Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.r) || (paramDrawable == this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.appbar.CollapsingToolbarLayout
 * JD-Core Version:    0.7.0.1
 */