package com.tencent.biz.pubaccount.NativeAd.data;

import android.text.TextUtils;
import org.json.JSONObject;

public class BannerInfo
{
  public int a;
  public String a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  public String j;
  
  public static BannerInfo a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      BannerInfo localBannerInfo = new BannerInfo();
      paramString = new JSONObject(paramString);
      localBannerInfo.jdField_a_of_type_Int = paramString.optInt("bannerType");
      localBannerInfo.jdField_a_of_type_JavaLangString = paramString.optString("iconUrl");
      localBannerInfo.jdField_b_of_type_JavaLangString = paramString.optString("abstractText");
      localBannerInfo.jdField_b_of_type_Int = paramString.optInt("jumpType");
      localBannerInfo.c = paramString.optString("linkUrl");
      localBannerInfo.d = paramString.optString("appid");
      localBannerInfo.e = paramString.optString("scheme");
      localBannerInfo.f = paramString.optString("packagename");
      localBannerInfo.g = paramString.optString("androidDownloadUrl");
      localBannerInfo.h = paramString.optString("iOSDownloadUrl");
      localBannerInfo.i = paramString.optString("appName");
      localBannerInfo.j = paramString.optString("apkUrl");
      return localBannerInfo;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public boolean a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))) {}
    while (((this.jdField_a_of_type_Int == 2) && (TextUtils.isEmpty(this.c))) || ((this.jdField_a_of_type_Int == 1) && ((TextUtils.isEmpty(this.f)) || (TextUtils.isEmpty(this.j))))) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.data.BannerInfo
 * JD-Core Version:    0.7.0.1
 */