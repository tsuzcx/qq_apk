package com.tencent.luggage.wxa.gw;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.rt.i;
import java.util.ArrayList;
import java.util.Iterator;

public class a
{
  private static boolean a = false;
  
  public static i a()
  {
    i locali2 = i.a(r.a().getExternalCacheDir());
    i locali1 = locali2;
    if (locali2 == null) {
      locali1 = i.a(r.a().getCacheDir());
    }
    locali1 = new i(locali1, "MixAudio");
    locali1.u();
    return locali1;
  }
  
  public static String a(String paramString)
  {
    i locali = a();
    StringBuilder localStringBuilder1;
    if ((paramString.contains(".")) && (paramString.contains("/")) && (paramString.lastIndexOf(".") > paramString.lastIndexOf("/")))
    {
      paramString = paramString.substring(paramString.lastIndexOf("/") + 1, paramString.lastIndexOf("."));
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(paramString);
      localStringBuilder1.append("_convert.pcm");
      paramString = localStringBuilder1.toString();
    }
    else
    {
      localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("");
      localStringBuilder2.append(paramString.hashCode());
      localStringBuilder1.append(c.a(localStringBuilder2.toString()));
      localStringBuilder1.append("_convert.pcm");
      paramString = localStringBuilder1.toString();
    }
    return new i(locali, paramString).b();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    i locali = a();
    if ((paramString2.contains(".")) && (paramString2.contains("/")) && (paramString2.lastIndexOf(".") > paramString2.lastIndexOf("/")))
    {
      paramString2 = paramString2.substring(paramString2.lastIndexOf("/") + 1, paramString2.lastIndexOf("."));
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append(paramString2);
      localStringBuilder1.append("_cache.pcm");
      paramString2 = localStringBuilder1.toString();
    }
    else
    {
      localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("");
      localStringBuilder2.append(paramString2.hashCode());
      localStringBuilder1.append(c.a(localStringBuilder2.toString()));
      localStringBuilder1.append("_cache.pcm");
      paramString2 = localStringBuilder1.toString();
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append(locali.b());
    localStringBuilder1.append("/");
    localStringBuilder1.append(paramString1);
    locali = new i(localStringBuilder1.toString());
    if (!locali.j()) {
      locali.u();
    }
    b.b("MicroMsg.Mix.FileUtil", "path:%s, appId:%s", new Object[] { locali.b(), paramString1 });
    return new i(locali, paramString2).b();
  }
  
  public static void a(String paramString, ArrayList<String> paramArrayList)
  {
    if (paramArrayList.size() > 0)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        String str = a(paramString, (String)paramArrayList.next());
        i locali = new i(str);
        if (locali.j())
        {
          locali.w();
          b.b("MicroMsg.Mix.FileUtil", "delete pcm cache file, file:%s", new Object[] { str });
        }
      }
    }
  }
  
  public static boolean a(i parami)
  {
    return parami.q() >= 5000000L;
  }
  
  public static i b(String paramString)
  {
    paramString = new i(paramString);
    if (!paramString.j()) {
      try
      {
        paramString.v();
        return paramString;
      }
      catch (Exception localException)
      {
        b.a("MicroMsg.Mix.FileUtil", localException, "createNewFile", new Object[0]);
      }
    }
    return paramString;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    i locali = a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(locali.b());
    localStringBuilder.append("/");
    localStringBuilder.append(paramString1);
    locali = new i(localStringBuilder.toString());
    if (!locali.j()) {
      locali.u();
    }
    b.b("MicroMsg.Mix.FileUtil", "path:%s, appId:%s", new Object[] { locali.b(), paramString1 });
    return new i(locali, paramString2).b();
  }
  
  public static boolean b(i parami)
  {
    return parami.q() >= 2000000L;
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    i locali = new i(paramString);
    if (!locali.j()) {
      return false;
    }
    if (locali.n()) {
      return false;
    }
    if ((paramString.endsWith(".wav")) && (a(locali))) {
      return false;
    }
    return (paramString.endsWith(".wav")) || (!b(locali));
  }
  
  public static long d(String paramString)
  {
    paramString = new i(paramString);
    if (paramString.j()) {
      return paramString.q();
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gw.a
 * JD-Core Version:    0.7.0.1
 */