package com.tencent.luggage.wxa.cs;

import com.tencent.luggage.wxa.do.c;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jj.h;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.x;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/version/JsApiUpdateApp;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "isGame", "", "Lcom/tencent/mm/plugin/appbrand/AppBrandRuntime;", "Companion", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
  extends com.tencent.luggage.wxa.jx.a<b>
{
  public static final int CTRL_INDEX = 359;
  @NotNull
  public static final String NAME = "updateApp";
  @Deprecated
  public static final a.a a = new a.a(null);
  
  private final boolean a(@NotNull com.tencent.luggage.wxa.iu.d paramd)
  {
    h localh = paramd.B();
    paramd = localh;
    if (!(localh instanceof c)) {
      paramd = null;
    }
    paramd = (c)paramd;
    return (paramd != null) && (paramd.c == 4);
  }
  
  public void a(@Nullable b paramb, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    Object localObject1 = null;
    if (paramb != null) {
      paramJSONObject = paramb.q();
    } else {
      paramJSONObject = null;
    }
    if ((paramJSONObject != null) && (paramJSONObject.ab() == 0))
    {
      Object localObject2 = paramJSONObject.B();
      if ((localObject2 instanceof c)) {
        localObject1 = localObject2;
      }
      localObject1 = (c)localObject1;
      if (localObject1 != null)
      {
        com.tencent.mm.plugin.appbrand.keylogger.d.a(com.tencent.luggage.wxa.oy.a.class, ((c)localObject1).D);
        localObject2 = ((c)localObject1).D;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Network:");
        localStringBuilder.append(x.b(r.a()));
        com.tencent.mm.plugin.appbrand.keylogger.d.a(com.tencent.luggage.wxa.oy.a.class, (String)localObject2, localStringBuilder.toString());
        localObject2 = new com.tencent.luggage.wxa.nn.a();
        ((com.tencent.luggage.wxa.nn.a)localObject2).b = paramJSONObject.aa();
        ((com.tencent.luggage.wxa.nn.a)localObject2).c = -1;
        ((com.tencent.luggage.wxa.nn.a)localObject2).d = paramJSONObject.ab();
        ((com.tencent.luggage.wxa.nn.a)localObject2).e = paramJSONObject.as();
        ((com.tencent.luggage.wxa.nn.a)localObject2).f = ((c)localObject1).f();
        ((com.tencent.luggage.wxa.nn.a)localObject2).g = ((c)localObject1).h;
        paramJSONObject.e((Runnable)new com.tencent.luggage.wxa.nl.a((com.tencent.luggage.wxa.nn.a)localObject2, (com.tencent.luggage.wxa.nl.a.a)new a.d(paramJSONObject, (c)localObject1, this, paramb, paramInt)));
        return;
      }
      ((Function0)new a.c(this, paramb, paramInt)).invoke();
      return;
    }
    if (paramJSONObject != null) {
      paramJSONObject.d((Runnable)new a.b(paramJSONObject, this, paramb, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cs.a
 * JD-Core Version:    0.7.0.1
 */