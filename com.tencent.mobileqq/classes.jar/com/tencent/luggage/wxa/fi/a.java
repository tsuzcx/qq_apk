package com.tencent.luggage.wxa.fi;

import android.app.Application;
import com.tencent.luggage.opensdk.a.b.a;
import com.tencent.luggage.opensdk.f;
import com.tencent.luggage.opensdk.f.a;
import com.tencent.luggage.opensdk.g.a;
import com.tencent.luggage.wxa.qw.ft;
import com.tencent.luggage.wxa.qw.ir;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram.Req;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/permission/jsauth/JsAuthTransferLogic;", "", "()V", "TAG", "", "cgiTransferActionHandler", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/IJsAuthUncaughtCgiExceptionHandler;", "handleCgiTransferActionIfNeed", "", "context", "Lcom/tencent/mm/plugin/appbrand/permission/jsauth/JsAuthExecuteContext;", "callback", "Lcom/tencent/luggage/wxa/standalone_open_runtime/permission/jsauth/JsAuthTransferLogic$TransferResultCallback;", "e", "handleCgiTransferActionIfNeed$luggage_standalone_open_runtime_sdk_release", "init", "", "application", "Landroid/app/Application;", "makeOpenSdkTransferParams", "Lcom/tencent/luggage/opensdk/OpenSDKBridgedJsApiParams$Req;", "wxa_scene", "", "OpenSdkBridgedCallbackIMPL", "TransferResultCallback", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a a = new a();
  private static final com.tencent.luggage.wxa.oo.b b = (com.tencent.luggage.wxa.oo.b)a.c.a;
  
  private final g.a a(com.tencent.luggage.wxa.oo.d paramd, int paramInt)
  {
    String str = null;
    try
    {
      localObject = (CharSequence)paramd.c();
      if (localObject == null) {
        break label176;
      }
      if (((CharSequence)localObject).length() != 0) {
        break label171;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject;
        g.a locala;
        continue;
        paramInt = 0;
        break label178;
        paramInt = 1;
        if (paramInt == 0) {}
      }
    }
    localObject = new JSONObject(paramd.c());
    break label51;
    o.c("Luggage.STANDALONE.JsAuthTransferLogic", "makeOpenSdkTransferParams json parse failed");
    localObject = null;
    label51:
    locala = new g.a().a(paramd.b()).a(paramd.d()).h(paramd.a().getAppId()).e(com.tencent.luggage.wxa.dg.d.a.d()).g(com.tencent.luggage.wxa.dd.i.a.e()).f("Test").b(1).a(true);
    if (localObject != null) {
      str = ((JSONObject)localObject).toString();
    }
    paramd = locala.b(str).c(paramd.a().getContext().getClass().getName()).d(f.b(paramd.a()));
    Intrinsics.checkExpressionValueIsNotNull(paramd, "OpenSDKBridgedJsApiParam…i.jsapiType(context.env))");
    return paramd;
  }
  
  public final void a(@NotNull Application paramApplication)
  {
    Intrinsics.checkParameterIsNotNull(paramApplication, "application");
    com.tencent.luggage.wxa.oo.a.a(b);
  }
  
  public final boolean a(@Nullable com.tencent.luggage.wxa.oo.d paramd, @Nullable a.b paramb, @Nullable Object paramObject)
  {
    boolean bool = paramObject instanceof com.tencent.luggage.wxa.dc.d;
    int i = 0;
    if (bool)
    {
      if (paramd == null) {
        return false;
      }
      paramObject = (com.tencent.luggage.wxa.dc.d)paramObject;
      if (paramObject.a().b != null)
      {
        bool = com.tencent.luggage.opensdk.i.a.a();
        int j = 3;
        if (bool)
        {
          localObject = new com.tencent.luggage.opensdk.a.c();
          ((com.tencent.luggage.opensdk.a.c)localObject).a = ((com.tencent.luggage.opensdk.a.a)a.b.a.a(paramd.a()));
          ((com.tencent.luggage.opensdk.a.c)localObject).b = paramd.b();
          ((com.tencent.luggage.opensdk.a.c)localObject).c = paramd.c();
          ((com.tencent.luggage.opensdk.a.c)localObject).d = paramd.d();
          CharSequence localCharSequence = (CharSequence)paramd.c();
          if ((localCharSequence == null) || (localCharSequence.length() == 0)) {
            i = 1;
          }
          if ((i == 0) && (paramObject.a().b.a == 2)) {
            i = j;
          } else {
            i = paramObject.a().b.a;
          }
          ((com.tencent.luggage.opensdk.a.c)localObject).e = i;
          com.tencent.luggage.opensdk.i.a.a((com.tencent.luggage.opensdk.a.c)localObject).a((e.c)new a.d((com.tencent.luggage.opensdk.a.c)localObject, paramb)).a((e.a)new a.e(paramd, paramb));
          return true;
        }
        if (!com.tencent.luggage.opensdk.d.a())
        {
          com.tencent.luggage.wxa.fh.a.a.a(paramd.a(), 2131889046);
          return true;
        }
        if (com.tencent.luggage.wxa.de.h.a.a() == 3)
        {
          com.tencent.luggage.wxa.fh.a.a.a(paramd.a(), 2131889045);
          return true;
        }
        paramObject = new WXLaunchMiniProgram.Req();
        paramObject.userName = f.a((com.tencent.luggage.wxa.jx.h)paramd.a());
        Object localObject = paramd.a().q();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "context.env.runtime");
        paramObject.miniprogramType = ((com.tencent.luggage.wxa.iu.d)localObject).ab();
        paramObject.path = "__wx__/open-api-redirecting-page";
        paramObject.extData = URLEncoder.encode(a.a(paramd, 3).toString());
        f.a(paramd.d(), paramObject, (f.a)new a.a(paramd, paramb));
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fi.a
 * JD-Core Version:    0.7.0.1
 */