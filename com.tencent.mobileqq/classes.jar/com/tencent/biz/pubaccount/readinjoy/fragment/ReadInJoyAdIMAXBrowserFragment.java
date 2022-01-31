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
import bebk;
import beey;
import besa;
import bngs;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import mqq.app.AppRuntime;
import oyr;
import oys;
import rdm;
import xod;

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
    return new oys(this);
  }
  
  private void i()
  {
    bngs.a(getActivity());
    if (bngs.b()) {
      bngs.c(getActivity());
    }
    if (bngs.b()) {}
    for (int i = bngs.b(getActivity());; i = 0)
    {
      if (this.jdField_a_of_type_Beey.jdField_a_of_type_Bebk.a != null) {
        this.jdField_a_of_type_Beey.jdField_a_of_type_Bebk.a.setVisibility(8);
      }
      if (this.jdField_a_of_type_Beey.d != null) {
        b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131296550), 0);
      }
      if (this.jdField_a_of_type_Beey.c == null) {
        return;
      }
      int j = xod.a(getActivity(), 30.0F);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getActivity());
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842530);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(9);
      localLayoutParams.leftMargin = xod.a(getActivity(), 15.0F);
      localLayoutParams.topMargin = (xod.a(getActivity(), 15.0F) + i);
      this.jdField_a_of_type_Beey.c.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new oyr(this));
      this.b = new ImageView(getActivity());
      this.b.setBackgroundResource(2130842532);
      localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(11);
      localLayoutParams.rightMargin = xod.a(getActivity(), 15.0F);
      localLayoutParams.topMargin = (i + xod.a(getActivity(), 15.0F));
      this.jdField_a_of_type_Beey.c.addView(this.b, localLayoutParams);
      this.b.setOnClickListener(a());
      return;
    }
  }
  
  public int a(Bundle paramBundle)
  {
    int i = super.a(paramBundle);
    if (getActivity().getRequestedOrientation() != 1) {
      getActivity().setRequestedOrientation(1);
    }
    getWebView().setVerticalScrollBarEnabled(false);
    getWebView().setHorizontalScrollBarEnabled(false);
    if ((this.jdField_a_of_type_Beey != null) && (this.jdField_a_of_type_Beey.jdField_a_of_type_Besa != null)) {
      this.jdField_a_of_type_Beey.jdField_a_of_type_Besa.a(false);
    }
    if ((this.jdField_a_of_type_Beey != null) && (this.jdField_a_of_type_Beey.d != null))
    {
      paramBundle = this.jdField_a_of_type_Beey.d.findViewById(2131364796);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    if (this.d != null) {
      this.d.setVisibility(8);
    }
    rdm.a(a());
    paramBundle = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramBundle instanceof ToolAppRuntime)) {
      this.jdField_a_of_type_MqqAppAppRuntime = paramBundle.getAppRuntime("modular_web");
    }
    i();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = ((AdvertisementInfo)a().getParcelableExtra("ad"));
    return i;
  }
  
  public int c(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Beey != null)
    {
      this.jdField_a_of_type_Beey.jdField_a_of_type_Befb.D = true;
      this.jdField_a_of_type_Beey.jdField_a_of_type_Befb.f = true;
      this.jdField_a_of_type_Befb.n = true;
    }
    rdm.a(a());
    return super.c(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    rdm.a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment
 * JD-Core Version:    0.7.0.1
 */