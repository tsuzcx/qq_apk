package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJThreadHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.BaseDynamicGridAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyStaticGridView;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.net.URLDecoder;
import java.util.Map;
import org.json.JSONException;

class ReadInJoyChannelPanelFragment$RecommendChannelAdapterCallback
  implements RIJBaseChannelGridViewAdapter.AdapterCallback
{
  private final long jdField_a_of_type_Long;
  private final int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public ReadInJoyChannelPanelFragment$RecommendChannelAdapterCallback(ReadInJoyChannelPanelFragment paramReadInJoyChannelPanelFragment, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, ReadInJoyDynamicGridView.BaseDynamicGridAdapter paramBaseDynamicGridAdapter)
  {
    if (RIJChannelHelper.a(paramTabChannelCoverInfo) == 0)
    {
      ReadInJoyChannelPanelFragment.c(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, true);
      paramTabChannelCoverInfo.redPoint.a = false;
      if (paramBaseDynamicGridAdapter != null) {
        paramBaseDynamicGridAdapter.notifyDataSetChanged();
      }
    }
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, AdapterView<?> paramAdapterView, int paramInt, int[] paramArrayOfInt)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "moveChannelToMine, position = ", Integer.valueOf(paramInt), ", tab = " + paramTabChannelCoverInfo });
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, paramTabChannelCoverInfo);
    ((ReadInJoyStaticGridView)paramAdapterView).a(paramInt, paramAdapterView.getCount() - 1);
    ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).a(paramTabChannelCoverInfo);
    try
    {
      RIJChannelReporter.a("0X800949D", new RIJTransMergeKanDianReport.ReportR5Builder().b().a(paramTabChannelCoverInfo.mChannelCoverId).m(RIJChannelHelper.a(paramTabChannelCoverInfo)).n(RIJChannelHelper.a(paramTabChannelCoverInfo)).c((int)paramTabChannelCoverInfo.sectionId).a());
      if (ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment) == null) {
        ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment, new ReadInJoyChannelPanelFragment.RecommendChannelAdapterCallback.2(this, paramArrayOfInt));
      }
      ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment).getViewTreeObserver().addOnPreDrawListener(ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment));
      ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment);
      return;
    }
    catch (JSONException paramTabChannelCoverInfo)
    {
      for (;;)
      {
        paramTabChannelCoverInfo.printStackTrace();
      }
    }
  }
  
  private void a(AdapterView<?> paramAdapterView, int paramInt, int[] paramArrayOfInt, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    try
    {
      RIJChannelReporter.a("0X8009499", new RIJTransMergeKanDianReport.ReportR5Builder().b().a(paramTabChannelCoverInfo.mChannelCoverId).m(RIJChannelHelper.a(paramTabChannelCoverInfo)).n(RIJChannelHelper.a(paramTabChannelCoverInfo)).c((int)paramTabChannelCoverInfo.sectionId).b("style", 1).a());
      if (ChannelCoverInfoModule.a(paramTabChannelCoverInfo.mChannelCoverId))
      {
        a(paramTabChannelCoverInfo, paramAdapterView, paramInt, paramArrayOfInt);
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment.getActivity().finish();
        ReadInJoyLogicEngine.a().c(paramTabChannelCoverInfo.mChannelCoverId, 3);
        RIJThreadHandler.b().post(new ReadInJoyChannelPanelFragment.RecommendChannelAdapterCallback.1(this, paramTabChannelCoverInfo));
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("ReadInJoyChannelPanelFragment", 1, "reportData error ->" + localJSONException.getMessage());
      }
      if (!TextUtils.isEmpty(paramTabChannelCoverInfo.mChannelJumpUrl)) {
        try
        {
          paramAdapterView = URLDecoder.decode(paramTabChannelCoverInfo.mChannelJumpUrl, "utf-8");
          ViolaAccessHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment.getActivity(), paramTabChannelCoverInfo.mChannelCoverName, paramAdapterView, null);
          return;
        }
        catch (Exception paramAdapterView)
        {
          paramAdapterView.printStackTrace();
          QLog.w("ReadInJoyChannelPanelFragment", 1, "gotoReadInJoyViolaChannel, v_url error->" + paramAdapterView.getMessage());
          return;
        }
      }
      if (paramTabChannelCoverInfo.mChannelType == 3)
      {
        ReadInJoyActivityHelper.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment.getActivity(), paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelCoverName, paramTabChannelCoverInfo.mChannelType, -1);
        return;
      }
      ReadInJoyActivityHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment.getActivity(), paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelCoverName, paramTabChannelCoverInfo.mChannelType, -1);
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
    RIJChannelReporter.a(localReportData, (int)this.jdField_a_of_type_Long);
  }
  
  public void a(AdapterView<?> paramAdapterView, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    QLog.d("ReadInJoyChannelPanelFragment", 1, new Object[] { "onRecommendChannelClick, position = ", Integer.valueOf(paramInt), ", tab = " + paramTabChannelCoverInfo });
    paramAdapterView.getChildAt(paramInt).getLocationOnScreen(this.jdField_a_of_type_ArrayOfInt);
    a(paramTabChannelCoverInfo, paramRIJBaseChannelGridViewAdapter);
    if (!ReadInJoyChannelPanelFragment.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyChannelPanelFragment))
    {
      a(paramAdapterView, paramInt, this.jdField_a_of_type_ArrayOfInt, paramTabChannelCoverInfo);
      return;
    }
    a(paramTabChannelCoverInfo, paramAdapterView, paramInt, this.jdField_a_of_type_ArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment.RecommendChannelAdapterCallback
 * JD-Core Version:    0.7.0.1
 */