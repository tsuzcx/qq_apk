package com.tencent.biz.pubaccount.NativeAd.data;

import android.text.TextUtils;
import org.json.JSONObject;

public class BannerInfo
{
  public int a;
  public String b;
  public String c;
  public int d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  
  public static BannerInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      BannerInfo localBannerInfo = new BannerInfo();
      paramString = new JSONObject(paramString);
      localBannerInfo.a = paramString.optInt("bannerType");
      localBannerInfo.b = paramString.optString("iconUrl");
      localBannerInfo.c = paramString.optString("abstractText");
      localBannerInfo.d = paramString.optInt("jumpType");
      localBannerInfo.e = paramString.optString("linkUrl");
      localBannerInfo.f = paramString.optString("appid");
      localBannerInfo.g = paramString.optString("scheme");
      localBannerInfo.h = paramString.optString("packagename");
      localBannerInfo.i = paramString.optString("androidDownloadUrl");
      localBannerInfo.j = paramString.optString("iOSDownloadUrl");
      localBannerInfo.k = paramString.optString("appName");
      localBannerInfo.l = paramString.optString("apkUrl");
      return localBannerInfo;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public boolean a()
  {
    if (!TextUtils.isEmpty(this.b))
    {
      if (TextUtils.isEmpty(this.c)) {
        return false;
      }
      if ((this.a == 2) && (TextUtils.isEmpty(this.e))) {
        return false;
      }
      return (this.a != 1) || ((!TextUtils.isEmpty(this.h)) && (!TextUtils.isEmpty(this.l)));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.data.BannerInfo
 * JD-Core Version:    0.7.0.1
 */