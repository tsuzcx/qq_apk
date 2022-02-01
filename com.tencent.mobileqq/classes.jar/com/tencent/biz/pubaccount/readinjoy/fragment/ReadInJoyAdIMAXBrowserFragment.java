package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import bhmv;
import bhql;
import bidh;
import bqcd;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import mqq.app.AppRuntime;
import poe;
import pof;
import ryx;
import zlx;

public class ReadInJoyAdIMAXBrowserFragment
  extends WebViewFragment
{
  public long a;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private boolean jdField_a_of_type_Boolean;
  private ImageView b;
  
  public ReadInJoyAdIMAXBrowserFragment()
  {
    this.jdField_a_of_type_Long = 8996L;
  }
  
  private View.OnClickListener a()
  {
    return new pof(this);
  }
  
  private void a()
  {
    bqcd.a(getActivity());
    if (bqcd.b()) {
      bqcd.c(getActivity());
    }
    if (bqcd.b()) {}
    for (int i = bqcd.b(getActivity());; i = 0)
    {
      if (this.mUIStyleHandler.jdField_a_of_type_Bhmv.a != null) {
        this.mUIStyleHandler.jdField_a_of_type_Bhmv.a.setVisibility(8);
      }
      if (this.mUIStyleHandler.d != null) {
        adjustWebViewTopMargin(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131296591), 0);
      }
      if (this.mUIStyleHandler.c == null) {
        return;
      }
      int j = zlx.a(getActivity(), 30.0F);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getActivity());
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842867);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(9);
      localLayoutParams.leftMargin = zlx.a(getActivity(), 15.0F);
      localLayoutParams.topMargin = (zlx.a(getActivity(), 15.0F) + i);
      this.mUIStyleHandler.c.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new poe(this));
      this.b = new ImageView(getActivity());
      this.b.setBackgroundResource(2130842869);
      localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(11);
      localLayoutParams.rightMargin = zlx.a(getActivity(), 15.0F);
      localLayoutParams.topMargin = (i + zlx.a(getActivity(), 15.0F));
      this.mUIStyleHandler.c.addView(this.b, localLayoutParams);
      this.b.setOnClickListener(a());
      return;
    }
  }
  
  public int doCreateLoopStep_Final(Bundle paramBundle)
  {
    int i = super.doCreateLoopStep_Final(paramBundle);
    if (getActivity().getRequestedOrientation() != 1) {
      getActivity().setRequestedOrientation(1);
    }
    getWebView().setVerticalScrollBarEnabled(false);
    getWebView().setHorizontalScrollBarEnabled(false);
    if ((this.mUIStyleHandler != null) && (this.mUIStyleHandler.jdField_a_of_type_Bidh != null)) {
      this.mUIStyleHandler.jdField_a_of_type_Bidh.a(false);
    }
    if ((this.mUIStyleHandler != null) && (this.mUIStyleHandler.d != null))
    {
      paramBundle = this.mUIStyleHandler.d.findViewById(2131365026);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    if (this.mSystemBarComp != null) {
      this.mSystemBarComp.setVisibility(8);
    }
    ryx.a(getHostActivity());
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramBundle instanceof ToolAppRuntime)) {
      this.jdField_a_of_type_MqqAppAppRuntime = paramBundle.getAppRuntime("modular_web");
    }
    a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)getIntent().getParcelableExtra("ad"));
    return i;
  }
  
  public int doCreateLoopStep_InitData(Bundle paramBundle)
  {
    if (this.mUIStyleHandler != null)
    {
      this.mUIStyleHandler.jdField_a_of_type_Bhqo.D = true;
      this.mUIStyleHandler.jdField_a_of_type_Bhqo.f = true;
      this.mUIStyle.n = true;
    }
    ryx.a(getHostActivity());
    return super.doCreateLoopStep_InitData(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    ryx.a(getHostActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment
 * JD-Core Version:    0.7.0.1
 */