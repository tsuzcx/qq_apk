package com.tencent.mobileqq.apollo.store;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.MqqWeakReferenceHandler;
import mqq.os.MqqHandler;

public class ApolloStoreActivity$ApolloWebViewFragment
  extends WebViewFragment
  implements Handler.Callback
{
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new MqqWeakReferenceHandler(Looper.getMainLooper(), this);
  private long b = 0L;
  
  public void a(WebView paramWebView, String paramString)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    this.b = System.currentTimeMillis();
    int i = (int)(this.b - this.jdField_a_of_type_Long);
    if ((getActivity() != null) && ((getActivity() instanceof ApolloStoreActivity))) {
      ApolloStoreActivity.a((ApolloStoreActivity)getActivity(), i);
    }
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloStoreActivity_apollo_store_stability_", 2, new Object[] { "onPageFinished total cost:", Integer.valueOf(i), " url:", paramString });
    }
  }
  
  public void a(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.b = 0L;
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1);
    long l = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).getLong("SP_KEY_APOLLO_STORE_PAGE_LOAD_TIMEOUT_VALUE", 15000L);
    QLog.d("[cmshow]ApolloStoreActivity", 2, new Object[] { "page load timeout value is:", Long.valueOf(l) });
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1, l);
    if (QLog.isColorLevel())
    {
      paramWebView = new StringBuilder();
      paramWebView.append("onPageStarted url:");
      paramWebView.append(paramString);
      QLog.d("[cmshow]ApolloStoreActivity", 2, paramWebView.toString());
    }
    if ((getActivity() instanceof ApolloStoreActivity))
    {
      paramWebView = (ApolloStoreActivity)getActivity();
      paramBitmap = this.jdField_a_of_type_JavaLangString;
      if ((paramBitmap != null) && (!paramBitmap.equals(paramString)) && (ApolloStoreActivity.a(paramWebView) != null)) {
        ApolloStoreActivity.a(paramWebView).b();
      }
      ApolloStoreActivity.a(paramWebView, paramString);
      paramWebView = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_user_config", 4).edit();
      paramWebView.putString("apollo_store_watch_current_url", paramString);
      paramWebView.apply();
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new ApolloStoreActivity.ApolloWebViewFragment.1(this, this.webViewSurface);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return true;
    }
    if ((getActivity() != null) && ((getActivity() instanceof ApolloStoreActivity)) && (this.b == 0L)) {
      ApolloStoreActivity.a((ApolloStoreActivity)getActivity());
    }
    if (QLog.isColorLevel()) {
      QLog.d("WebLog_WebViewFragment_apollo_store_stability_", 2, "handleMessage. MSG_CODE_CHECK_PAGE_LOAD_TIMEOUT");
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView == getSwiftTitleUI().a) && ((getActivity() instanceof ApolloStoreActivity)))
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
      ((ApolloStoreActivity)getActivity()).a(this.contentView);
    }
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreActivity.ApolloWebViewFragment
 * JD-Core Version:    0.7.0.1
 */