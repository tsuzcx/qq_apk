package com.tencent.map.sdk.a;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map.Entry;
import java.util.Set;

public final class em<K extends Comparable<K>, V>
  extends AbstractMap<K, V>
  implements Serializable
{
  int a = 0;
  em.c<K, V> b;
  em.c<K, V> c;
  em.c<K, V> d;
  
  private static <K extends Comparable<K>, V> void a(em.c<K, V> paramc, boolean paramBoolean)
  {
    if (paramc != null) {
      em.c.a(paramc, paramBoolean);
    }
  }
  
  private V b(K paramK, V paramV)
  {
    em.c localc;
    for (Object localObject = this.b;; localObject = localc)
    {
      int i = paramK.compareTo(em.c.a((em.c)localObject));
      if (i < 0)
      {
        localc = em.c.b((em.c)localObject);
        if (localc != null) {
          continue;
        }
        this.a += 1;
        paramK = new em.c((em.c)localObject, this.d, paramK, paramV);
        if (i >= 0) {
          break label121;
        }
        em.c.a((em.c)localObject, paramK);
      }
      for (;;)
      {
        em.c.c(this.d, paramK);
        this.d = paramK;
        b(paramK);
        return null;
        if (i > 0)
        {
          localc = em.c.c((em.c)localObject);
          break;
        }
        paramK = ((em.c)localObject).getValue();
        ((em.c)localObject).setValue(paramV);
        return paramK;
        label121:
        if (i > 0) {
          em.c.b((em.c)localObject, paramK);
        }
      }
    }
  }
  
  private void b(em.c<K, V> paramc)
  {
    em.c.a(paramc, true);
    while ((paramc != null) && (paramc != this.b) && (em.c.e(em.c.d(paramc)) == true))
    {
      Object localObject;
      if (em.c.d(paramc) == e(c(c(paramc))))
      {
        localObject = f(c(c(paramc)));
        if (d((em.c)localObject) == true)
        {
          a(c(paramc), false);
          a((em.c)localObject, false);
          a(c(c(paramc)), true);
          paramc = c(c(paramc));
        }
        else
        {
          localObject = paramc;
          if (paramc == f(c(paramc)))
          {
            localObject = c(paramc);
            g((em.c)localObject);
          }
          a(c((em.c)localObject), false);
          a(c(c((em.c)localObject)), true);
          h(c(c((em.c)localObject)));
          paramc = (em.c<K, V>)localObject;
        }
      }
      else
      {
        localObject = e(c(c(paramc)));
        if (d((em.c)localObject) == true)
        {
          a(c(paramc), false);
          a((em.c)localObject, false);
          a(c(c(paramc)), true);
          paramc = c(c(paramc));
        }
        else
        {
          localObject = paramc;
          if (paramc == e(c(paramc)))
          {
            localObject = c(paramc);
            h((em.c)localObject);
          }
          a(c((em.c)localObject), false);
          a(c(c((em.c)localObject)), true);
          g(c(c((em.c)localObject)));
          paramc = (em.c<K, V>)localObject;
        }
      }
    }
    em.c.a(this.b, false);
  }
  
  private static <K extends Comparable<K>, V> em.c<K, V> c(em.c<K, V> paramc)
  {
    if (paramc != null) {
      return em.c.d(paramc);
    }
    return null;
  }
  
  private static <K extends Comparable<K>, V> boolean d(em.c<K, V> paramc)
  {
    if (paramc != null) {
      return em.c.e(paramc);
    }
    return false;
  }
  
  private static <K extends Comparable<K>, V> em.c<K, V> e(em.c<K, V> paramc)
  {
    if (paramc != null) {
      return em.c.b(paramc);
    }
    return null;
  }
  
  private static <K extends Comparable<K>, V> em.c<K, V> f(em.c<K, V> paramc)
  {
    if (paramc != null) {
      return em.c.c(paramc);
    }
    return null;
  }
  
  private void g(em.c<K, V> paramc)
  {
    em.c localc;
    if (paramc != null)
    {
      localc = em.c.c(paramc);
      em.c.b(paramc, em.c.b(localc));
      if (em.c.b(localc) != null) {
        em.c.d(em.c.b(localc), paramc);
      }
      em.c.d(localc, em.c.d(paramc));
      if (em.c.d(paramc) != null) {
        break label68;
      }
      this.b = localc;
    }
    for (;;)
    {
      em.c.a(localc, paramc);
      em.c.d(paramc, localc);
      return;
      label68:
      if (em.c.b(em.c.d(paramc)) == paramc) {
        em.c.a(em.c.d(paramc), localc);
      } else {
        em.c.b(em.c.d(paramc), localc);
      }
    }
  }
  
  private void h(em.c<K, V> paramc)
  {
    em.c localc;
    if (paramc != null)
    {
      localc = em.c.b(paramc);
      em.c.a(paramc, em.c.c(localc));
      if (em.c.c(localc) != null) {
        em.c.d(em.c.c(localc), paramc);
      }
      em.c.d(localc, em.c.d(paramc));
      if (em.c.d(paramc) != null) {
        break label68;
      }
      this.b = localc;
    }
    for (;;)
    {
      em.c.b(localc, paramc);
      em.c.d(paramc, localc);
      return;
      label68:
      if (em.c.c(em.c.d(paramc)) == paramc) {
        em.c.b(em.c.d(paramc), localc);
      } else {
        em.c.a(em.c.d(paramc), localc);
      }
    }
  }
  
  public final em.c<K, V> a(K paramK)
  {
    if (paramK != null)
    {
      em.c localc1 = this.b;
      while (localc1 != null)
      {
        int i = paramK.compareTo(em.c.a(localc1));
        if (i < 0)
        {
          localc1 = em.c.b(localc1);
        }
        else
        {
          localc2 = localc1;
          if (i <= 0) {
            break label54;
          }
          localc1 = em.c.c(localc1);
        }
      }
    }
    em.c localc2 = null;
    label54:
    return localc2;
  }
  
  public final V a(K paramK, V paramV)
  {
    eg.a(paramK);
    if (this.b == null)
    {
      this.b = new em.c(null, null, paramK, paramV);
      this.c = this.b;
      this.d = this.b;
      this.a += 1;
      return null;
    }
    return b(paramK, paramV);
  }
  
  final void a(em.c<K, V> paramc)
  {
    while ((paramc != this.b) && (!d(paramc)))
    {
      Object localObject2;
      Object localObject1;
      if (paramc == e(c(paramc)))
      {
        localObject2 = f(c(paramc));
        localObject1 = localObject2;
        if (d((em.c)localObject2) == true)
        {
          a((em.c)localObject2, false);
          a(c(paramc), true);
          g(c(paramc));
          localObject1 = f(c(paramc));
        }
        if ((!d(e((em.c)localObject1))) && (!d(f((em.c)localObject1))))
        {
          a((em.c)localObject1, true);
          paramc = c(paramc);
        }
        else
        {
          localObject2 = localObject1;
          if (!d(f((em.c)localObject1)))
          {
            a(e((em.c)localObject1), false);
            a((em.c)localObject1, true);
            h((em.c)localObject1);
            localObject2 = f(c(paramc));
          }
          a((em.c)localObject2, d(c(paramc)));
          a(c(paramc), false);
          a(f((em.c)localObject2), false);
          g(c(paramc));
          paramc = this.b;
        }
      }
      else
      {
        localObject2 = e(c(paramc));
        localObject1 = localObject2;
        if (d((em.c)localObject2) == true)
        {
          a((em.c)localObject2, false);
          a(c(paramc), true);
          h(c(paramc));
          localObject1 = e(c(paramc));
        }
        if ((!d(f((em.c)localObject1))) && (!d(e((em.c)localObject1))))
        {
          a((em.c)localObject1, true);
          paramc = c(paramc);
        }
        else
        {
          localObject2 = localObject1;
          if (!d(e((em.c)localObject1)))
          {
            a(f((em.c)localObject1), false);
            a((em.c)localObject1, true);
            g((em.c)localObject1);
            localObject2 = e(c(paramc));
          }
          a((em.c)localObject2, d(c(paramc)));
          a(c(paramc), false);
          a(e((em.c)localObject2), false);
          h(c(paramc));
          paramc = this.b;
        }
      }
    }
    a(paramc, false);
  }
  
  public final Set<Map.Entry<K, V>> entrySet()
  {
    return new em.a(this);
  }
  
  public final int size()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.em
 * JD-Core Version:    0.7.0.1
 */