package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.ix.c.a;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "appId", "", "kotlin.jvm.PlatformType", "state", "Lcom/tencent/mm/plugin/appbrand/appstate/AppRunningState;", "onRunningStateChanged", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1$1$1", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1$$special$$inlined$apply$lambda$1"}, k=3, mv={1, 1, 16})
final class b$a$a$1
  implements c.a
{
  b$a$a$1(b.a.a parama) {}
  
  public final void a(String arg1, com.tencent.luggage.wxa.ix.b paramb)
  {
    if (paramb == com.tencent.luggage.wxa.ix.b.d)
    {
      b.c();
      synchronized (b.b())
      {
        b.c();
        paramb = (b)b.b().remove(this.a.a.aa());
        if (paramb != null)
        {
          b.b(paramb);
          paramb = Unit.INSTANCE;
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.b.a.a.1
 * JD-Core Version:    0.7.0.1
 */