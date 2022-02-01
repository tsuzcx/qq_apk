package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.proguard.x;
import java.util.Map;

final class d$2
  implements Runnable
{
  d$2(Thread paramThread, int paramInt, String paramString1, String paramString2, String paramString3, Map paramMap) {}
  
  public final void run()
  {
    try
    {
      if (d.a() == null)
      {
        x.e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
        return;
      }
      d.a(d.a(), this.a, this.b, this.c, this.d, this.e, this.f);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (!x.b(localThrowable)) {
        localThrowable.printStackTrace();
      }
      x.e("[ExtraCrashManager] Crash error %s %s %s", new Object[] { this.c, this.d, this.e });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.d.2
 * JD-Core Version:    0.7.0.1
 */