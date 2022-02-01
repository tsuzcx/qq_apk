package com.tencent.luggage.wxa.iu;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function1;

final class w
  implements x
{
  private final ConcurrentSkipListSet<x> a = new ConcurrentSkipListSet(new w.1(this));
  private final AtomicBoolean b = new AtomicBoolean(false);
  
  private void a(@NonNull Function1<x, Void> paramFunction1)
  {
    Iterator localIterator = new LinkedList(this.a).iterator();
    while (localIterator.hasNext()) {
      paramFunction1.invoke((x)localIterator.next());
    }
  }
  
  public void a()
  {
    a(new w.2(this));
  }
  
  void b()
  {
    this.a.clear();
    this.b.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.w
 * JD-Core Version:    0.7.0.1
 */