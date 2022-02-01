package com.tencent.luggage.wxa.du;

import android.text.TextUtils;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.ab;
import com.tencent.luggage.wxa.pd.m;
import com.tencent.luggage.wxa.pd.m.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import org.json.JSONObject;

public class b<Service extends c>
  extends e<Service>
{
  private volatile boolean a = false;
  private volatile boolean b = false;
  private volatile boolean c = false;
  private com.tencent.luggage.wxa.dr.c d;
  private com.tencent.luggage.wxa.dr.d e;
  private final LinkedList<Runnable> f = new LinkedList();
  private final Map<String, Boolean> g = new HashMap();
  
  public b(Service paramService)
  {
    super(paramService);
  }
  
  private void a(boolean paramBoolean)
  {
    if (!this.b)
    {
      ab.a((com.tencent.luggage.wxa.iu.b)y(), ((c)y()).getJsRuntime());
      Object localObject1 = a();
      long l = System.currentTimeMillis();
      com.tencent.luggage.wxa.pd.l.a(((c)y()).getJsRuntime(), (String)localObject1, new b.2(this, l, paramBoolean));
      Object localObject2 = b();
      String str1 = ((b.c)localObject2).a;
      String str2 = ((b.c)localObject2).b;
      if (TextUtils.isEmpty(((b.c)localObject2).c)) {
        localObject1 = str1;
      } else {
        localObject1 = ((b.c)localObject2).c;
      }
      if (TextUtils.isEmpty(((b.c)localObject2).d))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("v");
        ((StringBuilder)localObject2).append(((c)y()).A().c());
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      else
      {
        localObject2 = ((b.c)localObject2).d;
      }
      m.a((com.tencent.luggage.wxa.iu.h)y(), ((c)y()).getJsRuntime(), str1, (String)localObject1, (String)localObject2, c(), str2, m.a.a, new b.d(str1, str2, (c)y(), paramBoolean, null));
      this.b = true;
    }
  }
  
  private boolean a(String paramString)
  {
    Boolean localBoolean = (Boolean)this.g.get(paramString);
    if ((localBoolean != null) && (localBoolean.booleanValue()))
    {
      o.d("Luggage.AppBrandMiniProgramServiceLogicImp", "guardedCheckLoadModule appId:%s, name:%s, module already injected", new Object[] { A(), paramString });
      return false;
    }
    this.g.put(paramString, Boolean.valueOf(true));
    o.d("Luggage.AppBrandMiniProgramServiceLogicImp", "guardedCheckLoadModule appId:%s, name:%s, before injection", new Object[] { A(), paramString });
    a(new b.3(this, paramString));
    return true;
  }
  
  private void j()
  {
    try
    {
      Object localObject = ((c)y()).getJsRuntime();
      if (localObject == null) {
        return;
      }
      localObject = (q)((i)localObject).a(q.class);
      if (localObject != null)
      {
        ((q)localObject).c(-2);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      o.a("Luggage.AppBrandMiniProgramServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
    }
  }
  
  private void k()
  {
    try
    {
      Object localObject = ((c)y()).getJsRuntime();
      if (localObject == null) {
        return;
      }
      localObject = (q)((i)localObject).a(q.class);
      if (localObject != null)
      {
        ((q)localObject).c(10);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      o.a("Luggage.AppBrandMiniProgramServiceLogicImp", localThrowable, "[CAPTURED CRASH]", new Object[0]);
    }
  }
  
  private void l()
  {
    n();
    m();
  }
  
  private void m()
  {
    LinkedList localLinkedList = new LinkedList();
    synchronized (this.f)
    {
      localLinkedList.addAll(this.f);
      ??? = localLinkedList.iterator();
      while (((Iterator)???).hasNext()) {
        ((Runnable)((Iterator)???).next()).run();
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void n()
  {
    if (d()) {
      return;
    }
    if (this.c) {
      return;
    }
    i();
    String str = ((c)y()).i().i().S.pkgPath;
    if (TextUtils.isEmpty(str)) {
      return;
    }
    m.a(((c)y()).i(), ((c)y()).getJsRuntime(), str, "app-service.js", "", "", m.a.b, new b.e("app-service.js", (c)y(), null));
    this.c = true;
  }
  
  private void o()
  {
    r();
    ((c)y()).k();
  }
  
  private void r()
  {
    if (this.b) {
      return;
    }
    ((c)y()).getJsRuntime().evaluateJavascript(com.tencent.luggage.wxa.pc.c.a("wxa_library/android.js"), null);
  }
  
  @Nullable
  protected a a(@NonNull i parami, @NonNull com.tencent.mm.plugin.appbrand.jsruntime.s params)
  {
    return new h((c)y(), params);
  }
  
  protected String a()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(com.tencent.luggage.wxa.pc.c.a("wxa_library/android.js"));
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(com.tencent.luggage.wxa.pc.c.a("wxa_library/shared_buffer.js"));
    localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(com.tencent.luggage.wxa.mx.c.a());
    return localStringBuilder.toString();
  }
  
  protected void a(com.tencent.luggage.wxa.iu.d paramd)
  {
    y().getClass();
    com.tencent.luggage.wxa.dr.d locald = this.e;
    if (locald != null) {
      locald.a(((c)y()).getJsRuntime(), (com.tencent.luggage.wxa.jx.h)y());
    }
    j();
    paramd.a(com.tencent.mm.plugin.appbrand.ui.h.class, new com.tencent.mm.plugin.appbrand.ui.l(paramd));
    com.tencent.luggage.wxa.mx.c.a((com.tencent.luggage.wxa.jl.b)((c)y()).a(com.tencent.luggage.wxa.jl.b.class), (com.tencent.luggage.wxa.jl.a)((c)y()).a(com.tencent.luggage.wxa.jl.a.class), (com.tencent.luggage.wxa.iu.h)y());
    com.tencent.luggage.wxa.jv.b.a();
  }
  
  void a(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (y() == null)
    {
      o.c("Luggage.AppBrandMiniProgramServiceLogicImp", "runOnServiceReady getComponent()==NULL");
      return;
    }
    if (((c)y()).d())
    {
      paramRunnable.run();
      return;
    }
    synchronized (this.f)
    {
      this.f.add(paramRunnable);
      return;
    }
  }
  
  protected void a(String paramString1, String paramString2) {}
  
  @CallSuper
  public void a(@NonNull JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    ((c)y()).a(paramJSONObject, "isLazyLoad", Boolean.valueOf(((com.tencent.mm.plugin.appbrand.page.s)((c)y()).i().b(com.tencent.mm.plugin.appbrand.page.s.class)).a()));
  }
  
  protected b.c b()
  {
    boolean bool = d();
    String str = null;
    if (bool)
    {
      str = "WAServiceMainContext.js";
      localObject1 = ((c)y()).A().a("WAServiceMainContext.js");
    }
    else
    {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      str = "WAService.js";
      localObject2 = ((c)y()).A().a("WAService.js");
    }
    Object localObject1 = new b.c();
    ((b.c)localObject1).a = str;
    ((b.c)localObject1).b = ((String)localObject2);
    return localObject1;
  }
  
  public final boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    synchronized (this.g)
    {
      boolean bool = a(paramString);
      return bool;
    }
  }
  
  protected int c()
  {
    return 0;
  }
  
  public boolean d()
  {
    return this.a;
  }
  
  protected i e()
  {
    return new com.tencent.mm.plugin.appbrand.jsruntime.c(null, null);
  }
  
  @CallSuper
  protected void f()
  {
    super.f();
    i locali = ((c)y()).getJsRuntime();
    Object localObject = (com.tencent.mm.plugin.appbrand.jsruntime.s)locali.a(com.tencent.mm.plugin.appbrand.jsruntime.s.class);
    if (localObject != null)
    {
      localObject = a(locali, (com.tencent.mm.plugin.appbrand.jsruntime.s)localObject);
      if (localObject != null)
      {
        locali.addJavascriptInterface(localObject, "WeixinJSContext");
        locali.evaluateJavascript(g.a, null);
        ((a)localObject).b();
        this.a = true;
        break label80;
      }
    }
    this.a = false;
    label80:
    locali.setJsExceptionHandler(new b.1(this, locali));
    this.d = new com.tencent.luggage.wxa.dr.c();
    this.d.a(locali, y());
    this.e = new com.tencent.luggage.wxa.dr.d();
    this.e.a(((c)y()).getJsRuntime(), y(), 0);
    locali.addJavascriptInterface(new b.a(null), "MagicBrushViewIdTransfer");
    com.tencent.luggage.wxa.mx.c.a(locali, (com.tencent.luggage.wxa.iu.h)y());
  }
  
  protected void g()
  {
    super.g();
    Object localObject = this.d;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.dr.c)localObject).a(((c)y()).getJsRuntime());
    }
    localObject = this.e;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.dr.d)localObject).a(((c)y()).getJsRuntime());
    }
  }
  
  protected void i() {}
  
  public void p()
  {
    super.p();
    j();
  }
  
  public void q()
  {
    super.q();
    k();
  }
  
  protected void v()
  {
    o();
    a(false);
    l();
    C();
  }
  
  protected void w()
  {
    a(true);
    ((c)y()).N();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.du.b
 * JD-Core Version:    0.7.0.1
 */