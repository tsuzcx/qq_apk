package com.tencent.beacon.a.b;

import android.content.Context;
import com.tencent.beacon.a.e.a.a;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.InitHandleListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class j
  extends com.tencent.beacon.a.a
{
  private static j b = null;
  private static a i;
  private f c = null;
  private f d = null;
  private List<c> e = null;
  private Object f = new Object();
  private boolean g;
  private InitHandleListener h;
  
  private j(Context paramContext)
  {
    super(paramContext);
    com.tencent.beacon.a.c.b.a(this.a);
    d.a();
    if (this.e == null) {
      this.e = Collections.synchronizedList(new ArrayList(5));
    }
    this.c = new a(paramContext);
    this.d = new h(paramContext);
  }
  
  public static void a(a parama)
  {
    i = parama;
  }
  
  public static boolean a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    int j;
    if ((paramString == null) || (paramString.equals("")))
    {
      j = 1;
      if (j == 0) {
        break label35;
      }
      paramString = null;
    }
    label35:
    Object localObject1;
    for (;;)
    {
      if (paramString != null) {
        break label161;
      }
      return false;
      j = 0;
      break;
      localObject2 = paramString.replace('|', '_').trim();
      if (((String)localObject2).length() == 0)
      {
        com.tencent.beacon.a.g.a.d("[core] eventName is invalid!! eventName length == 0!", new Object[0]);
        paramString = null;
      }
      else if (com.tencent.beacon.a.a.d((String)localObject2))
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() > 128)
        {
          com.tencent.beacon.a.g.a.c("[core] eventName length should be less than 128! eventName:" + paramString, new Object[0]);
          localObject1 = ((String)localObject2).substring(0, 128);
        }
        paramString = (String)localObject1;
      }
      else
      {
        com.tencent.beacon.a.g.a.d("[core] eventName should be ASCII code in 32-126! eventName:" + paramString, new Object[0]);
        paramString = null;
      }
    }
    label161:
    com.tencent.beacon.a.g.a.a("[event] UserEvent: %s, %b, %d, %d, %b, %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
    Object localObject2 = g();
    if ((localObject2 != null) && (!com.tencent.beacon.a.e.b.j(((j)localObject2).a).p()))
    {
      com.tencent.beacon.a.g.a.a("[event] [%s] add to cache events list.", new Object[] { paramString });
      if (((j)localObject2).e != null) {
        ((j)localObject2).e.add(new c(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2));
      }
      return true;
    }
    if (!k())
    {
      com.tencent.beacon.a.g.a.d("[event] UserEventModule is disable (false).", new Object[0]);
      return false;
    }
    if (d.a().a(paramString))
    {
      com.tencent.beacon.a.g.a.d("[event] '%s' is not allowed in strategy (false).", new Object[] { paramString });
      return false;
    }
    if ((!paramBoolean1) || ((paramBoolean1) && (d.a().b(paramString)))) {
      if (paramBoolean2) {
        localObject1 = ((j)localObject2).d;
      }
    }
    while (localObject1 != null)
    {
      paramString = com.tencent.beacon.a.a.a(((j)localObject2).a, paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
      if (paramString == null)
      {
        com.tencent.beacon.a.g.a.d("[event] RDBean is null, return false!", new Object[0]);
        return false;
        localObject1 = ((j)localObject2).c;
      }
      else
      {
        return ((f)localObject1).a(paramString);
        com.tencent.beacon.a.g.a.d("[event] '%s' is sampled by svr rate (false).", new Object[] { paramString });
        return false;
      }
    }
    return false;
  }
  
  public static void b(boolean paramBoolean)
  {
    Object localObject = g();
    if (localObject != null)
    {
      f localf = ((j)localObject).c;
      if (localf != null) {
        localf.b(paramBoolean);
      }
      localObject = ((j)localObject).d;
      if (localObject != null) {
        ((f)localObject).b(paramBoolean);
      }
    }
  }
  
  public static boolean c(boolean paramBoolean)
  {
    j localj = g();
    if (localj == null) {
      com.tencent.beacon.a.g.a.d("[module] this module not ready!", new Object[0]);
    }
    while (!k()) {
      return false;
    }
    return localj.d(paramBoolean);
  }
  
  private void e(boolean paramBoolean)
  {
    try
    {
      if (paramBoolean != h())
      {
        f localf = this.c;
        if (localf != null) {
          localf.a(paramBoolean);
        }
        localf = this.d;
        if (localf != null) {
          localf.a(paramBoolean);
        }
        this.g = paramBoolean;
      }
      return;
    }
    finally {}
  }
  
  public static j g()
  {
    try
    {
      j localj = b;
      return localj;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static j j(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new j(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  private static boolean k()
  {
    Object localObject = g();
    if (localObject == null)
    {
      com.tencent.beacon.a.g.a.d("[module] this module not ready!", new Object[0]);
      return false;
    }
    boolean bool2 = ((j)localObject).h();
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = com.tencent.beacon.a.e.b.j(((j)localObject).a).p();
    }
    if (bool1)
    {
      localObject = d.a();
      if ((localObject != null) && (i != null) && (i.a() >= ((d)localObject).k()))
      {
        com.tencent.beacon.a.g.a.c("[strategy] reach daily consume limited! %d ", new Object[] { Integer.valueOf(((d)localObject).k()) });
        return false;
      }
    }
    return bool1;
  }
  
  private void l()
  {
    if (d.a().j())
    {
      str = com.tencent.beacon.a.a.c.a(this.a).a("LAUEVE_DENGTA", "");
      if (com.tencent.beacon.a.a.f().equals(str))
      {
        com.tencent.beacon.a.g.a.a("[event] AppLaunchedEvent has been uploaded!", new Object[0]);
        return;
      }
    }
    if (com.tencent.beacon.a.c.e.a(this.a) == null)
    {
      com.tencent.beacon.a.g.a.d("[event] DeviceInfo is null then return", new Object[0]);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("A33", com.tencent.beacon.a.c.e.i(this.a));
    localHashMap.put("A63", "Y");
    if (com.tencent.beacon.a.c.a.a(this.a))
    {
      localHashMap.put("A21", "Y");
      label124:
      if (!com.tencent.beacon.a.e.b.j(this.a).m()) {
        break label336;
      }
      localHashMap.put("A45", "Y");
      label150:
      if (!com.tencent.beacon.a.c.a.g(this.a)) {
        break label352;
      }
      localHashMap.put("A66", "F");
      label173:
      localHashMap.put("A68", com.tencent.beacon.a.c.a.h(this.a));
      if (!com.tencent.beacon.a.c.a.a) {
        break label368;
      }
    }
    label336:
    label352:
    label368:
    for (String str = "Y";; str = "N")
    {
      localHashMap.put("A85", str);
      localHashMap.put("A9", com.tencent.beacon.a.c.e.e());
      localHashMap.put("A14", com.tencent.beacon.a.c.e.f());
      localHashMap.put("A20", com.tencent.beacon.a.c.e.f(this.a));
      localHashMap.put("A69", com.tencent.beacon.a.c.e.g(this.a));
      if (!UserAction.onUserAction("rqd_applaunched", true, 0L, 0L, localHashMap, true)) {
        break;
      }
      com.tencent.beacon.a.a.c.a(this.a).a().a("LAUEVE_DENGTA", com.tencent.beacon.a.a.f()).b();
      return;
      localHashMap.put("A21", "N");
      break label124;
      localHashMap.put("A45", "N");
      break label150;
      localHashMap.put("A66", "B");
      break label173;
    }
  }
  
  private void m()
  {
    try
    {
      if ((this.e != null) && (this.e.size() > 0))
      {
        Iterator localIterator = this.e.iterator();
        while (localIterator.hasNext())
        {
          c localc = (c)localIterator.next();
          a(localc.a, localc.b, localc.c, localc.d, localc.e, localc.f, false);
        }
        this.e.clear();
      }
    }
    finally {}
  }
  
  public final void a(int paramInt, Map<String, String> paramMap)
  {
    super.a(paramInt, paramMap);
    if ((paramInt == 1) && (paramMap != null) && (paramMap.size() > 0) && (d.a() != null)) {
      d.a().a(paramMap);
    }
  }
  
  public final void a(com.tencent.beacon.a.e.a parama)
  {
    super.a(parama);
    if (parama != null)
    {
      parama = parama.b(1);
      if (parama != null)
      {
        boolean bool = parama.a();
        if (h() != bool)
        {
          com.tencent.beacon.a.g.a.f("[strategy] setEnable: %b", new Object[] { Boolean.valueOf(bool) });
          e(bool);
        }
      }
    }
  }
  
  public final void a(InitHandleListener paramInitHandleListener)
  {
    this.h = paramInitHandleListener;
  }
  
  public final void a(boolean paramBoolean)
  {
    if ((com.tencent.beacon.a.f.h.a(this.a) != null) && (paramBoolean != com.tencent.beacon.a.f.h.a(this.a).b()))
    {
      if (paramBoolean)
      {
        com.tencent.beacon.a.f.h.a(this.a).b(true);
        new e(this.a).b();
        l();
      }
    }
    else {
      return;
    }
    com.tencent.beacon.a.f.h.a(this.a).b(false);
    e.a(this.a);
  }
  
  public final void b(Context paramContext)
  {
    super.b(paramContext);
    Object localObject = com.tencent.beacon.a.e.b.j(this.a);
    if (localObject != null)
    {
      localObject = ((com.tencent.beacon.a.e.b)localObject).k().b(1);
      if ((localObject != null) && (((a.a)localObject).a() != true))
      {
        ((a.a)localObject).a(true);
        if (true != h()) {
          e(true);
        }
      }
    }
    new com.tencent.beacon.a.a.d().a(paramContext);
  }
  
  public final void b_()
  {
    com.tencent.beacon.a.g.a.e("[event] ua first clean :%d", new Object[] { Integer.valueOf(com.tencent.beacon.a.a.a.a.a(this.a, new int[] { 1, 2, 3, 4 })) });
    com.tencent.beacon.a.g.a.e("[event] ua remove strategy :%d", new Object[] { Integer.valueOf(a.a.b(this.a)) });
  }
  
  public final void c()
  {
    super.c();
    new e(this.a).b();
    l();
  }
  
  public final void c_()
  {
    super.c_();
    if (this.h != null) {
      this.h.onInitEnd();
    }
  }
  
  public final void d()
  {
    super.d();
    for (;;)
    {
      try
      {
        localObject = com.tencent.beacon.a.e.b.j(this.a).k();
        if (localObject != null) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        Set localSet;
        com.tencent.beacon.a.g.a.a(localThrowable);
        com.tencent.beacon.a.g.a.d("[event] common query end error %s", new Object[] { localThrowable.toString() });
        continue;
        int j = -1;
        continue;
        j = 0;
        continue;
        com.tencent.beacon.a.g.a.d("[event] module is disable", new Object[0]);
        continue;
        if (j <= 0) {
          continue;
        }
        j = 1;
        continue;
      }
      m();
      if (this.h != null) {
        this.h.onStrategyQuerySuccess();
      }
      return;
      localObject = ((com.tencent.beacon.a.e.a)localObject).b(1);
      if ((localObject != null) && (d.a() != null))
      {
        localSet = ((a.a)localObject).d();
        if ((localSet != null) && (localSet.size() > 0)) {
          d.a().a(localSet);
        }
        localSet = ((a.a)localObject).f();
        if ((localSet != null) && (localSet.size() > 0)) {
          d.a().b(localSet);
        }
      }
      if ((!h()) || (localObject == null)) {
        continue;
      }
      if (!h()) {
        continue;
      }
      j = com.tencent.beacon.a.a.c(this.a);
      continue;
      if (j != 0)
      {
        com.tencent.beacon.a.g.a.e("[event] asyn up module %d", new Object[] { Integer.valueOf(1) });
        com.tencent.beacon.a.a.b.a().a(new Runnable()
        {
          public final void run()
          {
            j.this.d(true);
          }
        });
      }
    }
  }
  
  public final boolean d(boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.f)
      {
        if (h())
        {
          j = com.tencent.beacon.a.a.c(this.a);
          if (j > 0) {
            try
            {
              if (com.tencent.beacon.a.f.h.a(this.a) != null)
              {
                b localb = new b(this.a);
                localb.a(paramBoolean);
                com.tencent.beacon.a.f.h.a(this.a).a(localb);
              }
              return true;
            }
            catch (Throwable localThrowable)
            {
              com.tencent.beacon.a.g.a.d("[event] up common error: %s", new Object[] { localThrowable.toString() });
              com.tencent.beacon.a.g.a.a(localThrowable);
            }
          }
          return false;
        }
      }
      int j = -1;
    }
  }
  
  public final boolean h()
  {
    try
    {
      boolean bool = this.g;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final f i()
  {
    return this.c;
  }
  
  public final f j()
  {
    return this.d;
  }
  
  public static abstract interface a
  {
    public abstract long a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.b.j
 * JD-Core Version:    0.7.0.1
 */