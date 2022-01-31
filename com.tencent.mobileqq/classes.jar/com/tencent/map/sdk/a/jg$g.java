package com.tencent.map.sdk.a;

import org.json.JSONException;
import org.json.JSONObject;

public final class jg$g
{
  public long a;
  public String b;
  public int c;
  
  final JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("time", this.a);
      localJSONObject.put("tid", this.b);
      localJSONObject.put("netError", this.c);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof g)) {
      return false;
    }
    paramObject = (g)paramObject;
    return nl.a(this.b, paramObject.b);
  }
  
  public final int hashCode()
  {
    if (this.b == null) {
      return super.hashCode();
    }
    return this.b.hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jg.g
 * JD-Core Version:    0.7.0.1
 */