package com.tencent.gdtad.views.canvas;

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
import com.tencent.gdtad.views.canvas.framework.GdtCanvasView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import yny;
import ypk;

public abstract class GdtCanvasBaseFragment
  extends PublicBaseFragment
{
  protected static final String KEY_DATA = "data";
  private static final String TAG = "GdtCanvasBaseFragment";
  private GdtCanvasView contentView;
  
  public static void start(Activity paramActivity, Class<? extends GdtCanvasBaseFragment> paramClass, GdtCanvasData paramGdtCanvasData)
  {
    start(paramActivity, paramClass, paramGdtCanvasData, null);
  }
  
  public static void start(Activity paramActivity, Class<? extends GdtCanvasBaseFragment> paramClass, GdtCanvasData paramGdtCanvasData, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramGdtCanvasData == null) || (!paramGdtCanvasData.isValid()))
    {
      yny.b("GdtCanvasBaseFragment", "start error");
      return;
    }
    yny.b("GdtCanvasBaseFragment", "start");
    Bundle localBundle = new Bundle();
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      localBundle.putAll(paramBundle);
    }
    localBundle.putSerializable("data", paramGdtCanvasData);
    paramGdtCanvasData = new Intent();
    paramGdtCanvasData.putExtra("public_fragment_window_feature", 1);
    paramGdtCanvasData.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    paramGdtCanvasData.putExtra("big_brother_source_key", "biz_src_ads");
    paramGdtCanvasData.putExtras(localBundle);
    if (TextUtils.isEmpty(paramGdtCanvasData.getStringExtra("big_brother_ref_source_key"))) {
      yny.d("GdtCanvasBaseFragment", "start gdt empty refId");
    }
    PublicFragmentActivity.a(paramActivity, paramGdtCanvasData, paramClass);
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
      return this.contentView.a();
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((getArguments() == null) || (!(getArguments().getSerializable("data") instanceof GdtCanvasData))) {
      return null;
    }
    paramLayoutInflater = (GdtCanvasData)GdtCanvasData.class.cast(getArguments().getSerializable("data"));
    if (!TextUtils.isEmpty(getArguments().getString("big_brother_ref_source_key"))) {
      paramLayoutInflater.sourceId = getArguments().getString("big_brother_ref_source_key");
    }
    this.contentView = new GdtCanvasView(getActivity());
    ypk.a(this.contentView);
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
      this.contentView.a();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    if (this.contentView != null) {
      this.contentView.c();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.contentView != null) {
      this.contentView.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.GdtCanvasBaseFragment
 * JD-Core Version:    0.7.0.1
 */