package com.tencent.gdtad.views.halfScreen;

import acho;
import acjq;
import acjr;
import acjs;
import acko;
import aeow;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.TextView;
import bieb;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasView;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.PublicTransFragmentActivityForTool;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public abstract class GdtBaseHalfScreenFragment
  extends PublicBaseFragment
{
  private acko jdField_a_of_type_Acko;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdCanvasView jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  
  private void a(int paramInt, AdCanvasData paramAdCanvasData, String paramString, FrameLayout paramFrameLayout)
  {
    if (paramInt == 2)
    {
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (paramAdCanvasData != null) && (!TextUtils.isEmpty(paramAdCanvasData.pageTitle))) {
        this.jdField_a_of_type_AndroidWidgetTextView.setText(paramAdCanvasData.pageTitle);
      }
      this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView = new AdCanvasView(getActivity());
      this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView.hideBar();
      this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView.setData(paramAdCanvasData);
      paramFrameLayout.addView(this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView);
    }
    while (paramInt != 1) {
      return;
    }
    paramAdCanvasData = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null).getAppRuntime("modular_web");
    this.jdField_a_of_type_ComTencentBizUiTouchWebView = new TouchWebView(getActivity());
    paramFrameLayout.addView(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    this.jdField_a_of_type_Acko = new acjs(this, getActivity(), getActivity(), null, paramAdCanvasData);
    this.jdField_a_of_type_Acko.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    new bieb(this.jdField_a_of_type_Acko).a(null, paramAdCanvasData, getActivity().getIntent());
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(paramString);
  }
  
  public static void a(Activity paramActivity, Class<? extends GdtBaseHalfScreenFragment> paramClass, Ad paramAd, AdCanvasData paramAdCanvasData, String paramString, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramAd == null) || (!paramAd.isValid()))
    {
      acho.d("GdtBaseHalfScreenFragment", "start error");
      return;
    }
    acho.b("GdtBaseHalfScreenFragment", "start GdtBaseHalfScreenFragment" + paramInt);
    Bundle localBundle = new Bundle();
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putSerializable("data", (GdtAd)paramAd);
    paramAd = new Intent();
    paramAd.putExtra("public_fragment_window_feature", 1);
    paramAd.putExtra("big_brother_source_key", "biz_src_ads");
    paramAd.putExtras(localBundle);
    paramAd.putExtra("url", paramString);
    paramAd.putExtra("canvas_data", paramAdCanvasData);
    paramAd.putExtra("style", paramInt);
    if (TextUtils.isEmpty(paramAd.getStringExtra("big_brother_ref_source_key"))) {
      acho.d("GdtBaseHalfScreenFragment", "start gdt empty refId");
    }
    if (paramInt == 2)
    {
      aeow.a(paramActivity, paramAd, PublicTransFragmentActivity.class, paramClass);
      return;
    }
    aeow.a(paramActivity, paramAd, PublicTransFragmentActivityForTool.class, paramClass);
  }
  
  private void a(FrameLayout paramFrameLayout, View paramView)
  {
    if (paramFrameLayout != null) {
      paramFrameLayout.setOnClickListener(new acjq(this));
    }
    if (paramView != null) {
      paramView.setOnClickListener(new acjr(this));
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Object localObject = null;
    paramBundle = (Bundle)localObject;
    if (getActivity() != null)
    {
      if (getActivity().getIntent() != null) {
        break label33;
      }
      paramBundle = (Bundle)localObject;
    }
    label33:
    do
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramBundle);
      return paramBundle;
      paramBundle = (Bundle)localObject;
    } while (!(getActivity().getIntent().getSerializableExtra("data") instanceof GdtAd));
    if ((getActivity().getIntent().getSerializableExtra("canvas_data") instanceof AdCanvasData)) {}
    for (paramBundle = (AdCanvasData)getActivity().getIntent().getSerializableExtra("canvas_data");; paramBundle = null)
    {
      localObject = (GdtAd)getActivity().getIntent().getSerializableExtra("data");
      localObject = getActivity().getIntent().getStringExtra("url");
      int i = getActivity().getIntent().getIntExtra("style", -2147483648);
      paramLayoutInflater = paramLayoutInflater.inflate(2131559268, paramViewGroup, false);
      paramViewGroup = (FrameLayout)paramLayoutInflater.findViewById(2131369772);
      FrameLayout localFrameLayout = (FrameLayout)paramLayoutInflater.findViewById(2131379356);
      View localView = paramLayoutInflater.findViewById(2131363323);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131379001));
      this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(AdUIUtils.dp2px(120.0F, getResources()));
      a(localFrameLayout, localView);
      a(i, paramBundle, (String)localObject, paramViewGroup);
      paramBundle = paramLayoutInflater;
      break;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Acko != null) {
      this.jdField_a_of_type_Acko.c();
    }
    if (this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView != null) {
      this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView.onActivityDestroy();
    }
    if (this.jdField_a_of_type_ComTencentBizUiTouchWebView != null)
    {
      ViewParent localViewParent = this.jdField_a_of_type_ComTencentBizUiTouchWebView.getParent();
      if ((localViewParent != null) && ((localViewParent instanceof ViewGroup))) {
        ((ViewGroup)localViewParent).removeAllViewsInLayout();
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_Acko != null) {
      this.jdField_a_of_type_Acko.b();
    }
    if (this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView != null) {
      this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView.onActivityPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Acko != null) {
      this.jdField_a_of_type_Acko.a();
    }
    if (this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView != null) {
      this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView.onActivityResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.halfScreen.GdtBaseHalfScreenFragment
 * JD-Core Version:    0.7.0.1
 */