package com.tencent.gdtad.views.canvas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.ad.tangram.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.views.canvas.framework.AdCanvasView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.statistics.GdtActionReporter;
import com.tencent.gdtad.statistics.GdtActionReporter.Params;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import tencent.gdt.landing_page_collect_data.LandingPageCollectData;

public final class GdtCanvasFragment
  extends PublicBaseFragment
{
  private AdCanvasView a;
  
  private void a()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((AdCanvasView)localObject).getData() != null) && (this.a.getData().isValid()))
    {
      localObject = new GdtActionReporter.Params();
      ((GdtActionReporter.Params)localObject).a = this.a.getData().ad;
      ((GdtActionReporter.Params)localObject).b.landing_page_action_type.set(102);
      GdtActionReporter.a((GdtActionReporter.Params)localObject);
      return;
    }
    GdtLog.d("GdtCanvasFragment", "reportStartEndForAction error");
  }
  
  public static void a(Activity paramActivity, AdCanvasData paramAdCanvasData, Bundle paramBundle)
  {
    if ((paramActivity != null) && (paramAdCanvasData != null) && (paramAdCanvasData.isValid()))
    {
      GdtLog.b("GdtCanvasFragment", "start");
      Bundle localBundle = new Bundle();
      if ((paramBundle != null) && (!paramBundle.isEmpty())) {
        localBundle.putAll(paramBundle);
      }
      localBundle.putSerializable("data", paramAdCanvasData);
      paramAdCanvasData = new Intent();
      paramAdCanvasData.putExtra("public_fragment_window_feature", 1);
      paramAdCanvasData.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      paramAdCanvasData.putExtra("big_brother_source_key", "biz_src_ads");
      paramAdCanvasData.putExtras(localBundle);
      if (TextUtils.isEmpty(paramAdCanvasData.getStringExtra("big_brother_ref_source_key"))) {
        GdtLog.d("GdtCanvasFragment", "start gdt empty refId");
      }
      PublicFragmentActivity.a(paramActivity, paramAdCanvasData, GdtCanvasFragment.class);
      return;
    }
    GdtLog.b("GdtCanvasFragment", "start error");
  }
  
  private void b()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((AdCanvasView)localObject).getData() != null) && (this.a.getData().isValid()))
    {
      localObject = new GdtActionReporter.Params();
      ((GdtActionReporter.Params)localObject).a = this.a.getData().ad;
      ((GdtActionReporter.Params)localObject).b.landing_page_action_type.set(103);
      GdtActionReporter.a((GdtActionReporter.Params)localObject);
      return;
    }
    GdtLog.d("GdtCanvasFragment", "reportEndForAction error");
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.setRequestedOrientation(1);
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return false;
  }
  
  public boolean onBackEvent()
  {
    AdCanvasView localAdCanvasView = this.a;
    if (localAdCanvasView != null) {
      return localAdCanvasView.back();
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((getArguments() != null) && ((getArguments().getSerializable("data") instanceof AdCanvasData)))
    {
      paramLayoutInflater = (AdCanvasData)AdCanvasData.class.cast(getArguments().getSerializable("data"));
      if (!TextUtils.isEmpty(getArguments().getString("big_brother_ref_source_key"))) {
        paramLayoutInflater.sourceId = getArguments().getString("big_brother_ref_source_key");
      }
      this.a = new AdCanvasView(getBaseActivity());
      GdtUIUtils.a(this.a);
      this.a.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.a.setData(paramLayoutInflater);
      if ((getBaseActivity() != null) && (getBaseActivity().getWindow() != null)) {
        getBaseActivity().getWindow().setSoftInputMode(16);
      }
      a();
      paramLayoutInflater = this.a;
    }
    else
    {
      paramLayoutInflater = null;
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    b();
    AdCanvasView localAdCanvasView = this.a;
    if (localAdCanvasView != null) {
      localAdCanvasView.onActivityDestroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    AdCanvasView localAdCanvasView = this.a;
    if (localAdCanvasView != null) {
      localAdCanvasView.onActivityPause();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    AdCanvasView localAdCanvasView = this.a;
    if (localAdCanvasView != null) {
      localAdCanvasView.onActivityResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.GdtCanvasFragment
 * JD-Core Version:    0.7.0.1
 */