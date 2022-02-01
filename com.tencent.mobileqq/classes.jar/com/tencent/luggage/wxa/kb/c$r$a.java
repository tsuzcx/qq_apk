package com.tencent.luggage.wxa.kb;

import com.tencent.luggage.wxa.jx.m.a;
import com.tencent.luggage.wxa.ro.b;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.plugin.appbrand.phonenumber.s;
import com.tencent.mm.plugin.appbrand.phonenumber.z;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "result", "", "", "invoke", "com/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$showPhoneNumberDialog$5$1$1"}, k=3, mv={1, 1, 16})
final class c$r$a
  extends Lambda
  implements Function2<Boolean, Map<String, ? extends String>, Unit>
{
  c$r$a(c.r paramr, r paramr1)
  {
    super(2);
  }
  
  public final void a(boolean paramBoolean, @NotNull Map<String, String> paramMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "result");
    if (paramBoolean)
    {
      paramBoolean = this.b.i();
      Object localObject2 = null;
      Object localObject1 = null;
      if (paramBoolean)
      {
        localObject2 = this.a.a;
        if (localObject2 != null)
        {
          localObject3 = this.a.a;
          if (localObject3 != null) {
            localObject1 = Long.valueOf(((z)localObject3).f());
          }
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          ((z)localObject2).g(((Long)localObject1).longValue() + 1L);
        }
      }
      else
      {
        localObject3 = this.a.a;
        if (localObject3 != null)
        {
          localObject4 = this.a.a;
          localObject1 = localObject2;
          if (localObject4 != null) {
            localObject1 = Long.valueOf(((z)localObject4).g());
          }
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          ((z)localObject3).h(((Long)localObject1).longValue() + 1L);
        }
      }
      localObject2 = this.a.d;
      Object localObject3 = new m.a("ok", new Object[0]);
      Object localObject4 = new HashMap();
      localObject1 = (String)paramMap.get("encryptedData");
      if (localObject1 == null) {
        localObject1 = "";
      }
      ((HashMap)localObject4).put("encryptedData", localObject1);
      paramMap = (String)paramMap.get("iv");
      if (paramMap == null) {
        paramMap = "";
      }
      ((HashMap)localObject4).put("iv", paramMap);
      ((m.a)localObject3).a((Map)localObject4);
      ((b)localObject2).a(new Object[] { localObject3 });
      s.a.a(this.b);
      return;
    }
    this.a.d.a(paramMap.get("errMsg"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.c.r.a
 * JD-Core Version:    0.7.0.1
 */