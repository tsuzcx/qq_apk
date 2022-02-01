package com.tencent.mobileqq.apollo.debug.page;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.debug.CmGameDebugManager;
import com.tencent.mobileqq.apollo.debug.log.CmGameDebugLogPagerAdapter;
import com.tencent.mobileqq.apollo.debug.log.CmGameDebugLogView;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.List;

public class CmGameDebugLogFragment
  extends CmGameDebugBaseFragment
  implements View.OnClickListener
{
  TextView jdField_a_of_type_AndroidWidgetTextView;
  TabLayoutCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat;
  ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private CmGameDebugLogPagerAdapter jdField_a_of_type_ComTencentMobileqqApolloDebugLogCmGameDebugLogPagerAdapter;
  private List<CmGameDebugLogView> jdField_a_of_type_JavaUtilList = new ArrayList();
  TextView b;
  
  private CmGameDebugLogView a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      CmGameDebugLogView localCmGameDebugLogView = (CmGameDebugLogView)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localCmGameDebugLogView.a() == paramInt) {
        return localCmGameDebugLogView;
      }
      i += 1;
    }
    return null;
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < CmGameDebugManager.b.length)
    {
      CmGameDebugLogView localCmGameDebugLogView = a(getActivity(), i);
      this.jdField_a_of_type_JavaUtilList.add(localCmGameDebugLogView);
      localArrayList.add(CmGameDebugManager.b[i]);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloDebugLogCmGameDebugLogPagerAdapter = new CmGameDebugLogPagerAdapter(this.jdField_a_of_type_JavaUtilList, localArrayList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloDebugLogCmGameDebugLogPagerAdapter);
  }
  
  public CmGameDebugLogView a(Context paramContext, int paramInt)
  {
    return new CmGameDebugLogView(paramContext, paramInt);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((CmGameDebugLogView)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(true);
        paramInt += 1;
      }
    }
    CmGameDebugLogView localCmGameDebugLogView = a(paramInt);
    if (localCmGameDebugLogView != null) {
      localCmGameDebugLogView.a(false);
    }
    localCmGameDebugLogView = a(0);
    if (localCmGameDebugLogView != null) {
      localCmGameDebugLogView.a(false);
    }
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
      CmGameDebugManager localCmGameDebugManager = CmGameUtil.a();
      if (localCmGameDebugManager != null)
      {
        localCmGameDebugManager.a(true);
        continue;
        a();
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558976, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = ((TabLayoutCompat)paramLayoutInflater.findViewById(2131364875));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)paramLayoutInflater.findViewById(2131364876));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131364871));
    this.b = ((TextView)paramLayoutInflater.findViewById(2131364872));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextColors(-16777216, -16777216);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorHeight(DisplayUtil.a(BaseApplicationImpl.getApplication(), 1.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorColor(Color.parseColor("#6090e3"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setupWithViewPager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat);
    b();
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.jdField_a_of_type_JavaUtilList.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.page.CmGameDebugLogFragment
 * JD-Core Version:    0.7.0.1
 */