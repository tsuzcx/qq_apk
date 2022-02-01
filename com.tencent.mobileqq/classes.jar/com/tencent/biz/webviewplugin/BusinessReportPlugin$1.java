package com.tencent.biz.webviewplugin;

import aazx;
import bhod;
import com.tencent.biz.pubaccount.CustomWebView;

public class BusinessReportPlugin$1
  implements Runnable
{
  public BusinessReportPlugin$1(aazx paramaazx, String paramString) {}
  
  public void run()
  {
    String str1 = this.a;
    String str2 = this.this$0.mRuntime.a().getUrl();
    this.this$0.postPluginAsyncTask(new BusinessReportPlugin.1.1(this, str1, str2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.BusinessReportPlugin.1
 * JD-Core Version:    0.7.0.1
 */