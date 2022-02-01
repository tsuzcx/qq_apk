package com.tencent.hlyyb.downloader.d.a;

import com.tencent.hlyyb.common.a;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b
{
  public String a;
  public int b;
  public long c;
  
  public final Object a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("appid", a.b());
      localJSONObject2.put("url", this.a);
      localJSONObject2.put("needFeature", this.b);
      localJSONObject2.put("size", this.c);
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("resources", localJSONArray);
      return localJSONObject1;
    }
    catch (Exception localException) {}
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.d.a.b
 * JD-Core Version:    0.7.0.1
 */