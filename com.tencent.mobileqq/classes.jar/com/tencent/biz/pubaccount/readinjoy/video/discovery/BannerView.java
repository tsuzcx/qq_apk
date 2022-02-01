package com.tencent.biz.pubaccount.readinjoy.video.discovery;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v4.view.ViewPager.PageTransformer;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.util.DisplayUtil;

public class BannerView
  extends FrameLayout
  implements ViewPager.OnPageChangeListener
{
  private float jdField_a_of_type_Float;
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewPager.OnPageChangeListener jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener;
  protected ViewPager a;
  private BannerView.AutoSidleTimer jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer;
  private BannerView.BannerViewAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter;
  private BannerView.DotsIndicator jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  int jdField_b_of_type_Int = DisplayUtil.dip2px(getContext(), 25.0F);
  private int c;
  private int d = 1;
  private int e = 3500;
  private int f = 81;
  
  public BannerView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 2130843130;
    a(paramContext);
  }
  
  public BannerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2130843130;
    a(paramContext);
  }
  
  public BannerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = 2130843130;
    a(paramContext);
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter != null)
    {
      if (paramInt != 0) {
        break label37;
      }
      this.c = (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.a() - 2);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.c, false);
    }
    label37:
    while (paramInt != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.a() - 1) {
      return;
    }
    this.c = 1;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.c, false);
  }
  
  private void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = new ViewPager(this.jdField_a_of_type_AndroidContentContext);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setLayoutParams(paramContext);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 0) || (paramInt == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.a() - 1);
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter != null) && (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.a()) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer != null))
    {
      if (this.c != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.a() - 1) {
        break label72;
      }
      this.c = 1;
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.c, false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer.b();
    }
    label72:
    while ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer == null)) {
      return;
    }
    this.c += 1;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.c);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer.b(this.e);
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.b() <= 1)) {}
    while ((this.d == 0) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.d = 0;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer.a(this.e);
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter == null) || (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.b() <= 1)) {}
    while ((this.d == 1) || (!this.jdField_a_of_type_Boolean)) {
      return;
    }
    this.d = 1;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer.a();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      b();
      continue;
      a();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.b() > 1)) {
      switch (paramMotionEvent.getAction())
      {
      case 1: 
      default: 
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      if (this.jdField_a_of_type_Float > this.jdField_b_of_type_Int)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
      }
      else
      {
        getParent().requestDisallowInterceptTouchEvent(false);
        return false;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        if (Math.abs(f1 - this.jdField_a_of_type_Float) >= Math.abs(f2 - this.jdField_b_of_type_Float)) {
          getParent().requestDisallowInterceptTouchEvent(true);
        } else {
          getParent().requestDisallowInterceptTouchEvent(false);
        }
      }
    }
  }
  
  public void onPageScrollStateChanged(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrollStateChanged(paramInt);
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter == null) {}
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.b() == 1);
      if ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) && (!a(paramInt1))) {
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageScrolled(paramInt1 - 1, paramFloat, paramInt2);
      }
    } while ((!a(paramInt1)) || (paramInt2 != 0));
    a(paramInt1);
  }
  
  public void onPageSelected(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter == null) {}
    while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.b() == 1) {
      return;
    }
    if ((this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener != null) && (!a(paramInt))) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener.onPageSelected(paramInt - 1);
    }
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter != null))
    {
      if (paramInt != 0) {
        break label86;
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator.setDotsSelected(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.a() - 3);
    }
    for (;;)
    {
      this.c = paramInt;
      return;
      label86:
      if (paramInt == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.a() - 1) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator.setDotsSelected(0);
      } else {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator.setDotsSelected(paramInt - 1);
      }
    }
  }
  
  public void setAdapter(BannerView.BannerViewAdapter paramBannerViewAdapter)
  {
    if ((paramBannerViewAdapter == null) || (paramBannerViewAdapter.a())) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter = paramBannerViewAdapter;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer == null))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$AutoSidleTimer = new BannerView.AutoSidleTimer(this);
      b();
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.b() > 1)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator.removeAllViews();
      }
      this.c = 1;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator = new BannerView.DotsIndicator(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.b(), this.f);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator.a();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator.setDotsSelected(this.c - 1);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.a());
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(this.c);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOverScrollMode(2);
      removeAllViews();
      addView(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$BannerViewAdapter.b() <= 1) {
        break;
      }
      addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoDiscoveryBannerView$DotsIndicator);
      return;
      this.c = 0;
    }
  }
  
  public void setDotsGravity(int paramInt)
  {
    if ((paramInt != 81) && (paramInt != 8388691) && (paramInt != 8388693)) {
      return;
    }
    this.f = paramInt;
  }
  
  public void setOffscreenPageLimit(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(paramInt);
    }
  }
  
  public void setPageChangeListener(ViewPager.OnPageChangeListener paramOnPageChangeListener)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$OnPageChangeListener = paramOnPageChangeListener;
  }
  
  public void setPageTransformer(boolean paramBoolean, ViewPager.PageTransformer paramPageTransformer)
  {
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setPageTransformer(paramBoolean, paramPageTransformer);
    }
  }
  
  public void setTimeInterval(int paramInt)
  {
    if (paramInt > 0) {
      this.e = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.discovery.BannerView
 * JD-Core Version:    0.7.0.1
 */