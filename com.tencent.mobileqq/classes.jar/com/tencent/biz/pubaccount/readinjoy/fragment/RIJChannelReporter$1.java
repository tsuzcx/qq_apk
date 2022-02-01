package com.tencent.biz.pubaccount.readinjoy.fragment;

import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ChannelListDynamicOrderConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;

final class RIJChannelReporter$1
  implements Runnable
{
  RIJChannelReporter$1(TabChannelCoverInfo paramTabChannelCoverInfo, BaseReportData paramBaseReportData, int paramInt) {}
  
  public void run()
  {
    try
    {
      int i = ChannelListDynamicOrderConfigHandler.a(ReadInJoyUtils.a(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.mChannelCoverId);
      RIJChannelReporter.a("0X8009954", new RIJTransMergeKanDianReport.ReportR5Builder().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo.mChannelCoverId).b().n(RIJChannelHelper.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTabChannelCoverInfo)).b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseReportData.l + 1).c(this.jdField_a_of_type_Int).b("is_change", i).b("style", 0).a());
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      QLog.d("RIJChannelReporter", 2, new Object[] { "reportChannelExposure exception ", localJSONException.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.RIJChannelReporter.1
 * JD-Core Version:    0.7.0.1
 */