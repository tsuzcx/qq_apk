package com.tencent.biz.pubaccount.util.api.impl;

import android.net.Uri;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class PublicAccountUtilImpl$14
  implements Runnable
{
  PublicAccountUtilImpl$14(PublicAccountUtilImpl paramPublicAccountUtilImpl, Uri paramUri, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      String str = this.jdField_a_of_type_AndroidNetUri.getQueryParameter("article_id");
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "dc00899", "Pb_account_lifeservice", "", "0X8006510", "0X8006510", 0, 0, str, this.jdField_a_of_type_Int + "", this.jdField_a_of_type_JavaLangString, "", false);
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.14
 * JD-Core Version:    0.7.0.1
 */