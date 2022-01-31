package com.tencent.beacon.a.e;

import android.content.Context;
import com.tencent.beacon.a.f.g;
import java.util.Iterator;
import java.util.List;

public final class c
  implements Runnable
{
  private static long a = 0L;
  private Context b = null;
  
  public c(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private static long a()
  {
    try
    {
      long l = a;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(long paramLong)
  {
    try
    {
      a = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private static boolean a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = com.tencent.beacon.a.a.c.a(paramContext);
      int i = Integer.parseInt(paramContext.a("querytimes", "0"));
      if (!com.tencent.beacon.a.a.f().equals(paramString)) {
        i = 0;
      }
      if (i <= a.a().f())
      {
        paramContext.a().a("querytimes", String.valueOf(i + 1)).b();
        return false;
      }
      bool = true;
      com.tencent.beacon.a.g.a.c("[strategy] set init times failed! ", new Object[0]);
    }
    catch (Exception paramContext)
    {
      try
      {
        com.tencent.beacon.a.g.a.e("[strategy] sdk init max times", new Object[0]);
        return true;
      }
      catch (Exception paramContext)
      {
        boolean bool;
        break label75;
      }
      paramContext = paramContext;
      bool = false;
    }
    label75:
    return bool;
  }
  
  public final void run()
  {
    Object localObject1 = a.a.a(this.b);
    if ((localObject1 != null) && (((d)localObject1).b == 101) && (((d)localObject1).c != null)) {}
    try
    {
      localObject4 = b.j(this.b).l();
      if (localObject4 != null)
      {
        ((com.tencent.beacon.a.f.f)localObject4).a(101, ((d)localObject1).c, false);
        com.tencent.beacon.a.g.a.e("common strategy setted by local db", new Object[0]);
      }
    }
    catch (Throwable localThrowable)
    {
      try
      {
        for (;;)
        {
          ((b)localObject4).n();
          localObject1 = localList.iterator();
          while (((Iterator)localObject1).hasNext()) {
            ((com.tencent.beacon.a.a)((Iterator)localObject1).next()).b_();
          }
          localThrowable = localThrowable;
          com.tencent.beacon.a.g.a.a(localThrowable);
        }
      }
      finally {}
    }
    Object localObject4 = b.j(this.b);
    List localList = com.tencent.beacon.a.a.a(this.b);
    boolean bool;
    long l1;
    if (((b)localObject4).o() == 0)
    {
      com.tencent.beacon.a.g.a.e("[strategy] stepCheckApp", new Object[0]);
      ((b)localObject4).a(1);
      bool = com.tencent.beacon.a.c.a.b(this.b);
      com.tencent.beacon.a.g.a.e("[strategy] isAppFirstRun : %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        com.tencent.beacon.a.g.a.e("[db] clear all analytics: %d", new Object[] { Integer.valueOf(com.tencent.beacon.a.a.a.a.a(this.b, null)) });
      }
      l1 = a();
      if (l1 > 0L) {
        com.tencent.beacon.a.g.a.e("[strategy] sleep: %d", new Object[] { Long.valueOf(l1) });
      }
    }
    try
    {
      Thread.sleep(l1);
      com.tencent.beacon.a.g.a.e("[strategy] stepStartQuery", new Object[0]);
      ((b)localObject4).a(2);
      ((b)localObject4).b(((b)localObject4).q() + 1);
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        localIterator.next();
      }
    }
    catch (InterruptedException localInterruptedException1)
    {
      for (;;)
      {
        com.tencent.beacon.a.g.a.a(localInterruptedException1);
      }
      int i;
      Object localObject5;
      String str;
      Object localObject6;
      if (!a.a().g())
      {
        g localg = b.i();
        i = 0;
        for (;;)
        {
          if (localg == null)
          {
            i += 1;
            if (i < 5) {
              try
              {
                Thread.sleep(200L);
                localg = b.i();
              }
              catch (InterruptedException localInterruptedException2)
              {
                for (;;)
                {
                  com.tencent.beacon.a.g.a.a(localInterruptedException2);
                }
              }
            }
          }
        }
        if (localInterruptedException2 == null) {
          break label687;
        }
        localObject5 = com.tencent.beacon.a.a.c.a(this.b);
        str = ((com.tencent.beacon.a.a.c)localObject5).a("initsdkdate", "");
        if (!com.tencent.beacon.a.a.f().equals(str)) {
          ((com.tencent.beacon.a.a.c)localObject5).a().a("initsdkdate", com.tencent.beacon.a.a.f()).b();
        }
        bool = a(this.b, str);
        localObject6 = this.b;
        localObject5 = com.tencent.beacon.a.b.d.a();
        if (!((com.tencent.beacon.a.b.d)localObject5).m()) {
          break label646;
        }
        localObject6 = com.tencent.beacon.a.a.c.a((Context)localObject6);
        l1 = System.currentTimeMillis();
        long l2 = (l1 / 60000L + 480L) % 1440L;
        if ((l2 < 0L) || (l2 > 30L) || (l1 - ((com.tencent.beacon.a.a.c)localObject6).b("last_success_strategy_query_time") > 90000000L)) {
          break label596;
        }
        i = 1;
        if ((!bool) && (i == 0)) {
          break label651;
        }
        com.tencent.beacon.a.g.a.c("[strategy] query times or query success times arrive max, return!", new Object[0]);
        b.j(this.b).h();
      }
      for (;;)
      {
        com.tencent.beacon.a.g.a.h("[strategy] common query end!", new Object[0]);
        ((b)localObject4).a(3);
        localObject3 = localList.iterator();
        while (((Iterator)localObject3).hasNext()) {
          ((com.tencent.beacon.a.a)((Iterator)localObject3).next()).d();
        }
        label596:
        if (com.tencent.beacon.a.a.f().equals(str))
        {
          if (((com.tencent.beacon.a.a.c)localObject6).a("today_success_strategy_query_times") < ((com.tencent.beacon.a.b.d)localObject5).l()) {
            break label646;
          }
          i = 1;
          break;
        }
        ((com.tencent.beacon.a.a.c)localObject6).a().a("today_success_strategy_query_times", Integer.valueOf(0)).b();
        label646:
        i = 0;
        break;
        label651:
        ((g)localObject3).a(new com.tencent.beacon.a.f.c(this.b));
        com.tencent.beacon.a.c.d.a(this.b).g().a_();
        continue;
        label687:
        com.tencent.beacon.a.g.a.h("[strategy] uphandler is null", new Object[0]);
      }
      Object localObject3 = b.j(this.b).k();
      if (localObject3 == null)
      {
        com.tencent.beacon.a.g.a.d("[strategy] currentStrategy is null.", new Object[0]);
        return;
      }
      l1 = ((a)localObject3).c() * 60000;
      if (l1 > 0L)
      {
        com.tencent.beacon.a.a.b.a().a(this, l1);
        com.tencent.beacon.a.g.a.h("[strategy] next time: %d", new Object[] { Long.valueOf(l1) });
        b.j(this.b).a(4);
        return;
      }
      com.tencent.beacon.a.g.a.h("[strategy] stop loop query", new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.e.c
 * JD-Core Version:    0.7.0.1
 */