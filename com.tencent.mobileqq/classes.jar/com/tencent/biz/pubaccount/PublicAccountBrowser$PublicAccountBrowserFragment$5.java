package com.tencent.biz.pubaccount;

import com.tencent.qphone.base.util.QLog;
import suk;

class PublicAccountBrowser$PublicAccountBrowserFragment$5
  implements Runnable
{
  PublicAccountBrowser$PublicAccountBrowserFragment$5(PublicAccountBrowser.PublicAccountBrowserFragment paramPublicAccountBrowserFragment) {}
  
  public void run()
  {
    try
    {
      boolean bool = suk.a(this.this$0.a, false, this.this$0.g);
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