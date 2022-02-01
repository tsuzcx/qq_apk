package com.tencent.luggage.wxa.lc;

import com.tencent.luggage.wxa.ik.a.c;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/msgsubscription/CompatNetSceneDispatcherDefaultAdapter;", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IDispatcher;", "()V", "TAG", "", "mapWxaUsername2Appid", "Ljava/util/concurrent/ConcurrentHashMap;", "send", "", "rr", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IReqResp;", "callback", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase$IOnSceneEnd;", "scene", "Lcom/tencent/mm/msgsubscription/util/CompatNetSceneBase;", "setWxaUsername2Appid", "", "wxaUsername", "appid", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
  implements com.tencent.luggage.wxa.ik.a.a
{
  public static final a a = new a();
  private static final ConcurrentHashMap<String, String> b = new ConcurrentHashMap();
  
  public int a(@NotNull a.c paramc, @Nullable com.tencent.luggage.wxa.ik.a.b paramb, @NotNull com.tencent.luggage.wxa.ik.a parama)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "rr");
    Intrinsics.checkParameterIsNotNull(parama, "scene");
    b localb = (b)com.tencent.luggage.wxa.ba.e.a(b.class);
    if (localb != null)
    {
      String str;
      if ((parama instanceof com.tencent.luggage.wxa.ii.a)) {
        str = (String)b.get(((com.tencent.luggage.wxa.ii.a)parama).b());
      } else {
        str = null;
      }
      localb.b(paramc.c(), str, (com.tencent.luggage.wxa.qu.a)paramc.a(), paramc.b().getClass()).a((e.c)new a.a(paramc, paramb, parama)).a((e.a)new a.b(paramb, parama));
      return 0;
    }
    return -1;
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "wxaUsername");
    Intrinsics.checkParameterIsNotNull(paramString2, "appid");
    ((Map)b).put(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lc.a
 * JD-Core Version:    0.7.0.1
 */