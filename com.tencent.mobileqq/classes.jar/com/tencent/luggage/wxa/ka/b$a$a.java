package com.tencent.luggage.wxa.ka;

import com.tencent.luggage.wxa.ix.c;
import com.tencent.luggage.wxa.ix.c.a;
import com.tencent.luggage.wxa.jj.g;
import com.tencent.luggage.wxa.jj.l;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue;", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/auth/AppBrandAuthJSAPIConcurrentQueue$Companion$obtainByRuntime$1$1"}, k=3, mv={1, 1, 16})
final class b$a$a
  extends Lambda
  implements Function0<b>
{
  b$a$a(com.tencent.luggage.wxa.iu.d paramd)
  {
    super(0);
  }
  
  @NotNull
  public final b a()
  {
    l locall = this.a.A();
    Object localObject = locall;
    if (!(locall instanceof com.tencent.luggage.wxa.do.d)) {
      localObject = null;
    }
    localObject = (com.tencent.luggage.wxa.do.d)localObject;
    if (localObject != null)
    {
      localObject = ((com.tencent.luggage.wxa.do.d)localObject).D;
      if (localObject != null)
      {
        i = ((g)localObject).G;
        break label48;
      }
    }
    int i = 10;
    label48:
    localObject = new b(i);
    b.c();
    b.b().put(this.a.aa(), localObject);
    this.a.al().a((c.a)new b.a.a.1(this));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.b.a.a
 * JD-Core Version:    0.7.0.1
 */