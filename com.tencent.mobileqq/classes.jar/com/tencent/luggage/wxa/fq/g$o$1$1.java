package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxa.hd.g;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class g$o$1$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(g.c.a.a());
    localStringBuilder.append('#');
    localStringBuilder.append(g.c.a.b());
    g.a(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.o.1.1
 * JD-Core Version:    0.7.0.1
 */