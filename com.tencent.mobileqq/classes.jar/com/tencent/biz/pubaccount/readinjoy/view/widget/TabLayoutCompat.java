package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pools.Pool;
import android.support.v4.util.Pools.SimplePool;
import android.support.v4.util.Pools.SynchronizedPool;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.FastOutSlowInInterpolator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TabLayoutCompat
  extends HorizontalScrollView
{
  private static final Pools.Pool<TabLayoutCompat.Tab> jdField_a_of_type_AndroidSupportV4UtilPools$Pool = new Pools.SynchronizedPool(16);
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842901, 16842904 };
  float jdField_a_of_type_Float;
  int jdField_a_of_type_Int;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  ColorStateList jdField_a_of_type_AndroidContentResColorStateList;
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private TabLayoutCompat.AdapterChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$AdapterChangeListener;
  private TabLayoutCompat.OnTabSelectedListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$OnTabSelectedListener;
  private TabLayoutCompat.PagerAdapterObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$PagerAdapterObserver;
  private final TabLayoutCompat.SlidingTabStrip jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip;
  private TabLayoutCompat.Tab jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$Tab;
  private TabLayoutCompat.TabLayoutOnPageChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener;
  private TabLayoutCompat.ViewPagerTabEventListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$ViewPagerTabEventListener;
  ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private final ArrayList<TabLayoutCompat.Tab> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float;
  int jdField_b_of_type_Int;
  private final Pools.Pool<TabLayoutCompat.TabView> jdField_b_of_type_AndroidSupportV4UtilPools$Pool = new Pools.SimplePool(12);
  private TabLayoutCompat.OnTabSelectedListener jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$OnTabSelectedListener;
  private final ArrayList<TabLayoutCompat.OnTabSelectedListener> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private boolean jdField_b_of_type_Boolean;
  int c;
  int d;
  int e;
  int f;
  int g = 2147483647;
  int h;
  int i;
  private final int j;
  private final int k;
  private int l;
  private int m;
  private int n;
  
  public TabLayoutCompat(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TabLayoutCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TabLayoutCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setHorizontalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip = new TabLayoutCompat.SlidingTabStrip(this, paramContext);
    super.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip, 0, new FrameLayout.LayoutParams(-2, -1));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.b(DisplayUtil.a(paramContext, 2.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.a(-1);
    this.d = 0;
    this.c = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.c = 0;
    this.d = 0;
    this.jdField_a_of_type_Float = DisplayUtil.c(paramContext, 12.0F);
    this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-1979711488);
    this.f = 0;
    this.m = 0;
    this.n = 0;
    this.i = 1;
    this.h = 1;
    this.jdField_b_of_type_Float = DisplayUtil.a(paramContext, 12.0F);
    this.l = DisplayUtil.a(paramContext, 72.0F);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.TabLayoutCompat);
    this.j = paramContext.getDimensionPixelSize(7, -1);
    this.k = paramContext.getDimensionPixelSize(6, -1);
    this.jdField_a_of_type_Int = paramContext.getDimensionPixelSize(12, 0);
    this.c = paramContext.getDimensionPixelSize(11, 0);
    this.m = paramContext.getDimensionPixelSize(2, 0);
    this.n = paramContext.getDimensionPixelSize(1, 0);
    paramContext.recycle();
    e();
  }
  
  private int a(int paramInt, float paramFloat)
  {
    int i1 = 0;
    int i2 = 0;
    View localView2;
    View localView1;
    if (this.i == 0)
    {
      localView2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildAt(paramInt);
      if (paramInt + 1 >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildCount()) {
        break label119;
      }
      localView1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildAt(paramInt + 1);
      if (localView2 == null) {
        break label125;
      }
      paramInt = localView2.getWidth();
      label58:
      if (localView2 == null) {
        break label130;
      }
    }
    label130:
    for (i1 = localView2.getLeft();; i1 = 0)
    {
      if (localView1 != null) {
        i2 = localView1.getWidth();
      }
      i1 = i1 + paramInt / 2 - getWidth() / 2;
      paramInt = (int)((i2 + paramInt) * 0.5F * paramFloat);
      if (ViewCompat.getLayoutDirection(this) != 0) {
        break label135;
      }
      i1 = paramInt + i1;
      return i1;
      label119:
      localView1 = null;
      break;
      label125:
      paramInt = 0;
      break label58;
    }
    label135:
    return i1 - paramInt;
  }
  
  private static ColorStateList a(int paramInt1, int paramInt2)
  {
    return new ColorStateList(new int[][] { SELECTED_STATE_SET, EMPTY_STATE_SET }, new int[] { paramInt2, paramInt1 });
  }
  
  private LinearLayout.LayoutParams a()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -1);
    a(localLayoutParams);
    return localLayoutParams;
  }
  
  private TabLayoutCompat.TabView a(@NonNull TabLayoutCompat.Tab paramTab)
  {
    if (this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool != null) {}
    for (TabLayoutCompat.TabView localTabView1 = (TabLayoutCompat.TabView)this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool.acquire();; localTabView1 = null)
    {
      TabLayoutCompat.TabView localTabView2 = localTabView1;
      if (localTabView1 == null) {
        localTabView2 = new TabLayoutCompat.TabView(this, getContext());
      }
      localTabView2.a(paramTab);
      localTabView2.setFocusable(true);
      localTabView2.setMinimumWidth(f());
      return localTabView2;
    }
  }
  
  private void a(int paramInt)
  {
    TabLayoutCompat.TabView localTabView = (TabLayoutCompat.TabView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildAt(paramInt);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.removeViewAt(paramInt);
    if (localTabView != null)
    {
      localTabView.a();
      this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool.release(localTabView);
    }
    requestLayout();
  }
  
  private void a(LinearLayout.LayoutParams paramLayoutParams)
  {
    if ((this.i == 1) && (this.h == 0))
    {
      paramLayoutParams.width = 0;
      paramLayoutParams.weight = 1.0F;
      return;
    }
    paramLayoutParams.width = f();
    paramLayoutParams.weight = 0.0F;
  }
  
  private void a(TabLayoutCompat.Tab paramTab)
  {
    TabLayoutCompat.TabView localTabView = paramTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabView;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.addView(localTabView, paramTab.a(), a());
  }
  
  private void a(TabLayoutCompat.Tab paramTab, int paramInt)
  {
    paramTab.a(paramInt);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, paramTab);
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    paramInt += 1;
    while (paramInt < i1)
    {
      ((TabLayoutCompat.Tab)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(paramInt);
      paramInt += 1;
    }
  }
  
  private void a(@Nullable ViewPagerCompat paramViewPagerCompat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.removeOnPageChangeListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$AdapterChangeListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$AdapterChangeListener);
      }
    }
    if (this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$OnTabSelectedListener != null)
    {
      b(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$OnTabSelectedListener);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$OnTabSelectedListener = null;
    }
    if (paramViewPagerCompat != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = paramViewPagerCompat;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener = new TabLayoutCompat.TabLayoutOnPageChangeListener(this);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener.a();
      paramViewPagerCompat.addOnPageChangeListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener);
      this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$OnTabSelectedListener = new TabLayoutCompat.ViewPagerOnTabSelectedListener(paramViewPagerCompat);
      a(this.jdField_b_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$OnTabSelectedListener);
      PagerAdapter localPagerAdapter = paramViewPagerCompat.getAdapter();
      if (localPagerAdapter != null) {
        a(localPagerAdapter, paramBoolean1);
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$AdapterChangeListener == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$AdapterChangeListener = new TabLayoutCompat.AdapterChangeListener(this);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$AdapterChangeListener.a(paramBoolean1);
      paramViewPagerCompat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$AdapterChangeListener);
      setScrollPosition(paramViewPagerCompat.getCurrentItem(), 0.0F, true);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = paramBoolean2;
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = null;
      a(null, false);
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() == null) || (!ViewCompat.isLaidOut(this)) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.a()))
    {
      setScrollPosition(paramInt, 0.0F, true);
      return;
    }
    int i1 = getScrollX();
    int i2 = a(paramInt, 0.0F);
    if (i1 != i2)
    {
      d();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setIntValues(new int[] { i1, i2 });
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.b(paramInt, 300);
  }
  
  private void b(@NonNull TabLayoutCompat.Tab paramTab)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((TabLayoutCompat.OnTabSelectedListener)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).a(paramTab);
      i1 -= 1;
    }
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((TabLayoutCompat.Tab)localIterator.next()).c();
    }
  }
  
  private void c(int paramInt)
  {
    int i2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildCount();
    if (paramInt < i2)
    {
      int i1 = 0;
      if (i1 < i2)
      {
        View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildAt(i1);
        if (i1 == paramInt) {}
        for (boolean bool = true;; bool = false)
        {
          localView.setSelected(bool);
          i1 += 1;
          break;
        }
      }
    }
  }
  
  private void c(@NonNull TabLayoutCompat.Tab paramTab)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((TabLayoutCompat.OnTabSelectedListener)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).b(paramTab);
      i1 -= 1;
    }
  }
  
  private int d()
  {
    return Math.max(0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new FastOutSlowInInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new TabLayoutCompat.1(this));
    }
  }
  
  private int e()
  {
    int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      TabLayoutCompat.Tab localTab = (TabLayoutCompat.Tab)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if ((localTab == null) || (localTab.a() == null) || (TextUtils.isEmpty(localTab.a()))) {}
    }
    for (i1 = 1;; i1 = 0)
    {
      if (i1 != 0)
      {
        return 72;
        i1 += 1;
        break;
      }
      return 48;
    }
  }
  
  private void e()
  {
    int i2 = this.m;
    int i1 = this.n;
    if (this.i == 0)
    {
      i2 = Math.max(0, this.m - this.jdField_a_of_type_Int);
      i1 = Math.max(0, this.n - this.c);
    }
    ViewCompat.setPaddingRelative(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip, i2, 0, i1, 0);
    switch (this.i)
    {
    }
    for (;;)
    {
      a(true);
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.setGravity(1);
      continue;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.setGravity(8388611);
    }
  }
  
  private int f()
  {
    if (this.j != -1) {
      return this.j;
    }
    if (this.i == 0) {
      return this.l;
    }
    return 0;
  }
  
  private void f(@NonNull TabLayoutCompat.Tab paramTab)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((TabLayoutCompat.OnTabSelectedListener)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).c(paramTab);
      i1 -= 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  int a(int paramInt)
  {
    return Math.round(getResources().getDisplayMetrics().density * paramInt);
  }
  
  @NonNull
  public TabLayoutCompat.Tab a()
  {
    TabLayoutCompat.Tab localTab2 = (TabLayoutCompat.Tab)jdField_a_of_type_AndroidSupportV4UtilPools$Pool.acquire();
    TabLayoutCompat.Tab localTab1 = localTab2;
    if (localTab2 == null) {
      localTab1 = new TabLayoutCompat.Tab();
    }
    localTab1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = this;
    localTab1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabView = a(localTab1);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$ViewPagerTabEventListener != null) {
      localTab1.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$ViewPagerTabEventListener.a(localTab1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabView));
    }
    return localTab1;
  }
  
  @Nullable
  public TabLayoutCompat.Tab a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= a())) {
      return null;
    }
    return (TabLayoutCompat.Tab)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a()
  {
    int i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildCount() - 1;
    while (i1 >= 0)
    {
      a(i1);
      i1 -= 1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      TabLayoutCompat.Tab localTab = (TabLayoutCompat.Tab)localIterator.next();
      localIterator.remove();
      localTab.d();
      jdField_a_of_type_AndroidSupportV4UtilPools$Pool.release(localTab);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$Tab = null;
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = Math.round(paramInt + paramFloat);
    if ((i1 < 0) || (i1 >= this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildCount())) {}
    do
    {
      return;
      if (paramBoolean2) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.a(paramInt, paramFloat);
      }
      if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      scrollTo(a(paramInt, paramFloat), 0);
    } while (!paramBoolean1);
    c(i1);
  }
  
  void a(@Nullable PagerAdapter paramPagerAdapter, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$PagerAdapterObserver != null)) {
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.unregisterDataSetObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$PagerAdapterObserver);
    }
    this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = paramPagerAdapter;
    if (paramPagerAdapter != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$PagerAdapterObserver == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$PagerAdapterObserver = new TabLayoutCompat.PagerAdapterObserver(this);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$PagerAdapterObserver.a(paramBoolean);
      paramPagerAdapter.registerDataSetObserver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$PagerAdapterObserver);
    }
    b();
  }
  
  public void a(@NonNull TabLayoutCompat.OnTabSelectedListener paramOnTabSelectedListener)
  {
    if (!this.jdField_b_of_type_JavaUtilArrayList.contains(paramOnTabSelectedListener)) {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramOnTabSelectedListener);
    }
  }
  
  public void a(@NonNull TabLayoutCompat.Tab paramTab, int paramInt, boolean paramBoolean)
  {
    if (paramTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat != this) {
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }
    a(paramTab, paramInt);
    a(paramTab);
    if (paramBoolean) {
      paramTab.a();
    }
  }
  
  public void a(@NonNull TabLayoutCompat.Tab paramTab, boolean paramBoolean)
  {
    a(paramTab, this.jdField_a_of_type_JavaUtilArrayList.size(), paramBoolean);
  }
  
  void a(boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildCount())
    {
      View localView = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.getChildAt(i1);
      localView.setMinimumWidth(f());
      a((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean) {
        localView.requestLayout();
      }
      i1 += 1;
    }
  }
  
  public void addView(View paramView)
  {
    QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
  }
  
  public void addView(View paramView, int paramInt)
  {
    QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
  }
  
  public void addView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    QLog.e("TabLayoutCompat", 2, "TabLayoutCompat#addView had been deprecated !", new IllegalAccessException("call addTab instead !"));
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$Tab != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$Tab.a();
    }
    return -1;
  }
  
  void b()
  {
    a();
    if (this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null)
    {
      int i2 = this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getCount();
      int i1 = 0;
      while (i1 < i2)
      {
        a(a().a(this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.getPageTitle(i1)), false);
        i1 += 1;
      }
      if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat != null) && (i2 > 0))
      {
        i1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.getCurrentItem();
        if ((i1 != b()) && (i1 < a())) {
          e(a(i1));
        }
      }
    }
  }
  
  public void b(@NonNull TabLayoutCompat.OnTabSelectedListener paramOnTabSelectedListener)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramOnTabSelectedListener);
  }
  
  void b(TabLayoutCompat.Tab paramTab, boolean paramBoolean)
  {
    TabLayoutCompat.Tab localTab = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$Tab;
    if (localTab == paramTab)
    {
      if (localTab != null)
      {
        f(paramTab);
        b(paramTab.a());
      }
      return;
    }
    int i1;
    if (paramTab != null)
    {
      i1 = paramTab.a();
      label40:
      if (paramBoolean)
      {
        if (((localTab != null) && (localTab.a() != -1)) || (i1 == -1)) {
          break label111;
        }
        setScrollPosition(i1, 0.0F, true);
      }
    }
    for (;;)
    {
      if (i1 != -1) {
        c(i1);
      }
      if (localTab != null) {
        c(localTab);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$Tab = paramTab;
      if (paramTab == null) {
        break;
      }
      b(paramTab);
      return;
      i1 = -1;
      break label40;
      label111:
      b(i1);
    }
  }
  
  int c()
  {
    return this.g;
  }
  
  void c(TabLayoutCompat.Tab paramTab, boolean paramBoolean)
  {
    TabLayoutCompat.Tab localTab = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$Tab;
    if (localTab == paramTab)
    {
      if (localTab != null) {
        b(paramTab.a());
      }
      return;
    }
    int i1;
    if (paramTab != null)
    {
      i1 = paramTab.a();
      if (paramBoolean)
      {
        if (((localTab != null) && (localTab.a() != -1)) || (i1 == -1)) {
          break label86;
        }
        setScrollPosition(i1, 0.0F, true);
      }
    }
    for (;;)
    {
      if (i1 != -1) {
        c(i1);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$Tab = paramTab;
      return;
      i1 = -1;
      break;
      label86:
      b(i1);
    }
  }
  
  public void d(@NonNull TabLayoutCompat.Tab paramTab)
  {
    a(paramTab, this.jdField_a_of_type_JavaUtilArrayList.isEmpty());
  }
  
  void e(TabLayoutCompat.Tab paramTab)
  {
    b(paramTab, true);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return generateDefaultLayoutParams();
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat == null)
    {
      ViewParent localViewParent = getParent();
      if ((localViewParent instanceof ViewPagerCompat)) {
        a((ViewPagerCompat)localViewParent, true, true);
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_Boolean)
    {
      setupWithViewPager(null);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    int i2 = 1;
    int i1 = a(e()) + getPaddingTop() + getPaddingBottom();
    label76:
    View localView;
    switch (View.MeasureSpec.getMode(paramInt2))
    {
    default: 
      i1 = View.MeasureSpec.getSize(paramInt1);
      if (View.MeasureSpec.getMode(paramInt1) != 0)
      {
        if (this.k > 0)
        {
          i1 = this.k;
          this.g = i1;
        }
      }
      else
      {
        super.onMeasure(paramInt1, paramInt2);
        if (getChildCount() == 1)
        {
          localView = getChildAt(0);
          switch (this.i)
          {
          default: 
            paramInt1 = 0;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        paramInt1 = getChildMeasureSpec(paramInt2, getPaddingTop() + getPaddingBottom(), localView.getLayoutParams().height);
        localView.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), paramInt1);
      }
      return;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(Math.min(i1, View.MeasureSpec.getSize(paramInt2)), 1073741824);
      break;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i1, 1073741824);
      break;
      i1 -= a(56);
      break label76;
      if (localView.getMeasuredWidth() < getMeasuredWidth()) {
        paramInt1 = 1;
      } else {
        paramInt1 = 0;
      }
    }
    if (localView.getMeasuredWidth() != getMeasuredWidth()) {}
    for (paramInt1 = i2;; paramInt1 = 0) {
      break;
    }
  }
  
  public void setCutomViewBeRelated(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  @Deprecated
  public void setOnTabSelectedListener(@Nullable TabLayoutCompat.OnTabSelectedListener paramOnTabSelectedListener)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$OnTabSelectedListener != null) {
      b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$OnTabSelectedListener);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$OnTabSelectedListener = paramOnTabSelectedListener;
    if (paramOnTabSelectedListener != null) {
      a(paramOnTabSelectedListener);
    }
  }
  
  public void setOverScrollMode(int paramInt)
  {
    super.setOverScrollMode(2);
  }
  
  public void setScrollPosition(int paramInt, float paramFloat, boolean paramBoolean)
  {
    a(paramInt, paramFloat, paramBoolean, true);
  }
  
  public void setScrollableTabMinWidth(int paramInt)
  {
    this.l = paramInt;
  }
  
  public void setSelectedTabIndicatorColor(@ColorInt int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.a(paramInt);
  }
  
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.b(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingBottom(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.e(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingLeft(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.c(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingRight(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$SlidingTabStrip.d(paramInt);
  }
  
  public void setTabBackgroundResId(int paramInt)
  {
    if (this.f != paramInt)
    {
      this.f = paramInt;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        TabLayoutCompat.Tab localTab = (TabLayoutCompat.Tab)localIterator.next();
        if (localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabView != null) {
          localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabView.setBackgroundResource(this.f);
        }
      }
    }
  }
  
  public void setTabGravity(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      e();
    }
  }
  
  public void setTabMode(int paramInt)
  {
    if (paramInt != this.i)
    {
      this.i = paramInt;
      e();
    }
  }
  
  public void setTabTextColors(int paramInt1, int paramInt2)
  {
    setTabTextColors(a(paramInt1, paramInt2));
  }
  
  public void setTabTextColors(@Nullable ColorStateList paramColorStateList)
  {
    if (this.jdField_a_of_type_AndroidContentResColorStateList != paramColorStateList)
    {
      this.jdField_a_of_type_AndroidContentResColorStateList = paramColorStateList;
      c();
    }
  }
  
  public void setTabTextSize(int paramInt)
  {
    if (this.jdField_a_of_type_Float != paramInt)
    {
      this.jdField_a_of_type_Float = paramInt;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        TabLayoutCompat.Tab localTab = (TabLayoutCompat.Tab)localIterator.next();
        if ((localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabView != null) && (TabLayoutCompat.TabView.a(localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabView) != null)) {
          TabLayoutCompat.TabView.a(localTab.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabView).setTextSize(this.jdField_a_of_type_Float);
        }
      }
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(@Nullable PagerAdapter paramPagerAdapter)
  {
    a(paramPagerAdapter, false);
  }
  
  public void setViewPagerTabEventListener(TabLayoutCompat.ViewPagerTabEventListener paramViewPagerTabEventListener)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$ViewPagerTabEventListener = paramViewPagerTabEventListener;
  }
  
  public void setupWithViewPager(@Nullable ViewPagerCompat paramViewPagerCompat)
  {
    setupWithViewPager(paramViewPagerCompat, true);
  }
  
  public void setupWithViewPager(@Nullable ViewPagerCompat paramViewPagerCompat, boolean paramBoolean)
  {
    a(paramViewPagerCompat, paramBoolean, false);
  }
  
  public boolean shouldDelayChildPressedState()
  {
    return d() > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat
 * JD-Core Version:    0.7.0.1
 */