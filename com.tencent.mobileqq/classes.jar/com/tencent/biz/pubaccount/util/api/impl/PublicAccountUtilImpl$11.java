package com.tencent.biz.pubaccount.util.api.impl;

import android.net.Uri;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class PublicAccountUtilImpl$11
  implements Runnable
{
  PublicAccountUtilImpl$11(PublicAccountUtilImpl paramPublicAccountUtilImpl, Uri paramUri, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      String str = this.a.getQueryParameter("article_id");
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b);
      localStringBuilder.append("");
      localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(null, "dc00899", "Pb_account_lifeservice", "", "0X8006510", "0X8006510", 0, 0, str, localStringBuilder.toString(), this.c, "", false);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.11
 * JD-Core Version:    0.7.0.1
 */