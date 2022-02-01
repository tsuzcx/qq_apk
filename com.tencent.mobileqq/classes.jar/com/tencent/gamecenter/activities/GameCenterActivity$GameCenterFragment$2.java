package com.tencent.gamecenter.activities;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.gamecenter.common.util.ScreenshotManager;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.smtt.sdk.WebView;

class GameCenterActivity$GameCenterFragment$2
  extends WebKernelCallBackProxy
{
  GameCenterActivity$GameCenterFragment$2(GameCenterActivity.GameCenterFragment paramGameCenterFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public String getUAMark()
  {
    return "gamecenter";
  }
  
  public boolean interceptStartLoadUrl()
  {
    return this.a.a(this.webViewKernelCallBack);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if ((this.a.g) && (!this.a.isDestroyed()))
    {
      if ((GameCenterActivity.GameCenterFragment.b(this.a) != null) && (GameCenterActivity.GameCenterFragment.c(this.a).canGoBack()) && (this.a.getSwiftTitleUI().d != null)) {
        this.a.getSwiftTitleUI().d.setText(2131887440);
      } else {
        this.a.getSwiftTitleUI().a(GameCenterActivity.GameCenterFragment.d(this.a));
      }
      this.a.a(paramString);
      this.a.g = false;
    }
    if ((!TextUtils.isEmpty(paramString)) && (GameCenterActivity.GameCenterFragment.a(this.a, paramString)) && (ScreenshotManager.a().d()))
    {
      ScreenshotManager.a().a(paramWebView, new GameCenterActivity.GameCenterFragment.2.1(this));
      ScreenshotManager.a().c();
    }
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((!GameCenterActivity.GameCenterFragment.a(this.a)) && (!TextUtils.isEmpty(paramString)) && (GameCenterActivity.GameCenterFragment.a(this.a, paramString)))
    {
      GameCenterActivity.GameCenterFragment.e = System.currentTimeMillis();
      GameCenterActivity.GameCenterFragment.a(this.a, paramWebView);
    }
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.activities.GameCenterActivity.GameCenterFragment.2
 * JD-Core Version:    0.7.0.1
 */