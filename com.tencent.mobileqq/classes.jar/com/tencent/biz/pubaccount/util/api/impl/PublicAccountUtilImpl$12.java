package com.tencent.biz.pubaccount.util.api.impl;

import android.net.Uri;
import com.tencent.mobileqq.statistics.ReportController;

class PublicAccountUtilImpl$12
  implements Runnable
{
  PublicAccountUtilImpl$12(PublicAccountUtilImpl paramPublicAccountUtilImpl, Uri paramUri, String paramString) {}
  
  public void run()
  {
    try
    {
      ReportController.b(null, "dc00899", "Pb_account_lifeservice", "", "0X8006A68", "0X8006A68", 0, 0, this.a.getQueryParameter("article_id"), this.b, "", "");
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.impl.PublicAccountUtilImpl.12
 * JD-Core Version:    0.7.0.1
 */