package com.tencent.biz.troopgift;

import org.json.JSONObject;

public class TroopGiftAioPanelData$WebPanelItemInfo
{
  public String a;
  public int b;
  public String c;
  public String d;
  public int e;
  public int f;
  public TroopGiftAioPanelData.AioActivityBubble g;
  
  public TroopGiftAioPanelData$WebPanelItemInfo(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("title");
    this.b = paramJSONObject.optInt("tabID");
    this.c = paramJSONObject.optString("icon");
    this.d = paramJSONObject.optString("jumpUrl");
    this.e = paramJSONObject.optInt("width");
    this.f = paramJSONObject.optInt("height");
    if (paramJSONObject.optJSONObject("aioActivityBubble") != null) {
      this.g = new TroopGiftAioPanelData.AioActivityBubble(paramJSONObject.optJSONObject("aioActivityBubble"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftAioPanelData.WebPanelItemInfo
 * JD-Core Version:    0.7.0.1
 */