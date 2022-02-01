package com.tencent.luggage.wxa.kg;

import com.tencent.luggage.wxa.kn.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "success", "", "invoke"}, k=3, mv={1, 1, 16})
final class c$b
  extends Lambda
  implements Function1<Boolean, Unit>
{
  c$b(c paramc, int paramInt, com.tencent.luggage.wxa.jx.c paramc1)
  {
    super(1);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b.a(this.a, this.b, this.c, null, 4, null);
      return;
    }
    b.a(this.a, this.b, this.c, 10008, "fail:system error, add service fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.c.b
 * JD-Core Version:    0.7.0.1
 */