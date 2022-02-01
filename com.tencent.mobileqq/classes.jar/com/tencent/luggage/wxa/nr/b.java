package com.tencent.luggage.wxa.nr;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ig.e;
import com.tencent.luggage.wxa.qy.c;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;

public class b
{
  public int a;
  public String b;
  public String c;
  private String d;
  private String e;
  private e f;
  private HashMap<String, c> g = new HashMap();
  
  public static b b()
  {
    return b.a.a();
  }
  
  public e a()
  {
    return this.f;
  }
  
  public void a(e parame)
  {
    this.f = parame;
  }
  
  public void a(c paramc, String paramString)
  {
    if (this.g.get(paramString) != null)
    {
      o.d("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", new Object[] { paramString });
      return;
    }
    com.tencent.luggage.wxa.qy.a.a.b(paramc);
    this.g.put(paramString, paramc);
  }
  
  public void a(String paramString)
  {
    this.e = paramString;
  }
  
  public void a(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    this.d = paramString1;
    this.a = paramInt;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (paramString2.equalsIgnoreCase("play"))
    {
      o.d("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", new Object[] { paramString1, this.d });
      return true;
    }
    if (paramString1.equalsIgnoreCase(this.d))
    {
      paramString1 = com.tencent.luggage.wxa.ig.a.f();
      if ((paramString1 != null) && (paramString1.c.equals(this.e))) {
        return true;
      }
    }
    return false;
  }
  
  public void b(String paramString)
  {
    this.d = paramString;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public void c(String paramString)
  {
    if (this.g.get(paramString) == null)
    {
      o.d("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", new Object[] { paramString });
      return;
    }
    com.tencent.luggage.wxa.qy.a.a.c((c)this.g.remove(paramString));
    this.g.remove(paramString);
  }
  
  public boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      o.b("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
      return false;
    }
    if (!paramString.equalsIgnoreCase(c()))
    {
      o.b("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
      return false;
    }
    if (TextUtils.isEmpty(this.e))
    {
      o.b("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
      return false;
    }
    paramString = com.tencent.luggage.wxa.ig.a.f();
    if (paramString == null)
    {
      o.b("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
      return false;
    }
    if (!this.e.equalsIgnoreCase(paramString.c))
    {
      o.b("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
      return false;
    }
    if (!com.tencent.luggage.wxa.ig.a.d())
    {
      o.d("MicroMsg.AppBrandMusicPlayerManager", "MusicHelper.isPlayingMusic FALSE");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nr.b
 * JD-Core Version:    0.7.0.1
 */