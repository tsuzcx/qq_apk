package com.tencent.biz.pubaccount;

import com.tencent.qphone.base.util.QLog;
import oju;
import uqm;

public class PublicAccountBrowser$PublicAccountBrowserFragment$5
  implements Runnable
{
  public PublicAccountBrowser$PublicAccountBrowserFragment$5(oju paramoju) {}
  
  public void run()
  {
    try
    {
      boolean bool = uqm.a(this.this$0.mApp, false, this.this$0.mUrl);
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