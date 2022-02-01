package com.tencent.luggage.wxa.na;

import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iz.b;
import com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j;
import java.util.HashSet;
import java.util.Set;

public class e
  extends b
{
  private boolean a = true;
  private com.tencent.luggage.wxa.fy.o b;
  private Set<com.tencent.luggage.wxa.fy.o> c = new HashSet();
  
  private void a(d paramd, int paramInt)
  {
    a locala = new a();
    locala.a.a = paramd.aa();
    locala.a.b = 4;
    locala.a.c = paramInt;
    com.tencent.luggage.wxa.qy.a.a.a(locala);
  }
  
  public void a(com.tencent.luggage.wxa.fy.o paramo)
  {
    if (paramo != null)
    {
      this.b = paramo;
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePusher:%s", new Object[] { paramo.b() });
    }
  }
  
  public void a(d paramd, com.tencent.luggage.wxa.fy.o paramo)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushBegin, runtime:%s, LivePusher:%s", new Object[] { paramd.aa(), paramo.b() });
    a(paramd, 1);
  }
  
  public void a(d paramd, boolean paramBoolean)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "enableMic, enable:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    boolean bool = this.a;
    this.a = paramBoolean;
    if (bool != paramBoolean) {
      a(paramd, 1);
    }
  }
  
  public boolean a()
  {
    return (this.b != null) && (!this.c.isEmpty());
  }
  
  public boolean a(com.tencent.luggage.wxa.fy.o paramo, int paramInt)
  {
    if ((a()) && (paramInt != 3)) {
      if ((paramo instanceof j))
      {
        if (this.b == paramo)
        {
          bool = true;
          break label55;
        }
      }
      else if ((paramo instanceof com.tencent.luggage.wxa.ga.a))
      {
        bool = this.c.contains(paramo);
        break label55;
      }
    }
    boolean bool = false;
    label55:
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "shouldInterceptEnterBackground, result:%s, isVOIPing:%s, type:%s", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(a()), Integer.valueOf(paramInt) });
    return bool;
  }
  
  public void b(com.tencent.luggage.wxa.fy.o paramo)
  {
    if (this.b == paramo)
    {
      this.b = null;
      com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePusher:%s", new Object[] { paramo.b() });
    }
  }
  
  public void b(d paramd, com.tencent.luggage.wxa.fy.o paramo)
  {
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "onPushEnd, runtime:%s, LivePusher:%s", new Object[] { paramd.aa(), paramo.b() });
    a(paramd, 2);
  }
  
  public void c(com.tencent.luggage.wxa.fy.o paramo)
  {
    this.c.add(paramo);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "registerLivePlayer:%s", new Object[] { paramo.b() });
  }
  
  public void d(com.tencent.luggage.wxa.fy.o paramo)
  {
    this.c.remove(paramo);
    com.tencent.luggage.wxa.qz.o.d("MicroMsg.AppBrandRuntimeLiveVOIPStateManager", "unregisterLivePlayer:%s", new Object[] { paramo.b() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.na.e
 * JD-Core Version:    0.7.0.1
 */