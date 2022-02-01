package com.tencent.luggage.wxa.fr;

import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/crash/WxaJvmCrashHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "()V", "TAG", "", "crashListeners", "Ljava/util/ArrayList;", "Lcom/tencent/luggage/wxaapi/internal/crash/JvmCrashListener;", "Lkotlin/collections/ArrayList;", "defaultExceptionHandler", "addJvmCrashListener", "", "l", "addJvmCrashListener$luggage_standalone_open_runtime_sdk_release", "uncaughtException", "thread", "Ljava/lang/Thread;", "throwable", "", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class e
  implements Thread.UncaughtExceptionHandler
{
  public static final e a;
  private static Thread.UncaughtExceptionHandler b;
  private static final ArrayList<a> c = new ArrayList();
  
  static
  {
    e locale = new e();
    a = locale;
    Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
    Intrinsics.checkExpressionValueIsNotNull(localUncaughtExceptionHandler, "Thread.getDefaultUncaughtExceptionHandler()");
    b = localUncaughtExceptionHandler;
    Thread.setDefaultUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)locale);
  }
  
  public final void a(@NotNull a parama)
  {
    Intrinsics.checkParameterIsNotNull(parama, "l");
    c.add(parama);
  }
  
  public void uncaughtException(@NotNull Thread paramThread, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramThread, "thread");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "throwable");
    paramThrowable.printStackTrace();
    try
    {
      Iterator localIterator = ((Iterable)c).iterator();
      while (localIterator.hasNext()) {
        ((a)localIterator.next()).a(paramThread, paramThrowable);
      }
      return;
    }
    catch (Exception localException)
    {
      o.a("Luggage.WXA.CrashReportSetup", (Throwable)localException, "invoke crash handler fail", new Object[0]);
      o.a();
      b.uncaughtException(paramThread, paramThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fr.e
 * JD-Core Version:    0.7.0.1
 */