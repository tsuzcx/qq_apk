package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AdGameComponentInfo
{
  public String A;
  public AdGiftInfo B = new AdGiftInfo();
  public int a;
  public String b;
  public String c = "";
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v;
  public String w;
  public String x;
  public String y;
  public String z;
  
  public static AdGameComponentInfo a(String paramString, AdGameComponentInfo paramAdGameComponentInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    AdGameComponentInfo localAdGameComponentInfo = paramAdGameComponentInfo;
    if (paramAdGameComponentInfo == null) {
      localAdGameComponentInfo = new AdGameComponentInfo();
    }
    try
    {
      paramString = new JSONObject(paramString);
      localAdGameComponentInfo.m = paramString.optString("button_desc", "");
      localAdGameComponentInfo.t = paramString.optString("word_content_no_wifi", "");
      localAdGameComponentInfo.u = paramString.optString("word_content_wifi", "");
      localAdGameComponentInfo.v = paramString.optString("word_highlight", "");
      localAdGameComponentInfo.w = paramString.optString("word_highlight_color", "");
      localAdGameComponentInfo.x = paramString.optString("word_title", "");
      localAdGameComponentInfo.n = paramString.optString("detail_url", "");
      localAdGameComponentInfo.o = paramString.optString("activity_url", "");
      localAdGameComponentInfo.l = paramString.optString("game_icon", "");
      localAdGameComponentInfo.y = paramString.optString("component_type", "");
      localAdGameComponentInfo.z = paramString.optString("nfa_chainId", "");
      localAdGameComponentInfo.A = paramString.optString("gads_txt", "");
      paramString = paramString.optString("gift_info", "");
      if (!TextUtils.isEmpty(paramString))
      {
        localAdGameComponentInfo.B = AdGiftInfo.a(paramString);
        return localAdGameComponentInfo;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localAdGameComponentInfo;
  }
  
  public static AdGameComponentInfo a(String paramString, AdGameComponentInfo paramAdGameComponentInfo, AdAppDownloadInfo paramAdAppDownloadInfo)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    AdGameComponentInfo localAdGameComponentInfo = paramAdGameComponentInfo;
    if (paramAdGameComponentInfo == null) {
      localAdGameComponentInfo = new AdGameComponentInfo();
    }
    try
    {
      paramString = new JSONObject(paramString);
      localAdGameComponentInfo.a = paramString.optInt("id", 0);
      localAdGameComponentInfo.b = paramString.optString("game_name", "");
      localAdGameComponentInfo.c = paramString.optString("package_name", "");
      localAdGameComponentInfo.d = paramString.optString("business_type", "");
      localAdGameComponentInfo.e = paramString.optString("plat_form", "");
      localAdGameComponentInfo.f = paramString.optString("appid", "");
      localAdGameComponentInfo.g = paramString.optString("oper_type", "");
      localAdGameComponentInfo.s = paramString.optString("game_stage", "");
      localAdGameComponentInfo.h = paramString.optString("game_status", "");
      localAdGameComponentInfo.i = paramString.optString("game_kind", "");
      localAdGameComponentInfo.j = paramString.optString("game_sub_kind", "");
      localAdGameComponentInfo.k = paramString.optString("play_nums", "");
      localAdGameComponentInfo.p = paramString.optString("game_tags", "");
      localAdGameComponentInfo.q = paramString.optString("game_download_url", "");
      localAdGameComponentInfo.r = paramString.optString("game_size", "");
      if (!TextUtils.isEmpty(localAdGameComponentInfo.c)) {
        paramAdAppDownloadInfo.b = localAdGameComponentInfo.c;
      }
      if (!TextUtils.isEmpty(localAdGameComponentInfo.q)) {
        paramAdAppDownloadInfo.e = localAdGameComponentInfo.q;
      }
      if (!TextUtils.isEmpty(localAdGameComponentInfo.f))
      {
        paramAdAppDownloadInfo.c = localAdGameComponentInfo.f;
        return localAdGameComponentInfo;
      }
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return localAdGameComponentInfo;
  }
  
  public void a(JSONObject paramJSONObject, AdGameComponentInfo paramAdGameComponentInfo, AdAppDownloadInfo paramAdAppDownloadInfo)
  {
    if (paramJSONObject.has("game_component_info")) {
      a(paramJSONObject.optString("game_component_info"), paramAdGameComponentInfo, paramAdAppDownloadInfo);
    }
    if (paramJSONObject.has("game_component_real_info")) {
      a(paramJSONObject.optString("game_component_real_info"), paramAdGameComponentInfo);
    }
    if ((paramJSONObject.has("delivery_mode")) && (paramAdAppDownloadInfo.g > 0) && (paramJSONObject.optString("delivery_mode", "").equals("3")) && (TextUtils.isEmpty(paramAdGameComponentInfo.c)))
    {
      paramAdGameComponentInfo.c = paramAdAppDownloadInfo.b;
      paramAdGameComponentInfo.y = String.valueOf(paramAdAppDownloadInfo.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGameComponentInfo
 * JD-Core Version:    0.7.0.1
 */