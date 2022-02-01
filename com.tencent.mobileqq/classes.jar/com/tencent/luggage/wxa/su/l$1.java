package com.tencent.luggage.wxa.su;

import android.os.AsyncTask;
import com.tencent.xweb.ae;
import com.tencent.xweb.internal.a.b;
import com.tencent.xweb.xwalk.p;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.a.a;
import com.tencent.xweb.xwalk.updater.a.c;
import com.tencent.xweb.xwalk.updater.a.d;
import com.tencent.xweb.xwalk.updater.a.e;
import com.tencent.xweb.xwalk.updater.c;
import com.tencent.xweb.xwalk.updater.j.b;
import com.tencent.xweb.xwalk.updater.j.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xwalk.core.Log;
import org.xwalk.core.NetworkUtil;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkLibraryLoader.DownloadListener;
import org.xwalk.core.XWalkLibraryLoader.HttpDownloadTask;
import org.xwalk.core.XWalkLibraryLoader.WXFileDownloaderTask;

class l$1
  implements com.tencent.xweb.xwalk.updater.b
{
  l$1(l paraml) {}
  
  private a.c a(a.e parame, int paramInt)
  {
    if ((parame != null) && (parame.i != null))
    {
      if (parame.i.length == 0) {
        return null;
      }
      parame = parame.i;
      int j = parame.length;
      int i = 0;
      while (i < j)
      {
        a.c localc = parame[i];
        if (localc.a == paramInt) {
          return localc;
        }
        i += 1;
      }
    }
    return null;
  }
  
  private a.e a(a.d paramd, String paramString, int paramInt, boolean paramBoolean)
  {
    if ((paramd != null) && (paramd.d != null) && (paramd.d.length != 0) && (paramString != null) && (!paramString.isEmpty()))
    {
      paramd = paramd.d;
      int j = paramd.length;
      int i = 0;
      while (i < j)
      {
        a.e locale = paramd[i];
        if ((paramString.equals(locale.r)) && (locale.a > paramInt) && (locale.c.a(paramBoolean))) {
          return locale;
        }
        i += 1;
      }
      return null;
    }
    Log.e("XWalkPluginUp", "findMatchedPluginInfo params error");
    return null;
  }
  
  public void a()
  {
    k.a(System.currentTimeMillis());
    com.tencent.xweb.util.h.G();
  }
  
  public void a(j.b paramb) {}
  
  public void a(j.c paramc)
  {
    com.tencent.xweb.util.h.H();
    a.d locald = com.tencent.xweb.xwalk.updater.a.b(paramc.b);
    if (locald == null)
    {
      XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "parse plugin config failed");
      com.tencent.xweb.util.h.J();
      l.a(this.a, 5, -6);
      return;
    }
    com.tencent.xweb.util.h.f(locald.c, false);
    com.tencent.xweb.b.b(locald.e, locald.c);
    p.a("plugin_update", 0);
    if ((locald.d != null) && (locald.d.length != 0))
    {
      HashMap localHashMap = new HashMap();
      paramc = h.b().iterator();
      while (paramc.hasNext())
      {
        g localg = (g)paramc.next();
        if (localg == null)
        {
          XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", "process plugin null");
        }
        else
        {
          Object localObject2 = a.a(localg.a());
          Object localObject1;
          if ((l.a(this.a)) && (!l.b(this.a).equals(localg.a())))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("set only update ");
            ((StringBuilder)localObject1).append(l.b(this.a));
            ((StringBuilder)localObject1).append(", skip ");
            ((StringBuilder)localObject1).append(localg.a());
            XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", ((StringBuilder)localObject1).toString());
          }
          else if ((ae.b()) && (!localg.C_()))
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("forbid download code, skip ");
            ((StringBuilder)localObject1).append(localg.a());
            XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", ((StringBuilder)localObject1).toString());
            ((Scheduler)localObject2).b(null);
          }
          else
          {
            int i = localg.a(true);
            if ((!l.a(this.a)) && (!localg.b()) && (i == -1))
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("not installed before, do not need download now, skip ");
              ((StringBuilder)localObject1).append(localg.a());
              XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", ((StringBuilder)localObject1).toString());
            }
            else
            {
              localObject1 = a(locald, localg.a(), i, l.a(this.a));
              if (localObject1 == null)
              {
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("no matched plugin version, skip ");
                ((StringBuilder)localObject1).append(localg.a());
                XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", ((StringBuilder)localObject1).toString());
                ((Scheduler)localObject2).b(null);
              }
              else
              {
                c localc = new c();
                localc.l = ((a.e)localObject1).a;
                localc.x = false;
                Object localObject3 = a((a.e)localObject1, i);
                if ((localObject3 != null) && (localg.g(((a.e)localObject1).b)))
                {
                  localc.h = ((a.c)localObject3).b;
                  localc.d = ((a.c)localObject3).c;
                  localc.y = localg.a(localc.l, true);
                  localc.q = ((a.c)localObject3).d;
                  localc.r = ((a.c)localObject3).e;
                  localc.f = true;
                  localc.u = ((a.e)localObject1).b;
                  localc.z = ((a.e)localObject1).o;
                  localc.A = ((a.e)localObject1).p;
                  localc.B = ((a.e)localObject1).q;
                }
                else
                {
                  localc.h = ((a.e)localObject1).d;
                  localc.d = ((a.e)localObject1).k;
                  localc.y = localg.a(localc.l, false);
                  localc.q = ((a.e)localObject1).l;
                  localc.r = ((a.e)localObject1).m;
                  localc.f = false;
                  localc.u = ((a.e)localObject1).b;
                  localc.z = ((a.e)localObject1).o;
                  localc.A = ((a.e)localObject1).p;
                  localc.B = ((a.e)localObject1).q;
                }
                if ((localc.y != null) && (!localc.y.isEmpty()))
                {
                  localc.k = Scheduler.a((a.a)localObject1, localg.a());
                  localc = ((Scheduler)localObject2).a(localc);
                  if ((!l.a(this.a)) && (!((Scheduler)localObject2).c(true))) {
                    continue;
                  }
                  com.tencent.xweb.util.h.a(903L, ((Scheduler)localObject2).b() + 160, 1L);
                  if ((!l.a(this.a)) && (!NetworkUtil.isNetworkAvailable()))
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("network is not available, skip ");
                    ((StringBuilder)localObject1).append(localg.a());
                    XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", ((StringBuilder)localObject1).toString());
                  }
                }
                for (;;)
                {
                  break;
                  if ((!l.a(this.a)) && (!localc.q) && (!NetworkUtil.isWifiAvailable()))
                  {
                    localObject1 = new StringBuilder();
                    ((StringBuilder)localObject1).append("can not use cellular, skip ");
                    ((StringBuilder)localObject1).append(localg.a());
                    XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", ((StringBuilder)localObject1).toString());
                  }
                  else
                  {
                    localObject2 = new l.b();
                    localObject3 = new l.c(this.a, localg, localc);
                    if (localc.f) {
                      i = 2;
                    } else {
                      i = 1;
                    }
                    Object localObject4 = new XWalkLibraryLoader.WXFileDownloaderTask(false, (XWalkLibraryLoader.DownloadListener)localObject3, localc.h, localc.y, i);
                    if ((localc.r) && (((XWalkLibraryLoader.WXFileDownloaderTask)localObject4).isValid()))
                    {
                      localObject3 = new StringBuilder();
                      ((StringBuilder)localObject3).append("use wx file downloader, plugin: ");
                      ((StringBuilder)localObject3).append(localg.a());
                      ((StringBuilder)localObject3).append(" isPatch: ");
                      ((StringBuilder)localObject3).append(localc.f);
                      XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", ((StringBuilder)localObject3).toString());
                      ((l.b)localObject2).a = ((AsyncTask)localObject4);
                      ((l.b)localObject2).b = 2;
                    }
                    else
                    {
                      localObject4 = new StringBuilder();
                      ((StringBuilder)localObject4).append("use default file downloader, plugin: ");
                      ((StringBuilder)localObject4).append(localg.a());
                      ((StringBuilder)localObject4).append(" isPatch: ");
                      ((StringBuilder)localObject4).append(localc.f);
                      XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", ((StringBuilder)localObject4).toString());
                      ((l.b)localObject2).a = new XWalkLibraryLoader.HttpDownloadTask(false, (XWalkLibraryLoader.DownloadListener)localObject3, localc.h, localc.y);
                      ((l.b)localObject2).b = 1;
                    }
                    localHashMap.put(localg.a(), localObject2);
                    if (localc.f)
                    {
                      localg.f(((a.e)localObject1).b);
                      break;
                      localObject1 = new StringBuilder();
                      ((StringBuilder)localObject1).append("download path is empty, skip ");
                      ((StringBuilder)localObject1).append(localg.a());
                      XWalkInitializer.addXWalkInitializeLog("XWalkPluginUp", ((StringBuilder)localObject1).toString());
                      ((Scheduler)localObject2).b(null);
                    }
                  }
                }
              }
            }
          }
        }
      }
      if (localHashMap.size() == 0)
      {
        XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "no available update, no task");
        l.a(this.a, 5, -8);
        return;
      }
      l.a(this.a, 3, localHashMap);
      return;
    }
    XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", "plugin config contains no plugin");
    l.a(this.a, 5, -7);
  }
  
  public void b(j.c paramc)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("plugin config download failed: ");
    localStringBuilder.append(paramc.c);
    XWalkEnvironment.addXWalkInitializeLog("XWalkPluginUp", localStringBuilder.toString());
    com.tencent.xweb.util.h.I();
    l.a(this.a, 5, -5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.su.l.1
 * JD-Core Version:    0.7.0.1
 */