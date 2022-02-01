package com.tencent.luggage.wxa.cx;

import com.tencent.luggage.wxa.oy.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.keylogger.d;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "Lcom/tencent/mm/plugin/appbrand/appcache/IPkgInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class i$b$1
  extends Lambda
  implements Function1<List<? extends e>, Unit>
{
  i$b$1(i.b paramb)
  {
    super(1);
  }
  
  public final void a(@NotNull List<? extends e> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "it");
    i.a(this.a.a, this.a.g, paramList);
    if (this.a.h.get()) {
      d.a(this.a.b, a.r, "", this.a.i, af.d());
    } else {
      d.a(this.a.b, a.q, "", this.a.i, af.d());
    }
    this.a.j.a(new Object[] { this.a.g });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.i.b.1
 * JD-Core Version:    0.7.0.1
 */