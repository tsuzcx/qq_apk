package com.tencent.biz.pubaccount.Advertisement.fragment;

import android.os.Bundle;
import android.widget.FrameLayout;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.webview.swift.SwiftBrowserUIStyle;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.qphone.base.util.QLog;

class WebpageFragment$1
  extends WebKernelCallBackProxy
{
  WebpageFragment$1(WebpageFragment paramWebpageFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onShowPreview(Bundle paramBundle)
  {
    if (this.a.getUIStyleHandler().c) {
      return;
    }
    Util.a("Web_qqbrowser_ShowPreview");
    long l = System.nanoTime();
    this.a.getUIStyleHandler().a(WebpageFragment.a(this.a));
    this.a.getUIStyle().c = 0L;
    this.a.contentView.a(this.a.getUIStyleHandler().jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftBrowserUIStyle.D);
    this.a.getWebTitleBarInterface().c(true);
    this.a.getWebTitleBarInterface().a(false);
    this.a.getWebTitleBarInterface().b(false);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("init view 1, cost = ");
      paramBundle.append((System.nanoTime() - l) / 1000000L);
      QLog.d("WebpageFragment", 2, paramBundle.toString());
    }
    this.a.getUIStyleHandler().c = true;
    this.a.getUIStyleHandler().jdField_a_of_type_AndroidWidgetProgressBar = this.a.contentView.jdField_a_of_type_AndroidWidgetProgressBar;
    this.a.contentView.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.a.getUIStyleHandler().a(WebpageFragment.a(this.a));
    this.a.getUIStyleHandler().b = false;
    Util.b("Web_qqbrowser_ShowPreview");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.WebpageFragment.1
 * JD-Core Version:    0.7.0.1
 */