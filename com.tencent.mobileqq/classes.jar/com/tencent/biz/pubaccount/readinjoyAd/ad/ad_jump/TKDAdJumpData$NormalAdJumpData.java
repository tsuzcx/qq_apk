package com.tencent.biz.pubaccount.readinjoyAd.ad.ad_jump;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import ugj;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/ad_jump/TKDAdJumpData$NormalAdJumpData;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/ad_jump/TKDAdJumpData;", "obtainJumpData", "adInfo", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class TKDAdJumpData$NormalAdJumpData
  extends TKDAdJumpData
{
  TKDAdJumpData$NormalAdJumpData()
  {
    super(str, i, null);
  }
  
  @NotNull
  public TKDAdJumpData obtainJumpData(@Nullable Object paramObject)
  {
    if ((paramObject instanceof AdvertisementInfo))
    {
      setJumpType(ugj.a((AdvertisementInfo)paramObject));
      setViolaUrl(((AdvertisementInfo)paramObject).mAdLandingPage);
      setWebViewUrl(((AdvertisementInfo)paramObject).mAdLandingPage);
      setQqMiniProSchema(((AdvertisementInfo)paramObject).mAdLandingPage);
      setDownloadJumpUrl(((AdvertisementInfo)paramObject).mAdLandingPage);
      setDeepLinkUrl(((AdvertisementInfo)paramObject).mAdLandingPage);
      setPackageName(new JSONObject(((AdvertisementInfo)paramObject).mAdExt).optString("pkg_name"));
    }
    return (TKDAdJumpData)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.ad_jump.TKDAdJumpData.NormalAdJumpData
 * JD-Core Version:    0.7.0.1
 */