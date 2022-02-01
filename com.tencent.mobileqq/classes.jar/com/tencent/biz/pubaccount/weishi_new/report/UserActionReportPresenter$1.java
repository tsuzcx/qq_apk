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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("report ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" start...");
    WSLog.b("weishi-report", localStringBuilder.toString());
    if ((paramWeishiTask != null) && (paramWeishiTask.a != null) && ((paramWeishiTask.a instanceof stWeishiReportRsp)))
    {
      paramWeishiTask = (stWeishiReportRsp)paramWeishiTask.a;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("report");
      localStringBuilder.append(this.a);
      localStringBuilder.append("end: ");
      localStringBuilder.append(paramWeishiTask.code);
      localStringBuilder.append(paramWeishiTask.msg);
      WSLog.b("weishi-report", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.UserActionReportPresenter.1
 * JD-Core Version:    0.7.0.1
 */