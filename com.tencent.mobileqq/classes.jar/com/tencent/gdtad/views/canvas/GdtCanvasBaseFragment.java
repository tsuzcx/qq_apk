package com.tencent.gdtad.views.canvas;

import acqy;
import acsj;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import com.tencent.ad.tangram.canvas.views.canvas.AdCanvasData;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasView;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;

public abstract class GdtCanvasBaseFragment
  extends PublicBaseFragment
{
  protected static final String KEY_DATA = "data";
  private static final String KEY_FROM_PROCESS_NAME = "from_process_name";
  private static final String TAG = "GdtCanvasBaseFragment";
  private AdCanvasView contentView;
  
  public static void start(Activity paramActivity, Class<? extends GdtCanvasBaseFragment> paramClass, AdCanvasData paramAdCanvasData)
  {
    start(paramActivity, paramClass, paramAdCanvasData, null);
  }
  
  public static void start(Activity paramActivity, Class<? extends GdtCanvasBaseFragment> paramClass, AdCanvasData paramAdCanvasData, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramAdCanvasData == null) || (!paramAdCanvasData.isValid()))
    {
      acqy.b("GdtCanvasBaseFragment", "start error");
      return;
    }
    acqy.b("GdtCanvasBaseFragment", "start");
    Object localObject = new Bundle();
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      ((Bundle)localObject).putAll(paramBundle);
    }
    ((Bundle)localObject).putSerializable("data", paramAdCanvasData);
    paramBundle = new Intent();
    paramBundle.putExtra("public_fragment_window_feature", 1);
    paramBundle.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    paramBundle.putExtra("big_brother_source_key", "biz_src_ads");
    paramBundle.putExtras((Bundle)localObject);
    if (TextUtils.isEmpty(paramBundle.getStringExtra("big_brother_ref_source_key"))) {
      acqy.d("GdtCanvasBaseFragment", "start gdt empty refId");
    }
    localObject = AdProcessManager.INSTANCE.getCurrentProcessName(paramActivity);
    String str = AdProcessManager.INSTANCE.getMainProcessName();
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramBundle.putExtra("from_process_name", (String)localObject);
    }
    PublicFragmentActivity.a(paramActivity, paramBundle, paramClass);
    AdReporterForAnalysis.reportForStartActivity(paramActivity, paramAdCanvasData.ad, "GdtCanvasBaseFragment", str);
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
    if (this.contentView != null) {
      return this.contentView.back();
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = null;
    if ((getArguments() != null) && (getArguments().containsKey("from_process_name"))) {}
    for (paramLayoutInflater = getArguments().getString("from_process_name");; paramLayoutInflater = null)
    {
      AdReporterForAnalysis.reportForActivityStatusChanged(getActivity(), null, "GdtCanvasBaseFragment", 1, paramLayoutInflater);
      paramLayoutInflater = paramViewGroup;
      if (getArguments() != null) {
        if ((getArguments().getSerializable("data") instanceof AdCanvasData)) {
          break label76;
        }
      }
      for (paramLayoutInflater = paramViewGroup;; paramLayoutInflater = this.contentView)
      {
        V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
        return paramLayoutInflater;
        label76:
        paramLayoutInflater = (AdCanvasData)AdCanvasData.class.cast(getArguments().getSerializable("data"));
        if (!TextUtils.isEmpty(getArguments().getString("big_brother_ref_source_key"))) {
          paramLayoutInflater.sourceId = getArguments().getString("big_brother_ref_source_key");
        }
        this.contentView = new AdCanvasView(getActivity());
        acsj.a(this.contentView);
        this.contentView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.contentView.setData(paramLayoutInflater);
        if ((getActivity() != null) && (getActivity().getWindow() != null)) {
          getActivity().getWindow().setSoftInputMode(16);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.contentView != null) {
      this.contentView.onActivityDestroy();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.contentView != null) {
      this.contentView.onActivityPause();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.contentView != null) {
      this.contentView.onActivityResume();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.GdtCanvasBaseFragment
 * JD-Core Version:    0.7.0.1
 */