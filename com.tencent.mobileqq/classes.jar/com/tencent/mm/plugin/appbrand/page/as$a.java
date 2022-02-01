package com.tencent.mm.plugin.appbrand.page;

import com.tencent.luggage.wxa.do.d;
import com.tencent.luggage.wxa.dq.c;
import com.tencent.mm.plugin.appbrand.appcache.af;
import com.tencent.mm.plugin.appbrand.appcache.ai;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper$Factory;", "", "()V", "createInjector", "Lcom/tencent/mm/plugin/appbrand/page/IWxaPageSeparatedPluginsInjectHelper;", "renderer", "Lcom/tencent/mm/plugin/appbrand/page/AbstractMPPageViewRenderer;", "IMPL", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class as$a
{
  @NotNull
  public final as a(@NotNull a<?> parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "renderer");
    Object localObject = (c)parama.y();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((d)((c)localObject).b(d.class)).S;
    if (localObject != null)
    {
      ai localai = ((af)localObject).f;
      if (localai != null)
      {
        i = localai.b();
        break label60;
      }
    }
    int i = 0;
    label60:
    if (i > 0)
    {
      localObject = ((af)localObject).f;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject, "wrappingInfo.separatedPlugins!!");
      return (as)new as.a.a(parama, (ai)localObject);
    }
    return (as)new as.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.as.a
 * JD-Core Version:    0.7.0.1
 */