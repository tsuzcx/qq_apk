package com.tencent.luggage.wxa.standalone_open_runtime;

import com.tencent.luggage.wxa.em.c;
import com.tencent.luggage.wxa.jx.aa;
import com.tencent.luggage.wxa.jx.bb;
import com.tencent.luggage.wxa.jx.w;
import com.tencent.luggage.wxa.ou.m;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxa/standalone_open_runtime/WxaPageView$createMenuInfoList$1$6$1$1", "Lcom/tencent/mm/plugin/appbrand/jsapi/IReturnCopyUrlWatcher;", "onReturnUrl", "", "url", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class e$n$1
  implements aa
{
  e$n$1(e parame) {}
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    int i = 0;
    o.d("Wxa.WxaPageView", "onReturnUrl %s", new Object[] { paramString });
    m localm = m.a;
    c localc = (c)this.a;
    if (((CharSequence)paramString).length() == 0) {
      i = 1;
    }
    if (i != 0) {
      i = 2;
    } else {
      i = 1;
    }
    m.a(localm, localc, 47, null, 0L, i, 0, 44, null);
    bb.a.a(w.a, (aa)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.e.n.1
 * JD-Core Version:    0.7.0.1
 */