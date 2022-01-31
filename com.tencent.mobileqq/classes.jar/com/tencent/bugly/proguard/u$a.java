package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;

final class u$a
  implements Runnable
{
  private final Context a;
  private final Runnable b;
  private final long c;
  
  public u$a(u paramu, Context paramContext)
  {
    this.a = paramContext;
    this.b = null;
    this.c = 0L;
  }
  
  public u$a(u paramu, Context paramContext, Runnable paramRunnable, long paramLong)
  {
    this.a = paramContext;
    this.b = paramRunnable;
    this.c = paramLong;
  }
  
  public final void run()
  {
    if (!z.a(this.a, "security_info", 30000L))
    {
      x.c("[UploadManager] Sleep %d try to lock security file again (pid=%d | tid=%d)", new Object[] { Integer.valueOf(5000), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      z.b(5000L);
      if (z.a(this, "BUGLY_ASYNC_UPLOAD") == null)
      {
        x.d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
        ??? = w.a();
        if (??? != null) {
          ((w)???).a(this);
        }
      }
      else
      {
        return;
      }
      x.e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
      return;
    }
    if (!u.c(this.d))
    {
      x.d("[UploadManager] Failed to load security info from database", new Object[0]);
      this.d.b(false);
    }
    if (u.d(this.d) != null)
    {
      if (this.d.d())
      {
        x.c("[UploadManager] Sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
        if (this.b != null) {
          u.a(this.d, this.b, this.c);
        }
        u.a(this.d, 0);
        z.b(this.a, "security_info");
        synchronized (u.e(this.d))
        {
          u.a(this.d, false);
          return;
        }
      }
      x.a("[UploadManager] Session ID is expired, drop it.", new Object[0]);
      this.d.b(true);
    }
    ??? = z.a(128);
    if ((??? != null) && (???.length << 3 == 128))
    {
      u.a(this.d, (byte[])???);
      x.c("[UploadManager] Execute one upload task for requesting session ID (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
      if (this.b != null)
      {
        u.a(this.d, this.b, this.c);
        return;
      }
      u.a(this.d, 1);
      return;
    }
    x.d("[UploadManager] Failed to create AES key (pid=%d | tid=%d)", new Object[] { Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()) });
    this.d.b(false);
    z.b(this.a, "security_info");
    synchronized (u.e(this.d))
    {
      u.a(this.d, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.proguard.u.a
 * JD-Core Version:    0.7.0.1
 */