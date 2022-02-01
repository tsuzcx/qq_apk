package com.tencent.beacon.event;

import com.tencent.beacon.event.a.a;
import java.util.Iterator;
import java.util.Set;

class c
  implements Runnable
{
  c(d paramd) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    Iterator localIterator = d.a(this.a).iterator();
    while (localIterator.hasNext())
    {
      ((StringBuilder)localObject).append((Long)localIterator.next());
      ((StringBuilder)localObject).append(",");
    }
    localObject = ((StringBuilder)localObject).substring(0, ((StringBuilder)localObject).lastIndexOf(","));
    boolean bool = d.c(this.a).a(d.b(this.a), (String)localObject);
    com.tencent.beacon.base.util.c.a(d.d(this.a), 4, "delete: %s", new Object[] { Boolean.valueOf(bool) });
    d.e(this.a).a(d.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.event.c
 * JD-Core Version:    0.7.0.1
 */