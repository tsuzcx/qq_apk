package com.tencent.acstat;

import android.content.Context;
import com.tencent.acstat.common.StatLogger;
import com.tencent.acstat.event.d;
import com.tencent.acstat.event.f;
import java.util.Map;

final class u
  implements Runnable
{
  u(Context paramContext, String paramString, StatSpecifyReportedInfo paramStatSpecifyReportedInfo) {}
  
  public final void run()
  {
    try
    {
      StatServiceImpl.flushDataToDB(this.a);
      synchronized (StatServiceImpl.g())
      {
        Object localObject2 = (Long)StatServiceImpl.g().remove(this.b);
        if (localObject2 != null)
        {
          localObject2 = Long.valueOf((System.currentTimeMillis() - ((Long)localObject2).longValue()) / 1000L);
          ??? = localObject2;
          if (((Long)localObject2).longValue() <= 0L) {
            ??? = Long.valueOf(1L);
          }
          String str = StatServiceImpl.i();
          localObject2 = str;
          if (str != null)
          {
            localObject2 = str;
            if (str.equals(this.b) == true) {
              localObject2 = "-";
            }
          }
          ??? = new f(this.a, (String)localObject2, this.b, StatServiceImpl.a(this.a, false, this.c), (Long)???, this.c);
          if (!this.b.equals(StatServiceImpl.h())) {
            StatServiceImpl.f().warn("Invalid invocation since previous onResume on diff page.");
          }
          new ab((d)???).a();
          StatServiceImpl.c(this.b);
          return;
        }
      }
      StatServiceImpl.f().e("Starttime for PageID:" + this.b + " not found, lost onResume()?");
    }
    catch (Throwable localThrowable)
    {
      StatServiceImpl.f().e(localThrowable);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.u
 * JD-Core Version:    0.7.0.1
 */