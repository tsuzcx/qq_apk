package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import wus;

public class SubscribeBannerView
  extends BaseWidgetView
{
  private static int b = ImmersiveUtils.a(20.0F);
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private SubscribeBannerView.BannerAdapter jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$BannerAdapter;
  private SubscribeBannerView.DotsIndicator jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$DotsIndicator;
  
  public SubscribeBannerView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public SubscribeBannerView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(FrameLayout paramFrameLayout)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$DotsIndicator = new SubscribeBannerView.DotsIndicator(getContext());
    paramFrameLayout = new FrameLayout.LayoutParams(-2, -2);
    paramFrameLayout.gravity = 81;
    addView(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$DotsIndicator, paramFrameLayout);
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$BannerAdapter != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$BannerAdapter.a().clear();
    }
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(null);
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = new ViewPager(getContext());
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    paramContext.bottomMargin = b;
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setLayoutParams(paramContext);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOffscreenPageLimit(3);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new wus(this));
    ((FrameLayout)paramView).addView(this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    a((FrameLayout)paramView);
  }
  
  public void a(Object paramObject) {}
  
  public void setAdapter(SubscribeBannerView.BannerAdapter paramBannerAdapter)
  {
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$BannerAdapter = paramBannerAdapter;
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager != null) {
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$BannerAdapter);
    }
  }
  
  public void setBannerHeight(int paramInt)
  {
    if (getLayoutParams() != null)
    {
      getLayoutParams().height = (b + paramInt);
      requestLayout();
    }
  }
  
  public void setDatas(List paramList)
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$BannerAdapter != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$BannerAdapter.a((ArrayList)paramList);
    }
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$DotsIndicator != null)
    {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$DotsIndicator.removeAllViews();
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$DotsIndicator.a(paramList.size());
        this.jdField_a_of_type_ComTencentBizSubscribeWidgetSubscribeBannerView$DotsIndicator.setDotsSelected(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeBannerView
 * JD-Core Version:    0.7.0.1
 */