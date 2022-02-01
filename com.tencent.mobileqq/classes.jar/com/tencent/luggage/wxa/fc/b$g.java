package com.tencent.luggage.wxa.fc;

import com.tencent.luggage.opensdk.a.a;
import com.tencent.luggage.opensdk.a.b;
import com.tencent.luggage.opensdk.a.b.a;
import com.tencent.luggage.opensdk.a.c;
import com.tencent.luggage.wxa.eo.a;
import com.tencent.luggage.wxa.jj.h;
import com.tencent.luggage.wxa.jj.j;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.mm.plugin.appbrand.page.o;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class b$g
  implements Runnable
{
  b$g(b paramb, com.tencent.luggage.wxa.standalone_open_runtime.ui.e parame, com.tencent.luggage.wxa.iu.b paramb1, String paramString, int paramInt, JSONObject paramJSONObject) {}
  
  public final void run()
  {
    Object localObject1 = this.b;
    Object localObject2 = this.c.q();
    Object localObject3 = b.d.C;
    Object localObject4 = this.c.q();
    Intrinsics.checkExpressionValueIsNotNull(localObject4, "env.runtime");
    localObject4 = ((com.tencent.luggage.wxa.iu.d)localObject4).B();
    if (localObject4 != null)
    {
      localObject3 = ((b.d.a)localObject3).a((a)localObject4);
      ((b.d)localObject3).D = this.d;
      localObject4 = new com.tencent.luggage.wxa.ou.d();
      ((com.tencent.luggage.wxa.ou.d)localObject4).c = 1037;
      ((b.d)localObject3).a((com.tencent.luggage.wxa.ou.d)localObject4);
      localObject4 = ((b.d)localObject3).h;
      ((j)localObject4).b = this.c.getAppId();
      ((j)localObject4).a = 1;
      Object localObject5 = this.c.q();
      Intrinsics.checkExpressionValueIsNotNull(localObject5, "env.runtime");
      localObject5 = ((com.tencent.luggage.wxa.iu.d)localObject5).C();
      Intrinsics.checkExpressionValueIsNotNull(localObject5, "env.runtime.pageContainer");
      ((j)localObject4).f = ((o)localObject5).getCurrentUrl();
      ((com.tencent.luggage.wxa.standalone_open_runtime.ui.e)localObject1).a((com.tencent.luggage.wxa.iu.d)localObject2, (h)localObject3);
      localObject1 = (com.tencent.luggage.wxa.ed.d)this.b.getActiveRuntime();
      if (localObject1 != null)
      {
        localObject1 = (b.e)localObject1;
        localObject2 = a.b.a.a(this.c);
        com.tencent.luggage.wxa.ef.i.a.a((com.tencent.luggage.wxa.iu.d)localObject1, (Function1)new b.g.1((a.b)localObject2));
        localObject3 = new b.g.2(this);
        localObject4 = com.tencent.luggage.opensdk.i.a;
        localObject5 = new a.c();
        ((a.c)localObject5).a = ((a.a)localObject2);
        ((a.c)localObject5).b = "sdk_navigateToMiniProgram";
        ((a.c)localObject5).c = this.f.toString();
        ((a.c)localObject5).d = this.e;
        ((a.c)localObject5).e = 1;
        ((com.tencent.luggage.opensdk.i)localObject4).a((a.c)localObject5).a((e.c)new b.g.3(this, (b.e)localObject1, (b.g.2)localObject3)).a((e.a)new b.g.4((b.g.2)localObject3, (b.e)localObject1));
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.luggage.wxa.standalone_open_runtime.jsapi.JsApiNavigateToMiniProgramBridged.BridgedWxaRuntime");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.luggage.standalone_ext.config.RuntimeSDKInitConfigBase");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fc.b.g
 * JD-Core Version:    0.7.0.1
 */