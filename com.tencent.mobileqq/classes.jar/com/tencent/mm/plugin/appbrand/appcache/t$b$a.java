package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.luggage.storage.b;
import com.tencent.luggage.util.e;
import com.tencent.luggage.wxa.dc.t;
import com.tencent.luggage.wxa.pc.i;
import com.tencent.luggage.wxa.qz.o;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class t$b$a
  implements Runnable
{
  public static final a a = new a();
  
  public final void run()
  {
    Object localObject1 = new i();
    if (s.a.a((i)localObject1, "checkIfDownload") != null) {
      return;
    }
    localObject1 = (ab)((i)localObject1).a;
    if (localObject1 != null)
    {
      if (((ab)localObject1).c <= c.a.c())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkIfDownload, skip by version, record(");
        ((StringBuilder)localObject2).append(((ab)localObject1).c);
        ((StringBuilder)localObject2).append(") <= asset(");
        ((StringBuilder)localObject2).append(c.a.c());
        ((StringBuilder)localObject2).append(')');
        o.d("Luggage.WxaCommLibPkgDownloader", ((StringBuilder)localObject2).toString());
        return;
      }
      Object localObject2 = t.a("lib", "", ((ab)localObject1).c, ((ab)localObject1).d, 0);
      try
      {
        Object localObject3 = e.a;
        String str = ((ab)localObject1).i;
        Intrinsics.checkExpressionValueIsNotNull(str, "record.field_downloadURL");
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "finalPkgPath");
        ((e)localObject3).b(str, (String)localObject2);
        localObject3 = af.c((String)localObject2);
        if ((Intrinsics.areEqual(localObject3, ((ab)localObject1).d) ^ true))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("checkIfDownload, download completed but md5 check failed, version(");
          ((StringBuilder)localObject2).append(((ab)localObject1).c);
          ((StringBuilder)localObject2).append(") file(");
          ((StringBuilder)localObject2).append((String)localObject3);
          ((StringBuilder)localObject2).append(")!=record(");
          ((StringBuilder)localObject2).append(((ab)localObject1).d);
          ((StringBuilder)localObject2).append(')');
          o.b("Luggage.WxaCommLibPkgDownloader", ((StringBuilder)localObject2).toString());
          return;
        }
        try
        {
          ((ab)localObject1).f = ((String)localObject2);
          ((ae)b.a(ae.class)).b((ab)localObject1);
          return;
        }
        catch (Throwable localThrowable)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("checkIfDownload, download completed but update record version(");
          ((StringBuilder)localObject3).append(((ab)localObject1).c);
          ((StringBuilder)localObject3).append(") md5(");
          ((StringBuilder)localObject3).append(((ab)localObject1).d);
          ((StringBuilder)localObject3).append(") failed by ");
          ((StringBuilder)localObject3).append(localThrowable);
          o.b("Luggage.WxaCommLibPkgDownloader", ((StringBuilder)localObject3).toString());
          localObject1 = Unit.INSTANCE;
          return;
        }
        return;
      }
      catch (IOException localIOException)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("checkIfDownload, download with version(");
        ((StringBuilder)localObject3).append(((ab)localObject1).c);
        ((StringBuilder)localObject3).append(") md5(");
        ((StringBuilder)localObject3).append(((ab)localObject1).d);
        ((StringBuilder)localObject3).append(") url(");
        ((StringBuilder)localObject3).append(((ab)localObject1).i);
        ((StringBuilder)localObject3).append("), failed by ");
        ((StringBuilder)localObject3).append(localIOException);
        o.b("Luggage.WxaCommLibPkgDownloader", ((StringBuilder)localObject3).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.t.b.a
 * JD-Core Version:    0.7.0.1
 */