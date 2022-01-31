package com.tencent.biz.pubaccount.Advertisement.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import azmj;
import beey;
import befb;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import ndq;
import nlo;
import nlq;

public class WebpageFragment
  extends WebViewFragment
{
  private nlo a;
  
  public static WebpageFragment a(Intent paramIntent)
  {
    WebpageFragment localWebpageFragment = new WebpageFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("intent", paramIntent);
    localWebpageFragment.setArguments(localBundle);
    return localWebpageFragment;
  }
  
  public void a(nlo paramnlo)
  {
    this.jdField_a_of_type_Nlo = paramnlo;
  }
  
  public boolean a()
  {
    ndq.a("Web_qqbrowser_ShowPreview");
    long l = System.nanoTime();
    this.jdField_a_of_type_Beey.a(this.jdField_a_of_type_AndroidContentIntent);
    this.jdField_a_of_type_Befb.c = 0L;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.a(this.jdField_a_of_type_Beey.jdField_a_of_type_Befb.D);
    this.p = true;
    this.q = false;
    G();
    if (QLog.isColorLevel()) {
      QLog.d("WebpageFragment", 2, "init view 1, cost = " + (System.nanoTime() - l) / 1000000L);
    }
    this.jdField_a_of_type_Beey.c = true;
    this.jdField_a_of_type_Beey.jdField_a_of_type_AndroidWidgetProgressBar = this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.jdField_a_of_type_AndroidWidgetProgressBar;
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
    this.jdField_a_of_type_Beey.a(this.g);
    this.jdField_a_of_type_Beey.b = false;
    ndq.b("Web_qqbrowser_ShowPreview");
    return true;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    azmj.a(null, "dc00898", "", this.jdField_a_of_type_Nlo.a.a, "0X8008F6B", "0X8008F6B", 0, 0, this.jdField_a_of_type_Nlo.a.c, "", "", this.jdField_a_of_type_Nlo.a.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.fragment.WebpageFragment
 * JD-Core Version:    0.7.0.1
 */