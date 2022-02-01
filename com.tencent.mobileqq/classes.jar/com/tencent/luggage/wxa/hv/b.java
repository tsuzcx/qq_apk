package com.tencent.luggage.wxa.hv;

import android.annotation.TargetApi;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  implements a
{
  private JSONArray a;
  
  public b()
  {
    this.a = new JSONArray();
  }
  
  public b(String paramString)
  {
    try
    {
      this.a = new JSONArray(paramString);
      return;
    }
    catch (JSONException paramString)
    {
      throw new g(paramString);
    }
  }
  
  b(JSONArray paramJSONArray)
  {
    junit.framework.a.a(paramJSONArray);
    this.a = paramJSONArray;
  }
  
  public a a(double paramDouble)
  {
    try
    {
      this.a.put(paramDouble);
      return this;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public a a(int paramInt)
  {
    this.a.put(paramInt);
    return this;
  }
  
  public a a(int paramInt, double paramDouble)
  {
    try
    {
      this.a.put(paramInt, paramDouble);
      return this;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public a a(int paramInt1, int paramInt2)
  {
    try
    {
      this.a.put(paramInt1, paramInt2);
      return this;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public a a(int paramInt, long paramLong)
  {
    try
    {
      this.a.put(paramInt, paramLong);
      return this;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public a a(int paramInt, Object paramObject)
  {
    try
    {
      this.a.put(paramInt, paramObject);
      return this;
    }
    catch (JSONException paramObject)
    {
      throw new g(paramObject);
    }
  }
  
  public a a(int paramInt, boolean paramBoolean)
  {
    try
    {
      this.a.put(paramInt, paramBoolean);
      return this;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public a a(long paramLong)
  {
    this.a.put(paramLong);
    return this;
  }
  
  public a a(Object paramObject)
  {
    this.a.put(paramObject);
    return this;
  }
  
  public a a(boolean paramBoolean)
  {
    this.a.put(paramBoolean);
    return this;
  }
  
  public a b(int paramInt)
  {
    try
    {
      Object localObject = this.a.getJSONArray(paramInt);
      if (localObject == null) {
        return null;
      }
      localObject = new b((JSONArray)localObject);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public a c(int paramInt)
  {
    JSONArray localJSONArray = this.a.optJSONArray(paramInt);
    if (localJSONArray == null) {
      return null;
    }
    return new b(localJSONArray);
  }
  
  public c d(int paramInt)
  {
    try
    {
      Object localObject = this.a.getJSONObject(paramInt);
      if (localObject == null) {
        return null;
      }
      localObject = new d((JSONObject)localObject);
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public c e(int paramInt)
  {
    JSONObject localJSONObject = this.a.optJSONObject(paramInt);
    if (localJSONObject == null) {
      return null;
    }
    return new d(localJSONObject);
  }
  
  public Object get(int paramInt)
  {
    try
    {
      Object localObject = this.a.get(paramInt);
      if ((localObject instanceof JSONObject)) {
        return new d((JSONObject)localObject);
      }
      if ((localObject instanceof JSONArray))
      {
        localObject = new b((JSONArray)localObject);
        return localObject;
      }
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public boolean getBoolean(int paramInt)
  {
    try
    {
      boolean bool = this.a.getBoolean(paramInt);
      return bool;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public double getDouble(int paramInt)
  {
    try
    {
      double d = this.a.getDouble(paramInt);
      return d;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public int getInt(int paramInt)
  {
    try
    {
      paramInt = this.a.getInt(paramInt);
      return paramInt;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public long getLong(int paramInt)
  {
    try
    {
      long l = this.a.getLong(paramInt);
      return l;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public String getString(int paramInt)
  {
    try
    {
      String str = this.a.getString(paramInt);
      return str;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
  
  public boolean isNull(int paramInt)
  {
    return this.a.isNull(paramInt);
  }
  
  public int length()
  {
    return this.a.length();
  }
  
  public Object opt(int paramInt)
  {
    Object localObject = this.a.opt(paramInt);
    if ((localObject instanceof JSONObject)) {
      return new d((JSONObject)localObject);
    }
    if ((localObject instanceof JSONArray)) {
      return new b((JSONArray)localObject);
    }
    return localObject;
  }
  
  public boolean optBoolean(int paramInt)
  {
    return this.a.optBoolean(paramInt);
  }
  
  public boolean optBoolean(int paramInt, boolean paramBoolean)
  {
    return this.a.optBoolean(paramInt, paramBoolean);
  }
  
  public double optDouble(int paramInt)
  {
    return this.a.optDouble(paramInt);
  }
  
  public double optDouble(int paramInt, double paramDouble)
  {
    return this.a.optDouble(paramInt, paramDouble);
  }
  
  public int optInt(int paramInt)
  {
    return this.a.optInt(paramInt);
  }
  
  public int optInt(int paramInt1, int paramInt2)
  {
    return this.a.optInt(paramInt1, paramInt2);
  }
  
  public long optLong(int paramInt)
  {
    return this.a.optLong(paramInt);
  }
  
  public long optLong(int paramInt, long paramLong)
  {
    return this.a.optLong(paramInt, paramLong);
  }
  
  public String optString(int paramInt)
  {
    return this.a.optString(paramInt);
  }
  
  public String optString(int paramInt, String paramString)
  {
    return this.a.optString(paramInt, paramString);
  }
  
  @TargetApi(19)
  public Object remove(int paramInt)
  {
    Object localObject = this.a.remove(paramInt);
    if ((localObject instanceof JSONObject)) {
      return new d((JSONObject)localObject);
    }
    if ((localObject instanceof JSONArray)) {
      return new b((JSONArray)localObject);
    }
    return localObject;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  public String toString(int paramInt)
  {
    try
    {
      String str = this.a.toString(paramInt);
      return str;
    }
    catch (JSONException localJSONException)
    {
      throw new g(localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hv.b
 * JD-Core Version:    0.7.0.1
 */