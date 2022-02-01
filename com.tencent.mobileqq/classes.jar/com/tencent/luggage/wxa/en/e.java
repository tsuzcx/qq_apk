package com.tencent.luggage.wxa.en;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.xwalk.core.XWalkEnvironment;

public class e
{
  private static volatile boolean a = false;
  private static volatile boolean b = false;
  private static final Set<e.a> c = new HashSet();
  
  public static void a(e.a parama)
  {
    try
    {
      boolean bool1 = a;
      boolean bool2 = b;
      if (!bool2)
      {
        if (parama != null) {
          c.add(parama);
        }
        a = true;
        b = false;
      }
      if (bool1) {
        return;
      }
      if (bool2)
      {
        if (parama != null) {
          parama.a();
        }
        return;
      }
      parama = new e.1();
      s locals = new s("Luggage.XWebPreloader");
      locals.a(new e.2(parama, locals));
      return;
    }
    finally {}
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = b;
      return bool;
    }
    finally {}
  }
  
  public static boolean b()
  {
    boolean bool = WebView.isXWalk();
    int i = XWalkEnvironment.getAvailableVersion();
    int j = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
    o.d("Luggage.XWebPreloader", "reInitToXWeb, isXWalk:%b, xwLoadedVersion:%d, xwApkVersion:%d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
    if ((!bool) && (i <= 0) && (j > 0))
    {
      WebView.reinitToXWeb();
      return true;
    }
    return false;
  }
  
  private static void e()
  {
    try
    {
      b = true;
      a = false;
      Object localObject1 = new HashSet(c);
      c.clear();
      o.d("Luggage.XWebPreloader", "notifyPreloadDone, type:%s, callbacks[%d]", new Object[] { WebView.getCurWebType(), Integer.valueOf(((Set)localObject1).size()) });
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((e.a)((Iterator)localObject1).next()).a();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private static void f()
  {
    try
    {
      b = false;
      a = false;
      Object localObject1 = new HashSet(c);
      c.clear();
      localObject1 = ((Set)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        ((e.a)((Iterator)localObject1).next()).b();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.en.e
 * JD-Core Version:    0.7.0.1
 */