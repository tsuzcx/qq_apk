package com.tencent.luggage.util;

import android.os.Looper;
import com.tencent.luggage.wxa.qz.t;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.contracts.ExperimentalContracts;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"profileTime", "Lkotlin/Pair;", "T", "Lkotlin/time/Duration;", "block", "Lkotlin/Function0;", "tag", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "removeUiRunnable", "", "task", "Ljava/lang/Runnable;", "uiThread", "delay", "", "isNotNull", "", "", "isNull", "optStringStrictly", "Lorg/json/JSONObject;", "name", "startsWithIgnoreCase", "prefix", "protocol", "startsWithIgnoreCaseAndBlank", "luggage-commons_release"}, k=2, mv={1, 1, 16})
public final class c
{
  @NotNull
  public static final String a(@NotNull JSONObject paramJSONObject, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "$this$optStringStrictly");
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    paramJSONObject = paramJSONObject.opt(paramString);
    if ((paramJSONObject instanceof String)) {
      return (String)paramJSONObject;
    }
    return "";
  }
  
  public static final void a(long paramLong, @NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    t.a((Runnable)new d(paramFunction0), paramLong);
  }
  
  public static final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "block");
    Thread localThread = Thread.currentThread();
    Looper localLooper = Looper.getMainLooper();
    Intrinsics.checkExpressionValueIsNotNull(localLooper, "Looper.getMainLooper()");
    if (Intrinsics.areEqual(localThread, localLooper.getThread()))
    {
      paramFunction0.invoke();
      return;
    }
    t.a((Runnable)new d(paramFunction0));
  }
  
  @ExperimentalContracts
  public static final boolean a(@Nullable Object paramObject)
  {
    return paramObject == null;
  }
  
  @ExperimentalContracts
  public static final boolean b(@Nullable Object paramObject)
  {
    return paramObject != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.c
 * JD-Core Version:    0.7.0.1
 */