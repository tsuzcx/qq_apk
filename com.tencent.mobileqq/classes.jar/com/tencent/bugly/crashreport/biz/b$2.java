package com.tencent.bugly.crashreport.biz;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import java.util.List;

final class b$2
  implements Application.ActivityLifecycleCallbacks
{
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    if (paramActivity != null) {
      paramActivity = paramActivity.getClass().getName();
    } else {
      paramActivity = "unknown";
    }
    if ((b.b() != null) && (!b.b().getName().equals(paramActivity))) {
      return;
    }
    x.c(">>> %s onCreated <<<", new Object[] { paramActivity });
    paramBundle = com.tencent.bugly.crashreport.common.info.a.b();
    if (paramBundle != null) {
      paramBundle.D.add(b.a(paramActivity, "onCreated"));
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity = paramActivity.getClass().getName();
    } else {
      paramActivity = "unknown";
    }
    if ((b.b() != null) && (!b.b().getName().equals(paramActivity))) {
      return;
    }
    x.c(">>> %s onDestroyed <<<", new Object[] { paramActivity });
    com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
    if (locala != null) {
      locala.D.add(b.a(paramActivity, "onDestroyed"));
    }
  }
  
  public final void onActivityPaused(Activity paramActivity)
  {
    String str;
    if (paramActivity != null) {
      str = paramActivity.getClass().getName();
    } else {
      str = "unknown";
    }
    if ((b.b() != null) && (!b.b().getName().equals(str))) {
      return;
    }
    x.c(">>> %s onPaused <<<", new Object[] { str });
    com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
    if (locala == null) {
      return;
    }
    locala.D.add(b.a(str, "onPaused"));
    locala.a(false);
    locala.u = System.currentTimeMillis();
    locala.v = (locala.u - locala.t);
    b.b(locala.u);
    if (locala.v < 0L) {
      locala.v = 0L;
    }
    if (paramActivity != null)
    {
      locala.s = "background";
      return;
    }
    locala.s = "unknown";
  }
  
  public final void onActivityResumed(Activity paramActivity)
  {
    if (paramActivity != null) {
      paramActivity = paramActivity.getClass().getName();
    } else {
      paramActivity = "unknown";
    }
    if ((b.b() != null) && (!b.b().getName().equals(paramActivity))) {
      return;
    }
    x.c(">>> %s onResumed <<<", new Object[] { paramActivity });
    com.tencent.bugly.crashreport.common.info.a locala = com.tencent.bugly.crashreport.common.info.a.b();
    if (locala == null) {
      return;
    }
    locala.D.add(b.a(paramActivity, "onResumed"));
    locala.a(true);
    locala.s = paramActivity;
    locala.t = System.currentTimeMillis();
    locala.w = (locala.t - b.c());
    long l2 = locala.t - b.d();
    long l1;
    if (b.e() > 0L) {
      l1 = b.e();
    } else {
      l1 = b.f();
    }
    if (l2 > l1)
    {
      locala.c();
      b.g();
      x.a("[session] launch app one times (app in background %d seconds and over %d seconds)", new Object[] { Long.valueOf(l2 / 1000L), Long.valueOf(b.f() / 1000L) });
      if (b.h() % b.i() == 0)
      {
        b.b.a(4, b.j(), 0L);
        return;
      }
      b.b.a(4, false, 0L);
      l1 = System.currentTimeMillis();
      if (l1 - b.k() > b.l())
      {
        b.a(l1);
        x.a("add a timer to upload hot start user info", new Object[0]);
        if (b.j())
        {
          paramActivity = b.b;
          l1 = b.l();
          w.a().a(new a.a(paramActivity, null, true), l1);
        }
      }
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.crashreport.biz.b.2
 * JD-Core Version:    0.7.0.1
 */