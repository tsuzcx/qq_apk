package com.tencent.mobileqq.activity;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.smtt.sdk.WebView;

class QQVasH5PayBrowserActivity$QQVasH5PayBrowserFragment$1
  extends WebKernelCallBackProxy
{
  QQVasH5PayBrowserActivity$QQVasH5PayBrowserFragment$1(QQVasH5PayBrowserActivity.QQVasH5PayBrowserFragment paramQQVasH5PayBrowserFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    QQVasH5PayBrowserActivity.QQVasH5PayBrowserFragment.a(this.a).setVisibility(0);
  }
  
  public void onInitUIContent(Bundle paramBundle)
  {
    super.onInitUIContent(paramBundle);
    QQVasH5PayBrowserActivity.QQVasH5PayBrowserFragment.b(this.a);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    QRUtils.a(1, 2131892944);
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQVasH5PayBrowserActivity.QQVasH5PayBrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */