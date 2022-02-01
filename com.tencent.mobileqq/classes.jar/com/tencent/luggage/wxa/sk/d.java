package com.tencent.luggage.wxa.sk;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class d
  implements Handler.Callback
{
  private Handler a = com.tencent.luggage.wxa.se.d.a("SerialQueueLeader", this);
  private AtomicBoolean b = new AtomicBoolean(false);
  private final d.d c;
  private boolean d = false;
  private HashSet<e> e = new HashSet();
  private LinkedList<e> f = new LinkedList();
  private final LinkedList<d.c> g = new LinkedList();
  private d.c[] h;
  
  d(@NonNull d.d paramd)
  {
    this.c = paramd;
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 60	com/tencent/luggage/wxa/sk/d:g	Ljava/util/LinkedList;
    //   6: invokevirtual 68	java/util/LinkedList:size	()I
    //   9: istore_2
    //   10: iload_2
    //   11: ifle +36 -> 47
    //   14: aload_0
    //   15: getfield 70	com/tencent/luggage/wxa/sk/d:h	[Lcom/tencent/luggage/wxa/sk/d$c;
    //   18: ifnonnull +11 -> 29
    //   21: aload_0
    //   22: iload_2
    //   23: anewarray 72	com/tencent/luggage/wxa/sk/d$c
    //   26: putfield 70	com/tencent/luggage/wxa/sk/d:h	[Lcom/tencent/luggage/wxa/sk/d$c;
    //   29: aload_0
    //   30: aload_0
    //   31: getfield 60	com/tencent/luggage/wxa/sk/d:g	Ljava/util/LinkedList;
    //   34: aload_0
    //   35: getfield 70	com/tencent/luggage/wxa/sk/d:h	[Lcom/tencent/luggage/wxa/sk/d$c;
    //   38: invokevirtual 76	java/util/LinkedList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   41: checkcast 77	[Lcom/tencent/luggage/wxa/sk/d$c;
    //   44: putfield 70	com/tencent/luggage/wxa/sk/d:h	[Lcom/tencent/luggage/wxa/sk/d$c;
    //   47: aload_0
    //   48: monitorexit
    //   49: iconst_0
    //   50: istore_1
    //   51: iload_1
    //   52: iload_2
    //   53: if_icmpge +89 -> 142
    //   56: aload_0
    //   57: getfield 70	com/tencent/luggage/wxa/sk/d:h	[Lcom/tencent/luggage/wxa/sk/d$c;
    //   60: astore 5
    //   62: aload 5
    //   64: iload_1
    //   65: aaload
    //   66: astore 4
    //   68: aload 5
    //   70: iload_1
    //   71: aconst_null
    //   72: aastore
    //   73: aload 4
    //   75: invokeinterface 81 1 0
    //   80: istore_3
    //   81: iload_3
    //   82: ifne +27 -> 109
    //   85: aload_0
    //   86: monitorenter
    //   87: aload_0
    //   88: getfield 60	com/tencent/luggage/wxa/sk/d:g	Ljava/util/LinkedList;
    //   91: aload 4
    //   93: invokevirtual 85	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   96: pop
    //   97: aload_0
    //   98: monitorexit
    //   99: goto +10 -> 109
    //   102: astore 4
    //   104: aload_0
    //   105: monitorexit
    //   106: aload 4
    //   108: athrow
    //   109: iload_1
    //   110: iconst_1
    //   111: iadd
    //   112: istore_1
    //   113: goto -62 -> 51
    //   116: astore 5
    //   118: aload_0
    //   119: monitorenter
    //   120: aload_0
    //   121: getfield 60	com/tencent/luggage/wxa/sk/d:g	Ljava/util/LinkedList;
    //   124: aload 4
    //   126: invokevirtual 85	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
    //   129: pop
    //   130: aload_0
    //   131: monitorexit
    //   132: aload 5
    //   134: athrow
    //   135: astore 4
    //   137: aload_0
    //   138: monitorexit
    //   139: aload 4
    //   141: athrow
    //   142: return
    //   143: astore 4
    //   145: aload_0
    //   146: monitorexit
    //   147: goto +6 -> 153
    //   150: aload 4
    //   152: athrow
    //   153: goto -3 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	d
    //   50	63	1	i	int
    //   9	45	2	j	int
    //   80	2	3	bool	boolean
    //   66	26	4	localc	d.c
    //   102	23	4	localObject1	Object
    //   135	5	4	localObject2	Object
    //   143	8	4	localObject3	Object
    //   60	9	5	arrayOfc	d.c[]
    //   116	17	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   87	99	102	finally
    //   104	106	102	finally
    //   73	81	116	finally
    //   120	132	135	finally
    //   137	139	135	finally
    //   2	10	143	finally
    //   14	29	143	finally
    //   29	47	143	finally
    //   47	49	143	finally
    //   145	147	143	finally
  }
  
  void a()
  {
    if (this.b.get()) {
      return;
    }
    try
    {
      e locale = (e)this.f.pollFirst();
      if (locale != null)
      {
        d.d locald = this.c;
        locald.getClass();
        ((d.d)locald).a(locale);
        return;
      }
      this.d = false;
      b();
      return;
    }
    finally {}
  }
  
  public void a(long paramLong, e parame)
  {
    boolean bool;
    try
    {
      if (this.b.get()) {
        return;
      }
      if (parame == null) {
        return;
      }
      if (parame.isCancelled()) {
        return;
      }
      if (paramLong > 0L)
      {
        localObject = this.a.obtainMessage();
        ((Message)localObject).obj = parame;
        ((Message)localObject).what = 1;
        try
        {
          this.e.add(parame);
          this.a.sendMessageAtTime((Message)localObject, SystemClock.uptimeMillis() + paramLong);
          return;
        }
        finally {}
      }
      bool = this.f.isEmpty();
      if ((!bool) || (this.d)) {
        break label174;
      }
      this.d = true;
      Object localObject = this.c;
      localObject.getClass();
      ((d.d)localObject).a(parame);
      return;
    }
    finally {}
    this.f.addLast(parame);
    for (;;)
    {
      this.f.addFirst(parame);
      return;
      label174:
      if (!bool) {
        if (paramLong != -9223372036854775808L) {
          break;
        }
      }
    }
  }
  
  void a(@NonNull d.b paramb)
  {
    paramb.getClass();
    try
    {
      Iterator localIterator = this.e.iterator();
      e locale;
      while (localIterator.hasNext())
      {
        locale = (e)localIterator.next();
        if (paramb.a(locale))
        {
          this.a.removeMessages(1, locale);
          if (!locale.isCancelled()) {
            locale.cancel(false);
          }
          localIterator.remove();
        }
      }
      localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        locale = (e)localIterator.next();
        if (paramb.a(locale))
        {
          if (!locale.isCancelled()) {
            locale.cancel(false);
          }
          localIterator.remove();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramb;
    }
  }
  
  void a(e parame)
  {
    try
    {
      if (this.e.remove(parame)) {
        this.a.removeMessages(1, parame);
      }
      Iterator localIterator = this.f.iterator();
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        if (locale == parame)
        {
          if (!locale.isCancelled()) {
            locale.cancel(false);
          }
          localIterator.remove();
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw parame;
    }
  }
  
  boolean a(d.a parama)
  {
    try
    {
      Iterator localIterator = this.e.iterator();
      while (localIterator.hasNext()) {
        if (parama.a((e)localIterator.next())) {
          return true;
        }
      }
      localIterator = this.f.iterator();
      while (localIterator.hasNext()) {
        if (parama.a((e)localIterator.next())) {
          return true;
        }
      }
      return false;
    }
    finally {}
    for (;;)
    {
      throw parama;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      try
      {
        if (this.e.remove(paramMessage.obj))
        {
          a(0L, (e)paramMessage.obj);
          return true;
        }
      }
      finally {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.sk.d
 * JD-Core Version:    0.7.0.1
 */