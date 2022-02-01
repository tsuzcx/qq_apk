package com.tencent.luggage.wxa.dc;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import com.tencent.luggage.wxa.ba.b;
import com.tencent.luggage.wxa.ba.e;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/WxaTdiTransferAlertService;", "", "()V", "TAG", "", "isInstalled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "install", "", "application", "Landroid/app/Application;", "AlertServiceIMPL", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class x
{
  public static final x a = new x();
  private static final AtomicBoolean b = new AtomicBoolean(false);
  
  @JvmStatic
  public static final void a(@NotNull Application paramApplication)
  {
    Intrinsics.checkParameterIsNotNull(paramApplication, "application");
    if (!b.getAndSet(true))
    {
      e.a(h.class, (b)x.a.a);
      paramApplication.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)x.a.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.x
 * JD-Core Version:    0.7.0.1
 */