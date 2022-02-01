package com.tencent.biz.pubaccount.util.api.impl;

import android.net.Uri;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class PublicAccountUtilImpl$16
  implements Runnable
{
  PublicAccountUtilImpl$16(PublicAccountUtilImpl paramPublicAccountUtilImpl, Uri paramUri, int paramInt1, int paramInt2, String paramString) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        String str = this.jdField_a_of_type_AndroidNetUri.getQueryParameter("article_id");
        int i = this.jdField_a_of_type_Int;
        if (this.jdField_a_of_type_Int == 0)
        {
          i = 100;
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "dc00899", "Pb_account_lifeservice", "", "0X8006DF8", "0X8006DF8", this.b, 0, str, this.jdField_a_of_type_JavaLangString, "" + i, "", false);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X8006DF8", "", str, this.jdField_a_of_type_JavaLangString, "" + i, "" + this.b);
          return;
        }
      }
      catch (Exception localException)
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.16
 * JD-Core Version:    0.7.0.1
 */