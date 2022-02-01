package com.tencent.map.sdk.a;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class jg$a
{
  public Set<jg.c> a;
  Set<jg.e> b;
  
  static a a(JSONObject paramJSONObject)
  {
    int j = 0;
    if (paramJSONObject == null) {
      return null;
    }
    a locala = new a();
    Object localObject2 = paramJSONObject.optJSONArray("faileUpdates");
    int i;
    if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
    {
      locala.a = new CopyOnWriteArraySet();
      i = 0;
      if (i < ((JSONArray)localObject2).length())
      {
        JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(i);
        if (localJSONObject == null) {
          localObject1 = null;
        }
        for (;;)
        {
          if (localObject1 != null) {
            locala.a.add(localObject1);
          }
          i += 1;
          break;
          localObject1 = new jg.c();
          ((jg.c)localObject1).a = localJSONObject.optString("name");
          ((jg.c)localObject1).b = localJSONObject.optLong("time");
          ((jg.c)localObject1).c = localJSONObject.optString("expectMd5");
          ((jg.c)localObject1).d = localJSONObject.optString("actualMd5");
          ((jg.c)localObject1).e = localJSONObject.optInt("localVer");
          ((jg.c)localObject1).f = localJSONObject.optInt("netError");
        }
      }
    }
    Object localObject1 = paramJSONObject.optJSONArray("missFiles");
    if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
    {
      locala.b = new CopyOnWriteArraySet();
      i = j;
      if (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        if (localObject2 == null) {
          paramJSONObject = null;
        }
        for (;;)
        {
          if (paramJSONObject != null) {
            locala.b.add(paramJSONObject);
          }
          i += 1;
          break;
          paramJSONObject = new jg.e();
          paramJSONObject.a = ((JSONObject)localObject2).optString("name");
          paramJSONObject.b = ((JSONObject)localObject2).optLong("time");
        }
      }
    }
    return locala;
  }
  
  final JSONObject a()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray;
    Iterator localIterator;
    JSONObject localJSONObject2;
    if ((this.a != null) && (!this.a.isEmpty()))
    {
      localJSONArray = new JSONArray();
      localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        localJSONObject2 = ((jg.c)localIterator.next()).a();
        if (localJSONObject2 != null) {
          localJSONArray.put(localJSONObject2);
        }
      }
      if (localJSONArray.length() <= 0) {}
    }
    try
    {
      localJSONObject1.put("faileUpdates", localJSONArray);
      if ((this.b != null) && (this.b.size() > 0))
      {
        localJSONArray = new JSONArray();
        localIterator = this.b.iterator();
        while (localIterator.hasNext())
        {
          localJSONObject2 = ((jg.e)localIterator.next()).a();
          if (localJSONObject2 != null) {
            localJSONArray.put(localJSONObject2);
          }
        }
      }
    }
    catch (JSONException localJSONException1)
    {
      for (;;)
      {
        localJSONException1.printStackTrace();
      }
      if (localJSONException1.length() > 0) {}
      try
      {
        localJSONObject1.put("missFiles", localJSONException1);
        return localJSONObject1;
      }
      catch (JSONException localJSONException2)
      {
        localJSONException2.printStackTrace();
      }
    }
    return localJSONObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.jg.a
 * JD-Core Version:    0.7.0.1
 */