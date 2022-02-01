package com.tencent.biz.pubaccount;

import com.tencent.qphone.base.util.QLog;
import ocd;
import ucp;

public class PublicAccountBrowser$PublicAccountBrowserFragment$5
  implements Runnable
{
  public PublicAccountBrowser$PublicAccountBrowserFragment$5(ocd paramocd) {}
  
  public void run()
  {
    try
    {
      boolean bool = ucp.a(this.this$0.mApp, false, this.this$0.mUrl);
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment", 2, "set subscribe full recommend switch = false , result : " + bool);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment.5
 * JD-Core Version:    0.7.0.1
 */