package com.tencent.mm.plugin.appbrand.phonenumber;

import com.tencent.luggage.wxa.kb.c.b;
import com.tencent.luggage.wxa.qw.dy;
import com.tencent.luggage.wxa.qw.et;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/JSOperateWxDataResponse;", "kotlin.jvm.PlatformType", "call"}, k=3, mv={1, 1, 16})
final class d$a<_Ret, _Var>
  implements com.tencent.luggage.wxa.rl.b<_Ret, _Var>
{
  d$a(Function4 paramFunction4) {}
  
  public final void a(et paramet)
  {
    o.d("Luggage.FULL.CgiPhoneNumber", "getPhoneNumber success");
    int j = paramet.a.a;
    Object localObject1 = paramet.a.b;
    int k = h.a.a();
    int i = 0;
    if (j != k)
    {
      paramet = new StringBuilder();
      paramet.append("jsErrcode:");
      paramet.append(j);
      paramet.append(", jsErrmsg:");
      paramet.append((String)localObject1);
      o.b("Luggage.FULL.CgiPhoneNumber", paramet.toString());
      localObject2 = this.a;
      if (localObject2 != null)
      {
        if (localObject1 != null) {
          paramet = (et)localObject1;
        } else {
          paramet = "";
        }
        paramet = (Unit)((Function4)localObject2).invoke(Boolean.valueOf(false), paramet, null, null);
      }
      return;
    }
    Object localObject2 = new JSONObject(paramet.b.d());
    localObject1 = new ArrayList();
    Object localObject3 = r.a;
    String str = ((JSONObject)localObject2).optString("wx_phone");
    Intrinsics.checkExpressionValueIsNotNull(str, "phoneItemsJsonObj.optString(\"wx_phone\")");
    localObject3 = ((r.a)localObject3).a(str);
    if (localObject3 != null)
    {
      ((r)localObject3).a(true);
      ((ArrayList)localObject1).add(localObject3);
    }
    localObject2 = ((JSONObject)localObject2).optJSONArray("custom_phone_list");
    if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
    {
      j = ((JSONArray)localObject2).length();
      while (i < j)
      {
        localObject3 = r.a;
        str = ((JSONArray)localObject2).getString(i);
        Intrinsics.checkExpressionValueIsNotNull(str, "customPhoneItemsObjArray.getString(i)");
        localObject3 = ((r.a)localObject3).a(str);
        if (localObject3 != null) {
          ((ArrayList)localObject1).add(localObject3);
        }
        i += 1;
      }
    }
    localObject2 = this.a;
    if (localObject2 != null) {
      paramet = (Unit)((Function4)localObject2).invoke(Boolean.valueOf(true), "", localObject1, new c.b(paramet.c, paramet.l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.d.a
 * JD-Core Version:    0.7.0.1
 */