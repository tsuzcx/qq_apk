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
import beft;
import bejh;
import bewj;
import bnle;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import mqq.app.AppRuntime;
import oyr;
import oys;
import rdm;
import xsm;

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
    bnle.a(getActivity());
    if (bnle.b()) {
      bnle.c(getActivity());
    }
    if (bnle.b()) {}
    for (int i = bnle.b(getActivity());; i = 0)
    {
      if (this.jdField_a_of_type_Bejh.jdField_a_of_type_Beft.a != null) {
        this.jdField_a_of_type_Bejh.jdField_a_of_type_Beft.a.setVisibility(8);
      }
      if (this.jdField_a_of_type_Bejh.d != null) {
        b(BaseApplicationImpl.getApplication().getResources().getDimensionPixelSize(2131296550), 0);
      }
      if (this.jdField_a_of_type_Bejh.c == null) {
        return;
      }
      int j = xsm.a(getActivity(), 30.0F);
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getActivity());
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130842543);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(9);
      localLayoutParams.leftMargin = xsm.a(getActivity(), 15.0F);
      localLayoutParams.topMargin = (xsm.a(getActivity(), 15.0F) + i);
      this.jdField_a_of_type_Bejh.c.addView(this.jdField_a_of_type_AndroidWidgetImageView, localLayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new oyr(this));
      this.b = new ImageView(getActivity());
      this.b.setBackgroundResource(2130842545);
      localLayoutParams = new RelativeLayout.LayoutParams(j, j);
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(11);
      localLayoutParams.rightMargin = xsm.a(getActivity(), 15.0F);
      localLayoutParams.topMargin = (i + xsm.a(getActivity(), 15.0F));
      this.jdField_a_of_type_Bejh.c.addView(this.b, localLayoutParams);
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
    if ((this.jdField_a_of_type_Bejh != null) && (this.jdField_a_of_type_Bejh.jdField_a_of_type_Bewj != null)) {
      this.jdField_a_of_type_Bejh.jdField_a_of_type_Bewj.a(false);
    }
    if ((this.jdField_a_of_type_Bejh != null) && (this.jdField_a_of_type_Bejh.d != null))
    {
      paramBundle = this.jdField_a_of_type_Bejh.d.findViewById(2131364797);
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
    if (this.jdField_a_of_type_Bejh != null)
    {
      this.jdField_a_of_type_Bejh.jdField_a_of_type_Bejk.D = true;
      this.jdField_a_of_type_Bejh.jdField_a_of_type_Bejk.f = true;
      this.jdField_a_of_type_Bejk.n = true;
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