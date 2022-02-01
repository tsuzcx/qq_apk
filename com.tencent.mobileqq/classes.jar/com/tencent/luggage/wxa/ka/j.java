package com.tencent.luggage.wxa.ka;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.oo.c;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.et;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.qw.md;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "service", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "data", "Lorg/json/JSONObject;", "callbackId", "", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "unhandledCgiException", "", "e", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public class j
  extends g
  implements f
{
  public static final int CTRL_INDEX = 79;
  @NotNull
  public static final String NAME = "operateWXData";
  @Deprecated
  public static final j.g a = new j.g(null);
  
  @NotNull
  public Context a(@NotNull h paramh)
  {
    Intrinsics.checkParameterIsNotNull(paramh, "$this$notNullContext");
    return f.c.a(this, paramh);
  }
  
  @NotNull
  public com.tencent.luggage.wxa.qu.b a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "$this$toByteString");
    return f.c.a(this, paramString);
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
      Object localObject = paramJSONObject.optString("data", null);
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AuthInvoke appId:");
        localStringBuilder.append(paramb.getAppId());
        localStringBuilder.append(", data:");
        localStringBuilder.append((String)localObject);
        o.d("Luggage.WXA.JsApiOperateWXDataLU", localStringBuilder.toString());
        localObject = new j.b(this, paramb, (String)localObject);
        a((h)paramb, "/cgi-bin/mmbiz-bin/js-operatewxdata", (a)((j.b)localObject).a(), et.class).b((com.tencent.luggage.wxa.rl.b)new j.c(this, paramb, paramInt, (j.b)localObject)).d((com.tencent.luggage.wxa.rl.b)new j.d(this, paramb, paramInt)).a((e.c)new j.e(parame)).a((com.tencent.luggage.wxa.rp.d)com.tencent.luggage.wxa.rp.d.a, (e.a)new j.f(this, paramb, paramInt, parame, paramJSONObject));
        return;
      }
      ((Function0)new j.a(this, paramb, paramInt)).invoke();
    }
  }
  
  public void a(@NotNull h paramh, @NotNull i parami)
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
 * Qualified Name:     com.tencent.luggage.wxa.ka.j
 * JD-Core Version:    0.7.0.1
 */