package com.tencent.luggage.wxa.fq;

import android.content.Context;
import android.util.Log;
import com.tencent.luggage.wxa.fv.e;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxaapi.WxaApi.Factory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/ComponentsGuard;", "", "()V", "TAG", "", "ensureWxaApiInstalled", "", "context", "Landroid/content/Context;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a a = new a();
  
  @JvmStatic
  public static final boolean a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    if (g.c.a.d() == null)
    {
      Object localObject1 = paramContext.getApplicationContext();
      if (localObject1 == null) {
        localObject1 = paramContext;
      }
      r.a((Context)localObject1);
      localObject1 = e.a.b();
      int j = e.a.c();
      Object localObject2 = (CharSequence)localObject1;
      int i;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if ((i == 0) && (1 <= j) && (2 >= j))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("ensureWxaApiInstall(), hostAppID:");
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(", hostAbi:");
        ((StringBuilder)localObject2).append(j);
        Log.i("Luggage.ComponentsGuard", ((StringBuilder)localObject2).toString());
        WxaApi.Factory.createApi(paramContext, (String)localObject1, j);
        return true;
      }
      Log.e("Luggage.ComponentsGuard", "ensureWxaApiInstalled(), wxaApi not initialized before, return null");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.a
 * JD-Core Version:    0.7.0.1
 */