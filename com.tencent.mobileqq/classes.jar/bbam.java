import android.app.Activity;
import android.content.Intent;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.io.ByteArrayInputStream;
import java.util.HashMap;
import java.util.Map;

public class bbam
  extends WebViewClient
{
  ArrayMap<String, Object> a;
  
  bbam(bbah parambbah) {}
  
  WebResourceResponse a(WebView paramWebView, String paramString)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    if (TextUtils.isEmpty(paramString)) {}
    WebViewPluginEngine localWebViewPluginEngine;
    do
    {
      return localObject2;
      try
      {
        if (agvk.a(paramString))
        {
          WebResourceResponse localWebResourceResponse = agvk.a(paramString);
          return localWebResourceResponse;
        }
      }
      catch (Exception localException)
      {
        QLog.e("WebLog_WebViewWrapper", 1, localException, new Object[0]);
        if (paramString.startsWith("mqqpa://resourceid/")) {
          return rsv.a(paramString);
        }
        localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
      }
    } while (localWebViewPluginEngine == null);
    Object localObject1;
    if (paramString.startsWith("https://jsbridge/"))
    {
      localObject1 = paramString.replace("https://jsbridge/", "jsbridge://");
      if (QLog.isColorLevel())
      {
        if ((!((String)localObject1).startsWith("jsbridge://")) || (((String)localObject1).length() <= 512)) {
          break label261;
        }
        QLog.i("WebLog_WebViewWrapper", 2, "doInterceptRequest:" + ((String)localObject1).substring(0, 512));
      }
    }
    for (;;)
    {
      if ((!((String)localObject1).startsWith("jsbridge:")) || (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
        break label286;
      }
      ThreadManagerV2.getUIHandlerV2().post(new WebViewWrapper.WebViewClientImpl.2(this, localWebViewPluginEngine, (String)localObject1));
      localObject1 = new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream(new byte[0]));
      paramString = ((WebResourceResponse)localObject1).getResponseHeaders();
      paramWebView = paramString;
      if (paramString == null) {
        paramWebView = new HashMap();
      }
      paramWebView.put("cache-control", "must-revalidate，no-store");
      ((WebResourceResponse)localObject1).setResponseHeaders(paramWebView);
      return localObject1;
      localObject1 = paramString;
      if (!paramString.startsWith("http://jsbridge/")) {
        break;
      }
      localObject1 = paramString.replace("http://jsbridge/", "jsbridge://");
      break;
      label261:
      QLog.i("WebLog_WebViewWrapper", 2, "doInterceptRequest:" + (String)localObject1);
    }
    for (;;)
    {
      try
      {
        label286:
        if (this.b.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl != null)
        {
          paramWebView = this.b.jdField_a_of_type_ComTencentMobileqqWebviewSonicSonicClientImpl.requestResource((String)localObject1);
          if (!(paramWebView instanceof WebResourceResponse)) {
            break label439;
          }
          paramWebView = (WebResourceResponse)paramWebView;
        }
      }
      catch (Exception paramString)
      {
        label359:
        paramWebView = localObject3;
        label370:
        QLog.e("WebLog_WebViewWrapper", 1, "shouldInterceptRequest:intercept by sonic error -> " + paramString.getMessage());
        continue;
      }
      for (;;)
      {
        try
        {
          QLog.i("WebLog_WebViewWrapper", 1, "doInterceptRequest:intercept by sonic.");
          localObject2 = paramWebView;
          if (paramWebView != null) {
            break;
          }
        }
        catch (Exception paramString)
        {
          break label370;
          break label359;
        }
        try
        {
          paramString = localWebViewPluginEngine.a((String)localObject1, 8L);
          if (!(paramString instanceof WebResourceResponse)) {
            continue;
          }
          paramString = (WebResourceResponse)paramString;
          paramWebView = paramString;
          return paramWebView;
        }
        catch (Exception paramString)
        {
          QLog.e("WebLog_WebViewWrapper", 1, "shouldInterceptRequest error:" + paramString.getMessage());
          return paramWebView;
        }
      }
      paramWebView = null;
      continue;
      label439:
      paramWebView = null;
    }
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    QLog.i("WebLog_WebViewWrapper", 1, "onDetectedBlankScreen, status: " + paramInt + ", url:" + paramString);
    if (this.b.jdField_a_of_type_Bazp != null) {
      this.b.jdField_a_of_type_Bazp.a(paramString, paramInt);
    }
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if ((this.b.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return;
    }
    QLog.d("WebLog_WebViewWrapper", 1, "onPageFinished:" + paramString);
    super.onPageFinished(paramWebView, paramString);
    if (this.b.jdField_a_of_type_Bazp != null) {
      this.b.jdField_a_of_type_Bazp.a(paramWebView, paramString);
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
      paramString = new bban(this);
      this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension().getFakeLoginStatus(paramWebView, paramString);
      try
      {
        paramWebView = this.b.jdField_a_of_type_AndroidAppActivity.getIntent();
        if (paramWebView.hasExtra("key_scroll_y"))
        {
          i = paramWebView.getIntExtra("key_scroll_y", 0);
          if (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() == null) {
            break label263;
          }
          this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension().scrollTo(this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.getWebScrollX(), i);
          paramWebView.removeExtra("key_scroll_y");
        }
      }
      catch (RuntimeException paramWebView)
      {
        for (;;)
        {
          int i;
          QLog.e("WebLog_WebViewWrapper", 1, paramWebView, new Object[0]);
        }
      }
      acio.b(this.b.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    catch (Throwable paramWebView)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("WebLog_WebViewWrapper", 2, "onFakeLoginRecognised e:", paramWebView);
          continue;
          label263:
          this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.scrollTo(this.b.jdField_a_of_type_ComTencentBizUiTouchWebView.getScrollX(), i);
        }
      }
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((this.b.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {}
    for (;;)
    {
      return;
      QLog.d("WebLog_WebViewWrapper", 1, "onPageStarted:" + paramString);
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      if (this.b.jdField_a_of_type_Bazp != null)
      {
        this.b.jdField_a_of_type_Bazp.a(paramWebView, paramString, paramBitmap);
        this.b.jdField_a_of_type_Bazp.b(paramWebView, paramString, paramBitmap);
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
          paramWebView.putStringArrayList("recognised-text", bbcd.a());
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
    if ((this.b.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {}
    do
    {
      return;
      QLog.e("WebLog_WebViewWrapper", 1, "onReceivedError:" + paramInt + ", desc=" + paramString1 + ", url=" + paramString2);
      if (this.b.jdField_a_of_type_Bazp != null) {
        this.b.jdField_a_of_type_Bazp.a(paramWebView, paramInt, paramString1, paramString2);
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
      if ((str != null) && (mkw.a().a(str)))
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
    if ((this.b.jdField_a_of_type_AndroidAppActivity.isFinishing()) || (this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null)) {
      return;
    }
    Object localObject = paramSslError.getCertificate();
    String str = paramWebView.getUrl();
    StringBuilder localStringBuilder = new StringBuilder().append("onReceivedSslError:").append(paramSslError.getPrimaryError()).append(", cert=");
    if (localObject == null) {}
    for (localObject = "null";; localObject = ((SslCertificate)localObject).toString())
    {
      QLog.e("WebLog_WebViewWrapper", 1, (String)localObject + ", pageUrl=" + mpw.b(str, new String[0]));
      if (this.b.jdField_a_of_type_Bazp != null) {
        this.b.jdField_a_of_type_Bazp.a(paramWebView, paramSslError);
      }
      paramSslErrorHandler.cancel();
      return;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((this.b.jdField_a_of_type_ComTencentBizUiTouchWebView == null) || (this.b.jdField_a_of_type_AndroidAppActivity.isFinishing()))
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
          break label264;
        }
        QLog.d("WebLog_WebViewWrapper", 2, "shouldOverrideUrlLoading:" + str.substring(0, 512));
      }
    }
    for (;;)
    {
      acio.b(this.b.jdField_a_of_type_AndroidContentIntent, str);
      paramString = bbdc.a(str);
      if ((this.b.jdField_a_of_type_Bazp == null) || (!this.b.jdField_a_of_type_Bazp.c(this.b.jdField_a_of_type_ComTencentBizUiTouchWebView, str))) {
        break label301;
      }
      QLog.d("WebLog_WebViewWrapper", 1, "shouldOverrideUrlLoading callback handle override url");
      return true;
      str = paramString;
      if (!paramString.startsWith("http://jsbridge/")) {
        break;
      }
      str = paramString.replace("http://jsbridge/", "jsbridge://");
      break;
      label264:
      QLog.d("WebLog_WebViewWrapper", 2, "shouldOverrideUrlLoading:" + mpw.b(str, new String[0]));
    }
    label301:
    if ((("http".equals(paramString)) || ("data".equals(paramString))) && (!str.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      CustomWebView.addContextLog(mpw.b(str, new String[0]));
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
      if ((this.b.jdField_a_of_type_Bazp != null) && (this.b.jdField_a_of_type_Bazp.b(paramWebView, str))) {
        return true;
      }
      if (("http".equals(paramString)) || ("https".equals(paramString)) || ("data".equals(paramString)) || ("file".equals(paramString)))
      {
        if ((localWebViewPluginEngine != null) && (localWebViewPluginEngine.a(str, 16L, null))) {
          return true;
        }
      }
      else if (this.b.jdField_a_of_type_Bazp != null)
      {
        boolean bool = this.b.jdField_a_of_type_Bazp.a(this.b.jdField_a_of_type_ComTencentBizUiTouchWebView, str);
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
        awqx.b(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, paramWebView, "", "", "");
        QLog.e("WebLog_WebViewWrapper", 1, paramString);
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bbam
 * JD-Core Version:    0.7.0.1
 */