package com.tencent.biz.qqstory.network.handler;

public final class GetUserIconHandler$1
  implements Runnable
{
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc2_w 15
    //   3: invokestatic 22	java/lang/Thread:sleep	(J)V
    //   6: invokestatic 28	tkd:a	()Ljava/util/ArrayList;
    //   9: astore_1
    //   10: aload_1
    //   11: monitorenter
    //   12: invokestatic 28	tkd:a	()Ljava/util/ArrayList;
    //   15: invokevirtual 34	java/util/ArrayList:isEmpty	()Z
    //   18: ifne +32 -> 50
    //   21: new 30	java/util/ArrayList
    //   24: dup
    //   25: invokestatic 28	tkd:a	()Ljava/util/ArrayList;
    //   28: invokespecial 37	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   31: astore_2
    //   32: invokestatic 28	tkd:a	()Ljava/util/ArrayList;
    //   35: invokevirtual 40	java/util/ArrayList:clear	()V
    //   38: invokestatic 43	tkd:a	()Ljava/util/Set;
    //   41: invokeinterface 46 1 0
    //   46: aload_2
    //   47: invokestatic 49	tkd:a	(Ljava/util/ArrayList;)V
    //   50: aload_1
    //   51: monitorexit
    //   52: iconst_0
    //   53: putstatic 52	tkd:a	Z
    //   56: return
    //   57: astore_2
    //   58: aload_1
    //   59: monitorexit
    //   60: aload_2
    //   61: athrow
    //   62: astore_1
    //   63: aload_1
    //   64: invokevirtual 55	java/lang/InterruptedException:printStackTrace	()V
    //   67: iconst_0
    //   68: putstatic 52	tkd:a	Z
    //   71: return
    //   72: astore_1
    //   73: iconst_0
    //   74: putstatic 52	tkd:a	Z
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	1
    //   62	2	1	localInterruptedException	java.lang.InterruptedException
    //   72	6	1	localObject1	Object
    //   31	16	2	localArrayList2	java.util.ArrayList
    //   57	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	50	57	finally
    //   50	52	57	finally
    //   58	60	57	finally
    //   0	12	62	java/lang/InterruptedException
    //   60	62	62	java/lang/InterruptedException
    //   0	12	72	finally
    //   60	62	72	finally
    //   63	67	72	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserIconHandler.1
 * JD-Core Version:    0.7.0.1
 */