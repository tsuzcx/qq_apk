package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.mobileqq.qroute.QRoute;

final class RIJStatisticCollectorReport$2
  implements Runnable
{
  RIJStatisticCollectorReport$2(boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, long paramLong, String paramString1, boolean paramBoolean2, String paramString2) {}
  
  public void run()
  {
    String str = new VideoR5.Builder(null, null, null, null).f(this.jdField_a_of_type_Boolean).G(this.jdField_a_of_type_Int).a(this.jdField_b_of_type_Int).F(this.c).g(this.jdField_a_of_type_Long).j(this.jdField_a_of_type_JavaLangString).a().a();
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    if (this.jdField_b_of_type_Boolean) {}
    for (int i = 1;; i = 0)
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(null, "", "0X80094FD", "0X80094FD", 0, i, "", "", this.jdField_b_of_type_JavaLangString, str, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJStatisticCollectorReport.2
 * JD-Core Version:    0.7.0.1
 */