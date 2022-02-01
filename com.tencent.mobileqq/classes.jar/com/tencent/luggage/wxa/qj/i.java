package com.tencent.luggage.wxa.qj;

import com.tencent.luggage.wxa.ig.c;
import com.tencent.luggage.wxa.ig.e;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.List;

public class i
  extends g
{
  private static i b;
  a a = null;
  private com.tencent.luggage.wxa.qq.a c;
  
  private i(a parama)
  {
    this.a = parama;
  }
  
  public static void a(a parama)
  {
    try
    {
      if (b != null)
      {
        o.b("MicroMsg.Music.MusicPlayerManager", "music player mgr is init, don't it again");
        b.a = parama;
        parama.a(b);
        parama.a();
        return;
      }
      b = new i(parama);
      parama.a(b);
      parama.a();
      return;
    }
    finally {}
  }
  
  public static i f()
  {
    i locali = b;
    if (locali != null)
    {
      if (locali.a == null) {
        locali.a = new h();
      }
      return b;
    }
    throw new NullPointerException("must init MusicPlayerManager with your impl logic first!!!");
  }
  
  private void f(e parame)
  {
    com.tencent.luggage.wxa.qq.d.a(parame);
    if (this.a.a(parame))
    {
      a(parame);
      return;
    }
    o.b("MicroMsg.Music.MusicPlayerManager", "prepare is fail, not to play or wait for callback onStart");
  }
  
  public static boolean g()
  {
    return b != null;
  }
  
  public static com.tencent.luggage.wxa.qq.a h()
  {
    if (f().c == null) {
      f().c = new com.tencent.luggage.wxa.qq.a();
    }
    return f().c;
  }
  
  public static a i()
  {
    return f().a;
  }
  
  public com.tencent.luggage.wxa.ql.d a()
  {
    return super.a();
  }
  
  public void a(int paramInt)
  {
    super.a(paramInt);
  }
  
  public void a(List<e> paramList, int paramInt)
  {
    o.d("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusicList");
    Object localObject = d();
    paramList = this.a.a(paramList, paramInt);
    if ((localObject != null) && (paramList != null) && (af.b(((e)localObject).c, paramList.c)))
    {
      localObject = com.tencent.luggage.wxa.ig.a.g();
      if ((localObject != null) && ("play".equals(((c)localObject).b)))
      {
        b(paramList);
        return;
      }
    }
    f(paramList);
  }
  
  public void a(List<e> paramList, boolean paramBoolean)
  {
    this.a.a(paramList, paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }
  
  public void b(e parame)
  {
    super.b(parame);
    this.a.e(parame);
  }
  
  public void c()
  {
    super.c();
  }
  
  public void c(e parame)
  {
    if (parame == null)
    {
      o.d("MicroMsg.Music.MusicPlayerManager", "musicWrapper is null");
      return;
    }
    o.d("MicroMsg.Music.MusicPlayerManager", "startMusicInList");
    f(this.a.b(parame));
  }
  
  public e d()
  {
    return this.a.b();
  }
  
  public void d(e parame)
  {
    this.a.d(parame);
  }
  
  public void e(e parame)
  {
    if (parame != null) {
      o.d("MicroMsg.Music.MusicPlayerManager", "MusicType %d", new Object[] { Integer.valueOf(parame.a) });
    }
    o.d("MicroMsg.Music.MusicPlayerManager", "startPlayNewMusic");
    f(this.a.c(parame));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qj.i
 * JD-Core Version:    0.7.0.1
 */