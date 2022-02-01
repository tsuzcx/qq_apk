package com.tencent.biz.troopgift;

import org.json.JSONObject;

public class TroopGiftAioPanelData$CoinInfo
{
  public String a = null;
  public String b = null;
  public String c = null;
  public String d = null;
  
  public TroopGiftAioPanelData$CoinInfo(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("icon");
    this.b = paramJSONObject.optString("iconGrid");
    this.c = paramJSONObject.optString("jumpUrl");
    this.d = paramJSONObject.optString("iconLoveGrid");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftAioPanelData.CoinInfo
 * JD-Core Version:    0.7.0.1
 */