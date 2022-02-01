package com.tencent.luggage.wxa.hj;

import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"ipcInvoke", "", "InputType", "Landroid/os/Parcelable;", "ResultType", "targetProcessName", "", "request", "process", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "callback", "Lkotlin/Function1;", "(Ljava/lang/String;Landroid/os/Parcelable;Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;Lkotlin/jvm/functions/Function1;)V", "ipcInvokeSync", "task", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "(Ljava/lang/String;Landroid/os/Parcelable;Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;)Landroid/os/Parcelable;", "ipcinvoker_release"}, k=2, mv={1, 1, 16})
public final class b
{
  @NotNull
  public static final <InputType extends Parcelable, ResultType extends Parcelable> ResultType a(@NotNull String paramString, @Nullable InputType paramInputType, @NotNull k<InputType, ResultType> paramk)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "targetProcessName");
    Intrinsics.checkParameterIsNotNull(paramk, "task");
    paramString = h.a(paramString, paramInputType, paramk.getClass());
    Intrinsics.checkExpressionValueIsNotNull(paramString, "IPCInvoker.invokeSync(ta…equest, task::class.java)");
    return paramString;
  }
  
  public static final <InputType extends Parcelable, ResultType extends Parcelable> void a(@NotNull String paramString, @Nullable InputType paramInputType, @NotNull c<InputType, ResultType> paramc, @Nullable Function1<? super ResultType, Unit> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "targetProcessName");
    Intrinsics.checkParameterIsNotNull(paramc, "process");
    Class localClass = paramc.getClass();
    if (paramFunction1 == null) {
      paramc = null;
    } else {
      paramc = (e)new b.a(paramFunction1);
    }
    h.a(paramString, paramInputType, localClass, paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.b
 * JD-Core Version:    0.7.0.1
 */