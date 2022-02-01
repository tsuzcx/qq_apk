package com.tencent.biz.pubaccount;

import com.tencent.qphone.base.util.QLog;
import nzh;
import tvx;

public class PublicAccountBrowser$PublicAccountBrowserFragment$1$1
  implements Runnable
{
  public PublicAccountBrowser$PublicAccountBrowserFragment$1$1(nzh paramnzh) {}
  
  public void run()
  {
    try
    {
      boolean bool = tvx.a(this.a.a.mApp, false, this.a.a.mUrl);
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
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountBrowser.PublicAccountBrowserFragment.1.1
 * JD-Core Version:    0.7.0.1
 */