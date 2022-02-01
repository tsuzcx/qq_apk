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
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private ReadInJoyNativeAdAppContentView jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<AdModuleBase> jdField_a_of_type_JavaUtilArrayList;
  private String b;
  private String c;
  
  private void a()
  {
    Object localObject2 = getArguments();
    Object localObject1 = ((Bundle)localObject2).getString("param_ad_json");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = new AdvertisementInfo();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTraceId = ((Bundle)localObject2).getString("param_ad_app_info_trace_id");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdFetchTime = ((Bundle)localObject2).getLong("param_ad_app_info_pull_time");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId = ((Bundle)localObject2).getString("param_ad_app_info_view_id");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdPosID = ((Bundle)localObject2).getLong("param_ad_app_info_pos_id");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdKdPos = ((Bundle)localObject2).getInt("param_ad_app_info_kd_pos");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductId = ((Bundle)localObject2).getString("param_ad_app_info_product_id");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType = ((Bundle)localObject2).getInt("param_ad_app_info_product_type");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdApurl = ((Bundle)localObject2).getString("param_ad_app_info_ap_url");
    this.jdField_a_of_type_Long = ((Bundle)localObject2).getLong("param_ad_app_info_video_playposition");
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
      int i;
      try
      {
        localObject1 = new JSONObject((String)localObject1);
        this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("adId");
        this.b = ((JSONObject)localObject1).optString("channelId");
        this.c = ((JSONObject)localObject1).optString("info");
        this.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("upslideType");
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject1 = ((JSONObject)localObject1).optJSONArray("pageInfoList");
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          localObject2 = AdModuleBase.a(getBaseActivity().app, ((JSONArray)localObject1).getJSONObject(i));
          if (localObject2 == null) {
            break label329;
          }
          this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          break label329;
        }
        if (this.jdField_a_of_type_JavaUtilArrayList.size() <= 0)
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
      i += 1;
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getBaseActivity().getAppInterface());
    a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131560236, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView = ((ReadInJoyNativeAdAppContentView)paramLayoutInflater.findViewById(2131371711));
    paramViewGroup = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView;
    if (paramViewGroup != null)
    {
      paramViewGroup.setVideoPlayPositon(this.jdField_a_of_type_Long);
      paramViewGroup = this.jdField_a_of_type_JavaUtilArrayList;
      if ((paramViewGroup != null) && (paramViewGroup.size() > 0)) {
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView.setData((AdModuleVideo)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyNativeAdAppContentView localReadInJoyNativeAdAppContentView = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView;
    if (localReadInJoyNativeAdAppContentView != null) {
      localReadInJoyNativeAdAppContentView.a();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ReadInJoyNativeAdAppContentView localReadInJoyNativeAdAppContentView = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView;
    if (localReadInJoyNativeAdAppContentView != null) {
      localReadInJoyNativeAdAppContentView.b();
    }
  }
  
  public void onResume()
  {
    ReadInJoyNativeAdAppContentView localReadInJoyNativeAdAppContentView = this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView;
    if (localReadInJoyNativeAdAppContentView != null) {
      localReadInJoyNativeAdAppContentView.c();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdAppFragment
 * JD-Core Version:    0.7.0.1
 */