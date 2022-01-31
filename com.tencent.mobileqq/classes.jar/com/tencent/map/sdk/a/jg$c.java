package com.tencent.map.sdk.a;

import org.json.JSONException;
import org.json.JSONObject;

public final class jg$c
{
  public String a;
  public long b;
  public String c;
  public String d;
  public int e;
  public int f;
  
  final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", this.a);
      localJSONObject.put("time", this.b);
      localJSONObject.put("expectMd5", this.c);
      localJSONObject.put("actualMd5", this.d);
      localJSONObject.put("localVer", this.e);
      localJSONObject.put("netError", this.f);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof c)) {
      return false;
    }
    paramObject = (c)paramObject;
    return nl.a(this.a, paramObject.a);
  }
  
  public final int hashCode()
  {
    if (this.a == null) {
      return super.hashCode();
    }
    return this.a.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jg.c
 * JD-Core Version:    0.7.0.1
 */