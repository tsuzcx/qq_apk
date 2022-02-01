package com.tencent.luggage.wxa.fs;

import android.content.Context;
import com.tencent.luggage.wxa.fq.b;
import com.tencent.luggage.wxa.fq.g.d;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.standalone_open_runtime.container.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class b$b
  extends Lambda
  implements Function0<Unit>
{
  b$b(Context paramContext, String paramString, long paramLong)
  {
    super(0);
  }
  
  public final void a()
  {
    a.a.b();
    b localb = b.a;
    Context localContext = this.a;
    if (localContext == null)
    {
      localContext = r.a();
      Intrinsics.checkExpressionValueIsNotNull(localContext, "MMApplicationContext.getContext()");
    }
    b.a(localb, localContext, this.b, this.c, null, 8, null);
    g.d.a(g.d.a, "launchByQRRawData", true, null, 0, 12, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fs.b.b
 * JD-Core Version:    0.7.0.1
 */