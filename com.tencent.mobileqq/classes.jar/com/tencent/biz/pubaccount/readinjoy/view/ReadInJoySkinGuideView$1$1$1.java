package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.surfaceviewaction.ILayer;
import com.tencent.mobileqq.surfaceviewaction.nv.Node;
import com.tencent.mobileqq.surfaceviewaction.nv.SpriteNativeView;
import org.json.JSONException;

class ReadInJoySkinGuideView$1$1$1
  implements Runnable
{
  ReadInJoySkinGuideView$1$1$1(ReadInJoySkinGuideView.1.1 param1, ILayer paramILayer) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView$1$1.a.this$0.a.a((Node)this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionILayer);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView$1$1.a.this$0.a.a();
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
    try
    {
      localReportR5Builder.e();
      localReportR5Builder.a("guide_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView$1$1.a.b);
      localReportR5Builder.a("channel_id", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView$1$1.a.jdField_a_of_type_Int);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView$1$1.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "", "0X8008C80", "0X8008C80", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView$1$1.a.b, "" + RIJAppSetting.a(), "" + ReadInJoySkinGuideView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoySkinGuideView$1$1.a.this$0), localReportR5Builder.a(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView.1.1.1
 * JD-Core Version:    0.7.0.1
 */