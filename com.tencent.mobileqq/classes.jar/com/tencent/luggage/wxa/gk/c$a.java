package com.tencent.luggage.wxa.gk;

import com.tencent.luggage.wxa.gi.c.c;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)V"}, k=3, mv={1, 1, 13})
final class c$a
  extends Lambda
  implements Function1<T, Unit>
{
  c$a(Function1 paramFunction1)
  {
    super(1);
  }
  
  public final void a(T paramT)
  {
    try
    {
      this.a.invoke(paramT);
      return;
    }
    catch (Exception paramT)
    {
      c.c.a("MagicBrush", (Throwable)paramT, "dispatch failed", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gk.c.a
 * JD-Core Version:    0.7.0.1
 */