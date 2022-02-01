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
import bhmv;
import bhql;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import mue;

public class QQH5BrowserActivity$QQH5BrowserFragment
  extends WebViewFragment
{
  private void a(Bundle paramBundle)
  {
    super.getActivity().getWindow().setFlags(1024, 1024);
    this.webView.setVerticalScrollBarEnabled(false);
    this.mUIStyleHandler.a.setVisibility(8);
    if ((this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      paramBundle = (RelativeLayout.LayoutParams)this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramBundle.height = ((int)mue.a(BaseApplicationImpl.getApplication(), 60.0F));
      this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramBundle);
    }
    this.mSwiftTitleUI.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
    int i = (int)mue.a(BaseApplicationImpl.getApplication(), 12.0F);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.width = ((int)mue.a(BaseApplicationImpl.getApplication(), 15.0F));
    paramBundle.height = ((int)mue.a(BaseApplicationImpl.getApplication(), 15.0F));
    this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBundle);
    this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130847784);
    this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.setText("");
    paramBundle = this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetTextView.getParent();
    if ((paramBundle instanceof RelativeLayout))
    {
      ((RelativeLayout)paramBundle).setPadding(0, 0, 0, 0);
      paramBundle.requestLayout();
    }
    paramBundle = super.getActivity().findViewById(2131376738);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9);
    localLayoutParams.setMargins(i, i, 0, 0);
    paramBundle.setLayoutParams(localLayoutParams);
    paramBundle = this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramBundle.width = ((int)mue.a(BaseApplicationImpl.getApplication(), 22.0F));
    paramBundle.height = ((int)mue.a(BaseApplicationImpl.getApplication(), 15.0F));
    this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBundle);
    this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130848415);
    paramBundle = this.mSwiftTitleUI.jdField_a_of_type_AndroidWidgetImageView.getParent();
    if ((paramBundle instanceof RelativeLayout))
    {
      ((RelativeLayout)paramBundle).setPadding(0, 0, 0, 0);
      paramBundle.requestLayout();
    }
    paramBundle = super.getActivity().findViewById(2131376739);
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