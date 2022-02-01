package com.tencent.luggage.wxa.sb;

import android.content.Context;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.rz.c.a;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.sj.i;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class a
  implements c
{
  private com.tencent.luggage.wxa.rz.a a;
  private ConcurrentHashMap<String, a.a> b = null;
  private AtomicLong c = new AtomicLong(0L);
  private final d d;
  private volatile long e = 0L;
  
  public a(Context paramContext, com.tencent.luggage.wxa.rz.a parama)
  {
    if (parama.g == null) {
      paramContext = new b(paramContext);
    } else {
      paramContext = parama.g;
    }
    this.d = paramContext;
    this.a = parama;
    b();
  }
  
  private ConcurrentHashMap<String, a.a> a()
  {
    if (this.b == null) {
      try
      {
        if (this.b == null) {
          this.b = new ConcurrentHashMap();
        }
      }
      finally {}
    }
    return this.b;
  }
  
  private void a(ConcurrentHashMap<String, a.a> paramConcurrentHashMap)
  {
    try
    {
      int i = paramConcurrentHashMap.size();
      if (i <= 0) {
        return;
      }
      long l = SystemClock.uptimeMillis();
      try
      {
        this.d.a(paramConcurrentHashMap.values());
        c.a locala = com.tencent.luggage.wxa.rz.c.c;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[persistCache] successfully! size=");
        localStringBuilder.append(paramConcurrentHashMap.size());
        localStringBuilder.append(" cost:");
        localStringBuilder.append(SystemClock.uptimeMillis() - l);
        locala.a("Experience", localStringBuilder.toString(), new Object[0]);
        paramConcurrentHashMap.clear();
      }
      catch (Exception paramConcurrentHashMap)
      {
        com.tencent.luggage.wxa.rz.c.c.c("Experience", "%s", new Object[] { paramConcurrentHashMap.toString() });
      }
      return;
    }
    finally {}
  }
  
  private void b()
  {
    long l = SystemClock.uptimeMillis();
    this.d.a(this.a.d);
    StringBuilder localStringBuilder1 = new StringBuilder("[buildCache] successfully! ");
    localStringBuilder1.append('\n');
    StringBuilder localStringBuilder2 = new StringBuilder();
    Iterator localIterator = this.d.a().entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      String str = (String)((Map.Entry)localObject).getKey();
      localObject = (a.a)((Map.Entry)localObject).getValue();
      localStringBuilder2.append("# ");
      localStringBuilder2.append(str);
      localStringBuilder2.append('-');
      localStringBuilder2.append(((a.a)localObject).b());
      localStringBuilder2.append('\n');
      a().put(str, localObject);
      i += 1;
    }
    localStringBuilder1.append("# ");
    localStringBuilder1.append("size:");
    localStringBuilder1.append(i);
    localStringBuilder1.append(" cost:");
    localStringBuilder1.append(SystemClock.uptimeMillis() - l);
    localStringBuilder1.append("ms");
    localStringBuilder1.append('\n');
    localStringBuilder1.append(localStringBuilder2);
    com.tencent.luggage.wxa.rz.c.c.a("Experience", localStringBuilder1.toString(), new Object[0]);
  }
  
  public void a(i parami)
  {
    parami.e().b(parami.f());
  }
  
  public void a(i parami, long paramLong1, long paramLong2)
  {
    parami.e().a(parami.f());
    Object localObject = parami.h();
    a.b localb = new a.b(parami.a(), localObject[0], localObject[1], parami.b().c());
    localObject = (a.a)a().get(localb.a);
    parami = (i)localObject;
    if (localObject == null)
    {
      parami = new a.a(localb.a);
      a().put(localb.a, parami);
    }
    parami.a(localb);
    if ((this.c.incrementAndGet() >= 5000L) && (System.currentTimeMillis() - this.e >= 600000L)) {
      f.a.d(new a.1(this));
    }
  }
  
  public boolean a(@Nullable String paramString)
  {
    if (paramString == null) {
      return true;
    }
    paramString = (a.a)a().get(paramString);
    if (paramString == null) {
      return true;
    }
    return paramString.b() ^ true;
  }
  
  public void b(i parami)
  {
    parami.e().a(parami.f());
  }
  
  public void c(i parami)
  {
    com.tencent.luggage.wxa.sg.g localg = parami.f();
    parami.e().d(localg);
  }
  
  public void d(i parami)
  {
    parami.e().a(parami.f());
  }
  
  public void e(i parami)
  {
    parami.e().a(parami.f());
  }
  
  public void f(i parami) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sb.a
 * JD-Core Version:    0.7.0.1
 */