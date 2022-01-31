package com.tencent.bugly.crashreport.crash.jni;

import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;

final class NativeCrashHandler$1
  implements Runnable
{
  NativeCrashHandler$1(NativeCrashHandler paramNativeCrashHandler) {}
  
  public final void run()
  {
    if (!z.a(NativeCrashHandler.a(this.a), "native_record_lock", 10000L))
    {
      x.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
      return;
    }
    if (!NativeCrashHandler.b()) {
      NativeCrashHandler.a(this.a, 999, "false");
    }
    CrashDetailBean localCrashDetailBean = b.a(NativeCrashHandler.a(this.a), NativeCrashHandler.b(this.a), NativeCrashHandler.c(this.a));
    if (localCrashDetailBean != null)
    {
      x.a("[Native] Get crash from native record.", new Object[0]);
      if (!NativeCrashHandler.d(this.a).a(localCrashDetailBean)) {
        NativeCrashHandler.d(this.a).a(localCrashDetailBean, 3000L, false);
      }
      b.a(false, NativeCrashHandler.b(this.a));
    }
    this.a.a();
    z.b(NativeCrashHandler.a(this.a), "native_record_lock");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
 * JD-Core Version:    0.7.0.1
 */