package com.tencent.beacon.event;

import android.content.Context;
import android.os.Process;
import com.tencent.beacon.a.b.d.a;
import com.tencent.beacon.a.k;
import com.tencent.beacon.upload.InitHandleListener;
import com.tencent.beacon.upload.UploadHandleListener;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class o
  implements com.tencent.beacon.a.b.a, com.tencent.beacon.a.b.e, com.tencent.beacon.a.b.f
{
  private static o e = null;
  public g a = null;
  public final Context b;
  public a c = null;
  public com.tencent.beacon.c.b d = null;
  private j f = null;
  private j g = null;
  private boolean h = true;
  private boolean i = false;
  private com.tencent.beacon.upload.h j;
  private boolean k;
  private int l = 0;
  private InitHandleListener m = null;
  private List<e> n = null;
  private Object o = new Object();
  private Object p = new Object();
  
  private o(Context paramContext, com.tencent.beacon.upload.h paramh, UploadHandleListener paramUploadHandleListener, InitHandleListener paramInitHandleListener)
  {
    if (paramContext == null)
    {
      com.tencent.beacon.d.a.c(" the context is null! init UserActionRecord failed!", new Object[0]);
      this.b = null;
      return;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null) {}
    for (this.b = localContext;; this.b = paramContext)
    {
      if (com.tencent.beacon.a.d.m() == null) {
        com.tencent.beacon.a.d.a(this.b);
      }
      if (this.n == null) {
        this.n = Collections.synchronizedList(new ArrayList(5));
      }
      this.j = paramh;
      if (paramh != null) {
        paramh.a(paramUploadHandleListener);
      }
      paramUploadHandleListener = com.tencent.beacon.a.b.b.a(this.b);
      paramUploadHandleListener.a(this);
      paramUploadHandleListener.a(this);
      paramUploadHandleListener.a(this);
      paramUploadHandleListener.a(0, paramh);
      paramUploadHandleListener.a(1, paramh);
      this.a = new g();
      this.f = new b(paramContext);
      this.g = new l(paramContext);
      this.h = true;
      this.m = paramInitHandleListener;
      this.d = new com.tencent.beacon.c.b(this.b);
      new com.tencent.beacon.a.e().a(this.b);
      return;
    }
  }
  
  public static o a(Context paramContext, com.tencent.beacon.upload.h paramh, UploadHandleListener paramUploadHandleListener, InitHandleListener paramInitHandleListener)
  {
    try
    {
      if (e == null)
      {
        com.tencent.beacon.d.a.e(" create ua instance ", new Object[0]);
        e = new o(paramContext, paramh, paramUploadHandleListener, paramInitHandleListener);
      }
      com.tencent.beacon.d.a.e(" return ua instance ", new Object[0]);
      paramContext = e;
      return paramContext;
    }
    finally {}
  }
  
  public static com.tencent.beacon.upload.h a(Context paramContext, boolean paramBoolean)
  {
    try
    {
      paramContext = com.tencent.beacon.upload.i.a(paramContext, paramBoolean);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  private void a(int paramInt)
  {
    try
    {
      this.l = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    com.tencent.beacon.d.a.e(" onUA: %s,%b,%d,%d,%b,%b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
    o localo = d();
    if ((localo != null) && (!localo.o()))
    {
      if (localo.n != null) {
        localo.n.add(new e(paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2));
      }
      return true;
    }
    if (!k()) {
      return false;
    }
    if (localo.a.a(paramString))
    {
      com.tencent.beacon.d.a.c("onUserAction return false, because eventName:[%s] is not allowed in server strategy!", new Object[] { paramString });
      return false;
    }
    j localj;
    if ((!paramBoolean1) || ((paramBoolean1) && (localo.a.b(paramString)))) {
      if (paramBoolean2) {
        localj = localo.m();
      }
    }
    while (localj != null)
    {
      return localj.a(b.a(localo.b, paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3));
      localj = localo.l();
      continue;
      com.tencent.beacon.d.a.c("onUserAction return false, because eventName:[%s] is sampled by svr rate!", new Object[] { paramString });
      return false;
    }
    return false;
  }
  
  public static boolean a(String paramString, boolean paramBoolean, long paramLong, Map<String, String> paramMap)
  {
    return a(paramString, paramBoolean, paramLong, 0L, paramMap, true, false);
  }
  
  public static void c(boolean paramBoolean)
  {
    Object localObject = d();
    if (localObject != null)
    {
      j localj = ((o)localObject).l();
      if (localj != null) {
        localj.b(paramBoolean);
      }
      localObject = ((o)localObject).m();
      if (localObject != null) {
        ((j)localObject).b(paramBoolean);
      }
    }
  }
  
  public static o d()
  {
    try
    {
      o localo = e;
      return localo;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean d(boolean paramBoolean)
  {
    o localo = d();
    if (localo == null) {
      com.tencent.beacon.d.a.c(" ua module not ready!", new Object[0]);
    }
    while (!k()) {
      return false;
    }
    return localo.e(paramBoolean);
  }
  
  public static void e()
  {
    o localo = d();
    if ((localo != null) && (localo.b != null))
    {
      com.tencent.beacon.upload.i.a(localo.b, false);
      HashMap localHashMap = new HashMap();
      com.tencent.beacon.a.f.a(localo.b);
      localHashMap.put("A33", com.tencent.beacon.a.f.l(localo.b));
      a("rqd_appexited", true, 0L, 0L, localHashMap, false, false);
    }
    for (;;)
    {
      if (localo != null) {
        localo.f(false);
      }
      return;
      com.tencent.beacon.d.a.d("onAppExited:ua is null", new Object[0]);
    }
  }
  
  private void f(boolean paramBoolean)
  {
    synchronized (this.p)
    {
      if (paramBoolean != g())
      {
        j localj = l();
        if (localj != null) {
          localj.a(paramBoolean);
        }
        localj = m();
        if (localj != null) {
          localj.a(paramBoolean);
        }
        this.k = paramBoolean;
      }
      return;
    }
  }
  
  private static boolean k()
  {
    o localo = d();
    if (localo == null)
    {
      com.tencent.beacon.d.a.d("isModuleAble:not init ua", new Object[0]);
      return false;
    }
    boolean bool2 = localo.g();
    boolean bool1 = bool2;
    if (bool2)
    {
      bool1 = bool2;
      if (localo.n()) {
        bool1 = localo.o();
      }
    }
    if (bool1)
    {
      g localg = localo.a;
      if ((localg != null) && (com.tencent.beacon.a.h.f(localo.b).e >= localg.f()))
      {
        com.tencent.beacon.d.a.c(" reach daily consume limited! %d ", new Object[] { Integer.valueOf(localg.f()) });
        return false;
      }
    }
    return bool1;
  }
  
  private j l()
  {
    try
    {
      j localj = this.f;
      return localj;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private j m()
  {
    try
    {
      j localj = this.g;
      return localj;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean n()
  {
    try
    {
      boolean bool = this.h;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private boolean o()
  {
    try
    {
      boolean bool = this.i;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void p()
  {
    try
    {
      this.i = true;
      if ((com.tencent.beacon.a.b.b.a(this.b).a()) && (this.m != null)) {
        this.m.onStrategyQuerySuccess();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void q()
  {
    try
    {
      if ((this.n != null) && (this.n.size() > 0))
      {
        Iterator localIterator = this.n.iterator();
        while (localIterator.hasNext())
        {
          e locale = (e)localIterator.next();
          a(locale.a, locale.b, locale.c, locale.d, locale.e, locale.f, false);
        }
        this.n.clear();
      }
    }
    finally {}
  }
  
  private static boolean r()
  {
    try
    {
      int i1 = Process.myUid();
      Class localClass = Class.forName("android.net.TrafficStats");
      if (localClass != null)
      {
        long l1 = ((Long)localClass.getMethod("getUidRxBytes", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(i1) })).longValue();
        long l2 = ((Long)localClass.getMethod("getUidTxBytes", new Class[] { Integer.TYPE }).invoke(null, new Object[] { Integer.valueOf(i1) })).longValue();
        if ((l1 != -1L) && (l2 != -1L)) {
          return true;
        }
      }
    }
    catch (Exception localException) {}
    return false;
  }
  
  private void s()
  {
    try
    {
      if ((!g()) && (!this.a.j())) {
        return;
      }
      Object localObject = com.tencent.beacon.a.b.b.a(this.b);
      if (localObject != null)
      {
        localObject = ((com.tencent.beacon.a.b.b)localObject).e().b(1);
        if (localObject != null)
        {
          localObject = ((d.a)localObject).b();
          if ((localObject != null) && (!"".equals(((String)localObject).trim())))
          {
            new i(this.b).a(false);
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      com.tencent.beacon.d.a.c(" startHeart failed! " + localException.getMessage(), new Object[0]);
    }
  }
  
  private void t()
  {
    if (com.tencent.beacon.a.f.a(this.b) == null)
    {
      com.tencent.beacon.d.a.c(" DeviceInfo == null?,return", new Object[0]);
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("A33", com.tencent.beacon.a.f.l(this.b));
    localHashMap.put("A63", "Y");
    if (com.tencent.beacon.a.b.c(this.b))
    {
      localHashMap.put("A21", "Y");
      label81:
      if (!com.tencent.beacon.a.b.b.a(this.b).g()) {
        break label300;
      }
      localHashMap.put("A45", "Y");
      label107:
      if (!com.tencent.beacon.a.b.h(this.b)) {
        break label316;
      }
      localHashMap.put("A66", "F");
      label130:
      localHashMap.put("A68", com.tencent.beacon.a.b.i(this.b));
      if (!com.tencent.beacon.a.b.a) {
        break label332;
      }
    }
    label300:
    label316:
    label332:
    String str2;
    for (String str1 = "Y";; str2 = "N")
    {
      for (;;)
      {
        localHashMap.put("A85", str1);
        a("rqd_applaunched", true, 0L, 0L, localHashMap, true, false);
        try
        {
          if (!this.a.i()) {
            break;
          }
          int i1 = this.a.h();
          com.tencent.beacon.a.c.a().a(106, new h(this.b, i1), i1 * 1000, i1 * 1000);
          return;
        }
        catch (Exception localException)
        {
          com.tencent.beacon.d.a.c(" startAutoLaunchEvent failed! ", new Object[0]);
          com.tencent.beacon.d.a.b(" startAutoLaunchEvent failed! " + localException.getMessage(), new Object[0]);
          return;
        }
      }
      localHashMap.put("A21", "N");
      break label81;
      localHashMap.put("A45", "N");
      break label107;
      localHashMap.put("A66", "B");
      break label130;
    }
  }
  
  public final void a()
  {
    a(j() + 1);
  }
  
  public final void a(com.tencent.beacon.a.b.d paramd)
  {
    if (paramd != null)
    {
      paramd = paramd.b(1);
      if (paramd != null)
      {
        boolean bool = paramd.a();
        if (g() != bool)
        {
          com.tencent.beacon.d.a.f("UAR onCommonStrategyChange setUsable:%b ", new Object[] { Boolean.valueOf(bool) });
          f(bool);
        }
      }
    }
  }
  
  public final void a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() > 0) && (this.a != null)) {
      this.a.a(paramMap);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject = com.tencent.beacon.a.b.b.a(this.b);
    if (localObject != null)
    {
      localObject = ((com.tencent.beacon.a.b.b)localObject).e().b(1);
      if ((localObject != null) && (((d.a)localObject).a() != paramBoolean))
      {
        ((d.a)localObject).a(paramBoolean);
        if (paramBoolean != g()) {
          f(paramBoolean);
        }
      }
    }
  }
  
  public final void b()
  {
    p();
    this.d.a = this.a.s();
    for (;;)
    {
      try
      {
        localObject1 = com.tencent.beacon.a.b.b.a(this.b).e();
        if (localObject1 != null) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject1;
        Object localObject2;
        long l1;
        long l2;
        long l3;
        com.tencent.beacon.d.a.a(localThrowable);
        com.tencent.beacon.d.a.d(" common query end error %s", new Object[] { localThrowable.toString() });
        continue;
        i1 = -1;
        break label784;
        i1 = 0;
        continue;
        com.tencent.beacon.d.a.b("event module is disable", new Object[0]);
        continue;
      }
      q();
      if (j() < 2)
      {
        if (this.m != null) {
          this.m.onInitEnd();
        }
        if ((com.tencent.beacon.upload.i.a(this.b).a()) && (com.tencent.beacon.a.i.a(this.b).a("sig_1")))
        {
          com.tencent.beacon.d.a.e(" get lock %s do singleton!", new Object[] { "sig_1" });
          localObject1 = this.b;
          localObject2 = this.a;
          com.tencent.beacon.a.f.a("com.tencent.beacon.runinfo.AppRunInfoTask", "startAppRunMonitor", new Class[] { Context.class, Object.class }, new Object[] { localObject1, localObject2 });
          if (com.tencent.beacon.upload.i.a(this.b).b())
          {
            s();
            t();
            if (this.a.y())
            {
              localObject1 = com.tencent.beacon.a.h.b(this.b);
              if (localObject1 != null)
              {
                l1 = ((com.tencent.beacon.a.a.f)localObject1).d;
                l2 = ((com.tencent.beacon.a.a.f)localObject1).e;
                l3 = ((com.tencent.beacon.a.a.f)localObject1).e;
                localObject1 = new HashMap();
                com.tencent.beacon.a.f.a(this.b);
                ((HashMap)localObject1).put("A33", com.tencent.beacon.a.f.l(this.b));
                ((HashMap)localObject1).put("A64", String.valueOf(l1 + l2));
                ((HashMap)localObject1).put("A65", String.valueOf(l3));
                if (a("rqd_sdk_net_consumed", true, 0L, 0L, (Map)localObject1, true, false)) {
                  UserAction.clearSDKTotalConsume(this.b);
                }
              }
            }
          }
        }
      }
      try
      {
        localObject1 = com.tencent.beacon.a.b.b(this.b, "rqd_model", "");
        boolean bool = com.tencent.beacon.a.f.n().equals(localObject1);
        if (!bool) {
          break label726;
        }
      }
      catch (Exception localException1)
      {
        com.tencent.beacon.d.a.c(" save modelEvent upload flag failed! ", new Object[0]);
        continue;
        Runnable local3 = new Runnable()
        {
          public final void run()
          {
            if (com.tencent.beacon.a.d.m() == null)
            {
              com.tencent.beacon.d.a.c(" model even common info == null?,return", new Object[0]);
              return;
            }
            Object localObject = n.a(o.this.b);
            if (localObject == null)
            {
              com.tencent.beacon.d.a.c(" UADeviceInfo == null?,return", new Object[0]);
              return;
            }
            com.tencent.beacon.a.f.a(o.this.b);
            HashMap localHashMap = new HashMap();
            localHashMap.put("A9", ((n)localObject).k());
            localHashMap.put("A10", ((n)localObject).b());
            localHashMap.put("A11", ((n)localObject).h());
            localHashMap.put("A12", ((n)localObject).i());
            localHashMap.put("A13", ((n)localObject).j());
            localHashMap.put("A14", ((n)localObject).f());
            localHashMap.put("A15", ((n)localObject).g());
            localHashMap.put("A16", ((n)localObject).d());
            localHashMap.put("A17", ((n)localObject).c());
            localHashMap.put("A18", ((n)localObject).e());
            localHashMap.put("A20", com.tencent.beacon.a.f.f(o.this.b));
            localHashMap.put("A22", n.b(o.this.b));
            localHashMap.put("A30", com.tencent.beacon.a.f.h() + "m");
            localHashMap.put("A33", com.tencent.beacon.a.f.l(o.this.b));
            localHashMap.put("A52", ((n)localObject).l());
            localHashMap.put("A53", ((n)localObject).m());
            localHashMap.put("A54", ((n)localObject).n());
            localHashMap.put("A55", ((n)localObject).o());
            localHashMap.put("A56", ((n)localObject).p());
            localHashMap.put("A57", ((n)localObject).q());
            localHashMap.put("A58", ((n)localObject).r());
            StringBuilder localStringBuilder = new StringBuilder();
            Context localContext = o.this.b;
            localObject = "0";
            long l = com.tencent.beacon.a.f.i(localContext);
            if (l > 0L) {
              localObject = l / 1024L / 1024L;
            }
            localHashMap.put("A59", (String)localObject + "m");
            localHashMap.put("A69", com.tencent.beacon.a.f.g(o.this.b));
            localObject = com.tencent.beacon.a.f.a(new String[] { "/system/bin/sh", "-c", "getprop ro.build.fingerprint" });
            if ((localObject != null) && (((List)localObject).size() > 0)) {}
            for (localObject = (String)((List)localObject).get(0);; localObject = "")
            {
              localHashMap.put("A82", localObject);
              o.a("rqd_model", true, 0L, localHashMap);
              return;
            }
          }
        };
        com.tencent.beacon.a.c.a().a(local3, 50000L);
        try
        {
          com.tencent.beacon.a.b.a(this.b, "rqd_model", com.tencent.beacon.a.f.n());
        }
        catch (Exception localException2)
        {
          com.tencent.beacon.d.a.c(" save modelEvent upload flag failed! ", new Object[0]);
          com.tencent.beacon.d.a.a(localException2);
        }
        continue;
        if (i1 <= 0) {
          continue;
        }
        int i1 = 1;
        continue;
      }
      if ((this.a.o()) || (this.a.p()))
      {
        this.c = new a(this.b, this.a.o(), this.a.p(), this.a.q(), this.a.r());
        if (this.a.p()) {
          new k(this.b).a();
        }
      }
      if ((this.a.m()) && (r()))
      {
        localObject1 = new Runnable()
        {
          public final void run()
          {
            o.a(o.this);
          }
        };
        com.tencent.beacon.a.c.a().a((Runnable)localObject1, 50000L);
        i1 = this.a.n();
        if (i1 > 0)
        {
          localObject1 = new Runnable()
          {
            public final void run()
            {
              com.tencent.beacon.a.h.c(o.this.b);
            }
          };
          com.tencent.beacon.a.c.a().a(107, (Runnable)localObject1, 0L, i1 * 1000);
        }
      }
      this.a.k();
      return;
      localObject1 = ((com.tencent.beacon.a.b.d)localObject1).b(1);
      if ((localObject1 != null) && (this.a != null))
      {
        localObject2 = ((d.a)localObject1).d();
        if ((localObject2 != null) && (((Set)localObject2).size() > 0)) {
          this.a.a((Set)localObject2);
        }
        localObject2 = ((d.a)localObject1).f();
        if ((localObject2 != null) && (((Set)localObject2).size() > 0)) {
          this.a.b((Set)localObject2);
        }
      }
      if ((!g()) || (localObject1 == null)) {
        continue;
      }
      if (!g()) {
        continue;
      }
      i1 = com.tencent.beacon.a.f.q(this.b);
      break label784;
      if (i1 != 0)
      {
        com.tencent.beacon.d.a.e(" asyn up module %d", new Object[] { Integer.valueOf(1) });
        com.tencent.beacon.a.c.a().a(new Runnable()
        {
          public final void run()
          {
            o.this.e(true);
          }
        });
      }
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    if ((com.tencent.beacon.upload.i.a(this.b) != null) && (paramBoolean != com.tencent.beacon.upload.i.a(this.b).b()))
    {
      if (paramBoolean)
      {
        com.tencent.beacon.upload.i.a(this.b).a(true);
        s();
        t();
      }
    }
    else {
      return;
    }
    com.tencent.beacon.upload.i.a(this.b).a(false);
    Context localContext = this.b;
    com.tencent.beacon.a.c.a().a(108);
    com.tencent.beacon.a.b.a(localContext, "HEART_DENGTA", com.tencent.beacon.a.f.n());
    com.tencent.beacon.d.a.a("heartbeat uploaded sucess!", new Object[0]);
  }
  
  public final void c()
  {
    Context localContext = this.b;
    com.tencent.beacon.d.a.a(" RecordDAO.deleteRecords() start", new Object[0]);
    com.tencent.beacon.d.a.e(" ua first clean :%d", new Object[] { Integer.valueOf(com.tencent.beacon.a.a.a.a(localContext, new int[] { 1, 2, 3, 4 })) });
    com.tencent.beacon.d.a.e(" ua remove strategy :%d", new Object[] { Integer.valueOf(com.tencent.beacon.a.f.p(this.b)) });
  }
  
  public final boolean e(boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.o)
      {
        if (g())
        {
          i1 = com.tencent.beacon.a.f.q(this.b);
          if (i1 > 0) {
            try
            {
              if (this.j != null)
              {
                c localc = new c(this.b);
                localc.a(paramBoolean);
                this.j.a(localc);
              }
              return true;
            }
            catch (Throwable localThrowable)
            {
              com.tencent.beacon.d.a.c(" up common error: %s", new Object[] { localThrowable.toString() });
              com.tencent.beacon.d.a.a(localThrowable);
            }
          }
          return false;
        }
      }
      int i1 = -1;
    }
  }
  
  public final void f()
  {
    com.tencent.beacon.d.a.a(" closeUseInfoEvent start", new Object[0]);
    try
    {
      g localg = this.a;
      g.g();
      com.tencent.beacon.a.c.a().a(104);
      return;
    }
    catch (Exception localException)
    {
      com.tencent.beacon.d.a.d(" closeUseInfoEvent function error:" + localException.getMessage(), new Object[0]);
    }
  }
  
  public final boolean g()
  {
    synchronized (this.p)
    {
      boolean bool = this.k;
      return bool;
    }
  }
  
  public final com.tencent.beacon.upload.h h()
  {
    return this.j;
  }
  
  public final g i()
  {
    return this.a;
  }
  
  public final int j()
  {
    try
    {
      int i1 = this.l;
      return i1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.o
 * JD-Core Version:    0.7.0.1
 */