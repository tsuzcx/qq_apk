package com.tencent.biz.webviewbase;

import com.tencent.biz.ui.TouchWebView;
import com.tencent.open.api.WebViewOpenSdkApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.DownloadListener;

class AbsBaseWebViewActivity$3
  implements DownloadListener
{
  AbsBaseWebViewActivity$3(AbsBaseWebViewActivity paramAbsBaseWebViewActivity, TouchWebView paramTouchWebView) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "start UniformDownloadActivity");
    }
    String str = this.a.getUrl();
    WebViewOpenSdkApi.a().a(paramString1, paramString2, paramString3, paramString4, paramLong, this.b, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewbase.AbsBaseWebViewActivity.3
 * JD-Core Version:    0.7.0.1
 */