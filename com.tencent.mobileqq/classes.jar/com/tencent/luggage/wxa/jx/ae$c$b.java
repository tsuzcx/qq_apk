package com.tencent.luggage.wxa.jx;

import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.ah;
import com.tencent.luggage.wxa.qw.ai;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class ae$c$b
  implements Runnable
{
  ae$c$b(ae.c paramc, ah paramah, Function1 paramFunction11, Function1 paramFunction12) {}
  
  public final void run()
  {
    Object localObject = ae.c.d(this.a);
    ae.c();
    d locald = ((b)localObject).b(ae.a, ae.c.e(this.a), (a)this.b, ai.class);
    Function1 localFunction1 = this.c;
    localObject = localFunction1;
    if (localFunction1 != null) {
      localObject = new af(localFunction1);
    }
    locald.a((e.c)localObject).a((e.a)new ae.c.b.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jx.ae.c.b
 * JD-Core Version:    0.7.0.1
 */