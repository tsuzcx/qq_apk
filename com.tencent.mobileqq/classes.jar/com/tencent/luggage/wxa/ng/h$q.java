package com.tencent.luggage.wxa.ng;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class h$q
  implements Runnable
{
  h$q(h paramh, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void run()
  {
    h localh = this.a;
    h.a(localh, new g(h.b(localh), false, h.c(this.a), h.d(this.a), this.b, 2, null));
    h.a(this.a).a((Function0)new h.q.1(this));
    h.a(this.a).a((Function1)new h.q.2(this));
    h.a(this.a).a((Function2)new h.q.3(this));
    h.a(this.a).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.h.q
 * JD-Core Version:    0.7.0.1
 */