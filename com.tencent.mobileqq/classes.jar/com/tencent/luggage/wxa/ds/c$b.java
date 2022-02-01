package com.tencent.luggage.wxa.ds;

import android.os.Looper;
import com.tencent.luggage.wxa.qz.v;
import com.tencent.luggage.wxa.qz.v.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "invoke"}, k=3, mv={1, 1, 16})
final class c$b
  extends Lambda
  implements Function0<v>
{
  c$b(c paramc)
  {
    super(0);
  }
  
  @NotNull
  public final v a()
  {
    return new v(Looper.getMainLooper(), (v.a)new c.b.1(this), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ds.c.b
 * JD-Core Version:    0.7.0.1
 */