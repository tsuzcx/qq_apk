package com.tencent.luggage.wxa.fk;

import com.tencent.luggage.wxa.en.a.a;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;
import com.tencent.luggage.wxa.standalone_open_runtime.e;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/standalone_open_runtime/runtime/WxaGameProcessSharedPreloader;", "Lcom/tencent/luggage/standalone_ext/boost/IRuntimePreloader;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/service/WxaAppService;", "Lcom/tencent/luggage/wxa/standalone_open_runtime/WxaPageView;", "()V", "callbacks", "Ljava/util/LinkedList;", "Lcom/tencent/luggage/standalone_ext/boost/IRuntimePreloader$Callback;", "preloadedServices", "state", "Lcom/tencent/luggage/wxa/standalone_open_runtime/runtime/WxaGameProcessSharedPreloader$State;", "syncObj", "", "getPageView", "appID", "", "getServices", "peekService", "preload", "", "callback", "forcePreload", "", "preloaded", "shouldWaitPreloading", "State", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class c
  implements com.tencent.luggage.wxa.en.a<com.tencent.luggage.wxa.standalone_open_runtime.service.a, e>
{
  public static final c a = new c();
  private static volatile c.a b = c.a.a;
  private static final byte[] c = new byte[0];
  private static final LinkedList<a.a> d = new LinkedList();
  private static final LinkedList<com.tencent.luggage.wxa.standalone_open_runtime.service.a> e = new LinkedList();
  
  public void a(@Nullable a.a parama, boolean paramBoolean)
  {
    synchronized (c)
    {
      c.a locala = b;
      int i = d.a[locala.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            if (paramBoolean) {
              d.addLast(parama);
            }
          }
        }
        else {
          d.addLast(parama);
        }
        b = c.a.b;
        parama = Unit.INSTANCE;
        f.a.c((Runnable)c.b.a);
        return;
      }
      d.addLast(parama);
      return;
    }
  }
  
  public boolean a()
  {
    synchronized (c)
    {
      c.a locala1 = c.a.c;
      c.a locala2 = b;
      boolean bool;
      if (locala1 == locala2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public boolean a(@Nullable a.a parama)
  {
    if (parama != null) {
      synchronized (c)
      {
        if (b == c.a.b)
        {
          d.addLast(parama);
          return true;
        }
        parama = Unit.INSTANCE;
        return false;
      }
    }
    return false;
  }
  
  @Nullable
  public com.tencent.luggage.wxa.standalone_open_runtime.service.a c()
  {
    synchronized (c)
    {
      com.tencent.luggage.wxa.standalone_open_runtime.service.a locala = (com.tencent.luggage.wxa.standalone_open_runtime.service.a)e.peek();
      return locala;
    }
  }
  
  @Nullable
  public com.tencent.luggage.wxa.standalone_open_runtime.service.a c(@Nullable String arg1)
  {
    synchronized (c)
    {
      com.tencent.luggage.wxa.standalone_open_runtime.service.a locala = (com.tencent.luggage.wxa.standalone_open_runtime.service.a)e.poll();
      return locala;
    }
  }
  
  @Nullable
  public e d(@Nullable String paramString)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fk.c
 * JD-Core Version:    0.7.0.1
 */