package com.tencent.luggage.wxa.fq;

import com.tencent.luggage.wxaapi.TdiAuthCheckStateListener;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class g$l$1
  extends Lambda
  implements Function0<Unit>
{
  g$l$1(g.l paraml, String paramString)
  {
    super(0);
  }
  
  public final void a()
  {
    this.a.a.checkAuthState((TdiAuthCheckStateListener)new g.l.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.l.1
 * JD-Core Version:    0.7.0.1
 */