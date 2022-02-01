package com.tencent.biz.pubaccount.readinjoyAd;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;

public class AdvertisementInfoHelper
{
  public static Bundle a(Bundle paramBundle, AdvertisementInfo paramAdvertisementInfo)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    localBundle.putString("param_ad_app_info_trace_id", paramAdvertisementInfo.mAdTraceId);
    localBundle.putLong("param_ad_app_info_pull_time", paramAdvertisementInfo.mAdFetchTime);
    localBundle.putString("param_ad_app_info_view_id", paramAdvertisementInfo.mAdViewId);
    localBundle.putLong("param_ad_app_info_pos_id", paramAdvertisementInfo.mAdPosID);
    localBundle.putInt("param_ad_app_info_kd_pos", paramAdvertisementInfo.mAdKdPos);
    localBundle.putString("param_ad_app_info_product_id", paramAdvertisementInfo.mAdProductId);
    localBundle.putInt("param_ad_app_info_product_type", paramAdvertisementInfo.mAdProductType);
    localBundle.putString("param_ad_app_info_ap_url", paramAdvertisementInfo.mAdApurl);
    localBundle.putString("param_ad_info_corporatelogo", paramAdvertisementInfo.mAdCorporateLogo);
    localBundle.putString("param_ad_info_corporatename", paramAdvertisementInfo.mAdCorporationName);
    localBundle.putString("param_ad_info_adtext", paramAdvertisementInfo.mAdTxt);
    localBundle.putParcelable("param_ad_info", paramAdvertisementInfo);
    localBundle.putParcelableArrayList("param_ad_info_dislike", paramAdvertisementInfo.mAdDislikeInfos);
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.AdvertisementInfoHelper
 * JD-Core Version:    0.7.0.1
 */