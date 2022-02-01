package com.tencent.luggage.wxa.standalone_open_runtime;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getWxaScore", "", "userName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "luggage-standalone-open-runtime-sdk_release"}, k=2, mv={1, 1, 16})
public final class a
{
  @Nullable
  public static final Object a(@NotNull String paramString, @NotNull Continuation<? super Double> paramContinuation)
  {
    return BuildersKt.withContext((CoroutineContext)Dispatchers.getIO(), (Function2)new a.a(paramString, null), paramContinuation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.a
 * JD-Core Version:    0.7.0.1
 */