package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.BaseDynamicGridAdapter;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import java.net.URLDecoder;
import java.util.Map;

class RIJXTabChannelPanelFragment$RecommendChannelAdapterCallback
  implements RIJBaseChannelGridViewAdapter.AdapterCallback
{
  private RIJXTabChannelPanelFragment$RecommendChannelAdapterCallback(RIJXTabChannelPanelFragment paramRIJXTabChannelPanelFragment) {}
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, ReadInJoyDynamicGridView.BaseDynamicGridAdapter paramBaseDynamicGridAdapter)
  {
    if (RIJChannelHelper.a(paramTabChannelCoverInfo) == 0)
    {
      paramTabChannelCoverInfo.redPoint.a = false;
      if (paramBaseDynamicGridAdapter != null) {
        paramBaseDynamicGridAdapter.notifyDataSetChanged();
      }
    }
  }
  
  private void b(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    RIJChannelReporter.a("0X800949D", new RIJTransMergeKanDianReport.ReportR5Builder().a(paramTabChannelCoverInfo.mChannelCoverId).f().a());
    if (!TextUtils.isEmpty(paramTabChannelCoverInfo.mChannelJumpUrl)) {
      try
      {
        String str = URLDecoder.decode(paramTabChannelCoverInfo.mChannelJumpUrl, "utf-8");
        ViolaAccessHelper.a(this.a.getActivity(), paramTabChannelCoverInfo.mChannelCoverName, str, null);
        return;
      }
      catch (Exception paramTabChannelCoverInfo)
      {
        paramTabChannelCoverInfo.printStackTrace();
        QLog.w("RIJXTabChannelPanelFragment", 1, "gotoReadInJoyViolaChannel, v_url error->" + paramTabChannelCoverInfo.getMessage());
        return;
      }
    }
    if (paramTabChannelCoverInfo.mChannelType == 3)
    {
      ReadInJoyActivityHelper.b(this.a.getActivity(), paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelCoverName, paramTabChannelCoverInfo.mChannelType, -1);
      return;
    }
    ReadInJoyActivityHelper.a(this.a.getActivity(), paramTabChannelCoverInfo.mChannelCoverId, paramTabChannelCoverInfo.mChannelCoverName, paramTabChannelCoverInfo.mChannelType, -1);
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    RIJXTabChannelPanelFragment.a(this.a).put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), paramTabChannelCoverInfo);
  }
  
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt) {}
  
  public void a(AdapterView<?> paramAdapterView, RIJBaseChannelGridViewAdapter paramRIJBaseChannelGridViewAdapter, int paramInt, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    QLog.d("RIJXTabChannelPanelFragment", 1, new Object[] { "onRecommendChannelClick, position = ", Integer.valueOf(paramInt), ", tab = " + paramTabChannelCoverInfo });
    a(paramTabChannelCoverInfo, paramRIJBaseChannelGridViewAdapter);
    b(paramTabChannelCoverInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.RIJXTabChannelPanelFragment.RecommendChannelAdapterCallback
 * JD-Core Version:    0.7.0.1
 */