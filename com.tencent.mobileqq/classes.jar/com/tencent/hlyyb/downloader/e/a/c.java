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
    //   13: istore 4
    //   15: invokestatic 56	android/os/SystemClock:elapsedRealtime	()J
    //   18: lload_2
    //   19: lsub
    //   20: lstore_2
    //   21: iload 4
    //   23: ifne +57 -> 80
    //   26: getstatic 66	com/tencent/hlyyb/downloader/a/a:d	I
    //   29: istore_1
    //   30: lload_2
    //   31: lconst_0
    //   32: lcmp
    //   33: ifle +47 -> 80
    //   36: lload_2
    //   37: iload_1
    //   38: i2l
    //   39: lcmp
    //   40: ifge +40 -> 80
    //   43: iload_1
    //   44: i2l
    //   45: lload_2
    //   46: lsub
    //   47: l2i
    //   48: istore_1
    //   49: aload_0
    //   50: iconst_1
    //   51: putfield 27	com/tencent/hlyyb/downloader/e/a/c:e	Z
    //   54: aload_0
    //   55: getfield 25	com/tencent/hlyyb/downloader/e/a/c:d	Ljava/lang/Object;
    //   58: astore 5
    //   60: aload 5
    //   62: monitorenter
    //   63: aload_0
    //   64: getfield 25	com/tencent/hlyyb/downloader/e/a/c:d	Ljava/lang/Object;
    //   67: iload_1
    //   68: i2l
    //   69: invokevirtual 70	java/lang/Object:wait	(J)V
    //   72: aload 5
    //   74: monitorexit
    //   75: aload_0
    //   76: iconst_0
    //   77: putfield 27	com/tencent/hlyyb/downloader/e/a/c:e	Z
    //   80: aload_0
    //   81: getfield 23	com/tencent/hlyyb/downloader/e/a/c:c	Ljava/lang/Object;
    //   84: astore 5
    //   86: aload 5
    //   88: monitorenter
    //   89: aload_0
    //   90: getfield 21	com/tencent/hlyyb/downloader/e/a/c:b	Z
    //   93: istore 4
    //   95: iload 4
    //   97: ifne +10 -> 107
    //   100: aload_0
    //   101: getfield 23	com/tencent/hlyyb/downloader/e/a/c:c	Ljava/lang/Object;
    //   104: invokevirtual 72	java/lang/Object:wait	()V
    //   107: aload 5
    //   109: monitorexit
    //   110: goto -110 -> 0
    //   113: astore 6
    //   115: aload 5
    //   117: monitorexit
    //   118: aload 6
    //   120: athrow
    //   121: astore 5
    //   123: iconst_0
    //   124: istore 4
    //   126: goto -111 -> 15
    //   129: astore 6
    //   131: aload 5
    //   133: monitorexit
    //   134: aload 6
    //   136: athrow
    //   137: astore 5
    //   139: aload_0
    //   140: iconst_0
    //   141: putfield 27	com/tencent/hlyyb/downloader/e/a/c:e	Z
    //   144: goto -64 -> 80
    //   147: astore 5
    //   149: aload_0
    //   150: iconst_0
    //   151: putfield 27	com/tencent/hlyyb/downloader/e/a/c:e	Z
    //   154: aload 5
    //   156: athrow
    //   157: astore 6
    //   159: aload 6
    //   161: invokevirtual 75	java/lang/InterruptedException:printStackTrace	()V
    //   164: goto -57 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	c
    //   29	39	1	i	int
    //   3	43	2	l	long
    //   13	112	4	bool	boolean
    //   121	11	5	localThrowable	java.lang.Throwable
    //   137	1	5	localException	Exception
    //   147	8	5	localObject2	Object
    //   113	6	6	localObject3	Object
    //   129	6	6	localObject4	Object
    //   157	3	6	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   89	95	113	finally
    //   100	107	113	finally
    //   107	110	113	finally
    //   115	118	113	finally
    //   159	164	113	finally
    //   4	15	121	java/lang/Throwable
    //   63	75	129	finally
    //   131	134	129	finally
    //   49	63	137	java/lang/Exception
    //   134	137	137	java/lang/Exception
    //   49	63	147	finally
    //   134	137	147	finally
    //   100	107	157	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.a.c
 * JD-Core Version:    0.7.0.1
 */