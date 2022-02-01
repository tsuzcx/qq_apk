package com.tencent.luggage.wxa.gq;

import com.tencent.luggage.wxa.gw.b;
import java.util.LinkedList;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class k
{
  private static k a;
  private Object b = new Object();
  private ThreadPoolExecutor c;
  private PriorityBlockingQueue<Runnable> d = new PriorityBlockingQueue(33);
  private LinkedList<l> e = new LinkedList();
  private int f;
  
  private k()
  {
    int i = b();
    this.c = new ThreadPoolExecutor(i, 32, 120L, TimeUnit.SECONDS, this.d, new j());
    this.c.setMaximumPoolSize(32);
    b.b("MicroMsg.Mix.AudioThreadPool", "new AudioThreadPool poolSize:%d", new Object[] { Integer.valueOf(i) });
  }
  
  public static k a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new k();
        }
      }
      finally {}
    }
    return a;
  }
  
  public static void a(l paraml)
  {
    a().c(paraml);
  }
  
  private int b()
  {
    int i = Runtime.getRuntime().availableProcessors();
    b.b("MicroMsg.Mix.AudioThreadPool", "getNormalCorePoolSize cpuCount:%d", new Object[] { Integer.valueOf(i) });
    int j = i * 2 + 2;
    if (j > 32)
    {
      i = 32;
    }
    else
    {
      i = j;
      if (j < 8) {
        i = 8;
      }
    }
    this.f = i;
    return i;
  }
  
  public static void b(l paraml)
  {
    a().d(paraml);
  }
  
  private void c(l paraml)
  {
    synchronized (this.b)
    {
      paraml.b();
      this.e.add(paraml);
      int i = this.f;
      if (this.e.size() > i) {
        a(i + 2);
      }
      this.c.execute(paraml);
      return;
    }
  }
  
  private void d(l paraml)
  {
    synchronized (this.b)
    {
      this.e.remove(paraml);
      if (this.e.size() <= 4)
      {
        this.f = 4;
        a(this.f);
      }
      this.c.remove(paraml);
      return;
    }
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 32) {
      this.f = 32;
    } else if (paramInt < 4) {
      this.f = 4;
    } else {
      this.f = paramInt;
    }
    b.b("MicroMsg.Mix.AudioThreadPool", "setCorePoolSize poolSize:%d", new Object[] { Integer.valueOf(paramInt) });
    this.c.setCorePoolSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gq.k
 * JD-Core Version:    0.7.0.1
 */