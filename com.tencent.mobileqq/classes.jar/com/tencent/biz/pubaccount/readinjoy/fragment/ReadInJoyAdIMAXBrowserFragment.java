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
import bccj;
import bcfx;
import bcsr;
import bkvi;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import mqq.app.AppRuntime;
import otn;
import oto;
import qoi;
import vzl;

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
    return new oto(this);
  }
  
  private void i()
  {
    bkvi.a(getActivity());
    if (bkvi.b()) {
      bkvi.c(getActivity());
    }
    if (bkvi.b()) {}
    for (int i = bkvi.b(getActivity());; i = 0)
    {
      if (this.jdField_a_of_type_Bcfx.jdField_a_of_type_Bccj.a != null) {
        this.jdField_a_of_type_Bcfx.jdField_a_of_type_Bccj.a.setVisibility(8);
      }
      if (this.jdField_a_of_type_Bcfx.d != null) {
        b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131296536), 0);
      }
      if (this.jdField_a_of_type_Bcfx.c == null) {
        return;
      }
      int j = vzl.a(getActivity(), 30.0F);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getActivity());
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842361);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(9);
      localLayoutParams.leftMargin = vzl.a(getActivity(), 15.0F);
      localLayoutParams.topMargin = (vzl.a(getActivity(), 15.0F) + i);
      this.jdField_a_of_type_Bcfx.c.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new otn(this));
      this.b = new ImageView(getActivity());
      this.b.setBackgroundResource(2130842363);
      localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(11);
      localLayoutParams.rightMargin = vzl.a(getActivity(), 15.0F);
      localLayoutParams.topMargin = (i + vzl.a(getActivity(), 15.0F));
      this.jdField_a_of_type_Bcfx.c.addView(this.b, localLayoutParams);
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
    if ((this.jdField_a_of_type_Bcfx != null) && (this.jdField_a_of_type_Bcfx.jdField_a_of_type_Bcsr != null)) {
      this.jdField_a_of_type_Bcfx.jdField_a_of_type_Bcsr.a(false);
    }
    if ((this.jdField_a_of_type_Bcfx != null) && (this.jdField_a_of_type_Bcfx.d != null))
    {
      paramBundle = this.jdField_a_of_type_Bcfx.d.findViewById(2131364717);
      if (paramBundle != null) {
        paramBundle.setVisibility(8);
      }
    }
    if (this.d != null) {
      this.d.setVisibility(8);
    }
    qoi.a(a());
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
    if (this.jdField_a_of_type_Bcfx != null)
    {
      this.jdField_a_of_type_Bcfx.jdField_a_of_type_Bcga.B = true;
      this.jdField_a_of_type_Bcfx.jdField_a_of_type_Bcga.f = true;
      this.jdField_a_of_type_Bcga.n = true;
    }
    qoi.a(a());
    return super.c(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    qoi.a(a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAdIMAXBrowserFragment
 * JD-Core Version:    0.7.0.1
 */