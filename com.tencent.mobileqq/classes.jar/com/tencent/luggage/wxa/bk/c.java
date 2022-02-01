package com.tencent.luggage.wxa.bk;

import com.tencent.magicbrush.handler.a;
import com.tencent.mm.plugin.appbrand.jsruntime.q;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/game/boot/JsThreadHandler;", "Lcom/tencent/magicbrush/handler/IJsThreadHandler;", "impl", "Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "(Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;)V", "getImpl", "()Lcom/tencent/mm/plugin/appbrand/jsruntime/AppBrandJsRuntimeAddonJsThread;", "doInnerLoopTask", "", "getExecutingTaskNameForDebug", "", "isJsThreadCurrent", "post", "", "r", "Ljava/lang/Runnable;", "ignorePause", "resumeLoopTasks", "luggage-wxa-game-ext_release"}, k=1, mv={1, 1, 16})
final class c
  implements a
{
  @NotNull
  private final q a;
  
  public c(@NotNull q paramq)
  {
    this.a = paramq;
  }
  
  public void a(@NotNull Runnable paramRunnable, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "r");
    this.a.a(paramRunnable, paramBoolean);
  }
  
  public boolean a()
  {
    return this.a.l();
  }
  
  @Nullable
  public String b()
  {
    return this.a.m();
  }
  
  public void c()
  {
    this.a.h();
  }
  
  public boolean d()
  {
    return this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bk.c
 * JD-Core Version:    0.7.0.1
 */