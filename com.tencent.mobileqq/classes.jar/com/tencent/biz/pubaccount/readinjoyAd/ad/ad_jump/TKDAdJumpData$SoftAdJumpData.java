package com.tencent.biz.pubaccount.readinjoyAd.ad.ad_jump;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uga;
import ugj;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/ad_jump/TKDAdJumpData$SoftAdJumpData;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/ad_jump/TKDAdJumpData;", "obtainJumpData", "adInfo", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
final class TKDAdJumpData$SoftAdJumpData
  extends TKDAdJumpData
{
  TKDAdJumpData$SoftAdJumpData()
  {
    super(str, i, null);
  }
  
  @NotNull
  public TKDAdJumpData obtainJumpData(@Nullable Object paramObject)
  {
    if ((paramObject instanceof uga))
    {
      setJumpType(ugj.a((uga)paramObject));
      setViolaUrl(((uga)paramObject).f);
      setWebViewUrl(((uga)paramObject).f);
      setQqMiniProSchema(((uga)paramObject).f);
      setDownloadJumpUrl(((uga)paramObject).f);
      setDeepLinkUrl(((uga)paramObject).f);
      setPackageName(((uga)paramObject).o);
    }
    return (TKDAdJumpData)this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.ad_jump.TKDAdJumpData.SoftAdJumpData
 * JD-Core Version:    0.7.0.1
 */