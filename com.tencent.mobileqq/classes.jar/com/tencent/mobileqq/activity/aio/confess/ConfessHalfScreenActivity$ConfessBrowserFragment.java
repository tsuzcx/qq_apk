package com.tencent.mobileqq.activity.aio.confess;

import android.os.Bundle;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebViewJumpPlugin;
import com.tencent.qphone.base.util.QLog;

public class ConfessHalfScreenActivity$ConfessBrowserFragment
  extends WebViewFragment
{
  private boolean a;
  private int b;
  
  public SwiftBrowserComponentsProvider createComponentsProvider()
  {
    return new SwiftBrowserComponentsProvider(this, 511, new ConfessHalfScreenActivity.ConfessBrowserFragment.1(this));
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "ConfessBrowserFragment doOnCreate = ");
    }
    boolean bool = super.doOnCreate(paramBundle);
    if ((this.webView != null) && (this.webView.getPluginEngine() != null)) {
      this.webView.getPluginEngine().a(new String[] { "sayHonest", WebViewJumpPlugin.a, "QQApi", "ui", "share", "PublicAccountJs" });
    }
    return bool;
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new ConfessHalfScreenActivity.ConfessBrowserFragment.2(this, this.webViewSurface);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity.ConfessBrowserFragment
 * JD-Core Version:    0.7.0.1
 */