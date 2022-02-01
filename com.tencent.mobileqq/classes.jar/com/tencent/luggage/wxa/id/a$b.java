package com.tencent.luggage.wxa.id;

import android.text.TextUtils;
import java.util.Map;
import java.util.Set;

public class a$b
{
  private Map<String, Object> a = new a.a(null);
  
  public int a(String paramString, int paramInt)
  {
    int i = paramInt;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.a.get(paramString);
      i = paramInt;
      if ((paramString instanceof Integer)) {
        i = ((Integer)paramString).intValue();
      }
    }
    return i;
  }
  
  public b a(String paramString, Object paramObject)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put(paramString, paramObject);
    }
    return this;
  }
  
  public b a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1)) {
      this.a.put(paramString1, paramString2);
    }
    return this;
  }
  
  public b a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.a.put(paramString, Boolean.valueOf(paramBoolean));
    }
    return this;
  }
  
  public Set<String> a()
  {
    return this.a.keySet();
  }
  
  public boolean a(String paramString)
  {
    return this.a.containsKey(paramString);
  }
  
  public <T> T b(String paramString, T paramT)
  {
    paramString = c(paramString);
    if (paramString != null) {
      return paramString;
    }
    return paramT;
  }
  
  public String b(String paramString1, String paramString2)
  {
    String str = paramString2;
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = this.a.get(paramString1);
      str = paramString2;
      if ((paramString1 instanceof String)) {
        str = (String)paramString1;
      }
    }
    return str;
  }
  
  public void b()
  {
    this.a.clear();
  }
  
  public boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.a.get(paramString);
      if ((paramString instanceof Boolean)) {
        return ((Boolean)paramString).booleanValue();
      }
    }
    return false;
  }
  
  public boolean b(String paramString, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = this.a.get(paramString);
      bool = paramBoolean;
      if ((paramString instanceof Boolean)) {
        bool = ((Boolean)paramString).booleanValue();
      }
    }
    return bool;
  }
  
  public Object c(String paramString)
  {
    return this.a.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.id.a.b
 * JD-Core Version:    0.7.0.1
 */