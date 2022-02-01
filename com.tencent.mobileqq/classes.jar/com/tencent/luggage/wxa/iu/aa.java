package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.pd.i;
import com.tencent.luggage.wxa.rm.a;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class aa
  implements i
{
  private final Set<a> a = new CopyOnWriteArraySet();
  
  public void a()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).a();
    }
    this.a.clear();
  }
  
  public final void a(a parama)
  {
    if (parama != null) {
      this.a.add(parama);
    }
  }
  
  public void b(a parama)
  {
    if (parama != null) {
      this.a.remove(parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.aa
 * JD-Core Version:    0.7.0.1
 */