package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "invoke"}, k=3, mv={1, 1, 16})
final class h$p
  extends Lambda
  implements Function1<Boolean, Unit>
{
  h$p(h paramh)
  {
    super(1);
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reconnect: isSuccess = ");
    ((StringBuilder)localObject).append(paramBoolean);
    o.d("MicroMsg.VideoCast.VideoCastController", ((StringBuilder)localObject).toString());
    if (paramBoolean)
    {
      localObject = this.a;
      ((h)localObject).a(h.i((h)localObject), 5);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.h.p
 * JD-Core Version:    0.7.0.1
 */