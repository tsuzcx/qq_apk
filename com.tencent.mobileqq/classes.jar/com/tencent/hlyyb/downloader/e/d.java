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
        case 1: 
          a(paramDownloaderTaskStatus);
          continue;
          paramDownloaderTaskStatus = f.a;
        }
      }
      finally {}
      continue;
      paramDownloaderTaskStatus = f.b;
      continue;
      paramDownloaderTaskStatus = f.d;
      continue;
      paramDownloaderTaskStatus = f.g;
      continue;
      paramDownloaderTaskStatus = f.f;
      continue;
      paramDownloaderTaskStatus = f.e;
      continue;
      paramDownloaderTaskStatus = f.h;
      continue;
      paramDownloaderTaskStatus = localDownloaderTaskStatus;
    }
  }
  
  public final DownloaderTaskStatus a()
  {
    return this.b;
  }
  
  /* Error */
  public final void a(DownloaderTaskListener paramDownloaderTaskListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   9: astore_2
    //   10: aload_2
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   16: aload_1
    //   17: invokevirtual 103	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   20: ifne +12 -> 32
    //   23: aload_0
    //   24: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   27: aload_1
    //   28: invokevirtual 106	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   31: pop
    //   32: aload_2
    //   33: monitorexit
    //   34: aload_0
    //   35: getfield 38	com/tencent/hlyyb/downloader/e/d:d	Ljava/util/Vector;
    //   38: astore_2
    //   39: aload_2
    //   40: monitorenter
    //   41: aload_0
    //   42: getfield 38	com/tencent/hlyyb/downloader/e/d:d	Ljava/util/Vector;
    //   45: aload_1
    //   46: invokevirtual 103	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   49: ifne +12 -> 61
    //   52: aload_0
    //   53: getfield 38	com/tencent/hlyyb/downloader/e/d:d	Ljava/util/Vector;
    //   56: aload_1
    //   57: invokevirtual 106	java/util/Vector:add	(Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_2
    //   62: monitorexit
    //   63: return
    //   64: astore_1
    //   65: aload_2
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    //   69: astore_1
    //   70: return
    //   71: astore_1
    //   72: aload_2
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	d
    //   0	76	1	paramDownloaderTaskListener	DownloaderTaskListener
    // Exception table:
    //   from	to	target	type
    //   41	61	64	finally
    //   61	63	64	finally
    //   65	67	64	finally
    //   5	12	69	java/lang/Throwable
    //   34	41	69	java/lang/Throwable
    //   67	69	69	java/lang/Throwable
    //   74	76	69	java/lang/Throwable
    //   12	32	71	finally
    //   32	34	71	finally
    //   72	74	71	finally
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
    if (paramf != null) {
      if ((paramf != null) && (paramf != f.h)) {
        break label28;
      }
    }
    for (;;)
    {
      if (paramf != null) {}
      try
      {
        this.g.put(paramf);
        return;
      }
      catch (InterruptedException paramf)
      {
        label28:
        g localg;
        paramf.printStackTrace();
      }
      localg = new g(this, paramf);
      a.f().post(localg);
    }
  }
  
  public final void b()
  {
    synchronized (this.c)
    {
      this.c.clear();
    }
    synchronized (this.d)
    {
      this.d.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  /* Error */
  public final void b(DownloaderTaskListener paramDownloaderTaskListener)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_0
    //   6: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   9: astore_2
    //   10: aload_2
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   16: aload_1
    //   17: invokevirtual 103	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   20: ifeq +12 -> 32
    //   23: aload_0
    //   24: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   27: aload_1
    //   28: invokevirtual 140	java/util/Vector:remove	(Ljava/lang/Object;)Z
    //   31: pop
    //   32: aload_2
    //   33: monitorexit
    //   34: aload_0
    //   35: getfield 38	com/tencent/hlyyb/downloader/e/d:d	Ljava/util/Vector;
    //   38: astore_2
    //   39: aload_2
    //   40: monitorenter
    //   41: aload_0
    //   42: getfield 38	com/tencent/hlyyb/downloader/e/d:d	Ljava/util/Vector;
    //   45: aload_1
    //   46: invokevirtual 103	java/util/Vector:contains	(Ljava/lang/Object;)Z
    //   49: ifeq +12 -> 61
    //   52: aload_0
    //   53: getfield 38	com/tencent/hlyyb/downloader/e/d:d	Ljava/util/Vector;
    //   56: aload_1
    //   57: invokevirtual 140	java/util/Vector:remove	(Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_2
    //   62: monitorexit
    //   63: return
    //   64: astore_1
    //   65: aload_2
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    //   69: astore_1
    //   70: return
    //   71: astore_1
    //   72: aload_2
    //   73: monitorexit
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	d
    //   0	76	1	paramDownloaderTaskListener	DownloaderTaskListener
    // Exception table:
    //   from	to	target	type
    //   41	61	64	finally
    //   61	63	64	finally
    //   65	67	64	finally
    //   5	12	69	java/lang/Throwable
    //   34	41	69	java/lang/Throwable
    //   67	69	69	java/lang/Throwable
    //   74	76	69	java/lang/Throwable
    //   12	32	71	finally
    //   32	34	71	finally
    //   72	74	71	finally
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
    //   14: checkcast 78	com/tencent/hlyyb/downloader/e/f
    //   17: astore 5
    //   19: getstatic 147	com/tencent/hlyyb/downloader/e/e:b	[I
    //   22: aload 5
    //   24: invokevirtual 148	com/tencent/hlyyb/downloader/e/f:ordinal	()I
    //   27: iaload
    //   28: istore_1
    //   29: iload_1
    //   30: tableswitch	default:+46 -> 76, 1:+58->88, 2:+63->93, 3:+164->194, 4:+260->290, 5:+345->375, 6:+437->467, 7:+529->559, 8:+639->669
    //   77: istore_1
    //   78: iload_1
    //   79: ifeq -72 -> 7
    //   82: aload_0
    //   83: iconst_0
    //   84: putfield 42	com/tencent/hlyyb/downloader/e/d:f	Z
    //   87: return
    //   88: iconst_0
    //   89: istore_1
    //   90: goto -12 -> 78
    //   93: invokestatic 153	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   96: aload_0
    //   97: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   100: invokevirtual 157	com/tencent/hlyyb/downloader/c/b:onTaskStartedSubloop	(Lcom/tencent/hlyyb/downloader/DownloaderTask;)V
    //   103: aload_0
    //   104: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   107: astore 5
    //   109: aload 5
    //   111: monitorenter
    //   112: aload_0
    //   113: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   116: invokevirtual 161	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   119: astore 6
    //   121: aload 6
    //   123: invokeinterface 167 1 0
    //   128: ifeq +58 -> 186
    //   131: aload 6
    //   133: invokeinterface 170 1 0
    //   138: checkcast 172	com/tencent/hlyyb/downloader/DownloaderTaskListener
    //   141: astore 7
    //   143: aload 7
    //   145: ifnull -24 -> 121
    //   148: aload 7
    //   150: aload_0
    //   151: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   154: invokeinterface 173 2 0
    //   159: goto -38 -> 121
    //   162: astore 6
    //   164: aload 5
    //   166: monitorexit
    //   167: aload 6
    //   169: athrow
    //   170: astore 5
    //   172: iconst_0
    //   173: istore_1
    //   174: aload 5
    //   176: invokevirtual 134	java/lang/InterruptedException:printStackTrace	()V
    //   179: iload_1
    //   180: ifeq -173 -> 7
    //   183: goto -101 -> 82
    //   186: aload 5
    //   188: monitorexit
    //   189: iconst_0
    //   190: istore_1
    //   191: goto -113 -> 78
    //   194: invokestatic 153	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   197: aload_0
    //   198: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   201: invokevirtual 176	com/tencent/hlyyb/downloader/c/b:onTaskDetectedSubloop	(Lcom/tencent/hlyyb/downloader/DownloaderTask;)V
    //   204: aload_0
    //   205: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   208: astore 5
    //   210: aload 5
    //   212: monitorenter
    //   213: aload_0
    //   214: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   217: invokevirtual 161	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   220: astore 6
    //   222: aload 6
    //   224: invokeinterface 167 1 0
    //   229: ifeq +53 -> 282
    //   232: aload 6
    //   234: invokeinterface 170 1 0
    //   239: checkcast 172	com/tencent/hlyyb/downloader/DownloaderTaskListener
    //   242: astore 7
    //   244: aload 7
    //   246: ifnull -24 -> 222
    //   249: aload 7
    //   251: aload_0
    //   252: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   255: invokeinterface 177 2 0
    //   260: goto -38 -> 222
    //   263: astore 6
    //   265: aload 5
    //   267: monitorexit
    //   268: aload 6
    //   270: athrow
    //   271: astore 5
    //   273: iconst_0
    //   274: istore_1
    //   275: iload_1
    //   276: ifne -194 -> 82
    //   279: aload 5
    //   281: athrow
    //   282: aload 5
    //   284: monitorexit
    //   285: iconst_0
    //   286: istore_1
    //   287: goto -209 -> 78
    //   290: invokestatic 153	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   293: aload_0
    //   294: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   297: invokevirtual 180	com/tencent/hlyyb/downloader/c/b:onTaskReceivedSubloop	(Lcom/tencent/hlyyb/downloader/DownloaderTask;)V
    //   300: aload_0
    //   301: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   304: astore 5
    //   306: aload 5
    //   308: monitorenter
    //   309: aload_0
    //   310: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   313: invokevirtual 161	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   316: astore 6
    //   318: aload 6
    //   320: invokeinterface 167 1 0
    //   325: ifeq +42 -> 367
    //   328: aload 6
    //   330: invokeinterface 170 1 0
    //   335: checkcast 172	com/tencent/hlyyb/downloader/DownloaderTaskListener
    //   338: astore 7
    //   340: aload 7
    //   342: ifnull -24 -> 318
    //   345: aload 7
    //   347: aload_0
    //   348: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   351: invokeinterface 181 2 0
    //   356: goto -38 -> 318
    //   359: astore 6
    //   361: aload 5
    //   363: monitorexit
    //   364: aload 6
    //   366: athrow
    //   367: aload 5
    //   369: monitorexit
    //   370: iconst_0
    //   371: istore_1
    //   372: goto -294 -> 78
    //   375: invokestatic 153	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   378: aload_0
    //   379: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   382: invokevirtual 184	com/tencent/hlyyb/downloader/c/b:onTaskPausedSubloop	(Lcom/tencent/hlyyb/downloader/DownloaderTask;)V
    //   385: aload_0
    //   386: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   389: astore 5
    //   391: aload 5
    //   393: monitorenter
    //   394: aload_0
    //   395: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   398: invokevirtual 161	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   401: astore 6
    //   403: aload 6
    //   405: invokeinterface 167 1 0
    //   410: ifeq +49 -> 459
    //   413: aload 6
    //   415: invokeinterface 170 1 0
    //   420: checkcast 172	com/tencent/hlyyb/downloader/DownloaderTaskListener
    //   423: astore 7
    //   425: aload 7
    //   427: ifnull -24 -> 403
    //   430: aload 7
    //   432: aload_0
    //   433: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   436: invokeinterface 185 2 0
    //   441: goto -38 -> 403
    //   444: astore 6
    //   446: aload 5
    //   448: monitorexit
    //   449: aload 6
    //   451: athrow
    //   452: astore 5
    //   454: iconst_1
    //   455: istore_1
    //   456: goto -282 -> 174
    //   459: aload 5
    //   461: monitorexit
    //   462: iconst_1
    //   463: istore_1
    //   464: goto -386 -> 78
    //   467: invokestatic 153	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   470: aload_0
    //   471: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   474: invokevirtual 188	com/tencent/hlyyb/downloader/c/b:onTaskFailedSubloop	(Lcom/tencent/hlyyb/downloader/DownloaderTask;)V
    //   477: aload_0
    //   478: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   481: astore 5
    //   483: aload 5
    //   485: monitorenter
    //   486: aload_0
    //   487: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   490: invokevirtual 161	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   493: astore 6
    //   495: aload 6
    //   497: invokeinterface 167 1 0
    //   502: ifeq +49 -> 551
    //   505: aload 6
    //   507: invokeinterface 170 1 0
    //   512: checkcast 172	com/tencent/hlyyb/downloader/DownloaderTaskListener
    //   515: astore 7
    //   517: aload 7
    //   519: ifnull -24 -> 495
    //   522: aload 7
    //   524: aload_0
    //   525: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   528: invokeinterface 189 2 0
    //   533: goto -38 -> 495
    //   536: astore 6
    //   538: aload 5
    //   540: monitorexit
    //   541: aload 6
    //   543: athrow
    //   544: astore 5
    //   546: iload_2
    //   547: istore_1
    //   548: goto -273 -> 275
    //   551: aload 5
    //   553: monitorexit
    //   554: iconst_1
    //   555: istore_1
    //   556: goto -478 -> 78
    //   559: invokestatic 195	android/os/SystemClock:elapsedRealtime	()J
    //   562: lstore_3
    //   563: aload_0
    //   564: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   567: astore 5
    //   569: aload 5
    //   571: monitorenter
    //   572: aload_0
    //   573: getfield 36	com/tencent/hlyyb/downloader/e/d:c	Ljava/util/Vector;
    //   576: invokevirtual 161	java/util/Vector:iterator	()Ljava/util/Iterator;
    //   579: astore 6
    //   581: aload 6
    //   583: invokeinterface 167 1 0
    //   588: ifeq +42 -> 630
    //   591: aload 6
    //   593: invokeinterface 170 1 0
    //   598: checkcast 172	com/tencent/hlyyb/downloader/DownloaderTaskListener
    //   601: astore 7
    //   603: aload 7
    //   605: ifnull -24 -> 581
    //   608: aload 7
    //   610: aload_0
    //   611: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   614: invokeinterface 198 2 0
    //   619: goto -38 -> 581
    //   622: astore 6
    //   624: aload 5
    //   626: monitorexit
    //   627: aload 6
    //   629: athrow
    //   630: aload 5
    //   632: monitorexit
    //   633: aload_0
    //   634: invokestatic 195	android/os/SystemClock:elapsedRealtime	()J
    //   637: lload_3
    //   638: lsub
    //   639: l2i
    //   640: putfield 40	com/tencent/hlyyb/downloader/e/d:e	I
    //   643: aload_0
    //   644: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   647: invokevirtual 203	com/tencent/hlyyb/downloader/e/i:t	()V
    //   650: invokestatic 195	android/os/SystemClock:elapsedRealtime	()J
    //   653: pop2
    //   654: invokestatic 153	com/tencent/hlyyb/downloader/c/b:a	()Lcom/tencent/hlyyb/downloader/c/b;
    //   657: aload_0
    //   658: getfield 49	com/tencent/hlyyb/downloader/e/d:a	Lcom/tencent/hlyyb/downloader/e/i;
    //   661: invokevirtual 204	com/tencent/hlyyb/downloader/c/b:onTaskCompletedSubloop	(Lcom/tencent/hlyyb/downloader/DownloaderTask;)V
    //   664: iconst_1
    //   665: istore_1
    //   666: goto -588 -> 78
    //   669: iconst_1
    //   670: istore_1
    //   671: goto -593 -> 78
    //   674: astore 5
    //   676: goto -401 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	679	0	this	d
    //   28	643	1	i	int
    //   1	546	2	j	int
    //   562	76	3	l	long
    //   17	148	5	localObject1	Object
    //   170	17	5	localInterruptedException1	InterruptedException
    //   271	12	5	localObject2	Object
    //   452	8	5	localInterruptedException2	InterruptedException
    //   544	8	5	localObject3	Object
    //   674	1	5	localObject4	Object
    //   119	13	6	localIterator1	java.util.Iterator
    //   162	6	6	localObject5	Object
    //   220	13	6	localIterator2	java.util.Iterator
    //   263	6	6	localObject6	Object
    //   316	13	6	localIterator3	java.util.Iterator
    //   359	6	6	localObject7	Object
    //   401	13	6	localIterator4	java.util.Iterator
    //   444	6	6	localObject8	Object
    //   493	13	6	localIterator5	java.util.Iterator
    //   536	6	6	localObject9	Object
    //   579	13	6	localIterator6	java.util.Iterator
    //   622	6	6	localObject10	Object
    //   141	468	7	localDownloaderTaskListener	DownloaderTaskListener
    // Exception table:
    //   from	to	target	type
    //   112	121	162	finally
    //   121	143	162	finally
    //   148	159	162	finally
    //   164	167	162	finally
    //   186	189	162	finally
    //   7	29	170	java/lang/InterruptedException
    //   93	112	170	java/lang/InterruptedException
    //   167	170	170	java/lang/InterruptedException
    //   194	213	170	java/lang/InterruptedException
    //   268	271	170	java/lang/InterruptedException
    //   290	309	170	java/lang/InterruptedException
    //   364	367	170	java/lang/InterruptedException
    //   213	222	263	finally
    //   222	244	263	finally
    //   249	260	263	finally
    //   265	268	263	finally
    //   282	285	263	finally
    //   7	29	271	finally
    //   93	112	271	finally
    //   167	170	271	finally
    //   194	213	271	finally
    //   268	271	271	finally
    //   290	309	271	finally
    //   364	367	271	finally
    //   309	318	359	finally
    //   318	340	359	finally
    //   345	356	359	finally
    //   361	364	359	finally
    //   367	370	359	finally
    //   394	403	444	finally
    //   403	425	444	finally
    //   430	441	444	finally
    //   446	449	444	finally
    //   459	462	444	finally
    //   375	394	452	java/lang/InterruptedException
    //   449	452	452	java/lang/InterruptedException
    //   467	486	452	java/lang/InterruptedException
    //   541	544	452	java/lang/InterruptedException
    //   559	572	452	java/lang/InterruptedException
    //   627	630	452	java/lang/InterruptedException
    //   633	664	452	java/lang/InterruptedException
    //   486	495	536	finally
    //   495	517	536	finally
    //   522	533	536	finally
    //   538	541	536	finally
    //   551	554	536	finally
    //   375	394	544	finally
    //   449	452	544	finally
    //   467	486	544	finally
    //   541	544	544	finally
    //   559	572	544	finally
    //   627	630	544	finally
    //   633	664	544	finally
    //   572	581	622	finally
    //   581	603	622	finally
    //   608	619	622	finally
    //   624	627	622	finally
    //   630	633	622	finally
    //   174	179	674	finally
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hlyyb.downloader.e.d
 * JD-Core Version:    0.7.0.1
 */