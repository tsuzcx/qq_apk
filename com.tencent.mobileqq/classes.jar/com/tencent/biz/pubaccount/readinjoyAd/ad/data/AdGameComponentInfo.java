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
  
  public AdGameComponentInfo()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo = new AdGiftInfo();
  }
  
  public static AdGameComponentInfo a(String paramString, AdGameComponentInfo paramAdGameComponentInfo)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramAdGameComponentInfo == null) {
      paramAdGameComponentInfo = new AdGameComponentInfo();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramAdGameComponentInfo.l = paramString.optString("button_desc", "");
        paramAdGameComponentInfo.s = paramString.optString("word_content_no_wifi", "");
        paramAdGameComponentInfo.t = paramString.optString("word_content_wifi", "");
        paramAdGameComponentInfo.u = paramString.optString("word_highlight", "");
        paramAdGameComponentInfo.v = paramString.optString("word_highlight_color", "");
        paramAdGameComponentInfo.w = paramString.optString("word_title", "");
        paramAdGameComponentInfo.m = paramString.optString("detail_url", "");
        paramAdGameComponentInfo.n = paramString.optString("activity_url", "");
        paramAdGameComponentInfo.k = paramString.optString("game_icon", "");
        paramAdGameComponentInfo.x = paramString.optString("component_type", "");
        paramAdGameComponentInfo.y = paramString.optString("nfa_chainId", "");
        String str = paramString.optString("gift_info", "");
        paramString = paramAdGameComponentInfo;
        if (TextUtils.isEmpty(str)) {
          break;
        }
        paramAdGameComponentInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdDataAdGiftInfo = AdGiftInfo.a(str);
        return paramAdGameComponentInfo;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramAdGameComponentInfo;
      }
    }
  }
  
  public static AdGameComponentInfo a(String paramString, AdGameComponentInfo paramAdGameComponentInfo, AdAppDownloadInfo paramAdAppDownloadInfo)
  {
    if (TextUtils.isEmpty(paramString))
    {
      paramString = null;
      return paramString;
    }
    if (paramAdGameComponentInfo == null) {
      paramAdGameComponentInfo = new AdGameComponentInfo();
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString);
        paramAdGameComponentInfo.jdField_a_of_type_Int = paramString.optInt("id", 0);
        paramAdGameComponentInfo.jdField_a_of_type_JavaLangString = paramString.optString("game_name", "");
        paramAdGameComponentInfo.b = paramString.optString("package_name", "");
        paramAdGameComponentInfo.c = paramString.optString("business_type", "");
        paramAdGameComponentInfo.d = paramString.optString("plat_form", "");
        paramAdGameComponentInfo.e = paramString.optString("appid", "");
        paramAdGameComponentInfo.f = paramString.optString("oper_type", "");
        paramAdGameComponentInfo.r = paramString.optString("game_stage", "");
        paramAdGameComponentInfo.g = paramString.optString("game_status", "");
        paramAdGameComponentInfo.h = paramString.optString("game_kind", "");
        paramAdGameComponentInfo.i = paramString.optString("game_sub_kind", "");
        paramAdGameComponentInfo.j = paramString.optString("play_nums", "");
        paramAdGameComponentInfo.o = paramString.optString("game_tags", "");
        paramAdGameComponentInfo.p = paramString.optString("game_download_url", "");
        paramAdGameComponentInfo.q = paramString.optString("game_size", "");
        if (!TextUtils.isEmpty(paramAdGameComponentInfo.b)) {
          paramAdAppDownloadInfo.b = paramAdGameComponentInfo.b;
        }
        if (!TextUtils.isEmpty(paramAdGameComponentInfo.p)) {
          paramAdAppDownloadInfo.e = paramAdGameComponentInfo.p;
        }
        paramString = paramAdGameComponentInfo;
        if (TextUtils.isEmpty(paramAdGameComponentInfo.e)) {
          break;
        }
        paramAdAppDownloadInfo.c = paramAdGameComponentInfo.e;
        return paramAdGameComponentInfo;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
        return paramAdGameComponentInfo;
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGameComponentInfo
 * JD-Core Version:    0.7.0.1
 */