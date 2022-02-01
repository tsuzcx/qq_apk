package com.tencent.gdtad.basics.motivevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingDialog;
import com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingDialog.Companion;
import com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingFragment;
import com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingFragment.Companion;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.data.StartGdtMotiveVideoParams;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.QPublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.QPublicFragmentActivityLandscape;
import com.tencent.mobileqq.activity.QPublicFragmentActivityLandscapeForTool;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class GdtMotiveVideoFragment
  extends QPublicBaseFragment
{
  private GdtMvViewController jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController;
  private GdtMotiveVideoModel jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel;
  private boolean jdField_a_of_type_Boolean = false;
  
  public GdtMotiveVideoFragment()
  {
    GdtLog.a("GdtMotiveVideoFragment", "GdtMotiveVideoFragment: ");
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController == null) {
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController = new GdtMvViewController(new GdtMotiveVideoFragment.3(this), this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel, false);
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
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel = new GdtMotiveVideoModel((GdtMotiveVideoPageData)GdtMotiveVideoPageData.class.cast(localObject));
  }
  
  private static void a(Context paramContext, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    if ((paramGdtMotiveVideoPageData != null) && (!TextUtils.isEmpty(paramGdtMotiveVideoPageData.adsContent))) {
      try
      {
        paramGdtMotiveVideoPageData = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramGdtMotiveVideoPageData.adsContent))));
      }
      catch (Throwable paramGdtMotiveVideoPageData)
      {
        GdtLog.d("GdtMotiveVideoFragment", "reportForAnalysis", paramGdtMotiveVideoPageData);
      }
    } else {
      paramGdtMotiveVideoPageData = null;
    }
    AdAnalysisHelperForUtil.reportForRewardedVideo(paramContext, paramGdtMotiveVideoPageData);
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
  
  public static void a(StartGdtMotiveVideoParams paramStartGdtMotiveVideoParams)
  {
    Activity localActivity = paramStartGdtMotiveVideoParams.jdField_a_of_type_AndroidAppActivity;
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = paramStartGdtMotiveVideoParams.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoPageData;
    Bundle localBundle = paramStartGdtMotiveVideoParams.jdField_a_of_type_AndroidOsBundle;
    boolean bool = paramStartGdtMotiveVideoParams.jdField_a_of_type_Boolean;
    ResultReceiver localResultReceiver = paramStartGdtMotiveVideoParams.jdField_a_of_type_AndroidOsResultReceiver;
    int i = paramStartGdtMotiveVideoParams.jdField_a_of_type_Int;
    a(localActivity, localGdtMotiveVideoPageData);
    if ((localActivity != null) && (localGdtMotiveVideoPageData != null) && (localBundle != null))
    {
      localBundle.putSerializable("data", localGdtMotiveVideoPageData);
      localBundle.putString("big_brother_ref_source_key", localGdtMotiveVideoPageData.refId);
      Intent localIntent = new Intent();
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      localIntent.putExtras(localBundle);
      if (TextUtils.isEmpty(localIntent.getStringExtra("big_brother_ref_source_key"))) {
        GdtLog.d("GdtMotiveVideoFragment", "start gdt empty refId");
      }
      if (a(localGdtMotiveVideoPageData))
      {
        paramStartGdtMotiveVideoParams = new StringBuilder();
        paramStartGdtMotiveVideoParams.append("start motive browsing type = ");
        paramStartGdtMotiveVideoParams.append(localGdtMotiveVideoPageData.containerType);
        QLog.i("GdtMotiveVideoFragment", 1, paramStartGdtMotiveVideoParams.toString());
        if (localGdtMotiveVideoPageData.containerType == 1) {
          GdtMotiveBrowsingDialog.a.a(localActivity, localGdtMotiveVideoPageData, localIntent);
        } else {
          GdtMotiveBrowsingFragment.a.a(localActivity, localGdtMotiveVideoPageData, localIntent);
        }
        GdtADFlyingStreamingReportHelper.a().a(3);
        return;
      }
      if (localGdtMotiveVideoPageData.containerType == 1)
      {
        localActivity.runOnUiThread(new GdtMotiveVideoFragment.1(localActivity, localIntent, localResultReceiver));
        return;
      }
      if (bool)
      {
        if (localGdtMotiveVideoPageData.screenOrientation == 0) {
          paramStartGdtMotiveVideoParams = QPublicFragmentActivityLandscapeForTool.class;
        } else {
          paramStartGdtMotiveVideoParams = QPublicFragmentActivityForTool.class;
        }
        QPublicFragmentActivity.Launcher.a(localActivity, localIntent, paramStartGdtMotiveVideoParams, GdtMotiveVideoFragment.class, i);
        return;
      }
      if (localGdtMotiveVideoPageData.screenOrientation == 0) {
        paramStartGdtMotiveVideoParams = QPublicFragmentActivityLandscape.class;
      } else {
        paramStartGdtMotiveVideoParams = QPublicFragmentActivity.class;
      }
      QPublicFragmentActivity.Launcher.a(localActivity, localIntent, paramStartGdtMotiveVideoParams, GdtMotiveVideoFragment.class, i);
      return;
    }
    paramStartGdtMotiveVideoParams = new StringBuilder();
    paramStartGdtMotiveVideoParams.append("start error data:");
    paramStartGdtMotiveVideoParams.append(localGdtMotiveVideoPageData);
    GdtLog.b("GdtMotiveVideoFragment", paramStartGdtMotiveVideoParams.toString());
  }
  
  private static boolean a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    return (paramGdtMotiveVideoPageData != null) && (paramGdtMotiveVideoPageData.vSize != 585) && (paramGdtMotiveVideoPageData.vSize != 185);
  }
  
  public void beforeFinish()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      Bundle localBundle = getArguments();
      String str = "";
      if (localBundle != null) {
        str = getArguments().getString("arg_callback", "");
      }
      this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController.a(str);
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
    paramActivity.setRequestedOrientation(this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a().screenOrientation);
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
    GdtMvViewController localGdtMvViewController = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController;
    if (localGdtMvViewController != null) {
      return localGdtMvViewController.c();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    GdtLog.b("GdtMotiveVideoFragment", "onCreate: ");
    if (this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel == null) {
      return;
    }
    a();
    this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController.i();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel == null)
    {
      paramLayoutInflater = null;
    }
    else
    {
      a();
      if ((this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoDataGdtMotiveVideoModel.a().screenOrientation == 1) && (GdtUIUtils.a(getQBaseActivity()))) {
        GdtUIUtils.a(getQBaseActivity());
      }
      paramLayoutInflater = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController.a(paramLayoutInflater, paramViewGroup);
    }
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    GdtMvViewController localGdtMvViewController = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController;
    if (localGdtMvViewController != null) {
      localGdtMvViewController.h();
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
    GdtMvViewController localGdtMvViewController = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController;
    if (localGdtMvViewController != null) {
      localGdtMvViewController.f();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    GdtLog.b("GdtMotiveVideoFragment", "onResume: ");
    GdtMvViewController localGdtMvViewController = this.jdField_a_of_type_ComTencentGdtadBasicsMotivevideoGdtMvViewController;
    if (localGdtMvViewController != null) {
      localGdtMvViewController.g();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19)) {
      getQBaseActivity().getWindow().getDecorView().setSystemUiVisibility(7942);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoFragment
 * JD-Core Version:    0.7.0.1
 */