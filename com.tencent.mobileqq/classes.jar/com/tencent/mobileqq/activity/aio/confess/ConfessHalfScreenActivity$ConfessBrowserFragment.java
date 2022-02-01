package com.tencent.mobileqq.activity.aio.confess;

import afia;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import bgtw;
import bgvt;
import bgzx;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class ConfessHalfScreenActivity$ConfessBrowserFragment
  extends WebViewFragment
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  
  public bgvt createComponentsProvider()
  {
    return new bgvt(this, 127, new afia(this));
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    this.mSwiftTitleUI.setTitleBarVisibility(false);
    this.mUIStyleHandler.mLoadingProgressBar.setVisibility(8);
    return i;
  }
  
  public int doCreateLoopStep_InitUIContent(Bundle paramBundle)
  {
    this.mUIStyle.mFloatBarRulesFromUrl = 0L;
    int i = super.doCreateLoopStep_InitUIContent(paramBundle);
    super.getActivity().getWindow().setBackgroundDrawableResource(2131167276);
    if ((this.mUIStyleHandler.webviewWrapper instanceof RefreshView)) {
      ((RefreshView)this.mUIStyleHandler.webviewWrapper).a(false);
    }
    if (this.mUIStyleHandler.mBrowserTips != null) {
      this.mUIStyleHandler.mBrowserTips.setVisibility(8);
    }
    this.contentView.setBackgroundColor(0);
    return i;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "ConfessBrowserFragment doOnCreate = ");
    }
    boolean bool = super.doOnCreate(paramBundle);
    this.mPluginEngine.a(new String[] { "sayHonest", bgzx.a, "QQApi", "ui", "share", "PublicAccountJs" });
    return bool;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "ConfessBrowserFragment onReceivedError = ");
    }
    this.jdField_a_of_type_Boolean = true;
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity.ConfessBrowserFragment
 * JD-Core Version:    0.7.0.1
 */