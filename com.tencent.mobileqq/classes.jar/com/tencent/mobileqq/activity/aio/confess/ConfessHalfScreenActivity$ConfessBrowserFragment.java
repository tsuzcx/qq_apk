package com.tencent.mobileqq.activity.aio.confess;

import adco;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import bccj;
import bcee;
import bcfx;
import bcim;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class ConfessHalfScreenActivity$ConfessBrowserFragment
  extends WebViewFragment
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    this.jdField_a_of_type_Bccj.b(false);
    this.jdField_a_of_type_Bcfx.a.setVisibility(8);
    return i;
  }
  
  public bcee a()
  {
    return new bcee(this, 127, new adco(this));
  }
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.a(paramWebView, paramInt, paramString1, paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "ConfessBrowserFragment onReceivedError = ");
    }
    this.jdField_a_of_type_Boolean = true;
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  public boolean a(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment", 2, "ConfessBrowserFragment doOnCreate = ");
    }
    boolean bool = super.a(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebViewPluginEngine.a(new String[] { "sayHonest", bcim.a, "QQApi", "ui", "share", "PublicAccountJs" });
    return bool;
  }
  
  public int d(Bundle paramBundle)
  {
    this.jdField_a_of_type_Bcga.c = 0L;
    int i = super.d(paramBundle);
    super.getActivity().getWindow().setBackgroundDrawableResource(2131167087);
    if ((this.jdField_a_of_type_Bcfx.c instanceof RefreshView)) {
      ((RefreshView)this.jdField_a_of_type_Bcfx.c).a(false);
    }
    if (this.jdField_a_of_type_Bcfx.b != null) {
      this.jdField_a_of_type_Bcfx.b.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.setBackgroundColor(0);
    return i;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.confess.ConfessHalfScreenActivity.ConfessBrowserFragment
 * JD-Core Version:    0.7.0.1
 */