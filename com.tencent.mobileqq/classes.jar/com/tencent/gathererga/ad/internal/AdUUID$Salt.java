package com.tencent.gathererga.ad.internal;

import org.json.JSONException;
import org.json.JSONObject;

public final class AdUUID$Salt
{
  private int a;
  private String b;
  private int c;
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("version", this.a);
      localJSONObject.put("salt", this.b);
      localJSONObject.put("maxLength", this.c);
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.ad.internal.AdUUID.Salt
 * JD-Core Version:    0.7.0.1
 */