package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AdGiftInfo
{
  public int a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public static AdGiftInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    AdGiftInfo localAdGiftInfo;
    try
    {
      paramString = new JSONObject(paramString);
      localAdGiftInfo = new AdGiftInfo();
      try
      {
        localAdGiftInfo.a = paramString.optInt("gift_id", 0);
        localAdGiftInfo.b = paramString.optString("gift_name", "");
        localAdGiftInfo.c = paramString.optString("activity_id", "");
        localAdGiftInfo.d = paramString.optString("gift_icon", "");
        localAdGiftInfo.h = paramString.optString("gift_desc", "");
        localAdGiftInfo.e = paramString.optString("bag_item_icon_1", "");
        localAdGiftInfo.f = paramString.optString("bag_item_icon_2", "");
        localAdGiftInfo.g = paramString.optString("bag_item_icon_3", "");
        localAdGiftInfo.i = paramString.optString("need_role", "");
        return localAdGiftInfo;
      }
      catch (JSONException paramString) {}
      paramString.printStackTrace();
    }
    catch (JSONException paramString)
    {
      localAdGiftInfo = null;
    }
    return localAdGiftInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGiftInfo
 * JD-Core Version:    0.7.0.1
 */