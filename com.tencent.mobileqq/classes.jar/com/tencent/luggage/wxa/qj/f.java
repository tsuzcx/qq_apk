package com.tencent.luggage.wxa.qj;

import com.tencent.luggage.wxa.ig.e;
import com.tencent.luggage.wxa.qz.o;
import java.net.URL;
import java.util.List;

public abstract class f
  implements a
{
  protected c a;
  protected e b;
  
  public e a(List<e> paramList, int paramInt)
  {
    if ((paramList != null) && (paramList.size() != 0) && (paramInt < paramList.size()))
    {
      this.b = ((e)paramList.get(paramInt));
      o.d("MicroMsg.Music.MusicBaseLogic", "startPlayNewMusicList:%d", new Object[] { Integer.valueOf(paramInt) });
      return this.b;
    }
    o.d("MicroMsg.Music.MusicBaseLogic", "music wrapper list error");
    return null;
  }
  
  public String a(String paramString)
  {
    return paramString;
  }
  
  public void a()
  {
    c();
  }
  
  public void a(e parame, int paramInt) {}
  
  public void a(c paramc)
  {
    this.a = paramc;
  }
  
  public void a(List<e> paramList, boolean paramBoolean) {}
  
  public boolean a(int paramInt)
  {
    return true;
  }
  
  public boolean a(e parame)
  {
    this.b = parame;
    return true;
  }
  
  public e b()
  {
    return this.b;
  }
  
  public e b(e parame)
  {
    return parame;
  }
  
  public URL b(String paramString)
  {
    return new URL(paramString);
  }
  
  public e c(e parame)
  {
    return parame;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d(e parame)
  {
    this.b = parame;
  }
  
  public void e(e parame)
  {
    e locale = this.b;
    if ((locale != null) && (locale.a(parame)))
    {
      this.b.c(parame);
      return;
    }
    this.b = parame;
  }
  
  public void f(e parame) {}
  
  public void g(e parame) {}
  
  public void h(e parame) {}
  
  public void i(e parame) {}
  
  public void j(e parame) {}
  
  public void k(e parame) {}
  
  public void l(e parame) {}
  
  public void m(e parame) {}
  
  public void n(e parame) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qj.f
 * JD-Core Version:    0.7.0.1
 */