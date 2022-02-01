package com.tencent.biz.pubaccount.readinjoy.view;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.handlers.BaseHandler;
import com.tencent.mobileqq.qroute.QRoute;

class ReadInJoyBaseAdapter$1$1
  implements Runnable
{
  ReadInJoyBaseAdapter$1$1(ReadInJoyBaseAdapter.1 param1, long paramLong, BaseHandler paramBaseHandler) {}
  
  public void run()
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder1 = new RIJTransMergeKanDianReport.ReportR5Builder();
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder2 = localReportR5Builder1.a("cost", this.jdField_a_of_type_Long).b("type", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$1.jdField_a_of_type_Int);
    Object localObject;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$1.jdField_a_of_type_JavaLangObject == null)
    {
      localObject = "0";
      localObject = localReportR5Builder2.b("result", (String)localObject).b("handleID", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyHandlersBaseHandler.a());
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter$1.jdField_a_of_type_AndroidViewView != null) {
        break label124;
      }
    }
    label124:
    for (int i = 1;; i = 0)
    {
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).b("isNewCreate", i).b("isDebugVersion", 0).b("isPublicVersion", 1);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountSimpleReportWithR5("0X800AF90", localReportR5Builder1.a());
      return;
      localObject = "1";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */