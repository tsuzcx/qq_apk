package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AdGiftInfo
{
  public int a;
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  
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
        localAdGiftInfo.jdField_a_of_type_Int = paramString.optInt("gift_id", 0);
        localAdGiftInfo.jdField_a_of_type_JavaLangString = paramString.optString("gift_name", "");
        localAdGiftInfo.b = paramString.optString("activity_id", "");
        localAdGiftInfo.c = paramString.optString("gift_icon", "");
        localAdGiftInfo.g = paramString.optString("gift_desc", "");
        localAdGiftInfo.d = paramString.optString("bag_item_icon_1", "");
        localAdGiftInfo.e = paramString.optString("bag_item_icon_2", "");
        localAdGiftInfo.f = paramString.optString("bag_item_icon_3", "");
        localAdGiftInfo.h = paramString.optString("need_role", "");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGiftInfo
 * JD-Core Version:    0.7.0.1
 */