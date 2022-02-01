package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import android.text.TextUtils;
import org.json.JSONObject;

public class AdAppDownloadInfo
{
  public String a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public int g;
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      this.a = paramJSONObject.optString("adDownloadApiUrl");
      this.b = paramJSONObject.optString("pkg_name");
      this.c = paramJSONObject.optString("appid");
      this.d = paramJSONObject.optString("appname");
      this.e = paramJSONObject.optString("pkgurl");
      this.g = paramJSONObject.optInt("business_type", 0);
      paramJSONObject = paramJSONObject.optString("apk_url");
      if (!TextUtils.isEmpty(paramJSONObject)) {
        this.e = paramJSONObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdAppDownloadInfo
 * JD-Core Version:    0.7.0.1
 */