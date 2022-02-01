package com.tencent.luggage.wxa.dc;

import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.ob.b;
import com.tencent.luggage.wxa.ob.c;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.gu;
import java.util.Iterator;
import java.util.List;

public class s
  implements b
{
  public static final s a = new s();
  private b b = v.a;
  
  public <Resp extends gu> Resp a(String paramString1, @Nullable String paramString2, a parama, Class<Resp> paramClass)
  {
    Iterator localIterator = q.a().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.a(paramString1, paramString2, parama)) {
        return localc.a(paramString1, paramString2, parama, paramClass);
      }
    }
    return this.b.a(paramString1, paramString2, parama, paramClass);
  }
  
  public boolean a()
  {
    return this.b instanceof com.tencent.luggage.wxa.de.d;
  }
  
  public boolean a(b paramb)
  {
    if (paramb == null) {
      return false;
    }
    this.b = paramb;
    return true;
  }
  
  public <Resp extends gu> com.tencent.luggage.wxa.ro.d<Resp> b(String paramString1, @Nullable String paramString2, a parama, Class<Resp> paramClass)
  {
    Iterator localIterator = q.a().iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.a(paramString1, paramString2, parama)) {
        return localc.b(paramString1, paramString2, parama, paramClass);
      }
    }
    return this.b.b(paramString1, paramString2, parama, paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.s
 * JD-Core Version:    0.7.0.1
 */