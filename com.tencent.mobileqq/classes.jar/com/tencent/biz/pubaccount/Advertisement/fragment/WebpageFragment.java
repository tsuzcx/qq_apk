package com.tencent.biz.pubaccount.Advertisement.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import axqy;
import bcfx;
import bcga;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import nau;
import nis;
import niu;

public class WebpageFragment
  extends WebViewFragment
{
  private nis a;
  
  public static WebpageFragment a(Intent paramIntent)
  {
    WebpageFragment localWebpageFragment = new WebpageFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    localWebpageFragment.setArguments(localBundle);
    return localWebpageFragment;
  }
  
  public void a(nis paramnis)
  {
    this.jdField_a_of_type_Nis = paramnis;
  }
  
  public boolean a()
  {
    nau.a("Web_qqbrowser_ShowPreview");
    long l = System.nanoTime();
    this.jdField_a_of_type_Bcfx.a(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_Bcga.c = 0L;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.a(this.jdField_a_of_type_Bcfx.jdField_a_of_type_Bcga.B);
    this.p = true;
    this.q = false;
    F();
    if (QLog.isColorLevel()) {
      QLog.d("WebpageFragment", 2, "init view 1, cost = " + (System.nanoTime() - l) / 1000000L);
    }
    this.jdField_a_of_type_Bcfx.c = true;
    this.jdField_a_of_type_Bcfx.jdField_a_of_type_AndroidWidgetProgressBar = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.jdField_a_of_type_AndroidWidgetProgressBar;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_Bcfx.a(this.h);
    this.jdField_a_of_type_Bcfx.b = false;
    nau.b("Web_qqbrowser_ShowPreview");
    return true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    axqy.a(null, "dc00898", "", this.jdField_a_of_type_Nis.a.a, "0X8008F6B", "0X8008F6B", 0, 0, this.jdField_a_of_type_Nis.a.c, "", "", this.jdField_a_of_type_Nis.a.b);
  }
  
  public void onResume()
  {
    super.onResume();
    FragmentActivity localFragmentActivity = super.getActivity();
    if (localFragmentActivity != null)
    {
      int i = localFragmentActivity.getWindow().getDecorView().getSystemUiVisibility();
      localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(i & 0xFFFFFFFD);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.WebpageFragment
 * JD-Core Version:    0.7.0.1
 */