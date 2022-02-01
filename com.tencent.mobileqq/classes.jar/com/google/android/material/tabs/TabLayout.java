package com.google.android.material.tabs;

import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.BoolRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.util.Pools.Pool;
import androidx.core.util.Pools.SimplePool;
import androidx.core.util.Pools.SynchronizedPool;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat.CollectionInfoCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.DecorView;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import com.google.android.material.R.attr;
import com.google.android.material.R.dimen;
import com.google.android.material.R.style;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Iterator;

@ViewPager.DecorView
public class TabLayout
  extends HorizontalScrollView
{
  private static final int y = R.style.q;
  private static final Pools.Pool<TabLayout.Tab> z = new Pools.SynchronizedPool(16);
  private final ArrayList<TabLayout.Tab> A = new ArrayList();
  @Nullable
  private TabLayout.Tab B;
  private int C = 0;
  private final int D;
  private final int E;
  private final int F;
  private int G;
  private TabIndicatorInterpolator H;
  @Nullable
  private TabLayout.BaseOnTabSelectedListener I;
  private final ArrayList<TabLayout.BaseOnTabSelectedListener> J = new ArrayList();
  @Nullable
  private TabLayout.BaseOnTabSelectedListener K;
  private ValueAnimator L;
  @Nullable
  private PagerAdapter M;
  private DataSetObserver N;
  private TabLayout.TabLayoutOnPageChangeListener O;
  private TabLayout.AdapterChangeListener P;
  private boolean Q;
  private final Pools.Pool<TabLayout.TabView> R = new Pools.SimplePool(12);
  @NonNull
  final TabLayout.SlidingTabIndicator a;
  int b;
  int c;
  int d;
  int e;
  int f;
  ColorStateList g;
  ColorStateList h;
  ColorStateList i;
  @NonNull
  Drawable j = new GradientDrawable();
  PorterDuff.Mode k;
  float l;
  float m;
  final int n;
  int o = 2147483647;
  int p;
  int q;
  int r;
  int s;
  boolean t;
  boolean u;
  int v;
  boolean w;
  @Nullable
  ViewPager x;
  
  public TabLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.Z);
  }
  
  public TabLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(MaterialThemeOverlay.a(paramContext, paramAttributeSet, paramInt, y), paramAttributeSet, paramInt);
    paramContext = getContext();
    setHorizontalScrollBarEnabled(false);
    this.a = new TabLayout.SlidingTabIndicator(this, paramContext);
    super.addView(this.a, 0, new FrameLayout.LayoutParams(-2, -1));
    paramAttributeSet = ThemeEnforcement.a(paramContext, paramAttributeSet, com.google.android.material.R.styleable.hk, paramInt, y, new int[] { com.google.android.material.R.styleable.hI });
    if ((getBackground() instanceof ColorDrawable))
    {
      localObject = (ColorDrawable)getBackground();
      MaterialShapeDrawable localMaterialShapeDrawable = new MaterialShapeDrawable();
      localMaterialShapeDrawable.g(ColorStateList.valueOf(((ColorDrawable)localObject).getColor()));
      localMaterialShapeDrawable.a(paramContext);
      localMaterialShapeDrawable.r(ViewCompat.getElevation(this));
      ViewCompat.setBackground(this, localMaterialShapeDrawable);
    }
    setSelectedTabIndicator(MaterialResources.b(paramContext, paramAttributeSet, com.google.android.material.R.styleable.hq));
    setSelectedTabIndicatorColor(paramAttributeSet.getColor(com.google.android.material.R.styleable.ht, 0));
    this.a.a(paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.hw, -1));
    setSelectedTabIndicatorGravity(paramAttributeSet.getInt(com.google.android.material.R.styleable.hv, 0));
    setTabIndicatorFullWidth(paramAttributeSet.getBoolean(com.google.android.material.R.styleable.hu, true));
    setTabIndicatorAnimationMode(paramAttributeSet.getInt(com.google.android.material.R.styleable.hs, 0));
    paramInt = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.hB, 0);
    this.e = paramInt;
    this.d = paramInt;
    this.c = paramInt;
    this.b = paramInt;
    this.b = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.hE, this.b);
    this.c = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.hF, this.c);
    this.d = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.hD, this.d);
    this.e = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.hC, this.e);
    this.f = paramAttributeSet.getResourceId(com.google.android.material.R.styleable.hI, R.style.f);
    Object localObject = paramContext.obtainStyledAttributes(this.f, androidx.appcompat.R.styleable.TextAppearance);
    try
    {
      this.l = ((TypedArray)localObject).getDimensionPixelSize(androidx.appcompat.R.styleable.TextAppearance_android_textSize, 0);
      this.g = MaterialResources.a(paramContext, (TypedArray)localObject, androidx.appcompat.R.styleable.TextAppearance_android_textColor);
      ((TypedArray)localObject).recycle();
      if (paramAttributeSet.hasValue(com.google.android.material.R.styleable.hJ)) {
        this.g = MaterialResources.a(paramContext, paramAttributeSet, com.google.android.material.R.styleable.hJ);
      }
      if (paramAttributeSet.hasValue(com.google.android.material.R.styleable.hH))
      {
        paramInt = paramAttributeSet.getColor(com.google.android.material.R.styleable.hH, 0);
        this.g = a(this.g.getDefaultColor(), paramInt);
      }
      this.h = MaterialResources.a(paramContext, paramAttributeSet, com.google.android.material.R.styleable.ho);
      this.k = ViewUtils.a(paramAttributeSet.getInt(com.google.android.material.R.styleable.hp, -1), null);
      this.i = MaterialResources.a(paramContext, paramAttributeSet, com.google.android.material.R.styleable.hG);
      this.q = paramAttributeSet.getInt(com.google.android.material.R.styleable.hr, 300);
      this.D = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.hz, -1);
      this.E = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.hy, -1);
      this.n = paramAttributeSet.getResourceId(com.google.android.material.R.styleable.hl, 0);
      this.G = paramAttributeSet.getDimensionPixelSize(com.google.android.material.R.styleable.hm, 0);
      this.s = paramAttributeSet.getInt(com.google.android.material.R.styleable.hA, 1);
      this.p = paramAttributeSet.getInt(com.google.android.material.R.styleable.hn, 0);
      this.t = paramAttributeSet.getBoolean(com.google.android.material.R.styleable.hx, false);
      this.w = paramAttributeSet.getBoolean(com.google.android.material.R.styleable.hK, false);
      paramAttributeSet.recycle();
      paramContext = getResources();
      this.m = paramContext.getDimensionPixelSize(R.dimen.r);
      this.F = paramContext.getDimensionPixelSize(R.dimen.q);
      i();
      return;
    }
    finally
    {
      ((TypedArray)localObject).recycle();
    }
  }
  
  private int a(int paramInt, float paramFloat)
  {
    int i2 = this.s;
    int i1 = 0;
    if ((i2 != 0) && (i2 != 2)) {
      return 0;
    }
    View localView2 = this.a.getChildAt(paramInt);
    paramInt += 1;
    View localView1;
    if (paramInt < this.a.getChildCount()) {
      localView1 = this.a.getChildAt(paramInt);
    } else {
      localView1 = null;
    }
    if (localView2 != null) {
      paramInt = localView2.getWidth();
    } else {
      paramInt = 0;
    }
    if (localView1 != null) {
      i1 = localView1.getWidth();
    }
    i2 = localView2.getLeft() + paramInt / 2 - getWidth() / 2;
    paramInt = (int)((paramInt + i1) * 0.5F * paramFloat);
    if (ViewCompat.getLayoutDirection(this) == 0) {
      return i2 + paramInt;
    }
    return i2 - paramInt;
  }
  
  @NonNull
  private static ColorStateList a(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt2, paramInt1 });
  }
  
  private void a(View paramView)
  {
    if ((paramView instanceof TabItem))
    {
      a((TabItem)paramView);
      return;
    }
    throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
  }
  
  private void a(@NonNull LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.s == 1) && (this.p == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = -2;
    paramLayoutParams.weight = 0.0F;
  }
  
  private void a(@Nullable ViewPager paramViewPager, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.x;
    if (localObject != null)
    {
      TabLayout.TabLayoutOnPageChangeListener localTabLayoutOnPageChangeListener = this.O;
      if (localTabLayoutOnPageChangeListener != null) {
        ((ViewPager)localObject).removeOnPageChangeListener(localTabLayoutOnPageChangeListener);
      }
      localObject = this.P;
      if (localObject != null) {
        this.x.removeOnAdapterChangeListener((ViewPager.OnAdapterChangeListener)localObject);
      }
    }
    localObject = this.K;
    if (localObject != null)
    {
      b((TabLayout.BaseOnTabSelectedListener)localObject);
      this.K = null;
    }
    if (paramViewPager != null)
    {
      this.x = paramViewPager;
      if (this.O == null) {
        this.O = new TabLayout.TabLayoutOnPageChangeListener(this);
      }
      this.O.a();
      paramViewPager.addOnPageChangeListener(this.O);
      this.K = new TabLayout.ViewPagerOnTabSelectedListener(paramViewPager);
      a(this.K);
      localObject = paramViewPager.getAdapter();
      if (localObject != null) {
        a((PagerAdapter)localObject, paramBoolean1);
      }
      if (this.P == null) {
        this.P = new TabLayout.AdapterChangeListener(this);
      }
      this.P.a(paramBoolean1);
      paramViewPager.addOnAdapterChangeListener(this.P);
      setScrollPosition(paramViewPager.getCurrentItem(), 0.0F, true);
    }
    else
    {
      this.x = null;
      a(null, false);
    }
    this.Q = paramBoolean2;
  }
  
  private void a(@NonNull TabItem paramTabItem)
  {
    TabLayout.Tab localTab = a();
    if (paramTabItem.a != null) {
      localTab.a(paramTabItem.a);
    }
    if (paramTabItem.b != null) {
      localTab.a(paramTabItem.b);
    }
    if (paramTabItem.c != 0) {
      localTab.a(paramTabItem.c);
    }
    if (!TextUtils.isEmpty(paramTabItem.getContentDescription())) {
      localTab.b(paramTabItem.getContentDescription());
    }
    a(localTab);
  }
  
  private void a(@NonNull TabLayout.Tab paramTab, int paramInt)
  {
    paramTab.b(paramInt);
    this.A.add(paramInt, paramTab);
    int i1 = this.A.size();
    for (;;)
    {
      paramInt += 1;
      if (paramInt >= i1) {
        break;
      }
      ((TabLayout.Tab)this.A.get(paramInt)).b(paramInt);
    }
  }
  
  private void b(int paramInt)
  {
    TabLayout.TabView localTabView = (TabLayout.TabView)this.a.getChildAt(paramInt);
    this.a.removeViewAt(paramInt);
    if (localTabView != null)
    {
      localTabView.a();
      this.R.release(localTabView);
    }
    requestLayout();
  }
  
  private void c(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() != null) && (ViewCompat.isLaidOut(this)) && (!this.a.a()))
    {
      int i1 = getScrollX();
      int i2 = a(paramInt, 0.0F);
      if (i1 != i2)
      {
        h();
        this.L.setIntValues(new int[] { i1, i2 });
        this.L.start();
      }
      this.a.a(paramInt, this.q);
      return;
    }
    setScrollPosition(paramInt, 0.0F, true);
  }
  
  @NonNull
  private TabLayout.TabView d(@NonNull TabLayout.Tab paramTab)
  {
    Object localObject1 = this.R;
    if (localObject1 != null) {
      localObject1 = (TabLayout.TabView)((Pools.Pool)localObject1).acquire();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new TabLayout.TabView(this, getContext());
    }
    ((TabLayout.TabView)localObject2).setTab(paramTab);
    ((TabLayout.TabView)localObject2).setFocusable(true);
    ((TabLayout.TabView)localObject2).setMinimumWidth(getTabMinWidth());
    if (TextUtils.isEmpty(TabLayout.Tab.b(paramTab)))
    {
      ((TabLayout.TabView)localObject2).setContentDescription(TabLayout.Tab.c(paramTab));
      return localObject2;
    }
    ((TabLayout.TabView)localObject2).setContentDescription(TabLayout.Tab.b(paramTab));
    return localObject2;
  }
  
  private void d(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt == 2) {}
      }
      else {
        this.a.setGravity(1);
      }
    }
    else {
      Log.w("TabLayout", "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead");
    }
    this.a.setGravity(8388611);
  }
  
  private void e(@NonNull TabLayout.Tab paramTab)
  {
    TabLayout.TabView localTabView = paramTab.b;
    localTabView.setSelected(false);
    localTabView.setActivated(false);
    this.a.addView(localTabView, paramTab.c(), g());
  }
  
  private void f()
  {
    int i2 = this.A.size();
    int i1 = 0;
    while (i1 < i2)
    {
      ((TabLayout.Tab)this.A.get(i1)).h();
      i1 += 1;
    }
  }
  
  private void f(@NonNull TabLayout.Tab paramTab)
  {
    int i1 = this.J.size() - 1;
    while (i1 >= 0)
    {
      ((TabLayout.BaseOnTabSelectedListener)this.J.get(i1)).a(paramTab);
      i1 -= 1;
    }
  }
  
  @NonNull
  private LinearLayout.LayoutParams g()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(localLayoutParams);
    return localLayoutParams;
  }
  
  private void g(@NonNull TabLayout.Tab paramTab)
  {
    int i1 = this.J.size() - 1;
    while (i1 >= 0)
    {
      ((TabLayout.BaseOnTabSelectedListener)this.J.get(i1)).b(paramTab);
      i1 -= 1;
    }
  }
  
  @Dimension(unit=0)
  private int getDefaultHeight()
  {
    int i4 = this.A.size();
    int i3 = 0;
    int i1 = 0;
    int i2;
    for (;;)
    {
      i2 = i3;
      if (i1 >= i4) {
        break;
      }
      TabLayout.Tab localTab = (TabLayout.Tab)this.A.get(i1);
      if ((localTab != null) && (localTab.b() != null) && (!TextUtils.isEmpty(localTab.d())))
      {
        i2 = 1;
        break;
      }
      i1 += 1;
    }
    if ((i2 != 0) && (!this.t)) {
      return 72;
    }
    return 48;
  }
  
  private int getTabMinWidth()
  {
    int i1 = this.D;
    if (i1 != -1) {
      return i1;
    }
    i1 = this.s;
    if ((i1 != 0) && (i1 != 2)) {
      return 0;
    }
    return this.F;
  }
  
  private int getTabScrollRange()
  {
    return Math.max(0, this.a.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void h()
  {
    if (this.L == null)
    {
      this.L = new ValueAnimator();
      this.L.setInterpolator(AnimationUtils.b);
      this.L.setDuration(this.q);
      this.L.addUpdateListener(new TabLayout.1(this));
    }
  }
  
  private void h(@NonNull TabLayout.Tab paramTab)
  {
    int i1 = this.J.size() - 1;
    while (i1 >= 0)
    {
      ((TabLayout.BaseOnTabSelectedListener)this.J.get(i1)).c(paramTab);
      i1 -= 1;
    }
  }
  
  private void i()
  {
    int i1 = this.s;
    if ((i1 != 0) && (i1 != 2)) {
      i1 = 0;
    } else {
      i1 = Math.max(0, this.G - this.b);
    }
    ViewCompat.setPaddingRelative(this.a, i1, 0, 0, 0);
    i1 = this.s;
    if (i1 != 0)
    {
      if ((i1 == 1) || (i1 == 2))
      {
        if (this.p == 2) {
          Log.w("TabLayout", "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead");
        }
        this.a.setGravity(1);
      }
    }
    else {
      d(this.p);
    }
    a(true);
  }
  
  private void setSelectedTabView(int paramInt)
  {
    int i2 = this.a.getChildCount();
    if (paramInt < i2)
    {
      int i1 = 0;
      while (i1 < i2)
      {
        View localView = this.a.getChildAt(i1);
        boolean bool2 = true;
        boolean bool1;
        if (i1 == paramInt) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        localView.setSelected(bool1);
        if (i1 == paramInt) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        localView.setActivated(bool1);
        i1 += 1;
      }
    }
  }
  
  @NonNull
  public TabLayout.Tab a()
  {
    TabLayout.Tab localTab = b();
    localTab.a = this;
    localTab.b = d(localTab);
    if (TabLayout.Tab.a(localTab) != -1) {
      localTab.b.setId(TabLayout.Tab.a(localTab));
    }
    return localTab;
  }
  
  @Nullable
  public TabLayout.Tab a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < getTabCount())) {
      return (TabLayout.Tab)this.A.get(paramInt);
    }
    return null;
  }
  
  void a(@Nullable PagerAdapter paramPagerAdapter, boolean paramBoolean)
  {
    PagerAdapter localPagerAdapter = this.M;
    if (localPagerAdapter != null)
    {
      DataSetObserver localDataSetObserver = this.N;
      if (localDataSetObserver != null) {
        localPagerAdapter.unregisterDataSetObserver(localDataSetObserver);
      }
    }
    this.M = paramPagerAdapter;
    if ((paramBoolean) && (paramPagerAdapter != null))
    {
      if (this.N == null) {
        this.N = new TabLayout.PagerAdapterObserver(this);
      }
      paramPagerAdapter.registerDataSetObserver(this.N);
    }
    e();
  }
  
  @Deprecated
  public void a(@Nullable TabLayout.BaseOnTabSelectedListener paramBaseOnTabSelectedListener)
  {
    if (!this.J.contains(paramBaseOnTabSelectedListener)) {
      this.J.add(paramBaseOnTabSelectedListener);
    }
  }
  
  public void a(@NonNull TabLayout.Tab paramTab)
  {
    a(paramTab, this.A.isEmpty());
  }
  
  public void a(@NonNull TabLayout.Tab paramTab, int paramInt, boolean paramBoolean)
  {
    if (paramTab.a == this)
    {
      a(paramTab, paramInt);
      e(paramTab);
      if (paramBoolean) {
        paramTab.f();
      }
      return;
    }
    throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
  }
  
  public void a(@NonNull TabLayout.Tab paramTab, boolean paramBoolean)
  {
    a(paramTab, this.A.size(), paramBoolean);
  }
  
  void a(boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < this.a.getChildCount())
    {
      View localView = this.a.getChildAt(i1);
      localView.setMinimumWidth(getTabMinWidth());
      a((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean) {
        localView.requestLayout();
      }
      i1 += 1;
    }
  }
  
  public void addView(View paramView)
  {
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt)
  {
    a(paramView);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    a(paramView);
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    a(paramView);
  }
  
  protected TabLayout.Tab b()
  {
    TabLayout.Tab localTab2 = (TabLayout.Tab)z.acquire();
    TabLayout.Tab localTab1 = localTab2;
    if (localTab2 == null) {
      localTab1 = new TabLayout.Tab();
    }
    return localTab1;
  }
  
  @Deprecated
  public void b(@Nullable TabLayout.BaseOnTabSelectedListener paramBaseOnTabSelectedListener)
  {
    this.J.remove(paramBaseOnTabSelectedListener);
  }
  
  public void b(@Nullable TabLayout.Tab paramTab, boolean paramBoolean)
  {
    TabLayout.Tab localTab = this.B;
    if (localTab == paramTab)
    {
      if (localTab != null)
      {
        h(paramTab);
        c(paramTab.c());
      }
    }
    else
    {
      int i1;
      if (paramTab != null) {
        i1 = paramTab.c();
      } else {
        i1 = -1;
      }
      if (paramBoolean)
      {
        if (((localTab == null) || (localTab.c() == -1)) && (i1 != -1)) {
          setScrollPosition(i1, 0.0F, true);
        } else {
          c(i1);
        }
        if (i1 != -1) {
          setSelectedTabView(i1);
        }
      }
      this.B = paramTab;
      if (localTab != null) {
        g(localTab);
      }
      if (paramTab != null) {
        f(paramTab);
      }
    }
  }
  
  protected boolean b(TabLayout.Tab paramTab)
  {
    return z.release(paramTab);
  }
  
  public void c()
  {
    int i1 = this.a.getChildCount() - 1;
    while (i1 >= 0)
    {
      b(i1);
      i1 -= 1;
    }
    Iterator localIterator = this.A.iterator();
    while (localIterator.hasNext())
    {
      TabLayout.Tab localTab = (TabLayout.Tab)localIterator.next();
      localIterator.remove();
      localTab.i();
      b(localTab);
    }
    this.B = null;
  }
  
  public void c(@Nullable TabLayout.Tab paramTab)
  {
    b(paramTab, true);
  }
  
  public boolean d()
  {
    return this.u;
  }
  
  void e()
  {
    c();
    Object localObject = this.M;
    if (localObject != null)
    {
      int i2 = ((PagerAdapter)localObject).getCount();
      int i1 = 0;
      while (i1 < i2)
      {
        a(a().a(this.M.getPageTitle(i1)), false);
        i1 += 1;
      }
      localObject = this.x;
      if ((localObject != null) && (i2 > 0))
      {
        i1 = ((ViewPager)localObject).getCurrentItem();
        if ((i1 != getSelectedTabPosition()) && (i1 < getTabCount())) {
          c(a(i1));
        }
      }
    }
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return generateDefaultLayoutParams();
  }
  
  public int getSelectedTabPosition()
  {
    TabLayout.Tab localTab = this.B;
    if (localTab != null) {
      return localTab.c();
    }
    return -1;
  }
  
  public int getTabCount()
  {
    return this.A.size();
  }
  
  public int getTabGravity()
  {
    return this.p;
  }
  
  @Nullable
  public ColorStateList getTabIconTint()
  {
    return this.h;
  }
  
  public int getTabIndicatorAnimationMode()
  {
    return this.v;
  }
  
  public int getTabIndicatorGravity()
  {
    return this.r;
  }
  
  int getTabMaxWidth()
  {
    return this.o;
  }
  
  public int getTabMode()
  {
    return this.s;
  }
  
  @Nullable
  public ColorStateList getTabRippleColor()
  {
    return this.i;
  }
  
  @NonNull
  public Drawable getTabSelectedIndicator()
  {
    return this.j;
  }
  
  @Nullable
  public ColorStateList getTabTextColors()
  {
    return this.g;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    MaterialShapeUtils.a(this);
    if (this.x == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ViewPager)) {
        a((ViewPager)localViewParent, true, true);
      }
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.Q)
    {
      setupWithViewPager(null);
      this.Q = false;
    }
  }
  
  protected void onDraw(@NonNull Canvas paramCanvas)
  {
    int i1 = 0;
    while (i1 < this.a.getChildCount())
    {
      View localView = this.a.getChildAt(i1);
      if ((localView instanceof TabLayout.TabView)) {
        TabLayout.TabView.a((TabLayout.TabView)localView, paramCanvas);
      }
      i1 += 1;
    }
    super.onDraw(paramCanvas);
  }
  
  public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    super.onInitializeAccessibilityNodeInfo(paramAccessibilityNodeInfo);
    AccessibilityNodeInfoCompat.wrap(paramAccessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getTabCount(), false, 1));
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i3 = Math.round(ViewUtils.a(getContext(), getDefaultHeight()));
    int i1 = View.MeasureSpec.getMode(paramInt2);
    int i2 = 0;
    if (i1 != -2147483648)
    {
      if (i1 != 0) {
        i1 = paramInt2;
      } else {
        i1 = View.MeasureSpec.makeMeasureSpec(i3 + getPaddingTop() + getPaddingBottom(), 1073741824);
      }
    }
    else
    {
      i1 = paramInt2;
      if (getChildCount() == 1)
      {
        i1 = paramInt2;
        if (View.MeasureSpec.getSize(paramInt2) >= i3)
        {
          getChildAt(0).setMinimumHeight(i3);
          i1 = paramInt2;
        }
      }
    }
    i3 = View.MeasureSpec.getSize(paramInt1);
    if (View.MeasureSpec.getMode(paramInt1) != 0)
    {
      paramInt2 = this.E;
      if (paramInt2 <= 0) {
        paramInt2 = (int)(i3 - ViewUtils.a(getContext(), 56));
      }
      this.o = paramInt2;
    }
    super.onMeasure(paramInt1, i1);
    if (getChildCount() == 1)
    {
      View localView = getChildAt(0);
      paramInt1 = this.s;
      if (paramInt1 != 0) {
        if (paramInt1 != 1)
        {
          if (paramInt1 != 2)
          {
            paramInt1 = i2;
            break label224;
          }
        }
        else
        {
          paramInt1 = i2;
          if (localView.getMeasuredWidth() == getMeasuredWidth()) {
            break label224;
          }
        }
      }
      do
      {
        paramInt1 = 1;
        break;
        paramInt1 = i2;
      } while (localView.getMeasuredWidth() < getMeasuredWidth());
      label224:
      if (paramInt1 != 0)
      {
        paramInt1 = getChildMeasureSpec(i1, getPaddingTop() + getPaddingBottom(), localView.getLayoutParams().height);
        localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), paramInt1);
      }
    }
  }
  
  @RequiresApi(21)
  public void setElevation(float paramFloat)
  {
    super.setElevation(paramFloat);
    MaterialShapeUtils.a(this, paramFloat);
  }
  
  public void setInlineLabel(boolean paramBoolean)
  {
    if (this.t != paramBoolean)
    {
      this.t = paramBoolean;
      int i1 = 0;
      while (i1 < this.a.getChildCount())
      {
        View localView = this.a.getChildAt(i1);
        if ((localView instanceof TabLayout.TabView)) {
          ((TabLayout.TabView)localView).c();
        }
        i1 += 1;
      }
      i();
    }
  }
  
  public void setInlineLabelResource(@BoolRes int paramInt)
  {
    setInlineLabel(getResources().getBoolean(paramInt));
  }
  
  @Deprecated
  public void setOnTabSelectedListener(@Nullable TabLayout.BaseOnTabSelectedListener paramBaseOnTabSelectedListener)
  {
    TabLayout.BaseOnTabSelectedListener localBaseOnTabSelectedListener = this.I;
    if (localBaseOnTabSelectedListener != null) {
      b(localBaseOnTabSelectedListener);
    }
    this.I = paramBaseOnTabSelectedListener;
    if (paramBaseOnTabSelectedListener != null) {
      a(paramBaseOnTabSelectedListener);
    }
  }
  
  @Deprecated
  public void setOnTabSelectedListener(@Nullable TabLayout.OnTabSelectedListener paramOnTabSelectedListener)
  {
    setOnTabSelectedListener(paramOnTabSelectedListener);
  }
  
  void setScrollAnimatorListener(Animator.AnimatorListener paramAnimatorListener)
  {
    h();
    this.L.addListener(paramAnimatorListener);
  }
  
  public void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean)
  {
    setScrollPosition(paramInt, paramFloat, paramBoolean, true);
  }
  
  public void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = Math.round(paramInt + paramFloat);
    if (i1 >= 0)
    {
      if (i1 >= this.a.getChildCount()) {
        return;
      }
      if (paramBoolean2) {
        this.a.a(paramInt, paramFloat);
      }
      ValueAnimator localValueAnimator = this.L;
      if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
        this.L.cancel();
      }
      scrollTo(a(paramInt, paramFloat), 0);
      if (paramBoolean1) {
        setSelectedTabView(i1);
      }
    }
  }
  
  public void setSelectedTabIndicator(@DrawableRes int paramInt)
  {
    if (paramInt != 0)
    {
      setSelectedTabIndicator(AppCompatResources.getDrawable(getContext(), paramInt));
      return;
    }
    setSelectedTabIndicator(null);
  }
  
  public void setSelectedTabIndicator(@Nullable Drawable paramDrawable)
  {
    if (this.j != paramDrawable)
    {
      if (paramDrawable == null) {
        paramDrawable = new GradientDrawable();
      }
      this.j = paramDrawable;
    }
  }
  
  public void setSelectedTabIndicatorColor(@ColorInt int paramInt)
  {
    this.C = paramInt;
  }
  
  public void setSelectedTabIndicatorGravity(int paramInt)
  {
    if (this.r != paramInt)
    {
      this.r = paramInt;
      ViewCompat.postInvalidateOnAnimation(this.a);
    }
  }
  
  @Deprecated
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void setTabGravity(int paramInt)
  {
    if (this.p != paramInt)
    {
      this.p = paramInt;
      i();
    }
  }
  
  public void setTabIconTint(@Nullable ColorStateList paramColorStateList)
  {
    if (this.h != paramColorStateList)
    {
      this.h = paramColorStateList;
      f();
    }
  }
  
  public void setTabIconTintResource(@ColorRes int paramInt)
  {
    setTabIconTint(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setTabIndicatorAnimationMode(int paramInt)
  {
    this.v = paramInt;
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        this.H = new ElasticTabIndicatorInterpolator();
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" is not a valid TabIndicatorAnimationMode");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    this.H = new TabIndicatorInterpolator();
  }
  
  public void setTabIndicatorFullWidth(boolean paramBoolean)
  {
    this.u = paramBoolean;
    ViewCompat.postInvalidateOnAnimation(this.a);
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != this.s)
    {
      this.s = paramInt;
      i();
    }
  }
  
  public void setTabRippleColor(@Nullable ColorStateList paramColorStateList)
  {
    if (this.i != paramColorStateList)
    {
      this.i = paramColorStateList;
      int i1 = 0;
      while (i1 < this.a.getChildCount())
      {
        paramColorStateList = this.a.getChildAt(i1);
        if ((paramColorStateList instanceof TabLayout.TabView)) {
          TabLayout.TabView.a((TabLayout.TabView)paramColorStateList, getContext());
        }
        i1 += 1;
      }
    }
  }
  
  public void setTabRippleColorResource(@ColorRes int paramInt)
  {
    setTabRippleColor(AppCompatResources.getColorStateList(getContext(), paramInt));
  }
  
  public void setTabTextColors(int paramInt1, int paramInt2)
  {
    setTabTextColors(a(paramInt1, paramInt2));
  }
  
  public void setTabTextColors(@Nullable ColorStateList paramColorStateList)
  {
    if (this.g != paramColorStateList)
    {
      this.g = paramColorStateList;
      f();
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(@Nullable PagerAdapter paramPagerAdapter)
  {
    a(paramPagerAdapter, false);
  }
  
  public void setUnboundedRipple(boolean paramBoolean)
  {
    if (this.w != paramBoolean)
    {
      this.w = paramBoolean;
      int i1 = 0;
      while (i1 < this.a.getChildCount())
      {
        View localView = this.a.getChildAt(i1);
        if ((localView instanceof TabLayout.TabView)) {
          TabLayout.TabView.a((TabLayout.TabView)localView, getContext());
        }
        i1 += 1;
      }
    }
  }
  
  public void setUnboundedRippleResource(@BoolRes int paramInt)
  {
    setUnboundedRipple(getResources().getBoolean(paramInt));
  }
  
  public void setupWithViewPager(@Nullable ViewPager paramViewPager)
  {
    setupWithViewPager(paramViewPager, true);
  }
  
  public void setupWithViewPager(@Nullable ViewPager paramViewPager, boolean paramBoolean)
  {
    a(paramViewPager, paramBoolean, false);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return getTabScrollRange() > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.tabs.TabLayout
 * JD-Core Version:    0.7.0.1
 */