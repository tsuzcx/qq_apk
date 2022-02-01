import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.webview.AbsWebView.WebViewClientImpl.1;
import com.tencent.mobileqq.webview.AbsWebView.WebViewClientImpl.2;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebView.HitTestResult;
import com.tencent.smtt.sdk.WebViewClient;

public class bimm
  extends WebViewClient
{
  private bimm(bimg parambimg) {}
  
  protected WebResourceResponse a(WebView paramWebView, String paramString)
  {
    Object localObject2 = null;
    WebViewPluginEngine localWebViewPluginEngine = ((CustomWebView)paramWebView).getPluginEngine();
    if (localWebViewPluginEngine == null) {
      return null;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "doInterceptRequest url = " + paramString);
    }
    String str1;
    if (!TextUtils.isEmpty(paramString)) {
      if (paramString.startsWith("https://jsbridge/"))
      {
        str1 = paramString.replace("https://jsbridge/", "jsbridge://");
        str2 = str1;
        if (QLog.isColorLevel()) {
          QLog.d("AbsWebView", 2, "doInterceptRequest  https://jsbridge/ temp url = " + str1);
        }
      }
    }
    for (String str2 = str1;; str2 = null)
    {
      if ((!TextUtils.isEmpty(str2)) && (this.b.mWebview != null))
      {
        ThreadManagerV2.getUIHandlerV2().post(new AbsWebView.WebViewClientImpl.1(this, localWebViewPluginEngine, str2));
        return new WebResourceResponse("text/html", "utf-8", null);
        if (!paramString.startsWith("http://jsbridge/")) {
          break label341;
        }
        str1 = paramString.replace("http://jsbridge/", "jsbridge://");
        break;
      }
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("jsbridge")) && (this.b.mWebview != null)) {
        ThreadManagerV2.getUIHandlerV2().post(new AbsWebView.WebViewClientImpl.2(this, localWebViewPluginEngine, paramString));
      }
      try
      {
        paramWebView = this.b.doInterceptRequest(paramWebView, paramString);
        if ((paramWebView instanceof WebResourceResponse)) {
          paramWebView = (WebResourceResponse)paramWebView;
        }
        Object localObject1 = null;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            QLog.i("AbsWebView", 1, "doInterceptRequest: resource intercept by sonic.");
            if (paramWebView != null) {
              continue;
            }
          }
          catch (Exception localException2)
          {
            continue;
          }
          try
          {
            paramString = (WebResourceResponse)localWebViewPluginEngine.a(paramString, 8L);
            paramWebView = paramString;
            return paramWebView;
          }
          catch (Exception paramString)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("AbsWebView", 2, "shouldInterceptRequest got exception!", paramString);
          }
          localException1 = localException1;
          paramWebView = localObject2;
          QLog.e("AbsWebView", 1, "shouldInterceptRequest:resource intercept by sonic error -> " + localException1.getMessage());
          continue;
          continue;
          paramWebView = null;
        }
      }
      label341:
      break;
    }
  }
  
  public void onDetectedBlankScreen(String paramString, int paramInt)
  {
    QLog.i("AbsWebView", 1, "onDetectedBlankScreen, status: " + paramInt + ", url:" + paramString);
    this.b.mStateReporter.a(this.b.mInterface, paramString, paramInt);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "onPageFinished:" + paramString);
    }
    if (this.b.mProgressBarController != null) {
      this.b.mProgressBarController.a((byte)2);
    }
    super.onPageFinished(paramWebView, paramString);
    this.b.onPageFinished(paramWebView, paramString);
    paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
    if (paramWebView != null) {
      paramWebView.a(paramString, 8589934594L, null);
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "onPageStarted:" + paramString);
    }
    if (!"about:blank".equalsIgnoreCase(paramString)) {
      this.b.mStateReporter.a(2);
    }
    if ((!this.b.mIsFirstOnPageStart) && (this.b.mProgressBarController != null) && (this.b.mProgressBarController.b() != 0)) {
      this.b.mProgressBarController.a((byte)0);
    }
    if (this.b.mIsFirstOnPageStart)
    {
      this.b.mIsFirstOnPageStart = false;
      this.b.mStartLoadUrlMilliTimeStamp = System.currentTimeMillis();
    }
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.b.onPageStarted(paramWebView, paramString, paramBitmap);
    paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
    if (paramWebView != null) {
      paramWebView.a(paramString, 8589934593L, null);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "onReceivedError:" + paramInt + ", desc=" + paramString1 + ", url=" + paramString2);
    }
    this.b.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    paramWebView = ((CustomWebView)paramWebView).getPluginEngine();
    if (paramWebView != null) {
      paramWebView.a(paramString2, 8589934595L, paramInt);
    }
  }
  
  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    SslCertificate localSslCertificate = paramSslError.getCertificate();
    String str = paramWebView.getUrl();
    paramSslError = new StringBuilder().append("onReceivedSslError:").append(paramSslError.getPrimaryError()).append(", cert=");
    if (localSslCertificate == null) {}
    for (paramWebView = "null";; paramWebView = localSslCertificate.toString())
    {
      QLog.w("AbsWebView", 1, paramWebView + ", pageUrl=" + noe.b(str, new String[0]));
      paramSslErrorHandler.cancel();
      return;
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsWebView", 2, "shouldOverrideUrlLoading " + noe.b(paramString, new String[0]));
    }
    if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
    {
      this.b.mPerfFirstLoadTag = false;
      this.b.mTimeBeforeLoadUrl = System.currentTimeMillis();
    }
    if ((TextUtils.isEmpty(paramString)) || ("about:blank;".equals(paramString)) || ("about:blank".equals(paramString))) {
      return true;
    }
    if (((paramString.startsWith("http")) || (paramString.startsWith("data:"))) && (!paramString.contains("/cgi-bin/httpconn?htcmd=0x6ff0080"))) {
      CustomWebView.addContextLog(noe.b(paramString, new String[0]));
    }
    try
    {
      if ((paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        localObject = paramWebView.getHitTestResult();
        if ((localObject != null) && (((WebView.HitTestResult)localObject).getType() == 0))
        {
          if (QLog.isColorLevel()) {
            QLog.i("AbsWebView", 2, "shouldOverrideUrlLoading detect 302 url: " + paramString);
          }
          this.b.mRedirect302Time = System.currentTimeMillis();
          this.b.mRedirect302Url = paramString;
          SwiftBrowserCookieMonster.d();
        }
      }
      Object localObject = ((CustomWebView)paramWebView).getPluginEngine();
      if ((localObject != null) && (((WebViewPluginEngine)localObject).a(paramString))) {
        return true;
      }
      if (this.b.shouldOverrideUrlLoading(paramWebView, paramString)) {
        return true;
      }
      if ((paramString.startsWith("file://")) || (paramString.startsWith("data:")) || (paramString.startsWith("http://")) || (paramString.startsWith("https://")))
      {
        if ((localObject == null) || (!((WebViewPluginEngine)localObject).a(paramString, 16L, null))) {
          break label453;
        }
        return true;
      }
      if (paramString.startsWith("tnow://openpage/recordstory"))
      {
        paramWebView = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
        paramWebView.setFlags(268435456);
        this.b.mContext.startActivity(paramWebView);
      }
    }
    catch (RuntimeException paramWebView)
    {
      paramString = QLog.getStackTraceString(paramWebView);
      if (paramString.length() <= 255) {
        break label448;
      }
      for (paramWebView = paramString.substring(0, 255);; paramWebView = paramString)
      {
        bdll.b(null, "P_CliOper", "BizTechReport", "", "webview", "exception", 0, 1, 0, paramWebView, "", "", "");
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.e("AbsWebView", 2, paramString);
        break;
      }
    }
    return true;
    label448:
    label453:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bimm
 * JD-Core Version:    0.7.0.1
 */