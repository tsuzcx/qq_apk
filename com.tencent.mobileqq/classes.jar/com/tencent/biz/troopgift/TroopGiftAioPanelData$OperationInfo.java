package com.tencent.biz.troopgift;

import org.json.JSONObject;

public class TroopGiftAioPanelData$OperationInfo
{
  public String a = null;
  public String b = null;
  
  public TroopGiftAioPanelData$OperationInfo(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("icon");
    this.b = paramJSONObject.optString("jumpUrl");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftAioPanelData.OperationInfo
 * JD-Core Version:    0.7.0.1
 */