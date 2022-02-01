package com.tencent.luggage.wxa.pd;

import android.util.Log;
import com.tencent.luggage.wxa.rm.a;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable$Companion;", "", "()V", "obtain", "Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "registry", "Lcom/tencent/mm/plugin/appbrand/utils/ILifeCycleRegistry;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "runnable", "Ljava/lang/Runnable;", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class n$a
{
  @JvmStatic
  @NotNull
  public final n a(@NotNull i<? super a> parami, @Nullable Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(parami, "registry");
    if ((paramRunnable instanceof n)) {
      return (n)paramRunnable;
    }
    return new n(parami, paramRunnable, Log.getStackTraceString(new Throwable()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.n.a
 * JD-Core Version:    0.7.0.1
 */