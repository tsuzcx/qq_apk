package com.tencent.gdtad.basics.motivevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
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
import java.io.Serializable;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class GdtMotiveVideoFragment
  extends QPublicBaseFragment
{
  private GdtMvViewController a;
  private GdtMotiveVideoModel b;
  private FrameLayout c;
  private GdtMotiveVideoPageData d;
  private boolean e = false;
  private GdtMvViewController.Listener f = new GdtMotiveVideoFragment.1(this);
  private boolean g;
  
  public GdtMotiveVideoFragment()
  {
    GdtLog.a("GdtMotiveVideoFragment", "GdtMotiveVideoFragment: ");
  }
  
  private static GdtMotiveVideoPageData a(@Nullable Serializable paramSerializable)
  {
    if (!(paramSerializable instanceof GdtMotiveVideoPageData)) {
      return null;
    }
    return (GdtMotiveVideoPageData)paramSerializable;
  }
  
  private void a()
  {
    if ((this.a == null) || (this.g))
    {
      this.g = false;
      this.a = new GdtMvViewController(new GdtMotiveVideoFragment.4(this), this.b, false);
    }
  }
  
  private void a(Activity paramActivity)
  {
    Bundle localBundle = getArguments();
    if (localBundle == null)
    {
      paramActivity.finish();
      return;
    }
    GdtMotiveVideoPageData localGdtMotiveVideoPageData = a(localBundle.getSerializable("data"));
    if (localGdtMotiveVideoPageData == null)
    {
      paramActivity.finish();
      return;
    }
    this.b = new GdtMotiveVideoModel(localGdtMotiveVideoPageData);
    this.d = a(localBundle.getSerializable("second_data"));
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
    if ((paramStartGdtMotiveVideoParams != null) && (paramStartGdtMotiveVideoParams.a != null) && (paramStartGdtMotiveVideoParams.b != null) && (paramStartGdtMotiveVideoParams.f != null))
    {
      Activity localActivity = paramStartGdtMotiveVideoParams.a;
      GdtMotiveVideoPageData localGdtMotiveVideoPageData = paramStartGdtMotiveVideoParams.b;
      Object localObject = paramStartGdtMotiveVideoParams.c;
      Bundle localBundle = paramStartGdtMotiveVideoParams.f;
      boolean bool = paramStartGdtMotiveVideoParams.e;
      ResultReceiver localResultReceiver = paramStartGdtMotiveVideoParams.d;
      int i = paramStartGdtMotiveVideoParams.g;
      a(localActivity, localGdtMotiveVideoPageData);
      localBundle.putSerializable("data", localGdtMotiveVideoPageData);
      localBundle.putSerializable("second_data", (Serializable)localObject);
      localBundle.putString("big_brother_ref_source_key", localGdtMotiveVideoPageData.refId);
      localObject = new Intent();
      ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
      ((Intent)localObject).putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      ((Intent)localObject).putExtras(localBundle);
      if (TextUtils.isEmpty(((Intent)localObject).getStringExtra("big_brother_ref_source_key"))) {
        GdtLog.d("GdtMotiveVideoFragment", "start gdt empty refId");
      }
      if (a(localGdtMotiveVideoPageData))
      {
        paramStartGdtMotiveVideoParams = new StringBuilder();
        paramStartGdtMotiveVideoParams.append("start motive browsing type = ");
        paramStartGdtMotiveVideoParams.append(localGdtMotiveVideoPageData.containerType);
        QLog.i("GdtMotiveVideoFragment", 1, paramStartGdtMotiveVideoParams.toString());
        if (localGdtMotiveVideoPageData.containerType == 1) {
          GdtMotiveBrowsingDialog.a.a(localActivity, localGdtMotiveVideoPageData, (Intent)localObject);
        } else {
          GdtMotiveBrowsingFragment.a.a(localActivity, localGdtMotiveVideoPageData, (Intent)localObject);
        }
        GdtADFlyingStreamingReportHelper.a().a(3);
        return;
      }
      if (localGdtMotiveVideoPageData.containerType == 1)
      {
        localActivity.runOnUiThread(new GdtMotiveVideoFragment.2(localActivity, (Intent)localObject, localResultReceiver));
        return;
      }
      if (bool)
      {
        if (localGdtMotiveVideoPageData.screenOrientation == 0) {
          paramStartGdtMotiveVideoParams = QPublicFragmentActivityLandscapeForTool.class;
        } else {
          paramStartGdtMotiveVideoParams = QPublicFragmentActivityForTool.class;
        }
        QPublicFragmentActivity.Launcher.a(localActivity, (Intent)localObject, paramStartGdtMotiveVideoParams, GdtMotiveVideoFragment.class, i);
        return;
      }
      if (localGdtMotiveVideoPageData.screenOrientation == 0) {
        paramStartGdtMotiveVideoParams = QPublicFragmentActivityLandscape.class;
      } else {
        paramStartGdtMotiveVideoParams = QPublicFragmentActivity.class;
      }
      QPublicFragmentActivity.Launcher.a(localActivity, (Intent)localObject, paramStartGdtMotiveVideoParams, GdtMotiveVideoFragment.class, i);
      return;
    }
    GdtLog.b("GdtMotiveVideoFragment", "[start] error params");
  }
  
  private static boolean a(GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    return (paramGdtMotiveVideoPageData != null) && (paramGdtMotiveVideoPageData.vSize != 585) && (paramGdtMotiveVideoPageData.vSize != 185);
  }
  
  @Nullable
  public View a(@NonNull LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, int paramInt)
  {
    if (this.b == null) {
      return null;
    }
    a();
    this.a.a(paramInt);
    if (this.d != null) {
      this.a.d(true);
    }
    this.a.n();
    if ((this.b.a().screenOrientation == 1) && (GdtUIUtils.b(getQBaseActivity()))) {
      GdtUIUtils.c(getQBaseActivity());
    }
    this.a.a(new WeakReference(this.f));
    return this.a.a(paramLayoutInflater, paramViewGroup);
  }
  
  public void beforeFinish()
  {
    if ((this.a != null) && (!this.e))
    {
      this.e = true;
      Bundle localBundle = getArguments();
      String str = "";
      if (localBundle != null) {
        str = getArguments().getString("arg_callback", "");
      }
      this.a.a(str);
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
      ((View)localObject).setOnSystemUiVisibilityChangeListener(new GdtMotiveVideoFragment.3(this, (View)localObject));
    }
    paramActivity.setRequestedOrientation(this.b.a().screenOrientation);
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
    GdtMvViewController localGdtMvViewController = this.a;
    if (localGdtMvViewController != null) {
      return localGdtMvViewController.f();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    GdtLog.b("GdtMotiveVideoFragment", "onCreate: ");
    if (this.b == null) {
      return;
    }
    a();
    this.a.n();
  }
  
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = new FrameLayout(paramLayoutInflater.getContext());
    paramLayoutInflater = a(paramLayoutInflater, this.c, 1);
    this.c.addView(paramLayoutInflater);
    paramLayoutInflater = this.c;
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    GdtMvViewController localGdtMvViewController = this.a;
    if (localGdtMvViewController != null) {
      localGdtMvViewController.m();
    }
    GdtADFlyingStreamingReportHelper.a().c();
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
  }
  
  public void onPause()
  {
    GdtMvViewController localGdtMvViewController = this.a;
    if (localGdtMvViewController != null) {
      localGdtMvViewController.k();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    GdtLog.b("GdtMotiveVideoFragment", "onResume: ");
    GdtMvViewController localGdtMvViewController = this.a;
    if (localGdtMvViewController != null) {
      localGdtMvViewController.l();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMotiveVideoFragment
 * JD-Core Version:    0.7.0.1
 */