package com.tencent.luggage.wxa.ed;

import com.tencent.luggage.wxa.do.c;
import com.tencent.mm.plugin.appbrand.appcache.ad;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import com.tencent.mm.plugin.appbrand.appcache.aj;
import com.tencent.mm.plugin.appbrand.appcache.ak.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/runtime/RuntimePkgReaderFactoryInterceptorImpl;", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaRuntimePkgReaderInternalImplFactory$FactoryInterceptor;", "()V", "forceNewReader", "", "getForceNewReader", "()Z", "setForceNewReader", "(Z)V", "forceNewReaderForGame", "getForceNewReaderForGame", "setForceNewReaderForGame", "createInternalReader", "Lcom/tencent/mm/plugin/appbrand/appcache/IWxaPkgRuntimeReader;", "rt", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "wrapper", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgRuntimeReader;", "isGame", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class h
  implements ak.a
{
  public static final h a = new h();
  private static volatile boolean b;
  private static volatile boolean c;
  
  private final boolean a(@NotNull com.tencent.luggage.wxa.iu.d paramd)
  {
    com.tencent.luggage.wxa.jj.h localh = paramd.B();
    paramd = localh;
    if (!(localh instanceof c)) {
      paramd = null;
    }
    paramd = (c)paramd;
    return (paramd != null) && (paramd.c == 4);
  }
  
  @Nullable
  public com.tencent.mm.plugin.appbrand.appcache.h a(@NotNull com.tencent.luggage.wxa.iu.d paramd, @NotNull ad paramad)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "rt");
    Intrinsics.checkParameterIsNotNull(paramad, "wrapper");
    Object localObject = (com.tencent.luggage.wxa.do.d)paramd.a(com.tencent.luggage.wxa.do.d.class, false);
    if (localObject != null)
    {
      localObject = ((com.tencent.luggage.wxa.do.d)localObject).S;
      if (localObject != null)
      {
        localObject = ((af)localObject).f;
        if ((localObject != null) && (!((ai)localObject).a()))
        {
          paramd = new aj(paramd);
          break label118;
        }
      }
    }
    if ((b) && (!a(paramd))) {
      paramd = new aj(paramd);
    } else if ((c) && (a(paramd))) {
      paramd = new aj(paramd);
    } else {
      paramd = null;
    }
    label118:
    if (paramd != null)
    {
      paramad.f("__plugin__/");
      paramad.f("__extended__/");
    }
    else
    {
      paramd = null;
    }
    return (com.tencent.mm.plugin.appbrand.appcache.h)paramd;
  }
  
  public final void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public final void b(boolean paramBoolean)
  {
    c = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ed.h
 * JD-Core Version:    0.7.0.1
 */