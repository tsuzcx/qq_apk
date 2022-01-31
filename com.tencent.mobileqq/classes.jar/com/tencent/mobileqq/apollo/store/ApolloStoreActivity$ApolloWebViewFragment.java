package com.tencent.mobileqq.apollo.store;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;

public class ApolloStoreActivity$ApolloWebViewFragment
  extends WebViewFragment
{
  private String a;
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.a(paramWebView, paramString, paramBitmap);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "onPageStarted url:" + paramString);
    }
    if ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equals(paramString)) && ((getActivity() instanceof ApolloStoreActivity)))
    {
      paramWebView = (ApolloStoreActivity)getActivity();
      if (ApolloStoreActivity.a(paramWebView) != null) {
        ApolloStoreActivity.a(paramWebView).b();
      }
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  protected int e(Bundle paramBundle)
  {
    int i = super.e(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setClickable(false);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(null);
    this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    return i;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftSwiftIphoneTitleBarUI.jdField_a_of_type_AndroidWidgetTextView) && ((getActivity() instanceof ApolloStoreActivity)))
    {
      ((ApolloStoreActivity)getActivity()).a();
      return;
    }
    super.onClick(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if ((getActivity() instanceof ApolloStoreActivity)) {
      ((ApolloStoreActivity)getActivity()).a(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftWebBrowserViewContainer);
    }
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreActivity.ApolloWebViewFragment
 * JD-Core Version:    0.7.0.1
 */