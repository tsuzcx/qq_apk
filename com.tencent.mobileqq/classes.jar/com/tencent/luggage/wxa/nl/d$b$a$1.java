package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.fw.c;
import com.tencent.luggage.wxa.qw.ca;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.n;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Ljava/lang/Void;", "kotlin.jvm.PlatformType", "invoke"}, k=3, mv={1, 1, 16})
final class d$b$a$1<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  d$b$a$1(d.b.a parama, int paramInt) {}
  
  public final void a(Void paramVoid)
  {
    paramVoid = this.a.c[0];
    if (paramVoid == null) {
      Intrinsics.throwNpe();
    }
    paramVoid = (CharSequence)paramVoid.b;
    if ((paramVoid != null) && (paramVoid.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      d.b(this.a.a.a).invoke(j.a.b, "invalid url");
      return;
    }
    d.c();
    paramVoid = new StringBuilder();
    paramVoid.append("Downloader.fallbackLegacy with ");
    paramVoid.append(this.a.b);
    o.d("MicroMsg.AppBrand.CommonPkgFetcher", paramVoid.toString());
    paramVoid = c.a;
    n localn = d.c(this.a.a.a);
    int i = this.a.b.d();
    int j = this.b;
    Object localObject = this.a.c[0];
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((ca)localObject).b;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "urls[LEGACY]!!.url");
    paramVoid.a(localn, i, j, (String)localObject, (com.tencent.luggage.wxa.fw.b)new d.b.a.1.1(this), (Function1)new d.b.a.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.d.b.a.1
 * JD-Core Version:    0.7.0.1
 */