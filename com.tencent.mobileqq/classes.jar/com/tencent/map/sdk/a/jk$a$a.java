package com.tencent.map.sdk.a;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;

public final class jk$a$a
  implements Iterator<E>
{
  private jk.a<E>.b<E> b;
  private jk.a<E>.b<E> c;
  private E d;
  
  jk$a$a(jk.a parama)
  {
    jk.a.a(parama);
    try
    {
      this.b = parama.c.b;
      if (this.b != null) {
        this.d = this.b.a;
      }
      return;
    }
    finally
    {
      parama.a();
    }
  }
  
  private static jk.a<E>.b<E> a(jk.a<E>.b<E> parama)
  {
    jk.a.b localb;
    do
    {
      localb = parama.b;
      if (localb == null) {
        break;
      }
      parama = localb;
    } while (localb.a == null);
    return localb;
  }
  
  public final boolean hasNext()
  {
    return this.b != null;
  }
  
  public final E next()
  {
    jk.a.a(this.a);
    try
    {
      if (this.b != null)
      {
        Object localObject3 = this.d;
        this.c = this.b;
        this.b = a(this.b);
        Object localObject1;
        if (this.b == null) {
          localObject1 = null;
        } else {
          localObject1 = this.b.a;
        }
        this.d = localObject1;
        return localObject3;
      }
      throw new NoSuchElementException();
    }
    finally
    {
      this.a.a();
    }
  }
  
  public final void remove()
  {
    jk.a.a(this.a);
    try
    {
      jk.a.b localb2 = this.c;
      this.c = null;
      Object localObject1 = this.a.c;
      Object localObject3;
      jk.a.b localb1;
      do
      {
        localObject3 = localObject1;
        localb1 = localObject3.b;
        if (localb1 == null) {
          break;
        }
        localObject1 = localb1;
      } while (localb1 != localb2);
      localObject1 = this.a;
      localb1.a = null;
      localObject3.b = localb1.b;
      if (((jk.a)localObject1).b.getAndDecrement() == ((jk.a)localObject1).a) {
        ((jk.a)localObject1).d.signal();
      }
      this.a.a();
      return;
    }
    finally
    {
      this.a.a();
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.jk.a.a
 * JD-Core Version:    0.7.0.1
 */