package com.tencent.luggage.wxa.gk;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/magicbrush/utils/ThreadUtil;", "", "()V", "uiHandler", "Landroid/os/Handler;", "getMainHandler", "isUiThread", "", "postOnUiThread", "r", "Lkotlin/Function0;", "", "run", "Ljava/lang/Runnable;", "delayMs", "", "runOnJsThreadIfAvailable", "runtime", "Lcom/tencent/magicbrush/MBRuntime;", "runnable", "runOnUiThread", "syncOnUiThread", "T", "cb", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "callable", "Ljava/util/concurrent/Callable;", "(Ljava/util/concurrent/Callable;)Ljava/lang/Object;", "lib-magicbrush-nano_release"}, k=1, mv={1, 1, 13})
public final class f
{
  public static final f a = new f();
  private static final Handler b = new Handler(Looper.getMainLooper());
  
  @JvmStatic
  @NotNull
  public static final Handler a()
  {
    return b;
  }
  
  @JvmStatic
  public static final void a(@NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "run");
    if (b())
    {
      paramRunnable.run();
      return;
    }
    b.post(paramRunnable);
  }
  
  @JvmStatic
  public static final boolean b()
  {
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    Intrinsics.checkExpressionValueIsNotNull(localLooper, "Looper.getMainLooper()");
    return Intrinsics.areEqual(localThread, localLooper.getThread());
  }
  
  public final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "run");
    a((Runnable)new g(paramFunction0));
  }
  
  public final <T> T b(@NotNull Function0<? extends T> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "cb");
    paramFunction0 = new e((Callable)new f.a(paramFunction0));
    a((Runnable)paramFunction0);
    return paramFunction0.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gk.f
 * JD-Core Version:    0.7.0.1
 */