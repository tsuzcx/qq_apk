package com.b.a.a;

import android.os.SystemClock;
import com.b.a.b.a;
import com.b.a.g;
import com.b.a.k;
import com.b.a.m;
import com.b.a.q;
import com.b.a.r;
import com.b.a.s;
import com.b.a.t;
import com.b.a.u;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class b
  implements g
{
  private static boolean a = u.a;
  private final f b;
  private c c;
  
  public b(f paramf)
  {
    this(paramf, new c(4096));
  }
  
  private b(f paramf, c paramc)
  {
    this.b = new a(paramf);
    this.c = paramc;
  }
  
  private static Map<String, String> a(Map<String, List<String>> paramMap)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localEntry.getKey() != null)
      {
        List localList = (List)localEntry.getValue();
        localTreeMap.put(localEntry.getKey(), localList.get(0));
      }
    }
    return localTreeMap;
  }
  
  private static void a(String paramString, m<?> paramm, t paramt)
  {
    q localq = paramm.o();
    int i = paramm.n();
    try
    {
      localq.a(paramt);
      paramm.a(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      return;
    }
    catch (t paramt)
    {
      paramm.a(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      throw paramt;
    }
  }
  
  private byte[] a(InputStream paramInputStream, int paramInt, m<?> paramm)
  {
    i locali = new i(this.c, paramInt);
    Object localObject = null;
    if (paramInputStream != null) {
      label155:
      try
      {
        arrayOfByte = this.c.a(1024);
        int i = 0;
        for (;;)
        {
          localObject = arrayOfByte;
          int j = paramInputStream.read(arrayOfByte);
          if (j == -1) {
            break;
          }
          localObject = arrayOfByte;
          locali.write(arrayOfByte, 0, j);
          j = i + j;
          i = j;
          if (paramInt != 0)
          {
            i = j;
            localObject = arrayOfByte;
            if ((paramm instanceof h))
            {
              localObject = arrayOfByte;
              i = j * 100 / paramInt;
              localObject = arrayOfByte;
              j.a().a(paramm.c(), i);
              i = j;
            }
          }
        }
        localObject = arrayOfByte;
        paramm = locali.toByteArray();
        if (paramInputStream == null) {}
      }
      finally
      {
        byte[] arrayOfByte;
      }
    }
    try
    {
      paramInputStream.close();
    }
    catch (IOException paramInputStream)
    {
      break label155;
    }
    u.a("Error occurred when closing InputStream", new Object[0]);
    this.c.a(arrayOfByte);
    locali.close();
    return paramm;
    throw new r();
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
    }
    catch (IOException paramInputStream)
    {
      label203:
      break label203;
    }
    u.a("Error occurred when closing InputStream", new Object[0]);
    this.c.a(localObject);
    locali.close();
    for (;;)
    {
      throw paramm;
    }
  }
  
  public final com.b.a.j a(m<?> paramm)
  {
    long l1 = SystemClock.elapsedRealtime();
    Object localObject4 = Collections.emptyMap();
    for (Object localObject6 = null;; localObject6 = "null")
    {
      try
      {
        Object localObject5;
        try
        {
          Object localObject1 = new HashMap();
          localObject3 = paramm.e();
          if (localObject3 != null)
          {
            if (((b.a)localObject3).b != null) {
              ((Map)localObject1).put("If-None-Match", ((b.a)localObject3).b);
            }
            if (((b.a)localObject3).d > 0L) {
              ((Map)localObject1).put("If-Modified-Since", d.a(((b.a)localObject3).d));
            }
          }
          e locale = this.b.a(paramm, (Map)localObject1);
          localObject3 = localObject4;
          localObject1 = localObject6;
          try
          {
            i = locale.a();
            localObject3 = localObject4;
            localObject1 = localObject6;
            Map localMap = a(locale.b());
            if (i == 304)
            {
              localObject3 = localMap;
              localObject1 = localObject6;
              localObject4 = paramm.e();
              if (localObject4 == null)
              {
                localObject3 = localMap;
                localObject1 = localObject6;
                return new com.b.a.j(304, null, localMap, true, SystemClock.elapsedRealtime() - l1);
              }
              localObject3 = localMap;
              localObject1 = localObject6;
              ((b.a)localObject4).g.putAll(localMap);
              localObject3 = localMap;
              localObject1 = localObject6;
              return new com.b.a.j(304, ((b.a)localObject4).a, ((b.a)localObject4).g, true, SystemClock.elapsedRealtime() - l1);
            }
            localObject3 = localMap;
            localObject1 = localObject6;
            localObject4 = locale.d();
            if (localObject4 != null)
            {
              localObject3 = localMap;
              localObject1 = localObject6;
              localObject4 = a((InputStream)localObject4, locale.c(), paramm);
              localObject1 = localObject4;
            }
            else
            {
              localObject3 = localMap;
              localObject1 = localObject6;
              localObject4 = new byte[0];
              localObject1 = localObject4;
            }
            localObject4 = localObject1;
            localObject3 = localMap;
            localObject1 = localObject4;
            long l2 = SystemClock.elapsedRealtime() - l1;
            localObject3 = localMap;
            localObject1 = localObject4;
            if ((a) || (l2 > 3000L))
            {
              if (localObject4 == null) {
                continue;
              }
              localObject3 = localMap;
              localObject1 = localObject4;
              localObject6 = Integer.valueOf(localObject4.length);
              localObject3 = localMap;
              localObject1 = localObject4;
              u.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramm, Long.valueOf(l2), localObject6, Integer.valueOf(i), Integer.valueOf(paramm.o().b()) });
            }
            if ((i >= 200) && (i <= 299))
            {
              localObject3 = localMap;
              localObject1 = localObject4;
              return new com.b.a.j(i, (byte[])localObject4, localMap, false, SystemClock.elapsedRealtime() - l1);
            }
            localObject3 = localMap;
            localObject1 = localObject4;
            throw new IOException();
          }
          catch (IOException localIOException2)
          {
            localObject6 = localObject1;
            localObject1 = localIOException2;
            localObject5 = locale;
          }
          if (localObject5 == null) {
            break label684;
          }
        }
        catch (IOException localIOException1)
        {
          localObject3 = localObject5;
          localObject5 = null;
          localObject6 = localObject5;
        }
        int i = localObject5.a();
        u.c("Unexpected response code %d for %s", new Object[] { Integer.valueOf(i), paramm.c() });
        if (localObject6 != null)
        {
          localObject2 = new com.b.a.j(i, (byte[])localObject6, (Map)localObject3, false, SystemClock.elapsedRealtime() - l1);
          if ((i != 401) && (i != 403))
          {
            if ((i >= 400) && (i <= 499)) {
              throw new com.b.a.d((com.b.a.j)localObject2);
            }
            if ((i >= 500) && (i <= 599)) {
              throw new r((com.b.a.j)localObject2);
            }
            throw new r((com.b.a.j)localObject2);
          }
          localObject2 = new com.b.a.a((com.b.a.j)localObject2);
          localObject3 = "auth";
        }
        else
        {
          localObject2 = new com.b.a.i();
          localObject3 = "network";
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Object localObject2;
        u.c("Unexpected response MalformedURLException", new Object[] { localMalformedURLException.getMessage() });
        localObject3 = new StringBuilder("Bad URL ");
        ((StringBuilder)localObject3).append(paramm.c());
        throw new RuntimeException(((StringBuilder)localObject3).toString(), localMalformedURLException);
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        label684:
        u.c("Unexpected response SocketTimeoutException", new Object[] { localSocketTimeoutException.getMessage() });
        s locals = new s();
        Object localObject3 = "socket";
        a((String)localObject3, paramm, locals);
      }
      throw new k((Throwable)localObject2);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */