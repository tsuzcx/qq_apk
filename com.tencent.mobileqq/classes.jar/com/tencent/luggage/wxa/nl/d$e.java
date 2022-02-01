package com.tencent.luggage.wxa.nl;

import android.util.Pair;
import com.tencent.luggage.wxa.qw.ca;
import com.tencent.luggage.wxa.qw.gs;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.plugin.appbrand.appcache.ab;
import com.tencent.mm.plugin.appbrand.appcache.g;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.appcache.z;
import com.tencent.mm.plugin.appbrand.appcache.z.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "urls", "", "Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;", "Lcom/tencent/mm/plugin/appbrand/launching/LocalUnifiedGetDownloadUrlResp;", "invoke", "([Lcom/tencent/mm/protocal/protobuf/GetDownloadUrlRespItem;)V"}, k=3, mv={1, 1, 16})
final class d$e
  extends Lambda
  implements Function1<ca[], Unit>
{
  d$e(d paramd, k.b paramb)
  {
    super(1);
  }
  
  public final void a(@NotNull ca[] paramArrayOfca)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfca, "urls");
    int i = 0;
    Object localObject2 = paramArrayOfca[0];
    if (localObject2 != null)
    {
      if (this.b.i()) {
        d.f(this.a).a(((ca)localObject2).h.a, ((ca)localObject2).e, ((ca)localObject2).i);
      }
      Object localObject1 = d.f(this.a).a(d.c(this.a).toString(), ((ca)localObject2).e, d.e(this.a).e(), new String[0]);
      if (localObject1 == null)
      {
        localObject1 = new ab();
        ((ab)localObject1).b = d.c(this.a).toString();
        ((ab)localObject1).c = 0;
        ((ab)localObject1).h = d.e(this.a).e();
      }
      Object localObject3 = ((ab)localObject1).d;
      Object localObject4 = ((ab)localObject1).e;
      Object localObject5 = (CharSequence)((ab)localObject1).d;
      if ((localObject5 == null) || (((CharSequence)localObject5).length() == 0)) {
        i = 1;
      }
      if (i != 0) {
        ((ab)localObject1).d = ((ca)localObject2).c;
      }
      ((ab)localObject1).e = ((ca)localObject2).c;
      ((ab)localObject1).c = ((ca)localObject2).e;
      ((ab)localObject1).i = ((ca)localObject2).b;
      ((ab)localObject1).g = com.tencent.luggage.wxa.qz.af.a();
      boolean bool = d.f(this.a).a((ab)localObject1);
      d.c();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("cgiExecutor.onSuccess, updated(");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(") md5(");
      ((StringBuilder)localObject2).append((String)localObject3);
      ((StringBuilder)localObject2).append('|');
      ((StringBuilder)localObject2).append((String)localObject4);
      ((StringBuilder)localObject2).append(")->(");
      ((StringBuilder)localObject2).append(((ab)localObject1).d);
      ((StringBuilder)localObject2).append('|');
      ((StringBuilder)localObject2).append(((ab)localObject1).e);
      ((StringBuilder)localObject2).append(") with key(");
      ((StringBuilder)localObject2).append(((ab)localObject1).b);
      ((StringBuilder)localObject2).append("), versionType(");
      ((StringBuilder)localObject2).append(((ab)localObject1).h);
      ((StringBuilder)localObject2).append("), version(");
      ((StringBuilder)localObject2).append(((ab)localObject1).c);
      ((StringBuilder)localObject2).append(')');
      o.d("MicroMsg.AppBrand.CommonPkgFetcher", ((StringBuilder)localObject2).toString());
      if (this.b.i())
      {
        localObject2 = z.a.a(((ab)localObject1).b, ((ab)localObject1).h, ((ab)localObject1).c);
        localObject3 = (z.a)e.a((Pair)localObject2);
        localObject2 = (com.tencent.mm.plugin.appbrand.appcache.af)e.b((Pair)localObject2);
        if (localObject2 != null)
        {
          d.c();
          paramArrayOfca = new StringBuilder();
          paramArrayOfca.append("cgiExecutor.onSuccess, latest request already cached, request=");
          paramArrayOfca.append(d.e(this.a));
          o.d("MicroMsg.AppBrand.CommonPkgFetcher", paramArrayOfca.toString());
          paramArrayOfca = d.d(this.a);
          localObject3 = d.c.a;
          localObject4 = d.e(this.a);
          localObject5 = ((com.tencent.mm.plugin.appbrand.appcache.af)localObject2).pkgPath;
          Intrinsics.checkExpressionValueIsNotNull(localObject5, "pkg.pkgPath");
          paramArrayOfca.invoke(((d.c)localObject3).a((j.d)localObject4, (String)localObject5, ((com.tencent.mm.plugin.appbrand.appcache.af)localObject2).md5, ((ab)localObject1).c, j.f.a));
          return;
        }
        d.c();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("cgiExecutor.onSuccess, latest request find cached pkg with error:");
        ((StringBuilder)localObject2).append(localObject3);
        ((StringBuilder)localObject2).append(" request:");
        ((StringBuilder)localObject2).append(d.e(this.a));
        o.d("MicroMsg.AppBrand.CommonPkgFetcher", ((StringBuilder)localObject2).toString());
        if ((localObject3 == z.a.f) || (localObject3 == z.a.b))
        {
          d.b(this.a).invoke(j.a.j, "find cached pkg failed");
          return;
        }
      }
      localObject1 = d.c.a.a(d.e(this.a), (ab)localObject1);
      if (localObject1 != null)
      {
        d.d(this.a).invoke(localObject1);
        return;
      }
      new d.b(this.a).a(this.b, paramArrayOfca);
      return;
    }
    ((Function0)new d.e.a(this)).invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.d.e
 * JD-Core Version:    0.7.0.1
 */