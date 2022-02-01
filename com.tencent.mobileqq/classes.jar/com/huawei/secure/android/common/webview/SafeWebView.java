package com.huawei.secure.android.common.webview;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.secure.android.common.util.LogsUtil;
import com.tencent.qqlive.module.videoreport.inject.webview.dtwebview.DtWebView;
import java.util.Arrays;
import java.util.Map;

public class SafeWebView
  extends DtWebView
{
  private static final String TAG = "SafeWebView";
  private String I;
  private String[] J;
  private String[] K;
  private String[] L;
  private WebViewLoadCallBack M;
  
  public SafeWebView(Context paramContext)
  {
    super(paramContext);
    h();
  }
  
  public SafeWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    h();
  }
  
  public SafeWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    h();
  }
  
  @TargetApi(21)
  public SafeWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    h();
  }
  
  private void h()
  {
    SafeWebSettings.initWebviewAndSettings(this);
    setWebViewClient(null);
  }
  
  private boolean isHttpUrl(String paramString)
  {
    return URLUtil.isHttpUrl(paramString);
  }
  
  public String getDefaultErrorPage()
  {
    return this.I;
  }
  
  public WebViewLoadCallBack getWebViewLoadCallBack()
  {
    return this.M;
  }
  
  @Deprecated
  @TargetApi(9)
  public String[] getWhitelist()
  {
    String[] arrayOfString = this.J;
    if (arrayOfString == null) {
      return null;
    }
    return (String[])Arrays.copyOf(arrayOfString, arrayOfString.length);
  }
  
  @Deprecated
  public String[] getWhitelistNotMathcSubDomain()
  {
    String[] arrayOfString = this.K;
    if (arrayOfString == null) {
      return null;
    }
    return (String[])Arrays.copyOf(arrayOfString, arrayOfString.length);
  }
  
  @TargetApi(9)
  public String[] getWhitelistWithPath()
  {
    String[] arrayOfString = this.L;
    if (arrayOfString == null) {
      return null;
    }
    return (String[])Arrays.copyOf(arrayOfString, arrayOfString.length);
  }
  
  @TargetApi(9)
  public boolean isWhiteListUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      LogsUtil.e("SafeWebView", "url is null");
      return false;
    }
    if (!URLUtil.isNetworkUrl(paramString)) {
      return true;
    }
    String[] arrayOfString1 = getWhitelistWithPath();
    String[] arrayOfString2 = getWhitelistNotMathcSubDomain();
    String[] arrayOfString3 = getWhitelist();
    if ((arrayOfString1 != null) && (arrayOfString1.length != 0)) {
      return UriUtil.isUrlHostAndPathInWhitelist(paramString, arrayOfString1);
    }
    if ((arrayOfString2 != null) && (arrayOfString2.length != 0)) {
      return UriUtil.isUrlHostSameWhitelist(paramString, arrayOfString2);
    }
    return UriUtil.isUrlHostInWhitelist(paramString, arrayOfString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (isHttpUrl(paramString1))
    {
      Log.e("SafeWebView", "loadDataWithBaseURL: http url , not safe");
      if (!TextUtils.isEmpty(this.I))
      {
        super.loadDataWithBaseURL(this.I, paramString2, paramString3, paramString4, paramString5);
        return;
      }
      if (getWebViewLoadCallBack() != null)
      {
        Log.e("SafeWebView", "WebViewLoadCallBack");
        getWebViewLoadCallBack().onCheckError(paramString1, WebViewLoadCallBack.ErrorCode.HTTP_URL);
      }
      return;
    }
    super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    if (isHttpUrl(paramString))
    {
      Log.e("SafeWebView", "loadUrl: http url , not safe");
      if (!TextUtils.isEmpty(this.I))
      {
        super.loadUrl(this.I);
        return;
      }
      if (getWebViewLoadCallBack() != null)
      {
        Log.e("SafeWebView", "WebViewLoadCallBack");
        getWebViewLoadCallBack().onCheckError(paramString, WebViewLoadCallBack.ErrorCode.HTTP_URL);
      }
      return;
    }
    super.loadUrl(paramString);
  }
  
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    if (isHttpUrl(paramString))
    {
      Log.e("SafeWebView", "loadUrl: http url , not safe");
      if (!TextUtils.isEmpty(this.I))
      {
        super.loadUrl(this.I, paramMap);
        return;
      }
      if (getWebViewLoadCallBack() != null)
      {
        Log.e("SafeWebView", "WebViewLoadCallBack");
        getWebViewLoadCallBack().onCheckError(paramString, WebViewLoadCallBack.ErrorCode.HTTP_URL);
      }
      return;
    }
    super.loadUrl(paramString, paramMap);
  }
  
  public final void onCheckError(WebView paramWebView, String paramString)
  {
    LogsUtil.e("SafeWebView", "onCheckError url is not in white list ", paramString);
    paramWebView.stopLoading();
    String str = getDefaultErrorPage();
    if (!TextUtils.isEmpty(str))
    {
      paramWebView.loadUrl(str);
      return;
    }
    if (getWebViewLoadCallBack() != null)
    {
      Log.e("SafeWebView", "onPageStarted WebViewLoadCallBack");
      getWebViewLoadCallBack().onCheckError(paramString, WebViewLoadCallBack.ErrorCode.URL_NOT_IN_WHITE_LIST);
    }
  }
  
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    if (isHttpUrl(paramString))
    {
      Log.e("SafeWebView", "postUrl: http url , not safe");
      if (!TextUtils.isEmpty(this.I))
      {
        super.postUrl(this.I, paramArrayOfByte);
        return;
      }
      if (getWebViewLoadCallBack() != null)
      {
        Log.e("SafeWebView", "WebViewLoadCallBack");
        getWebViewLoadCallBack().onCheckError(paramString, WebViewLoadCallBack.ErrorCode.HTTP_URL);
      }
      return;
    }
    super.postUrl(paramString, paramArrayOfByte);
  }
  
  public void setDefaultErrorPage(String paramString)
  {
    this.I = paramString;
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    super.setWebViewClient(new SafeWebView.c(this, paramWebViewClient, true, null));
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient, boolean paramBoolean)
  {
    super.setWebViewClient(new SafeWebView.c(this, paramWebViewClient, paramBoolean, null));
  }
  
  public void setWebViewLoadCallBack(WebViewLoadCallBack paramWebViewLoadCallBack)
  {
    this.M = paramWebViewLoadCallBack;
  }
  
  @Deprecated
  @TargetApi(9)
  public void setWhitelist(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      paramArrayOfString = null;
    } else {
      paramArrayOfString = (String[])Arrays.copyOf(paramArrayOfString, paramArrayOfString.length);
    }
    this.J = paramArrayOfString;
  }
  
  @Deprecated
  public void setWhitelistNotMathcSubDomain(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      paramArrayOfString = null;
    } else {
      paramArrayOfString = (String[])Arrays.copyOf(paramArrayOfString, paramArrayOfString.length);
    }
    this.K = paramArrayOfString;
  }
  
  @TargetApi(9)
  public void setWhitelistWithPath(String[] paramArrayOfString)
  {
    if (paramArrayOfString == null) {
      paramArrayOfString = null;
    } else {
      paramArrayOfString = (String[])Arrays.copyOf(paramArrayOfString, paramArrayOfString.length);
    }
    this.L = paramArrayOfString;
  }
  
  protected final void showNoticeWhenSSLErrorOccurred(String paramString1, String paramString2, String paramString3, String paramString4, SslErrorHandler paramSslErrorHandler)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(getContext());
    if (!TextUtils.isEmpty(paramString1)) {
      localBuilder.setTitle(paramString1);
    }
    paramString1 = new SafeWebView.b(paramSslErrorHandler);
    paramSslErrorHandler = new SafeWebView.a(paramSslErrorHandler);
    localBuilder.setMessage(paramString2);
    localBuilder.setPositiveButton(paramString3, paramString1);
    localBuilder.setNegativeButton(paramString4, paramSslErrorHandler);
    localBuilder.create().show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.webview.SafeWebView
 * JD-Core Version:    0.7.0.1
 */