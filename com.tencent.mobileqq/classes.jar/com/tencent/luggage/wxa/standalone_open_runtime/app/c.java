package com.tencent.luggage.wxa.standalone_open_runtime.app;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Process;
import com.tencent.luggage.wxa.fa.b;
import com.tencent.luggage.wxa.fa.b.a;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/app/WxaProcessSuicideLogic;", "", "()V", "TAG", "", "killProcess", "", "watch", "application", "Landroid/app/Application;", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class c
{
  public static final c a = new c();
  
  private final void a()
  {
    o.b();
    Process.killProcess(Process.myPid());
    System.exit(0);
    throw ((Throwable)new RuntimeException("System.exit returned normally, while it was supposed to halt JVM."));
  }
  
  public final void a(@NotNull Application paramApplication)
  {
    Intrinsics.checkParameterIsNotNull(paramApplication, "application");
    Object localObject = r.c();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "MMApplicationContext.getProcessName()");
    if (!StringsKt.contains$default((CharSequence)localObject, (CharSequence)":wxa_container", false, 2, null)) {
      return;
    }
    localObject = new AtomicInteger(0);
    paramApplication.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new c.a((AtomicInteger)localObject));
    b.a.a((b.a)new c.b((AtomicInteger)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.app.c
 * JD-Core Version:    0.7.0.1
 */