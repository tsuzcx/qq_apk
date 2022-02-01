package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.kandian.biz.daily.api.IKanDianDailyReportUtils;
import com.tencent.mobileqq.kandian.biz.reddot.api.IKanDianSubscribeReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class PublicAccountUtilImpl$17
  implements Runnable
{
  PublicAccountUtilImpl$17(PublicAccountUtilImpl paramPublicAccountUtilImpl, String paramString) {}
  
  public void run()
  {
    if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(this.a))
    {
      ((IKanDianSubscribeReportUtils)QRoute.api(IKanDianSubscribeReportUtils.class)).reportPushRedDotExposure();
      return;
    }
    if (AppConstants.KANDIAN_DAILY_UIN.equals(this.a))
    {
      ((IKanDianDailyReportUtils)QRoute.api(IKanDianDailyReportUtils.class)).reportPushRedDotExposure();
      return;
    }
    PublicAccountUtilImpl.access$700(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.17
 * JD-Core Version:    0.7.0.1
 */