package com.tencent.biz.troopgift;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TroopGiftAioPanelData$AioActivityBubble
{
  public int a;
  public int b;
  public String c;
  public int d;
  public String e;
  public List<TroopGiftAioPanelData.AioActivity> f;
  
  public TroopGiftAioPanelData$AioActivityBubble(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optInt("width");
    this.b = paramJSONObject.optInt("height");
    this.c = paramJSONObject.optString("lottie");
    this.d = paramJSONObject.optInt("interval");
    this.e = paramJSONObject.optString("jumpUrl");
    if (paramJSONObject.optJSONArray("aioActivities") != null)
    {
      this.f = new ArrayList();
      paramJSONObject = paramJSONObject.optJSONArray("aioActivities");
      int i = 0;
      while (i < paramJSONObject.length())
      {
        TroopGiftAioPanelData.AioActivity localAioActivity = new TroopGiftAioPanelData.AioActivity(paramJSONObject.optJSONObject(i));
        this.f.add(localAioActivity);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftAioPanelData.AioActivityBubble
 * JD-Core Version:    0.7.0.1
 */