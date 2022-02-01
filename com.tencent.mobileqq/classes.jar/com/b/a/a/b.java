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
    if (paramInputStream == null) {
      try
      {
        throw new r();
      }
      finally
      {
        if (paramInputStream == null) {}
      }
    }
    try
    {
      paramInputStream.close();
      this.c.a((byte[])localObject);
      locali.close();
      throw paramm;
      byte[] arrayOfByte = this.c.a(1024);
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
          localObject = arrayOfByte;
          i = j;
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
      if (paramInputStream != null) {}
      try
      {
        paramInputStream.close();
        this.c.a(arrayOfByte);
        locali.close();
        return paramm;
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          u.a("Error occurred when closing InputStream", new Object[0]);
        }
      }
    }
    catch (IOException paramInputStream)
    {
      for (;;)
      {
        u.a("Error occurred when closing InputStream", new Object[0]);
      }
    }
  }
  
  public final com.b.a.j a(m<?> paramm)
  {
    long l1 = SystemClock.elapsedRealtime();
    for (;;)
    {
      Map localMap = null;
      localObject6 = Collections.emptyMap();
      try
      {
        Object localObject1 = new HashMap();
        Object localObject4 = paramm.e();
        if (localObject4 != null)
        {
          if (((b.a)localObject4).b != null) {
            ((Map)localObject1).put("If-None-Match", ((b.a)localObject4).b);
          }
          if (((b.a)localObject4).d > 0L) {
            ((Map)localObject1).put("If-Modified-Since", d.a(((b.a)localObject4).d));
          }
        }
        localObject4 = this.b.a(paramm, (Map)localObject1);
        localObject1 = localObject6;
        try
        {
          i = ((e)localObject4).a();
          localObject1 = localObject6;
          localMap = a(((e)localObject4).b());
          if (i == 304)
          {
            localObject1 = localMap;
            localObject6 = paramm.e();
            if (localObject6 == null)
            {
              localObject1 = localMap;
              return new com.b.a.j(304, null, localMap, true, SystemClock.elapsedRealtime() - l1);
            }
            localObject1 = localMap;
            ((b.a)localObject6).g.putAll(localMap);
            localObject1 = localMap;
            return new com.b.a.j(304, ((b.a)localObject6).a, ((b.a)localObject6).g, true, SystemClock.elapsedRealtime() - l1);
          }
          localObject1 = localMap;
          localObject6 = ((e)localObject4).d();
          if (localObject6 != null)
          {
            localObject1 = localMap;
            localObject6 = a((InputStream)localObject6, ((e)localObject4).c(), paramm);
            localObject1 = localObject6;
          }
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            long l2;
            label335:
            Object localObject2;
            byte[] arrayOfByte = null;
            localObject6 = localIOException1;
            localObject5 = localIOException3;
          }
        }
        try
        {
          l2 = SystemClock.elapsedRealtime() - l1;
          if ((!a) && (l2 <= 3000L)) {
            break label705;
          }
          if (localObject1 == null) {
            break label396;
          }
          localObject6 = Integer.valueOf(localObject1.length);
          u.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramm, Long.valueOf(l2), localObject6, Integer.valueOf(i), Integer.valueOf(paramm.o().b()) });
        }
        catch (IOException localIOException2)
        {
          localObject6 = localObject5;
          localObject5 = localIOException2;
          Object localObject7 = localObject3;
          localObject3 = localIOException3;
          break label490;
          if (i < 200) {
            break label335;
          }
          if (i <= 299) {
            break label404;
          }
          break label335;
        }
        throw new IOException();
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        for (;;)
        {
          u.c("Unexpected response SocketTimeoutException", new Object[] { localSocketTimeoutException.getMessage() });
          a("socket", paramm, new s());
          break;
          localObject2 = localMap;
          localObject6 = new byte[0];
          localObject2 = localObject6;
          continue;
          localObject6 = "null";
        }
        localObject6 = new com.b.a.j(i, (byte[])localObject2, localMap, false, SystemClock.elapsedRealtime() - l1);
        return localObject6;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        u.c("Unexpected response MalformedURLException", new Object[] { localMalformedURLException.getMessage() });
        throw new RuntimeException("Bad URL " + paramm.c(), localMalformedURLException);
      }
      catch (IOException localIOException1)
      {
        label396:
        label404:
        arrayOfByte = null;
        localObject3 = localObject6;
        localObject6 = localMap;
        label490:
        if (localObject6 != null)
        {
          i = ((e)localObject6).a();
          u.c("Unexpected response code %d for %s", new Object[] { Integer.valueOf(i), paramm.c() });
          if (arrayOfByte == null) {
            break label651;
          }
          localObject3 = new com.b.a.j(i, arrayOfByte, (Map)localObject3, false, SystemClock.elapsedRealtime() - l1);
          if ((i == 401) || (i == 403)) {
            a("auth", paramm, new com.b.a.a((com.b.a.j)localObject3));
          }
        }
        else
        {
          throw new k(localIOException1);
        }
      }
      if ((i >= 400) && (i <= 499)) {
        throw new com.b.a.d((com.b.a.j)localObject3);
      }
      if ((i >= 500) && (i <= 599)) {
        throw new r((com.b.a.j)localObject3);
      }
      throw new r((com.b.a.j)localObject3);
      label651:
      a("network", paramm, new com.b.a.i());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */