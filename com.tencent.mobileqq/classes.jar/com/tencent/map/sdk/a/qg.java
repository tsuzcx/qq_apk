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
    if (this.b != null)
    {
      this.b.shutdown();
      this.b = null;
    }
    if (this.d != null)
    {
      this.d.shutdown();
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
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 24	com/tencent/map/sdk/a/qg:a	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 58 2 0
    //   12: checkcast 60	com/tencent/map/sdk/a/qg$a
    //   15: astore_1
    //   16: aload_1
    //   17: ifnull +24 -> 41
    //   20: aload_1
    //   21: getfield 63	com/tencent/map/sdk/a/qg$a:d	I
    //   24: ifeq +17 -> 41
    //   27: aload_1
    //   28: getfield 63	com/tencent/map/sdk/a/qg$a:d	I
    //   31: istore_2
    //   32: getstatic 67	com/tencent/map/sdk/a/qg$b:b	I
    //   35: istore_3
    //   36: iload_2
    //   37: iload_3
    //   38: if_icmpne +6 -> 44
    //   41: aload_0
    //   42: monitorexit
    //   43: return
    //   44: aload_1
    //   45: getfield 70	com/tencent/map/sdk/a/qg$a:b	Ljava/util/concurrent/Future;
    //   48: ifnull +14 -> 62
    //   51: aload_1
    //   52: getfield 70	com/tencent/map/sdk/a/qg$a:b	Ljava/util/concurrent/Future;
    //   55: iconst_1
    //   56: invokeinterface 76 2 0
    //   61: pop
    //   62: aload_1
    //   63: getfield 78	com/tencent/map/sdk/a/qg$a:c	Lcom/tencent/map/sdk/a/qe;
    //   66: ifnull +10 -> 76
    //   69: aload_1
    //   70: getfield 78	com/tencent/map/sdk/a/qg$a:c	Lcom/tencent/map/sdk/a/qe;
    //   73: invokevirtual 82	com/tencent/map/sdk/a/qe:b	()V
    //   76: aload_1
    //   77: getstatic 84	com/tencent/map/sdk/a/qg$b:c	I
    //   80: putfield 63	com/tencent/map/sdk/a/qg$a:d	I
    //   83: goto -42 -> 41
    //   86: astore_1
    //   87: aload_0
    //   88: monitorexit
    //   89: aload_1
    //   90: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	qg
    //   0	91	1	paramString	String
    //   31	8	2	i	int
    //   35	4	3	j	int
    // Exception table:
    //   from	to	target	type
    //   2	16	86	finally
    //   20	36	86	finally
    //   44	62	86	finally
    //   62	76	86	finally
    //   76	83	86	finally
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
  
  public final void a(String paramString, qe paramqe, int paramInt)
  {
    if (paramqe == null) {}
    for (;;)
    {
      return;
      try
      {
        if (this.b == null) {
          this.b = Executors.newFixedThreadPool(5);
        }
        try
        {
          if (this.b.isShutdown()) {
            continue;
          }
          qg.1 local1 = new qg.1(this, paramString, paramqe, paramInt);
          Future localFuture = this.b.submit(local1);
          qg.a locala = new qg.a(this, (byte)0);
          locala.a = local1;
          locala.c = paramqe;
          locala.b = localFuture;
          if (locala.d == 0) {
            locala.d = qg.b.a;
          }
          this.a.put(paramString, locala);
        }
        catch (IllegalMonitorStateException paramString)
        {
          paramString.printStackTrace();
        }
      }
      finally {}
    }
  }
  
  final void a(String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    if (this.c.isEmpty()) {}
    do
    {
      return;
      if (this.d == null) {
        this.d = Executors.newSingleThreadExecutor();
      }
    } while (this.d.isShutdown());
    this.d.execute(new qg.2(this, paramBoolean, paramString, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.sdk.a.qg
 * JD-Core Version:    0.7.0.1
 */