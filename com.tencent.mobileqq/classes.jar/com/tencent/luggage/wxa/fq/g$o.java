package com.tencent.luggage.wxa.fq;

import android.content.Context;
import com.tencent.luggage.wxaapi.TdiAuthCheckStateListener;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class g$o
  extends Lambda
  implements Function0<Unit>
{
  g$o(g paramg, String paramString1, Context paramContext, int paramInt, String paramString2, String paramString3, long paramLong, Map paramMap)
  {
    super(0);
  }
  
  public final void a()
  {
    this.a.checkAuthState((TdiAuthCheckStateListener)new g.o.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.o
 * JD-Core Version:    0.7.0.1
 */