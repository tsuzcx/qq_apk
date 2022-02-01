package com.tencent.biz.pubaccount.weishi_new;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSBasePresenter;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSSubTabData;
import com.tencent.biz.pubaccount.weishi_new.ui.HomeTabSelectListener;
import com.tencent.biz.pubaccount.weishi_new.view.WSFeedsLinearLayout;
import com.tencent.biz.pubaccount.weishi_new.view.WSParentViewPager;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSSubTabsHelper;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabInfo;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class WSRecommendFragment
  extends WSBaseFragment
  implements HomeTabSelectListener
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#6933CC");
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private WSHomeFragmentAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter;
  private WSFeedsLinearLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout;
  private WSTabLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout;
  private List<Fragment> jdField_a_of_type_JavaUtilList;
  private List<WSTabInfo> b;
  
  private List<Fragment> a(List<WSTabInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList.size() == 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(WSGridPageFragment.a("1000", true, true));
      return this.jdField_a_of_type_JavaUtilList;
    }
    int i = 0;
    WSTabInfo localWSTabInfo;
    if (i < paramList.size())
    {
      localWSTabInfo = (WSTabInfo)paramList.get(i);
      if ((i == 0) || (i == 1)) {
        break label109;
      }
    }
    label109:
    for (boolean bool = false;; bool = true)
    {
      this.jdField_a_of_type_JavaUtilList.add(WSGridPageFragment.a(localWSTabInfo.a(), true, bool));
      i += 1;
      break;
      return this.jdField_a_of_type_JavaUtilList;
    }
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout = ((WSTabLayout)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout.findViewById(2131382033));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout.findViewById(2131382053));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout.findViewById(2131381622);
    c();
    d();
  }
  
  private void a(WSSubTabData paramWSSubTabData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new WSRecommendFragment.5(this, paramWSSubTabData));
  }
  
  private void a(List<WSTabInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter = new WSHomeFragmentAdapter(getChildFragmentManager(), a(paramList));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setOffscreenPageLimit(5);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.addOnPageChangeListener(new WSRecommendFragment.4(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup instanceof WSParentViewPager)) {
      ((WSParentViewPager)this.jdField_a_of_type_AndroidViewViewGroup).setChildCanScroll(paramBoolean);
    }
  }
  
  private void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.setTabItemSelect(paramInt, jdField_a_of_type_Int);
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {}
    int i;
    do
    {
      return;
      ((WSGridPageFragment)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(paramInt);
      i = paramInt + 1;
    } while (i >= this.jdField_a_of_type_JavaUtilList.size());
    ((WSGridPageFragment)this.jdField_a_of_type_JavaUtilList.get(i)).i();
    WSTabBeaconReport.a(paramInt, ((WSTabInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt)).a());
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout.setBackgroundColor(-16777216);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout.setDispatchTouchEventListener(new WSRecommendFragment.1(this));
      return;
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout.setBackgroundColor(-1);
    }
  }
  
  private void d()
  {
    WSSubTabData localWSSubTabData = WSSubTabsHelper.a(WSExpABTestManager.a().b());
    this.jdField_b_of_type_JavaUtilList = WSSubTabsHelper.a(localWSSubTabData);
    a(this.jdField_b_of_type_JavaUtilList);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.setMargins(0, ImmersiveUtils.getStatusBarHeight(getActivity()), 0, 0);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
    if (this.jdField_b_of_type_JavaUtilList.size() == 0)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.setVisibility(0);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.setupWithViewPager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.a(this.jdField_b_of_type_JavaUtilList, new WSRecommendFragment.2(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.setTabAnimListener(new WSRecommendFragment.3(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.setTabItemSelect(0, jdField_a_of_type_Int);
    a(localWSSubTabData);
  }
  
  @NonNull
  public IWSPresenter a()
  {
    return new WSBasePresenter();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt == 1) && (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.a()))
    {
      a(true);
      return;
    }
    a(false);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout = ((WSFeedsLinearLayout)paramLayoutInflater.inflate(2131560133, paramViewGroup, false));
    paramLayoutInflater = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment
 * JD-Core Version:    0.7.0.1
 */