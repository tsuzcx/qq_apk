package com.tencent.luggage.wxa.qd;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;

class g$2
  implements e
{
  g$2(g paramg) {}
  
  public void a(String arg1)
  {
    j localj = g.a(this.a, ???);
    if (localj == null)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "onStart player is null");
      return;
    }
    g.a(this.a, ???, localj);
    synchronized (g.a(this.a))
    {
      g.a(this.a, false);
      t.b(g.b(this.a));
      return;
    }
  }
  
  public void b(String paramString)
  {
    j localj = g.a(this.a, paramString);
    if (localj == null)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "onPause player is null");
      return;
    }
    g.b(this.a, paramString, localj);
    g.c(this.a, paramString, localj);
    g.c(this.a);
    this.a.b(1800000);
  }
  
  public void c(String paramString)
  {
    j localj = g.a(this.a, paramString);
    if (localj == null)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "onStop player is null");
      return;
    }
    g.b(this.a, paramString, localj);
    g.c(this.a, paramString, localj);
    g.c(this.a);
    this.a.b(1800000);
    g.b(this.a, paramString);
    this.a.r(paramString);
  }
  
  public void d(String paramString)
  {
    j localj = g.a(this.a, paramString);
    if (localj == null)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "onComplete player is null");
      return;
    }
    g.b(this.a, paramString, localj);
    g.c(this.a, paramString, localj);
    g.c(this.a);
    this.a.b(1800000);
    g.b(this.a, paramString);
    this.a.r(paramString);
  }
  
  public void e(String paramString)
  {
    j localj = g.a(this.a, paramString);
    if (localj == null)
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "onError player is null");
      return;
    }
    g.b(this.a, paramString, localj);
    if (g.a(this.a, paramString, localj.N()))
    {
      o.b("MicroMsg.Audio.AudioPlayerMgr", "try to stop same url players and play again");
      g.d(this.a);
      this.a.a(paramString, null);
      return;
    }
    o.b("MicroMsg.Audio.AudioPlayerMgr", "not try to play again");
    g.c(this.a, paramString, localj);
    g.c(this.a);
    this.a.b(1800000);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.g.2
 * JD-Core Version:    0.7.0.1
 */