package com.tencent.luggage.wxa.ju;

import android.content.Context;
import android.os.Handler;
import com.tencent.luggage.wxa.fx.a;
import com.tencent.luggage.wxa.fx.a.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.e;
import com.tencent.luggage.wxa.jx.f.b;
import com.tencent.luggage.wxa.jx.f.c;
import com.tencent.luggage.wxa.jx.f.d;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.jx.u;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import org.json.JSONObject;

public class b
  implements a
{
  private static final String a = "MicroMsg.AppBrand.AppBrandInvokeContext";
  private int b;
  private JSONObject c;
  private m d;
  private c e;
  private f.d f;
  private f.b g;
  private f.c h;
  
  public b(int paramInt, JSONObject paramJSONObject, c paramc, m paramm)
  {
    this.b = paramInt;
    this.c = paramJSONObject;
    this.e = paramc;
    this.d = paramm;
  }
  
  public String a()
  {
    c localc = this.e;
    if (localc != null) {
      return localc.getAppId();
    }
    return null;
  }
  
  public String a(String paramString)
  {
    c localc = this.e;
    if (localc != null)
    {
      m localm = this.d;
      if (localm != null) {
        localc.a(this.b, localm.b(paramString));
      }
    }
    return null;
  }
  
  public String a(String paramString, Map<String, ? extends Object> paramMap)
  {
    c localc = this.e;
    if (localc != null)
    {
      m localm = this.d;
      if (localm != null) {
        localc.a(this.b, localm.a(paramString, paramMap));
      }
    }
    return null;
  }
  
  public void a(a.a parama)
  {
    if ((this.e instanceof e))
    {
      o.d("MicroMsg.AppBrand.AppBrandInvokeContext", "addLifecycleListener");
      e locale = (e)this.e;
      this.f = new b.1(this, parama);
      this.g = new b.2(this, parama);
      this.h = new b.3(this, parama);
      locale.a(this.f);
      locale.a(this.g);
      locale.a(this.h);
    }
  }
  
  public Context b()
  {
    c localc = this.e;
    if (localc != null) {
      return localc.getContext();
    }
    return null;
  }
  
  public void b(a.a parama) {}
  
  public boolean c()
  {
    return this.d instanceof u;
  }
  
  public JSONObject d()
  {
    JSONObject localJSONObject = this.c;
    if (localJSONObject != null) {
      return localJSONObject;
    }
    return new JSONObject();
  }
  
  public String e()
  {
    m localm = this.d;
    if (localm != null) {
      return localm.d();
    }
    return null;
  }
  
  public void f()
  {
    if ((this.e instanceof e))
    {
      o.d("MicroMsg.AppBrand.AppBrandInvokeContext", "removeLifecycleListener");
      e locale = (e)this.e;
      Object localObject = this.f;
      if (localObject != null)
      {
        locale.b((f.d)localObject);
        this.f = null;
      }
      localObject = this.g;
      if (localObject != null)
      {
        locale.b((f.b)localObject);
        this.g = null;
      }
      localObject = this.h;
      if (localObject != null)
      {
        locale.b((f.c)localObject);
        this.h = null;
      }
    }
  }
  
  public c g()
  {
    return this.e;
  }
  
  public Handler h()
  {
    c localc = this.e;
    if (localc != null) {
      return localc.getAsyncHandler();
    }
    return null;
  }
  
  public JSONObject i()
  {
    return this.c;
  }
  
  public int j()
  {
    return this.b;
  }
  
  public m k()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ju.b
 * JD-Core Version:    0.7.0.1
 */