package com.tencent.luggage.wxa.ea;

import com.tencent.luggage.wxa.hj.m;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "PARAMS", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "onDied"}, k=3, mv={1, 1, 16})
final class b$b
  implements m
{
  b$b(b paramb) {}
  
  public final void a()
  {
    b.a(this.a).set(false);
    o.d("Luggage.LuggageMiniProgramProcess", "[%s] died", new Object[] { this.a.c() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ea.b.b
 * JD-Core Version:    0.7.0.1
 */