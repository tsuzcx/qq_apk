package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import bejh;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.WebViewProgressBar;

public class QQTranslucentBrowserActivity$QQTranslucentBrowserFragment
  extends WebViewFragment
{
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    if ((getActivity() == null) || (getActivity().getIntent() == null)) {}
    while (this.jdField_a_of_type_AndroidContentIntent.getIntExtra("key_dialog_type", -1) == -1) {
      return i;
    }
    getActivity().getWindow().setFlags(1024, 1024);
    this.jdField_a_of_type_Bejh.a.setVisibility(8);
    this.jdField_a_of_type_Bejk.a = true;
    D();
    g(false);
    return i;
  }
  
  @TargetApi(11)
  public int d(Bundle paramBundle)
  {
    int i = super.d(paramBundle);
    super.getActivity().getWindow().setBackgroundDrawableResource(2131167140);
    if ((this.jdField_a_of_type_Bejh.jdField_c_of_type_AndroidViewViewGroup instanceof RefreshView)) {
      ((RefreshView)this.jdField_a_of_type_Bejh.jdField_c_of_type_AndroidViewViewGroup).a(false);
    }
    if (this.jdField_a_of_type_Bejh.jdField_c_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_Bejh.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView.getX5WebViewExtension() != null) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.getView().setBackgroundColor(0);
        this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
        this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer.setBackgroundColor(0);
        return i;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        continue;
      }
      this.jdField_a_of_type_ComTencentBizUiTouchWebView.setBackgroundColor(0);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater.setBackgroundColor(0);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
 * JD-Core Version:    0.7.0.1
 */