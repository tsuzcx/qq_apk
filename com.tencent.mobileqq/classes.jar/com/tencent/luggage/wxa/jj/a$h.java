package com.tencent.luggage.wxa.jj;

import org.json.JSONObject;

public class a$h
{
  public final String a;
  public final String b;
  public final String c;
  public final String d;
  
  public a$h(JSONObject paramJSONObject)
  {
    this.a = paramJSONObject.optString("pagePath");
    this.b = paramJSONObject.optString("text");
    this.c = paramJSONObject.optString("iconData");
    this.d = paramJSONObject.optString("selectedIconData");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jj.a.h
 * JD-Core Version:    0.7.0.1
 */