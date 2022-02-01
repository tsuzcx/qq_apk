package com.tencent.luggage.wxa.hv;

import com.tencent.luggage.wxa.b.b;
import com.tencent.luggage.wxa.b.h;

public class k
  implements a
{
  private b a;
  
  public k()
  {
    this.a = new b();
  }
  
  k(b paramb)
  {
    junit.framework.a.a(paramb);
    this.a = paramb;
  }
  
  public k(String paramString)
  {
    this.a = com.tencent.luggage.wxa.b.a.b(paramString).c();
    if (this.a != null) {
      return;
    }
    throw new g(String.format("JSONArray string(%s) parse error.", new Object[] { paramString }));
  }
  
  public a a(double paramDouble)
  {
    this.a.a(paramDouble);
    return this;
  }
  
  public a a(int paramInt)
  {
    this.a.a(paramInt);
    return this;
  }
  
  public a a(int paramInt, double paramDouble)
  {
    try
    {
      this.a.a(paramInt, paramDouble);
      return this;
    }
    catch (Exception localException)
    {
      throw new g(localException);
    }
  }
  
  public a a(int paramInt1, int paramInt2)
  {
    try
    {
      this.a.a(paramInt1, paramInt2);
      return this;
    }
    catch (Exception localException)
    {
      throw new g(localException);
    }
  }
  
  public a a(int paramInt, long paramLong)
  {
    try
    {
      this.a.a(paramInt, paramLong);
      return this;
    }
    catch (Exception localException)
    {
      throw new g(localException);
    }
  }
  
  public a a(int paramInt, Object paramObject)
  {
    try
    {
      j.a(this.a, paramInt, paramObject);
      return this;
    }
    catch (Exception paramObject)
    {
      throw new g(paramObject);
    }
  }
  
  public a a(int paramInt, boolean paramBoolean)
  {
    try
    {
      this.a.a(paramInt, paramBoolean);
      return this;
    }
    catch (Exception localException)
    {
      throw new g(localException);
    }
  }
  
  public a a(long paramLong)
  {
    this.a.a(paramLong);
    return this;
  }
  
  public a a(Object paramObject)
  {
    j.a(this.a, paramObject);
    return this;
  }
  
  public a a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
    return this;
  }
  
  public a b(int paramInt)
  {
    int i = length();
    if ((paramInt >= 0) && (paramInt < i))
    {
      h localh = this.a.c(paramInt);
      if (localh != null) {
        return new k(localh.c());
      }
      throw new g(String.format("getJSONArray(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
    }
    throw new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
  }
  
  public a c(int paramInt)
  {
    int i = length();
    if (paramInt >= 0)
    {
      if (paramInt >= i) {
        return null;
      }
      h localh = this.a.c(paramInt);
      if (localh == null) {
        return null;
      }
      return new k(localh.c());
    }
    return null;
  }
  
  public c d(int paramInt)
  {
    int i = length();
    if ((paramInt >= 0) && (paramInt < i))
    {
      h localh = this.a.c(paramInt);
      if (localh != null) {
        return new l(localh.l());
      }
      throw new g(String.format("getJSONObject(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
    }
    throw new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
  }
  
  public c e(int paramInt)
  {
    int i = length();
    if (paramInt >= 0)
    {
      if (paramInt >= i) {
        return null;
      }
      h localh = this.a.c(paramInt);
      if (localh == null) {
        return null;
      }
      return new l(localh.l());
    }
    return null;
  }
  
  public Object get(int paramInt)
  {
    int i = length();
    if ((paramInt >= 0) && (paramInt < i))
    {
      h localh = this.a.c(paramInt);
      if (localh == null) {
        return null;
      }
      if (localh.e()) {
        return localh.toString();
      }
      if (localh.a()) {
        return Boolean.valueOf(localh.d());
      }
      if (localh.b()) {
        return new k(localh.c());
      }
      if (localh.k()) {
        return new l(localh.l());
      }
      if (localh.i()) {
        return localh.j();
      }
      return null;
    }
    throw new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
  }
  
  public boolean getBoolean(int paramInt)
  {
    int i = length();
    if ((paramInt >= 0) && (paramInt < i))
    {
      h localh = this.a.c(paramInt);
      if (localh != null)
      {
        if (localh.a()) {
          return localh.d();
        }
        if (localh.i())
        {
          String str = localh.j();
          if ("true".equals(str)) {
            return true;
          }
          if ("false".equals(str)) {
            return false;
          }
        }
        throw new g(String.format("getBoolean(%d) error, value : %s.", new Object[] { Integer.valueOf(paramInt), localh }));
      }
      throw new g(String.format("getBoolean(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
    }
    throw new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
  }
  
  public double getDouble(int paramInt)
  {
    int i = length();
    h localh;
    if ((paramInt >= 0) && (paramInt < i))
    {
      localh = this.a.c(paramInt);
      if (localh == null) {}
    }
    try
    {
      if (localh.e()) {
        return localh.h();
      }
      if (localh.i())
      {
        double d = Double.parseDouble(localh.j());
        return d;
      }
    }
    catch (Exception localException)
    {
      label64:
      break label64;
    }
    throw new g(String.format("getDouble(%d) error, value : %s.", new Object[] { Integer.valueOf(paramInt), localh }));
    throw new g(String.format("getDouble(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
    throw new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
  }
  
  public int getInt(int paramInt)
  {
    int i = length();
    h localh;
    if ((paramInt >= 0) && (paramInt < i))
    {
      localh = this.a.c(paramInt);
      if (localh == null) {}
    }
    try
    {
      boolean bool = localh.e();
      if (!bool) {}
    }
    catch (Exception localException1)
    {
      label53:
      double d;
      label80:
      break label80;
    }
    try
    {
      i = localh.f();
      return i;
    }
    catch (Exception localException2)
    {
      break label53;
    }
    return (int)localh.h();
    if (localh.i())
    {
      d = Double.parseDouble(localh.j());
      return (int)d;
    }
    throw new g(String.format("getInt(%d) error, value : %s.", new Object[] { Integer.valueOf(paramInt), localh }));
    throw new g(String.format("getInteger(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
    throw new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
  }
  
  public long getLong(int paramInt)
  {
    int i = length();
    h localh;
    if ((paramInt >= 0) && (paramInt < i))
    {
      localh = this.a.c(paramInt);
      if (localh == null) {}
    }
    try
    {
      boolean bool = localh.e();
      if (!bool) {}
    }
    catch (Exception localException1)
    {
      long l;
      label53:
      double d;
      label80:
      break label80;
    }
    try
    {
      l = localh.g();
      return l;
    }
    catch (Exception localException2)
    {
      break label53;
    }
    return localh.h();
    if (localh.i())
    {
      d = Double.parseDouble(localh.j());
      return d;
    }
    throw new g(String.format("getLong(%d) error, value : %s.", new Object[] { Integer.valueOf(paramInt), localh }));
    throw new g(String.format("getLong(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
    throw new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
  }
  
  public String getString(int paramInt)
  {
    int i = length();
    if ((paramInt >= 0) && (paramInt < i))
    {
      h localh = this.a.c(paramInt);
      if (localh != null)
      {
        if (localh.i()) {
          return localh.j();
        }
        return localh.toString();
      }
      throw new g(String.format("getString(%d) return null.", new Object[] { Integer.valueOf(paramInt) }));
    }
    throw new g(String.format("index(%d) out of range(0, %d).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) }));
  }
  
  public boolean isNull(int paramInt)
  {
    return (paramInt < 0) || (paramInt >= length()) || (this.a.c(paramInt) == null);
  }
  
  public int length()
  {
    return this.a.a_();
  }
  
  public Object opt(int paramInt)
  {
    int i = length();
    if (paramInt >= 0)
    {
      if (paramInt >= i) {
        return null;
      }
      h localh = this.a.c(paramInt);
      if (localh == null) {
        return null;
      }
      if (localh.e()) {
        return localh.toString();
      }
      if (localh.a()) {
        return Boolean.valueOf(localh.d());
      }
      if (localh.b()) {
        return new k(localh.c());
      }
      if (localh.k()) {
        return new l(localh.l());
      }
      if (localh.i()) {
        return localh.j();
      }
    }
    return null;
  }
  
  public boolean optBoolean(int paramInt)
  {
    return optBoolean(paramInt, false);
  }
  
  public boolean optBoolean(int paramInt, boolean paramBoolean)
  {
    int i = length();
    if (paramInt >= 0)
    {
      if (paramInt >= i) {
        return paramBoolean;
      }
      Object localObject = this.a.c(paramInt);
      if (localObject == null) {
        return paramBoolean;
      }
      if (((h)localObject).a()) {
        return ((h)localObject).d();
      }
      if (((h)localObject).i())
      {
        localObject = ((h)localObject).j();
        if ("true".equals(localObject)) {
          return true;
        }
        if ("false".equals(localObject)) {
          return false;
        }
      }
    }
    return paramBoolean;
  }
  
  public double optDouble(int paramInt)
  {
    return optDouble(paramInt, 0.0D);
  }
  
  public double optDouble(int paramInt, double paramDouble)
  {
    int i = length();
    h localh;
    if (paramInt >= 0)
    {
      if (paramInt >= i) {
        return paramDouble;
      }
      localh = this.a.c(paramInt);
      if (localh == null) {
        return paramDouble;
      }
    }
    try
    {
      if (localh.e()) {
        return localh.h();
      }
      if (localh.i())
      {
        double d = Double.parseDouble(localh.j());
        return d;
      }
      return paramDouble;
    }
    catch (Exception localException) {}
    return paramDouble;
  }
  
  public int optInt(int paramInt)
  {
    return optInt(paramInt, 0);
  }
  
  public int optInt(int paramInt1, int paramInt2)
  {
    int i = length();
    h localh;
    if (paramInt1 >= 0)
    {
      if (paramInt1 >= i) {
        return paramInt2;
      }
      localh = this.a.c(paramInt1);
      if (localh == null) {
        return paramInt2;
      }
    }
    try
    {
      boolean bool = localh.e();
      if (!bool) {}
    }
    catch (Exception localException1)
    {
      label55:
      double d;
      return paramInt2;
    }
    try
    {
      paramInt1 = localh.f();
      return paramInt1;
    }
    catch (Exception localException2)
    {
      break label55;
    }
    return (int)localh.h();
    if (localh.i())
    {
      d = Double.parseDouble(localh.j());
      return (int)d;
    }
    return paramInt2;
  }
  
  public long optLong(int paramInt)
  {
    return optLong(paramInt, 0L);
  }
  
  public long optLong(int paramInt, long paramLong)
  {
    int i = length();
    h localh;
    if (paramInt >= 0)
    {
      if (paramInt >= i) {
        return paramLong;
      }
      localh = this.a.c(paramInt);
      if (localh == null) {
        return paramLong;
      }
    }
    try
    {
      boolean bool = localh.e();
      if (!bool) {}
    }
    catch (Exception localException1)
    {
      long l;
      label57:
      double d;
      return paramLong;
    }
    try
    {
      l = localh.g();
      return l;
    }
    catch (Exception localException2)
    {
      break label57;
    }
    return localh.h();
    if (localh.i())
    {
      d = Double.parseDouble(localh.j());
      return d;
    }
    return paramLong;
  }
  
  public String optString(int paramInt)
  {
    return optString(paramInt, null);
  }
  
  public String optString(int paramInt, String paramString)
  {
    int i = length();
    if (paramInt >= 0)
    {
      if (paramInt >= i) {
        return paramString;
      }
      h localh = this.a.c(paramInt);
      if (localh == null) {
        return paramString;
      }
      if (localh.i()) {
        return localh.j();
      }
      return localh.toString();
    }
    return paramString;
  }
  
  public Object remove(int paramInt)
  {
    int i = length();
    if (paramInt >= 0)
    {
      if (paramInt >= i) {
        return null;
      }
      b localb = this.a.b(paramInt);
      if (localb == null) {
        return null;
      }
      if (localb.e()) {
        return localb.toString();
      }
      if (localb.a()) {
        return Boolean.valueOf(localb.d());
      }
      if (localb.b()) {
        return new k(localb.c());
      }
      if (localb.k()) {
        return new l(localb.l());
      }
      if (localb.i()) {
        return localb.j();
      }
    }
    return null;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
  
  public String toString(int paramInt)
  {
    try
    {
      String str = this.a.a(com.tencent.luggage.wxa.b.k.a(paramInt));
      return str;
    }
    catch (Throwable localThrowable)
    {
      throw new g(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hv.k
 * JD-Core Version:    0.7.0.1
 */