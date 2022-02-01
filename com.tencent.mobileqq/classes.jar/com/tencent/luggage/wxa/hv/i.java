package com.tencent.luggage.wxa.hv;

import java.util.Iterator;
import java.util.Map;
import junit.framework.a;
import org.json.JSONObject;

public class i
  extends JSONObject
  implements c
{
  private final c a;
  
  public i()
  {
    this.a = h.b();
  }
  
  public i(c paramc)
  {
    a.a(paramc);
    this.a = paramc;
  }
  
  public i(String paramString)
  {
    this.a = h.b(paramString);
  }
  
  public i(Map paramMap)
  {
    this.a = h.a(paramMap);
  }
  
  public String a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public i b(String paramString, double paramDouble)
  {
    this.a.a(a(paramString), paramDouble);
    return this;
  }
  
  public i b(String paramString, int paramInt)
  {
    this.a.a(a(paramString), paramInt);
    return this;
  }
  
  public i b(String paramString, long paramLong)
  {
    this.a.a(a(paramString), paramLong);
    return this;
  }
  
  public i b(String paramString, boolean paramBoolean)
  {
    this.a.a(paramString, paramBoolean);
    return this;
  }
  
  public i c(String paramString, Object paramObject)
  {
    if ((paramObject instanceof i)) {
      return c(paramString, ((i)paramObject).a);
    }
    this.a.a(paramString, paramObject);
    return this;
  }
  
  public i d(String paramString, Object paramObject)
  {
    this.a.b(paramString, paramObject);
    return this;
  }
  
  public f f(String paramString)
  {
    paramString = this.a.b(paramString);
    if (paramString == null) {
      return null;
    }
    return new f(paramString);
  }
  
  public f g(String paramString)
  {
    paramString = this.a.c(paramString);
    if (paramString == null) {
      return null;
    }
    return new f(paramString);
  }
  
  public Object get(String paramString)
  {
    return this.a.get(paramString);
  }
  
  public boolean getBoolean(String paramString)
  {
    return this.a.getBoolean(paramString);
  }
  
  public double getDouble(String paramString)
  {
    return this.a.getDouble(paramString);
  }
  
  public int getInt(String paramString)
  {
    return this.a.getInt(paramString);
  }
  
  public long getLong(String paramString)
  {
    return this.a.getLong(paramString);
  }
  
  public String getString(String paramString)
  {
    return this.a.getString(paramString);
  }
  
  public i h(String paramString)
  {
    paramString = this.a.d(paramString);
    if (paramString == null) {
      return null;
    }
    return new i(paramString);
  }
  
  public boolean has(String paramString)
  {
    return this.a.has(paramString);
  }
  
  public i i(String paramString)
  {
    paramString = this.a.e(paramString);
    if (paramString == null) {
      return null;
    }
    return new i(paramString);
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
    return this.a.opt(paramString);
  }
  
  public boolean optBoolean(String paramString)
  {
    return this.a.optBoolean(paramString, false);
  }
  
  public boolean optBoolean(String paramString, boolean paramBoolean)
  {
    return this.a.optBoolean(paramString, paramBoolean);
  }
  
  public double optDouble(String paramString)
  {
    return this.a.optDouble(paramString, (0.0D / 0.0D));
  }
  
  public double optDouble(String paramString, double paramDouble)
  {
    return this.a.optDouble(paramString, paramDouble);
  }
  
  public int optInt(String paramString)
  {
    return this.a.optInt(paramString, 0);
  }
  
  public int optInt(String paramString, int paramInt)
  {
    return this.a.optInt(paramString, paramInt);
  }
  
  public long optLong(String paramString)
  {
    return this.a.optLong(paramString, 0L);
  }
  
  public long optLong(String paramString, long paramLong)
  {
    return this.a.optLong(paramString, paramLong);
  }
  
  public String optString(String paramString)
  {
    return this.a.optString(paramString, "");
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
 * Qualified Name:     com.tencent.luggage.wxa.hv.i
 * JD-Core Version:    0.7.0.1
 */