package com.tencent.luggage.wxa.qg;

import android.text.TextUtils;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.p;
import java.util.ArrayList;
import java.util.Map;

public class g
{
  private static p<String, String> a = new p(20);
  private static p<String, Boolean> b = new p(20);
  private static p<String, Integer> c = new p(20);
  private static p<String, Integer> d = new p(20);
  private static p<String, Long> e = new p(20);
  private static p<String, String> f = new p(20);
  private static String g = null;
  private static int h = 0;
  
  public static int a(int paramInt)
  {
    int i = h;
    if (i != 0) {
      return i;
    }
    h = e.a(paramInt);
    o.d("MicroMsg.Music.PieceCacheHelper", "sRemovePlayingAudioPlayerGroupCount:%d", new Object[] { Integer.valueOf(h) });
    if (h == 0) {
      h = paramInt;
    }
    return h;
  }
  
  public static String a()
  {
    String str = g;
    if (str != null) {
      return str;
    }
    str = e.b();
    if (TextUtils.isEmpty(str))
    {
      o.d("MicroMsg.Music.PieceCacheHelper", "retAccPath:%s is invalid", new Object[] { str });
      return com.tencent.luggage.wxa.qq.b.a();
    }
    o.d("MicroMsg.Music.PieceCacheHelper", "getAccPath retAccPath:%s", new Object[] { str });
    g = str;
    return str;
  }
  
  public static void a(String paramString)
  {
    if (!TextUtils.isEmpty(b(paramString))) {
      return;
    }
    String str = e.b(paramString);
    if (!TextUtils.isEmpty(str))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(str);
      new f(localArrayList).a();
      a(paramString, str);
    }
  }
  
  public static void a(String paramString, int paramInt)
  {
    if (paramString != null) {
      c.a(paramString, Integer.valueOf(paramInt));
    }
  }
  
  public static void a(String paramString, long paramLong)
  {
    if (paramLong > 0L) {
      e.a(paramString, Long.valueOf(paramLong));
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      a.a(paramString1, paramString2);
    }
  }
  
  public static void a(String paramString, Map<String, String> paramMap)
  {
    if (paramMap != null) {
      c(paramString);
    }
  }
  
  public static void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {
      b.a(paramString, Boolean.valueOf(paramBoolean));
    }
  }
  
  public static String b(String paramString)
  {
    if (a.d(paramString)) {
      return (String)a.b(paramString);
    }
    return "";
  }
  
  public static void b(String paramString, int paramInt)
  {
    if (paramString != null) {
      d.a(paramString, Integer.valueOf(paramInt));
    }
  }
  
  public static void b(String paramString1, String paramString2)
  {
    String str = b(paramString1);
    if (TextUtils.isEmpty(str))
    {
      o.b("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
      return;
    }
    if (!TextUtils.isEmpty(e(paramString1))) {
      return;
    }
    o.d("MicroMsg.Music.PieceCacheHelper", "setMusicMIMEType url:%s mimeType:%s", new Object[] { paramString1, paramString2 });
    c(paramString1, paramString2);
    e.a(str, paramString2);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      f.a(paramString1, paramString2);
    }
  }
  
  public static boolean c(String paramString)
  {
    if (b.d(paramString)) {
      return ((Boolean)b.b(paramString)).booleanValue();
    }
    return false;
  }
  
  public static String d(String paramString)
  {
    paramString = b(paramString);
    if (TextUtils.isEmpty(paramString))
    {
      o.b("MicroMsg.Music.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
      return null;
    }
    return e.d(paramString);
  }
  
  public static String e(String paramString)
  {
    if (f.d(paramString)) {
      return (String)f.b(paramString);
    }
    return null;
  }
  
  public static long f(String paramString)
  {
    if (e.d(paramString)) {
      return ((Long)e.b(paramString)).longValue();
    }
    return -1L;
  }
  
  public static long g(String paramString)
  {
    return h.b(paramString);
  }
  
  public static void h(String paramString)
  {
    h.d(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qg.g
 * JD-Core Version:    0.7.0.1
 */