package com.tencent.luggage.wxa.mo;

import com.tencent.luggage.wxa.gx.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rt.k;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class b
  implements c
{
  private a a;
  private Set<c.b> b = new HashSet();
  
  private void f()
  {
    a locala = this.a;
    if (locala != null)
    {
      locala.a();
      this.a = null;
    }
  }
  
  private void g()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((c.b)localIterator.next()).a();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void h()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((c.b)localIterator.next()).b();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void i()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((c.b)localIterator.next()).c();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  private void j()
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext()) {
        ((c.b)localIterator.next()).d();
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
  
  public g a(String paramString)
  {
    if (af.c(paramString))
    {
      o.b("MicaoMsg.DefaultLuggageVoicePlayer", "filePath is null");
      return new g("filePath is null", new Object[0]);
    }
    if (!k.h(paramString))
    {
      o.b("MicaoMsg.DefaultLuggageVoicePlayer", "file is not exist");
      return new g("file is not exist", new Object[0]);
    }
    f();
    this.a = com.tencent.luggage.wxa.gx.b.a(paramString);
    this.a.a(new b.1(this));
    boolean bool = this.a.a(paramString);
    o.d("MicaoMsg.DefaultLuggageVoicePlayer", "play:%s isOk:%b", new Object[] { paramString, Boolean.valueOf(bool) });
    if (!bool)
    {
      o.d("MicaoMsg.DefaultLuggageVoicePlayer", "play fail");
      return new g("fail to start, may be already start", new Object[0]);
    }
    g();
    return g.c;
  }
  
  public void a() {}
  
  public void a(c.b paramb)
  {
    synchronized (this.b)
    {
      this.b.add(paramb);
      return;
    }
  }
  
  public void b() {}
  
  public void b(c.b paramb)
  {
    synchronized (this.b)
    {
      this.b.remove(paramb);
      return;
    }
  }
  
  public void c()
  {
    f();
  }
  
  public g d()
  {
    a locala = this.a;
    if (locala == null) {
      return new g("fail to pause, may be not start", new Object[0]);
    }
    boolean bool = locala.b();
    o.d("MicaoMsg.DefaultLuggageVoicePlayer", "pause isOk:%b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      o.d("MicaoMsg.DefaultLuggageVoicePlayer", "pause fail");
      return new g("fail to pause, may be not start", new Object[0]);
    }
    h();
    return g.c;
  }
  
  public g e()
  {
    a locala = this.a;
    if (locala == null) {
      return new g("fail to stop, may be not start", new Object[0]);
    }
    boolean bool = locala.c();
    o.d("MicaoMsg.DefaultLuggageVoicePlayer", "stop isOk:%b", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      o.d("MicaoMsg.DefaultLuggageVoicePlayer", "stop fail");
      return new g("fail to stop, may be not start", new Object[0]);
    }
    this.a.a(null);
    f();
    i();
    return g.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.mo.b
 * JD-Core Version:    0.7.0.1
 */