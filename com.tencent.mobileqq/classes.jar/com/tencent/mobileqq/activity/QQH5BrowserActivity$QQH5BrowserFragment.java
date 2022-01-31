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
import bcbv;
import bcfj;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import muf;

public class QQH5BrowserActivity$QQH5BrowserFragment
  extends WebViewFragment
{
  private void a(Bundle paramBundle)
  {
    super.getActivity().getWindow().setFlags(1024, 1024);
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_Bcfj.a.setVisibility(8);
    if ((this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams() instanceof RelativeLayout.LayoutParams))
    {
      paramBundle = (RelativeLayout.LayoutParams)this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
      paramBundle.height = ((int)muf.a(BaseApplicationImpl.getApplication(), 60.0F));
      this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(paramBundle);
    }
    this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, 0);
    int i = (int)muf.a(BaseApplicationImpl.getApplication(), 12.0F);
    paramBundle = new RelativeLayout.LayoutParams(-2, -2);
    paramBundle.width = ((int)muf.a(BaseApplicationImpl.getApplication(), 15.0F));
    paramBundle.height = ((int)muf.a(BaseApplicationImpl.getApplication(), 15.0F));
    this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams(paramBundle);
    this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130846879);
    this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetTextView.setText("");
    paramBundle = this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetTextView.getParent();
    if ((paramBundle instanceof RelativeLayout))
    {
      ((RelativeLayout)paramBundle).setPadding(0, 0, 0, 0);
      paramBundle.requestLayout();
    }
    paramBundle = super.getActivity().findViewById(2131375448);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(9);
    localLayoutParams.setMargins(i, i, 0, 0);
    paramBundle.setLayoutParams(localLayoutParams);
    paramBundle = this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    paramBundle.width = ((int)muf.a(BaseApplicationImpl.getApplication(), 22.0F));
    paramBundle.height = ((int)muf.a(BaseApplicationImpl.getApplication(), 15.0F));
    this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(paramBundle);
    this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130847478);
    paramBundle = this.jdField_a_of_type_Bcbv.jdField_a_of_type_AndroidWidgetImageView.getParent();
    if ((paramBundle instanceof RelativeLayout))
    {
      ((RelativeLayout)paramBundle).setPadding(0, 0, 0, 0);
      paramBundle.requestLayout();
    }
    paramBundle = super.getActivity().findViewById(2131375449);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(11);
    localLayoutParams.setMargins(0, i, i, 0);
    paramBundle.setLayoutParams(localLayoutParams);
  }
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    a(paramBundle);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQH5BrowserActivity.QQH5BrowserFragment
 * JD-Core Version:    0.7.0.1
 */