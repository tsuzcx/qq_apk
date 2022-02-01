package com.tencent.luggage.wxa.fc;

import com.tencent.luggage.wxa.ef.i;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.q;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "", "onTerminate"}, k=3, mv={1, 1, 16})
final class b$g$3<T>
  implements e.c<String>
{
  b$g$3(b.g paramg, b.e parame, b.g.2 param2) {}
  
  public final void a(@Nullable String paramString)
  {
    if (paramString != null) {
      localObject1 = paramString;
    } else {
      localObject1 = "";
    }
    Object localObject1 = (CharSequence)localObject1;
    Object localObject4 = (CharSequence)"sdk_navigateToMiniProgram:ok";
    Object localObject3 = null;
    if (StringsKt.contains$default((CharSequence)localObject1, (CharSequence)localObject4, false, 2, null))
    {
      this.a.c.a(this.a.e, this.a.a.b("ok"));
      try
      {
        localObject1 = new JSONObject(paramString);
        paramString = (String)localObject1;
      }
      catch (JSONException localJSONException)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("on wechat invoke back, parse json failed, exception:");
        ((StringBuilder)localObject4).append(localJSONException);
        ((StringBuilder)localObject4).append(", json:");
        ((StringBuilder)localObject4).append(paramString);
        o.b("Luggage.Wxa.JsApiNavigateToMiniProgramBridged", ((StringBuilder)localObject4).toString());
        paramString = null;
      }
      Object localObject2;
      if ((paramString == null) || (paramString.has("extraData") != true))
      {
        localObject2 = localObject3;
        if (paramString != null)
        {
          localObject2 = localObject3;
          if (paramString.has("privateExtraData") != true) {}
        }
      }
      else
      {
        localObject2 = new q();
        ((q)localObject2).a = paramString.optJSONObject("extraData");
        ((q)localObject2).b = paramString.optJSONObject("privateExtraData");
      }
      i.a.a((d)this.b, (Function1)new b.g.3.1(this));
      this.b.a(localObject2);
      return;
    }
    this.c.a(this.b, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fc.b.g.3
 * JD-Core Version:    0.7.0.1
 */