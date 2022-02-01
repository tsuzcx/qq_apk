package com.tencent.luggage.wxa.hv;

import com.tencent.luggage.wxa.b.e;
import com.tencent.luggage.wxa.b.h;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class l
  implements c
{
  private e a;
  
  public l()
  {
    this.a = new e();
  }
  
  l(e parame)
  {
    e locale = parame;
    if (parame == null) {
      locale = new e();
    }
    this.a = locale;
  }
  
  public l(String paramString)
  {
    this.a = com.tencent.luggage.wxa.b.a.b(paramString).l();
  }
  
  public l(Map paramMap)
  {
    this.a = j.a(paramMap);
  }
  
  public c a(String paramString, double paramDouble)
  {
    this.a.a(paramString, paramDouble);
    return this;
  }
  
  public c a(String paramString, int paramInt)
  {
    this.a.a(paramString, paramInt);
    return this;
  }
  
  public c a(String paramString, long paramLong)
  {
    this.a.a(paramString, paramLong);
    return this;
  }
  
  public c a(String paramString, Object paramObject)
  {
    j.a(this.a, paramString, paramObject);
    return this;
  }
  
  public c a(String paramString, boolean paramBoolean)
  {
    this.a.a(paramString, paramBoolean);
    return this;
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
    h localh = this.a.b(paramString);
    if (localh != null) {
      return new k(localh.c());
    }
    throw new g(String.format("key %s do not exist.", new Object[] { paramString }));
  }
  
  public c b(String paramString, Object paramObject)
  {
    j.a(this.a, paramString, paramObject);
    return this;
  }
  
  public a c(String paramString)
  {
    paramString = this.a.b(paramString);
    if (paramString == null) {
      return null;
    }
    return new k(paramString.c());
  }
  
  public c d(String paramString)
  {
    h localh = this.a.b(paramString);
    if (localh != null) {
      return new l(localh.l());
    }
    throw new g(String.format("key %s do not exist.", new Object[] { paramString }));
  }
  
  public c e(String paramString)
  {
    paramString = this.a.b(paramString);
    if (paramString == null) {
      return null;
    }
    return new l(paramString.l());
  }
  
  public Object get(String paramString)
  {
    return opt(paramString);
  }
  
  public boolean getBoolean(String paramString)
  {
    h localh = this.a.b(paramString);
    if (localh != null)
    {
      if (localh.a()) {
        return localh.d();
      }
      if (localh.i())
      {
        String str = localh.toString();
        if ("true".equals(str)) {
          return true;
        }
        if ("false".equals(str)) {
          return false;
        }
      }
      throw new g(String.format("getBoolean by key : %s error, value : %s", new Object[] { paramString, localh }));
    }
    throw new g(String.format("key %s do not exist.", new Object[] { paramString }));
  }
  
  public double getDouble(String paramString)
  {
    h localh = this.a.b(paramString);
    if (localh != null) {}
    try
    {
      if (localh.e()) {
        return localh.h();
      }
      if (localh.i())
      {
        double d = Double.parseDouble(localh.toString());
        return d;
      }
    }
    catch (Exception localException)
    {
      label48:
      break label48;
    }
    throw new g(String.format("getDouble by key : %s error, value : %s", new Object[] { paramString, localh }));
    throw new g(String.format("key %s do not exist.", new Object[] { paramString }));
  }
  
  public int getInt(String paramString)
  {
    h localh = this.a.b(paramString);
    if (localh != null) {}
    try
    {
      boolean bool = localh.e();
      if (!bool) {}
    }
    catch (Exception localException1)
    {
      int i;
      label37:
      double d;
      label64:
      break label64;
    }
    try
    {
      i = localh.f();
      return i;
    }
    catch (Exception localException2)
    {
      break label37;
    }
    return (int)localh.h();
    if (localh.i())
    {
      d = Double.parseDouble(localh.toString());
      return (int)d;
    }
    throw new g(String.format("getInt by key : %s error, value : %s", new Object[] { paramString, localh }));
    throw new g(String.format("key %s do not exist.", new Object[] { paramString }));
  }
  
  public long getLong(String paramString)
  {
    h localh = this.a.b(paramString);
    if (localh != null) {}
    try
    {
      boolean bool = localh.e();
      if (!bool) {}
    }
    catch (Exception localException1)
    {
      long l;
      label37:
      double d;
      label64:
      break label64;
    }
    try
    {
      l = localh.g();
      return l;
    }
    catch (Exception localException2)
    {
      break label37;
    }
    return localh.h();
    if (localh.i())
    {
      d = Double.parseDouble(localh.toString());
      return d;
    }
    throw new g(String.format("getLong by key : %s error, value : %s", new Object[] { paramString, localh }));
    throw new g(String.format("key %s do not exist.", new Object[] { paramString }));
  }
  
  public String getString(String paramString)
  {
    h localh = this.a.b(paramString);
    if (localh != null)
    {
      if (localh.i()) {
        return localh.j();
      }
      return localh.toString();
    }
    throw new g(String.format("key %s do not exist.", new Object[] { paramString }));
  }
  
  public boolean has(String paramString)
  {
    return this.a.b(paramString) != null;
  }
  
  public boolean isNull(String paramString)
  {
    return this.a.b(paramString) == null;
  }
  
  public Iterator<String> keys()
  {
    return this.a.c_().iterator();
  }
  
  public int length()
  {
    return this.a.b_();
  }
  
  public Object opt(String paramString)
  {
    paramString = this.a.b(paramString);
    if (paramString == null) {
      return null;
    }
    if (paramString.e()) {
      return paramString.toString();
    }
    if (paramString.a()) {
      return Boolean.valueOf(paramString.d());
    }
    if (paramString.b()) {
      return new k(paramString.c());
    }
    if (paramString.k()) {
      return new l(paramString.l());
    }
    if (paramString.i()) {
      return paramString.j();
    }
    return null;
  }
  
  public boolean optBoolean(String paramString, boolean paramBoolean)
  {
    paramString = this.a.b(paramString);
    if (paramString == null) {
      return paramBoolean;
    }
    if (paramString.a()) {
      return paramString.d();
    }
    if (paramString.i())
    {
      paramString = paramString.toString();
      if ("true".equals(paramString)) {
        return true;
      }
      if ("false".equals(paramString)) {
        return false;
      }
    }
    return paramBoolean;
  }
  
  public double optDouble(String paramString, double paramDouble)
  {
    paramString = this.a.b(paramString);
    if (paramString == null) {
      return paramDouble;
    }
    try
    {
      if (paramString.e()) {
        return paramString.h();
      }
      if (paramString.i())
      {
        double d = Double.parseDouble(paramString.toString());
        return d;
      }
      return paramDouble;
    }
    catch (Exception paramString) {}
    return paramDouble;
  }
  
  public int optInt(String paramString, int paramInt)
  {
    paramString = this.a.b(paramString);
    if (paramString == null) {
      return paramInt;
    }
    try
    {
      boolean bool = paramString.e();
      if (!bool) {}
    }
    catch (Exception paramString)
    {
      int i;
      label35:
      double d;
      return paramInt;
    }
    try
    {
      i = paramString.f();
      return i;
    }
    catch (Exception localException)
    {
      break label35;
    }
    return (int)paramString.h();
    if (paramString.i())
    {
      d = Double.parseDouble(paramString.toString());
      return (int)d;
    }
    return paramInt;
  }
  
  public long optLong(String paramString, long paramLong)
  {
    paramString = this.a.b(paramString);
    if (paramString == null) {
      return paramLong;
    }
    try
    {
      boolean bool = paramString.e();
      if (!bool) {}
    }
    catch (Exception paramString)
    {
      long l;
      label35:
      double d;
      return paramLong;
    }
    try
    {
      l = paramString.g();
      return l;
    }
    catch (Exception localException)
    {
      break label35;
    }
    return paramString.h();
    if (paramString.i())
    {
      d = Double.parseDouble(paramString.toString());
      return d;
    }
    return paramLong;
  }
  
  public String optString(String paramString)
  {
    return optString(paramString, null);
  }
  
  public String optString(String paramString1, String paramString2)
  {
    paramString1 = this.a.b(paramString1);
    if (paramString1 == null) {
      return null;
    }
    if (paramString1.i()) {
      return paramString1.j();
    }
    return paramString1.toString();
  }
  
  public Object remove(String paramString)
  {
    paramString = this.a.a(paramString);
    if (paramString == null) {
      return null;
    }
    if (paramString.e()) {
      return paramString.toString();
    }
    if (paramString.a()) {
      return Boolean.valueOf(paramString.d());
    }
    if (paramString.b()) {
      return new k(paramString.c());
    }
    if (paramString.k()) {
      return new l(paramString.l());
    }
    if (paramString.i()) {
      return paramString.j();
    }
    return null;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hv.l
 * JD-Core Version:    0.7.0.1
 */