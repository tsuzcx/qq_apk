package com.tencent.luggage.wxa.iu;

import androidx.annotation.NonNull;
import androidx.core.util.Consumer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentSkipListSet;

class v
  implements r
{
  private final ConcurrentSkipListSet<r> a = new ConcurrentSkipListSet(new v.1(this));
  
  private void a(@NonNull Consumer<r> paramConsumer)
  {
    Iterator localIterator = new LinkedList(this.a).iterator();
    while (localIterator.hasNext()) {
      paramConsumer.accept((r)localIterator.next());
    }
  }
  
  public void a()
  {
    a(new v.3(this));
  }
  
  public void a(@NonNull n paramn)
  {
    a(new v.2(this, paramn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.v
 * JD-Core Version:    0.7.0.1
 */