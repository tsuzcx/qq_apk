package com.huawei.updatesdk.service.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class c$1
  implements a
{
  private final List<b> a = new ArrayList();
  
  public void a(int paramInt, com.huawei.updatesdk.a.b.c.b paramb)
  {
    synchronized (this.a)
    {
      Iterator localIterator = this.a.iterator();
      if (localIterator.hasNext()) {
        ((b)localIterator.next()).a(paramInt, paramb);
      }
    }
  }
  
  /* Error */
  public void a(b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 18	com/huawei/updatesdk/service/b/c$1:a	Ljava/util/List;
    //   4: astore_3
    //   5: aload_3
    //   6: monitorenter
    //   7: aload_1
    //   8: ifnonnull +6 -> 14
    //   11: aload_3
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 18	com/huawei/updatesdk/service/b/c$1:a	Ljava/util/List;
    //   18: aload_1
    //   19: invokeinterface 51 2 0
    //   24: istore_2
    //   25: iload_2
    //   26: ifne +14 -> 40
    //   29: aload_0
    //   30: getfield 18	com/huawei/updatesdk/service/b/c$1:a	Ljava/util/List;
    //   33: aload_1
    //   34: invokeinterface 54 2 0
    //   39: pop
    //   40: aload_3
    //   41: monitorexit
    //   42: return
    //   43: astore_1
    //   44: aload_3
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    //   48: astore_1
    //   49: ldc 56
    //   51: ldc 58
    //   53: invokestatic 64	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: goto -16 -> 40
    //   59: astore_1
    //   60: ldc 56
    //   62: ldc 66
    //   64: invokestatic 64	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: goto -27 -> 40
    //   70: astore_1
    //   71: ldc 56
    //   73: ldc 68
    //   75: invokestatic 64	com/huawei/updatesdk/a/a/b/a/a/a:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: goto -38 -> 40
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	1
    //   0	81	1	paramb	b
    //   24	2	2	bool	boolean
    //   4	41	3	localList	List
    // Exception table:
    //   from	to	target	type
    //   11	13	43	finally
    //   14	25	43	finally
    //   29	40	43	finally
    //   40	42	43	finally
    //   44	46	43	finally
    //   49	56	43	finally
    //   60	67	43	finally
    //   71	78	43	finally
    //   29	40	48	java/lang/UnsupportedOperationException
    //   29	40	59	java/lang/ClassCastException
    //   29	40	70	java/lang/IllegalArgumentException
  }
  
  public void b(b paramb)
  {
    synchronized (this.a)
    {
      try
      {
        this.a.remove(paramb);
        return;
      }
      catch (UnsupportedOperationException paramb)
      {
        for (;;)
        {
          com.huawei.updatesdk.a.a.b.a.a.a.d("InstallObserverManager", "unRegisterObserver UnsupportedOperationException");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.service.b.c.1
 * JD-Core Version:    0.7.0.1
 */