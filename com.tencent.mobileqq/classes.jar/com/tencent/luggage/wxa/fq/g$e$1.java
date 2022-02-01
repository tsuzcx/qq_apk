package com.tencent.luggage.wxa.fq;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "invoke"}, k=3, mv={1, 1, 16})
final class g$e$1
  extends Lambda
  implements Function1<Boolean, Unit>
{
  g$e$1(g.e parame)
  {
    super(1);
  }
  
  public final void a(boolean paramBoolean)
  {
    BuildersKt.launch$default((CoroutineScope)GlobalScope.INSTANCE, null, null, (Function2)new g.e.1.1(this, null), 3, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.e.1
 * JD-Core Version:    0.7.0.1
 */