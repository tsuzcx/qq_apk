package com.tencent.mobileqq.ark.dict;

import android.os.Handler;

final class ArkRecommendLogic$ArkWordSegmentThread$BlockingRunnable
  implements Runnable
{
  private final Runnable a;
  private final ArkRecommendLogic.ArkWordSegmentThread b;
  private volatile boolean c = false;
  
  public ArkRecommendLogic$ArkWordSegmentThread$BlockingRunnable(ArkRecommendLogic.ArkWordSegmentThread paramArkWordSegmentThread, Runnable paramRunnable)
  {
    this.a = paramRunnable;
    this.b = paramArkWordSegmentThread;
  }
  
  public void a()
  {
    try
    {
      this.b.a().post(this);
      for (;;)
      {
        boolean bool = this.c;
        if (!bool) {}
        try
        {
          wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
      return;
    }
    finally
    {
      for (;;)
      {
        for (;;)
        {
          throw localObject;
        }
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 21	com/tencent/mobileqq/ark/dict/ArkRecommendLogic$ArkWordSegmentThread$BlockingRunnable:a	Ljava/lang/Runnable;
    //   4: invokeinterface 43 1 0
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: iconst_1
    //   13: putfield 19	com/tencent/mobileqq/ark/dict/ArkRecommendLogic$ArkWordSegmentThread$BlockingRunnable:c	Z
    //   16: aload_0
    //   17: invokevirtual 46	java/lang/Object:notifyAll	()V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: astore_1
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_1
    //   27: athrow
    //   28: astore_1
    //   29: aload_0
    //   30: monitorenter
    //   31: aload_0
    //   32: iconst_1
    //   33: putfield 19	com/tencent/mobileqq/ark/dict/ArkRecommendLogic$ArkWordSegmentThread$BlockingRunnable:c	Z
    //   36: aload_0
    //   37: invokevirtual 46	java/lang/Object:notifyAll	()V
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	BlockingRunnable
    //   23	4	1	localObject1	Object
    //   28	15	1	localObject2	Object
    //   44	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	22	23	finally
    //   24	26	23	finally
    //   0	9	28	finally
    //   31	42	44	finally
    //   45	47	44	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkRecommendLogic.ArkWordSegmentThread.BlockingRunnable
 * JD-Core Version:    0.7.0.1
 */