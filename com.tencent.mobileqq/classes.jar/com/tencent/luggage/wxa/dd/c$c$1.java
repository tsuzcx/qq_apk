package com.tencent.luggage.wxa.dd;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.ro.b;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/luggage/login/account/LoginByRefresh$refreshSession$3$1", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class c$c$1
  implements Callback
{
  c$c$1(b paramb) {}
  
  public void onFailure(@NotNull Call paramCall, @NotNull IOException paramIOException)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
    Intrinsics.checkParameterIsNotNull(paramIOException, "e");
    this.b.a(paramIOException);
  }
  
  public void onResponse(@NotNull Call paramCall, @NotNull Response paramResponse)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
    Intrinsics.checkParameterIsNotNull(paramResponse, "response");
    paramCall = paramResponse.body();
    if (paramCall == null) {
      Intrinsics.throwNpe();
    }
    paramCall = paramCall.string();
    o.f("Luggage.AccountManager", "refresh session response json: %s", new Object[] { paramCall });
    try
    {
      paramResponse = new JSONObject(paramCall);
      int i = paramResponse.optInt("ErrCode", 0);
      Object localObject1 = c.a(c.a);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("refresh :");
      ((StringBuilder)localObject2).append(i);
      o.d((String)localObject1, ((StringBuilder)localObject2).toString());
      if (i != 0)
      {
        o.b("Luggage.AccountManager", "refresh session failed: %s", new Object[] { Integer.valueOf(i) });
        paramResponse = this.b;
        int j = d.a.c();
        int k = d.a.d();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("errCode:");
        ((StringBuilder)localObject1).append(i);
        paramResponse.a(new d(j, k, ((StringBuilder)localObject1).toString()));
        return;
      }
      localObject1 = this.a.b;
      localObject2 = paramResponse.getString("session_id");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "obj.getString(\"session_id\")");
      ((g)localObject1).a((String)localObject2);
      this.a.b.c(paramResponse.optInt("expiretime"));
      this.b.a(new Object[] { this.a.b });
      return;
    }
    catch (JSONException paramResponse)
    {
      o.b("Luggage.AccountManager", "request failed: %s => %s", new Object[] { this.a.a.url(), paramCall });
      this.b.a(paramResponse);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dd.c.c.1
 * JD-Core Version:    0.7.0.1
 */