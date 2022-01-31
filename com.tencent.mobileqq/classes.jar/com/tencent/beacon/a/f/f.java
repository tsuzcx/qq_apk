package com.tencent.beacon.a.f;

import android.content.Context;
import android.util.SparseArray;
import com.tencent.beacon.a.a.c;
import com.tencent.beacon.a.b.d;
import com.tencent.beacon.a.e.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class f
{
  private Context a = null;
  
  public f(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final void a(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (paramInt != 101) {
      com.tencent.beacon.a.g.a.c("[strategy] com strategy unmatch key: %d", new Object[] { Integer.valueOf(paramInt) });
    }
    com.tencent.beacon.a.e.a locala;
    Object localObject1;
    int i;
    for (;;)
    {
      return;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        locala = com.tencent.beacon.a.e.b.j(this.a).k();
        if (locala == null)
        {
          com.tencent.beacon.a.g.a.c("[strategy] impossible! common strategy null!", new Object[0]);
          return;
        }
        try
        {
          localObject1 = new com.tencent.beacon.a.d.c.a();
          ((com.tencent.beacon.a.d.c.a)localObject1).a(new com.tencent.beacon.a.h.a(paramArrayOfByte));
          com.tencent.beacon.a.e.b localb = com.tencent.beacon.a.e.b.j(this.a);
          if (locala == null)
          {
            i = 0;
            if (i != 0)
            {
              if (paramBoolean)
              {
                com.tencent.beacon.a.g.a.e("[strategy] update common strategy should save ", new Object[0]);
                a.a.a(this.a, paramInt, paramArrayOfByte);
              }
              localb.b(locala);
            }
            if (!paramBoolean) {
              continue;
            }
            localb.h();
            paramArrayOfByte = d.a();
            if ((paramArrayOfByte == null) || (!paramArrayOfByte.m())) {
              continue;
            }
            paramArrayOfByte = c.a(this.a);
            paramInt = paramArrayOfByte.a("today_success_strategy_query_times");
            paramArrayOfByte.a().a("today_success_strategy_query_times", Integer.valueOf(paramInt + 1)).a("last_success_strategy_query_time", Long.valueOf(System.currentTimeMillis())).b();
          }
        }
        catch (Throwable paramArrayOfByte)
        {
          com.tencent.beacon.a.g.a.a(paramArrayOfByte);
          com.tencent.beacon.a.g.a.d("[strategy] error to common strategy!", new Object[0]);
          return;
        }
      }
    }
    int k = 0;
    if (!((com.tencent.beacon.a.d.c.a)localObject1).c.equals(locala.b()))
    {
      k = 1;
      locala.a(((com.tencent.beacon.a.d.c.a)localObject1).c);
    }
    if (((com.tencent.beacon.a.d.c.a)localObject1).b != locala.c())
    {
      k = 1;
      locala.a(((com.tencent.beacon.a.d.c.a)localObject1).b);
    }
    Object localObject2 = ((com.tencent.beacon.a.d.c.a)localObject1).a;
    label292:
    Object localObject3;
    int m;
    label336:
    int j;
    label369:
    boolean bool;
    label440:
    label586:
    label633:
    int n;
    if (locala == null)
    {
      i = 0;
      break label972;
      localObject1 = ((com.tencent.beacon.a.d.c.a)localObject1).d;
      if (locala == null)
      {
        i = 0;
        break label983;
      }
    }
    else
    {
      i = 0;
      if (localObject2 != null)
      {
        localObject3 = locala.e();
        if (localObject3 == null) {
          break label972;
        }
        m = 0;
        i = 0;
        j = i;
        if (m >= ((SparseArray)localObject3).size()) {
          break label968;
        }
        a.a locala1 = (a.a)((SparseArray)localObject3).valueAt(m);
        Iterator localIterator = ((ArrayList)localObject2).iterator();
        if (!localIterator.hasNext()) {
          break label1007;
        }
        com.tencent.beacon.a.d.c.b localb1 = (com.tencent.beacon.a.d.c.b)localIterator.next();
        j = i;
        if (localb1.a != locala1.e()) {
          break label994;
        }
        com.tencent.beacon.a.g.a.a("[strategy] server module strategy mid: %d", new Object[] { Byte.valueOf(localb1.a) });
        if (localb1.b != 1) {
          break label1001;
        }
        bool = true;
        if (locala1.a() != bool)
        {
          i = 1;
          locala1.a(bool);
        }
        j = i;
        if (!locala1.b().equals(localb1.c))
        {
          j = 1;
          locala1.a(localb1.c);
        }
        if (localb1.a != 1)
        {
          i = j;
          if (localb1.a != 2) {}
        }
        else
        {
          if ((locala1.c() == null) || (localb1.d == null)) {
            break label706;
          }
          i = j;
          if (!locala1.c().equals(localb1.d))
          {
            i = 1;
            locala1.a(localb1.d);
            com.tencent.beacon.a.e.b.j(this.a).b(localb1.a, localb1.d);
          }
        }
        j = i;
        if (localb1.a != 1) {
          break label994;
        }
        if ((locala1.d() != null) && (localb1.e != null))
        {
          if (!locala1.d().equals(localb1.e))
          {
            i = 1;
            locala1.a(com.tencent.beacon.a.a.a(localb1.e));
          }
          label649:
          if ((locala1.f() == null) || (localb1.f == null)) {
            break label785;
          }
          j = i;
          if (locala1.f().equals(localb1.f)) {
            break label994;
          }
        }
        for (;;)
        {
          j = 1;
          locala1.b(com.tencent.beacon.a.a.a(localb1.f));
          break label994;
          label706:
          i = j;
          if (localb1.d == null) {
            break label586;
          }
          i = j;
          if (locala1.c() != null) {
            break label586;
          }
          i = 1;
          locala1.a(localb1.d);
          com.tencent.beacon.a.e.b.j(this.a).b(localb1.a, localb1.d);
          break label586;
          if (locala1.d() != null) {
            break label633;
          }
          if (localb1.e == null) {
            break label649;
          }
          break label633;
          label785:
          if (locala1.f() == null) {
            if (localb1.f == null) {
              break;
            }
          }
        }
      }
      localObject2 = locala.e();
      if (localObject2 == null) {
        break label972;
      }
      n = ((SparseArray)localObject2).size();
      m = 0;
      i = 0;
    }
    for (;;)
    {
      j = i;
      if (m < n)
      {
        localObject3 = (a.a)((SparseArray)localObject2).valueAt(m);
        if (!((a.a)localObject3).a()) {
          break label1016;
        }
        i = 1;
        ((a.a)localObject3).a(false);
        break label1016;
        k = 0;
        if ((localObject1 != null) && (locala.d() != null))
        {
          i = k;
          if (!((Map)localObject1).equals(locala.d()))
          {
            locala.a((Map)localObject1);
            i = 1;
          }
        }
        else
        {
          i = k;
          if (localObject1 != null)
          {
            i = k;
            if (locala.d() == null)
            {
              locala.a((Map)localObject1);
              i = 1;
            }
          }
        }
      }
      label968:
      label972:
      label983:
      while (i == 0)
      {
        i = j;
        break;
        do
        {
          j = k;
          break;
          i = j;
        } while (i == 0);
        j = 1;
        break label292;
      }
      i = 1;
      break;
      label994:
      i = j;
      break label369;
      label1001:
      bool = false;
      break label440;
      label1007:
      m += 1;
      break label336;
      label1016:
      m += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.f.f
 * JD-Core Version:    0.7.0.1
 */