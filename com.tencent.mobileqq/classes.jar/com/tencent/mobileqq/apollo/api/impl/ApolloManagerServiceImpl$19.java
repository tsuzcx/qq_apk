package com.tencent.mobileqq.apollo.api.impl;

class ApolloManagerServiceImpl$19
  implements Runnable
{
  ApolloManagerServiceImpl$19(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl$19:this$0	Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;
    //   4: invokestatic 25	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:access$1400	(Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: astore_3
    //   8: aload_3
    //   9: ifnonnull +4 -> 13
    //   12: return
    //   13: aload_3
    //   14: invokevirtual 31	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   17: astore_1
    //   18: aload_1
    //   19: invokevirtual 36	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   22: aload_0
    //   23: getfield 12	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl$19:this$0	Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;
    //   26: invokestatic 40	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:access$1200	(Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;)Ljava/lang/Object;
    //   29: astore_2
    //   30: aload_2
    //   31: monitorenter
    //   32: aload_0
    //   33: getfield 12	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl$19:this$0	Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;
    //   36: invokestatic 44	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:access$1300	(Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;)Ljava/util/List;
    //   39: ifnull +155 -> 194
    //   42: new 46	java/util/ArrayList
    //   45: dup
    //   46: invokespecial 47	java/util/ArrayList:<init>	()V
    //   49: astore 4
    //   51: aload_0
    //   52: getfield 12	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl$19:this$0	Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;
    //   55: invokestatic 44	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:access$1300	(Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;)Ljava/util/List;
    //   58: invokeinterface 53 1 0
    //   63: astore 5
    //   65: aload 5
    //   67: invokeinterface 59 1 0
    //   72: ifeq +56 -> 128
    //   75: aload 5
    //   77: invokeinterface 63 1 0
    //   82: checkcast 65	com/tencent/mobileqq/DrawerPushItem
    //   85: astore 6
    //   87: aload 6
    //   89: getfield 69	com/tencent/mobileqq/DrawerPushItem:is_reddot	I
    //   92: ifne -27 -> 65
    //   95: aload 4
    //   97: aload 6
    //   99: invokeinterface 73 2 0
    //   104: pop
    //   105: goto -40 -> 65
    //   108: astore_3
    //   109: aload_2
    //   110: monitorexit
    //   111: aload_3
    //   112: athrow
    //   113: astore_2
    //   114: ldc 75
    //   116: iconst_1
    //   117: ldc 77
    //   119: aload_2
    //   120: invokestatic 83	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   123: aload_1
    //   124: invokevirtual 86	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   127: return
    //   128: aload 4
    //   130: invokeinterface 90 1 0
    //   135: ifle +59 -> 194
    //   138: aload 4
    //   140: invokeinterface 53 1 0
    //   145: astore 4
    //   147: aload 4
    //   149: invokeinterface 59 1 0
    //   154: ifeq +40 -> 194
    //   157: aload 4
    //   159: invokeinterface 63 1 0
    //   164: checkcast 65	com/tencent/mobileqq/DrawerPushItem
    //   167: astore 5
    //   169: aload_0
    //   170: getfield 12	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl$19:this$0	Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;
    //   173: invokestatic 44	com/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl:access$1300	(Lcom/tencent/mobileqq/apollo/api/impl/ApolloManagerServiceImpl;)Ljava/util/List;
    //   176: aload 5
    //   178: invokeinterface 93 2 0
    //   183: pop
    //   184: aload_3
    //   185: aload 5
    //   187: invokevirtual 96	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   190: pop
    //   191: goto -44 -> 147
    //   194: aload_2
    //   195: monitorexit
    //   196: aload_1
    //   197: invokevirtual 99	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   200: aload_1
    //   201: invokevirtual 86	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   204: return
    //   205: astore_2
    //   206: aload_1
    //   207: invokevirtual 86	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   210: aload_2
    //   211: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	212	0	this	19
    //   17	190	1	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   113	82	2	localException	java.lang.Exception
    //   205	6	2	localObject2	Object
    //   7	7	3	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   108	77	3	localObject3	Object
    //   49	109	4	localObject4	Object
    //   63	123	5	localObject5	Object
    //   85	13	6	localDrawerPushItem	com.tencent.mobileqq.DrawerPushItem
    // Exception table:
    //   from	to	target	type
    //   32	65	108	finally
    //   65	105	108	finally
    //   109	111	108	finally
    //   128	147	108	finally
    //   147	191	108	finally
    //   194	196	108	finally
    //   18	32	113	java/lang/Exception
    //   111	113	113	java/lang/Exception
    //   196	200	113	java/lang/Exception
    //   18	32	205	finally
    //   111	113	205	finally
    //   114	123	205	finally
    //   196	200	205	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.19
 * JD-Core Version:    0.7.0.1
 */