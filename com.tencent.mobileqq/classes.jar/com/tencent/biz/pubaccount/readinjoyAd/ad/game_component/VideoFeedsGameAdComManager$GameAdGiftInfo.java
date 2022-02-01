package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import org.json.JSONObject;

public class VideoFeedsGameAdComManager$GameAdGiftInfo
{
  public String a;
  public String b;
  public String c;
  public long d;
  
  VideoFeedsGameAdComManager$GameAdGiftInfo(VideoFeedsGameAdComManager paramVideoFeedsGameAdComManager, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.a = paramJSONObject.optString("sActivityId");
    this.b = paramJSONObject.optString("sGiftName");
    this.c = paramJSONObject.optString("sNeedRole");
    this.d = paramJSONObject.optInt("iGiftId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.GameAdGiftInfo
 * JD-Core Version:    0.7.0.1
 */