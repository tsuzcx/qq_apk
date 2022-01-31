package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;

public class QQTranslucentBrowserActivity$QQTranslucentBrowserFragment
  extends WebViewFragment
{
  @TargetApi(11)
  public int c(Bundle paramBundle)
  {
    int i = super.c(paramBundle);
    super.getActivity().getWindow().setBackgroundDrawableResource(2131492924);
    if ((this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a instanceof RefreshView)) {
      ((RefreshView)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.a).a(false);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b != null) {
      this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserUIStyleHandler.b.setVisibility(8);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
 * JD-Core Version:    0.7.0.1
 */