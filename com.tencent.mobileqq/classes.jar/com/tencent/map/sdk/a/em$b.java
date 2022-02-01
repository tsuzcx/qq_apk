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
      Object localObject1 = em.c.h(localc);
      Object localObject2 = em.c.g(localc);
      if (localObject1 != null) {
        em.c.c((em.c)localObject1, (em.c)localObject2);
      }
      if (localObject2 != null) {
        em.c.e((em.c)localObject2, (em.c)localObject1);
      }
      localObject1 = localc;
      if (em.c.b(localc) != null)
      {
        localObject1 = localc;
        if (em.c.c(localc) != null)
        {
          if (localc == null)
          {
            localObject2 = null;
          }
          else
          {
            if (em.c.c(localc) != null) {
              for (localObject1 = em.c.c(localc);; localObject1 = em.c.b((em.c)localObject1))
              {
                localObject2 = localObject1;
                if (em.c.b((em.c)localObject1) == null) {
                  break;
                }
              }
            }
            localObject1 = em.c.d(localc);
            Object localObject3 = localc;
            for (;;)
            {
              localObject2 = localObject1;
              if (localObject1 == null) {
                break;
              }
              localObject2 = localObject1;
              if (localObject3 != em.c.c((em.c)localObject1)) {
                break;
              }
              localObject2 = em.c.d((em.c)localObject1);
              localObject3 = localObject1;
              localObject1 = localObject2;
            }
          }
          em.c.a(localc, em.c.a((em.c)localObject2));
          em.c.a(localc, em.c.f((em.c)localObject2));
          localObject1 = localObject2;
        }
      }
      if (em.c.b((em.c)localObject1) != null) {
        localObject2 = em.c.b((em.c)localObject1);
      } else {
        localObject2 = em.c.c((em.c)localObject1);
      }
      if (localObject2 != null)
      {
        em.c.d((em.c)localObject2, em.c.d((em.c)localObject1));
        if (em.c.d((em.c)localObject1) == null) {
          localem.b = ((em.c)localObject2);
        } else if (localObject1 == em.c.b(em.c.d((em.c)localObject1))) {
          em.c.a(em.c.d((em.c)localObject1), (em.c)localObject2);
        } else {
          em.c.b(em.c.d((em.c)localObject1), (em.c)localObject2);
        }
        em.c.a((em.c)localObject1, null);
        em.c.b((em.c)localObject1, null);
        em.c.d((em.c)localObject1, null);
        if (!em.c.e((em.c)localObject1)) {
          localem.a((em.c)localObject2);
        }
      }
      else
      {
        if (em.c.d((em.c)localObject1) == null)
        {
          localem.b = null;
          return;
        }
        if (!em.c.e((em.c)localObject1)) {
          localem.a((em.c)localObject1);
        }
        if (em.c.d((em.c)localObject1) != null)
        {
          if (localObject1 == em.c.b(em.c.d((em.c)localObject1))) {
            em.c.a(em.c.d((em.c)localObject1), null);
          } else if (localObject1 == em.c.c(em.c.d((em.c)localObject1))) {
            em.c.b(em.c.d((em.c)localObject1), null);
          }
          em.c.d((em.c)localObject1, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.em.b
 * JD-Core Version:    0.7.0.1
 */