package com.tencent.luggage.wxa.qq;

import android.text.TextUtils;
import com.tencent.luggage.wxa.hz.a;
import com.tencent.luggage.wxa.ig.e;
import com.tencent.luggage.wxa.qg.g;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.q;
import com.tencent.luggage.wxa.rt.i;

public class b
{
  public static String a()
  {
    return a.d();
  }
  
  public static String a(e parame)
  {
    if (parame.a == 6)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("6_");
      localStringBuilder.append(b(parame));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("0_");
    localStringBuilder.append(b(parame));
    return localStringBuilder.toString();
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("piece");
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("");
    localStringBuilder2.append(paramString.hashCode());
    localStringBuilder1.append(q.a(localStringBuilder2.toString()));
    return localStringBuilder1.toString();
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    i locali = new i(g.a(), "music");
    if (!locali.j()) {
      o.d("MicroMsg.Music.MusicFileUtil", "create file folder:%b for path:%s", new Object[] { Boolean.valueOf(locali.u()), locali.l() });
    }
    paramString = b(paramString, paramBoolean);
    locali = new i(locali, paramString);
    o.e("MicroMsg.Music.MusicFileUtil", "music name %s path %s", new Object[] { paramString, locali.m() });
    return locali.l();
  }
  
  private static String b(e parame)
  {
    if (TextUtils.isEmpty(parame.c)) {
      return "";
    }
    return q.a(parame.c);
  }
  
  public static String b(String paramString)
  {
    i locali = new i(g.a(), "music");
    if (!locali.j()) {
      locali.u();
    }
    paramString = a(paramString);
    locali = new i(locali, paramString);
    o.e("MicroMsg.Music.MusicFileUtil", "getMusicPieceFilePath music name %s path %s", new Object[] { paramString, locali.m() });
    return locali.l();
  }
  
  public static String b(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(paramString);
      localStringBuilder2.append("temp");
      localStringBuilder1.append(q.a(localStringBuilder2.toString()));
      localStringBuilder1.append("-wifi");
      return localStringBuilder1.toString();
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(paramString);
    localStringBuilder1.append("temp");
    return q.a(localStringBuilder1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qq.b
 * JD-Core Version:    0.7.0.1
 */