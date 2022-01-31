package com.tencent.map.sdk.a;

import org.json.JSONException;
import org.json.JSONObject;

public final class jg$e
{
  String a;
  long b;
  
  final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("name", this.a);
      localJSONObject.put("time", this.b);
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
    if (!(paramObject instanceof e)) {
      return false;
    }
    paramObject = (e)paramObject;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.jg.e
 * JD-Core Version:    0.7.0.1
 */