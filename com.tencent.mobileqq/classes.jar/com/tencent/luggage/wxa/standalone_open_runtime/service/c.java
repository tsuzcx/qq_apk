package com.tencent.luggage.wxa.standalone_open_runtime.service;

import com.tencent.luggage.standalone_ext.service.d;
import com.tencent.luggage.wxa.fc.g;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.mm.appbrand.v8.c.a;
import com.tencent.mm.plugin.appbrand.jsruntime.i;
import com.tencent.mm.plugin.appbrand.jsruntime.v;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/service/WxaAppServiceLogicIMPL;", "Lcom/tencent/luggage/standalone_ext/service/MPServiceLogic;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/service/WxaAppService;", "service", "(Lcom/tencent/luggage/wxa/standalone_open_runtime/service/WxaAppService;)V", "mNodeInstaller", "Lcom/tencent/luggage/standalone_ext/service/MNodeInstaller;", "createCustomJsRuntime", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntime;", "getEnvBootstrapScript", "", "onCreateJsApiPool", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "postCleanUp", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public class c
  extends d<a>
{
  private com.tencent.luggage.standalone_ext.service.c a;
  
  public c(@NotNull a parama)
  {
    super((com.tencent.luggage.wxa.du.c)parama);
  }
  
  @NotNull
  protected Map<String, m> E()
  {
    return g.a.a();
  }
  
  @NotNull
  protected String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("var openInvokeHandlerJsBinding = true;");
    localStringBuilder.append(super.a());
    com.tencent.luggage.standalone_ext.service.c localc = this.a;
    if (localc == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mNodeInstaller");
    }
    localStringBuilder.append(localc.b());
    return localStringBuilder.toString();
  }
  
  @NotNull
  protected i e()
  {
    if (com.tencent.luggage.wxa.hd.c.d()) {
      localObject1 = com.tencent.luggage.wxa.pc.c.b("wxa_library/v8_snapshot64.bin");
    } else {
      localObject1 = com.tencent.luggage.wxa.pc.c.b("wxa_library/v8_snapshot.bin");
    }
    Object localObject2 = new c.a();
    ((c.a)localObject2).a = com.tencent.luggage.wxa.en.c.a.a();
    ((c.a)localObject2).b = ((byte[])localObject1);
    ((c.a)localObject2).c = "1";
    ((c.a)localObject2).d = true;
    ((c.a)localObject2).e = true;
    ((c.a)localObject2).f = true;
    ((c.a)localObject2).g = false;
    ((c.a)localObject2).i = new WeakReference(y());
    Object localObject3 = new v((c.a)localObject2);
    this.a = new com.tencent.luggage.standalone_ext.service.c();
    Object localObject1 = this.a;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mNodeInstaller");
    }
    localObject2 = (h)y();
    localObject3 = (i)localObject3;
    ((com.tencent.luggage.standalone_ext.service.c)localObject1).a((h)localObject2, (i)localObject3);
    return localObject3;
  }
  
  protected void h()
  {
    super.h();
    if (((c)this).a != null)
    {
      com.tencent.luggage.standalone_ext.service.c localc = this.a;
      if (localc == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mNodeInstaller");
      }
      localc.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.service.c
 * JD-Core Version:    0.7.0.1
 */