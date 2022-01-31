package com.tencent.biz.pubaccount.NativeAd.fragment;

import abtu;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.NativeAd.view.ReadInJoyNativeAdAppContentView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.activity.PublicFragmentActivityForTool;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import nll;
import nlt;
import org.json.JSONArray;
import org.json.JSONObject;
import yxs;

public class ReadInJoyNativeAdAppFragment
  extends PublicBaseFragment
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ReadInJoyNativeAdAppContentView jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView;
  private AdvertisementInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<nll> jdField_a_of_type_JavaUtilArrayList;
  private String b;
  private String c;
  
  private void a()
  {
    Object localObject1 = getArguments();
    Object localObject2 = ((Bundle)localObject1).getString("param_ad_json");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo = new AdvertisementInfo();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdTraceId = ((Bundle)localObject1).getString("param_ad_app_info_trace_id");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdFetchTime = ((Bundle)localObject1).getLong("param_ad_app_info_pull_time");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId = ((Bundle)localObject1).getString("param_ad_app_info_view_id");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdPosID = ((Bundle)localObject1).getLong("param_ad_app_info_pos_id");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdKdPos = ((Bundle)localObject1).getInt("param_ad_app_info_kd_pos");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductId = ((Bundle)localObject1).getString("param_ad_app_info_product_id");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdProductType = ((Bundle)localObject1).getInt("param_ad_app_info_product_type");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdApurl = ((Bundle)localObject1).getString("param_ad_app_info_ap_url");
    this.jdField_a_of_type_Long = ((Bundle)localObject1).getLong("param_ad_app_info_video_playposition");
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNativeAdAppFragment", 2, "check data: " + (String)localObject2);
    }
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      getActivity().finish();
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject((String)localObject2);
        this.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("adId");
        this.b = ((JSONObject)localObject1).optString("channelId");
        this.c = ((JSONObject)localObject1).optString("info");
        this.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("upslideType");
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
        localObject1 = ((JSONObject)localObject1).optJSONArray("pageInfoList");
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          localObject2 = nll.a(getActivity().app, ((JSONArray)localObject1).getJSONObject(i));
          if (localObject2 != null) {
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
          }
        }
        else
        {
          if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
            break;
          }
          getActivity().finish();
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        getActivity().finish();
        return;
      }
      i += 1;
    }
  }
  
  public static void a(Activity paramActivity, Class<? extends ReadInJoyNativeAdAppFragment> paramClass, Bundle paramBundle)
  {
    if ((paramActivity == null) || (paramBundle == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNativeAdAppFragment", 2, "error");
      }
      return;
    }
    yxs.b("ReadInJoyNativeAdAppFragment", "start");
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtras(paramBundle);
    abtu.a(paramActivity, localIntent, PublicFragmentActivityForTool.class, paramClass);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)getActivity().getAppInterface());
    a();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131559970, paramViewGroup, false);
    this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView = ((ReadInJoyNativeAdAppContentView)paramLayoutInflater.findViewById(2131370663));
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView.setVideoPlayPositon(this.jdField_a_of_type_Long);
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView.setData((nlt)this.jdField_a_of_type_JavaUtilArrayList.get(0), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView.a();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView.b();
    }
  }
  
  public void onResume()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountNativeAdViewReadInJoyNativeAdAppContentView.c();
    }
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdAppFragment
 * JD-Core Version:    0.7.0.1
 */