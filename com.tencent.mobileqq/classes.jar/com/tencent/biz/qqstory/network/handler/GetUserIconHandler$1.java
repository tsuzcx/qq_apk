package com.tencent.biz.qqstory.network.handler;

final class GetUserIconHandler$1
  implements Runnable
{
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: ldc2_w 15
    //   3: invokestatic 22	java/lang/Thread:sleep	(J)V
    //   6: invokestatic 28	com/tencent/biz/qqstory/network/handler/GetUserIconHandler:a	()Ljava/util/ArrayList;
    //   9: astore_1
    //   10: aload_1
    //   11: monitorenter
    //   12: invokestatic 28	com/tencent/biz/qqstory/network/handler/GetUserIconHandler:a	()Ljava/util/ArrayList;
    //   15: invokevirtual 34	java/util/ArrayList:isEmpty	()Z
    //   18: ifne +32 -> 50
    //   21: new 30	java/util/ArrayList
    //   24: dup
    //   25: invokestatic 28	com/tencent/biz/qqstory/network/handler/GetUserIconHandler:a	()Ljava/util/ArrayList;
    //   28: invokespecial 37	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   31: astore_2
    //   32: invokestatic 28	com/tencent/biz/qqstory/network/handler/GetUserIconHandler:a	()Ljava/util/ArrayList;
    //   35: invokevirtual 40	java/util/ArrayList:clear	()V
    //   38: invokestatic 43	com/tencent/biz/qqstory/network/handler/GetUserIconHandler:a	()Ljava/util/Set;
    //   41: invokeinterface 46 1 0
    //   46: aload_2
    //   47: invokestatic 49	com/tencent/biz/qqstory/network/handler/GetUserIconHandler:a	(Ljava/util/ArrayList;)V
    //   50: aload_1
    //   51: monitorexit
    //   52: goto +17 -> 69
    //   55: astore_2
    //   56: aload_1
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    //   60: astore_1
    //   61: goto +13 -> 74
    //   64: astore_1
    //   65: aload_1
    //   66: invokevirtual 52	java/lang/InterruptedException:printStackTrace	()V
    //   69: iconst_0
    //   70: putstatic 55	com/tencent/biz/qqstory/network/handler/GetUserIconHandler:a	Z
    //   73: return
    //   74: iconst_0
    //   75: putstatic 55	com/tencent/biz/qqstory/network/handler/GetUserIconHandler:a	Z
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	1
    //   60	1	1	localObject1	Object
    //   64	15	1	localInterruptedException	java.lang.InterruptedException
    //   31	16	2	localArrayList2	java.util.ArrayList
    //   55	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	50	55	finally
    //   50	52	55	finally
    //   56	58	55	finally
    //   0	12	60	finally
    //   58	60	60	finally
    //   65	69	60	finally
    //   0	12	64	java/lang/InterruptedException
    //   58	60	64	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetUserIconHandler.1
 * JD-Core Version:    0.7.0.1
 */