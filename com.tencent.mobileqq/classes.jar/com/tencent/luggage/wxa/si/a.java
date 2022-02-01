package com.tencent.luggage.wxa.si;

import com.tencent.luggage.wxa.rz.c;
import com.tencent.luggage.wxa.rz.c.a;
import com.tencent.luggage.wxa.rz.c.e;
import com.tencent.luggage.wxa.sj.i;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a
  implements d
{
  private final AtomicBoolean a = new AtomicBoolean(false);
  
  public <V> com.tencent.luggage.wxa.sj.d<V> a(i<V> parami)
  {
    if (!a())
    {
      if (!parami.isCancelled())
      {
        b().a(parami);
        return parami;
      }
      c.a locala = c.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(parami.a());
      localStringBuilder.append("#");
      localStringBuilder.append(parami.l());
      locala.b("[BasePool#input] task=%s pool=%s", localStringBuilder.toString(), new Object[] { c() });
    }
    else
    {
      c.a.a(parami.a(), parami.l(), c(), true);
    }
    return null;
  }
  
  public boolean a()
  {
    return this.a.get();
  }
  
  protected abstract a.a b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.si.a
 * JD-Core Version:    0.7.0.1
 */