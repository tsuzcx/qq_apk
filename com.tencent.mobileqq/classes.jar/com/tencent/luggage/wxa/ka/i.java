package com.tencent.luggage.wxa.ka;

import android.content.Context;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.eq;
import com.tencent.luggage.wxa.qw.er;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.qw.md;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiLoginLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "invoke", "component", "cgiUrlStripForApiCallback", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class i
  extends g
  implements f
{
  public static final int CTRL_INDEX = 52;
  @NotNull
  public static final String NAME = "login";
  @Deprecated
  public static final i.e a = new i.e(null);
  
  private final String a(@NotNull String paramString)
  {
    int i = paramString.hashCode();
    String str;
    if (i != -453030458)
    {
      if (i != 865464761) {
        return paramString;
      }
      str = paramString;
      if (paramString.equals("/cgi-bin/mmbiz-bin/js-login-confirm")) {
        return "js-login-confirm";
      }
    }
    else
    {
      str = paramString;
      if (paramString.equals("/cgi-bin/mmbiz-bin/js-login")) {
        str = "js-login";
      }
    }
    return str;
  }
  
  @NotNull
  public Context a(@NotNull h paramh)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "$this$notNullContext");
    return f.c.a(this, paramh);
  }
  
  @NotNull
  public md a(@NotNull md parammd, @NotNull h paramh)
  {
    Intrinsics.checkParameterIsNotNull(parammd, "$this$fill");
    Intrinsics.checkParameterIsNotNull(paramh, "service");
    return f.c.a(this, parammd, paramh);
  }
  
  @NotNull
  public <R extends gu> com.tencent.luggage.wxa.ro.d<R> a(@NotNull h paramh, @NotNull String paramString, @NotNull a parama, @NotNull Class<R> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "$this$runCgi");
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(parama, "request");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    return f.c.a(this, paramh, paramString, parama, paramClass);
  }
  
  public void a(@Nullable com.tencent.luggage.wxa.iu.b paramb, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject != null)
    {
      try
      {
        if (!paramJSONObject.has("requestInQueue")) {
          paramJSONObject.put("requestInQueue", false);
        }
      }
      catch (JSONException localJSONException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("invoke put KEY_IN_QUEUE e=");
        localStringBuilder.append(localJSONException.getMessage());
        o.b("Luggage.WXA.JsApiLoginLU", localStringBuilder.toString());
      }
      super.a(paramb, paramJSONObject, paramInt);
    }
  }
  
  protected void a(@Nullable com.tencent.luggage.wxa.iu.b paramb, @Nullable JSONObject paramJSONObject, int paramInt, @Nullable e parame)
  {
    if ((paramb != null) && (paramJSONObject != null))
    {
      paramJSONObject = (h)paramb;
      eq localeq = new eq();
      localeq.a = paramb.getAppId();
      com.tencent.luggage.wxa.iu.d locald = paramb.q();
      Intrinsics.checkExpressionValueIsNotNull(locald, "service.runtime");
      localeq.f = locald.ab();
      localeq.g = a(new md(), paramJSONObject);
      a(paramJSONObject, "/cgi-bin/mmbiz-bin/js-login", (a)localeq, er.class).b((com.tencent.luggage.wxa.rl.b)new i.a(this, paramb, paramInt)).d((com.tencent.luggage.wxa.rl.b)new i.b(this, paramb, paramInt)).a((e.c)new i.c(parame)).a((e.a)new i.d(this, parame, paramb, paramInt));
    }
  }
  
  public void a(@NotNull h paramh, @NotNull com.tencent.mm.plugin.appbrand.widget.dialog.i parami)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "$this$showAuthorizeDialog");
    Intrinsics.checkParameterIsNotNull(parami, "dialog");
    f.c.a(this, paramh, parami);
  }
  
  public <_Var> void a(@NotNull com.tencent.luggage.wxa.ro.b paramb, @NotNull com.tencent.luggage.wxa.ro.d<_Var> paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "$this$bridge");
    Intrinsics.checkParameterIsNotNull(paramd, "pipeable");
    f.c.a(this, paramb, paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.i
 * JD-Core Version:    0.7.0.1
 */