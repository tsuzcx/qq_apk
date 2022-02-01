package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicManager;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelSection;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyStaticGridView;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.SlideDownFrameLayout;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class RIJXTabChannelPanelFragment
  extends RIJBaseChannelPanelFragment
{
  private ReadInJoyLogicEngine jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine;
  private RIJStaticChannelGridViewAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJStaticChannelGridViewAdapter;
  private ReadInJoyStaticGridView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyStaticGridView;
  private List<TabChannelCoverInfo> jdField_a_of_type_JavaUtilList;
  private Map<Integer, TabChannelCoverInfo> jdField_a_of_type_JavaUtilMap;
  
  private boolean a(TabChannelCoverInfo paramTabChannelCoverInfo, List<TabChannelCoverInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)paramList.next();
      if ((localTabChannelCoverInfo.mChannelCoverId == paramTabChannelCoverInfo.mChannelCoverId) || ((paramTabChannelCoverInfo.mChannelCoverName != null) && (paramTabChannelCoverInfo.mChannelCoverName.equals(localTabChannelCoverInfo.mChannelCoverName)))) {
        return true;
      }
    }
    return false;
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaUtilList = a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine.a());
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  private void c()
  {
    ThreadManager.executeOnSubThread(new RIJXTabChannelPanelFragment.1(this));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyStaticGridView = ((ReadInJoyStaticGridView)this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout.findViewById(2131376720));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJStaticChannelGridViewAdapter = new RIJStaticChannelGridViewAdapter(getActivity(), 4, this.jdField_a_of_type_Int, new RIJXTabChannelPanelFragment.RecommendChannelAdapterCallback(this, null));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJStaticChannelGridViewAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyStaticGridView.setExpendable(true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyStaticGridView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJStaticChannelGridViewAdapter);
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine = ((ReadInJoyLogicManager)ReadInJoyUtils.a().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).a();
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyStaticGridView.setOnItemClickListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentRIJStaticChannelGridViewAdapter);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_JavaUtilMap == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.values().iterator();
    while (localIterator.hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
      if (RIJChannelHelper.a(localTabChannelCoverInfo) == 1)
      {
        localTabChannelCoverInfo.redPoint.a = false;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine.a(localTabChannelCoverInfo);
      }
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine.c(false);
  }
  
  int a()
  {
    return 2131562902;
  }
  
  String a()
  {
    return getString(2131718338);
  }
  
  @VisibleForTesting
  public List<TabChannelCoverInfo> a(List<ChannelSection> paramList)
  {
    Object localObject = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      while (i < paramList.size())
      {
        ((List)localObject).addAll(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine.b(i));
        i += 1;
      }
    }
    paramList = RIJXTabFrameUtils.a();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
      if (!a(localTabChannelCoverInfo, paramList)) {
        localArrayList.add(localTabChannelCoverInfo);
      }
    }
    return localArrayList;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    e();
    c();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    b();
    d();
    f();
    paramLayoutInflater = this.jdField_a_of_type_ComTencentMobileqqWidgetSlideDownFrameLayout;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    g();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyLogicEngine = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.RIJXTabChannelPanelFragment
 * JD-Core Version:    0.7.0.1
 */