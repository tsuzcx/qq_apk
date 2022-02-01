package com.tencent.luggage.wxa.ea;

import android.util.Log;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager$Companion;", "", "()V", "INSTANCE", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager;", "Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcess;", "Lcom/tencent/luggage/sdk/processes/LuggageStartParams;", "INSTANCE$annotations", "getINSTANCE", "()Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager;", "setINSTANCE", "(Lcom/tencent/luggage/sdk/processes/LuggageMiniProgramProcessManager;)V", "KEY_PROCESS_INDEX", "", "TAG", "<set-?>", "", "banInvokePrivacyAPI", "getBanInvokePrivacyAPI", "()Z", "setBanInvokePrivacyAPI", "(Z)V", "banInvokePrivacyAPI$delegate", "Lcom/tencent/luggage/sdk/wxa_ktx/WxaMmkvProperty;", "initAllProcessesAliveState", "", "inject", "_instance", "reInject", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 1, 16})
public final class c$a
{
  public final void a(@NotNull c<b<h>, h> paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "<set-?>");
    c.a(paramc);
  }
  
  public final void a(boolean paramBoolean)
  {
    c.g().a(c.c, a[0], Boolean.valueOf(paramBoolean));
  }
  
  public final boolean a()
  {
    return ((Boolean)c.g().a(c.c, a[0])).booleanValue();
  }
  
  @NotNull
  public final c<b<h>, h> b()
  {
    c localc = c.h();
    if (localc == null) {
      Intrinsics.throwUninitializedPropertyAccessException("INSTANCE");
    }
    return localc;
  }
  
  @JvmStatic
  public final void b(@NotNull c<b<h>, h> paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "_instance");
    if (r.h())
    {
      a locala = (a)this;
      if (a(locala) == null)
      {
        locala.a(paramc);
        locala.c();
      }
      return;
    }
    throw ((Throwable)new IllegalAccessError("ProcessManager can only used by main process"));
  }
  
  public final void c()
  {
    if (((a)this).a())
    {
      o.d("Luggage.LuggageMiniProgramProcessManager", "initAllProcessesAliveState: reject");
      return;
    }
    f.a.c((Runnable)c.a.a.a);
  }
  
  @JvmStatic
  public final void c(@NotNull c<b<h>, h> paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "_instance");
    a locala = (a)this;
    o.e("Luggage.LuggageMiniProgramProcessManager", "reInject: old %s new %s stack %s", new Object[] { Integer.valueOf(locala.b().hashCode()), Integer.valueOf(paramc.hashCode()), Log.getStackTraceString(new Throwable()) });
    locala.a(paramc);
    locala.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ea.c.a
 * JD-Core Version:    0.7.0.1
 */