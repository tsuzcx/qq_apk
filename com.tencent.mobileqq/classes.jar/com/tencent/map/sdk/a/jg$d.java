package com.tencent.map.sdk.a;

import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class jg$d
{
  boolean a = false;
  public long b = 0L;
  public long c = 0L;
  jg.b d;
  public Set<jg.g> e;
  public jg.a f;
  
  final JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray;
    try
    {
      localJSONObject1.put("loadSuccess", this.a);
      localJSONObject1.put("loadSuccessTime", this.b);
      localJSONObject1.put("firstLoadTime", this.c);
      if (this.d != null) {
        localJSONObject1.put("configUpdate", this.d.a());
      }
      if ((this.e == null) || (this.e.size() <= 0)) {
        break label159;
      }
      localJSONArray = new JSONArray();
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext())
      {
        JSONObject localJSONObject2 = ((jg.g)localIterator.next()).a();
        if (localJSONObject2 != null) {
          localJSONArray.put(localJSONObject2);
        }
      }
      if (localJSONArray.length() <= 0) {
        break label159;
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return null;
    }
    localJSONException.put("tileErrors", localJSONArray);
    label159:
    if (this.f != null) {
      localJSONException.put("configError", this.f.a());
    }
    return localJSONException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.jg.d
 * JD-Core Version:    0.7.0.1
 */