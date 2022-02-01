package com.tencent.biz.webviewbase;

import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.open.temp.api.IWebViewOpenSdkApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.DownloadListener;

class AbsBaseWebViewActivity$4
  implements DownloadListener
{
  AbsBaseWebViewActivity$4(AbsBaseWebViewActivity paramAbsBaseWebViewActivity, TouchWebView paramTouchWebView) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewBase", 2, "start UniformDownloadActivity");
    }
    String str = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getUrl();
    ((IWebViewOpenSdkApi)QRoute.api(IWebViewOpenSdkApi.class)).downloadUrlByUniformDownload(paramString1, paramString2, paramString3, paramString4, paramLong, this.jdField_a_of_type_ComTencentBizWebviewbaseAbsBaseWebViewActivity, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewbase.AbsBaseWebViewActivity.4
 * JD-Core Version:    0.7.0.1
 */