package com.tencent.luggage.wxa.cg;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public final class a$a
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  
  private a o()
  {
    long l1 = System.currentTimeMillis();
    a();
    b();
    c();
    d();
    e();
    f();
    g();
    h();
    i();
    j();
    k();
    l();
    m();
    n();
    long l2 = System.currentTimeMillis();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("genAllDeviceInfo, timeCost = ");
    localStringBuilder.append(l2 - l1);
    o.e("AdDeviceInfo", localStringBuilder.toString());
    return this;
  }
  
  private String p()
  {
    try
    {
      long l1 = System.currentTimeMillis();
      Object localObject = new JSONObject();
      if (!af.c(this.a)) {
        ((JSONObject)localObject).put("oaid", this.a);
      }
      if (!af.c(this.b)) {
        ((JSONObject)localObject).put("imeiWx", this.b);
      }
      if (!af.c(this.c)) {
        ((JSONObject)localObject).put("deviceId", this.c);
      }
      if (!af.c(this.d)) {
        ((JSONObject)localObject).put("deviceId0", this.d);
      }
      if (!af.c(this.e)) {
        ((JSONObject)localObject).put("deviceId1", this.e);
      }
      if (!af.c(this.f)) {
        ((JSONObject)localObject).put("imei", this.f);
      }
      if (!af.c(this.g)) {
        ((JSONObject)localObject).put("imei0", this.g);
      }
      if (!af.c(this.h)) {
        ((JSONObject)localObject).put("imei1", this.h);
      }
      if (!af.c(this.i)) {
        ((JSONObject)localObject).put("meid", this.i);
      }
      if (!af.c(this.j)) {
        ((JSONObject)localObject).put("meid0", this.j);
      }
      if (!af.c(this.k)) {
        ((JSONObject)localObject).put("meid1", this.k);
      }
      if (!af.c(this.l)) {
        ((JSONObject)localObject).put("subscriberId", this.l);
      }
      if (!af.c(this.m)) {
        ((JSONObject)localObject).put("uuid", this.m);
      }
      if (!af.c(this.n)) {
        ((JSONObject)localObject).put("androidId", this.n);
      }
      localObject = ((JSONObject)localObject).toString();
      long l2 = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("buildPartDeviceInfo, timeCost = ");
      localStringBuilder.append(l2 - l1);
      localStringBuilder.append(", ret = ");
      localStringBuilder.append((String)localObject);
      o.e("AdDeviceInfo", localStringBuilder.toString());
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      o.b("AdDeviceInfo", localThrowable.toString());
    }
    return "";
  }
  
  public a a()
  {
    this.a = c.a();
    return this;
  }
  
  public a b()
  {
    this.b = c.f();
    return this;
  }
  
  public a c()
  {
    this.c = c.b();
    return this;
  }
  
  public a d()
  {
    this.d = c.a(0);
    return this;
  }
  
  public a e()
  {
    this.e = c.a(1);
    return this;
  }
  
  public a f()
  {
    this.f = c.c();
    return this;
  }
  
  public a g()
  {
    this.g = c.b(0);
    return this;
  }
  
  public a h()
  {
    this.h = c.b(1);
    return this;
  }
  
  public a i()
  {
    this.i = c.d();
    return this;
  }
  
  public a j()
  {
    this.j = c.c(0);
    return this;
  }
  
  public a k()
  {
    this.k = c.c(1);
    return this;
  }
  
  public a l()
  {
    this.l = c.e();
    return this;
  }
  
  public a m()
  {
    this.m = c.h();
    return this;
  }
  
  public a n()
  {
    this.n = c.g();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cg.a.a
 * JD-Core Version:    0.7.0.1
 */