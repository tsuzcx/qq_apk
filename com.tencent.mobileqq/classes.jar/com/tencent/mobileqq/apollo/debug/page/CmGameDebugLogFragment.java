package com.tencent.mobileqq.apollo.debug.page;

import akst;
import aktb;
import akwd;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import bdaq;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.debug.log.CmGameDebugLogPagerAdapter;
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
  private List<aktb> jdField_a_of_type_JavaUtilList = new ArrayList();
  TextView b;
  
  private aktb a(int paramInt)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      aktb localaktb = (aktb)this.jdField_a_of_type_JavaUtilList.get(i);
      if (localaktb.a() == paramInt) {
        return localaktb;
      }
      i += 1;
    }
    return null;
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < akst.b.length)
    {
      aktb localaktb = a(getActivity(), i);
      this.jdField_a_of_type_JavaUtilList.add(localaktb);
      localArrayList.add(akst.b[i]);
      i += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloDebugLogCmGameDebugLogPagerAdapter = new CmGameDebugLogPagerAdapter(this.jdField_a_of_type_JavaUtilList, localArrayList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(this.jdField_a_of_type_ComTencentMobileqqApolloDebugLogCmGameDebugLogPagerAdapter);
  }
  
  public aktb a(Context paramContext, int paramInt)
  {
    return new aktb(paramContext, paramInt);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == 0)
    {
      paramInt = 0;
      while (paramInt < this.jdField_a_of_type_JavaUtilList.size())
      {
        ((aktb)this.jdField_a_of_type_JavaUtilList.get(paramInt)).a(true);
        paramInt += 1;
      }
    }
    aktb localaktb = a(paramInt);
    if (localaktb != null) {
      localaktb.a(false);
    }
    localaktb = a(0);
    if (localaktb != null) {
      localaktb.a(false);
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131364381: 
      do
      {
        return;
        paramView = akwd.a();
      } while (paramView == null);
      paramView.a(true);
      return;
    }
    a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558829, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = ((TabLayoutCompat)paramLayoutInflater.findViewById(2131364385));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)paramLayoutInflater.findViewById(2131364386));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131364381));
    this.b = ((TextView)paramLayoutInflater.findViewById(2131364382));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextColors(-16777216, -16777216);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorHeight(bdaq.a(BaseApplicationImpl.getApplication(), 1.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorColor(Color.parseColor("#6090e3"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setupWithViewPager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat);
    b();
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