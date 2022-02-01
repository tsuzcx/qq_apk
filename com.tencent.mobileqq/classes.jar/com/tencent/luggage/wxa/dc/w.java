package com.tencent.luggage.wxa.dc;

import com.tencent.ilinkservice.aq;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.dg.b.a;
import com.tencent.luggage.wxa.dg.b.b;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.ro.e.a;
import com.tencent.luggage.wxa.ro.e.c;
import com.tencent.luggage.wxa.ro.h;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/WxaTdiLoginBoot;", "", "()V", "Error_FAIL", "", "Error_IGNORE", "Error_OK", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "TAG", "", "value", "", "USE_TDI", "()Z", "setUSE_TDI", "(Z)V", "deviceId", "extraData", "hostAppId", "productId", "token", "userLoginDoneCallbacksQueue", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lkotlin/Function2;", "", "username", "waitForIlinkLoginDone", "waitForUserLoginDone", "boot", "bootInner", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "checkTokenIfNeed", "checkTokenValid", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z", "iLinkAutoLogin", "activateDeviceLogic", "Lcom/tencent/luggage/login/device/IActivateDevice;", "ilinkLoginDone", "userAutoLogin", "userLoginDone", "userAutoLoginForClientProcess", "userAutoLoginForMainProcess", "waitForILinkAutoLogin", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class w
{
  public static final w a = new w();
  private static final com.tencent.luggage.wxa.qz.w b = com.tencent.luggage.wxa.qz.w.a("Luggage.WxaTdiLoginBoot", 2);
  private static int c = -1;
  private static String d = "";
  private static String e = "";
  private static String f = "";
  private static String g = "";
  private static String h = "";
  private static Function2<? super Boolean, ? super String, Unit> i;
  private static final Function2<Boolean, String, Unit> j = (Function2)w.i.a;
  private static final ConcurrentLinkedQueue<Function2<Boolean, String, Unit>> k = new ConcurrentLinkedQueue();
  
  @JvmStatic
  @JvmName(name="USE_TDI")
  public static final boolean a()
  {
    return b.getBoolean("sUseTdi", true);
  }
  
  private final boolean a(Integer paramInteger, String paramString1, String paramString2, String paramString3)
  {
    if ((paramInteger == null) || (paramInteger.intValue() != -1))
    {
      int m;
      if ((paramString1 != null) && (((CharSequence)paramString1).length() > 0)) {
        m = 1;
      } else {
        m = 0;
      }
      if (m != 0)
      {
        if ((paramString2 != null) && (((CharSequence)paramString2).length() > 0)) {
          m = 1;
        } else {
          m = 0;
        }
        if (m != 0)
        {
          if ((paramString3 != null) && (((CharSequence)paramString3).length() > 0)) {
            m = 1;
          } else {
            m = 0;
          }
          if (m != 0) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private final com.tencent.luggage.wxa.ro.d<Boolean> c()
  {
    com.tencent.luggage.wxa.dg.d.a.e();
    Object localObject = (com.tencent.luggage.wxa.dg.b)com.tencent.luggage.wxa.ba.e.a(com.tencent.luggage.wxa.dg.b.class);
    if (localObject == null) {
      localObject = com.tencent.luggage.wxa.dg.b.b;
    }
    localObject = h.a().b((com.tencent.luggage.wxa.rl.b)new w.c((com.tencent.luggage.wxa.dg.b)localObject)).b((com.tencent.luggage.wxa.rl.b)w.d.a).b((com.tencent.luggage.wxa.rl.b)new w.e((com.tencent.luggage.wxa.dg.b)localObject)).b((com.tencent.luggage.wxa.rl.b)new w.f((com.tencent.luggage.wxa.dg.b)localObject));
    Intrinsics.checkExpressionValueIsNotNull(localObject, "pipeline().`$logic` {\n  …           true\n        }");
    return localObject;
  }
  
  private final void c(com.tencent.luggage.wxa.dg.b paramb, Function2<? super Integer, ? super String, Unit> paramFunction2)
  {
    boolean bool = a();
    Integer localInteger = Integer.valueOf(0);
    if (!bool)
    {
      paramFunction2.invoke(localInteger, "");
      return;
    }
    if (r.h())
    {
      d(paramb, paramFunction2);
      return;
    }
    paramFunction2.invoke(localInteger, "");
  }
  
  private final void d()
  {
    boolean bool = com.tencent.luggage.wxa.dg.d.a.a(c, d, e, f, g, h);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Wxa login logic boot: step 2: checkTokenByCgi:");
    ((StringBuilder)localObject).append(bool);
    o.d("Luggage.WxaTdiLoginBoot", ((StringBuilder)localObject).toString());
    if (bool)
    {
      localObject = i;
      if (localObject != null) {
        localObject = (Unit)((Function2)localObject).invoke(Boolean.valueOf(true), "");
      }
    }
  }
  
  private final void d(com.tencent.luggage.wxa.dg.b paramb, Function2<? super Integer, ? super String, Unit> paramFunction2)
  {
    paramb.a((b.b)new w.h(paramb, paramFunction2));
    paramb = paramb.f();
    if (paramb == null)
    {
      o.b("Luggage.WxaTdiLoginBoot", "userAutoLoginForMainProcess with NULL session, return false");
      paramFunction2.invoke(Integer.valueOf(-1), "fail:invalid session");
      paramb = j;
      if (paramb != null) {
        paramb = (Unit)paramb.invoke(Boolean.valueOf(false), "fail:invalid session");
      }
    }
    else
    {
      o.d("Luggage.WxaTdiLoginBoot", "userAutoLoginForMainProcess invoke tdiSession.autoLogin()");
      paramb.c();
    }
  }
  
  public final void a(@NotNull com.tencent.luggage.wxa.dg.b paramb, @NotNull Function2<? super Boolean, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "activateDeviceLogic");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "ilinkLoginDone");
    if (com.tencent.luggage.wxa.dg.d.a.g())
    {
      if (com.tencent.luggage.wxa.dg.d.a.f())
      {
        paramFunction2.invoke(Boolean.valueOf(true), "");
        return;
      }
      paramb.a((b.a)new w.g(paramFunction2));
      return;
    }
    paramFunction2.invoke(Boolean.valueOf(false), "first boot: not activate device before");
  }
  
  public final void a(@NotNull Function2<? super Boolean, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction2, "userLoginDone");
    if (i.a.g())
    {
      o.d("Luggage.WxaTdiLoginBoot", "wait For IlinkLoginDone");
      k.add(paramFunction2);
      return;
    }
    paramFunction2.invoke(Boolean.valueOf(false), "not login before");
  }
  
  public final void b()
  {
    if (!r.h()) {
      return;
    }
    if (Intrinsics.areEqual("com.tencent.ilink.ServiceProcess", r.c())) {
      return;
    }
    o.d("Luggage.WxaTdiLoginBoot", "Wxa login logic boot.");
    c().a((e.c)w.a.a).a((e.a)w.b.a);
  }
  
  public final void b(@NotNull com.tencent.luggage.wxa.dg.b paramb, @NotNull Function2<? super Boolean, ? super String, Unit> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "activateDeviceLogic");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "ilinkLoginDone");
    if (com.tencent.luggage.wxa.dg.d.a.g())
    {
      if (com.tencent.luggage.wxa.dg.d.a.f())
      {
        paramFunction2.invoke(Boolean.valueOf(true), "");
        return;
      }
      o.d("Luggage.WxaTdiLoginBoot", "wait For IlinkLoginDone");
      i = paramFunction2;
      return;
    }
    paramFunction2.invoke(Boolean.valueOf(false), "first boot: not activate device before");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.w
 * JD-Core Version:    0.7.0.1
 */