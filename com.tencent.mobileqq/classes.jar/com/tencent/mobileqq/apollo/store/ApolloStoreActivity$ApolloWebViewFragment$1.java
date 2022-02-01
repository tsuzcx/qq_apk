package com.tencent.mobileqq.apollo.store;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.swift.proxy.WebKernelCallBackProxy;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.smtt.sdk.WebView;
import com.tencent.widget.immersive.ImmersiveUtils;

class ApolloStoreActivity$ApolloWebViewFragment$1
  extends WebKernelCallBackProxy
{
  ApolloStoreActivity$ApolloWebViewFragment$1(ApolloStoreActivity.ApolloWebViewFragment paramApolloWebViewFragment, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    super(paramWebViewKernelCallBack);
  }
  
  public boolean interceptInitUIFrame()
  {
    this.webViewKernelCallBack.onShowPreview(new Bundle());
    this.a.getSwiftTitleUI().jdField_a_of_type_AndroidViewViewGroup.setClickable(false);
    this.a.getSwiftTitleUI().jdField_a_of_type_AndroidViewViewGroup.setOnTouchListener(null);
    this.a.getSwiftTitleUI().jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    if (this.a.getActivity() != null) {
      ImmersiveUtils.clearCoverForStatus(this.a.getActivity().getWindow(), true);
    }
    return true;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this.a.a(paramWebView, paramString);
  }
  
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this.a.a(paramWebView, paramString, paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreActivity.ApolloWebViewFragment.1
 * JD-Core Version:    0.7.0.1
 */