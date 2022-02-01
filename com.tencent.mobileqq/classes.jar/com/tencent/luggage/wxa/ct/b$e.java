package com.tencent.luggage.wxa.ct;

import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.jx.u;
import com.tencent.luggage.wxa.pc.i;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class b$e
  extends Lambda
  implements Function0<Unit>
{
  b$e(b paramb, i parami, m paramm, JSONObject paramJSONObject)
  {
    super(0);
  }
  
  public final void a()
  {
    i locali = this.b;
    m localm = this.c;
    if (localm != null)
    {
      locali.a = ((u)localm).a((c)this.a, this.d);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mm.plugin.appbrand.jsapi.AppBrandSyncJsApi<com.tencent.mm.plugin.appbrand.jsapi.AppBrandComponent>");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.b.e
 * JD-Core Version:    0.7.0.1
 */