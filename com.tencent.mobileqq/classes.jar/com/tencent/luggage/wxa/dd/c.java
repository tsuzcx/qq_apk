package com.tencent.luggage.wxa.dd;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rl.b;
import com.tencent.luggage.wxa.ro.d;
import com.tencent.luggage.wxa.ro.e;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.luggage.wxa.ro.h;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/LoginByRefresh;", "", "()V", "TAG", "", "createRefreshRequest", "Lokhttp3/Request;", "sessionKey", "refreshSession", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "Lcom/tencent/luggage/login/account/SessionInfo;", "sessionInfo", "", "callback", "Lcom/tencent/luggage/login/account/IWxaAccountManager$ILoginCallback;", "refreshSessionSync", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class c
{
  public static final c a = new c();
  private static final String b = "Luggage.LoginByRefresh";
  
  private final Request a(String paramString)
  {
    Object localObject = HttpUrl.parse("https://open.weixin.qq.com/wxaruntime/refresh_session");
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((HttpUrl)localObject).newBuilder();
    ((HttpUrl.Builder)localObject).addQueryParameter("session_id", paramString);
    paramString = ((HttpUrl.Builder)localObject).build().toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "urlBuilder.build().toString()");
    paramString = new Request.Builder().url(paramString).build();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "Request.Builder().url(url).build()");
    return paramString;
  }
  
  private final d<g> b(g paramg)
  {
    Request localRequest = a(paramg.a());
    paramg = h.a().b((b)new c.c(localRequest, paramg));
    Intrinsics.checkExpressionValueIsNotNull(paramg, "QuickAccess.pipeline().`…  SessionInfo()\n        }");
    return paramg;
  }
  
  @Nullable
  public final g a(@NotNull g paramg)
  {
    Intrinsics.checkParameterIsNotNull(paramg, "sessionInfo");
    Object localObject = a(paramg.a());
    try
    {
      localObject = com.tencent.luggage.wxa.dc.g.get().newCall((Request)localObject).execute().body();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = new JSONObject(((ResponseBody)localObject).string());
      int i = ((JSONObject)localObject).optInt("ErrCode", 0);
      if (i != 0)
      {
        o.b("Luggage.AccountManager", "refresh session failed: %s", new Object[] { Integer.valueOf(i) });
        return null;
      }
      String str = ((JSONObject)localObject).getString("session_id");
      Intrinsics.checkExpressionValueIsNotNull(str, "obj.getString(\"session_id\")");
      paramg.a(str);
      paramg.c(((JSONObject)localObject).optInt("expiretime"));
      return paramg;
    }
    catch (JSONException paramg)
    {
      o.a("Luggage.AccountManager", (Throwable)paramg, "", new Object[0]);
      return null;
    }
    catch (IOException paramg)
    {
      o.a("Luggage.AccountManager", (Throwable)paramg, "", new Object[0]);
    }
    return null;
  }
  
  public final void a(@NotNull g paramg, @NotNull b.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramg, "sessionInfo");
    Intrinsics.checkParameterIsNotNull(paramc, "callback");
    b(paramg).a((e.c)new c.a(paramc)).a((e.a)new c.b(paramc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dd.c
 * JD-Core Version:    0.7.0.1
 */