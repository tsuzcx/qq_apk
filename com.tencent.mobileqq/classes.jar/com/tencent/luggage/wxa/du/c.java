package com.tencent.luggage.wxa.du;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.dq.b.a;
import com.tencent.luggage.wxa.dq.d.a;
import com.tencent.luggage.wxa.iu.ab;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.c.b;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.ny.f;
import com.tencent.luggage.wxa.pc.g;
import com.tencent.luggage.wxa.pd.w;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.n;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import java.util.Map;
import org.joor.Reflect;
import org.json.JSONObject;

public class c
  extends h
  implements com.tencent.luggage.wxa.dq.d, f
{
  private e c;
  
  public c()
  {
    this(new b.b());
  }
  
  public c(@NonNull b.a parama)
  {
    String str = parama.getClass().getSimpleName();
    com.tencent.luggage.wxa.qz.o.e("MicroMsg.AppBrand.AppBrandServiceLU", "hy: using %s as logic imp", new Object[] { str });
    this.c = ((e)d.a().a(parama, this));
    parama = this.c;
    if (parama != null)
    {
      parama.D();
      return;
    }
    parama = new StringBuilder();
    parama.append("No logic corresponding implement found with type: ");
    parama.append(str);
    throw new IllegalArgumentException(parama.toString());
  }
  
  public c(@NonNull Class<? extends e> paramClass)
  {
    this.c = ((e)Reflect.on(paramClass).create(new Object[] { this }).get());
    this.c.D();
  }
  
  public final e a()
  {
    return this.c;
  }
  
  public String a(String paramString)
  {
    String str = this.c.c(paramString);
    if (af.c(str)) {
      return super.a(paramString);
    }
    return str;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.c.a(paramInt, paramString)) {
      return;
    }
    super.a(paramInt, paramString);
  }
  
  public void a(@NonNull d.a parama, boolean paramBoolean, long paramLong1, long paramLong2, @Nullable Object paramObject) {}
  
  public void a(com.tencent.luggage.wxa.iu.d paramd)
  {
    super.a(paramd);
    a(u());
    this.c.a(paramd);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.c.a(paramString1, paramString2, paramInt)) {
      return;
    }
    super.a(paramString1, paramString2, paramInt);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt, com.tencent.mm.plugin.appbrand.jsruntime.o paramo)
  {
    if (((paramo == null) || (paramo == getJsRuntime())) && (this.c.a(paramString1, paramString2, paramInt))) {
      return;
    }
    super.a(paramString1, paramString2, paramInt, paramo);
  }
  
  public void a(@NonNull JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.c.b(paramJSONObject);
    a(paramJSONObject, "isIsolateContext", Boolean.valueOf(this.c.d()));
    a(paramJSONObject, "version", com.tencent.luggage.wxa.qz.d.a(null, 654316592));
    a(paramJSONObject, "language", n.a(getContext()));
  }
  
  protected final void a(boolean paramBoolean)
  {
    if (!d())
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrand.AppBrandServiceLU", "onRuntimeResume but not running, appId %s, willRelaunch %b", new Object[] { getAppId(), Boolean.valueOf(paramBoolean) });
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrand.AppBrandServiceLU", "dl: onRuntimeResume, dispatch AppBrandOnAppEnterForegroundEvent, appId:%s", new Object[] { getAppId() });
    new c.1(this).a(i(), paramBoolean);
    this.c.p();
  }
  
  final void b()
  {
    super.F();
  }
  
  @CallSuper
  protected void b(@NonNull JSONObject paramJSONObject)
  {
    o().a(paramJSONObject);
  }
  
  public boolean b(String paramString)
  {
    return this.c.b(paramString);
  }
  
  public final <T> T d(Class<T> paramClass)
  {
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    if (paramClass.isInstance(this.c)) {
      return paramClass.cast(this.c);
    }
    return paramClass.cast(this.c.a(paramClass));
  }
  
  public com.tencent.luggage.wxa.dq.c f()
  {
    return (com.tencent.luggage.wxa.dq.c)super.e(com.tencent.luggage.wxa.dq.c.class);
  }
  
  public final Map<String, m> g()
  {
    return this.c.E();
  }
  
  public i h()
  {
    i locali2 = this.c.e();
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = super.h();
    }
    return locali1;
  }
  
  public com.tencent.luggage.wxa.ed.d i()
  {
    return (com.tencent.luggage.wxa.ed.d)super.q();
  }
  
  @NonNull
  public JSONObject j()
  {
    JSONObject localJSONObject = super.j();
    a(localJSONObject, "appType", Integer.valueOf(i().j().c));
    a(localJSONObject, "debug", Boolean.valueOf(i().i().b));
    b(localJSONObject);
    int[] arrayOfInt = w.a(this);
    boolean bool = false;
    a(localJSONObject, "screenWidth", Integer.valueOf(g.a(arrayOfInt[0])));
    a(localJSONObject, "screenHeight", Integer.valueOf(g.a(arrayOfInt[1])));
    a(localJSONObject, "supportAsyncGetSystemInfo", Boolean.valueOf(true));
    if (i().j().u == com.tencent.luggage.wxa.dw.d.b) {
      bool = true;
    }
    a(localJSONObject, "prerender", Boolean.valueOf(bool));
    a(localJSONObject, "instanceId", i().j().i());
    localJSONObject.remove("permission");
    localJSONObject.remove("navigateToMiniProgramAppIdList");
    return localJSONObject;
  }
  
  public final void k()
  {
    super.k();
    this.c.u();
    J();
  }
  
  public final void l()
  {
    this.c.g();
    super.l();
    this.c.h();
  }
  
  protected void m()
  {
    if (D()) {
      ab.a(this, getJsRuntime());
    }
    this.c.v();
  }
  
  protected final void n()
  {
    if (!d())
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrand.AppBrandServiceLU", "onRuntimePause but not running appId %s", new Object[] { getAppId() });
      return;
    }
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrand.AppBrandServiceLU", "dl: onRuntimePause, dispatch AppBrandOnAppEnterBackgroundEvent, appId:%s", new Object[] { getAppId() });
    new c.2(this).a(i());
    this.c.q();
  }
  
  protected final e o()
  {
    return this.c;
  }
  
  protected void p()
  {
    this.c.w();
  }
  
  public String r()
  {
    return "https://usr/";
  }
  
  protected final void r_()
  {
    this.c.f();
  }
  
  public String s()
  {
    return "https://lib/";
  }
  
  protected com.tencent.luggage.wxa.qb.a t()
  {
    return new com.tencent.luggage.wxa.qb.a(this);
  }
  
  @Nullable
  protected c.b u()
  {
    return new com.tencent.luggage.wxa.iu.a(i(), this, i().a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.du.c
 * JD-Core Version:    0.7.0.1
 */