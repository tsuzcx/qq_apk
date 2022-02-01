package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.experiment.AdExperimentData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.experiment.AdExperimentData.VideoGuide;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/utils/AdExperimentInitUtil;", "", "()V", "initExperiment", "", "adInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "initVideoGuide", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AdExperimentInitUtil
{
  public static final AdExperimentInitUtil a = new AdExperimentInitUtil();
  
  private final void b(AdvertisementInfo paramAdvertisementInfo)
  {
    AdExperimentData localAdExperimentData = paramAdvertisementInfo.adExperimentData;
    paramAdvertisementInfo = paramAdvertisementInfo.mAdExtInfo;
    if (!TextUtils.isEmpty((CharSequence)paramAdvertisementInfo))
    {
      Object localObject = new JSONObject(paramAdvertisementInfo).opt("video_guide");
      paramAdvertisementInfo = localObject;
      if (!(localObject instanceof JSONObject)) {
        paramAdvertisementInfo = null;
      }
      paramAdvertisementInfo = (JSONObject)paramAdvertisementInfo;
      if (paramAdvertisementInfo != null) {
        localAdExperimentData.a(new AdExperimentData.VideoGuide(paramAdvertisementInfo.optInt("second_state_time", -1), paramAdvertisementInfo.optInt("third_state_time", -1)));
      }
    }
  }
  
  public final void a(@Nullable AdvertisementInfo paramAdvertisementInfo)
  {
    if (paramAdvertisementInfo != null) {
      a.b(paramAdvertisementInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdExperimentInitUtil
 * JD-Core Version:    0.7.0.1
 */