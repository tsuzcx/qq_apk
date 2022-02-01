package com.tencent.map.sdk.a;

final class pv$j
{
  private static String a = "GLThreadManager";
  private boolean b;
  private int c;
  private boolean d;
  private boolean e;
  private boolean f;
  private pv.i g;
  
  private void c()
  {
    if (!this.b)
    {
      this.c = 131072;
      if (this.c >= 131072) {
        this.e = true;
      }
      this.b = true;
    }
  }
  
  public final void a(pv.i parami)
  {
    try
    {
      pv.i.a(parami);
      if (this.g == parami) {
        this.g = null;
      }
      notifyAll();
      return;
    }
    finally {}
  }
  
  /* Error */
  public final void a(javax.microedition.khronos.opengles.GL10 paramGL10)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 48	com/tencent/map/sdk/a/pv$j:d	Z
    //   8: ifne +65 -> 73
    //   11: aload_0
    //   12: invokespecial 50	com/tencent/map/sdk/a/pv$j:c	()V
    //   15: aload_1
    //   16: sipush 7937
    //   19: invokeinterface 56 2 0
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 32	com/tencent/map/sdk/a/pv$j:c	I
    //   29: ldc 30
    //   31: if_icmpge +23 -> 54
    //   34: aload_1
    //   35: ldc 58
    //   37: invokevirtual 64	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   40: ifne +36 -> 76
    //   43: iconst_1
    //   44: istore_2
    //   45: aload_0
    //   46: iload_2
    //   47: putfield 34	com/tencent/map/sdk/a/pv$j:e	Z
    //   50: aload_0
    //   51: invokevirtual 45	java/lang/Object:notifyAll	()V
    //   54: aload_0
    //   55: getfield 34	com/tencent/map/sdk/a/pv$j:e	Z
    //   58: ifne +23 -> 81
    //   61: iload_3
    //   62: istore_2
    //   63: aload_0
    //   64: iload_2
    //   65: putfield 66	com/tencent/map/sdk/a/pv$j:f	Z
    //   68: aload_0
    //   69: iconst_1
    //   70: putfield 48	com/tencent/map/sdk/a/pv$j:d	Z
    //   73: aload_0
    //   74: monitorexit
    //   75: return
    //   76: iconst_0
    //   77: istore_2
    //   78: goto -33 -> 45
    //   81: iconst_0
    //   82: istore_2
    //   83: goto -20 -> 63
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	j
    //   0	91	1	paramGL10	javax.microedition.khronos.opengles.GL10
    //   44	39	2	bool1	boolean
    //   1	61	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	43	86	finally
    //   45	54	86	finally
    //   54	61	86	finally
    //   63	73	86	finally
  }
  
  public final boolean a()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 50	com/tencent/map/sdk/a/pv$j:c	()V
    //   6: aload_0
    //   7: getfield 34	com/tencent/map/sdk/a/pv$j:e	Z
    //   10: istore_1
    //   11: iload_1
    //   12: ifne +9 -> 21
    //   15: iconst_1
    //   16: istore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: iload_1
    //   20: ireturn
    //   21: iconst_0
    //   22: istore_1
    //   23: goto -6 -> 17
    //   26: astore_2
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_2
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	j
    //   10	13	1	bool	boolean
    //   26	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	26	finally
  }
  
  public final boolean b(pv.i arg1)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((this.g == ???) || (this.g == null))
        {
          this.g = ???;
          notifyAll();
          return bool;
        }
        c();
        if (!this.e)
        {
          if (this.g != null)
          {
            pv.i locali = this.g;
            synchronized (pv.a())
            {
              locali.i = true;
              pv.a().notifyAll();
            }
          }
          bool = false;
        }
      }
      finally {}
    }
  }
  
  public final void c(pv.i parami)
  {
    try
    {
      if (this.g == parami) {
        this.g = null;
      }
      notifyAll();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.pv.j
 * JD-Core Version:    0.7.0.1
 */