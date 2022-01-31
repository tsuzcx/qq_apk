package com.tencent.gdtad.api.motivevideo;

import aapk;
import aapl;
import aapm;
import aaqa;
import aasd;
import aase;
import aatp;
import adpn;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.activity.PublicFragmentActivityLandscape;
import com.tencent.mobileqq.activity.PublicFragmentActivityLandscapeForTool;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;

public class GdtMotiveVideoFragment
  extends PublicBaseFragment
{
  private aapm jdField_a_of_type_Aapm;
  private aaqa jdField_a_of_type_Aaqa;
  private boolean jdField_a_of_type_Boolean;
  
  public GdtMotiveVideoFragment()
  {
    aase.a("GdtMotiveVideoFragment", "GdtMotiveVideoFragment: ");
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Aaqa == null) {
      this.jdField_a_of_type_Aaqa = new aaqa(new aapl(this), this.jdField_a_of_type_Aapm, false);
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
    this.jdField_a_of_type_Aapm = new aapm((GdtMotiveVideoPageData)GdtMotiveVideoPageData.class.cast(localObject));
  }
  
  public static void a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    a(paramActivity, paramClass, paramGdtMotiveVideoPageData, new Bundle(), false);
  }
  
  private static void a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, Bundle paramBundle, boolean paramBoolean)
  {
    a(paramActivity, paramGdtMotiveVideoPageData);
    if ((paramActivity == null) || (paramGdtMotiveVideoPageData == null) || (paramBundle == null) || (!aatp.a(paramGdtMotiveVideoPageData.vSize)))
    {
      aase.b("GdtMotiveVideoFragment", "start error data:" + paramGdtMotiveVideoPageData);
      return;
    }
    paramBundle.putSerializable("data", paramGdtMotiveVideoPageData);
    paramBundle.putString("big_brother_ref_source_key", paramGdtMotiveVideoPageData.refId);
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    localIntent.putExtras(paramBundle);
    if (TextUtils.isEmpty(localIntent.getStringExtra("big_brother_ref_source_key"))) {
      aase.d("GdtMotiveVideoFragment", "start gdt empty refId");
    }
    if (paramGdtMotiveVideoPageData.containerType == 1)
    {
      paramActivity.runOnUiThread(new GdtMotiveVideoFragment.1(paramActivity, localIntent));
      return;
    }
    if (paramBoolean)
    {
      if (paramGdtMotiveVideoPageData.screenOrientation == 0) {}
      for (paramClass = PublicFragmentActivityLandscapeForTool.class;; paramClass = PublicFragmentActivityForTool.class)
      {
        adpn.a(paramActivity, localIntent, paramClass, GdtMotiveVideoFragment.class, 101);
        AdReporterForAnalysis.reportForStartActivity(paramActivity, null, "GdtMotiveVideoFragment");
        return;
      }
    }
    if (paramGdtMotiveVideoPageData.screenOrientation == 0) {}
    for (paramGdtMotiveVideoPageData = PublicFragmentActivityLandscape.class;; paramGdtMotiveVideoPageData = PublicFragmentActivity.class)
    {
      adpn.a(paramActivity, localIntent, paramGdtMotiveVideoPageData, paramClass, 101);
      break;
    }
  }
  
  public static void a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("arg_callback", paramString);
    a(paramActivity, paramClass, paramGdtMotiveVideoPageData, localBundle, false);
  }
  
  private static void a(Context paramContext, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    if ((paramGdtMotiveVideoPageData != null) && (!TextUtils.isEmpty(paramGdtMotiveVideoPageData.adsContent))) {}
    for (;;)
    {
      try
      {
        paramGdtMotiveVideoPageData = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(aasd.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramGdtMotiveVideoPageData.adsContent))));
        AdReporterForAnalysis.reportForRewardedVideo(paramContext, paramGdtMotiveVideoPageData);
        return;
      }
      catch (Throwable paramGdtMotiveVideoPageData)
      {
        aase.d("GdtMotiveVideoFragment", "reportForAnalysis", paramGdtMotiveVideoPageData);
      }
      paramGdtMotiveVideoPageData = null;
    }
  }
  
  public static void b(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    a(paramActivity, paramClass, paramGdtMotiveVideoPageData, new Bundle(), true);
  }
  
  public void beforeFinish()
  {
    if ((this.jdField_a_of_type_Aaqa != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      String str = "";
      if (getArguments() != null) {
        str = getArguments().getString("arg_callback", "");
      }
      this.jdField_a_of_type_Aaqa.a(str);
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
      ((View)localObject).setOnSystemUiVisibilityChangeListener(new aapk(this, (View)localObject));
    }
    paramActivity.setRequestedOrientation(this.jdField_a_of_type_Aapm.a().screenOrientation);
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
    if (this.jdField_a_of_type_Aaqa != null) {
      return this.jdField_a_of_type_Aaqa.c();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    aase.b("GdtMotiveVideoFragment", "onCreate: ");
    if (this.jdField_a_of_type_Aapm == null) {
      return;
    }
    a();
    this.jdField_a_of_type_Aaqa.h();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AdReporterForAnalysis.reportForActivityStatusChanged(getActivity(), null, "GdtMotiveVideoFragment", 1);
    if (this.jdField_a_of_type_Aapm == null) {
      return null;
    }
    a();
    if ((this.jdField_a_of_type_Aapm.a().screenOrientation == 1) && (aatp.a(getActivity()))) {
      aatp.a(getActivity());
    }
    return this.jdField_a_of_type_Aaqa.a(paramLayoutInflater, paramViewGroup);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Aaqa != null) {
      this.jdField_a_of_type_Aaqa.g();
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_Aaqa != null) {
      this.jdField_a_of_type_Aaqa.e();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    aase.b("GdtMotiveVideoFragment", "onResume: ");
    if (this.jdField_a_of_type_Aaqa != null) {
      this.jdField_a_of_type_Aaqa.f();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment
 * JD-Core Version:    0.7.0.1
 */