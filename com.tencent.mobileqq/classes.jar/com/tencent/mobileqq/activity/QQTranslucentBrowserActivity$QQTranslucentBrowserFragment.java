package com.tencent.mobileqq.activity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import birg;
import com.tencent.biz.ui.RefreshView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebBrowserViewContainer;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public class QQTranslucentBrowserActivity$QQTranslucentBrowserFragment
  extends WebViewFragment
{
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    if ((getActivity() == null) || (getActivity().getIntent() == null)) {}
    while (this.intent.getIntExtra("key_dialog_type", -1) == -1) {
      return i;
    }
    getActivity().getWindow().setFlags(1024, 1024);
    this.mUIStyleHandler.a.setVisibility(8);
    this.mUIStyle.a = true;
    hideVirtualNavBar();
    doShowTitleBar(false);
    return i;
  }
  
  @TargetApi(11)
  public int doCreateLoopStep_InitUIContent(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_InitUIContent(paramBundle);
    super.getActivity().getWindow().setBackgroundDrawableResource(2131167247);
    if ((this.mUIStyleHandler.jdField_c_of_type_AndroidViewViewGroup instanceof RefreshView)) {
      ((RefreshView)this.mUIStyleHandler.jdField_c_of_type_AndroidViewViewGroup).a(false);
    }
    if (this.mUIStyleHandler.jdField_c_of_type_AndroidViewView != null) {
      this.mUIStyleHandler.jdField_c_of_type_AndroidViewView.setVisibility(8);
    }
    if (this.webView.getX5WebViewExtension() != null) {}
    for (;;)
    {
      try
      {
        this.webView.getView().setBackgroundColor(0);
        this.webView.setBackgroundColor(0);
        this.contentView.setBackgroundColor(0);
        return i;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        continue;
      }
      this.webView.setBackgroundColor(0);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater.setBackgroundColor(0);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
 * JD-Core Version:    0.7.0.1
 */