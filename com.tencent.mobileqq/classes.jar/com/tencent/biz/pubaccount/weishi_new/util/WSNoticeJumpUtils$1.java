package com.tencent.biz.pubaccount.weishi_new.util;

import UserGrowth.stNotificationRsp;
import com.tencent.biz.pubaccount.weishi_new.jump.OnJumpListener;
import com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;

final class WSNoticeJumpUtils$1
  extends OnJumpListener
{
  WSNoticeJumpUtils$1(stNotificationRsp paramstNotificationRsp, String paramString) {}
  
  public void a()
  {
    UserActionReportPresenter.a(4, 114, 0, null, null);
    WSReportDc00898.a(114, this.a.type, this.a.cid);
    WSGridBeaconReport.a("gzh_click", this.a.type, 1000003, this.a.cid, this.a.trace_id, this.b);
  }
  
  public void b() {}
  
  public void c()
  {
    WSReportDc00898.a(140, this.a.type, this.a.cid);
    WSGridBeaconReport.a("gzh_click", this.a.type, 1000004, this.a.cid, this.a.trace_id, this.b);
  }
  
  public void d()
  {
    WSReportDc00898.a(115, this.a.type, this.a.cid);
    WSGridBeaconReport.a("gzh_click", this.a.type, 1000002, this.a.cid, this.a.trace_id, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.util.WSNoticeJumpUtils.1
 * JD-Core Version:    0.7.0.1
 */