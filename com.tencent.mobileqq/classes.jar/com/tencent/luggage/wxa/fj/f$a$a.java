package com.tencent.luggage.wxa.fj;

import com.tencent.ilinkservice.aq;
import com.tencent.luggage.wxa.dj.g;
import com.tencent.luggage.wxa.dj.h;
import com.tencent.luggage.wxa.dj.h.b;
import com.tencent.luggage.wxa.dj.h.d;
import com.tencent.luggage.wxa.fv.a;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/wxa/standalone_open_runtime/report/SmcReporter$REPORTER$2$reporter$1", "Lcom/tencent/luggage/reporter/SmcKVReportSessionHolder;", "session", "Lcom/tencent/luggage/reporter/SmcKVReportSessionInterface$SessionAdapter;", "getReportSession", "Lcom/tencent/luggage/reporter/SmcKVReportSessionInterface;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class f$a$a
  implements g
{
  private h.d a;
  
  @Nullable
  public h a()
  {
    aq localaq = a.c.i();
    Object localObject = null;
    if (localaq != null)
    {
      h.d locald = this.a;
      if (locald != null) {
        localObject = locald.a();
      }
      if (Intrinsics.areEqual(localObject, localaq)) {
        return (h)this.a;
      }
      localObject = h.b.a(localaq);
      if (localObject != null)
      {
        this.a = ((h.d)localObject);
        return localObject;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.luggage.reporter.SmcKVReportSessionInterface.SessionAdapter");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fj.f.a.a
 * JD-Core Version:    0.7.0.1
 */