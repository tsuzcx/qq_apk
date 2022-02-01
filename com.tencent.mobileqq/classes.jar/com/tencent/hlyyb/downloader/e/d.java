package com.tencent.hlyyb.downloader.e;

import android.os.Handler;
import com.tencent.hlyyb.common.a;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.hlyyb.downloader.DownloaderTaskStatus;
import java.util.Vector;
import java.util.concurrent.LinkedBlockingQueue;

public final class d
{
  private i a;
  private volatile DownloaderTaskStatus b = DownloaderTaskStatus.PENDING;
  private Vector<DownloaderTaskListener> c = new Vector();
  private Vector<DownloaderTaskListener> d = new Vector();
  private int e = 0;
  private volatile boolean f = false;
  private LinkedBlockingQueue<f> g = new LinkedBlockingQueue();
  
  public d(i parami)
  {
    this.a = parami;
  }
  
  private void a(DownloaderTaskStatus paramDownloaderTaskStatus, boolean paramBoolean)
  {
    for (;;)
    {
      DownloaderTaskStatus localDownloaderTaskStatus;
      try
      {
        if ((this.b == DownloaderTaskStatus.COMPLETE) || (this.b == DownloaderTaskStatus.FAILED) || (this.b == DownloaderTaskStatus.PAUSED) || (this.b == DownloaderTaskStatus.DELETED))
        {
          localDownloaderTaskStatus = DownloaderTaskStatus.PENDING;
          if (paramDownloaderTaskStatus != localDownloaderTaskStatus) {
            return;
          }
        }
        this.b = paramDownloaderTaskStatus;
        localDownloaderTaskStatus = null;
        switch (e.a[paramDownloaderTaskStatus.ordinal()])
        {
        case 7: 
          paramDownloaderTaskStatus = f.h;
          break;
        case 6: 
          paramDownloaderTaskStatus = f.e;
          break;
        case 5: 
          paramDownloaderTaskStatus = f.f;
          break;
        case 4: 
          paramDownloaderTaskStatus = f.g;
          break;
        case 3: 
          paramDownloaderTaskStatus = f.d;
          break;
        case 2: 
          paramDownloaderTaskStatus = f.b;
          break;
        case 1: 
          paramDownloaderTaskStatus = f.a;
          a(paramDownloaderTaskStatus);
          return;
        }
      }
      finally {}
      paramDownloaderTaskStatus = localDownloaderTaskStatus;
    }
  }
  
  public final DownloaderTaskStatus a()
  {
    return this.b;
  }
  
  public final void a(DownloaderTaskListener paramDownloaderTaskListener)
  {
    if (paramDownloaderTaskListener == null) {
      return;
    }
    try
    {
      synchronized (this.c)
      {
        if (!this.c.contains(paramDownloaderTaskListener)) {
          this.c.add(paramDownloaderTaskListener);
        }
        synchronized (this.d)
        {
          if (!this.d.contains(paramDownloaderTaskListener)) {
            this.d.add(paramDownloaderTaskListener);
          }
          return;
        }
      }
      return;
    }
    catch (Throwable paramDownloaderTaskListener) {}
  }
  
  public final void a(DownloaderTaskStatus paramDownloaderTaskStatus)
  {
    try
    {
      a(paramDownloaderTaskStatus, true);
      return;
    }
    finally
    {
      paramDownloaderTaskStatus = finally;
      throw paramDownloaderTaskStatus;
    }
  }
  
  public final void a(f paramf)
  {
    if (paramf != null)
    {
      if ((paramf != null) && (paramf != f.h))
      {
        g localg = new g(this, paramf);
        a.f().post(localg);
      }
      if (paramf != null) {
        try
        {
          this.g.put(paramf);
          return;
        }
        catch (InterruptedException paramf)
        {
          paramf.printStackTrace();
        }
      }
    }
  }
  
  public final void b()
  {
    synchronized (this.c)
    {
      this.c.clear();
      synchronized (this.d)
      {
        this.d.clear();
        return;
      }
    }
  }
  
  public final void b(DownloaderTaskListener paramDownloaderTaskListener)
  {
    if (paramDownloaderTaskListener == null) {
      return;
    }
    try
    {
      synchronized (this.c)
      {
        if (this.c.contains(paramDownloaderTaskListener)) {
          this.c.remove(paramDownloaderTaskListener);
        }
        synchronized (this.d)
        {
          if (this.d.contains(paramDownloaderTaskListener)) {
            this.d.remove(paramDownloaderTaskListener);
          }
          return;
        }
      }
      return;
    }
    catch (Throwable paramDownloaderTaskListener) {}
  }
  
  public final void c()
  {
    try
    {
      this.g.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public final void d()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 42	com/tencent/hlyyb/downloader/e/d:f	Z
    //   7: aload_0
    //   8: getfield 47	com/tencent/hlyyb/downloader/e/d:g	Ljava/util/concurrent/LinkedBlockingQueue;
    //   11: invokevirtual 145	java/util/concurrent/LinkedBlockingQueue:take	()Ljava/lang/Object;
    //   14: checkcast 75	com/tencent/hlyyb/downloader/e/f
    //   17: astore 5
    //   19: getstatic 147	com/tencent/hlyyb/downloader/e/e:b	[I
    //   22: aload 5
    //   24: invokevirtual 148	com/tencent/hlyyb/downloader/e/f:ordinal	()I
    //   27: iaload
    //   28: istore_1
    //   29: iload_1
    //   30: tableswitch	default:+46 -> 76, 1:+591->621, 2:+508->538, 3:+425->455, 4:+342->372, 5:+245->275, 6:+162->192, 7:+54->84, 8:+49->79
    //   77: iconst_m1
    //   78: lload_3
    //   79: iconst_1
    //   80: istore_1
    //   81: goto +542 -> 623
    //   84: invokestatic 154	android/os/SystemClock:elapsedRealtime	()J
    //   87: lstore_3
    //   88: aload_0
    //   89: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   92: astore 5
    //   94: aload 5
    //   96: monitorenter
    //   97: aload_0
    //   98: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   101: invokevirtual 158	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   104: astore 6
    //   106: aload 6
    //   108: invokeinterface 164 1 0
    //   113: ifeq +34 -> 147
    //   116: aload 6
    //   118: invokeinterface 167 1 0
    //   123: checkcast 169	com/tencent/hlyyb/downloader/DownloaderTaskListener
    //   126: astore 7
    //   128: aload 7
    //   130: ifnull -24 -> 106
    //   133: aload 7
    //   135: aload_0
    //   136: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   139: invokeinterface 173 2 0
    //   144: goto -38 -> 106
    //   147: aload 5
    //   149: monitorexit
    //   150: aload_0
    //   151: invokestatic 154	android/os/SystemClock:elapsedRealtime	()J
    //   154: lload_3
    //   155: lsub
    //   156: l2i
    //   157: putfield 40	com/tencent/hlyyb/downloader/e/d:e	I
    //   160: aload_0
    //   161: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   164: invokevirtual 178	com/tencent/hlyyb/downloader/e/i:t	()V
    //   167: invokestatic 154	android/os/SystemClock:elapsedRealtime	()J
    //   170: pop2
    //   171: invokestatic 183	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   174: aload_0
    //   175: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   178: invokevirtual 184	com/tencent/hlyyb/downloader/c/b:onTaskCompletedSubloop	(Lcom/tencent/hlyyb/downloader/DownloaderTask;)V
    //   181: goto -102 -> 79
    //   184: astore 6
    //   186: aload 5
    //   188: monitorexit
    //   189: aload 6
    //   191: athrow
    //   192: invokestatic 183	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   195: aload_0
    //   196: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   199: invokevirtual 187	com/tencent/hlyyb/downloader/c/b:onTaskFailedSubloop	(Lcom/tencent/hlyyb/downloader/DownloaderTask;)V
    //   202: aload_0
    //   203: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   206: astore 5
    //   208: aload 5
    //   210: monitorenter
    //   211: aload_0
    //   212: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   215: invokevirtual 158	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   218: astore 6
    //   220: aload 6
    //   222: invokeinterface 164 1 0
    //   227: ifeq +34 -> 261
    //   230: aload 6
    //   232: invokeinterface 167 1 0
    //   237: checkcast 169	com/tencent/hlyyb/downloader/DownloaderTaskListener
    //   240: astore 7
    //   242: aload 7
    //   244: ifnull -24 -> 220
    //   247: aload 7
    //   249: aload_0
    //   250: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   253: invokeinterface 188 2 0
    //   258: goto -38 -> 220
    //   261: aload 5
    //   263: monitorexit
    //   264: goto -185 -> 79
    //   267: astore 6
    //   269: aload 5
    //   271: monitorexit
    //   272: aload 6
    //   274: athrow
    //   275: invokestatic 183	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   278: aload_0
    //   279: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   282: invokevirtual 191	com/tencent/hlyyb/downloader/c/b:onTaskPausedSubloop	(Lcom/tencent/hlyyb/downloader/DownloaderTask;)V
    //   285: aload_0
    //   286: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   289: astore 5
    //   291: aload 5
    //   293: monitorenter
    //   294: aload_0
    //   295: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   298: invokevirtual 158	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   301: astore 6
    //   303: aload 6
    //   305: invokeinterface 164 1 0
    //   310: ifeq +34 -> 344
    //   313: aload 6
    //   315: invokeinterface 167 1 0
    //   320: checkcast 169	com/tencent/hlyyb/downloader/DownloaderTaskListener
    //   323: astore 7
    //   325: aload 7
    //   327: ifnull -24 -> 303
    //   330: aload 7
    //   332: aload_0
    //   333: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   336: invokeinterface 192 2 0
    //   341: goto -38 -> 303
    //   344: aload 5
    //   346: monitorexit
    //   347: goto -268 -> 79
    //   350: astore 6
    //   352: aload 5
    //   354: monitorexit
    //   355: aload 6
    //   357: athrow
    //   358: astore 5
    //   360: iload_2
    //   361: istore_1
    //   362: goto +293 -> 655
    //   365: astore 5
    //   367: iconst_1
    //   368: istore_1
    //   369: goto +272 -> 641
    //   372: invokestatic 183	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   375: aload_0
    //   376: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   379: invokevirtual 195	com/tencent/hlyyb/downloader/c/b:onTaskReceivedSubloop	(Lcom/tencent/hlyyb/downloader/DownloaderTask;)V
    //   382: aload_0
    //   383: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   386: astore 5
    //   388: aload 5
    //   390: monitorenter
    //   391: aload_0
    //   392: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   395: invokevirtual 158	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   398: astore 6
    //   400: aload 6
    //   402: invokeinterface 164 1 0
    //   407: ifeq +34 -> 441
    //   410: aload 6
    //   412: invokeinterface 167 1 0
    //   417: checkcast 169	com/tencent/hlyyb/downloader/DownloaderTaskListener
    //   420: astore 7
    //   422: aload 7
    //   424: ifnull -24 -> 400
    //   427: aload 7
    //   429: aload_0
    //   430: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   433: invokeinterface 196 2 0
    //   438: goto -38 -> 400
    //   441: aload 5
    //   443: monitorexit
    //   444: goto +177 -> 621
    //   447: astore 6
    //   449: aload 5
    //   451: monitorexit
    //   452: aload 6
    //   454: athrow
    //   455: invokestatic 183	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   458: aload_0
    //   459: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   462: invokevirtual 199	com/tencent/hlyyb/downloader/c/b:onTaskDetectedSubloop	(Lcom/tencent/hlyyb/downloader/DownloaderTask;)V
    //   465: aload_0
    //   466: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   469: astore 5
    //   471: aload 5
    //   473: monitorenter
    //   474: aload_0
    //   475: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   478: invokevirtual 158	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   481: astore 6
    //   483: aload 6
    //   485: invokeinterface 164 1 0
    //   490: ifeq +34 -> 524
    //   493: aload 6
    //   495: invokeinterface 167 1 0
    //   500: checkcast 169	com/tencent/hlyyb/downloader/DownloaderTaskListener
    //   503: astore 7
    //   505: aload 7
    //   507: ifnull -24 -> 483
    //   510: aload 7
    //   512: aload_0
    //   513: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   516: invokeinterface 200 2 0
    //   521: goto -38 -> 483
    //   524: aload 5
    //   526: monitorexit
    //   527: goto +94 -> 621
    //   530: astore 6
    //   532: aload 5
    //   534: monitorexit
    //   535: aload 6
    //   537: athrow
    //   538: invokestatic 183	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   541: aload_0
    //   542: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   545: invokevirtual 203	com/tencent/hlyyb/downloader/c/b:onTaskStartedSubloop	(Lcom/tencent/hlyyb/downloader/DownloaderTask;)V
    //   548: aload_0
    //   549: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   552: astore 5
    //   554: aload 5
    //   556: monitorenter
    //   557: aload_0
    //   558: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   561: invokevirtual 158	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   564: astore 6
    //   566: aload 6
    //   568: invokeinterface 164 1 0
    //   573: ifeq +34 -> 607
    //   576: aload 6
    //   578: invokeinterface 167 1 0
    //   583: checkcast 169	com/tencent/hlyyb/downloader/DownloaderTaskListener
    //   586: astore 7
    //   588: aload 7
    //   590: ifnull -24 -> 566
    //   593: aload 7
    //   595: aload_0
    //   596: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   599: invokeinterface 204 2 0
    //   604: goto -38 -> 566
    //   607: aload 5
    //   609: monitorexit
    //   610: goto +11 -> 621
    //   613: astore 6
    //   615: aload 5
    //   617: monitorexit
    //   618: aload 6
    //   620: athrow
    //   621: iconst_0
    //   622: istore_1
    //   623: iload_1
    //   624: ifeq -617 -> 7
    //   627: goto +32 -> 659
    //   630: astore 5
    //   632: iconst_0
    //   633: istore_1
    //   634: goto +21 -> 655
    //   637: astore 5
    //   639: iconst_0
    //   640: istore_1
    //   641: aload 5
    //   643: invokevirtual 134	java/lang/InterruptedException:printStackTrace	()V
    //   646: iload_1
    //   647: ifeq -640 -> 7
    //   650: goto +9 -> 659
    //   653: astore 5
    //   655: iload_1
    //   656: ifeq +9 -> 665
    //   659: aload_0
    //   660: iconst_0
    //   661: putfield 42	com/tencent/hlyyb/downloader/e/d:f	Z
    //   664: return
    //   665: goto +6 -> 671
    //   668: aload 5
    //   670: athrow
    //   671: goto -3 -> 668
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	674	0	this	d
    //   28	628	1	i	int
    //   1	360	2	j	int
    //   87	68	3	l	long
    //   17	336	5	localObject1	Object
    //   358	1	5	localObject2	Object
    //   365	1	5	localInterruptedException1	InterruptedException
    //   386	230	5	localVector	Vector
    //   630	1	5	localObject3	Object
    //   637	5	5	localInterruptedException2	InterruptedException
    //   653	16	5	localObject4	Object
    //   104	13	6	localIterator1	java.util.Iterator
    //   184	6	6	localObject5	Object
    //   218	13	6	localIterator2	java.util.Iterator
    //   267	6	6	localObject6	Object
    //   301	13	6	localIterator3	java.util.Iterator
    //   350	6	6	localObject7	Object
    //   398	13	6	localIterator4	java.util.Iterator
    //   447	6	6	localObject8	Object
    //   481	13	6	localIterator5	java.util.Iterator
    //   530	6	6	localObject9	Object
    //   564	13	6	localIterator6	java.util.Iterator
    //   613	6	6	localObject10	Object
    //   126	468	7	localDownloaderTaskListener	DownloaderTaskListener
    // Exception table:
    //   from	to	target	type
    //   97	106	184	finally
    //   106	128	184	finally
    //   133	144	184	finally
    //   147	150	184	finally
    //   186	189	184	finally
    //   211	220	267	finally
    //   220	242	267	finally
    //   247	258	267	finally
    //   261	264	267	finally
    //   269	272	267	finally
    //   294	303	350	finally
    //   303	325	350	finally
    //   330	341	350	finally
    //   344	347	350	finally
    //   352	355	350	finally
    //   84	97	358	finally
    //   150	181	358	finally
    //   189	192	358	finally
    //   192	211	358	finally
    //   272	275	358	finally
    //   275	294	358	finally
    //   355	358	358	finally
    //   84	97	365	java/lang/InterruptedException
    //   150	181	365	java/lang/InterruptedException
    //   189	192	365	java/lang/InterruptedException
    //   192	211	365	java/lang/InterruptedException
    //   272	275	365	java/lang/InterruptedException
    //   275	294	365	java/lang/InterruptedException
    //   355	358	365	java/lang/InterruptedException
    //   391	400	447	finally
    //   400	422	447	finally
    //   427	438	447	finally
    //   441	444	447	finally
    //   449	452	447	finally
    //   474	483	530	finally
    //   483	505	530	finally
    //   510	521	530	finally
    //   524	527	530	finally
    //   532	535	530	finally
    //   557	566	613	finally
    //   566	588	613	finally
    //   593	604	613	finally
    //   607	610	613	finally
    //   615	618	613	finally
    //   7	29	630	finally
    //   372	391	630	finally
    //   452	455	630	finally
    //   455	474	630	finally
    //   535	538	630	finally
    //   538	557	630	finally
    //   618	621	630	finally
    //   7	29	637	java/lang/InterruptedException
    //   372	391	637	java/lang/InterruptedException
    //   452	455	637	java/lang/InterruptedException
    //   455	474	637	java/lang/InterruptedException
    //   535	538	637	java/lang/InterruptedException
    //   538	557	637	java/lang/InterruptedException
    //   618	621	637	java/lang/InterruptedException
    //   641	646	653	finally
  }
  
  public final boolean e()
  {
    return this.f;
  }
  
  public final int f()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.d
 * JD-Core Version:    0.7.0.1
 */