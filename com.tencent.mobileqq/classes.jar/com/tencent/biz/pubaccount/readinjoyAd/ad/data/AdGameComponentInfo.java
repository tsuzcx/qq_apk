package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class AdGameComponentInfo
{
  public int a;
  public AdGiftInfo a;
  public String a;
  public String b = "";
  public String c;
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
  
  public AdGameComponentInfo()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo = new AdGiftInfo();
  }
  
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
      localAdGameComponentInfo.l = paramString.optString("button_desc", "");
      localAdGameComponentInfo.s = paramString.optString("word_content_no_wifi", "");
      localAdGameComponentInfo.t = paramString.optString("word_content_wifi", "");
      localAdGameComponentInfo.u = paramString.optString("word_highlight", "");
      localAdGameComponentInfo.v = paramString.optString("word_highlight_color", "");
      localAdGameComponentInfo.w = paramString.optString("word_title", "");
      localAdGameComponentInfo.m = paramString.optString("detail_url", "");
      localAdGameComponentInfo.n = paramString.optString("activity_url", "");
      localAdGameComponentInfo.k = paramString.optString("game_icon", "");
      localAdGameComponentInfo.x = paramString.optString("component_type", "");
      localAdGameComponentInfo.y = paramString.optString("nfa_chainId", "");
      localAdGameComponentInfo.z = paramString.optString("gads_txt", "");
      paramString = paramString.optString("gift_info", "");
      if (!TextUtils.isEmpty(paramString))
      {
        localAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo = AdGiftInfo.a(paramString);
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
      localAdGameComponentInfo.jdField_a_of_type_Int = paramString.optInt("id", 0);
      localAdGameComponentInfo.jdField_a_of_type_JavaLangString = paramString.optString("game_name", "");
      localAdGameComponentInfo.b = paramString.optString("package_name", "");
      localAdGameComponentInfo.c = paramString.optString("business_type", "");
      localAdGameComponentInfo.d = paramString.optString("plat_form", "");
      localAdGameComponentInfo.e = paramString.optString("appid", "");
      localAdGameComponentInfo.f = paramString.optString("oper_type", "");
      localAdGameComponentInfo.r = paramString.optString("game_stage", "");
      localAdGameComponentInfo.g = paramString.optString("game_status", "");
      localAdGameComponentInfo.h = paramString.optString("game_kind", "");
      localAdGameComponentInfo.i = paramString.optString("game_sub_kind", "");
      localAdGameComponentInfo.j = paramString.optString("play_nums", "");
      localAdGameComponentInfo.o = paramString.optString("game_tags", "");
      localAdGameComponentInfo.p = paramString.optString("game_download_url", "");
      localAdGameComponentInfo.q = paramString.optString("game_size", "");
      if (!TextUtils.isEmpty(localAdGameComponentInfo.b)) {
        paramAdAppDownloadInfo.b = localAdGameComponentInfo.b;
      }
      if (!TextUtils.isEmpty(localAdGameComponentInfo.p)) {
        paramAdAppDownloadInfo.e = localAdGameComponentInfo.p;
      }
      if (!TextUtils.isEmpty(localAdGameComponentInfo.e))
      {
        paramAdAppDownloadInfo.c = localAdGameComponentInfo.e;
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
    if ((paramJSONObject.has("delivery_mode")) && (paramAdAppDownloadInfo.jdField_a_of_type_Int > 0) && (paramJSONObject.optString("delivery_mode", "").equals("3")) && (TextUtils.isEmpty(paramAdGameComponentInfo.b)))
    {
      paramAdGameComponentInfo.b = paramAdAppDownloadInfo.b;
      paramAdGameComponentInfo.x = String.valueOf(paramAdAppDownloadInfo.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGameComponentInfo
 * JD-Core Version:    0.7.0.1
 */