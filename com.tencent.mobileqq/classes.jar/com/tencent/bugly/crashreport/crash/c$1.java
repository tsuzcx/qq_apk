package com.tencent.bugly.crashreport.crash;

import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.proguard.x;

final class c$1
  implements Runnable
{
  c$1(c paramc, boolean paramBoolean1, Thread paramThread, Throwable paramThrowable, String paramString, byte[] paramArrayOfByte, boolean paramBoolean2) {}
  
  public final void run()
  {
    try
    {
      x.c("post a throwable %b", new Object[] { Boolean.valueOf(this.a) });
      c.a(this.g).a(this.b, this.c, false, this.d, this.e);
      if (this.f)
      {
        x.a("clear user datas", new Object[0]);
        a.a(c.b(this.g)).A();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      if (x.b(localThrowable) != true) {
        localThrowable.printStackTrace();
      }
      x.e("java catch error: %s", new Object[] { this.c.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.c.1
 * JD-Core Version:    0.7.0.1
 */