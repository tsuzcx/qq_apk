package com.tencent.biz.pubaccount.util.api.impl;

import android.net.Uri;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class PublicAccountUtilImpl$13
  implements Runnable
{
  PublicAccountUtilImpl$13(PublicAccountUtilImpl paramPublicAccountUtilImpl, Uri paramUri, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    try
    {
      String str1 = this.jdField_a_of_type_AndroidNetUri.getQueryParameter("article_id");
      int i = this.jdField_a_of_type_Int;
      if (this.jdField_a_of_type_Int == 0) {
        i = 100;
      }
      IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      int j = this.b;
      String str2 = this.jdField_a_of_type_JavaLangString;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(i);
      localIPublicAccountReportUtils.publicAccountReportClickEventForMigrate(null, "dc00899", "Pb_account_lifeservice", "", "0X8006DF8", "0X8006DF8", j, 0, str1, str2, ((StringBuilder)localObject).toString(), "", false);
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      str2 = this.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(this.b);
      localIPublicAccountReportUtils.reportPAinfoToLighthouse("0X8006DF8", "", str1, str2, (String)localObject, localStringBuilder.toString());
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.13
 * JD-Core Version:    0.7.0.1
 */