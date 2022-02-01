package com.tencent.comic.api.plugin;

import org.json.JSONException;
import org.json.JSONObject;

public class PreloadPublicParam
{
  public int a = 0;
  public boolean b = false;
  public int c;
  public int d;
  public boolean e = false;
  public boolean f;
  public boolean g;
  public boolean h;
  public boolean i = false;
  public int j;
  public boolean k = false;
  public boolean l = false;
  public boolean m = false;
  public int n;
  public boolean o = false;
  public int p;
  public boolean q = false;
  public int r;
  public int s;
  public int t;
  
  public static PreloadPublicParam a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    PreloadPublicParam localPreloadPublicParam = new PreloadPublicParam();
    try
    {
      if (paramJSONObject.has("pppid")) {
        localPreloadPublicParam.a = paramJSONObject.getInt("pppid");
      }
      boolean bool = paramJSONObject.has("timecontrol");
      JSONObject localJSONObject;
      if (bool)
      {
        localJSONObject = paramJSONObject.getJSONObject("timecontrol");
        localPreloadPublicParam.b = localJSONObject.getBoolean("switch");
        localPreloadPublicParam.c = localJSONObject.getInt("dayofweek");
        localPreloadPublicParam.d = localJSONObject.getInt("hourofday");
      }
      if (paramJSONObject.has("reddot"))
      {
        localJSONObject = paramJSONObject.getJSONObject("reddot");
        localPreloadPublicParam.e = localJSONObject.getBoolean("switch");
        localPreloadPublicParam.f = localJSONObject.optBoolean("apponly");
        localPreloadPublicParam.g = localJSONObject.getBoolean("app");
        localPreloadPublicParam.h = localJSONObject.getBoolean("leba");
      }
      if (paramJSONObject.has("lebalist")) {
        localPreloadPublicParam.l = paramJSONObject.getJSONObject("lebalist").getBoolean("switch");
      }
      if (paramJSONObject.has("activetime"))
      {
        localJSONObject = paramJSONObject.getJSONObject("activetime");
        localPreloadPublicParam.m = localJSONObject.getBoolean("switch");
        localPreloadPublicParam.n = localJSONObject.getInt("hour");
      }
      if (paramJSONObject.has("usedtimes"))
      {
        localJSONObject = paramJSONObject.getJSONObject("usedtimes");
        localPreloadPublicParam.o = localJSONObject.getBoolean("switch");
        localPreloadPublicParam.p = localJSONObject.getInt("times");
      }
      if (paramJSONObject.has("userlearn"))
      {
        localJSONObject = paramJSONObject.getJSONObject("userlearn");
        localPreloadPublicParam.q = localJSONObject.getBoolean("switch");
        localPreloadPublicParam.r = localJSONObject.getInt("timearea");
        localPreloadPublicParam.s = localJSONObject.getInt("methodid");
        localPreloadPublicParam.t = localJSONObject.getInt("clusternum");
      }
      if (paramJSONObject.has("cdperiod"))
      {
        paramJSONObject = paramJSONObject.getJSONObject("cdperiod");
        localPreloadPublicParam.i = paramJSONObject.optBoolean("switch");
        localPreloadPublicParam.j = paramJSONObject.optInt("time");
        localPreloadPublicParam.k = paramJSONObject.optBoolean("reverse");
      }
      return localPreloadPublicParam;
    }
    catch (JSONException paramJSONObject) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.comic.api.plugin.PreloadPublicParam
 * JD-Core Version:    0.7.0.1
 */