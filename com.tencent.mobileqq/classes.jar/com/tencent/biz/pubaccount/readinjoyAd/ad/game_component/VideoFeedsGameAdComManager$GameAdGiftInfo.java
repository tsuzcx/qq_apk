package com.tencent.biz.pubaccount.readinjoyAd.ad.game_component;

import org.json.JSONObject;

public class VideoFeedsGameAdComManager$GameAdGiftInfo
{
  public long a;
  public String a;
  public String b;
  public String c;
  
  VideoFeedsGameAdComManager$GameAdGiftInfo(VideoFeedsGameAdComManager paramVideoFeedsGameAdComManager, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("sActivityId");
    this.b = paramJSONObject.optString("sGiftName");
    this.c = paramJSONObject.optString("sNeedRole");
    this.jdField_a_of_type_Long = paramJSONObject.optInt("iGiftId");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.game_component.VideoFeedsGameAdComManager.GameAdGiftInfo
 * JD-Core Version:    0.7.0.1
 */