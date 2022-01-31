package com.tencent.gdtad.views.canvas;

import aase;
import aatp;
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
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;

public abstract class GdtCanvasBaseFragment
  extends PublicBaseFragment
{
  protected static final String KEY_DATA = "data";
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
      aase.b("GdtCanvasBaseFragment", "start error");
      return;
    }
    aase.b("GdtCanvasBaseFragment", "start");
    Bundle localBundle = new Bundle();
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putSerializable("data", paramAdCanvasData);
    paramBundle = new Intent();
    paramBundle.putExtra("public_fragment_window_feature", 1);
    paramBundle.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    paramBundle.putExtra("big_brother_source_key", "biz_src_ads");
    paramBundle.putExtras(localBundle);
    if (TextUtils.isEmpty(paramBundle.getStringExtra("big_brother_ref_source_key"))) {
      aase.d("GdtCanvasBaseFragment", "start gdt empty refId");
    }
    PublicFragmentActivity.a(paramActivity, paramBundle, paramClass);
    AdReporterForAnalysis.reportForStartActivity(paramActivity, paramAdCanvasData.ad, "GdtCanvasBaseFragment");
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
    AdReporterForAnalysis.reportForActivityStatusChanged(getActivity(), null, "GdtCanvasBaseFragment", 1);
    if ((getArguments() == null) || (!(getArguments().getSerializable("data") instanceof AdCanvasData))) {
      return null;
    }
    paramLayoutInflater = (AdCanvasData)AdCanvasData.class.cast(getArguments().getSerializable("data"));
    if (!TextUtils.isEmpty(getArguments().getString("big_brother_ref_source_key"))) {
      paramLayoutInflater.sourceId = getArguments().getString("big_brother_ref_source_key");
    }
    this.contentView = new AdCanvasView(getActivity());
    aatp.a(this.contentView);
    this.contentView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.contentView.setData(paramLayoutInflater);
    if ((getActivity() != null) && (getActivity().getWindow() != null)) {
      getActivity().getWindow().setSoftInputMode(16);
    }
    return this.contentView;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.GdtCanvasBaseFragment
 * JD-Core Version:    0.7.0.1
 */