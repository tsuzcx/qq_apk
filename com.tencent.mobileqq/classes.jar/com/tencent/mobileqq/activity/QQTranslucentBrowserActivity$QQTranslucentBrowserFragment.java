package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewUIUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.webview.swift.utils.WebViewKernelCallBack;
import com.tencent.mobileqq.webviewplugin.WebUiUtils.WebTitleBarInterface;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;

public class QQTranslucentBrowserActivity$QQTranslucentBrowserFragment
  extends WebViewFragment
{
  public WebViewKernelCallBack getWebViewKernelCallBack()
  {
    return new QQTranslucentBrowserActivity.QQTranslucentBrowserFragment.1(this, this.webViewSurface);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater.setBackgroundColor(0);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onFinalState(Bundle paramBundle, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    paramWebViewKernelCallBack.onFinalState(paramBundle);
    if (getActivity() != null)
    {
      if (getActivity().getIntent() == null) {
        return;
      }
      if (this.intent.getIntExtra("key_dialog_type", -1) != -1)
      {
        getActivity().getWindow().setFlags(1024, 1024);
        getUIStyleHandler().a.setVisibility(8);
        getUIStyle().a = true;
        WebViewUIUtils.b(super.getActivity());
        getWebTitleBarInterface().e(false);
      }
    }
  }
  
  @TargetApi(11)
  public void onInitUIContent(Bundle paramBundle, WebViewKernelCallBack paramWebViewKernelCallBack)
  {
    if ((getIntent() != null) && (getIntent().getBooleanExtra("flag_hide_float_bar", false))) {
      getUIStyle().c = 0L;
    }
    paramWebViewKernelCallBack.onInitUIContent(paramBundle);
    super.getActivity().getWindow().setBackgroundDrawableResource(2131167333);
    if ((getUIStyleHandler().jdField_c_of_type_AndroidViewViewGroup instanceof RefreshView)) {
      ((RefreshView)getUIStyleHandler().jdField_c_of_type_AndroidViewViewGroup).a(false);
    }
    if (getUIStyleHandler().jdField_c_of_type_AndroidViewView != null) {
      getUIStyleHandler().jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.webView.getX5WebViewExtension() != null) {
      try
      {
        this.webView.getView().setBackgroundColor(0);
        this.webView.setBackgroundColor(0);
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
      }
    } else {
      this.webView.setBackgroundColor(0);
    }
    this.contentView.setBackgroundColor(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
 * JD-Core Version:    0.7.0.1
 */