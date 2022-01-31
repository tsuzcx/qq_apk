import android.graphics.Bitmap;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.webview.sonic.SonicClientImpl;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.WebViewWrapper.WebViewClientImpl.2;
import com.tencent.mobileqq.webview.swift.WebViewWrapper.WebViewClientImpl.3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

public class beda
  extends WebViewClient
{
  ArrayMap<String, Object> a;
  
  beda(becv parambecv) {}
  
  WebResourceResponse a(WebView paramWebView, String paramString)
  {
    return a(paramWebView, paramString, "", false);
  }
  
  WebResourceResponse a(WebView paramWebView, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (TextUtils.isEmpty(paramString1)) {}
    WebViewPluginEngine localWebViewPluginEngine;
    do
    {
      return localObject1;
      if (paramString1.startsWith("mqqpa://resourceid/")) {
        return sxe.a(paramString1);
      }
      localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
    } while (localWebViewPluginEngine == null);
    String str;
    if (paramString1.startsWith("https://jsbridge/"))
    {
      str = paramString1.replace("https://jsbridge/", "jsbridge://");
      if (QLog.isColorLevel())
      {
        if ((!str.startsWith("jsbridge://")) || (str.length() <= 512)) {
          break label231;
        }
        QLog.i("WebLog_WebViewWrapper", 2, "doInterceptRequest:" + str.substring(0, 512));
      }
    }
    for (;;)
    {
      if ((this.b.jdField_a_of_type_ComTencentBizUiTouchWebView != null) && (paramString2.equalsIgnoreCase("post")) && (paramBoolean)) {
        ThreadManagerV2.getUIHandlerV2().post(new WebViewWrapper.WebViewClientImpl.2(this, localWebViewPluginEngine, str));
      }
      if ((!str.startsWith("jsbridge:")) || (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
        break label257;
      }
      ThreadManagerV2.getUIHandlerV2().post(new WebViewWrapper.WebViewClientImpl.3(this, localWebViewPluginEngine, str));
      return befr.a();
      str = paramString1;
      if (!paramString1.startsWith("http://jsbridge/")) {
        break;
      }
      str = paramString1.replace("http://jsbridge/", "jsbridge://");
      break;
      label231:
      QLog.i("WebLog_WebViewWrapper", 2, "doInterceptRequest:" + str);
    }
    for (;;)
    {
      try
      {
        label257:
        if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)
        {
          paramWebView = this.b.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.requestResource(str);
          if (!(paramWebView instanceof WebResourceResponse)) {
            break label412;
          }
          paramWebView = (WebResourceResponse)paramWebView;
        }
      }
      catch (Exception paramString1)
      {
        label332:
        paramWebView = localObject2;
        label343:
        QLog.e("WebLog_WebViewWrapper", 1, "shouldInterceptRequest:intercept by sonic error -> " + paramString1.getMessage());
        continue;
      }
      for (;;)
      {
        try
        {
          QLog.i("WebLog_WebViewWrapper", 1, "doInterceptRequest:intercept by sonic.");
          localObject1 = paramWebView;
          if (paramWebView != null) {
            break;
          }
        }
        catch (Exception paramString1)
        {
          break label343;
          break label332;
        }
        try
        {
          paramString1 = localWebViewPluginEngine.a(str, 8L);
          if (!(paramString1 instanceof WebResourceResponse)) {
            continue;
          }
          paramString1 = (WebResourceResponse)paramString1;
          paramWebView = paramString1;
          return paramWebView;
        }
        catch (Exception paramString1)
        {
          QLog.e("WebLog_WebViewWrapper", 1, "shouldInterceptRequest error:" + paramString1.getMessage());
          return paramWebView;
        }
      }
      paramWebView = null;
      continue;
      label412:
      paramWebView = null;
    }
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    QLog.i("WebLog_WebViewWrapper", 1, "onDetectedBlankScreen, status: " + paramInt + ", url:" + paramString);
    if (this.b.jdField_a_of_type_Beby != null) {
      this.b.jdField_a_of_type_Beby.c(paramString, paramInt);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if ((this.b.a()) || (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return;
    }
    QLog.d("WebLog_WebViewWrapper", 1, "onPageFinished:" + paramString);
    super.onPageFinished(paramWebView, paramString);
    if (this.b.jdField_a_of_type_Beby != null) {
      this.b.jdField_a_of_type_Beby.a(paramWebView, paramString);
    }
    paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
    if (paramWebView != null) {
      paramWebView.a(paramString, 8589934594L, null);
    }
    if (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() != null) {}
    try
    {
      paramWebView = new Bundle();
      paramWebView.putString("input-box-num", "");
      paramString = new bedb(this);
      this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension().getFakeLoginStatus(paramWebView, paramString);
      aekj.b(this.b.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Throwable paramWebView)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("WebLog_WebViewWrapper", 2, "onFakeLoginRecognised e:", paramWebView);
        }
      }
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((this.b.a()) || (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {}
    for (;;)
    {
      return;
      QLog.d("WebLog_WebViewWrapper", 1, "onPageStarted:" + paramString);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if (this.b.jdField_a_of_type_Beby != null)
      {
        this.b.jdField_a_of_type_Beby.a(paramWebView, paramString, paramBitmap);
        this.b.jdField_a_of_type_Beby.b(paramWebView, paramString, paramBitmap);
      }
      paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
      if (paramWebView != null) {
        paramWebView.a(paramString, 8589934593L, null);
      }
      try
      {
        if (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() != null)
        {
          paramWebView = new Bundle();
          paramWebView.putStringArrayList("recognised-text", bees.a());
          this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension().setFakeLoginParams(paramWebView);
          if (QLog.isColorLevel())
          {
            QLog.d("WebLog_WebViewWrapper", 2, "initWebviewExtension success");
            return;
          }
        }
      }
      catch (Throwable paramWebView) {}
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((this.b.a()) || (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {}
    do
    {
      return;
      QLog.e("WebLog_WebViewWrapper", 1, "onReceivedError:" + paramInt + ", desc=" + paramString1 + ", url=" + paramString2);
      if (this.b.jdField_a_of_type_Beby != null) {
        this.b.jdField_a_of_type_Beby.a(paramWebView, paramInt, paramString1, paramString2);
      }
      paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
    } while (paramWebView == null);
    paramWebView.a(paramString2, 8589934595L, paramInt);
  }
  
  public void onReceivedHttpError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceResponse paramWebResourceResponse)
  {
    if ((paramWebView != null) && (paramWebResourceRequest != null) && (paramWebResourceResponse != null))
    {
      QLog.e("WebLog_WebViewWrapper", 1, "onReceivedHttpError:" + paramWebResourceRequest.getUrl() + "Occur error, resp code=" + paramWebResourceResponse.getStatusCode());
      String str = paramWebView.getUrl();
      if ((str != null) && (myl.a().a(str)))
      {
        paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
        if (paramWebView != null)
        {
          if (this.a == null) {
            this.a = new ArrayMap(4);
          }
          this.a.put("requestData", paramWebResourceRequest);
          this.a.put("responseData", paramWebResourceResponse);
          this.a.put("errorCode", Integer.valueOf(paramWebResourceResponse.getStatusCode()));
          paramWebView.a(str, 64L, this.a);
          paramWebView.a(str, 8589934612L, this.a);
        }
      }
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if ((this.b.a()) || (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return;
    }
    Object localObject = paramSslError.getCertificate();
    String str = paramWebView.getUrl();
    StringBuilder localStringBuilder = new StringBuilder().append("onReceivedSslError:").append(paramSslError.getPrimaryError()).append(", cert=");
    if (localObject == null) {}
    for (localObject = "null";; localObject = ((SslCertificate)localObject).toString())
    {
      QLog.e("WebLog_WebViewWrapper", 1, (String)localObject + ", pageUrl=" + ndq.b(str, new String[0]));
      if (this.b.jdField_a_of_type_Beby != null) {
        this.b.jdField_a_of_type_Beby.a(paramWebView, paramSslError);
      }
      paramSslErrorHandler.cancel();
      return;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null) || (this.b.a()))
    {
      QLog.e("WebLog_WebViewWrapper", 1, "call shouldOverrideUrlLoading after destroy.");
      return true;
    }
    if ((TextUtils.isEmpty(paramString)) || ("about:blank;".equals(paramString)) || ("about:blank".equals(paramString)))
    {
      QLog.e("WebLog_WebViewWrapper", 1, new Object[] { new StringBuilder("shouldOverrideUrlLoading fail , url=[").append(paramString).append("].") });
      return true;
    }
    String str;
    if (paramString.startsWith("https://jsbridge/"))
    {
      str = paramString.replace("https://jsbridge/", "jsbridge://");
      if (QLog.isColorLevel())
      {
        if ((!str.startsWith("jsbridge://")) || (str.length() <= 512)) {
          break label261;
        }
        QLog.d("WebLog_WebViewWrapper", 2, "shouldOverrideUrlLoading:" + str.substring(0, 512));
      }
    }
    for (;;)
    {
      aekj.b(this.b.jdField_a_of_type_AndroidContentIntent, str);
      paramString = befr.b(str);
      if ((this.b.jdField_a_of_type_Beby == null) || (!this.b.jdField_a_of_type_Beby.c(this.b.jdField_a_of_type_ComTencentBizUiTouchWebView, str))) {
        break label298;
      }
      QLog.d("WebLog_WebViewWrapper", 1, "shouldOverrideUrlLoading callback handle override url");
      return true;
      str = paramString;
      if (!paramString.startsWith("http://jsbridge/")) {
        break;
      }
      str = paramString.replace("http://jsbridge/", "jsbridge://");
      break;
      label261:
      QLog.d("WebLog_WebViewWrapper", 2, "shouldOverrideUrlLoading:" + ndq.b(str, new String[0]));
    }
    label298:
    if ((("http".equals(paramString)) || ("data".equals(paramString))) && (!str.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      CustomWebView.addContextLog(ndq.b(str, new String[0]));
    }
    try
    {
      WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
      if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.a(str, 1024L, null)))
      {
        QLog.i("WebLog_WebViewWrapper", 1, "KEY_EVENT_OVERRIDE_URL_LOADING");
        return true;
      }
      if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.a(str))) {
        return true;
      }
      if ((this.b.jdField_a_of_type_Beby != null) && (this.b.jdField_a_of_type_Beby.b(paramWebView, str))) {
        return true;
      }
      if (("http".equals(paramString)) || ("https".equals(paramString)) || ("data".equals(paramString)) || ("file".equals(paramString)))
      {
        if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.a(str, 16L, null))) {
          return true;
        }
      }
      else if (this.b.jdField_a_of_type_Beby != null)
      {
        boolean bool = this.b.jdField_a_of_type_Beby.a(this.b.jdField_a_of_type_ComTencentBizUiTouchWebView, str);
        if (bool) {
          return true;
        }
      }
    }
    catch (RuntimeException paramWebView)
    {
      paramString = QLog.getStackTraceString(paramWebView);
      if (paramString.length() > 255) {}
      for (paramWebView = paramString.substring(0, 255);; paramWebView = paramString)
      {
        azmj.b(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, paramWebView, "", "", "");
        QLog.e("WebLog_WebViewWrapper", 1, paramString);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beda
 * JD-Core Version:    0.7.0.1
 */