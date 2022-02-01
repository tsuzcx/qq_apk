package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stNotificationRsp;
import com.tencent.biz.pubaccount.weishi_new.jump.IJumpListener;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;

final class WSNoticeJumpUtils$1
  implements IJumpListener
{
  WSNoticeJumpUtils$1(stNotificationRsp paramstNotificationRsp, String paramString) {}
  
  public void a()
  {
    UserActionReportPresenter.a(4, 114, 0, null, null);
    WSReportDc00898.a(114, this.jdField_a_of_type_UserGrowthStNotificationRsp.type, this.jdField_a_of_type_UserGrowthStNotificationRsp.cid);
    WSGridBeaconReport.a("gzh_click", this.jdField_a_of_type_UserGrowthStNotificationRsp.type, 1000003, this.jdField_a_of_type_UserGrowthStNotificationRsp.cid, this.jdField_a_of_type_UserGrowthStNotificationRsp.trace_id, this.jdField_a_of_type_JavaLangString);
  }
  
  public void b() {}
  
  public void c()
  {
    WSReportDc00898.a(140, this.jdField_a_of_type_UserGrowthStNotificationRsp.type, this.jdField_a_of_type_UserGrowthStNotificationRsp.cid);
    WSGridBeaconReport.a("gzh_click", this.jdField_a_of_type_UserGrowthStNotificationRsp.type, 1000004, this.jdField_a_of_type_UserGrowthStNotificationRsp.cid, this.jdField_a_of_type_UserGrowthStNotificationRsp.trace_id, this.jdField_a_of_type_JavaLangString);
  }
  
  public void d()
  {
    WSReportDc00898.a(115, this.jdField_a_of_type_UserGrowthStNotificationRsp.type, this.jdField_a_of_type_UserGrowthStNotificationRsp.cid);
    WSGridBeaconReport.a("gzh_click", this.jdField_a_of_type_UserGrowthStNotificationRsp.type, 1000002, this.jdField_a_of_type_UserGrowthStNotificationRsp.cid, this.jdField_a_of_type_UserGrowthStNotificationRsp.trace_id, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSNoticeJumpUtils.1
 * JD-Core Version:    0.7.0.1
 */