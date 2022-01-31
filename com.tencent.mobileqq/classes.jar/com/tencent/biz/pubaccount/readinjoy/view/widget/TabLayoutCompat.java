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
import azvv;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import rhh;
import rhi;
import rhj;
import rhk;
import rhl;
import rho;
import rhp;
import rhq;
import rhr;

public class TabLayoutCompat
  extends HorizontalScrollView
{
  private static final Pools.Pool<rho> jdField_a_of_type_AndroidSupportV4UtilPools$Pool = new Pools.SynchronizedPool(16);
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842901, 16842904 };
  public float a;
  public int a;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  public ColorStateList a;
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private TabLayoutCompat.TabLayoutOnPageChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener;
  public ViewPagerCompat a;
  private final ArrayList<rho> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private rhi jdField_a_of_type_Rhi;
  private rhj jdField_a_of_type_Rhj;
  private rhk jdField_a_of_type_Rhk;
  private final rhl jdField_a_of_type_Rhl;
  private rho jdField_a_of_type_Rho;
  private rhr jdField_a_of_type_Rhr;
  private boolean jdField_a_of_type_Boolean;
  public float b;
  public int b;
  private final Pools.Pool<rhp> jdField_b_of_type_AndroidSupportV4UtilPools$Pool = new Pools.SimplePool(12);
  private final ArrayList<rhj> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private rhj jdField_b_of_type_Rhj;
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
  private final int l;
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
    this.jdField_a_of_type_Rhl = new rhl(this, paramContext);
    super.addView(this.jdField_a_of_type_Rhl, 0, new FrameLayout.LayoutParams(-2, -1));
    this.jdField_a_of_type_Rhl.b(azvv.a(paramContext, 2.0F));
    this.jdField_a_of_type_Rhl.a(-1);
    this.d = 0;
    this.c = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.c = 0;
    this.d = 0;
    this.jdField_a_of_type_Float = azvv.c(paramContext, 12.0F);
    this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-1979711488);
    this.f = 0;
    this.m = 0;
    this.n = 0;
    this.i = 1;
    this.h = 1;
    this.jdField_b_of_type_Float = azvv.a(paramContext, 12.0F);
    this.l = azvv.a(paramContext, 72.0F);
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
      localView2 = this.jdField_a_of_type_Rhl.getChildAt(paramInt);
      if (paramInt + 1 >= this.jdField_a_of_type_Rhl.getChildCount()) {
        break label119;
      }
      localView1 = this.jdField_a_of_type_Rhl.getChildAt(paramInt + 1);
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
  
  private rhp a(@NonNull rho paramrho)
  {
    if (this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool != null) {}
    for (rhp localrhp1 = (rhp)this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool.acquire();; localrhp1 = null)
    {
      rhp localrhp2 = localrhp1;
      if (localrhp1 == null) {
        localrhp2 = new rhp(this, getContext());
      }
      localrhp2.a(paramrho);
      localrhp2.setFocusable(true);
      localrhp2.setMinimumWidth(f());
      return localrhp2;
    }
  }
  
  private void a(int paramInt)
  {
    rhp localrhp = (rhp)this.jdField_a_of_type_Rhl.getChildAt(paramInt);
    this.jdField_a_of_type_Rhl.removeViewAt(paramInt);
    if (localrhp != null)
    {
      localrhp.a();
      this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool.release(localrhp);
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
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener);
      }
      if (this.jdField_a_of_type_Rhi != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.b(this.jdField_a_of_type_Rhi);
      }
    }
    if (this.jdField_b_of_type_Rhj != null)
    {
      b(this.jdField_b_of_type_Rhj);
      this.jdField_b_of_type_Rhj = null;
    }
    if (paramViewPagerCompat != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = paramViewPagerCompat;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener = new TabLayoutCompat.TabLayoutOnPageChangeListener(this);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener.a();
      paramViewPagerCompat.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener);
      this.jdField_b_of_type_Rhj = new rhq(paramViewPagerCompat);
      a(this.jdField_b_of_type_Rhj);
      PagerAdapter localPagerAdapter = paramViewPagerCompat.getAdapter();
      if (localPagerAdapter != null) {
        a(localPagerAdapter, paramBoolean1);
      }
      if (this.jdField_a_of_type_Rhi == null) {
        this.jdField_a_of_type_Rhi = new rhi(this);
      }
      this.jdField_a_of_type_Rhi.a(paramBoolean1);
      paramViewPagerCompat.a(this.jdField_a_of_type_Rhi);
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
  
  private void a(rho paramrho, int paramInt)
  {
    paramrho.a(paramInt);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, paramrho);
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    paramInt += 1;
    while (paramInt < i1)
    {
      ((rho)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(paramInt);
      paramInt += 1;
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() == null) || (!ViewCompat.isLaidOut(this)) || (this.jdField_a_of_type_Rhl.a()))
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
    this.jdField_a_of_type_Rhl.b(paramInt, 300);
  }
  
  private void b(rho paramrho)
  {
    rhp localrhp = paramrho.jdField_a_of_type_Rhp;
    this.jdField_a_of_type_Rhl.addView(localrhp, paramrho.a(), a());
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((rho)localIterator.next()).c();
    }
  }
  
  private void c(int paramInt)
  {
    int i2 = this.jdField_a_of_type_Rhl.getChildCount();
    if (paramInt < i2)
    {
      int i1 = 0;
      if (i1 < i2)
      {
        View localView = this.jdField_a_of_type_Rhl.getChildAt(i1);
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
  
  private void c(@NonNull rho paramrho)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((rhj)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).a(paramrho);
      i1 -= 1;
    }
  }
  
  private int d()
  {
    return Math.max(0, this.jdField_a_of_type_Rhl.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new FastOutSlowInInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new rhh(this));
    }
  }
  
  private void d(@NonNull rho paramrho)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((rhj)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).b(paramrho);
      i1 -= 1;
    }
  }
  
  private int e()
  {
    int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      rho localrho = (rho)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if ((localrho == null) || (localrho.a() == null) || (TextUtils.isEmpty(localrho.a()))) {}
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
    ViewCompat.setPaddingRelative(this.jdField_a_of_type_Rhl, i2, 0, i1, 0);
    switch (this.i)
    {
    }
    for (;;)
    {
      a(true);
      return;
      this.jdField_a_of_type_Rhl.setGravity(1);
      continue;
      this.jdField_a_of_type_Rhl.setGravity(8388611);
    }
  }
  
  private void e(@NonNull rho paramrho)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((rhj)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).c(paramrho);
      i1 -= 1;
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
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public int a(int paramInt)
  {
    return Math.round(getResources().getDisplayMetrics().density * paramInt);
  }
  
  @NonNull
  public rho a()
  {
    rho localrho2 = (rho)jdField_a_of_type_AndroidSupportV4UtilPools$Pool.acquire();
    rho localrho1 = localrho2;
    if (localrho2 == null) {
      localrho1 = new rho();
    }
    localrho1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = this;
    localrho1.jdField_a_of_type_Rhp = a(localrho1);
    if (this.jdField_a_of_type_Rhr != null) {
      localrho1.a(this.jdField_a_of_type_Rhr.a(localrho1.jdField_a_of_type_Rhp));
    }
    return localrho1;
  }
  
  @Nullable
  public rho a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= a())) {
      return null;
    }
    return (rho)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a()
  {
    int i1 = this.jdField_a_of_type_Rhl.getChildCount() - 1;
    while (i1 >= 0)
    {
      a(i1);
      i1 -= 1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      rho localrho = (rho)localIterator.next();
      localIterator.remove();
      localrho.d();
      jdField_a_of_type_AndroidSupportV4UtilPools$Pool.release(localrho);
    }
    this.jdField_a_of_type_Rho = null;
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = Math.round(paramInt + paramFloat);
    if ((i1 < 0) || (i1 >= this.jdField_a_of_type_Rhl.getChildCount())) {}
    do
    {
      return;
      if (paramBoolean2) {
        this.jdField_a_of_type_Rhl.a(paramInt, paramFloat);
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
    if ((this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null) && (this.jdField_a_of_type_Rhk != null)) {
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.unregisterDataSetObserver(this.jdField_a_of_type_Rhk);
    }
    this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = paramPagerAdapter;
    if (paramPagerAdapter != null)
    {
      if (this.jdField_a_of_type_Rhk == null) {
        this.jdField_a_of_type_Rhk = new rhk(this);
      }
      this.jdField_a_of_type_Rhk.a(paramBoolean);
      paramPagerAdapter.registerDataSetObserver(this.jdField_a_of_type_Rhk);
    }
    b();
  }
  
  public void a(@NonNull rhj paramrhj)
  {
    if (!this.jdField_b_of_type_JavaUtilArrayList.contains(paramrhj)) {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramrhj);
    }
  }
  
  public void a(@NonNull rho paramrho, int paramInt, boolean paramBoolean)
  {
    if (paramrho.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat != this) {
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }
    a(paramrho, paramInt);
    b(paramrho);
    if (paramBoolean) {
      paramrho.a();
    }
  }
  
  public void a(@NonNull rho paramrho, boolean paramBoolean)
  {
    a(paramrho, this.jdField_a_of_type_JavaUtilArrayList.size(), paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_Rhl.getChildCount())
    {
      View localView = this.jdField_a_of_type_Rhl.getChildAt(i1);
      localView.setMinimumWidth(f());
      a((LinearLayout.LayoutParams)localView.getLayoutParams());
      if (paramBoolean) {
        localView.requestLayout();
      }
      i1 += 1;
    }
  }
  
  public void a_(rho paramrho)
  {
    b(paramrho, true);
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
    if (this.jdField_a_of_type_Rho != null) {
      return this.jdField_a_of_type_Rho.a();
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
          a_(a(i1));
        }
      }
    }
  }
  
  public void b(@NonNull rhj paramrhj)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramrhj);
  }
  
  void b(rho paramrho, boolean paramBoolean)
  {
    rho localrho = this.jdField_a_of_type_Rho;
    if (localrho == paramrho)
    {
      if (localrho != null)
      {
        e(paramrho);
        b(paramrho.a());
      }
      return;
    }
    int i1;
    if (paramrho != null)
    {
      i1 = paramrho.a();
      label40:
      if (paramBoolean)
      {
        if (((localrho != null) && (localrho.a() != -1)) || (i1 == -1)) {
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
      if (localrho != null) {
        d(localrho);
      }
      this.jdField_a_of_type_Rho = paramrho;
      if (paramrho == null) {
        break;
      }
      c(paramrho);
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
  
  public void c(rho paramrho, boolean paramBoolean)
  {
    rho localrho = this.jdField_a_of_type_Rho;
    if (localrho == paramrho)
    {
      if (localrho != null) {
        b(paramrho.a());
      }
      return;
    }
    int i1;
    if (paramrho != null)
    {
      i1 = paramrho.a();
      if (paramBoolean)
      {
        if (((localrho != null) && (localrho.a() != -1)) || (i1 == -1)) {
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
      this.jdField_a_of_type_Rho = paramrho;
      return;
      i1 = -1;
      break;
      label86:
      b(i1);
    }
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
  public void setOnTabSelectedListener(@Nullable rhj paramrhj)
  {
    if (this.jdField_a_of_type_Rhj != null) {
      b(this.jdField_a_of_type_Rhj);
    }
    this.jdField_a_of_type_Rhj = paramrhj;
    if (paramrhj != null) {
      a(paramrhj);
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
  
  public void setSelectedTabIndicatorColor(@ColorInt int paramInt)
  {
    this.jdField_a_of_type_Rhl.a(paramInt);
  }
  
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.jdField_a_of_type_Rhl.b(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingBottom(int paramInt)
  {
    this.jdField_a_of_type_Rhl.e(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingLeft(int paramInt)
  {
    this.jdField_a_of_type_Rhl.c(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingRight(int paramInt)
  {
    this.jdField_a_of_type_Rhl.d(paramInt);
  }
  
  public void setTabBackgroundResId(int paramInt)
  {
    if (this.f != paramInt)
    {
      this.f = paramInt;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        rho localrho = (rho)localIterator.next();
        if (localrho.jdField_a_of_type_Rhp != null) {
          localrho.jdField_a_of_type_Rhp.setBackgroundResource(this.f);
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
        rho localrho = (rho)localIterator.next();
        if ((localrho.jdField_a_of_type_Rhp != null) && (rhp.a(localrho.jdField_a_of_type_Rhp) != null)) {
          rhp.a(localrho.jdField_a_of_type_Rhp).setTextSize(this.jdField_a_of_type_Float);
        }
      }
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(@Nullable PagerAdapter paramPagerAdapter)
  {
    a(paramPagerAdapter, false);
  }
  
  public void setViewPagerTabEventListener(rhr paramrhr)
  {
    this.jdField_a_of_type_Rhr = paramrhr;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat
 * JD-Core Version:    0.7.0.1
 */