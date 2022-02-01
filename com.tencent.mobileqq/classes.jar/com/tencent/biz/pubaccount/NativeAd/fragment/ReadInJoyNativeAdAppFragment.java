package com.tencent.biz.pubaccount.NativeAd.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase;
import com.tencent.biz.pubaccount.NativeAd.module.AdModuleVideo;
import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppContentView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class ReadInJoyNativeAdAppFragment
  extends PublicBaseFragment
{
  private ReadInJoyNativeAdAppContentView a;
  private String b;
  private String c;
  private String d;
  private int e;
  private ArrayList<AdModuleBase> f;
  private AdvertisementInfo g;
  private QQAppInterface h;
  private long i = 0L;
  
  private void a()
  {
    Object localObject2 = getArguments();
    Object localObject1 = ((Bundle)localObject2).getString("param_ad_json");
    this.g = new AdvertisementInfo();
    this.g.mAdTraceId = ((Bundle)localObject2).getString("param_ad_app_info_trace_id");
    this.g.mAdFetchTime = ((Bundle)localObject2).getLong("param_ad_app_info_pull_time");
    this.g.mAdViewId = ((Bundle)localObject2).getString("param_ad_app_info_view_id");
    this.g.mAdPosID = ((Bundle)localObject2).getLong("param_ad_app_info_pos_id");
    this.g.mAdKdPos = ((Bundle)localObject2).getInt("param_ad_app_info_kd_pos");
    this.g.mAdProductId = ((Bundle)localObject2).getString("param_ad_app_info_product_id");
    this.g.mAdProductType = ((Bundle)localObject2).getInt("param_ad_app_info_product_type");
    this.g.mAdApurl = ((Bundle)localObject2).getString("param_ad_app_info_ap_url");
    this.i = ((Bundle)localObject2).getLong("param_ad_app_info_video_playposition");
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("check data: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("ReadInJoyNativeAdAppFragment", 2, ((StringBuilder)localObject2).toString());
    }
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      getBaseActivity().finish();
      return;
    }
    for (;;)
    {
      int j;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        this.b = ((JSONObject)localObject1).optString("adId");
        this.c = ((JSONObject)localObject1).optString("channelId");
        this.d = ((JSONObject)localObject1).optString("info");
        this.e = ((JSONObject)localObject1).optInt("upslideType");
        this.f = new ArrayList();
        localObject1 = ((JSONObject)localObject1).optJSONArray("pageInfoList");
        j = 0;
        if (j < ((JSONArray)localObject1).length())
        {
          localObject2 = AdModuleBase.a(getBaseActivity().app, ((JSONArray)localObject1).getJSONObject(j));
          if (localObject2 == null) {
            break label329;
          }
          this.f.add(localObject2);
          break label329;
        }
        if (this.f.size() <= 0)
        {
          getBaseActivity().finish();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        getBaseActivity().finish();
      }
      return;
      label329:
      j += 1;
    }
  }
  
  public static void a(Activity paramActivity, Class<? extends ReadInJoyNativeAdAppFragment> paramClass, Bundle paramBundle)
  {
    if ((paramActivity != null) && (paramBundle != null))
    {
      GdtLog.b("ReadInJoyNativeAdAppFragment", "start");
      Intent localIntent = new Intent();
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtras(paramBundle);
      PublicFragmentActivity.Launcher.a(paramActivity, localIntent, PublicFragmentActivityForTool.class, paramClass);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppFragment", 2, "error");
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    if (paramActivity == null) {
      return;
    }
    paramActivity.requestWindowFeature(1);
    paramActivity.getWindow().addFlags(1024);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.h = ((QQAppInterface)getBaseActivity().getAppInterface());
    a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131626283, paramViewGroup, false);
    this.a = ((ReadInJoyNativeAdAppContentView)paramLayoutInflater.findViewById(2131439138));
    paramViewGroup = this.a;
    if (paramViewGroup != null)
    {
      paramViewGroup.setVideoPlayPositon(this.i);
      paramViewGroup = this.f;
      if ((paramViewGroup != null) && (paramViewGroup.size() > 0)) {
        this.a.setData((AdModuleVideo)this.f.get(0), this.g, this.h);
      }
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyNativeAdAppContentView localReadInJoyNativeAdAppContentView = this.a;
    if (localReadInJoyNativeAdAppContentView != null) {
      localReadInJoyNativeAdAppContentView.a();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ReadInJoyNativeAdAppContentView localReadInJoyNativeAdAppContentView = this.a;
    if (localReadInJoyNativeAdAppContentView != null) {
      localReadInJoyNativeAdAppContentView.b();
    }
  }
  
  public void onResume()
  {
    ReadInJoyNativeAdAppContentView localReadInJoyNativeAdAppContentView = this.a;
    if (localReadInJoyNativeAdAppContentView != null) {
      localReadInJoyNativeAdAppContentView.c();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdAppFragment
 * JD-Core Version:    0.7.0.1
 */