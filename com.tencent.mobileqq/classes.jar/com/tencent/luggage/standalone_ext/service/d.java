package com.tencent.luggage.standalone_ext.service;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.appbrand.v8.c.a;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.Map;
import org.joor.Reflect;
import org.joor.ReflectException;
import org.json.JSONException;
import org.json.JSONObject;

public class d<SERVICE extends com.tencent.luggage.wxa.du.c>
  extends com.tencent.luggage.wxa.du.b<SERVICE>
{
  @Nullable
  private final e a;
  
  public d(SERVICE paramSERVICE)
  {
    super(paramSERVICE);
    try
    {
      this.a = ((e)Reflect.on("com.tencent.luggage.standalone_ext.service.MagicBrushInstallerDelegateForMiniProgramIMPL").create().get());
      return;
    }
    catch (ReflectException paramSERVICE)
    {
      label24:
      break label24;
    }
    throw new RuntimeException(String.format(Locale.ENGLISH, "Check your proguard config pls, you should keep '%s' for mini-game support.", new Object[] { "com.tencent.luggage.standalone_ext.service.MagicBrushInstallerDelegateForMiniProgramIMPL" }));
  }
  
  private byte[] j()
  {
    if (com.tencent.luggage.wxa.hd.c.d()) {
      return com.tencent.luggage.wxa.pc.c.b("wxa_library/v8_snapshot64.bin");
    }
    return com.tencent.luggage.wxa.pc.c.b("wxa_library/v8_snapshot.bin");
  }
  
  protected Map<String, m> E()
  {
    return new com.tencent.luggage.wxa.em.a().a();
  }
  
  protected String a()
  {
    Object localObject2 = this.a;
    Object localObject1 = "";
    if (localObject2 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append("var openInvokeHandlerJsBinding = true;");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(super.a());
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(com.tencent.luggage.wxa.pc.c.a("wxa_library/js_binding_skia.js"));
    localObject1 = ((StringBuilder)localObject2).toString();
    if (this.a != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(com.tencent.luggage.wxa.pc.c.a("wxa_library/NativeGlobal-WAService.js"));
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(com.tencent.luggage.wxa.pc.c.a("wxa_library/NativeGlobal-Dummy.js"));
      localObject1 = ((StringBuilder)localObject2).toString();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(com.tencent.luggage.wxa.mx.c.a());
    return ((StringBuilder)localObject2).toString();
  }
  
  protected void a(com.tencent.luggage.wxa.iu.d paramd)
  {
    super.a(paramd);
    e locale = this.a;
    if (locale != null) {
      locale.a(paramd);
    }
  }
  
  public void b(@NonNull JSONObject paramJSONObject)
  {
    super.b(paramJSONObject);
    try
    {
      paramJSONObject.put("JSEngineName", com.tencent.luggage.wxa.dv.b.a(((com.tencent.luggage.wxa.du.c)y()).getJsRuntime()));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      o.a("Luggage.Standalone.MPServiceLogic", paramJSONObject, "attachCommonConfig error", new Object[0]);
    }
  }
  
  protected i e()
  {
    Object localObject = j();
    localObject = new c.a(com.tencent.luggage.wxa.en.c.a.a(), (byte[])localObject);
    ((c.a)localObject).d = true;
    ((c.a)localObject).c = "1";
    ((c.a)localObject).i = new WeakReference(y());
    return new com.tencent.mm.plugin.appbrand.jsruntime.c((c.a)localObject);
  }
  
  protected void f()
  {
    super.f();
    y().getClass();
    e locale = this.a;
    if (locale != null) {
      locale.a(this);
    }
    if (com.tencent.luggage.wxa.ev.a.a((h)y()))
    {
      com.tencent.luggage.wxa.qc.a.a(((com.tencent.luggage.wxa.du.c)y()).getJsRuntime(), ((com.tencent.luggage.wxa.du.c)y()).getComponentId(), A());
      com.tencent.luggage.wxa.qc.a.a(((com.tencent.luggage.wxa.du.c)y()).getJsRuntime(), ((com.tencent.luggage.wxa.du.c)y()).getComponentId(), ((com.tencent.luggage.wxa.du.c)y()).getComponentId(), A());
    }
  }
  
  protected void g()
  {
    super.g();
    e locale = this.a;
    if (locale != null) {
      locale.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.standalone_ext.service.d
 * JD-Core Version:    0.7.0.1
 */