package com.tencent.luggage.wxa.nl;

import com.tencent.luggage.wxa.qw.ca;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.luggage.wxa.ro.h;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class d$b$a
  implements Runnable
{
  d$b$a(d.b paramb, k.b paramb1, ca[] paramArrayOfca) {}
  
  public final void a()
  {
    int i;
    if (this.b.i())
    {
      Object localObject = (ca)ArraysKt.getOrNull(this.c, 0);
      if (localObject != null)
      {
        i = ((ca)localObject).e;
      }
      else
      {
        localObject = this.a;
        d.c();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Downloader.start, get invalid app_version using needLatestVersion, request=");
        ((StringBuilder)localObject).append(this.b);
        o.b("MicroMsg.AppBrand.CommonPkgFetcher", ((StringBuilder)localObject).toString());
        d.b(this.a.a).invoke(j.a.b, "invalid cgi response");
      }
    }
    else
    {
      i = this.b.e();
    }
    h.a().a((b)new d.b.a.1(this, i)).a((e.c)d.b.a.2.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nl.d.b.a
 * JD-Core Version:    0.7.0.1
 */