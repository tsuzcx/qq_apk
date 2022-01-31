package com.tencent.mobileqq.apollo.game;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler.SwiftBrowserUIStyle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import ymr;
import yms;

public class ApolloWebViewFragment
  extends ApolloFragment
{
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      paramBundle = a();
      if (paramBundle != null) {
        paramBundle.putExtra("Director", new ApolloGameView.Director());
      }
      if (Build.VERSION.SDK_INT < 18) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.clearView();
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl("about:blank");
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    String str = paramWebView.getTitle();
    if (!TextUtils.isEmpty(str))
    {
      Object localObject = a().getSerializableExtra("Director");
      if ((localObject != null) && ((localObject instanceof ApolloGameView.Director)))
      {
        localObject = (ApolloGameView.Director)localObject;
        if (!str.equals(((ApolloGameView.Director)localObject).title))
        {
          ((ApolloGameView.Director)localObject).title = str;
          ApolloFragmentManager.a().b();
        }
      }
    }
    super.a(paramWebView, paramString);
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.a(paramWebView, paramString, paramBitmap);
  }
  
  public void a(String paramString)
  {
    Util.a("Web_readyToLoadUrl");
    if ((this.jdField_a_of_type_ComTencentBizUiTouchWebView == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    c();
    if (Build.VERSION.SDK_INT < 18) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.clearView();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.e) && (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.h > 0L))
      {
        ReportController.b(null, "P_CliOper", "BizTechReport", "", "web", "plugin_start_time", 0, 1, (int)((System.nanoTime() - this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.h) / 1000000L), "", "", "", "" + this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.c);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.h = 0L;
      }
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.n = System.currentTimeMillis();
      long l = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.n;
      l = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.b;
      this.g = paramString;
      if (!TextUtils.isEmpty(this.g)) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(this.g);
      }
      Util.b("Web_readyToLoadUrl");
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserStatistics.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView, this.g, 0, 0, 0, 0, 0, null);
      return;
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl("about:blank");
    }
  }
  
  public boolean a()
  {
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.c = 0L;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_Boolean = false;
    Util.a("Web_qqbrowser_ShowPreview");
    long l = System.nanoTime();
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler$SwiftBrowserUIStyle.y);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_b_of_type_AndroidViewViewGroup = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.a(this.jdField_a_of_type_AndroidContentIntent, this);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.b(false);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloWebViewFragment", 2, "init view 1, cost = " + (System.nanoTime() - l) / 1000000L);
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.c = true;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.jdField_a_of_type_AndroidWidgetProgressBar = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.jdField_a_of_type_AndroidWidgetProgressBar;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a(this.g);
    Util.b("Web_qqbrowser_ShowPreview");
    return true;
  }
  
  public void b(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloWebViewFragment", 2, "[onShow] ");
    }
    String str1;
    if (paramBundle != null)
    {
      paramBundle.getInt("id");
      str1 = paramBundle.getString("url");
      String str2 = b();
      if ((TextUtils.isEmpty(str2)) || (str2.equals(str1))) {
        break label64;
      }
      a(str1);
    }
    for (;;)
    {
      super.b(paramBundle);
      return;
      label64:
      if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(str1);
      }
    }
  }
  
  public void c(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloWebViewFragment", 2, "[onForward] ");
    }
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Int = paramBundle.getInt("id");
      ThreadManager.post(new yms(this, paramBundle.getString("url")), 8, null, false);
    }
    super.c(paramBundle);
  }
  
  protected int e(Bundle paramBundle)
  {
    Util.a("Web_qqbrowser_state_machine_init_ui_frame");
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.d = true;
    }
    a();
    this.m = 128;
    Util.b("Web_qqbrowser_state_machine_init_ui_frame");
    return 1;
  }
  
  public void onResume()
  {
    int j = 1;
    Util.a("Web_qqbrowser_doonresume");
    if (QLog.isColorLevel()) {
      QLog.d("ApolloWebViewFragment", 2, "onResume");
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null) {
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.onResume();
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt("state_machine_step", this.m);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserComponentsProvider.a(2, (Bundle)localObject);
    localObject = a();
    int i = j;
    if ((localObject instanceof QQBrowserActivity))
    {
      WebViewFragment localWebViewFragment = ((QQBrowserActivity)localObject).b();
      i = j;
      if (localWebViewFragment != null) {
        if (localWebViewFragment != this) {
          break label139;
        }
      }
    }
    label139:
    for (i = 1;; i = 0)
    {
      if (i != 0) {
        a(2L, null);
      }
      ThreadManager.executeOnSubThread(new ymr(this, (Activity)localObject));
      Util.b("Web_qqbrowser_doonresume");
      super.onResume();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloWebViewFragment
 * JD-Core Version:    0.7.0.1
 */