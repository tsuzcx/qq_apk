package com.tencent.biz.pubaccount.weishi_new.report;

import UserGrowth.stWeishiReportRsp;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

final class UserActionReportPresenter$1
  implements IWeishiServiceListener
{
  UserActionReportPresenter$1(String paramString) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    WSLog.b("weishi-report", "report " + this.a + " start...");
    if ((paramWeishiTask != null) && (paramWeishiTask.a != null) && ((paramWeishiTask.a instanceof stWeishiReportRsp)))
    {
      paramWeishiTask = (stWeishiReportRsp)paramWeishiTask.a;
      WSLog.b("weishi-report", "report" + this.a + "end: " + paramWeishiTask.code + paramWeishiTask.msg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter.1
 * JD-Core Version:    0.7.0.1
 */