package com.tencent.map.sdk.a;

import java.util.Iterator;
import java.util.Map.Entry;

final class em$b
  implements Iterator<Map.Entry<K, V>>
{
  private em.c<K, V> b;
  
  private em$b(em.c<K, V> paramc)
  {
    Object localObject;
    this.b = localObject;
  }
  
  public final boolean hasNext()
  {
    return this.b != null;
  }
  
  public final void remove()
  {
    em localem = this.a;
    em.c localc = localem.a(this.b.a);
    Object localObject1;
    Object localObject2;
    if (localc != null)
    {
      localem.a -= 1;
      localc.getValue();
      if (localc == localem.c) {
        localem.c = em.c.g(localc);
      }
      if (localc == localem.d) {
        localem.d = em.c.h(localc);
      }
      localObject1 = em.c.h(localc);
      localObject2 = em.c.g(localc);
      if (localObject1 != null) {
        em.c.c((em.c)localObject1, (em.c)localObject2);
      }
      if (localObject2 != null) {
        em.c.e((em.c)localObject2, (em.c)localObject1);
      }
      if ((em.c.b(localc) == null) || (em.c.c(localc) == null)) {
        break label408;
      }
      if (localc != null) {
        break label214;
      }
      localObject1 = null;
      em.c.a(localc, em.c.a((em.c)localObject1));
      em.c.a(localc, em.c.f((em.c)localObject1));
    }
    for (;;)
    {
      if (em.c.b((em.c)localObject1) != null)
      {
        localObject2 = em.c.b((em.c)localObject1);
        label156:
        if (localObject2 == null) {
          break label324;
        }
        em.c.d((em.c)localObject2, em.c.d((em.c)localObject1));
        if (em.c.d((em.c)localObject1) != null) {
          break label289;
        }
        localem.b = ((em.c)localObject2);
        label182:
        em.c.a((em.c)localObject1, null);
        em.c.b((em.c)localObject1, null);
        em.c.d((em.c)localObject1, null);
        if (!em.c.e((em.c)localObject1)) {
          localem.a((em.c)localObject2);
        }
      }
      label214:
      do
      {
        return;
        if (em.c.c(localc) != null) {
          for (localObject2 = em.c.c(localc);; localObject2 = em.c.b((em.c)localObject2))
          {
            localObject1 = localObject2;
            if (em.c.b((em.c)localObject2) == null) {
              break;
            }
          }
        }
        localObject2 = em.c.d(localc);
        Object localObject3 = localc;
        for (;;)
        {
          localObject1 = localObject2;
          if (localObject2 == null) {
            break;
          }
          localObject1 = localObject2;
          if (localObject3 != em.c.c((em.c)localObject2)) {
            break;
          }
          localObject1 = em.c.d((em.c)localObject2);
          localObject3 = localObject2;
          localObject2 = localObject1;
        }
        localObject2 = em.c.c((em.c)localObject1);
        break label156;
        if (localObject1 == em.c.b(em.c.d((em.c)localObject1)))
        {
          em.c.a(em.c.d((em.c)localObject1), (em.c)localObject2);
          break label182;
        }
        em.c.b(em.c.d((em.c)localObject1), (em.c)localObject2);
        break label182;
        if (em.c.d((em.c)localObject1) == null)
        {
          localem.b = null;
          return;
        }
        if (!em.c.e((em.c)localObject1)) {
          localem.a((em.c)localObject1);
        }
      } while (em.c.d((em.c)localObject1) == null);
      label289:
      label324:
      if (localObject1 == em.c.b(em.c.d((em.c)localObject1))) {
        em.c.a(em.c.d((em.c)localObject1), null);
      }
      for (;;)
      {
        em.c.d((em.c)localObject1, null);
        return;
        if (localObject1 == em.c.c(em.c.d((em.c)localObject1))) {
          em.c.b(em.c.d((em.c)localObject1), null);
        }
      }
      label408:
      localObject1 = localc;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.em.b
 * JD-Core Version:    0.7.0.1
 */