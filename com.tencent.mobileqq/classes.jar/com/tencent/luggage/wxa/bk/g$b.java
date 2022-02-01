package com.tencent.luggage.wxa.bk;

import com.tencent.magicbrush.e;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class g$b
  extends Lambda
  implements Function0<Unit>
{
  g$b(g paramg)
  {
    super(0);
  }
  
  public final void a()
  {
    synchronized (this.a)
    {
      if (g.a(this.a) != null)
      {
        Object localObject1 = g.a(this.a);
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((e)localObject1).g();
        g.a(this.a, (e)null);
        localObject1 = Unit.INSTANCE;
        return;
      }
      throw ((Throwable)new IllegalStateException("Required value was null.".toString()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bk.g.b
 * JD-Core Version:    0.7.0.1
 */