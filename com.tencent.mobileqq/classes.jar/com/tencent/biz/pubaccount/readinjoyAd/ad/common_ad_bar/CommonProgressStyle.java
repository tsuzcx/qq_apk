package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar;

import com.tencent.biz.pubaccount.NativeAd.util.ParseUtil;
import org.json.JSONObject;

public class CommonProgressStyle
{
  public int a;
  public String b = "#12B7F5";
  public int c = 100;
  public int d = 50;
  public int e = 50;
  public int f = 20;
  public int g = 22;
  public float h = 2.0F;
  public String i = "#F2F2F2";
  public String j = "#F2F2F2";
  public String k = "#ffffff";
  public int l = 12;
  public int m = 10;
  public int n = 16;
  public String o = "#12B7F5";
  public float p = 2.0F;
  public int q = 2;
  public boolean r = false;
  public String s = "#CCE5E5E5";
  public float t = 1.5F;
  public float u = 1.5F;
  public float v = 7.0F;
  public int w = 270;
  public int x = 0;
  
  public CommonProgressStyle(int paramInt)
  {
    this.a = paramInt;
  }
  
  public static CommonProgressStyle a(int paramInt, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject;
    if (paramJSONObject == null) {
      localJSONObject = new JSONObject();
    }
    paramJSONObject = new CommonProgressStyle(paramInt);
    paramJSONObject.a = paramInt;
    paramJSONObject.d = ParseUtil.a(localJSONObject.optString("width"), 50);
    paramJSONObject.e = ParseUtil.a(localJSONObject.optString("minWidth"), 50);
    paramInt = paramJSONObject.d;
    int i1 = paramJSONObject.e;
    if (paramInt < i1) {
      paramJSONObject.d = i1;
    } else if (paramInt > 100) {
      paramJSONObject.d = 100;
    }
    paramJSONObject.f = ParseUtil.a(localJSONObject.optString("height"), 20);
    paramJSONObject.g = ParseUtil.a(localJSONObject.optString("maxHeight"), 22);
    paramInt = paramJSONObject.f;
    if (paramInt < 18)
    {
      paramJSONObject.f = 18;
    }
    else
    {
      i1 = paramJSONObject.g;
      if (paramInt > i1) {
        paramJSONObject.f = i1;
      }
    }
    paramJSONObject.h = ParseUtil.a(localJSONObject.optString("corner"), 2.0F);
    float f1 = paramJSONObject.h;
    if (f1 < 2.0F) {
      paramJSONObject.h = 2.0F;
    } else if (f1 > 20.0F) {
      paramJSONObject.h = 20.0F;
    }
    paramJSONObject.i = ParseUtil.a(localJSONObject, "progressBg", "#F2F2F2");
    paramJSONObject.j = ParseUtil.a(localJSONObject, "secondaryProgressBg", "#F2F2F2");
    paramJSONObject.b = ParseUtil.a(localJSONObject, "progressColor", "#12B7F5");
    paramJSONObject.k = ParseUtil.a(localJSONObject, "textColor", "#ffffff");
    paramJSONObject.l = localJSONObject.optInt("textSize", 12);
    paramJSONObject.m = 10;
    paramJSONObject.n = 16;
    paramJSONObject.o = ParseUtil.a(localJSONObject, "buttonBorderColor", "#12B7F5");
    paramJSONObject.p = ParseUtil.a(localJSONObject.optString("buttonBorderSize", "0"), 0.0F);
    paramJSONObject.q = 2;
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.CommonProgressStyle
 * JD-Core Version:    0.7.0.1
 */