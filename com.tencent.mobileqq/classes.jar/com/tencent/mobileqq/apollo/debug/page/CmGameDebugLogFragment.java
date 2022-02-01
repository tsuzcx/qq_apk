package com.tencent.mobileqq.apollo.debug.page;

import amxt;
import amyb;
import anbd;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import bhgr;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.debug.log.CmGameDebugLogPagerAdapter;
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
  private List<amyb> jdField_a_of_type_JavaUtilList = new ArrayList();
  TextView b;
  
  private amyb a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      amyb localamyb = (amyb)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localamyb.a() == paramInt) {
        return localamyb;
      }
      i += 1;
    }
    return null;
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < amxt.b.length)
    {
      amyb localamyb = a(getActivity(), i);
      this.jdField_a_of_type_JavaUtilList.add(localamyb);
      localArrayList.add(amxt.b[i]);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloDebugLogCmGameDebugLogPagerAdapter = new CmGameDebugLogPagerAdapter(this.jdField_a_of_type_JavaUtilList, localArrayList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloDebugLogCmGameDebugLogPagerAdapter);
  }
  
  public amyb a(Context paramContext, int paramInt)
  {
    return new amyb(paramContext, paramInt);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((amyb)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(true);
        paramInt += 1;
      }
    }
    amyb localamyb = a(paramInt);
    if (localamyb != null) {
      localamyb.a(false);
    }
    localamyb = a(0);
    if (localamyb != null) {
      localamyb.a(false);
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
      amxt localamxt = anbd.a();
      if (localamxt != null)
      {
        localamxt.a(true);
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
    paramLayoutInflater = paramLayoutInflater.inflate(2131558900, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = ((TabLayoutCompat)paramLayoutInflater.findViewById(2131364641));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)paramLayoutInflater.findViewById(2131364642));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131364637));
    this.b = ((TextView)paramLayoutInflater.findViewById(2131364638));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextColors(-16777216, -16777216);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorHeight(bhgr.a(BaseApplicationImpl.getApplication(), 1.0F));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.page.CmGameDebugLogFragment
 * JD-Core Version:    0.7.0.1
 */