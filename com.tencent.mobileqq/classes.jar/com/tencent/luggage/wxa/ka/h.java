package com.tencent.luggage.wxa.ka;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.luggage.wxa.oo.c;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.em;
import com.tencent.luggage.wxa.qw.en;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.qw.md;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiAuthorizeLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "unhandledCgiException", "", "e", "", "cgiUrlStripForApiCallback", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public class h
  extends g
  implements f
{
  public static final int CTRL_INDEX = 54;
  @NotNull
  public static final String NAME = "authorize";
  @Deprecated
  public static final h.f a = new h.f(null);
  
  private final String a(@NotNull String paramString)
  {
    int i = paramString.hashCode();
    String str;
    if (i != -1813933127)
    {
      if (i != 1410133958) {
        return paramString;
      }
      str = paramString;
      if (paramString.equals("/cgi-bin/mmbiz-bin/js-authorize")) {
        return "js-authorize";
      }
    }
    else
    {
      str = paramString;
      if (paramString.equals("/cgi-bin/mmbiz-bin/js-authorize-confirm")) {
        str = "js-authorize-confirm";
      }
    }
    return str;
  }
  
  @NotNull
  public Context a(@NotNull com.tencent.luggage.wxa.jx.h paramh)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "$this$notNullContext");
    return f.c.a(this, paramh);
  }
  
  @NotNull
  public md a(@NotNull md parammd, @NotNull com.tencent.luggage.wxa.jx.h paramh)
  {
    Intrinsics.checkParameterIsNotNull(parammd, "$this$fill");
    Intrinsics.checkParameterIsNotNull(paramh, "service");
    return f.c.a(this, parammd, paramh);
  }
  
  @NotNull
  public <R extends gu> com.tencent.luggage.wxa.ro.d<R> a(@NotNull com.tencent.luggage.wxa.jx.h paramh, @NotNull String paramString, @NotNull a parama, @NotNull Class<R> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "$this$runCgi");
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(parama, "request");
    Intrinsics.checkParameterIsNotNull(paramClass, "clazz");
    return f.c.a(this, paramh, paramString, parama, paramClass);
  }
  
  public void a(@NotNull Context paramContext, @Nullable Bitmap paramBitmap, @Nullable String paramString1, @Nullable String paramString2, @NotNull c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramc, "dialog");
    f.c.a(this, paramContext, paramBitmap, paramString1, paramString2, paramc);
  }
  
  protected final void a(@Nullable com.tencent.luggage.wxa.iu.b paramb, @Nullable JSONObject paramJSONObject, int paramInt, @Nullable e parame)
  {
    if ((paramb != null) && (paramJSONObject != null))
    {
      Object localObject2 = paramJSONObject.optJSONArray("scope");
      if (localObject2 != null)
      {
        Object localObject1 = new LinkedList();
        int k = ((JSONArray)localObject2).length();
        if (k >= 0)
        {
          int i = 0;
          for (;;)
          {
            localObject3 = ((JSONArray)localObject2).optString(i, null);
            CharSequence localCharSequence = (CharSequence)localObject3;
            int j;
            if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
              j = 0;
            } else {
              j = 1;
            }
            if (j == 0) {
              ((LinkedList)localObject1).add(localObject3);
            }
            if (i == k) {
              break;
            }
            i += 1;
          }
        }
        localObject2 = (com.tencent.luggage.wxa.jx.h)paramb;
        Object localObject3 = new em();
        ((em)localObject3).a = paramb.getAppId();
        ((em)localObject3).b.addAll((Collection)localObject1);
        localObject1 = paramb.q();
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "service.runtime");
        ((em)localObject3).c = ((com.tencent.luggage.wxa.iu.d)localObject1).ab();
        ((em)localObject3).d = a(new md(), (com.tencent.luggage.wxa.jx.h)localObject2);
        a((com.tencent.luggage.wxa.jx.h)localObject2, "/cgi-bin/mmbiz-bin/js-authorize", (a)localObject3, en.class).b((com.tencent.luggage.wxa.rl.b)new h.b(this, paramb, paramInt)).d((com.tencent.luggage.wxa.rl.b)new h.c(this, paramb, paramInt)).a((e.c)new h.d(parame)).a((e.a)new h.e(this, paramb, paramInt, parame, paramJSONObject));
        return;
      }
      ((Function0)new h.a(this, paramb, paramInt)).invoke();
    }
  }
  
  public void a(@NotNull com.tencent.luggage.wxa.jx.h paramh, @NotNull i parami)
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
  
  public boolean a(@Nullable com.tencent.luggage.wxa.iu.b paramb, @Nullable JSONObject paramJSONObject, int paramInt, @Nullable e parame, @Nullable Object paramObject)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ka.h
 * JD-Core Version:    0.7.0.1
 */