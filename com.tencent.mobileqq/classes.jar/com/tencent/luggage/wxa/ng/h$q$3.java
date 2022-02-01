package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.ge.a;
import com.tencent.luggage.wxa.jo.c;
import com.tencent.luggage.wxa.pc.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "device", "Lcom/tencent/mm/plugin/appbrand/dlna/device/MRDevice;", "<anonymous parameter 1>", "", "invoke"}, k=3, mv={1, 1, 16})
final class h$q$3
  extends Lambda
  implements Function2<c, Integer, Unit>
{
  h$q$3(h.q paramq)
  {
    super(2);
  }
  
  public final void a(@Nullable c paramc, int paramInt)
  {
    if (paramc == null)
    {
      h.g(this.a.a).b(false);
      h.a(this.a.a).a(null);
      h.a(this.a.a).f();
      return;
    }
    h.g(this.a.a).b(true);
    if (this.a.a.b() != null)
    {
      Object localObject = this.a.a.b();
      if (localObject != null) {
        localObject = (Unit)((Function0)localObject).invoke();
      }
    }
    h.d(this.a.a).a(paramc);
    this.a.a.a(3);
    if (this.a.c) {
      l.a((Runnable)new h.q.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.h.q.3
 * JD-Core Version:    0.7.0.1
 */