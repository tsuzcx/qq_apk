package com.tencent.luggage.wxa.fk;

import com.tencent.luggage.wxa.standalone_open_runtime.service.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class c$b
  implements Runnable
{
  public static final b a = new b();
  
  public final void run()
  {
    Object localObject2 = a.c.a();
    ((a)localObject2).B();
    synchronized (c.a(c.a))
    {
      c.b(c.a).addLast(localObject2);
      localObject2 = new LinkedList((Collection)c.c(c.a));
      c.c(c.a).clear();
      c.a(c.a, c.a.c);
      Unit localUnit = Unit.INSTANCE;
      ??? = ((Iterable)localObject2).iterator();
      while (((Iterator)???).hasNext()) {
        ((com.tencent.luggage.wxa.en.a.a)((Iterator)???).next()).a();
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fk.c.b
 * JD-Core Version:    0.7.0.1
 */