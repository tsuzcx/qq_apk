package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.e;
import java.util.HashSet;
import java.util.concurrent.ConcurrentSkipListSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "response", "Lcom/tencent/mm/plugin/appbrand/launching/ICommonPkgFetcher$Response;", "invoke"}, k=3, mv={1, 1, 16})
final class b$d
  extends Lambda
  implements Function1<j.e, Unit>
{
  b$d(ConcurrentSkipListSet paramConcurrentSkipListSet, j.d paramd, b.b paramb, b.c paramc, HashSet paramHashSet, Function1 paramFunction1, b.a parama)
  {
    super(1);
  }
  
  public final void a(@NotNull j.e parame)
  {
    Intrinsics.checkParameterIsNotNull(parame, "response");
    boolean bool = this.a.add(parame.a());
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("waitForPkg ");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(" onSuccess(");
    ((StringBuilder)localObject).append(parame.a().pkgVersion());
    ((StringBuilder)localObject).append('|');
    ((StringBuilder)localObject).append(parame.b());
    ((StringBuilder)localObject).append(") added(");
    ((StringBuilder)localObject).append(bool);
    ((StringBuilder)localObject).append(')');
    o.d("MicroMsg.AppBrand.BatchGetCodePkgExecutor", ((StringBuilder)localObject).toString());
    if (bool)
    {
      if (parame.b() == j.f.a) {
        this.c.a();
      }
      localObject = this.d;
      j.d locald = this.b;
      Intrinsics.checkExpressionValueIsNotNull(locald, "request");
      parame = parame.a().pkgPath();
      Intrinsics.checkExpressionValueIsNotNull(parame, "response.pkgInfo.pkgPath()");
      ((b.c)localObject).a(locald, parame);
      if (this.a.size() == this.e.size())
      {
        this.f.invoke(CollectionsKt.toList((Iterable)this.a));
        parame = this.g;
        if (parame != null) {
          parame.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.b.d
 * JD-Core Version:    0.7.0.1
 */