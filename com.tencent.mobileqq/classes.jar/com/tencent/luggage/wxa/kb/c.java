package com.tencent.luggage.wxa.kb;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.m.a;
import com.tencent.luggage.wxa.qw.f;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.luggage.wxa.ro.h;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.phonenumber.aa;
import com.tencent.mm.plugin.appbrand.phonenumber.n;
import com.tencent.mm.plugin.appbrand.phonenumber.r;
import com.tencent.mm.plugin.appbrand.phonenumber.s;
import com.tencent.mm.plugin.appbrand.phonenumber.v;
import com.tencent.mm.plugin.appbrand.phonenumber.z;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/page/AppBrandPageView;", "()V", "getLocalPhoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getServePhoneItems", "Lcom/tencent/mm/vending/tuple/Tuple2;", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/JsApiGetCustomPhoneNumber$Info;", "env", "apiName", "", "withCredentials", "", "localPhoneItems", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "invoke", "", "data", "Lorg/json/JSONObject;", "callbackId", "", "jumpToBindWxPhoneIfNeed", "tuple2", "needBindWxPhone", "phoneItems", "showPhoneNumberDialog", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandJsApi$CallResult;", "it", "progressDialog", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandProgressDialog;", "dialog", "Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "showProgressDialog", "", "Companion", "Info", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
@TargetApi(8)
public class c
  extends com.tencent.luggage.wxa.jx.a<u>
{
  private static final int CTRL_INDEX = 209;
  @NotNull
  private static final String NAME = "getPhoneNumber";
  public static final c.a a = new c.a(null);
  
  static
  {
    NAME = "getPhoneNumber";
  }
  
  private final m.a a(com.tencent.luggage.wxa.rr.c<List<r>, c.b> paramc, u paramu, com.tencent.mm.plugin.appbrand.widget.dialog.e parame, com.tencent.luggage.wxa.kc.a parama, z paramz)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramc != null) {
      localObject1 = (List)paramc.b();
    } else {
      localObject1 = null;
    }
    if (paramc != null) {
      paramc = (c.b)paramc.c();
    } else {
      paramc = null;
    }
    com.tencent.luggage.wxa.ro.b localb = h.c();
    if (paramu != null)
    {
      com.tencent.mm.plugin.appbrand.widget.dialog.l locall = paramu.getDialogContainer();
      if (locall != null) {
        locall.b((i)parame);
      }
    }
    parame = ((com.tencent.luggage.wxa.jj.l)paramu.b(com.tencent.luggage.wxa.jj.l.class)).I;
    if (parame == null) {
      parame = "";
    }
    parama.a(parame);
    parame = ((com.tencent.luggage.wxa.jj.l)paramu.b(com.tencent.luggage.wxa.jj.l.class)).K;
    if (parame == null) {
      parame = "";
    }
    parama.b(parame);
    parama.a((Function0)new c.n(paramz, localb));
    parama.b((Function0)new c.o(paramz, localb));
    parama.d((Function0)new c.p(paramz, paramu, parama));
    parama.e((Function0)new c.q(paramz, paramu, parama));
    parama.a((Function1)new c.r(paramz, paramu, paramc, localb));
    if (paramc != null)
    {
      parame = paramc.b();
      if ((parame != null) && (parame.a == true))
      {
        parama.a(true);
        parama.c((Function0)new c.s(paramz, parama, paramu, paramc));
        break label304;
      }
    }
    parama.a(false);
    label304:
    if (!(localObject1 instanceof ArrayList)) {
      localObject1 = localObject2;
    }
    paramc = (ArrayList)localObject1;
    if (paramc == null) {
      paramc = new ArrayList();
    }
    parama.a(paramc);
    parama.a((com.tencent.luggage.wxa.iu.b)paramu);
    return new m.a("ok", new Object[0]);
  }
  
  private final com.tencent.luggage.wxa.rr.c<List<r>, c.b> a(com.tencent.luggage.wxa.rr.c<List<r>, c.b> paramc, u paramu, z paramz, String paramString, boolean paramBoolean)
  {
    Object localObject2 = null;
    Object localObject1;
    if (paramc != null) {
      localObject1 = (List)paramc.b();
    } else {
      localObject1 = null;
    }
    if ((localObject1 == null) || (((List)localObject1).isEmpty()) || (a((List)localObject1)))
    {
      o.b("MicroMsg.JsApiGetPhoneNumberNew", "phoneItems is null, tryToBindWechatPhoneNumber");
      if (paramz != null) {
        paramz.a(1L);
      }
      com.tencent.luggage.wxa.ro.b localb = h.c();
      n localn = v.a.a();
      localObject1 = localObject2;
      if (paramu != null) {
        localObject1 = paramu.getContext();
      }
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "env?.context");
      localn.a((Context)localObject1, (Function1)new c.m(paramz, paramu, paramString, paramBoolean, localb));
    }
    return paramc;
  }
  
  private final com.tencent.luggage.wxa.rr.c<List<r>, c.b> a(u paramu, String paramString, boolean paramBoolean, List<r> paramList, z paramz)
  {
    com.tencent.luggage.wxa.ro.b localb = h.c();
    if (paramz != null) {
      paramz.c(paramz.b() + 1L);
    }
    paramu = paramu.getAppId();
    Intrinsics.checkExpressionValueIsNotNull(paramu, "env.appId");
    new com.tencent.mm.plugin.appbrand.phonenumber.d(paramu, paramString, paramBoolean).a((Function4)new c.c(localb, paramList));
    return null;
  }
  
  private final Object a(com.tencent.mm.plugin.appbrand.widget.dialog.e parame, u paramu)
  {
    com.tencent.luggage.wxa.ro.b localb = h.b();
    parame.setMessage((CharSequence)paramu.getContext().getString(2131886971));
    parame.setOnCancelListener((DialogInterface.OnCancelListener)new c.t(localb));
    paramu = paramu.getDialogContainer();
    if (paramu != null) {
      paramu.a((i)parame);
    }
    return new Object();
  }
  
  private final boolean a(@NonNull List<r> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (((r)paramList.next()).i()) {
        return false;
      }
    }
    return true;
  }
  
  private final List<r> c()
  {
    return s.a.a();
  }
  
  public void a(@NotNull u paramu, @NotNull JSONObject paramJSONObject, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramu, "env");
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "data");
    if ((paramu.getContext() != null) && ((paramu.getContext() instanceof Activity)))
    {
      o.d("MicroMsg.JsApiGetPhoneNumberNew", "getPhoneNumber data:%s", new Object[] { paramJSONObject.toString() });
      paramu.getContext();
      Object localObject = aa.a;
      String str = paramu.getAppId();
      Intrinsics.checkExpressionValueIsNotNull(str, "env.appId");
      ((aa)localObject).a(str);
      localObject = paramJSONObject.optString("api_name", "webapi_getuserwxphone");
      boolean bool = paramJSONObject.optBoolean("with_credentials", true);
      paramJSONObject = new com.tencent.mm.plugin.appbrand.widget.dialog.e(paramu.getContext());
      h.a().a((com.tencent.luggage.wxa.rl.b)new c.d(this, paramJSONObject, paramu)).b((com.tencent.luggage.wxa.rl.b)new c.e(this)).b((com.tencent.luggage.wxa.rl.b)new c.f(this, paramu, (String)localObject, bool)).b((com.tencent.luggage.wxa.rl.b)new c.g(this, paramu, (String)localObject, bool)).b((com.tencent.luggage.wxa.rl.b)c.h.a).d((com.tencent.luggage.wxa.rl.b)new c.i(this, paramu, paramJSONObject)).a((com.tencent.luggage.wxa.rp.d)com.tencent.luggage.wxa.rp.d.b, (e.c)new c.j(this, paramu, paramInt)).a((e.a)new c.k(this, paramu, paramInt)).a((com.tencent.luggage.wxa.rp.d)com.tencent.luggage.wxa.rp.d.a, (e.a)new c.l(paramu, paramJSONObject));
      return;
    }
    o.b("MicroMsg.JsApiGetPhoneNumberNew", "env is null, return");
    paramu.a(paramInt, b("fail"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.c
 * JD-Core Version:    0.7.0.1
 */