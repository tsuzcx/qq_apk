package com.tencent.map.sdk.a;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class ol$b
  extends HandlerThread
{
  private boolean a;
  private boolean b;
  private Handler c;
  private ConcurrentLinkedQueue<ol.e> d = new ConcurrentLinkedQueue();
  private Set<ol.b.a> e = new HashSet();
  private Set<ol.b.a> f = new HashSet();
  
  public ol$b(String paramString)
  {
    super(paramString);
  }
  
  public final <T> ol.b.a<T> a(ol.c<T> paramc)
  {
    ol.e locale = (ol.e)this.d.poll();
    if (locale == null) {
      return null;
    }
    os.a locala = os.a("DispatchUtil");
    StringBuilder localStringBuilder = new StringBuilder("dispatchHandler:");
    localStringBuilder.append(this.c);
    localStringBuilder.toString();
    locala.a();
    paramc = new ol.b.a(this, this.c, paramc, locale);
    paramc.a(new ol.b.b(this, paramc));
    if (this.c == null) {
      this.f.add(paramc);
    }
    return paramc;
  }
  
  final void a(ol.e parame)
  {
    try
    {
      os.a locala = os.a("DispatchUtil");
      StringBuilder localStringBuilder = new StringBuilder("prepared:");
      localStringBuilder.append(this.a);
      localStringBuilder.toString();
      locala.a();
      if ((!this.a) && (!this.b))
      {
        start();
        this.b = true;
      }
      this.d.add(parame);
      return;
    }
    finally {}
  }
  
  protected final void onLooperPrepared()
  {
    super.onLooperPrepared();
    this.a = true;
    this.c = new ol.b.1(this, getLooper());
    os.a("DispatchUtil").a();
    if (!this.f.isEmpty())
    {
      os.a("DispatchUtil").a();
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        ol.b.a locala = (ol.b.a)localIterator.next();
        locala.g = this.c;
        os.a locala1 = os.a("DispatchUtil");
        StringBuilder localStringBuilder = new StringBuilder("to active:");
        localStringBuilder.append(locala.j);
        localStringBuilder.toString();
        locala1.a();
        if (!locala.j) {
          locala.b(locala.d);
        }
      }
      this.f.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.ol.b
 * JD-Core Version:    0.7.0.1
 */