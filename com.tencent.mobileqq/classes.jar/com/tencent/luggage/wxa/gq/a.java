package com.tencent.luggage.wxa.gq;

import android.text.TextUtils;
import com.tencent.luggage.wxa.gn.f;
import com.tencent.luggage.wxa.gv.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class a
{
  private com.tencent.luggage.wxa.gt.d a;
  private HashMap<String, b> b = new HashMap();
  private HashMap<String, com.tencent.luggage.wxa.if.b> c = new HashMap();
  private List<String> d = new ArrayList();
  private LinkedList<String> e = new LinkedList();
  private Object f = new Object();
  
  public a(com.tencent.luggage.wxa.gt.d paramd)
  {
    this.a = paramd;
    a();
  }
  
  private boolean a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "doDecodeAudio");
    if (this.a == null)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecodeMgr", "mPlayer is null!");
      return false;
    }
    Object localObject2 = (com.tencent.luggage.wxa.if.b)this.c.get(paramString);
    if (localObject2 == null)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", new Object[] { paramString });
      return false;
    }
    Object localObject1 = (b)this.b.get(paramString);
    if (localObject1 != null)
    {
      if ((((b)localObject1).a()) && (!this.a.b().i()) && (!this.a.b().j(paramString)))
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
        return true;
      }
      if (((b)localObject1).a())
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "task is end, reset source and decoder to run");
        ((b)localObject1).b();
        paramString = new com.tencent.luggage.wxa.gv.a((com.tencent.luggage.wxa.if.b)localObject2);
        ((b)localObject1).a(h.a(this.a, paramString, 1, paramBoolean2));
        k.a((l)localObject1);
        return true;
      }
      n localn = ((b)localObject1).d();
      if ((localn != null) && (paramBoolean1))
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "force decode to stop and create new task to run");
        localn.f();
      }
      else
      {
        if ((localn != null) && (localn.i()) && (!localn.j()))
        {
          com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "resume decoder to run");
          localn.c();
          return true;
        }
        if ((localn != null) && (localn.j()))
        {
          com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "decoder to stop, reset task run");
          ((b)localObject1).b();
          paramString = new com.tencent.luggage.wxa.gv.a((com.tencent.luggage.wxa.if.b)localObject2);
          ((b)localObject1).a(h.a(this.a, paramString, 1, paramBoolean2));
          k.a((l)localObject1);
          return true;
        }
        if (localn != null)
        {
          com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "task is run and playing audio");
          return true;
        }
      }
    }
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "task is not exist, create new task to run");
    localObject1 = new com.tencent.luggage.wxa.gv.a((com.tencent.luggage.wxa.if.b)localObject2);
    localObject1 = h.a(this.a, (c)localObject1, 1, paramBoolean2);
    localObject2 = new b(new a.1(this), paramString, 5);
    ((b)localObject2).a((n)localObject1);
    k.a((l)localObject2);
    this.b.put(paramString, localObject2);
    return true;
  }
  
  public void a()
  {
    f.c().d();
  }
  
  public void a(com.tencent.luggage.wxa.if.b paramb)
  {
    this.c.put(paramb.a, paramb);
  }
  
  public boolean a(String paramString)
  {
    synchronized (this.f)
    {
      boolean bool = this.d.contains(paramString);
      return bool;
    }
  }
  
  public boolean a(String paramString, int paramInt)
  {
    if (!b(paramString, paramInt)) {
      return false;
    }
    b(paramString, paramInt);
    paramString = (b)this.b.get(paramString);
    if (paramString == null)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      return false;
    }
    if (paramString.a())
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      return false;
    }
    if (paramString.e())
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      return false;
    }
    paramString = paramString.d();
    if (paramString != null) {
      paramString.a(paramInt);
    }
    return true;
  }
  
  public void b()
  {
    this.b.clear();
    this.e.clear();
    this.c.clear();
  }
  
  public void b(com.tencent.luggage.wxa.if.b paramb)
  {
    if (this.c.containsKey(paramb.a)) {
      this.c.put(paramb.a, paramb);
    }
  }
  
  public void b(String paramString)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "startDecode audioId:%s", new Object[] { paramString });
    a(paramString, false, false);
  }
  
  public boolean b(String paramString, int paramInt)
  {
    com.tencent.luggage.wxa.if.b localb = (com.tencent.luggage.wxa.if.b)this.c.get(paramString);
    if (localb == null)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecodeMgr", "param for id %s is not exist!", new Object[] { paramString });
      return false;
    }
    localb.d = paramInt;
    return true;
  }
  
  public void c()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "pauseAllOnBackground");
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (b)this.b.get(localObject);
      if ((localObject != null) && (!((b)localObject).a()) && (!((b)localObject).e()))
      {
        localObject = ((b)localObject).d();
        if ((localObject != null) && (!((n)localObject).i())) {
          ((n)localObject).e();
        }
      }
    }
  }
  
  public void c(com.tencent.luggage.wxa.if.b paramb)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "prepareDecode");
    if (paramb == null)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecodeMgr", "param is null");
      return;
    }
    if (TextUtils.isEmpty(paramb.a))
    {
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "audioId is empty!");
      return;
    }
    if (!this.e.contains(paramb.a))
    {
      this.e.add(paramb.a);
      this.c.put(paramb.a, paramb);
      bool = false;
    }
    else
    {
      if (((com.tencent.luggage.wxa.if.b)this.c.get(paramb.a)).a(paramb))
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "is same param");
        bool = false;
      }
      else
      {
        com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "force to decode");
        bool = true;
      }
      this.c.put(paramb.a, paramb);
    }
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "ids:%d, id2ParamMap:%d", new Object[] { Integer.valueOf(this.e.size()), Integer.valueOf(this.c.size()) });
    if (paramb.B)
    {
      bool = a(paramb.a, bool, true);
      localObject = this.f;
      if (bool) {}
      try
      {
        if (!this.d.contains(paramb.c)) {
          this.d.add(paramb.c);
        }
        return;
      }
      finally {}
    }
    if (paramb.g)
    {
      a(paramb.a, bool, false);
      return;
    }
    boolean bool = a(paramb.a, bool, true);
    Object localObject = this.f;
    if (bool) {}
    try
    {
      if (!this.d.contains(paramb.c)) {
        this.d.add(paramb.c);
      }
      return;
    }
    finally {}
  }
  
  public void c(String paramString)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "pauseDecode audioId:%s", new Object[] { paramString });
    paramString = (b)this.b.get(paramString);
    if (paramString == null)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      return;
    }
    if (paramString.a())
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      return;
    }
    if (paramString.e())
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      return;
    }
    paramString = paramString.d();
    if (paramString != null) {
      paramString.d();
    }
  }
  
  public void d(String paramString)
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "stopDecode audioId:%s", new Object[] { paramString });
    b localb = (b)this.b.get(paramString);
    if (localb == null)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      return;
    }
    if (localb.a())
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      return;
    }
    n localn = localb.d();
    if (localn != null)
    {
      localn.f();
      localb.c();
      this.b.remove(paramString);
    }
  }
  
  public void e(String paramString)
  {
    if ((this.b.containsKey(paramString)) && (this.e.contains(paramString))) {
      d(paramString);
    }
    this.c.remove(paramString);
    this.e.remove(paramString);
  }
  
  public boolean f(String paramString)
  {
    paramString = (b)this.b.get(paramString);
    if (paramString == null) {
      return true;
    }
    if (paramString.a()) {
      return true;
    }
    return paramString.e();
  }
  
  public boolean g(String paramString)
  {
    b localb = (b)this.b.get(paramString);
    if ((localb != null) && (localb.a()) && (!this.a.b().i()) && (!this.a.b().j(paramString)))
    {
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioDecodeMgr", "task is end, but not to play end");
      return true;
    }
    return false;
  }
  
  public long h(String paramString)
  {
    paramString = (b)this.b.get(paramString);
    long l = -1L;
    if (paramString == null) {
      return -1L;
    }
    paramString = paramString.d();
    if (paramString != null) {
      l = paramString.z();
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gq.a
 * JD-Core Version:    0.7.0.1
 */