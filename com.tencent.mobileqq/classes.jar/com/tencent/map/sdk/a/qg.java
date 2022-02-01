package com.tencent.map.sdk.a;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class qg
{
  public final Map<String, qg.a> a = new Hashtable();
  public ExecutorService b;
  public Set<qf> c = new HashSet();
  private ExecutorService d;
  private qe e;
  
  public final void a()
  {
    this.e = null;
    ExecutorService localExecutorService = this.b;
    if (localExecutorService != null)
    {
      localExecutorService.shutdown();
      this.b = null;
    }
    localExecutorService = this.d;
    if (localExecutorService != null)
    {
      localExecutorService.shutdown();
      this.d = null;
    }
    this.c.clear();
  }
  
  public final void a(qf paramqf)
  {
    if (paramqf != null) {
      this.c.add(paramqf);
    }
  }
  
  public final void a(String paramString)
  {
    try
    {
      paramString = (qg.a)this.a.remove(paramString);
      if (paramString != null) {
        if ((paramString.d != 0) && (paramString.d != qg.b.b))
        {
          if (paramString.b != null) {
            paramString.b.cancel(true);
          }
          if (paramString.c != null) {
            paramString.c.b();
          }
          paramString.d = qg.b.c;
        }
        else
        {
          return;
        }
      }
      return;
    }
    finally {}
  }
  
  public final void a(String paramString, qe paramqe)
  {
    try
    {
      a(paramString, paramqe, qh.a.e);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public final void a(String paramString, qe paramqe, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_2
    //   3: ifnonnull +6 -> 9
    //   6: aload_0
    //   7: monitorexit
    //   8: return
    //   9: aload_0
    //   10: getfield 34	com/tencent/map/sdk/a/qg:b	Ljava/util/concurrent/ExecutorService;
    //   13: ifnonnull +11 -> 24
    //   16: aload_0
    //   17: iconst_5
    //   18: invokestatic 103	java/util/concurrent/Executors:newFixedThreadPool	(I)Ljava/util/concurrent/ExecutorService;
    //   21: putfield 34	com/tencent/map/sdk/a/qg:b	Ljava/util/concurrent/ExecutorService;
    //   24: aload_0
    //   25: getfield 34	com/tencent/map/sdk/a/qg:b	Ljava/util/concurrent/ExecutorService;
    //   28: invokeinterface 107 1 0
    //   33: ifne +89 -> 122
    //   36: new 109	com/tencent/map/sdk/a/qg$1
    //   39: dup
    //   40: aload_0
    //   41: aload_1
    //   42: aload_2
    //   43: iload_3
    //   44: invokespecial 112	com/tencent/map/sdk/a/qg$1:<init>	(Lcom/tencent/map/sdk/a/qg;Ljava/lang/String;Lcom/tencent/map/sdk/a/qe;I)V
    //   47: astore 4
    //   49: aload_0
    //   50: getfield 34	com/tencent/map/sdk/a/qg:b	Ljava/util/concurrent/ExecutorService;
    //   53: aload 4
    //   55: invokeinterface 116 2 0
    //   60: astore 5
    //   62: new 60	com/tencent/map/sdk/a/qg$a
    //   65: dup
    //   66: aload_0
    //   67: iconst_0
    //   68: invokespecial 119	com/tencent/map/sdk/a/qg$a:<init>	(Lcom/tencent/map/sdk/a/qg;B)V
    //   71: astore 6
    //   73: aload 6
    //   75: aload 4
    //   77: putfield 122	com/tencent/map/sdk/a/qg$a:a	Ljava/lang/Runnable;
    //   80: aload 6
    //   82: aload_2
    //   83: putfield 78	com/tencent/map/sdk/a/qg$a:c	Lcom/tencent/map/sdk/a/qe;
    //   86: aload 6
    //   88: aload 5
    //   90: putfield 70	com/tencent/map/sdk/a/qg$a:b	Ljava/util/concurrent/Future;
    //   93: aload 6
    //   95: getfield 63	com/tencent/map/sdk/a/qg$a:d	I
    //   98: ifne +11 -> 109
    //   101: aload 6
    //   103: getstatic 124	com/tencent/map/sdk/a/qg$b:a	I
    //   106: putfield 63	com/tencent/map/sdk/a/qg$a:d	I
    //   109: aload_0
    //   110: getfield 24	com/tencent/map/sdk/a/qg:a	Ljava/util/Map;
    //   113: aload_1
    //   114: aload 6
    //   116: invokeinterface 128 3 0
    //   121: pop
    //   122: aload_0
    //   123: monitorexit
    //   124: return
    //   125: astore_1
    //   126: aload_1
    //   127: invokevirtual 131	java/lang/IllegalMonitorStateException:printStackTrace	()V
    //   130: aload_0
    //   131: monitorexit
    //   132: return
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	qg
    //   0	138	1	paramString	String
    //   0	138	2	paramqe	qe
    //   0	138	3	paramInt	int
    //   47	29	4	local1	qg.1
    //   60	29	5	localFuture	Future
    //   71	44	6	locala	qg.a
    // Exception table:
    //   from	to	target	type
    //   24	109	125	java/lang/IllegalMonitorStateException
    //   109	122	125	java/lang/IllegalMonitorStateException
    //   9	24	133	finally
    //   24	109	133	finally
    //   109	122	133	finally
    //   126	130	133	finally
  }
  
  final void a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (this.c.isEmpty()) {
      return;
    }
    if (this.d == null) {
      this.d = Executors.newSingleThreadExecutor();
    }
    if (!this.d.isShutdown()) {
      this.d.execute(new qg.2(this, paramBoolean, paramString, paramArrayOfByte));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.qg
 * JD-Core Version:    0.7.0.1
 */