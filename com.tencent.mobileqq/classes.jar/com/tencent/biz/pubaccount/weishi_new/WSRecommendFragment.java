package com.tencent.biz.pubaccount.weishi_new;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.event.WSPreloadTabEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleBaseEvent;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventBus;
import com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver;
import com.tencent.biz.pubaccount.weishi_new.presenter.WSBasePresenter;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSSubTabData;
import com.tencent.biz.pubaccount.weishi_new.ui.OnTabSelectedListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.view.WSFeedsLinearLayout;
import com.tencent.biz.pubaccount.weishi_new.view.WSViewPager;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSSubTabsHelper;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabInfo;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout;
import com.tencent.mobileqq.app.BaseFragment;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;

public class WSRecommendFragment
  extends WSBaseFragment
  implements WSSimpleEventReceiver, OnTabSelectedListener
{
  private static final int jdField_a_of_type_Int = Color.parseColor("#6933CC");
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private WSHomeFragmentAdapter jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter;
  private WSFeedsLinearLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout;
  private WSViewPager jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSViewPager;
  private WSTabLayout jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout;
  private String jdField_a_of_type_JavaLangString;
  private List<BaseFragment> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int = 0;
  private List<WSTabInfo> jdField_b_of_type_JavaUtilList;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean;
  
  @Nullable
  private WSGridPageFragment a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (WSGridPageFragment)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public static BaseFragment a(String paramString, boolean paramBoolean)
  {
    WSRecommendFragment localWSRecommendFragment = new WSRecommendFragment();
    Intent localIntent = new Intent();
    Bundle localBundle = new Bundle();
    localBundle.putString("key_context_feed_id", paramString);
    localBundle.putBoolean("key_show_context_feed_musk", paramBoolean);
    localIntent.putExtras(localBundle);
    localWSRecommendFragment.setArguments(localIntent.getExtras());
    return localWSRecommendFragment;
  }
  
  private List<BaseFragment> a(List<WSTabInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    if (paramList.size() == 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(WSGridPageFragment.a("1000", true, true, this.jdField_a_of_type_JavaLangString, this.jdField_c_of_type_Boolean));
      return this.jdField_a_of_type_JavaUtilList;
    }
    int i = 0;
    while (i < paramList.size())
    {
      WSTabInfo localWSTabInfo = (WSTabInfo)paramList.get(i);
      boolean bool;
      if (i != 0) {
        bool = false;
      } else {
        bool = true;
      }
      String str;
      if (TextUtils.equals("1000", localWSTabInfo.a())) {
        str = this.jdField_a_of_type_JavaLangString;
      } else {
        str = "";
      }
      this.jdField_a_of_type_JavaUtilList.add(WSGridPageFragment.a(localWSTabInfo.a(), true, bool, str, this.jdField_c_of_type_Boolean));
      i += 1;
    }
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.setTabItemSelect(paramInt, jdField_a_of_type_Int);
    Object localObject = this.jdField_a_of_type_JavaUtilList;
    if (localObject != null)
    {
      if (paramInt >= ((List)localObject).size()) {
        return;
      }
      int i = this.jdField_c_of_type_Int;
      this.jdField_c_of_type_Int = paramInt;
      localObject = a(i);
      if (localObject != null) {
        ((WSGridPageFragment)localObject).h();
      }
      localObject = a(paramInt);
      if (localObject != null) {
        ((WSGridPageFragment)localObject).g();
      }
      if (paramInt != 0)
      {
        localObject = new WSPreloadTabEvent();
        ((WSPreloadTabEvent)localObject).setPosition(paramInt);
        WSSimpleEventBus.a().a((WSSimpleBaseEvent)localObject);
      }
      WSTabBeaconReport.a(paramInt, ((WSTabInfo)this.jdField_b_of_type_JavaUtilList.get(paramInt)).a());
    }
  }
  
  private void a(WSSubTabData paramWSSubTabData)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener(new WSRecommendFragment.3(this, paramWSSubTabData));
  }
  
  private void a(List<WSTabInfo> paramList)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter = new WSHomeFragmentAdapter(getChildFragmentManager(), a(paramList));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newWSHomeFragmentAdapter);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSViewPager.setOffscreenPageLimit(5);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSViewPager.addOnPageChangeListener(new WSRecommendFragment.2(this));
    this.jdField_c_of_type_Int = 0;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout = ((WSTabLayout)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout.findViewById(2131381238));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSViewPager = ((WSViewPager)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout.findViewById(2131381256));
    this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout.findViewById(2131380853);
    c();
    d();
    e();
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout.setBackgroundColor(-16777216);
    } else {
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout.setBackgroundColor(-1);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout.setOnActionListener(new WSOnActionListenerImpl(this, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout));
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
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.setupWithViewPager(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSViewPager);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.a(this.jdField_b_of_type_JavaUtilList, new WSRecommendFragment.1(this));
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewTabLayoutWSTabLayout.setTabItemSelect(0, jdField_a_of_type_Int);
    a(localWSSubTabData);
  }
  
  private void e()
  {
    WSSimpleEventBus.a().a(this);
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @NonNull
  public IWSPresenter a()
  {
    return new WSBasePresenter();
  }
  
  public ArrayList<Class> a()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(WSPreloadTabEvent.class);
    return localArrayList;
  }
  
  public void a(WSSimpleBaseEvent paramWSSimpleBaseEvent)
  {
    if (!(paramWSSimpleBaseEvent instanceof WSPreloadTabEvent)) {
      return;
    }
    int j = ((WSPreloadTabEvent)paramWSSimpleBaseEvent).getPosition();
    int i = j;
    if (j == -1) {
      i = this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSViewPager.getCurrentItem();
    }
    i += 1;
    if (i >= this.jdField_a_of_type_JavaUtilList.size()) {
      return;
    }
    ((WSGridPageFragment)this.jdField_a_of_type_JavaUtilList.get(i)).m();
  }
  
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSRecommendFragment.java][setCurrentViewPagerCanScroll] canScroll:");
    localStringBuilder.append(paramBoolean);
    WSLog.d("WSRecommendFragment", localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSViewPager.setCanScrollHorizontally(paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSViewPager.setScrollable(paramBoolean);
  }
  
  public void g()
  {
    WSLog.b("WSRecommendFragment", "[WSRecommendFragment.java][onTabSelected]");
    WSGridPageFragment localWSGridPageFragment = a(this.jdField_c_of_type_Int);
    if (localWSGridPageFragment != null) {
      localWSGridPageFragment.g();
    }
  }
  
  public void h()
  {
    WSLog.b("WSRecommendFragment", "[WSRecommendFragment.java][onTabUnselected]");
    WSGridPageFragment localWSGridPageFragment = a(this.jdField_c_of_type_Int);
    if (localWSGridPageFragment != null) {
      localWSGridPageFragment.h();
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (getArguments() != null)
    {
      this.jdField_a_of_type_JavaLangString = getArguments().getString("key_context_feed_id");
      this.jdField_c_of_type_Boolean = getArguments().getBoolean("key_show_context_feed_musk");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout = ((WSFeedsLinearLayout)paramLayoutInflater.inflate(2131560017, paramViewGroup, false));
    return this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newViewWSFeedsLinearLayout;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    WSSimpleEventBus.a().b(this);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment
 * JD-Core Version:    0.7.0.1
 */