package com.tencent.luggage.opensdk;

import com.tencent.luggage.wxa.qt.a;
import com.tencent.luggage.wxa.ro.b;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class i$b$f$1
  implements Runnable
{
  i$b$f$1(i.b.f paramf, b paramb, a parama, String paramString) {}
  
  public final void run()
  {
    Object localObject = i.b.b(this.a.a).a;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "request.env");
    if (!((a.a)localObject).c())
    {
      this.b.a(i.b.a(this.a.a, i.b.b(this.a.a), "switch to foreground by user manually", null, 2, null));
      return;
    }
    if (!this.c.a)
    {
      i.b.c(this.a.a);
      localObject = i.b.b(this.a.a);
      String str = this.d;
      Intrinsics.checkExpressionValueIsNotNull(str, "ticket");
      new j((a.c)localObject, str, (Function1)new i.b.f.1.1(this), (Function1)new i.b.f.1.2(this)).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.opensdk.i.b.f.1
 * JD-Core Version:    0.7.0.1
 */