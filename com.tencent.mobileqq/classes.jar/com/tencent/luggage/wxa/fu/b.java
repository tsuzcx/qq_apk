package com.tencent.luggage.wxa.fu;

import android.content.Context;
import android.util.Log;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/process/DummyProcessStartup;", "Lcom/tencent/luggage/wxaapi/internal/process/ProcessStartup;", "()V", "TAG", "", "initialize", "", "context", "Landroid/content/Context;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
  implements f
{
  public static final b a = new b();
  
  public void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = new StringBuilder();
    paramContext.append("initialize: useless startup:");
    paramContext.append(Log.getStackTraceString(new Throwable()));
    Log.w("DummyProcessStartup", paramContext.toString());
    paramContext = new StringBuilder();
    paramContext.append("initialize: useless startup:");
    paramContext.append(Log.getStackTraceString(new Throwable()));
    o.c("DummyProcessStartup", paramContext.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fu.b
 * JD-Core Version:    0.7.0.1
 */