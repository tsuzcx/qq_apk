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
  
  boolean a()
  {
    return a(0L);
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
    //   15: invokevirtual 25	java/lang/Object:wait	(J)V
    //   18: aload_0
    //   19: monitorexit
    //   20: iconst_1
    //   21: ireturn
    //   22: astore_3
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_3
    //   26: athrow
    //   27: astore_3
    //   28: aload_3
    //   29: invokevirtual 28	java/lang/InterruptedException:printStackTrace	()V
    //   32: aload_0
    //   33: monitorexit
    //   34: iconst_0
    //   35: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	Signal
    //   0	36	1	paramLong	long
    //   22	4	3	localObject	Object
    //   27	2	3	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	11	22	finally
    //   13	18	22	finally
    //   18	20	22	finally
    //   23	25	22	finally
    //   28	34	22	finally
    //   13	18	27	java/lang/InterruptedException
  }
  
  void b()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.roam.C2CRoamMsgFetcher.Signal
 * JD-Core Version:    0.7.0.1
 */