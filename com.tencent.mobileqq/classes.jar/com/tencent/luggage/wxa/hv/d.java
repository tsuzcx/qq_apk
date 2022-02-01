package com.tencent.luggage.wxa.hv;

import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  implements c
{
  private JSONObject a;
  
  public d()
  {
    this.a = new JSONObject();
  }
  
  public d(String paramString)
  {
    try
    {
      this.a = new JSONObject(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public d(Map paramMap)
  {
    this.a = new JSONObject(paramMap);
  }
  
  d(JSONObject paramJSONObject)
  {
    junit.framework.a.a(paramJSONObject);
    this.a = paramJSONObject;
  }
  
  public c a(String paramString, double paramDouble)
  {
    try
    {
      this.a.put(paramString, paramDouble);
      return this;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public c a(String paramString, int paramInt)
  {
    try
    {
      this.a.put(paramString, paramInt);
      return this;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public c a(String paramString, long paramLong)
  {
    try
    {
      this.a.put(paramString, paramLong);
      return this;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public c a(String paramString, Object paramObject)
  {
    try
    {
      if ((paramObject instanceof d))
      {
        this.a.put(paramString, ((d)paramObject).a);
        return this;
      }
      this.a.put(paramString, paramObject);
      return this;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public c a(String paramString, boolean paramBoolean)
  {
    try
    {
      this.a.put(paramString, paramBoolean);
      return this;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public String a(String paramString)
  {
    if (paramString != null) {
      return paramString;
    }
    throw new g("Names must be non-null");
  }
  
  public a b(String paramString)
  {
    try
    {
      paramString = this.a.getJSONArray(paramString);
      if (paramString == null) {
        return null;
      }
      paramString = new b(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public c b(String paramString, Object paramObject)
  {
    try
    {
      if ((paramObject instanceof d))
      {
        this.a.putOpt(paramString, ((d)paramObject).a);
        return this;
      }
      this.a.putOpt(paramString, paramObject);
      return this;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public a c(String paramString)
  {
    paramString = this.a.optJSONArray(paramString);
    if (paramString == null) {
      return null;
    }
    return new b(paramString);
  }
  
  public c d(String paramString)
  {
    try
    {
      paramString = this.a.getJSONObject(paramString);
      if (paramString == null) {
        return null;
      }
      paramString = new d(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public c e(String paramString)
  {
    paramString = this.a.optJSONObject(paramString);
    if (paramString == null) {
      return null;
    }
    return new d(paramString);
  }
  
  public Object get(String paramString)
  {
    try
    {
      paramString = this.a.get(paramString);
      if ((paramString instanceof JSONObject)) {
        return new d((JSONObject)paramString);
      }
      if ((paramString instanceof JSONArray))
      {
        paramString = new b((JSONArray)paramString);
        return paramString;
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public boolean getBoolean(String paramString)
  {
    try
    {
      boolean bool = this.a.getBoolean(paramString);
      return bool;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public double getDouble(String paramString)
  {
    try
    {
      double d = this.a.getDouble(paramString);
      return d;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public int getInt(String paramString)
  {
    try
    {
      int i = this.a.getInt(paramString);
      return i;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public long getLong(String paramString)
  {
    try
    {
      long l = this.a.getLong(paramString);
      return l;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public String getString(String paramString)
  {
    try
    {
      paramString = this.a.getString(paramString);
      return paramString;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  public boolean has(String paramString)
  {
    return this.a.has(paramString);
  }
  
  public boolean isNull(String paramString)
  {
    return this.a.isNull(paramString);
  }
  
  public Iterator<String> keys()
  {
    return this.a.keys();
  }
  
  public int length()
  {
    return this.a.length();
  }
  
  public Object opt(String paramString)
  {
    try
    {
      paramString = this.a.get(paramString);
      if ((paramString instanceof JSONObject)) {
        return new d((JSONObject)paramString);
      }
      if ((paramString instanceof JSONArray))
      {
        paramString = new b((JSONArray)paramString);
        return paramString;
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      label51:
      break label51;
    }
    return null;
  }
  
  public boolean optBoolean(String paramString, boolean paramBoolean)
  {
    return this.a.optBoolean(paramString, paramBoolean);
  }
  
  public double optDouble(String paramString, double paramDouble)
  {
    return this.a.optDouble(paramString, paramDouble);
  }
  
  public int optInt(String paramString, int paramInt)
  {
    return this.a.optInt(paramString, paramInt);
  }
  
  public long optLong(String paramString, long paramLong)
  {
    return this.a.optLong(paramString, paramLong);
  }
  
  public String optString(String paramString)
  {
    return this.a.optString(paramString);
  }
  
  public String optString(String paramString1, String paramString2)
  {
    return this.a.optString(paramString1, paramString2);
  }
  
  public Object remove(String paramString)
  {
    return this.a.remove(paramString);
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hv.d
 * JD-Core Version:    0.7.0.1
 */