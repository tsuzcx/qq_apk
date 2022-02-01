package com.tencent.gdtad.views.halfScreen;

import acqy;
import acte;
import actf;
import actg;
import acuc;
import aevv;
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
import bhmg;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasView;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
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
  public static String a;
  private acuc jdField_a_of_type_Acuc;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private AdCanvasView jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView;
  private TouchWebView jdField_a_of_type_ComTencentBizUiTouchWebView;
  
  static
  {
    jdField_a_of_type_JavaLangString = "key_from_process_name";
  }
  
  private void a(int paramInt, AdCanvasData paramAdCanvasData, String paramString, FrameLayout paramFrameLayout)
  {
    if (paramInt == 2)
    {
      if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (!TextUtils.isEmpty(paramAdCanvasData.pageTitle))) {
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
    this.jdField_a_of_type_Acuc = new actg(this, getActivity(), getActivity(), null, paramAdCanvasData);
    this.jdField_a_of_type_Acuc.a(this.jdField_a_of_type_ComTencentBizUiTouchWebView);
    new bhmg(this.jdField_a_of_type_Acuc).a(null, paramAdCanvasData, getActivity().getIntent());
    this.jdField_a_of_type_ComTencentBizUiTouchWebView.loadUrl(paramString);
  }
  
  public static void a(Activity paramActivity, Class<? extends GdtBaseHalfScreenFragment> paramClass, Ad paramAd, AdCanvasData paramAdCanvasData, String paramString, int paramInt, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramAd == null) || (!paramAd.isValid()))
    {
      acqy.d("GdtBaseHalfScreenFragment", "start error");
      return;
    }
    acqy.b("GdtBaseHalfScreenFragment", "start GdtBaseHalfScreenFragment" + paramInt);
    Bundle localBundle = new Bundle();
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putSerializable("data", (GdtAd)paramAd);
    paramBundle = new Intent();
    paramBundle.putExtra("public_fragment_window_feature", 1);
    paramBundle.putExtra("big_brother_source_key", "biz_src_ads");
    paramBundle.putExtras(localBundle);
    paramBundle.putExtra("url", paramString);
    paramBundle.putExtra("canvas_data", paramAdCanvasData);
    paramBundle.putExtra("style", paramInt);
    if (TextUtils.isEmpty(paramBundle.getStringExtra("big_brother_ref_source_key"))) {
      acqy.d("GdtBaseHalfScreenFragment", "start gdt empty refId");
    }
    paramString = AdProcessManager.INSTANCE.getCurrentProcessName(paramActivity);
    if (paramInt == 2)
    {
      paramAdCanvasData = AdProcessManager.INSTANCE.getMainProcessName();
      if (!TextUtils.isEmpty(paramString)) {
        paramBundle.putExtra(jdField_a_of_type_JavaLangString, paramString);
      }
      if (paramInt != 2) {
        break label250;
      }
      aevv.a(paramActivity, paramBundle, PublicTransFragmentActivity.class, paramClass);
    }
    for (;;)
    {
      AdReporterForAnalysis.reportForStartActivity(paramActivity, paramAd, "GdtBaseHalfScreenFragment", paramAdCanvasData);
      return;
      paramAdCanvasData = AdProcessManager.INSTANCE.getWebProcessName();
      break;
      label250:
      aevv.a(paramActivity, paramBundle, PublicTransFragmentActivityForTool.class, paramClass);
    }
  }
  
  private void a(FrameLayout paramFrameLayout, View paramView)
  {
    if (paramFrameLayout != null) {
      paramFrameLayout.setOnClickListener(new acte(this));
    }
    if (paramView != null) {
      paramView.setOnClickListener(new actf(this));
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
      String str = getActivity().getIntent().getStringExtra("url");
      int i = getActivity().getIntent().getIntExtra("style", -2147483648);
      if ((getArguments() != null) && (getArguments().containsKey(jdField_a_of_type_JavaLangString))) {}
      for (localObject = getArguments().getString(jdField_a_of_type_JavaLangString);; localObject = null)
      {
        AdReporterForAnalysis.reportForActivityStatusChanged(getActivity(), null, "GdtBaseHalfScreenFragment", 1, (String)localObject);
        paramLayoutInflater = paramLayoutInflater.inflate(2131559223, paramViewGroup, false);
        paramViewGroup = (FrameLayout)paramLayoutInflater.findViewById(2131369520);
        localObject = (FrameLayout)paramLayoutInflater.findViewById(2131379126);
        View localView = paramLayoutInflater.findViewById(2131363205);
        this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378776));
        this.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(AdUIUtils.dp2px(120.0F, getResources()));
        a((FrameLayout)localObject, localView);
        a(i, paramBundle, str, paramViewGroup);
        paramBundle = paramLayoutInflater;
        break;
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_Acuc != null) {
      this.jdField_a_of_type_Acuc.c();
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
    if (this.jdField_a_of_type_Acuc != null) {
      this.jdField_a_of_type_Acuc.b();
    }
    if (this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView != null) {
      this.jdField_a_of_type_ComTencentAdTangramCanvasViewsCanvasFrameworkAdCanvasView.onActivityPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Acuc != null) {
      this.jdField_a_of_type_Acuc.a();
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