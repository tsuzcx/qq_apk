package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJThreadHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelSection;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.BaseDynamicGridAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyStaticGridView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

class ReadInJoyChannelPanelFragment$MyChannelAdapterCallback
  implements RIJDynamicChannelGridViewAdapter.DynamicAdapterCallback
{
  private int jdField_a_of_type_Int = -1;
  private int b = 0;
  
  private ReadInJoyChannelPanelFragment$MyChannelAdapterCallback(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment) {}
  
  private int a()
  {
    if (ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment) == null) {}
    label91:
    for (;;)
    {
      int k = -1;
      return k;
      List localList = ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).a();
      if (localList != null)
      {
        int i = 0;
        for (;;)
        {
          if (i >= localList.size()) {
            break label91;
          }
          TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localList.get(i);
          k = ChannelCoverInfoModule.a();
          int j = k;
          if (k == -1) {
            j = 0;
          }
          if (localTabChannelCoverInfo != null)
          {
            k = i;
            if (localTabChannelCoverInfo.mChannelCoverId == j) {
              break;
            }
          }
          i += 1;
        }
      }
    }
  }
  
  private void a(RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter)
  {
    int i = a();
    if (i != -1)
    {
      ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, i);
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)paramRIJBaseChannelGridViewAdapter.getItem(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment));
      if (localTabChannelCoverInfo != null)
      {
        localTabChannelCoverInfo.isCurrent = true;
        paramRIJBaseChannelGridViewAdapter.notifyDataSetChanged();
      }
      QLog.d("ReadInJoyChannelPanelFragment", 1, "getRecommendChannelIndex: " + ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment));
    }
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, ReadInJoyDynamicGridView.BaseDynamicGridAdapter paramBaseDynamicGridAdapter)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, "clearChannelInfoRedDot, tabChannelCoverInfo = " + paramTabChannelCoverInfo);
    if (RIJChannelHelper.a(paramTabChannelCoverInfo) >= 0)
    {
      ReadInJoyChannelPanelFragment.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, true);
      paramTabChannelCoverInfo.redPoint.a = false;
      if (paramBaseDynamicGridAdapter != null) {
        paramBaseDynamicGridAdapter.notifyDataSetChanged();
      }
    }
  }
  
  private void b(int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "deleteChannelItem, position = ", Integer.valueOf(paramInt), ", tabChannelCoverInfo = " + paramTabChannelCoverInfo });
    int[] arrayOfInt = new int[2];
    if (paramInt < this.b) {
      QLog.d("ReadInJoyChannelPanelFragment", 2, new Object[] { "can not delete item, position = ", Integer.valueOf(paramInt), ", lockCount = ", Integer.valueOf(this.b) });
    }
    do
    {
      return;
      ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, paramTabChannelCoverInfo);
      try
      {
        RIJChannelReporter.a("0X800949C", new RIJTransMergeKanDianReport.ReportR5Builder().b().a(paramTabChannelCoverInfo.mChannelCoverId).m(RIJChannelHelper.a(paramTabChannelCoverInfo)).a());
        if (ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).getChildAt(paramInt) == null)
        {
          QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "deleteChannelItem NPE, position = ", Integer.valueOf(paramInt), ", tabChannelCoverInfo = " + paramTabChannelCoverInfo });
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
        ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).getChildAt(paramInt).getLocationOnScreen(arrayOfInt);
      }
    } while (!ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).a(paramInt, ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).getCount() - 1));
    ReadInJoyStaticGridView localReadInJoyStaticGridView = (ReadInJoyStaticGridView)ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).findViewWithTag(Long.valueOf(paramTabChannelCoverInfo.sectionId));
    if (localReadInJoyStaticGridView == null) {
      localReadInJoyStaticGridView = (ReadInJoyStaticGridView)ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).get(0);
    }
    for (paramTabChannelCoverInfo.channelConfigType = ((ChannelSection)ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).get(1)).a;; paramTabChannelCoverInfo.channelConfigType = paramTabChannelCoverInfo.sectionId)
    {
      localReadInJoyStaticGridView.a(localReadInJoyStaticGridView.getAdapter().getCount() - 1, 0, paramTabChannelCoverInfo);
      paramTabChannelCoverInfo = new ReadInJoyChannelPanelFragment.MyChannelAdapterCallback.2(this, localReadInJoyStaticGridView, arrayOfInt);
      localReadInJoyStaticGridView.setTag(2131376542, paramTabChannelCoverInfo);
      localReadInJoyStaticGridView.getViewTreeObserver().addOnPreDrawListener(paramTabChannelCoverInfo);
      if (paramInt != ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment)) {
        break;
      }
      a(paramRIJBaseChannelGridViewAdapter);
      return;
    }
  }
  
  public void a()
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, "onActionDrop");
    ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, false);
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, -1);
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).setLockCount(paramInt);
    QLog.d("ReadInJoyChannelPanelFragment", 2, "onLockCountChanged:" + paramInt);
  }
  
  public void a(int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "onClick, delete button position = ", Integer.valueOf(paramInt) });
    b(paramInt, paramTabChannelCoverInfo, paramRIJBaseChannelGridViewAdapter);
  }
  
  public void a(RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter, int paramInt1, int paramInt2)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, "onDragPositionsChanged, onDragPosition: " + this.jdField_a_of_type_Int);
    TabChannelCoverInfo localTabChannelCoverInfo = null;
    if (this.jdField_a_of_type_Int >= 0) {
      localTabChannelCoverInfo = (TabChannelCoverInfo)paramRIJBaseChannelGridViewAdapter.getItem(this.jdField_a_of_type_Int);
    }
    if (localTabChannelCoverInfo != null) {}
    try
    {
      RIJChannelReporter.a("0X800949B", new RIJTransMergeKanDianReport.ReportR5Builder().b().a(localTabChannelCoverInfo.mChannelCoverId).m(RIJChannelHelper.a(localTabChannelCoverInfo)).a());
      this.jdField_a_of_type_Int = -1;
      return;
    }
    catch (JSONException paramRIJBaseChannelGridViewAdapter)
    {
      for (;;)
      {
        paramRIJBaseChannelGridViewAdapter.printStackTrace();
      }
    }
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), paramTabChannelCoverInfo);
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    ReportData localReportData = new ReportData();
    localReportData.a = paramTabChannelCoverInfo;
    localReportData.l = paramInt;
    RIJChannelReporter.a(localReportData, TabChannelCoverInfo.TYPE_CHANNEL_RECOMMEND_CONFIG);
  }
  
  public void a(AdapterView<?> paramAdapterView, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "onMyChannelClick, position = ", Integer.valueOf(paramInt), ", tab = ", paramTabChannelCoverInfo, ", isEditMode: ", Boolean.valueOf(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment)) });
    if (!ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment)) {
      try
      {
        RIJChannelReporter.a("0X8009499", new RIJTransMergeKanDianReport.ReportR5Builder().b().a(paramTabChannelCoverInfo.mChannelCoverId).m(RIJChannelHelper.a(paramTabChannelCoverInfo)).n(RIJChannelHelper.a(paramTabChannelCoverInfo)).c((int)paramTabChannelCoverInfo.sectionId).b("style", 1).a());
        a(paramTabChannelCoverInfo, paramRIJBaseChannelGridViewAdapter);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment.getActivity().finish();
        if (ReadInJoyHelper.D())
        {
          ReadInJoyLogicEngine.a().a(paramTabChannelCoverInfo.mChannelCoverId, 3, false, true);
          RIJThreadHandler.b().post(new ReadInJoyChannelPanelFragment.MyChannelAdapterCallback.1(this, paramTabChannelCoverInfo));
          return;
        }
      }
      catch (JSONException paramAdapterView)
      {
        for (;;)
        {
          paramAdapterView.printStackTrace();
          continue;
          ReadInJoyLogicEngine.a().b(paramTabChannelCoverInfo.mChannelCoverId, 3);
        }
      }
    }
    b(paramInt, paramTabChannelCoverInfo, paramRIJBaseChannelGridViewAdapter);
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment);
  }
  
  public void b(AdapterView<?> paramAdapterView, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "onChannelLongClick, position = ", Integer.valueOf(paramInt), ", tabInfo = " + paramTabChannelCoverInfo });
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, true);
    if (paramInt >= this.b)
    {
      this.jdField_a_of_type_Int = paramInt;
      ReadInJoyChannelPanelFragment.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, true);
      ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, paramTabChannelCoverInfo);
    }
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, paramInt);
    try
    {
      RIJChannelReporter.a("0X800949A", new RIJTransMergeKanDianReport.ReportR5Builder().b().a(paramTabChannelCoverInfo.mChannelCoverId).m(RIJChannelHelper.a(paramTabChannelCoverInfo)).a());
      return;
    }
    catch (JSONException paramAdapterView)
    {
      paramAdapterView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment.MyChannelAdapterCallback
 * JD-Core Version:    0.7.0.1
 */