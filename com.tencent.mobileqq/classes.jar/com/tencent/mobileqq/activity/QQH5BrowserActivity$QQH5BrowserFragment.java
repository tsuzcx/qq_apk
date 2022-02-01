package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bieo;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserUIStyleHandler;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import mvk;

public class QQH5BrowserActivity$QQH5BrowserFragment
  extends WebViewFragment
{
  private void a(Bundle paramBundle)
  {
    super.getActivity().getWindow().setFlags(1024, 1024);
    this.webView.setVerticalScrollBarEnabled(false);
    this.mUIStyleHandler.mLoadingProgressBar.setVisibility(8);
    if ((this.mSwiftTitleUI.titleContainer.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      paramBundle = (RelativeLayout.LayoutParams)this.mSwiftTitleUI.titleContainer.getLayoutParams();
      paramBundle.height = ((int)mvk.a(BaseApplicationImpl.getApplication(), 60.0F));
      this.mSwiftTitleUI.titleContainer.setLayoutParams(paramBundle);
    }
    this.mSwiftTitleUI.titleContainer.setPadding(0, 0, 0, 0);
    int i = (int)mvk.a(BaseApplicationImpl.getApplication(), 12.0F);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.width = ((int)mvk.a(BaseApplicationImpl.getApplication(), 15.0F));
    paramBundle.height = ((int)mvk.a(BaseApplicationImpl.getApplication(), 15.0F));
    this.mSwiftTitleUI.leftView.setLayoutParams(paramBundle);
    this.mSwiftTitleUI.leftView.setBackgroundResource(2130847804);
    this.mSwiftTitleUI.leftView.setText("");
    paramBundle = this.mSwiftTitleUI.leftView.getParent();
    if ((paramBundle instanceof RelativeLayout))
    {
      ((RelativeLayout)paramBundle).setPadding(0, 0, 0, 0);
      paramBundle.requestLayout();
    }
    paramBundle = super.getActivity().findViewById(2131376893);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9);
    localLayoutParams.setMargins(i, i, 0, 0);
    paramBundle.setLayoutParams(localLayoutParams);
    paramBundle = this.mSwiftTitleUI.rightViewImg.getLayoutParams();
    paramBundle.width = ((int)mvk.a(BaseApplicationImpl.getApplication(), 22.0F));
    paramBundle.height = ((int)mvk.a(BaseApplicationImpl.getApplication(), 15.0F));
    this.mSwiftTitleUI.rightViewImg.setLayoutParams(paramBundle);
    this.mSwiftTitleUI.rightViewImg.setImageResource(2130848436);
    paramBundle = this.mSwiftTitleUI.rightViewImg.getParent();
    if ((paramBundle instanceof RelativeLayout))
    {
      ((RelativeLayout)paramBundle).setPadding(0, 0, 0, 0);
      paramBundle.requestLayout();
    }
    paramBundle = super.getActivity().findViewById(2131376894);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11);
    localLayoutParams.setMargins(0, i, i, 0);
    paramBundle.setLayoutParams(localLayoutParams);
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    a(paramBundle);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQH5BrowserActivity.QQH5BrowserFragment
 * JD-Core Version:    0.7.0.1
 */