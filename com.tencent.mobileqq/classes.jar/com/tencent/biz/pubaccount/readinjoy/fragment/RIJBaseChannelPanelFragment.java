package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.view.NestedScrollView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.widget.SlideDownFrameLayout;
import com.tencent.mobileqq.widget.SlideDownFrameLayout.OnSlideListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public abstract class RIJBaseChannelPanelFragment
  extends PublicBaseFragment
  implements View.OnClickListener, SlideDownFrameLayout.OnSlideListener
{
  protected int a;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  protected TextView a;
  private NestedScrollView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewNestedScrollView;
  protected SlideDownFrameLayout a;
  private View b;
  private View c;
  
  public RIJBaseChannelPanelFragment()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void a(LayoutInflater paramLayoutInflater)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131365312));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewNestedScrollView = ((NestedScrollView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131364579));
    paramLayoutInflater = paramLayoutInflater.inflate(a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewNestedScrollView, false);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -2);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewNestedScrollView.addView(paramLayoutInflater, localLayoutParams);
    this.c = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131364828);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131372081));
    ((TextView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131376543)).setText(a());
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131371077);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.setOnSlideListener(this);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnTouchListener(new RIJBaseChannelPanelFragment.1(this));
    onPostThemeChanged();
    paramLayoutInflater = ((ViewGroup)((FrameLayout)getActivity().findViewById(16908290)).getParent()).getChildAt(1);
    if (((paramLayoutInflater instanceof FrameLayout)) && (paramLayoutInflater.getId() != 16908290)) {
      paramLayoutInflater.setVisibility(8);
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setAlpha(0.0F);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.post(new RIJBaseChannelPanelFragment.2(this));
  }
  
  private void b()
  {
    FragmentActivity localFragmentActivity;
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      localFragmentActivity = getActivity();
      localFragmentActivity.getWindow().addFlags(67108864);
      ImmersiveUtils.clearCoverForStatus(getActivity().getWindow(), true);
      if (localFragmentActivity.mSystemBarComp == null) {
        localFragmentActivity.mSystemBarComp = new SystemBarCompact(localFragmentActivity, true, -1);
      }
      localFragmentActivity.mSystemBarComp.init();
      if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
      {
        localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        localFragmentActivity.mSystemBarComp.setStatusBarColor(0);
      }
    }
    else
    {
      return;
    }
    if (!SystemUtil.d())
    {
      localFragmentActivity.mSystemBarComp.setStatusBarColor(-2368549);
      return;
    }
    localFragmentActivity.mSystemBarComp.setStatusBarColor(-1);
    localFragmentActivity.mSystemBarComp.setStatusBarDarkMode(true);
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.b();
  }
  
  private void c()
  {
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
  }
  
  abstract int a();
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidWidgetLinearLayout;
  }
  
  abstract String a();
  
  public void a()
  {
    if (getActivity() != null)
    {
      getActivity().finish();
      getActivity().overridePendingTransition(0, 0);
    }
  }
  
  public void a(float paramFloat, int paramInt)
  {
    ReadInJoyLogicEngineEventDispatcher.a().a(paramFloat, paramInt);
    this.jdField_a_of_type_AndroidViewView.setAlpha(1.0F - paramFloat / paramInt);
  }
  
  protected void a(View paramView) {}
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewNestedScrollView.getScrollY() == 0;
  }
  
  public boolean isWrapContent()
  {
    return true;
  }
  
  public boolean onBackEvent()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.b();
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      b(paramView);
      continue;
      a(paramView);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_Int = AIOUtils.a(8.0F, getResources());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getActivity().setTheme(2131755154);
    this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout = ((SlideDownFrameLayout)paramLayoutInflater.inflate(2131562877, paramViewGroup, false));
    a(paramLayoutInflater);
    c();
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onPostThemeChanged()
  {
    if (ThemeUtil.isNowThemeIsNight(ReadInJoyUtils.a(), false, null))
    {
      if (this.b == null) {
        this.b = ((ViewStub)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131376600)).inflate();
      }
      if (this.b != null) {
        this.b.setVisibility(0);
      }
    }
    while (this.b == null) {
      return;
    }
    this.b.setVisibility(8);
  }
  
  public void onResume()
  {
    super.onResume();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.RIJBaseChannelPanelFragment
 * JD-Core Version:    0.7.0.1
 */