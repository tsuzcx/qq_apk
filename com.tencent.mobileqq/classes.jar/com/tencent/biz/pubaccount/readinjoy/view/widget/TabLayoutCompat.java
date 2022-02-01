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
import bhgr;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import szs;
import szt;
import szu;
import szv;
import szw;
import szz;
import taa;
import tab;
import tac;

public class TabLayoutCompat
  extends HorizontalScrollView
{
  private static final Pools.Pool<szz> jdField_a_of_type_AndroidSupportV4UtilPools$Pool = new Pools.SynchronizedPool(16);
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842901, 16842904 };
  public float a;
  public int a;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  public ColorStateList a;
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private TabLayoutCompat.TabLayoutOnPageChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener;
  public ViewPagerCompat a;
  private final ArrayList<szz> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private szt jdField_a_of_type_Szt;
  private szu jdField_a_of_type_Szu;
  private szv jdField_a_of_type_Szv;
  private final szw jdField_a_of_type_Szw;
  private szz jdField_a_of_type_Szz;
  private tac jdField_a_of_type_Tac;
  private boolean jdField_a_of_type_Boolean;
  public float b;
  public int b;
  private final Pools.Pool<taa> jdField_b_of_type_AndroidSupportV4UtilPools$Pool = new Pools.SimplePool(12);
  private final ArrayList<szu> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private szu jdField_b_of_type_Szu;
  private boolean jdField_b_of_type_Boolean;
  public int c;
  public int d;
  public int e;
  public int f;
  public int g = 2147483647;
  public int h;
  public int i;
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
    this.jdField_a_of_type_Szw = new szw(this, paramContext);
    super.addView(this.jdField_a_of_type_Szw, 0, new FrameLayout.LayoutParams(-2, -1));
    this.jdField_a_of_type_Szw.b(bhgr.a(paramContext, 2.0F));
    this.jdField_a_of_type_Szw.a(-1);
    this.d = 0;
    this.c = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.c = 0;
    this.d = 0;
    this.jdField_a_of_type_Float = bhgr.c(paramContext, 12.0F);
    this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-1979711488);
    this.f = 0;
    this.m = 0;
    this.n = 0;
    this.i = 1;
    this.h = 1;
    this.jdField_b_of_type_Float = bhgr.a(paramContext, 12.0F);
    this.l = bhgr.a(paramContext, 72.0F);
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
      localView2 = this.jdField_a_of_type_Szw.getChildAt(paramInt);
      if (paramInt + 1 >= this.jdField_a_of_type_Szw.getChildCount()) {
        break label119;
      }
      localView1 = this.jdField_a_of_type_Szw.getChildAt(paramInt + 1);
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
  
  private taa a(@NonNull szz paramszz)
  {
    if (this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool != null) {}
    for (taa localtaa1 = (taa)this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool.acquire();; localtaa1 = null)
    {
      taa localtaa2 = localtaa1;
      if (localtaa1 == null) {
        localtaa2 = new taa(this, getContext());
      }
      localtaa2.a(paramszz);
      localtaa2.setFocusable(true);
      localtaa2.setMinimumWidth(f());
      return localtaa2;
    }
  }
  
  private void a(int paramInt)
  {
    taa localtaa = (taa)this.jdField_a_of_type_Szw.getChildAt(paramInt);
    this.jdField_a_of_type_Szw.removeViewAt(paramInt);
    if (localtaa != null)
    {
      localtaa.a();
      this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool.release(localtaa);
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
  
  private void a(@Nullable ViewPagerCompat paramViewPagerCompat, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat != null)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.removeOnPageChangeListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener);
      }
      if (this.jdField_a_of_type_Szt != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.b(this.jdField_a_of_type_Szt);
      }
    }
    if (this.jdField_b_of_type_Szu != null)
    {
      b(this.jdField_b_of_type_Szu);
      this.jdField_b_of_type_Szu = null;
    }
    if (paramViewPagerCompat != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = paramViewPagerCompat;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener = new TabLayoutCompat.TabLayoutOnPageChangeListener(this);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener.a();
      paramViewPagerCompat.addOnPageChangeListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener);
      this.jdField_b_of_type_Szu = new tab(paramViewPagerCompat);
      a(this.jdField_b_of_type_Szu);
      PagerAdapter localPagerAdapter = paramViewPagerCompat.getAdapter();
      if (localPagerAdapter != null) {
        a(localPagerAdapter, paramBoolean1);
      }
      if (this.jdField_a_of_type_Szt == null) {
        this.jdField_a_of_type_Szt = new szt(this);
      }
      this.jdField_a_of_type_Szt.a(paramBoolean1);
      paramViewPagerCompat.a(this.jdField_a_of_type_Szt);
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
  
  private void a(szz paramszz)
  {
    taa localtaa = paramszz.jdField_a_of_type_Taa;
    this.jdField_a_of_type_Szw.addView(localtaa, paramszz.a(), a());
  }
  
  private void a(szz paramszz, int paramInt)
  {
    paramszz.a(paramInt);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, paramszz);
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    paramInt += 1;
    while (paramInt < i1)
    {
      ((szz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(paramInt);
      paramInt += 1;
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() == null) || (!ViewCompat.isLaidOut(this)) || (this.jdField_a_of_type_Szw.a()))
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
    this.jdField_a_of_type_Szw.b(paramInt, 300);
  }
  
  private void b(@NonNull szz paramszz)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((szu)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).a(paramszz);
      i1 -= 1;
    }
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((szz)localIterator.next()).c();
    }
  }
  
  private void c(int paramInt)
  {
    int i2 = this.jdField_a_of_type_Szw.getChildCount();
    if (paramInt < i2)
    {
      int i1 = 0;
      if (i1 < i2)
      {
        View localView = this.jdField_a_of_type_Szw.getChildAt(i1);
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
  
  private void c(@NonNull szz paramszz)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((szu)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).b(paramszz);
      i1 -= 1;
    }
  }
  
  private int d()
  {
    return Math.max(0, this.jdField_a_of_type_Szw.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new FastOutSlowInInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new szs(this));
    }
  }
  
  private int e()
  {
    int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      szz localszz = (szz)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if ((localszz == null) || (localszz.a() == null) || (TextUtils.isEmpty(localszz.a()))) {}
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
    ViewCompat.setPaddingRelative(this.jdField_a_of_type_Szw, i2, 0, i1, 0);
    switch (this.i)
    {
    }
    for (;;)
    {
      a(true);
      return;
      this.jdField_a_of_type_Szw.setGravity(1);
      continue;
      this.jdField_a_of_type_Szw.setGravity(8388611);
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
  
  private void f(@NonNull szz paramszz)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((szu)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).c(paramszz);
      i1 -= 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(int paramInt)
  {
    return Math.round(getResources().getDisplayMetrics().density * paramInt);
  }
  
  @NonNull
  public szz a()
  {
    szz localszz2 = (szz)jdField_a_of_type_AndroidSupportV4UtilPools$Pool.acquire();
    szz localszz1 = localszz2;
    if (localszz2 == null) {
      localszz1 = new szz();
    }
    localszz1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = this;
    localszz1.jdField_a_of_type_Taa = a(localszz1);
    if (this.jdField_a_of_type_Tac != null) {
      localszz1.a(this.jdField_a_of_type_Tac.a(localszz1.jdField_a_of_type_Taa));
    }
    return localszz1;
  }
  
  @Nullable
  public szz a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= a())) {
      return null;
    }
    return (szz)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a()
  {
    int i1 = this.jdField_a_of_type_Szw.getChildCount() - 1;
    while (i1 >= 0)
    {
      a(i1);
      i1 -= 1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      szz localszz = (szz)localIterator.next();
      localIterator.remove();
      localszz.d();
      jdField_a_of_type_AndroidSupportV4UtilPools$Pool.release(localszz);
    }
    this.jdField_a_of_type_Szz = null;
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = Math.round(paramInt + paramFloat);
    if ((i1 < 0) || (i1 >= this.jdField_a_of_type_Szw.getChildCount())) {}
    do
    {
      return;
      if (paramBoolean2) {
        this.jdField_a_of_type_Szw.a(paramInt, paramFloat);
      }
      if ((this.jdField_a_of_type_AndroidAnimationValueAnimator != null) && (this.jdField_a_of_type_AndroidAnimationValueAnimator.isRunning())) {
        this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
      }
      scrollTo(a(paramInt, paramFloat), 0);
    } while (!paramBoolean1);
    c(i1);
  }
  
  public void a(@Nullable PagerAdapter paramPagerAdapter, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null) && (this.jdField_a_of_type_Szv != null)) {
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.unregisterDataSetObserver(this.jdField_a_of_type_Szv);
    }
    this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = paramPagerAdapter;
    if (paramPagerAdapter != null)
    {
      if (this.jdField_a_of_type_Szv == null) {
        this.jdField_a_of_type_Szv = new szv(this);
      }
      this.jdField_a_of_type_Szv.a(paramBoolean);
      paramPagerAdapter.registerDataSetObserver(this.jdField_a_of_type_Szv);
    }
    b();
  }
  
  public void a(@NonNull szu paramszu)
  {
    if (!this.jdField_b_of_type_JavaUtilArrayList.contains(paramszu)) {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramszu);
    }
  }
  
  public void a(@NonNull szz paramszz, int paramInt, boolean paramBoolean)
  {
    if (paramszz.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat != this) {
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }
    a(paramszz, paramInt);
    a(paramszz);
    if (paramBoolean) {
      paramszz.a();
    }
  }
  
  public void a(@NonNull szz paramszz, boolean paramBoolean)
  {
    a(paramszz, this.jdField_a_of_type_JavaUtilArrayList.size(), paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_Szw.getChildCount())
    {
      View localView = this.jdField_a_of_type_Szw.getChildAt(i1);
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
    if (this.jdField_a_of_type_Szz != null) {
      return this.jdField_a_of_type_Szz.a();
    }
    return -1;
  }
  
  public void b()
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
  
  public void b(@NonNull szu paramszu)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramszu);
  }
  
  void b(szz paramszz, boolean paramBoolean)
  {
    szz localszz = this.jdField_a_of_type_Szz;
    if (localszz == paramszz)
    {
      if (localszz != null)
      {
        f(paramszz);
        b(paramszz.a());
      }
      return;
    }
    int i1;
    if (paramszz != null)
    {
      i1 = paramszz.a();
      label40:
      if (paramBoolean)
      {
        if (((localszz != null) && (localszz.a() != -1)) || (i1 == -1)) {
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
      if (localszz != null) {
        c(localszz);
      }
      this.jdField_a_of_type_Szz = paramszz;
      if (paramszz == null) {
        break;
      }
      b(paramszz);
      return;
      i1 = -1;
      break label40;
      label111:
      b(i1);
    }
  }
  
  public int c()
  {
    return this.g;
  }
  
  public void c(szz paramszz, boolean paramBoolean)
  {
    szz localszz = this.jdField_a_of_type_Szz;
    if (localszz == paramszz)
    {
      if (localszz != null) {
        b(paramszz.a());
      }
      return;
    }
    int i1;
    if (paramszz != null)
    {
      i1 = paramszz.a();
      if (paramBoolean)
      {
        if (((localszz != null) && (localszz.a() != -1)) || (i1 == -1)) {
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
      this.jdField_a_of_type_Szz = paramszz;
      return;
      i1 = -1;
      break;
      label86:
      b(i1);
    }
  }
  
  public void d(@NonNull szz paramszz)
  {
    a(paramszz, this.jdField_a_of_type_JavaUtilArrayList.isEmpty());
  }
  
  public void e(szz paramszz)
  {
    b(paramszz, true);
  }
  
  public FrameLayout.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    return generateDefaultLayoutParams();
  }
  
  protected void onAttachedToWindow()
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
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_Boolean)
    {
      setupWithViewPager(null);
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
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
  public void setOnTabSelectedListener(@Nullable szu paramszu)
  {
    if (this.jdField_a_of_type_Szu != null) {
      b(this.jdField_a_of_type_Szu);
    }
    this.jdField_a_of_type_Szu = paramszu;
    if (paramszu != null) {
      a(paramszu);
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
    this.jdField_a_of_type_Szw.a(paramInt);
  }
  
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.jdField_a_of_type_Szw.b(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingBottom(int paramInt)
  {
    this.jdField_a_of_type_Szw.e(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingLeft(int paramInt)
  {
    this.jdField_a_of_type_Szw.c(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingRight(int paramInt)
  {
    this.jdField_a_of_type_Szw.d(paramInt);
  }
  
  public void setTabBackgroundResId(int paramInt)
  {
    if (this.f != paramInt)
    {
      this.f = paramInt;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        szz localszz = (szz)localIterator.next();
        if (localszz.jdField_a_of_type_Taa != null) {
          localszz.jdField_a_of_type_Taa.setBackgroundResource(this.f);
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
        szz localszz = (szz)localIterator.next();
        if ((localszz.jdField_a_of_type_Taa != null) && (taa.a(localszz.jdField_a_of_type_Taa) != null)) {
          taa.a(localszz.jdField_a_of_type_Taa).setTextSize(this.jdField_a_of_type_Float);
        }
      }
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(@Nullable PagerAdapter paramPagerAdapter)
  {
    a(paramPagerAdapter, false);
  }
  
  public void setViewPagerTabEventListener(tac paramtac)
  {
    this.jdField_a_of_type_Tac = paramtac;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat
 * JD-Core Version:    0.7.0.1
 */