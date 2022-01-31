package com.tencent.mobileqq.apollo.store;

import akzs;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bebk;
import bhoe;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.os.MqqHandler;

public class ApolloStoreActivity$ApolloWebViewFragment
  extends WebViewFragment
  implements Handler.Callback
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bhoe(Looper.getMainLooper(), this);
  private long b;
  
  public void a(WebView paramWebView, String paramString)
  {
    super.a(paramWebView, paramString);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    this.b = System.currentTimeMillis();
    int i = (int)(this.b - this.jdField_a_of_type_Long);
    if ((getActivity() != null) && ((getActivity() instanceof ApolloStoreActivity))) {
      ApolloStoreActivity.a((ApolloStoreActivity)getActivity(), i);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity_apollo_store_stability_", 2, new Object[] { "onPageFinished total cost:", Integer.valueOf(i), " url:", paramString });
    }
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.a(paramWebView, paramString, paramBitmap);
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.b = 0L;
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    long l = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).getLong("SP_KEY_APOLLO_STORE_PAGE_LOAD_TIMEOUT_VALUE", 15000L);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, new Object[] { "page load timeout value is:", Long.valueOf(l) });
    }
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, l);
    if (QLog.isColorLevel()) {
      QLog.d("ApolloStoreActivity", 2, "onPageStarted url:" + paramString);
    }
    if ((getActivity() instanceof ApolloStoreActivity))
    {
      paramWebView = (ApolloStoreActivity)getActivity();
      if ((this.jdField_a_of_type_JavaLangString != null) && (!this.jdField_a_of_type_JavaLangString.equals(paramString)) && (ApolloStoreActivity.a(paramWebView) != null)) {
        ApolloStoreActivity.a(paramWebView).b();
      }
      ApolloStoreActivity.a(paramWebView, paramString);
      paramWebView = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).edit();
      paramWebView.putString("apollo_store_watch_current_url", paramString);
      paramWebView.apply();
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public int f(Bundle paramBundle)
  {
    int i = super.f(paramBundle);
    this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidViewViewGroup.setClickable(false);
    this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(null);
    this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (getActivity() != null) {
      ImmersiveUtils.a(getActivity().getWindow(), true);
    }
    return i;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if ((getActivity() != null) && ((getActivity() instanceof ApolloStoreActivity)) && (this.b == 0L)) {
        ApolloStoreActivity.a((ApolloStoreActivity)getActivity());
      }
      if (QLog.isColorLevel()) {
        QLog.d("WebLog_WebViewFragment_apollo_store_stability_", 2, "handleMessage. MSG_CODE_CHECK_PAGE_LOAD_TIMEOUT");
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == this.jdField_a_of_type_Bebk.jdField_a_of_type_AndroidWidgetTextView) && ((getActivity() instanceof ApolloStoreActivity)))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreActivity.ApolloWebViewFragment
 * JD-Core Version:    0.7.0.1
 */