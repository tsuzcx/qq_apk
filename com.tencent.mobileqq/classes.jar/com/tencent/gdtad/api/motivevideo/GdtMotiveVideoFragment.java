package com.tencent.gdtad.api.motivevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingDialog;
import com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingDialog.Companion;
import com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingFragment;
import com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingFragment.Companion;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.PublicFragmentActivityLandscape;
import com.tencent.mobileqq.activity.PublicFragmentActivityLandscapeForTool;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class GdtMotiveVideoFragment
  extends PublicBaseFragment
{
  private GdtMotiveVideoModel jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel;
  private GdtMvViewController jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController;
  private boolean jdField_a_of_type_Boolean = false;
  
  public GdtMotiveVideoFragment()
  {
    GdtLog.a("GdtMotiveVideoFragment", "GdtMotiveVideoFragment: ");
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController == null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController = new GdtMvViewController(new GdtMotiveVideoFragment.3(this), this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel, false);
    }
  }
  
  private void a(Activity paramActivity)
  {
    Object localObject = getArguments();
    if (localObject == null)
    {
      paramActivity.finish();
      return;
    }
    localObject = ((Bundle)localObject).getSerializable("data");
    if (!(localObject instanceof GdtMotiveVideoPageData))
    {
      paramActivity.finish();
      return;
    }
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel = new GdtMotiveVideoModel((GdtMotiveVideoPageData)GdtMotiveVideoPageData.class.cast(localObject));
  }
  
  public static void a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    a(paramActivity, paramClass, paramGdtMotiveVideoPageData, new Bundle(), false, null);
  }
  
  private static void a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, Bundle paramBundle, boolean paramBoolean, ResultReceiver paramResultReceiver)
  {
    a(paramActivity, paramGdtMotiveVideoPageData);
    if ((paramActivity == null) || (paramGdtMotiveVideoPageData == null) || (paramBundle == null))
    {
      GdtLog.b("GdtMotiveVideoFragment", "start error data:" + paramGdtMotiveVideoPageData);
      return;
    }
    paramBundle.putSerializable("data", paramGdtMotiveVideoPageData);
    paramBundle.putString("big_brother_ref_source_key", paramGdtMotiveVideoPageData.refId);
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    localIntent.putExtras(paramBundle);
    if (TextUtils.isEmpty(localIntent.getStringExtra("big_brother_ref_source_key"))) {
      GdtLog.d("GdtMotiveVideoFragment", "start gdt empty refId");
    }
    if (a(paramGdtMotiveVideoPageData))
    {
      QLog.i("GdtMotiveVideoFragment", 1, "start motive browsing type = " + paramGdtMotiveVideoPageData.containerType);
      if (paramGdtMotiveVideoPageData.containerType == 1) {
        GdtMotiveBrowsingDialog.a.a(paramActivity, paramGdtMotiveVideoPageData, localIntent);
      }
      for (;;)
      {
        GdtADFlyingStreamingReportHelper.a().a(3);
        return;
        GdtMotiveBrowsingFragment.a.a(paramActivity, paramGdtMotiveVideoPageData, localIntent);
      }
    }
    if (paramGdtMotiveVideoPageData.containerType == 1)
    {
      paramActivity.runOnUiThread(new GdtMotiveVideoFragment.1(paramActivity, localIntent, paramResultReceiver));
      return;
    }
    if (paramBoolean)
    {
      if (paramGdtMotiveVideoPageData.screenOrientation == 0) {}
      for (paramClass = PublicFragmentActivityLandscapeForTool.class;; paramClass = PublicFragmentActivityForTool.class)
      {
        PublicFragmentActivity.Launcher.a(paramActivity, localIntent, paramClass, GdtMotiveVideoFragment.class, 101);
        return;
      }
    }
    if (paramGdtMotiveVideoPageData.screenOrientation == 0) {}
    for (paramGdtMotiveVideoPageData = PublicFragmentActivityLandscape.class;; paramGdtMotiveVideoPageData = PublicFragmentActivity.class)
    {
      PublicFragmentActivity.Launcher.a(paramActivity, localIntent, paramGdtMotiveVideoPageData, paramClass, 101);
      return;
    }
  }
  
  public static void a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, ResultReceiver paramResultReceiver)
  {
    a(paramActivity, paramClass, paramGdtMotiveVideoPageData, new Bundle(), false, paramResultReceiver);
  }
  
  public static void a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("arg_callback", paramString);
    a(paramActivity, paramClass, paramGdtMotiveVideoPageData, localBundle, false, null);
  }
  
  private static void a(Context paramContext, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    if ((paramGdtMotiveVideoPageData != null) && (!TextUtils.isEmpty(paramGdtMotiveVideoPageData.adsContent))) {}
    for (;;)
    {
      try
      {
        paramGdtMotiveVideoPageData = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramGdtMotiveVideoPageData.adsContent))));
        AdReporterForAnalysis.reportForRewardedVideo(paramContext, paramGdtMotiveVideoPageData);
        return;
      }
      catch (Throwable paramGdtMotiveVideoPageData)
      {
        GdtLog.d("GdtMotiveVideoFragment", "reportForAnalysis", paramGdtMotiveVideoPageData);
      }
      paramGdtMotiveVideoPageData = null;
    }
  }
  
  public static void a(ResultReceiver paramResultReceiver)
  {
    if (paramResultReceiver == null)
    {
      QLog.i("GdtMotiveVideoFragment", 1, "onGdtMotiveVideoFailed resultReceiver == null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("duration_time", 0);
    localIntent.putExtra("elapsed_time", 0);
    localIntent.putExtra("profitable_flag", false);
    localIntent.putExtra("is_end", false);
    paramResultReceiver.send(-1, localIntent.getExtras());
  }
  
  private static boolean a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    return (paramGdtMotiveVideoPageData != null) && (paramGdtMotiveVideoPageData.vSize != 585) && (paramGdtMotiveVideoPageData.vSize != 185);
  }
  
  public static void b(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    a(paramActivity, paramClass, paramGdtMotiveVideoPageData, new Bundle(), true, null);
  }
  
  public void beforeFinish()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      String str = "";
      if (getArguments() != null) {
        str = getArguments().getString("arg_callback", "");
      }
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.a(str);
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    a(paramActivity);
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    Object localObject = paramActivity.getWindow();
    ((Window)localObject).setFlags(1024, 1024);
    localObject = ((Window)localObject).getDecorView();
    ((View)localObject).setSystemUiVisibility(7942);
    if (Build.VERSION.SDK_INT >= 19) {
      ((View)localObject).setOnSystemUiVisibilityChangeListener(new GdtMotiveVideoFragment.2(this, (View)localObject));
    }
    paramActivity.setRequestedOrientation(this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a().screenOrientation);
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
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController != null) {
      return this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.c();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    GdtLog.b("GdtMotiveVideoFragment", "onCreate: ");
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel == null) {
      return;
    }
    a();
    this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.k();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel == null) {}
    for (paramLayoutInflater = null;; paramLayoutInflater = this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.a(paramLayoutInflater, paramViewGroup))
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      a();
      if ((this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMotiveVideoModel.a().screenOrientation == 1) && (GdtUIUtils.a(getActivity()))) {
        GdtUIUtils.a(getActivity());
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.j();
    }
    GdtADFlyingStreamingReportHelper.a().a();
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.h();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    GdtLog.b("GdtMotiveVideoFragment", "onResume: ");
    if (this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController != null) {
      this.jdField_a_of_type_ComTencentGdtadApiMotivevideoGdtMvViewController.i();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19)) {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(7942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment
 * JD-Core Version:    0.7.0.1
 */