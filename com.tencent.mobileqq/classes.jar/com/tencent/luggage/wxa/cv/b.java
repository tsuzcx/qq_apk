package com.tencent.luggage.wxa.cv;

import com.tencent.luggage.wxa.cu.i;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.jx.u;
import com.tencent.luggage.wxa.qw.du;
import com.tencent.luggage.wxa.qw.dw;
import com.tencent.luggage.wxa.qw.dx;
import com.tencent.luggage.wxa.qw.ec;
import com.tencent.luggage.wxa.qw.ed;
import com.tencent.luggage.wxa.qw.ef;
import com.tencent.luggage.wxa.qw.eg;
import com.tencent.luggage.wxa.qw.eh;
import com.tencent.luggage.wxa.qw.ew;
import com.tencent.luggage.wxa.qw.jf;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/jsapi/webview/model/HTMLWebViewJsApiPermissionController;", "", "viewController", "Lcom/tencent/luggage/jsapi/webview/HTMLWebViewComponentImpl;", "(Lcom/tencent/luggage/jsapi/webview/HTMLWebViewComponentImpl;)V", "JSAuthCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/mm/protocal/protobuf/JSAPIAuthInfo;", "JSAuthCache$annotations", "()V", "controlBytes", "", "checkApiPermission", "", "api", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi;", "dataJson", "Lorg/json/JSONObject;", "onAccept", "Lkotlin/Function0;", "onReject", "doJSAuthVerify", "doPreVerify", "data", "onSuccess", "onError", "Lkotlin/Function1;", "doRealtimeVerify", "doSetJSAuth", "verifyRequest", "Lcom/tencent/mm/protocal/protobuf/JSAPIAuthRequest;", "verifyResponse", "Lcom/tencent/mm/protocal/protobuf/JSAPIAuthResponse;", "makeJSAuthKey", "url", "toLogString", "Lcom/tencent/mm/protocal/protobuf/VerifyInfo;", "Companion", "JSVerifyRequestProxy", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class b
{
  @Deprecated
  public static final b.a a = new b.a(null);
  private static final HashMap<String, Integer> e;
  private ConcurrentHashMap<String, Integer> b;
  private final ConcurrentHashMap<String, du> c;
  private final com.tencent.luggage.wxa.ct.b d;
  
  static
  {
    HashMap localHashMap = new HashMap();
    Map localMap = (Map)localHashMap;
    localMap.put("log", Integer.valueOf(0));
    localMap.put("checkJsApi", Integer.valueOf(84));
    localMap.put("chooseImage", Integer.valueOf(104));
    localMap.put("geoLocation", Integer.valueOf(57));
    localMap.put("getNetworkType", Integer.valueOf(16));
    localMap.put("invokeMiniProgramAPI", Integer.valueOf(295));
    e = localHashMap;
  }
  
  public b(@NotNull com.tencent.luggage.wxa.ct.b paramb)
  {
    this.d = paramb;
    this.b = new ConcurrentHashMap();
    paramb = (Map)this.b;
    Integer localInteger = Integer.valueOf(1);
    paramb.put("invokeMiniProgramAPI", localInteger);
    ((Map)this.b).put("preVerifyJSAPI", localInteger);
    this.c = new ConcurrentHashMap();
  }
  
  private final String a(@NotNull jf paramjf)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VerifyInfo:{jsapi_name=");
    localStringBuilder.append(paramjf.a);
    localStringBuilder.append(", state=");
    localStringBuilder.append(paramjf.b);
    localStringBuilder.append(", verify_ok=");
    localStringBuilder.append(paramjf.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  private final String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append('_');
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private final void a(dw paramdw, dx paramdx)
  {
    Object localObject = paramdx.d;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "verifyResponse.scope_auth_info");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((ew)((Iterator)localObject).next()).b = 1;
    }
    localObject = new eg();
    ((eg)localObject).a = paramdw.a;
    ((eg)localObject).b = paramdw.b;
    ((eg)localObject).c = paramdw.c;
    ((eg)localObject).d = paramdw.d;
    ((eg)localObject).e = paramdw.e;
    ((eg)localObject).f = paramdw.f;
    ((eg)localObject).g = paramdw.g;
    ((eg)localObject).h = paramdw.h;
    ((eg)localObject).i = paramdw.i;
    ((eg)localObject).j.addAll((Collection)paramdx.d);
    this.d.a("/cgi-bin/mmbiz-bin/jsapi-setauth", (com.tencent.luggage.wxa.qu.a)localObject, eh.class).a((e.c)new b.i(paramdw)).a((e.a)new b.j(paramdw));
  }
  
  private final void b(m paramm, JSONObject paramJSONObject, Function0<Unit> paramFunction01, Function0<Unit> paramFunction02)
  {
    String str = this.d.l().getCurrentURL();
    du localdu = (du)this.c.get(a(str, paramm.d()));
    int i;
    if (localdu != null) {
      i = localdu.b;
    } else {
      i = 0;
    }
    if (i == 1)
    {
      paramFunction01.invoke();
      return;
    }
    if (i == 0)
    {
      paramJSONObject = b.b.a.a(str, paramm, paramJSONObject).a();
      this.d.a("/cgi-bin/mmbiz-bin/jsapi-auth", (com.tencent.luggage.wxa.qu.a)paramJSONObject, dx.class).a((com.tencent.luggage.wxa.rp.d)com.tencent.luggage.wxa.rp.d.a, (e.c)new b.c(this, paramm, str, paramFunction02, paramFunction01, paramJSONObject)).a((e.a)new b.d(paramm, str, paramFunction02));
      return;
    }
    paramFunction02.invoke();
  }
  
  private final void c(m paramm, JSONObject paramJSONObject, Function0<Unit> paramFunction01, Function0<Unit> paramFunction02)
  {
    String str = this.d.l().getCurrentURL();
    this.d.a("/cgi-bin/mmbiz-bin/jsapi-realtimeverify", (com.tencent.luggage.wxa.qu.a)b.b.a.a(str, paramm, paramJSONObject).b(), ef.class).a((e.c)new b.g(this, 1, paramFunction01, paramm, str, paramFunction02)).a((e.a)new b.h(paramm, str, paramFunction02));
  }
  
  public final void a(@NotNull m paramm, @NotNull JSONObject paramJSONObject, @NotNull Function0<Unit> paramFunction01, @NotNull Function0<Unit> paramFunction02)
  {
    Intrinsics.checkParameterIsNotNull(paramm, "api");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "dataJson");
    Intrinsics.checkParameterIsNotNull(paramFunction01, "onAccept");
    Intrinsics.checkParameterIsNotNull(paramFunction02, "onReject");
    boolean bool = paramm instanceof i;
    if (bool)
    {
      paramFunction01.invoke();
      return;
    }
    Integer localInteger = (Integer)this.b.get(paramm.d());
    if (localInteger == null) {
      localInteger = Integer.valueOf(0);
    }
    Intrinsics.checkExpressionValueIsNotNull(localInteger, "controlBytes[api.name] ?…ISTATE.MMBIZ_JSAPI_REFUSE");
    int i = localInteger.intValue();
    if (i == 1)
    {
      paramFunction01.invoke();
      return;
    }
    if ((paramm instanceof u))
    {
      paramFunction02.invoke();
      return;
    }
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          paramFunction02.invoke();
          return;
        }
        b(paramm, paramJSONObject, paramFunction01, paramFunction02);
        return;
      }
      c(paramm, paramJSONObject, paramFunction01, paramFunction02);
      return;
    }
    if (bool)
    {
      paramFunction01.invoke();
      return;
    }
    paramFunction02.invoke();
  }
  
  public final void a(@NotNull JSONObject paramJSONObject, @NotNull Function0<Unit> paramFunction0, @NotNull Function1<? super String, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "data");
    Intrinsics.checkParameterIsNotNull(paramFunction0, "onSuccess");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "onError");
    ec localec = new ec();
    localec.a = this.d.l().getCurrentURL();
    localec.b = paramJSONObject.optString("verifyAppId");
    LinkedList localLinkedList = localec.c;
    List localList = (List)b.a.a(a, paramJSONObject, "verifyJsApiList");
    if (localList == null) {
      localList = CollectionsKt.emptyList();
    }
    localLinkedList.addAll((Collection)localList);
    localec.d = paramJSONObject.optString("verifyTimestamp");
    localec.e = paramJSONObject.optString("verifyNonceStr");
    localec.f = paramJSONObject.optString("verifySignature");
    localec.g = paramJSONObject.optString("verifySignType");
    localec.h = 0;
    localec.i = this.d.b();
    this.d.a("/cgi-bin/mmbiz-bin/jsapi-preverify", (com.tencent.luggage.wxa.qu.a)localec, ed.class).a((e.c)new b.e(this, paramFunction0, paramFunction1)).a((e.a)new b.f(paramFunction1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cv.b
 * JD-Core Version:    0.7.0.1
 */