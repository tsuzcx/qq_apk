package com.tencent.luggage.wxa.hd;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class f
{
  private static volatile long a;
  private static final Map<Integer, f.a> b = new ConcurrentHashMap();
  private static final Map<Integer, f.a> c = new ConcurrentHashMap();
  private static final Map<Integer, f.a> d = new ConcurrentHashMap();
  private static final Map<Integer, f.a> e = new ConcurrentHashMap();
  @Nullable
  private static d f;
  
  public static f.a a(int paramInt, boolean paramBoolean, String paramString)
  {
    f.a locala = new f.a();
    locala.d = paramString;
    locala.b = paramBoolean;
    o.d("MicroMsg.MediaCodecProxyUtils", "insertMapWithMimeType, isEncode:[%b],mimeType:[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (paramString.contains("video/"))
    {
      if (paramBoolean)
      {
        d.put(Integer.valueOf(paramInt), locala);
        return locala;
      }
      e.put(Integer.valueOf(paramInt), locala);
      return locala;
    }
    if (paramString.contains("audio/"))
    {
      if (paramBoolean)
      {
        b.put(Integer.valueOf(paramInt), locala);
        return locala;
      }
      c.put(Integer.valueOf(paramInt), locala);
      return locala;
    }
    f.b.a(20);
    f.b.a(20, locala);
    return locala;
  }
  
  public static void a()
  {
    o.d("MicroMsg.MediaCodecProxyUtils", "codecCountCheck allsize:[%d], audioEncodeMap:[%d], audioDecodeMap:[%d], videoEncodeMap:[%d], videoDecodeMap:[%d]", new Object[] { Integer.valueOf(b.size() + c.size() + d.size() + e.size()), Integer.valueOf(b.size()), Integer.valueOf(c.size()), Integer.valueOf(d.size()), Integer.valueOf(e.size()) });
    a(c, 12);
    a(b, 13);
    a(e, 14);
    a(d, 15);
  }
  
  private static void a(Map<Integer, f.a> paramMap, int paramInt)
  {
    if (paramMap.size() >= 8)
    {
      o.d("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl type:[%d], map.size:[%d], process:[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramMap.size()), r.c() });
      if (a + 30000L >= System.currentTimeMillis()) {
        if (a == 0L)
        {
          o.e("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl first time");
        }
        else
        {
          o.e("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl report return, time diff is %s", new Object[] { Long.valueOf(System.currentTimeMillis() - a) });
          return;
        }
      }
      a = System.currentTimeMillis();
      o.e("MicroMsg.MediaCodecProxyUtils", "codecLeakCheckImpl start leak report, time:%s", new Object[] { Long.valueOf(a) });
      StringBuilder localStringBuilder1 = new StringBuilder();
      StringBuilder localStringBuilder2 = new StringBuilder();
      Object localObject = paramMap.keySet();
      long l1 = System.currentTimeMillis();
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        f.a locala = (f.a)paramMap.get((Integer)((Iterator)localObject).next());
        if (locala != null)
        {
          String str;
          if (locala.f != null) {
            str = locala.f.replace(",", ";");
          } else {
            str = "";
          }
          localStringBuilder1.append(locala.b);
          localStringBuilder1.append(";");
          localStringBuilder1.append(locala.d);
          localStringBuilder1.append(";");
          localStringBuilder1.append(locala.e);
          localStringBuilder1.append(";");
          localStringBuilder1.append(r.c());
          localStringBuilder1.append(";");
          localStringBuilder1.append(str);
          localStringBuilder1.append(";");
          localStringBuilder1.append(locala.c);
          localStringBuilder1.append("|");
          long l2 = l1 - locala.a;
          if (l2 > 600000L)
          {
            o.d("MicroMsg.MediaCodecProxyUtils", "codecCountCheckImpl diffTime:[%s] ", new Object[] { Long.valueOf(l2) });
            localStringBuilder2.append(l2);
            localStringBuilder2.append(";");
            localStringBuilder2.append(locala.b);
            localStringBuilder2.append(";");
            localStringBuilder2.append(locala.d);
            localStringBuilder2.append(";");
            localStringBuilder2.append(locala.e);
            localStringBuilder2.append(";");
            localStringBuilder2.append(r.c());
            localStringBuilder2.append(";");
            localStringBuilder2.append(str);
            localStringBuilder2.append(";");
            localStringBuilder2.append(locala.c);
            localStringBuilder2.append("|");
          }
        }
      }
      if (paramInt == 12)
      {
        f.b.a(12);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          f.b.a(192);
          if (r.h()) {
            f.b.a(192, localStringBuilder1.toString());
          }
        }
        if (r.h())
        {
          f.b.a(180);
          f.b.a(180, localStringBuilder1.toString());
          return;
        }
        if (g())
        {
          f.b.a(184);
          return;
        }
        f.b.a(188);
        return;
      }
      if (paramInt == 13)
      {
        f.b.a(13);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          f.b.a(193);
          if (r.h()) {
            f.b.a(193, localStringBuilder1.toString());
          }
        }
        if (r.h())
        {
          f.b.a(181);
          f.b.a(181, localStringBuilder1.toString());
          return;
        }
        if (g())
        {
          f.b.a(185);
          return;
        }
        f.b.a(189);
        return;
      }
      if (paramInt == 14)
      {
        f.b.a(14);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          f.b.a(194);
          if (r.h()) {
            f.b.a(194, localStringBuilder1.toString());
          }
        }
        if (r.h())
        {
          f.b.a(182);
          f.b.a(182, localStringBuilder1.toString());
          return;
        }
        if (g())
        {
          f.b.a(186);
          return;
        }
        f.b.a(190);
        return;
      }
      if (paramInt == 15)
      {
        f.b.a(15);
        if (!TextUtils.isEmpty(localStringBuilder2.toString()))
        {
          f.b.a(195);
          if (r.h()) {
            f.b.a(195, localStringBuilder1.toString());
          }
        }
        if (r.h())
        {
          f.b.a(183);
          f.b.a(183, localStringBuilder1.toString());
          return;
        }
        if (g())
        {
          f.b.a(187);
          return;
        }
        f.b.a(191);
      }
    }
  }
  
  public static void a(boolean paramBoolean, String paramString, f.a parama)
  {
    o.d("MicroMsg.MediaCodecProxyUtils", "isEncode:[%b], mimeType:[%s]", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    if (paramString.contains("video/"))
    {
      if (paramBoolean)
      {
        f.b.a(6);
        f.b.a(6, parama);
        return;
      }
      f.b.a(5);
      f.b.a(5, parama);
      return;
    }
    if (paramString.contains("audio/"))
    {
      if (paramBoolean)
      {
        f.b.a(4);
        f.b.a(4, parama);
        return;
      }
      f.b.a(3);
      f.b.a(3, parama);
    }
  }
  
  public static boolean a(int paramInt)
  {
    if (b.remove(Integer.valueOf(paramInt)) != null)
    {
      o.e("MicroMsg.MediaCodecProxyUtils", "removeMap audioEncodeMap success");
      return true;
    }
    if (c.remove(Integer.valueOf(paramInt)) != null)
    {
      o.e("MicroMsg.MediaCodecProxyUtils", "removeMap audioDecodeMap success");
      return true;
    }
    if (d.remove(Integer.valueOf(paramInt)) != null)
    {
      o.e("MicroMsg.MediaCodecProxyUtils", "removeMap videoEncodeMap success");
      return true;
    }
    if (e.remove(Integer.valueOf(paramInt)) != null)
    {
      o.e("MicroMsg.MediaCodecProxyUtils", "removeMap videoDecodeMap success");
      return true;
    }
    o.b("MicroMsg.MediaCodecProxyUtils", "removeMap fail");
    f.b.a(22);
    f.b.a(22, new f.a());
    return false;
  }
  
  public static boolean a(String paramString, f.a parama)
  {
    int k = MediaCodecList.getCodecCount();
    int i = 0;
    while (i < k)
    {
      MediaCodecInfo localMediaCodecInfo = MediaCodecList.getCodecInfoAt(i);
      String[] arrayOfString = localMediaCodecInfo.getSupportedTypes();
      int j = 0;
      while (j < arrayOfString.length)
      {
        if (TextUtils.equals(arrayOfString[j], paramString))
        {
          parama.e = localMediaCodecInfo.getName();
          return true;
        }
        j += 1;
      }
      i += 1;
    }
    o.b("MicroMsg.MediaCodecProxyUtils", "mimeTypeSupportCheck error, type unsupport:[%s]", new Object[] { paramString });
    f.b.a(23);
    f.b.a(23, parama);
    return false;
  }
  
  private static boolean g()
  {
    return r.c().contains(":appbrand");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.f
 * JD-Core Version:    0.7.0.1
 */