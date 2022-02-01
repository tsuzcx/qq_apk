package com.tencent.luggage.wxa.sh;

import com.tencent.luggage.wxa.sg.g;
import com.tencent.luggage.wxa.sg.g.a;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a
  implements b
{
  private static final HashMap<String, g.a> a = new HashMap();
  
  private void a(AtomicInteger paramAtomicInteger)
  {
    int i;
    do
    {
      i = paramAtomicInteger.get();
    } while (!paramAtomicInteger.compareAndSet(i, i + 1));
  }
  
  private void b(AtomicInteger paramAtomicInteger)
  {
    int i;
    do
    {
      i = paramAtomicInteger.get();
    } while (!paramAtomicInteger.compareAndSet(i, i - 1));
  }
  
  public g a(String paramString)
  {
    synchronized (a)
    {
      g.a locala2 = (g.a)a.get(paramString);
      g.a locala1 = locala2;
      if (locala2 == null)
      {
        locala1 = new g.a(paramString, new AtomicInteger());
        a.put(paramString, locala1);
      }
      return new g(locala1);
    }
  }
  
  public void a(g paramg)
  {
    b(paramg.a.c);
  }
  
  public void b(g paramg) {}
  
  public void d(g paramg)
  {
    a(paramg.a.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sh.a
 * JD-Core Version:    0.7.0.1
 */