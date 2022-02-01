package com.tencent.luggage.wxa.dd;

import android.util.Log;
import com.tencent.luggage.wxa.ep.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.w;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/WxaAccountManager;", "Lcom/tencent/luggage/login/account/IWxaAccountManager;", "()V", "TAG", "", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMmkv", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "mmkv$delegate", "Lkotlin/Lazy;", "wxaAccountManager", "getWxaAccountManager", "()Lcom/tencent/luggage/login/account/IWxaAccountManager;", "setWxaAccountManager", "(Lcom/tencent/luggage/login/account/IWxaAccountManager;)V", "addAccountCallbacks", "", "callback", "Lcom/tencent/luggage/login/account/IWxaAccountManager$IAccountCallback;", "generateIfNull", "getDeviceId", "getSessionInfo", "Lcom/tencent/luggage/login/account/SessionInfo;", "getSessionKey", "hasLogin", "", "init", "share", "isShare", "login", "logic", "Lcom/tencent/luggage/login/account/IWxaAccountManager$ILogin;", "logicCallback", "Lcom/tencent/luggage/login/account/IWxaAccountManager$ILoginCallback;", "loginSessionInfo", "sessionInfo", "logout", "refreshSession", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "refreshSessionInfoSync", "release", "removeAccountCallbacks", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class i
  implements b
{
  public static final i a = new i();
  @Nullable
  private static b b = (b)new f();
  private static final Lazy c = LazyKt.lazy((Function0)i.a.a);
  
  private final w d()
  {
    return (w)c.getValue();
  }
  
  private final String i()
  {
    Object localObject1 = d().getString("Luggage.AccountManager.deviceId", "");
    Object localObject2 = (CharSequence)localObject1;
    int i;
    if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("LU");
      ((StringBuilder)localObject1).append(a.a());
      localObject1 = ((StringBuilder)localObject1).toString();
      if (localObject1 != null)
      {
        localObject1 = ((String)localObject1).substring(0, 16);
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("generated luggage deviceId: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        o.e("Luggage.AccountManager", ((StringBuilder)localObject2).toString());
        d().putString("Luggage.AccountManager.deviceId", (String)localObject1);
        return localObject1;
      }
      throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("get saved luggage deviceId: ");
    ((StringBuilder)localObject2).append((String)localObject1);
    o.e("Luggage.AccountManager", ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  public void a(@NotNull b.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "callback");
    b localb = b;
    if (localb != null) {
      localb.a(parama);
    }
  }
  
  public void a(@NotNull b.b paramb, @Nullable b.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "logic");
    b localb = b;
    if (localb != null) {
      localb.a(paramb, paramc);
    }
  }
  
  public final void a(@Nullable b paramb)
  {
    b = paramb;
  }
  
  public void a(@Nullable g paramg)
  {
    b localb = b;
    if (localb != null) {
      localb.a(paramg);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    b localb = b;
    if (localb != null) {
      localb.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    b localb = b;
    if (localb != null) {
      return localb.a();
    }
    return true;
  }
  
  public void b()
  {
    o.d("Luggage.AccountManager", "logout: [%s]", new Object[] { Log.getStackTraceString(new Throwable()) });
    b localb = b;
    if (localb != null) {
      localb.b();
    }
  }
  
  public void b(@NotNull b.a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "callback");
    b localb = b;
    if (localb != null) {
      localb.b(parama);
    }
  }
  
  @NotNull
  public final String c()
  {
    return i();
  }
  
  @NotNull
  public String e()
  {
    Object localObject = b;
    if (localObject != null)
    {
      localObject = ((b)localObject).e();
      if (localObject != null) {
        return localObject;
      }
    }
    return "";
  }
  
  @Nullable
  public g f()
  {
    Object localObject = b;
    if (localObject != null)
    {
      localObject = ((b)localObject).f();
      if (localObject != null) {
        return localObject;
      }
    }
    return null;
  }
  
  public boolean g()
  {
    b localb = b;
    if (localb != null) {
      return localb.g();
    }
    return false;
  }
  
  public boolean h()
  {
    long l = af.b();
    Object localObject = b;
    if (localObject != null) {
      return ((b)localObject).h();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("refreshSessionInfoSync ret[");
    ((StringBuilder)localObject).append(false);
    ((StringBuilder)localObject).append("] cost[");
    ((StringBuilder)localObject).append(af.b() - l);
    ((StringBuilder)localObject).append("ms]");
    o.d("Luggage.AccountManager", ((StringBuilder)localObject).toString());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dd.i
 * JD-Core Version:    0.7.0.1
 */