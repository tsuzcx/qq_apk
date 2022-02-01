package com.tencent.gdtad.api.motivevideo;

import acqn;
import acqo;
import acqx;
import acse;
import acsf;
import acsg;
import acsz;
import acvb;
import acvc;
import acwn;
import afez;
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
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.api.motivebrowsing.GdtMotiveBrowsingFragment;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
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
  private acsg jdField_a_of_type_Acsg;
  private acsz jdField_a_of_type_Acsz;
  private boolean jdField_a_of_type_Boolean;
  
  public GdtMotiveVideoFragment()
  {
    acvc.a("GdtMotiveVideoFragment", "GdtMotiveVideoFragment: ");
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Acsz == null) {
      this.jdField_a_of_type_Acsz = new acsz(new acsf(this), this.jdField_a_of_type_Acsg, false);
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
    this.jdField_a_of_type_Acsg = new acsg((GdtMotiveVideoPageData)GdtMotiveVideoPageData.class.cast(localObject));
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
      acvc.b("GdtMotiveVideoFragment", "start error data:" + paramGdtMotiveVideoPageData);
      return;
    }
    paramBundle.putSerializable("data", paramGdtMotiveVideoPageData);
    paramBundle.putString("big_brother_ref_source_key", paramGdtMotiveVideoPageData.refId);
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    localIntent.putExtras(paramBundle);
    if (TextUtils.isEmpty(localIntent.getStringExtra("big_brother_ref_source_key"))) {
      acvc.d("GdtMotiveVideoFragment", "start gdt empty refId");
    }
    if (a(paramGdtMotiveVideoPageData))
    {
      QLog.i("GdtMotiveVideoFragment", 1, "start motive browsing type = " + paramGdtMotiveVideoPageData.containerType);
      if (paramGdtMotiveVideoPageData.containerType == 1)
      {
        acqn.a.a(paramActivity, paramGdtMotiveVideoPageData, localIntent);
        return;
      }
      GdtMotiveBrowsingFragment.a.a(paramActivity, paramGdtMotiveVideoPageData, localIntent);
      return;
    }
    if (paramGdtMotiveVideoPageData.containerType == 1)
    {
      paramActivity.runOnUiThread(new GdtMotiveVideoFragment.1(paramActivity, localIntent, paramResultReceiver));
      return;
    }
    paramResultReceiver = AdProcessManager.INSTANCE.getCurrentProcessName(paramActivity);
    if (paramBoolean)
    {
      paramBundle = AdProcessManager.INSTANCE.getWebProcessName();
      if (!TextUtils.isEmpty(paramResultReceiver)) {
        localIntent.putExtra("from_process_name", paramResultReceiver);
      }
      if (!paramBoolean) {
        break label293;
      }
      if (paramGdtMotiveVideoPageData.screenOrientation != 0) {
        break label287;
      }
    }
    label287:
    for (paramClass = PublicFragmentActivityLandscapeForTool.class;; paramClass = PublicFragmentActivityForTool.class)
    {
      afez.a(paramActivity, localIntent, paramClass, GdtMotiveVideoFragment.class, 101);
      AdReporterForAnalysis.reportForStartActivity(paramActivity, null, "GdtMotiveVideoFragment", paramBundle);
      return;
      paramBundle = AdProcessManager.INSTANCE.getMainProcessName();
      break;
    }
    label293:
    if (paramGdtMotiveVideoPageData.screenOrientation == 0) {}
    for (paramGdtMotiveVideoPageData = PublicFragmentActivityLandscape.class;; paramGdtMotiveVideoPageData = PublicFragmentActivity.class)
    {
      afez.a(paramActivity, localIntent, paramGdtMotiveVideoPageData, paramClass, 101);
      break;
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
        paramGdtMotiveVideoPageData = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(acvb.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramGdtMotiveVideoPageData.adsContent))));
        AdReporterForAnalysis.reportForRewardedVideo(paramContext, paramGdtMotiveVideoPageData);
        return;
      }
      catch (Throwable paramGdtMotiveVideoPageData)
      {
        acvc.d("GdtMotiveVideoFragment", "reportForAnalysis", paramGdtMotiveVideoPageData);
      }
      paramGdtMotiveVideoPageData = null;
    }
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
    if ((this.jdField_a_of_type_Acsz != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      String str = "";
      if (getArguments() != null) {
        str = getArguments().getString("arg_callback", "");
      }
      this.jdField_a_of_type_Acsz.a(str);
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
      ((View)localObject).setOnSystemUiVisibilityChangeListener(new acse(this, (View)localObject));
    }
    paramActivity.setRequestedOrientation(this.jdField_a_of_type_Acsg.a().screenOrientation);
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
    if (this.jdField_a_of_type_Acsz != null) {
      return this.jdField_a_of_type_Acsz.c();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    acvc.b("GdtMotiveVideoFragment", "onCreate: ");
    if (this.jdField_a_of_type_Acsg == null) {
      return;
    }
    a();
    this.jdField_a_of_type_Acsz.m();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    Object localObject = null;
    if ((getArguments() != null) && (getArguments().containsKey("from_process_name"))) {}
    for (paramBundle = getArguments().getString("from_process_name");; paramBundle = null)
    {
      AdReporterForAnalysis.reportForActivityStatusChanged(getActivity(), null, "GdtMotiveVideoFragment", 1, paramBundle);
      if (this.jdField_a_of_type_Acsg == null) {}
      for (paramLayoutInflater = localObject;; paramLayoutInflater = this.jdField_a_of_type_Acsz.a(paramLayoutInflater, paramViewGroup))
      {
        V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
        return paramLayoutInflater;
        a();
        if ((this.jdField_a_of_type_Acsg.a().screenOrientation == 1) && (acwn.a(getActivity()))) {
          acwn.a(getActivity());
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Acsz != null) {
      this.jdField_a_of_type_Acsz.l();
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_Acsz != null) {
      this.jdField_a_of_type_Acsz.j();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    acvc.b("GdtMotiveVideoFragment", "onResume: ");
    if (this.jdField_a_of_type_Acsz != null) {
      this.jdField_a_of_type_Acsz.k();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment
 * JD-Core Version:    0.7.0.1
 */