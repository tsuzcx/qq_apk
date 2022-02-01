package com.tencent.luggage.wxa.iu;

import com.tencent.luggage.wxa.hw.a;
import com.tencent.luggage.wxa.hw.d;
import com.tencent.luggage.wxa.hw.d.a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class k
  extends d
{
  private final Set<Class<? extends a>> a = Collections.newSetFromMap(new ConcurrentHashMap());
  private volatile d.a b;
  
  public k()
  {
    super.a(new k.1(this));
  }
  
  public void a()
  {
    Object localObject = new HashSet(this.a);
    this.a.clear();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      super.b((Class)((Iterator)localObject).next());
    }
  }
  
  public void a(d.a parama)
  {
    this.b = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.k
 * JD-Core Version:    0.7.0.1
 */