package com.tencent.luggage.wxa.cx;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class s$b$c$1
  extends Lambda
  implements Function0<Unit>
{
  s$b$c$1(s.b.c paramc)
  {
    super(0);
  }
  
  public final void a()
  {
    if (!this.a.a.isCompleted()) {
      JobKt.cancel$default(this.a.a, "Runtime finished", null, 2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cx.s.b.c.1
 * JD-Core Version:    0.7.0.1
 */