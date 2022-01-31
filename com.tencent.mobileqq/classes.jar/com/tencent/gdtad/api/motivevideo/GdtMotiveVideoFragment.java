package com.tencent.gdtad.api.motivevideo;

import abtu;
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
import yvf;
import yvg;
import yvh;
import yvv;
import yxr;
import yxs;
import yze;

public class GdtMotiveVideoFragment
  extends PublicBaseFragment
{
  private yvh jdField_a_of_type_Yvh;
  private yvv jdField_a_of_type_Yvv;
  private boolean jdField_a_of_type_Boolean;
  
  public GdtMotiveVideoFragment()
  {
    yxs.a("GdtMotiveVideoFragment", "GdtMotiveVideoFragment: ");
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Yvv == null) {
      this.jdField_a_of_type_Yvv = new yvv(new yvg(this), this.jdField_a_of_type_Yvh, false);
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
    this.jdField_a_of_type_Yvh = new yvh((GdtMotiveVideoPageData)GdtMotiveVideoPageData.class.cast(localObject));
  }
  
  public static void a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    a(paramActivity, paramClass, paramGdtMotiveVideoPageData, new Bundle(), false);
  }
  
  private static void a(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, GdtMotiveVideoPageData paramGdtMotiveVideoPageData, Bundle paramBundle, boolean paramBoolean)
  {
    a(paramActivity, paramGdtMotiveVideoPageData);
    if ((paramActivity == null) || (paramGdtMotiveVideoPageData == null) || (paramBundle == null) || (!yze.a(paramGdtMotiveVideoPageData.vSize)))
    {
      yxs.b("GdtMotiveVideoFragment", "start error data:" + paramGdtMotiveVideoPageData);
      return;
    }
    paramBundle.putSerializable("data", paramGdtMotiveVideoPageData);
    paramBundle.putString("big_brother_ref_source_key", paramGdtMotiveVideoPageData.refId);
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
    localIntent.putExtras(paramBundle);
    if (TextUtils.isEmpty(localIntent.getStringExtra("big_brother_ref_source_key"))) {
      yxs.d("GdtMotiveVideoFragment", "start gdt empty refId");
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
        abtu.a(paramActivity, localIntent, paramClass, GdtMotiveVideoFragment.class, 101);
        return;
      }
    }
    if (paramGdtMotiveVideoPageData.screenOrientation == 0) {}
    for (paramGdtMotiveVideoPageData = PublicFragmentActivityLandscape.class;; paramGdtMotiveVideoPageData = PublicFragmentActivity.class)
    {
      abtu.a(paramActivity, localIntent, paramGdtMotiveVideoPageData, paramClass, 101);
      return;
    }
  }
  
  private static void a(Context paramContext, GdtMotiveVideoPageData paramGdtMotiveVideoPageData)
  {
    if ((paramGdtMotiveVideoPageData != null) && (!TextUtils.isEmpty(paramGdtMotiveVideoPageData.adsContent))) {}
    for (;;)
    {
      try
      {
        paramGdtMotiveVideoPageData = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)qq_ad_get.QQAdGetRsp.AdInfo.class.cast(yxr.a(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(paramGdtMotiveVideoPageData.adsContent))));
        AdReporterForAnalysis.reportForRewardedVideo(paramContext, paramGdtMotiveVideoPageData);
        return;
      }
      catch (Throwable paramGdtMotiveVideoPageData)
      {
        yxs.d("GdtMotiveVideoFragment", "reportForAnalysis", paramGdtMotiveVideoPageData);
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
    if ((this.jdField_a_of_type_Yvv != null) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_Yvv.i();
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
    ((View)localObject).setSystemUiVisibility(3846);
    if (Build.VERSION.SDK_INT >= 19) {
      ((View)localObject).setOnSystemUiVisibilityChangeListener(new yvf(this, (View)localObject));
    }
    paramActivity.setRequestedOrientation(this.jdField_a_of_type_Yvh.a().screenOrientation);
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
    if (this.jdField_a_of_type_Yvv != null) {
      return this.jdField_a_of_type_Yvv.c();
    }
    return super.onBackEvent();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    yxs.b("GdtMotiveVideoFragment", "onCreate: ");
    if (this.jdField_a_of_type_Yvh == null) {
      return;
    }
    a();
    this.jdField_a_of_type_Yvv.h();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.jdField_a_of_type_Yvh == null) {
      return null;
    }
    a();
    if ((this.jdField_a_of_type_Yvh.a().screenOrientation == 1) && (yze.a(getActivity()))) {
      yze.a(getActivity());
    }
    return this.jdField_a_of_type_Yvv.a(paramLayoutInflater, paramViewGroup);
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Yvv != null) {
      this.jdField_a_of_type_Yvv.g();
    }
    super.onDestroy();
  }
  
  public void onFinish()
  {
    super.onFinish();
  }
  
  public void onPause()
  {
    if (this.jdField_a_of_type_Yvv != null) {
      this.jdField_a_of_type_Yvv.e();
    }
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    yxs.b("GdtMotiveVideoFragment", "onResume: ");
    if (this.jdField_a_of_type_Yvv != null) {
      this.jdField_a_of_type_Yvv.f();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (Build.VERSION.SDK_INT >= 19)) {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(3846);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMotiveVideoFragment
 * JD-Core Version:    0.7.0.1
 */