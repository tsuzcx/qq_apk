package com.tencent.mobileqq.apollo.persistence.api.impl;

class ApolloDaoManagerServiceImpl$14
  implements Runnable
{
  ApolloDaoManagerServiceImpl$14(ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl$14:this$0	Lcom/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl;
    //   4: invokestatic 25	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:access$800	(Lcom/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   7: invokevirtual 31	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   10: astore_1
    //   11: aload_1
    //   12: invokevirtual 36	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   15: aload_0
    //   16: getfield 12	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl$14:this$0	Lcom/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl;
    //   19: invokestatic 40	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:access$600	(Lcom/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl;)Ljava/lang/Object;
    //   22: astore_2
    //   23: aload_2
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 12	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl$14:this$0	Lcom/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl;
    //   29: invokestatic 44	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:access$700	(Lcom/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl;)Ljava/util/List;
    //   32: ifnull +134 -> 166
    //   35: new 46	java/util/ArrayList
    //   38: dup
    //   39: invokespecial 47	java/util/ArrayList:<init>	()V
    //   42: astore_3
    //   43: aload_0
    //   44: getfield 12	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl$14:this$0	Lcom/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl;
    //   47: invokestatic 44	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:access$700	(Lcom/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl;)Ljava/util/List;
    //   50: invokeinterface 53 1 0
    //   55: astore 4
    //   57: aload 4
    //   59: invokeinterface 59 1 0
    //   64: ifeq +35 -> 99
    //   67: aload 4
    //   69: invokeinterface 63 1 0
    //   74: checkcast 65	com/tencent/mobileqq/DrawerPushItem
    //   77: astore 5
    //   79: aload 5
    //   81: getfield 69	com/tencent/mobileqq/DrawerPushItem:is_reddot	I
    //   84: ifne -27 -> 57
    //   87: aload_3
    //   88: aload 5
    //   90: invokeinterface 73 2 0
    //   95: pop
    //   96: goto -39 -> 57
    //   99: aload_3
    //   100: invokeinterface 77 1 0
    //   105: ifle +61 -> 166
    //   108: aload_3
    //   109: invokeinterface 53 1 0
    //   114: astore_3
    //   115: aload_3
    //   116: invokeinterface 59 1 0
    //   121: ifeq +45 -> 166
    //   124: aload_3
    //   125: invokeinterface 63 1 0
    //   130: checkcast 65	com/tencent/mobileqq/DrawerPushItem
    //   133: astore 4
    //   135: aload_0
    //   136: getfield 12	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl$14:this$0	Lcom/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl;
    //   139: invokestatic 44	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:access$700	(Lcom/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl;)Ljava/util/List;
    //   142: aload 4
    //   144: invokeinterface 80 2 0
    //   149: pop
    //   150: aload_0
    //   151: getfield 12	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl$14:this$0	Lcom/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl;
    //   154: invokestatic 25	com/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl:access$800	(Lcom/tencent/mobileqq/apollo/persistence/api/impl/ApolloDaoManagerServiceImpl;)Lcom/tencent/mobileqq/persistence/EntityManager;
    //   157: aload 4
    //   159: invokevirtual 83	com/tencent/mobileqq/persistence/EntityManager:remove	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   162: pop
    //   163: goto -48 -> 115
    //   166: aload_2
    //   167: monitorexit
    //   168: aload_1
    //   169: invokevirtual 86	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   172: goto +22 -> 194
    //   175: astore_3
    //   176: aload_2
    //   177: monitorexit
    //   178: aload_3
    //   179: athrow
    //   180: astore_2
    //   181: goto +18 -> 199
    //   184: astore_2
    //   185: ldc 88
    //   187: iconst_1
    //   188: ldc 90
    //   190: aload_2
    //   191: invokestatic 96	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   194: aload_1
    //   195: invokevirtual 99	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   198: return
    //   199: aload_1
    //   200: invokevirtual 99	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   203: goto +5 -> 208
    //   206: aload_2
    //   207: athrow
    //   208: goto -2 -> 206
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	14
    //   10	190	1	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   180	1	2	localObject2	Object
    //   184	23	2	localException	java.lang.Exception
    //   42	83	3	localObject3	Object
    //   175	4	3	localObject4	Object
    //   55	103	4	localObject5	Object
    //   77	12	5	localDrawerPushItem	com.tencent.mobileqq.DrawerPushItem
    // Exception table:
    //   from	to	target	type
    //   25	57	175	finally
    //   57	96	175	finally
    //   99	115	175	finally
    //   115	163	175	finally
    //   166	168	175	finally
    //   176	178	175	finally
    //   11	25	180	finally
    //   168	172	180	finally
    //   178	180	180	finally
    //   185	194	180	finally
    //   11	25	184	java/lang/Exception
    //   168	172	184	java/lang/Exception
    //   178	180	184	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl.14
 * JD-Core Version:    0.7.0.1
 */