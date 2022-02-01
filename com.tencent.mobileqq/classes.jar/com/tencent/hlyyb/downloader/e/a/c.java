package com.tencent.hlyyb.downloader.e.a;

public final class c
  implements Runnable
{
  private d a;
  private volatile boolean b = false;
  private Object c = new Object();
  private Object d = new Object();
  private volatile boolean e = false;
  
  public c(d paramd)
  {
    this.a = paramd;
    new Thread(this, "HalleyDownload-SaveThread").start();
  }
  
  public final void a()
  {
    synchronized (this.c)
    {
      if (!this.b)
      {
        this.b = true;
        this.c.notify();
      }
      return;
    }
  }
  
  public final void b()
  {
    synchronized (this.c)
    {
      if (this.b) {
        this.b = false;
      }
      return;
    }
  }
  
  public final void c()
  {
    try
    {
      if (this.e) {
        synchronized (this.d)
        {
          this.d.notify();
          return;
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: invokestatic 56	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_2
    //   4: aload_0
    //   5: getfield 29	com/tencent/hlyyb/downloader/e/a/c:a	Lcom/tencent/hlyyb/downloader/e/a/d;
    //   8: invokeinterface 61 1 0
    //   13: istore 6
    //   15: goto +6 -> 21
    //   18: iconst_0
    //   19: istore 6
    //   21: invokestatic 56	android/os/SystemClock:elapsedRealtime	()J
    //   24: lload_2
    //   25: lsub
    //   26: lstore_2
    //   27: iload 6
    //   29: ifne +82 -> 111
    //   32: getstatic 66	com/tencent/hlyyb/downloader/a/a:d	I
    //   35: istore_1
    //   36: lload_2
    //   37: lconst_0
    //   38: lcmp
    //   39: ifle +72 -> 111
    //   42: iload_1
    //   43: i2l
    //   44: lstore 4
    //   46: lload_2
    //   47: lload 4
    //   49: lcmp
    //   50: ifge +61 -> 111
    //   53: lload 4
    //   55: lload_2
    //   56: lsub
    //   57: l2i
    //   58: istore_1
    //   59: aload_0
    //   60: iconst_1
    //   61: putfield 27	com/tencent/hlyyb/downloader/e/a/c:e	Z
    //   64: aload_0
    //   65: getfield 25	com/tencent/hlyyb/downloader/e/a/c:d	Ljava/lang/Object;
    //   68: astore 7
    //   70: aload 7
    //   72: monitorenter
    //   73: aload_0
    //   74: getfield 25	com/tencent/hlyyb/downloader/e/a/c:d	Ljava/lang/Object;
    //   77: iload_1
    //   78: i2l
    //   79: invokevirtual 70	java/lang/Object:wait	(J)V
    //   82: aload 7
    //   84: monitorexit
    //   85: goto +21 -> 106
    //   88: astore 8
    //   90: aload 7
    //   92: monitorexit
    //   93: aload 8
    //   95: athrow
    //   96: astore 7
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 27	com/tencent/hlyyb/downloader/e/a/c:e	Z
    //   103: aload 7
    //   105: athrow
    //   106: aload_0
    //   107: iconst_0
    //   108: putfield 27	com/tencent/hlyyb/downloader/e/a/c:e	Z
    //   111: aload_0
    //   112: getfield 23	com/tencent/hlyyb/downloader/e/a/c:c	Ljava/lang/Object;
    //   115: astore 7
    //   117: aload 7
    //   119: monitorenter
    //   120: aload_0
    //   121: getfield 21	com/tencent/hlyyb/downloader/e/a/c:b	Z
    //   124: istore 6
    //   126: iload 6
    //   128: ifne +20 -> 148
    //   131: aload_0
    //   132: getfield 23	com/tencent/hlyyb/downloader/e/a/c:c	Ljava/lang/Object;
    //   135: invokevirtual 72	java/lang/Object:wait	()V
    //   138: goto +10 -> 148
    //   141: astore 8
    //   143: aload 8
    //   145: invokevirtual 75	java/lang/InterruptedException:printStackTrace	()V
    //   148: aload 7
    //   150: monitorexit
    //   151: goto -151 -> 0
    //   154: astore 8
    //   156: aload 7
    //   158: monitorexit
    //   159: goto +6 -> 165
    //   162: aload 8
    //   164: athrow
    //   165: goto -3 -> 162
    //   168: astore 7
    //   170: goto -152 -> 18
    //   173: astore 7
    //   175: goto -69 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	178	0	this	c
    //   35	43	1	i	int
    //   3	53	2	l1	long
    //   44	10	4	l2	long
    //   13	114	6	bool	boolean
    //   96	8	7	localObject2	Object
    //   168	1	7	localThrowable	java.lang.Throwable
    //   173	1	7	localException	Exception
    //   88	6	8	localObject4	Object
    //   141	3	8	localInterruptedException	java.lang.InterruptedException
    //   154	9	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   73	85	88	finally
    //   90	93	88	finally
    //   59	73	96	finally
    //   93	96	96	finally
    //   131	138	141	java/lang/InterruptedException
    //   120	126	154	finally
    //   131	138	154	finally
    //   143	148	154	finally
    //   148	151	154	finally
    //   156	159	154	finally
    //   4	15	168	java/lang/Throwable
    //   59	73	173	java/lang/Exception
    //   93	96	173	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.a.c
 * JD-Core Version:    0.7.0.1
 */