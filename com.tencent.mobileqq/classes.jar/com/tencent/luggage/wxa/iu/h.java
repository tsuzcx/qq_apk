package com.tencent.luggage.wxa.iu;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.jj.a;
import com.tencent.luggage.wxa.jx.az;
import com.tencent.luggage.wxa.jx.x;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.mm.plugin.appbrand.jsruntime.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class h
  extends b
{
  private volatile boolean b = false;
  private volatile boolean c = false;
  private volatile boolean d = false;
  private volatile boolean e = false;
  private com.tencent.luggage.wxa.oq.c f = new com.tencent.luggage.wxa.or.n();
  private volatile d g;
  private final Object h = new byte[0];
  private volatile j i;
  private final Object j = new byte[0];
  private volatile LinkedList<x> k;
  private h.a l;
  
  public h()
  {
    synchronized (this.j)
    {
      this.k = new LinkedList();
      return;
    }
  }
  
  private void a()
  {
    synchronized (this.h)
    {
      if (this.i == null) {
        this.i = w();
      }
      return;
    }
  }
  
  private <T extends Activity> T d(Class<T> paramClass)
  {
    Context localContext;
    if (v() == null) {
      localContext = getContext();
    } else {
      localContext = v().getContext();
    }
    if (paramClass.isInstance(localContext)) {
      return (Activity)localContext;
    }
    return null;
  }
  
  public final void B()
  {
    M();
    a();
    c(K());
    this.d = true;
    p();
  }
  
  public final boolean C()
  {
    return (q() == null) && (!this.b);
  }
  
  public final boolean D()
  {
    return this.d;
  }
  
  public final void E()
  {
    super.E();
    a();
    this.c = true;
    a(this.g.at());
    m();
    b(false);
  }
  
  protected final void F()
  {
    Object localObject3;
    synchronized (this.j)
    {
      if (this.k != null)
      {
        Object localObject1 = new LinkedList(this.k);
        this.k = null;
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            ??? = (x)((Iterator)localObject1).next();
            super.a(((x)???).a, ((x)???).b, ((x)???).c);
          }
        }
        return;
      }
    }
  }
  
  public final Activity G()
  {
    return d(Activity.class);
  }
  
  protected String H()
  {
    return "AppBrandService";
  }
  
  public final j I()
  {
    synchronized (this.h)
    {
      j localj = this.i;
      return localj;
    }
  }
  
  protected final void J()
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandService", "notifyWxConfigReadyIfNeed, hash=%d", new Object[] { Integer.valueOf(getComponentId()) });
    String str = String.format(Locale.US, ";(function(){ if(__wxConfig.preload) { %s; return true; } else { return false; }})();", new Object[] { az.a("onWxConfigReady", "", 0) });
    if (getJsRuntime().a(com.tencent.mm.plugin.appbrand.jsruntime.u.class) != null)
    {
      ((com.tencent.mm.plugin.appbrand.jsruntime.u)getJsRuntime().a(com.tencent.mm.plugin.appbrand.jsruntime.u.class)).a(null, null, null, 0, str, new h.4(this));
      return;
    }
    long l1 = af.d();
    getJsRuntime().evaluateJavascript(str, new h.5(this, l1));
  }
  
  @CallSuper
  @NonNull
  public JSONObject K()
  {
    return super.K();
  }
  
  public String a(String paramString)
  {
    return "";
  }
  
  public void a(d paramd)
  {
    this.g = paramd;
    a(paramd.W());
    i.a().a(this);
  }
  
  public void a(com.tencent.luggage.wxa.oq.c paramc)
  {
    this.f = paramc;
  }
  
  protected void a(String paramString, long paramLong1, long paramLong2, Object paramObject) {}
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if ((e()) && (e.a(com.tencent.luggage.wxa.iv.d.class) != null) && (((com.tencent.luggage.wxa.iv.d)e.a(com.tencent.luggage.wxa.iv.d.class)).a(paramString1)))
    {
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandService", "dispatch, ad related event:%s", new Object[] { paramString1 });
      super.a(paramString1, paramString2, paramInt);
      return;
    }
    if (this.k != null) {
      synchronized (this.j)
      {
        if (this.k != null)
        {
          this.k.add(x.a(paramString1, paramString2, paramInt));
          return;
        }
      }
    }
    super.a(paramString1, paramString2, paramInt);
  }
  
  public final void a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if (!d()) {
      return;
    }
    this.g.C().a(paramString1, paramString2, paramArrayOfInt);
  }
  
  public void a(@NonNull JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    if (getJsRuntime() != null)
    {
      boolean bool;
      if (getJsRuntime().a(k.class) != null) {
        bool = true;
      } else {
        bool = false;
      }
      a(paramJSONObject, "nativeBufferEnabled", Boolean.valueOf(bool));
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if (!d()) {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandService", "onRuntimeResume but not running, appId %s, willRelaunch %b", new Object[] { getAppId(), Boolean.valueOf(paramBoolean) });
    }
  }
  
  @Deprecated
  public final void b(String paramString1, String paramString2)
  {
    super.a(paramString1, paramString2, 0);
  }
  
  public final void b(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean d()
  {
    return (this.c) && (!this.b) && (super.d());
  }
  
  public <T extends com.tencent.mm.plugin.appbrand.page.u> T e(Class<T> paramClass)
  {
    if (this.g == null) {
      return null;
    }
    if (this.g.C() == null) {
      return null;
    }
    if (this.g.C() == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandService", "getCurrentPageView NULL PageContainer, appId=%s", new Object[] { getAppId() });
      if (this.g.F()) {
        return null;
      }
      throw new IllegalStateException("getCurrentPageView NULL PageContainer");
    }
    Object localObject = this.g.C().getCurrentPage();
    if (localObject == null)
    {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandService", "getCurrentPageView NULL Page, appId=%s", new Object[] { getAppId() });
      return null;
    }
    localObject = ((com.tencent.mm.plugin.appbrand.page.m)localObject).getCurrentPageView();
    if (paramClass.isInstance(localObject)) {
      return localObject;
    }
    return null;
  }
  
  public final boolean e()
  {
    return this.e;
  }
  
  public Map<String, com.tencent.luggage.wxa.jx.m> g()
  {
    return null;
  }
  
  public final int getComponentId()
  {
    return super.getComponentId();
  }
  
  public com.tencent.mm.plugin.appbrand.jsruntime.i h()
  {
    return new com.tencent.mm.plugin.appbrand.jsruntime.c(null, null);
  }
  
  @CallSuper
  @NonNull
  public JSONObject j()
  {
    JSONObject localJSONObject = new JSONObject();
    a(localJSONObject);
    Object localObject1 = this.g.A();
    Object localObject2 = this.g.aj();
    if ((localObject1 != null) && (localObject2 != null))
    {
      localObject1 = ((a)localObject2).k();
      localObject2 = ((JSONObject)localObject1).keys();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        Object localObject3 = ((JSONObject)localObject1).opt(str);
        try
        {
          localJSONObject.putOpt(str, localObject3);
        }
        catch (Exception localException)
        {
          com.tencent.luggage.wxa.qz.o.b("MicroMsg.AppBrandService", localException.getMessage());
        }
      }
      a(localJSONObject, "env", new JSONObject());
      localObject1 = new JSONObject();
      a((JSONObject)localObject1, "zIndex", Integer.valueOf(1000));
      a((JSONObject)localObject1, "viewId", Integer.valueOf(1));
      a(localJSONObject, "menuButtonInfo", localObject1);
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandService", "generateWxConfig(%s): %s", new Object[] { getAppId(), localJSONObject.toString() });
      return localJSONObject;
    }
    return new JSONObject();
  }
  
  @CallSuper
  protected void k()
  {
    Object localObject = j();
    String str = this.g.aj().b;
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandService", "injectConfig start, hash=%d", new Object[] { Integer.valueOf(getComponentId()) });
    if (getJsRuntime().a(com.tencent.mm.plugin.appbrand.jsruntime.n.class) != null)
    {
      str = ((JSONObject)localObject).toString();
      ((com.tencent.mm.plugin.appbrand.jsruntime.n)getJsRuntime().a(com.tencent.mm.plugin.appbrand.jsruntime.n.class)).a("__native_custom_event__wxConfig_inject", str, 0, "", new h.1(this, str));
      return;
    }
    long l1 = af.d();
    localObject = ((JSONObject)localObject).toString();
    str = String.format(Locale.ENGLISH, ";if(typeof __wxConfig==='undefined'){var __wxConfig={};};Object.assign(__wxConfig, %s);var __wxIndexPage = \"%s\";", new Object[] { localObject, str });
    if (getJsRuntime().a(com.tencent.mm.plugin.appbrand.jsruntime.u.class) != null)
    {
      ((com.tencent.mm.plugin.appbrand.jsruntime.u)getJsRuntime().a(com.tencent.mm.plugin.appbrand.jsruntime.u.class)).a(null, null, null, 0, str, new h.2(this, (String)localObject));
      return;
    }
    getJsRuntime().evaluateJavascript(str, new h.3(this, l1, (String)localObject));
  }
  
  public void l()
  {
    this.c = false;
    this.b = true;
    this.g = null;
    super.l();
    synchronized (this.h)
    {
      if (this.i != null)
      {
        this.i.a();
        this.i = null;
      }
      return;
    }
  }
  
  protected void m()
  {
    k();
    F();
  }
  
  protected void n()
  {
    if (!d()) {
      com.tencent.luggage.wxa.qz.o.c("MicroMsg.AppBrandService", "onRuntimePause but not running appId %s", new Object[] { getAppId() });
    }
  }
  
  protected void p() {}
  
  public d q()
  {
    return this.g;
  }
  
  public String r()
  {
    return "";
  }
  
  public String s()
  {
    return "";
  }
  
  public com.tencent.mm.plugin.appbrand.page.u v()
  {
    return e(com.tencent.mm.plugin.appbrand.page.u.class);
  }
  
  protected j w()
  {
    return new j(this);
  }
  
  public com.tencent.luggage.wxa.oq.c y()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.h
 * JD-Core Version:    0.7.0.1
 */