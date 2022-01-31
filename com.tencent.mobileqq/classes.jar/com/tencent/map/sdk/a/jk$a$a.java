package com.tencent.map.sdk.a;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
      if (this.b == null) {
        throw new NoSuchElementException();
      }
    }
    finally
    {
      this.a.a();
    }
    Object localObject3 = this.d;
    this.c = this.b;
    this.b = a(this.b);
    if (this.b == null) {}
    for (Object localObject2 = null;; localObject2 = this.b.a)
    {
      this.d = localObject2;
      this.a.a();
      return localObject3;
    }
  }
  
  /* Error */
  public final void remove()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 20	com/tencent/map/sdk/a/jk$a$a:a	Lcom/tencent/map/sdk/a/jk$a;
    //   4: invokestatic 27	com/tencent/map/sdk/a/jk$a:a	(Lcom/tencent/map/sdk/a/jk$a;)V
    //   7: aload_0
    //   8: getfield 52	com/tencent/map/sdk/a/jk$a$a:c	Lcom/tencent/map/sdk/a/jk$a$b;
    //   11: astore 4
    //   13: aload_0
    //   14: aconst_null
    //   15: putfield 52	com/tencent/map/sdk/a/jk$a$a:c	Lcom/tencent/map/sdk/a/jk$a$b;
    //   18: aload_0
    //   19: getfield 20	com/tencent/map/sdk/a/jk$a$a:a	Lcom/tencent/map/sdk/a/jk$a;
    //   22: getfield 29	com/tencent/map/sdk/a/jk$a:c	Lcom/tencent/map/sdk/a/jk$a$b;
    //   25: astore_2
    //   26: aload_2
    //   27: getfield 33	com/tencent/map/sdk/a/jk$a$b:b	Lcom/tencent/map/sdk/a/jk$a$b;
    //   30: astore_1
    //   31: aload_1
    //   32: ifnull +50 -> 82
    //   35: aload_1
    //   36: aload 4
    //   38: if_acmpne +52 -> 90
    //   41: aload_0
    //   42: getfield 20	com/tencent/map/sdk/a/jk$a$a:a	Lcom/tencent/map/sdk/a/jk$a;
    //   45: astore_3
    //   46: aload_1
    //   47: aconst_null
    //   48: putfield 36	com/tencent/map/sdk/a/jk$a$b:a	Ljava/lang/Object;
    //   51: aload_2
    //   52: aload_1
    //   53: getfield 33	com/tencent/map/sdk/a/jk$a$b:b	Lcom/tencent/map/sdk/a/jk$a$b;
    //   56: putfield 33	com/tencent/map/sdk/a/jk$a$b:b	Lcom/tencent/map/sdk/a/jk$a$b;
    //   59: aload_3
    //   60: getfield 59	com/tencent/map/sdk/a/jk$a:b	Ljava/util/concurrent/atomic/AtomicInteger;
    //   63: invokevirtual 65	java/util/concurrent/atomic/AtomicInteger:getAndDecrement	()I
    //   66: aload_3
    //   67: getfield 68	com/tencent/map/sdk/a/jk$a:a	I
    //   70: if_icmpne +12 -> 82
    //   73: aload_3
    //   74: getfield 71	com/tencent/map/sdk/a/jk$a:d	Ljava/util/concurrent/locks/Condition;
    //   77: invokeinterface 76 1 0
    //   82: aload_0
    //   83: getfield 20	com/tencent/map/sdk/a/jk$a$a:a	Lcom/tencent/map/sdk/a/jk$a;
    //   86: invokevirtual 40	com/tencent/map/sdk/a/jk$a:a	()V
    //   89: return
    //   90: aload_1
    //   91: getfield 33	com/tencent/map/sdk/a/jk$a$b:b	Lcom/tencent/map/sdk/a/jk$a$b;
    //   94: astore_3
    //   95: aload_1
    //   96: astore_2
    //   97: aload_3
    //   98: astore_1
    //   99: goto -68 -> 31
    //   102: astore_1
    //   103: aload_0
    //   104: getfield 20	com/tencent/map/sdk/a/jk$a$a:a	Lcom/tencent/map/sdk/a/jk$a;
    //   107: invokevirtual 40	com/tencent/map/sdk/a/jk$a:a	()V
    //   110: aload_1
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	a
    //   30	69	1	localObject1	Object
    //   102	9	1	localObject2	Object
    //   25	72	2	localObject3	Object
    //   45	53	3	localObject4	Object
    //   11	26	4	localb	jk.a.b
    // Exception table:
    //   from	to	target	type
    //   7	31	102	finally
    //   41	82	102	finally
    //   90	95	102	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jk.a.a
 * JD-Core Version:    0.7.0.1
 */