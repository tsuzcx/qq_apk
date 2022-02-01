package com.tencent.biz.pubaccount.util.api.impl;

import com.tencent.biz.pubaccount.readinjoy.common.KandianDailyReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.KandianSubscribeReportUtils;
import com.tencent.mobileqq.app.AppConstants;

class PublicAccountUtilImpl$22
  implements Runnable
{
  PublicAccountUtilImpl$22(PublicAccountUtilImpl paramPublicAccountUtilImpl, String paramString) {}
  
  public void run()
  {
    if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(this.a))
    {
      KandianSubscribeReportUtils.a();
      return;
    }
    if (AppConstants.KANDIAN_DAILY_UIN.equals(this.a))
    {
      KandianDailyReportUtils.a();
      return;
    }
    PublicAccountUtilImpl.access$1000(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.22
 * JD-Core Version:    0.7.0.1
 */