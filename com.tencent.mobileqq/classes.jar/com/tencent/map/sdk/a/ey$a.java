package com.tencent.map.sdk.a;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class ey$a<T>
  extends ee<T>
{
  private final en<T> b;
  private final Map<String, ey.b> c;
  
  private ey$a(en<T> paramen, Map<String, ey.b> paramMap)
  {
    this.b = paramMap;
    Object localObject;
    this.c = localObject;
  }
  
  public final T a(fe paramfe)
  {
    if (paramfe.f() == ff.i)
    {
      paramfe.k();
      return null;
    }
    Object localObject1 = this.b.a();
    try
    {
      paramfe.c();
      while (paramfe.e())
      {
        Object localObject2 = paramfe.h();
        localObject2 = (ey.b)this.c.get(localObject2);
        if ((localObject2 != null) && (((ey.b)localObject2).i)) {
          ((ey.b)localObject2).a(paramfe, localObject1);
        } else {
          paramfe.o();
        }
      }
      paramfe.d();
      return localObject1;
    }
    catch (IllegalAccessException paramfe)
    {
      throw new AssertionError(paramfe);
    }
    catch (IllegalStateException paramfe)
    {
      paramfe = new eb(paramfe);
    }
    for (;;)
    {
      throw paramfe;
    }
  }
  
  public final void a(fg paramfg, T paramT)
  {
    if (paramT == null)
    {
      paramfg.e();
      return;
    }
    paramfg.c();
    try
    {
      Iterator localIterator = this.c.values().iterator();
      while (localIterator.hasNext())
      {
        ey.b localb = (ey.b)localIterator.next();
        if (localb.h)
        {
          paramfg.a(localb.g);
          localb.a(paramfg, paramT);
        }
      }
      paramfg.d();
      return;
    }
    catch (IllegalAccessException paramfg)
    {
      label84:
      break label84;
    }
    paramfg = new AssertionError();
    for (;;)
    {
      throw paramfg;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.ey.a
 * JD-Core Version:    0.7.0.1
 */