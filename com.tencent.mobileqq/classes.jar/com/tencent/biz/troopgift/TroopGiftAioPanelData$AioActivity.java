package com.tencent.biz.troopgift;

import org.json.JSONObject;

public class TroopGiftAioPanelData$AioActivity
{
  public String a;
  public String b;
  public String c;
  public String d;
  public float e;
  public float f;
  public String g;
  public boolean h;
  
  public TroopGiftAioPanelData$AioActivity(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("title");
    this.b = paramJSONObject.optString("startTime");
    this.c = paramJSONObject.optString("endTime");
    this.d = paramJSONObject.optString("jumpUrl");
    this.e = ((float)paramJSONObject.optDouble("durationStart"));
    this.f = ((float)paramJSONObject.optDouble("durationEnd"));
    this.g = paramJSONObject.optString("replaceImage");
    this.h = paramJSONObject.optBoolean("replace");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftAioPanelData.AioActivity
 * JD-Core Version:    0.7.0.1
 */