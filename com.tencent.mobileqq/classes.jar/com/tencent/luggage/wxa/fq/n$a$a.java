package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.w;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class n$a$a
  extends Lambda
  implements Function0<Unit>
{
  n$a$a(n.a parama)
  {
    super(0);
  }
  
  public final void a()
  {
    long l1 = n.a(this.a.a).getLong(n.b(this.a.a), 0L);
    long l2 = af.d();
    int i = 1;
    if ((l1 <= l2) && (af.d(l1) < this.a.a.c())) {
      i = 0;
    }
    if (i != 0) {
      try
      {
        this.a.a.b();
        return;
      }
      finally
      {
        n.a(this.a.a).putLong(n.b(this.a.a), l2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.n.a.a
 * JD-Core Version:    0.7.0.1
 */