package com.tencent.mobileqq.activity.aio.roam;

class C2CRoamMsgFetcher$Signal
{
  boolean a;
  
  void a()
  {
    try
    {
      this.a = false;
      return;
    }
    finally {}
  }
  
  /* Error */
  boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 15	com/tencent/mobileqq/activity/aio/roam/C2CRoamMsgFetcher$Signal:a	Z
    //   6: ifeq +7 -> 13
    //   9: aload_0
    //   10: monitorexit
    //   11: iconst_1
    //   12: ireturn
    //   13: aload_0
    //   14: lload_1
    //   15: invokevirtual 22	java/lang/Object:wait	(J)V
    //   18: aload_0
    //   19: monitorexit
    //   20: iconst_1
    //   21: ireturn
    //   22: astore_3
    //   23: aload_3
    //   24: invokevirtual 25	java/lang/InterruptedException:printStackTrace	()V
    //   27: aload_0
    //   28: monitorexit
    //   29: iconst_0
    //   30: ireturn
    //   31: astore_3
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_3
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	Signal
    //   0	36	1	paramLong	long
    //   22	2	3	localInterruptedException	java.lang.InterruptedException
    //   31	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   13	18	22	java/lang/InterruptedException
    //   2	11	31	finally
    //   13	18	31	finally
    //   18	20	31	finally
    //   23	29	31	finally
    //   32	34	31	finally
  }
  
  boolean b()
  {
    return a(0L);
  }
  
  void c()
  {
    try
    {
      this.a = true;
      notify();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.roam.C2CRoamMsgFetcher.Signal
 * JD-Core Version:    0.7.0.1
 */