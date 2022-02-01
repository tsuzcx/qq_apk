package com.tencent.mobileqq.activity.aio.confess;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

class ConfessHalfScreenActivity$ConfessBrowserFragment$2
  extends WebKernelCallBackProxy
{
  ConfessHalfScreenActivity$ConfessBrowserFragment$2(ConfessHalfScreenActivity.ConfessBrowserFragment paramConfessBrowserFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public void onFinalState(Bundle paramBundle)
  {
    super.onFinalState(paramBundle);
    this.a.getSwiftTitleUI().e(false);
    this.a.getUIStyleHandler().v.setVisibility(8);
  }
  
  public void onInitUIContent(Bundle paramBundle)
  {
    this.a.getUIStyle().e = 0L;
    super.onInitUIContent(paramBundle);
    this.a.getActivity().getWindow().setBackgroundDrawableResource(2131168376);
    if ((this.a.getUIStyleHandler().u instanceof RefreshView)) {
      ((RefreshView)this.a.getUIStyleHandler().u).a(false);
    }
    if (this.a.getUIStyleHandler().D != null) {
      this.a.getUIStyleHandler().D.setVisibility(8);
    }
    this.a.contentView.setBackgroundColor(0);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "ConfessBrowserFragment onReceivedError = ");
    }
    ConfessHalfScreenActivity.ConfessBrowserFragment.a(this.a, true);
    if (this.a.getActivity() != null) {
      this.a.getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity.ConfessBrowserFragment.2
 * JD-Core Version:    0.7.0.1
 */