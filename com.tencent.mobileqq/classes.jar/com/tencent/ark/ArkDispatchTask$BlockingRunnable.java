package com.tencent.ark;

import android.os.Handler;

public final class ArkDispatchTask$BlockingRunnable
  implements Runnable
{
  private volatile boolean mDone = false;
  private final Runnable mTask;
  
  public ArkDispatchTask$BlockingRunnable(Runnable paramRunnable)
  {
    this.mTask = paramRunnable;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 19	com/tencent/ark/ArkDispatchTask$BlockingRunnable:mTask	Ljava/lang/Runnable;
    //   4: invokeinterface 23 1 0
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: iconst_1
    //   13: putfield 17	com/tencent/ark/ArkDispatchTask$BlockingRunnable:mDone	Z
    //   16: aload_0
    //   17: invokevirtual 26	java/lang/Object:notifyAll	()V
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
    //   33: putfield 17	com/tencent/ark/ArkDispatchTask$BlockingRunnable:mDone	Z
    //   36: aload_0
    //   37: invokevirtual 26	java/lang/Object:notifyAll	()V
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
  
  public boolean send(Handler paramHandler)
  {
    try
    {
      if (!ArkDispatchTask.postImpl(paramHandler, this, 0L)) {
        return false;
      }
      for (;;)
      {
        boolean bool = this.mDone;
        if (bool) {
          break;
        }
        try
        {
          wait();
        }
        catch (InterruptedException paramHandler)
        {
          ArkDispatchTask.ENV.logD("ArkApp.DispatchTask", "DispatchTask.exception: " + paramHandler.getLocalizedMessage());
        }
      }
    }
    finally {}
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.ark.ArkDispatchTask.BlockingRunnable
 * JD-Core Version:    0.7.0.1
 */