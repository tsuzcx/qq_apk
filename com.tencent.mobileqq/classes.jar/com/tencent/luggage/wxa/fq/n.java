package com.tencent.luggage.wxa.fq;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.w;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/WxaPeriodTaskChecker;", "", "()V", "CHECK_INTERVAL_MS", "", "getCHECK_INTERVAL_MS", "()J", "CHECK_IN_MAIN_PROCESS_ONLY", "", "getCHECK_IN_MAIN_PROCESS_ONLY", "()Z", "CHECK_IN_WORKER", "getCHECK_IN_WORKER", "KEY_LAST_CHECKED_TIMESTAMP", "", "MMKV", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "getMMKV", "()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "TAG", "getTAG", "()Ljava/lang/String;", "clearCheckedTimestamp", "", "doCheck", "installPeriodChecker", "application", "Landroid/app/Application;", "onInstalled", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public abstract class n
{
  private final String a;
  private final long b;
  private final boolean c;
  private final boolean d;
  
  public n()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a());
    localStringBuilder.append("__KEY_LAST_CHECKED_TIMESTAMP");
    this.a = localStringBuilder.toString();
    this.b = TimeUnit.DAYS.toMillis(1L);
    this.c = true;
    this.d = true;
  }
  
  private final w f()
  {
    return w.a("WxaPeriodTaskChecker.cfg", 2);
  }
  
  @NotNull
  public abstract String a();
  
  public final void a(@NotNull Application paramApplication)
  {
    Intrinsics.checkParameterIsNotNull(paramApplication, "application");
    if ((e()) && (!r.h())) {
      return;
    }
    paramApplication.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)new n.a(this));
    b(paramApplication);
  }
  
  public abstract void b();
  
  protected void b(@NotNull Application paramApplication)
  {
    Intrinsics.checkParameterIsNotNull(paramApplication, "application");
  }
  
  public long c()
  {
    return this.b;
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public boolean e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.n
 * JD-Core Version:    0.7.0.1
 */