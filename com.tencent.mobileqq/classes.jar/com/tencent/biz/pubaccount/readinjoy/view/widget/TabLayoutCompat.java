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
import trd;
import tre;
import trf;
import trg;
import trh;
import trk;
import trl;
import trm;
import trn;

public class TabLayoutCompat
  extends HorizontalScrollView
{
  private static final Pools.Pool<trk> jdField_a_of_type_AndroidSupportV4UtilPools$Pool = new Pools.SynchronizedPool(16);
  private static final int[] jdField_a_of_type_ArrayOfInt = { 16842901, 16842904 };
  public float a;
  public int a;
  private ValueAnimator jdField_a_of_type_AndroidAnimationValueAnimator;
  public ColorStateList a;
  private PagerAdapter jdField_a_of_type_AndroidSupportV4ViewPagerAdapter;
  private TabLayoutCompat.TabLayoutOnPageChangeListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener;
  public ViewPagerCompat a;
  private final ArrayList<trk> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private tre jdField_a_of_type_Tre;
  private trf jdField_a_of_type_Trf;
  private trg jdField_a_of_type_Trg;
  private final trh jdField_a_of_type_Trh;
  private trk jdField_a_of_type_Trk;
  private trn jdField_a_of_type_Trn;
  private boolean jdField_a_of_type_Boolean;
  public float b;
  public int b;
  private final Pools.Pool<trl> jdField_b_of_type_AndroidSupportV4UtilPools$Pool = new Pools.SimplePool(12);
  private final ArrayList<trf> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  private trf jdField_b_of_type_Trf;
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
    this.jdField_a_of_type_Trh = new trh(this, paramContext);
    super.addView(this.jdField_a_of_type_Trh, 0, new FrameLayout.LayoutParams(-2, -1));
    this.jdField_a_of_type_Trh.b(DisplayUtil.dip2px(paramContext, 2.0F));
    this.jdField_a_of_type_Trh.a(-1);
    this.d = 0;
    this.c = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.c = 0;
    this.d = 0;
    this.jdField_a_of_type_Float = DisplayUtil.sp2px(paramContext, 12.0F);
    this.jdField_a_of_type_AndroidContentResColorStateList = ColorStateList.valueOf(-1979711488);
    this.f = 0;
    this.m = 0;
    this.n = 0;
    this.i = 1;
    this.h = 1;
    this.jdField_b_of_type_Float = DisplayUtil.dip2px(paramContext, 12.0F);
    this.l = DisplayUtil.dip2px(paramContext, 72.0F);
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
      localView2 = this.jdField_a_of_type_Trh.getChildAt(paramInt);
      if (paramInt + 1 >= this.jdField_a_of_type_Trh.getChildCount()) {
        break label119;
      }
      localView1 = this.jdField_a_of_type_Trh.getChildAt(paramInt + 1);
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
  
  private trl a(@NonNull trk paramtrk)
  {
    if (this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool != null) {}
    for (trl localtrl1 = (trl)this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool.acquire();; localtrl1 = null)
    {
      trl localtrl2 = localtrl1;
      if (localtrl1 == null) {
        localtrl2 = new trl(this, getContext());
      }
      localtrl2.a(paramtrk);
      localtrl2.setFocusable(true);
      localtrl2.setMinimumWidth(f());
      return localtrl2;
    }
  }
  
  private void a(int paramInt)
  {
    trl localtrl = (trl)this.jdField_a_of_type_Trh.getChildAt(paramInt);
    this.jdField_a_of_type_Trh.removeViewAt(paramInt);
    if (localtrl != null)
    {
      localtrl.a();
      this.jdField_b_of_type_AndroidSupportV4UtilPools$Pool.release(localtrl);
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
      if (this.jdField_a_of_type_Tre != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.b(this.jdField_a_of_type_Tre);
      }
    }
    if (this.jdField_b_of_type_Trf != null)
    {
      b(this.jdField_b_of_type_Trf);
      this.jdField_b_of_type_Trf = null;
    }
    if (paramViewPagerCompat != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = paramViewPagerCompat;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener = new TabLayoutCompat.TabLayoutOnPageChangeListener(this);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener.a();
      paramViewPagerCompat.addOnPageChangeListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat$TabLayoutOnPageChangeListener);
      this.jdField_b_of_type_Trf = new trm(paramViewPagerCompat);
      a(this.jdField_b_of_type_Trf);
      PagerAdapter localPagerAdapter = paramViewPagerCompat.getAdapter();
      if (localPagerAdapter != null) {
        a(localPagerAdapter, paramBoolean1);
      }
      if (this.jdField_a_of_type_Tre == null) {
        this.jdField_a_of_type_Tre = new tre(this);
      }
      this.jdField_a_of_type_Tre.a(paramBoolean1);
      paramViewPagerCompat.a(this.jdField_a_of_type_Tre);
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
  
  private void a(trk paramtrk)
  {
    trl localtrl = paramtrk.jdField_a_of_type_Trl;
    this.jdField_a_of_type_Trh.addView(localtrl, paramtrk.a(), a());
  }
  
  private void a(trk paramtrk, int paramInt)
  {
    paramtrk.a(paramInt);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramInt, paramtrk);
    int i1 = this.jdField_a_of_type_JavaUtilArrayList.size();
    paramInt += 1;
    while (paramInt < i1)
    {
      ((trk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a(paramInt);
      paramInt += 1;
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    if ((getWindowToken() == null) || (!ViewCompat.isLaidOut(this)) || (this.jdField_a_of_type_Trh.a()))
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
    this.jdField_a_of_type_Trh.b(paramInt, 300);
  }
  
  private void b(@NonNull trk paramtrk)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((trf)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).a(paramtrk);
      i1 -= 1;
    }
  }
  
  private void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((trk)localIterator.next()).c();
    }
  }
  
  private void c(int paramInt)
  {
    int i2 = this.jdField_a_of_type_Trh.getChildCount();
    if (paramInt < i2)
    {
      int i1 = 0;
      if (i1 < i2)
      {
        View localView = this.jdField_a_of_type_Trh.getChildAt(i1);
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
  
  private void c(@NonNull trk paramtrk)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((trf)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).b(paramtrk);
      i1 -= 1;
    }
  }
  
  private int d()
  {
    return Math.max(0, this.jdField_a_of_type_Trh.getWidth() - getWidth() - getPaddingLeft() - getPaddingRight());
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_AndroidAnimationValueAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setInterpolator(new FastOutSlowInInterpolator());
      this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(300L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new trd(this));
    }
  }
  
  private int e()
  {
    int i2 = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      trk localtrk = (trk)this.jdField_a_of_type_JavaUtilArrayList.get(i1);
      if ((localtrk == null) || (localtrk.a() == null) || (TextUtils.isEmpty(localtrk.a()))) {}
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
    ViewCompat.setPaddingRelative(this.jdField_a_of_type_Trh, i2, 0, i1, 0);
    switch (this.i)
    {
    }
    for (;;)
    {
      a(true);
      return;
      this.jdField_a_of_type_Trh.setGravity(1);
      continue;
      this.jdField_a_of_type_Trh.setGravity(8388611);
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
  
  private void f(@NonNull trk paramtrk)
  {
    int i1 = this.jdField_b_of_type_JavaUtilArrayList.size() - 1;
    while (i1 >= 0)
    {
      ((trf)this.jdField_b_of_type_JavaUtilArrayList.get(i1)).c(paramtrk);
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
  public trk a()
  {
    trk localtrk2 = (trk)jdField_a_of_type_AndroidSupportV4UtilPools$Pool.acquire();
    trk localtrk1 = localtrk2;
    if (localtrk2 == null) {
      localtrk1 = new trk();
    }
    localtrk1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = this;
    localtrk1.jdField_a_of_type_Trl = a(localtrk1);
    if (this.jdField_a_of_type_Trn != null) {
      localtrk1.a(this.jdField_a_of_type_Trn.a(localtrk1.jdField_a_of_type_Trl));
    }
    return localtrk1;
  }
  
  @Nullable
  public trk a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= a())) {
      return null;
    }
    return (trk)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public void a()
  {
    int i1 = this.jdField_a_of_type_Trh.getChildCount() - 1;
    while (i1 >= 0)
    {
      a(i1);
      i1 -= 1;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      trk localtrk = (trk)localIterator.next();
      localIterator.remove();
      localtrk.d();
      jdField_a_of_type_AndroidSupportV4UtilPools$Pool.release(localtrk);
    }
    this.jdField_a_of_type_Trk = null;
  }
  
  void a(int paramInt, float paramFloat, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i1 = Math.round(paramInt + paramFloat);
    if ((i1 < 0) || (i1 >= this.jdField_a_of_type_Trh.getChildCount())) {}
    do
    {
      return;
      if (paramBoolean2) {
        this.jdField_a_of_type_Trh.a(paramInt, paramFloat);
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
    if ((this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter != null) && (this.jdField_a_of_type_Trg != null)) {
      this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter.unregisterDataSetObserver(this.jdField_a_of_type_Trg);
    }
    this.jdField_a_of_type_AndroidSupportV4ViewPagerAdapter = paramPagerAdapter;
    if (paramPagerAdapter != null)
    {
      if (this.jdField_a_of_type_Trg == null) {
        this.jdField_a_of_type_Trg = new trg(this);
      }
      this.jdField_a_of_type_Trg.a(paramBoolean);
      paramPagerAdapter.registerDataSetObserver(this.jdField_a_of_type_Trg);
    }
    b();
  }
  
  public void a(@NonNull trf paramtrf)
  {
    if (!this.jdField_b_of_type_JavaUtilArrayList.contains(paramtrf)) {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramtrf);
    }
  }
  
  public void a(@NonNull trk paramtrk, int paramInt, boolean paramBoolean)
  {
    if (paramtrk.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat != this) {
      throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
    }
    a(paramtrk, paramInt);
    a(paramtrk);
    if (paramBoolean) {
      paramtrk.a();
    }
  }
  
  public void a(@NonNull trk paramtrk, boolean paramBoolean)
  {
    a(paramtrk, this.jdField_a_of_type_JavaUtilArrayList.size(), paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    int i1 = 0;
    while (i1 < this.jdField_a_of_type_Trh.getChildCount())
    {
      View localView = this.jdField_a_of_type_Trh.getChildAt(i1);
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
    if (this.jdField_a_of_type_Trk != null) {
      return this.jdField_a_of_type_Trk.a();
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
  
  public void b(@NonNull trf paramtrf)
  {
    this.jdField_b_of_type_JavaUtilArrayList.remove(paramtrf);
  }
  
  void b(trk paramtrk, boolean paramBoolean)
  {
    trk localtrk = this.jdField_a_of_type_Trk;
    if (localtrk == paramtrk)
    {
      if (localtrk != null)
      {
        f(paramtrk);
        b(paramtrk.a());
      }
      return;
    }
    int i1;
    if (paramtrk != null)
    {
      i1 = paramtrk.a();
      label40:
      if (paramBoolean)
      {
        if (((localtrk != null) && (localtrk.a() != -1)) || (i1 == -1)) {
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
      if (localtrk != null) {
        c(localtrk);
      }
      this.jdField_a_of_type_Trk = paramtrk;
      if (paramtrk == null) {
        break;
      }
      b(paramtrk);
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
  
  public void c(trk paramtrk, boolean paramBoolean)
  {
    trk localtrk = this.jdField_a_of_type_Trk;
    if (localtrk == paramtrk)
    {
      if (localtrk != null) {
        b(paramtrk.a());
      }
      return;
    }
    int i1;
    if (paramtrk != null)
    {
      i1 = paramtrk.a();
      if (paramBoolean)
      {
        if (((localtrk != null) && (localtrk.a() != -1)) || (i1 == -1)) {
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
      this.jdField_a_of_type_Trk = paramtrk;
      return;
      i1 = -1;
      break;
      label86:
      b(i1);
    }
  }
  
  public void d(@NonNull trk paramtrk)
  {
    a(paramtrk, this.jdField_a_of_type_JavaUtilArrayList.isEmpty());
  }
  
  public void e(trk paramtrk)
  {
    b(paramtrk, true);
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
  public void setOnTabSelectedListener(@Nullable trf paramtrf)
  {
    if (this.jdField_a_of_type_Trf != null) {
      b(this.jdField_a_of_type_Trf);
    }
    this.jdField_a_of_type_Trf = paramtrf;
    if (paramtrf != null) {
      a(paramtrf);
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
    this.jdField_a_of_type_Trh.a(paramInt);
  }
  
  public void setSelectedTabIndicatorHeight(int paramInt)
  {
    this.jdField_a_of_type_Trh.b(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingBottom(int paramInt)
  {
    this.jdField_a_of_type_Trh.e(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingLeft(int paramInt)
  {
    this.jdField_a_of_type_Trh.c(paramInt);
  }
  
  public void setSelectedTabIndicatorPaddingRight(int paramInt)
  {
    this.jdField_a_of_type_Trh.d(paramInt);
  }
  
  public void setTabBackgroundResId(int paramInt)
  {
    if (this.f != paramInt)
    {
      this.f = paramInt;
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        trk localtrk = (trk)localIterator.next();
        if (localtrk.jdField_a_of_type_Trl != null) {
          localtrk.jdField_a_of_type_Trl.setBackgroundResource(this.f);
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
        trk localtrk = (trk)localIterator.next();
        if ((localtrk.jdField_a_of_type_Trl != null) && (trl.a(localtrk.jdField_a_of_type_Trl) != null)) {
          trl.a(localtrk.jdField_a_of_type_Trl).setTextSize(this.jdField_a_of_type_Float);
        }
      }
    }
  }
  
  @Deprecated
  public void setTabsFromPagerAdapter(@Nullable PagerAdapter paramPagerAdapter)
  {
    a(paramPagerAdapter, false);
  }
  
  public void setViewPagerTabEventListener(trn paramtrn)
  {
    this.jdField_a_of_type_Trn = paramtrn;
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