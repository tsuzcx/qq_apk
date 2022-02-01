package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.HotChatItemData;

class HotChatCenterManager$1
  implements Runnable
{
  HotChatCenterManager$1(HotChatCenterManager paramHotChatCenterManager, HotChatItemData paramHotChatItemData) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: aload_3
    //   6: astore_2
    //   7: aload 4
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 14	com/tencent/mobileqq/app/HotChatCenterManager$1:this$0	Lcom/tencent/mobileqq/app/HotChatCenterManager;
    //   14: invokevirtual 29	com/tencent/mobileqq/app/HotChatCenterManager:i	()Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: astore 5
    //   19: aload 5
    //   21: ifnonnull +28 -> 49
    //   24: aload_3
    //   25: astore_2
    //   26: aload 4
    //   28: astore_1
    //   29: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   32: ifeq +200 -> 232
    //   35: aload_3
    //   36: astore_2
    //   37: aload 4
    //   39: astore_1
    //   40: ldc 37
    //   42: iconst_2
    //   43: ldc 39
    //   45: invokestatic 43	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: return
    //   49: aload_3
    //   50: astore_2
    //   51: aload 4
    //   53: astore_1
    //   54: aload 5
    //   56: invokevirtual 49	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   59: invokevirtual 55	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   62: astore_3
    //   63: aload_3
    //   64: astore_2
    //   65: aload_3
    //   66: astore_1
    //   67: aload_0
    //   68: getfield 16	com/tencent/mobileqq/app/HotChatCenterManager$1:a	Lcom/tencent/mobileqq/data/HotChatItemData;
    //   71: invokevirtual 61	com/tencent/mobileqq/data/HotChatItemData:getStatus	()I
    //   74: sipush 1000
    //   77: if_icmpne +57 -> 134
    //   80: aload_3
    //   81: astore_2
    //   82: aload_3
    //   83: astore_1
    //   84: aload_3
    //   85: aload_0
    //   86: getfield 16	com/tencent/mobileqq/app/HotChatCenterManager$1:a	Lcom/tencent/mobileqq/data/HotChatItemData;
    //   89: invokevirtual 67	com/tencent/mobileqq/persistence/EntityManager:persist	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   92: aload_3
    //   93: astore_2
    //   94: aload_3
    //   95: astore_1
    //   96: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   99: ifeq +87 -> 186
    //   102: aload_3
    //   103: astore_2
    //   104: aload_3
    //   105: astore_1
    //   106: ldc 37
    //   108: iconst_2
    //   109: iconst_2
    //   110: anewarray 4	java/lang/Object
    //   113: dup
    //   114: iconst_0
    //   115: ldc 69
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload_0
    //   121: getfield 16	com/tencent/mobileqq/app/HotChatCenterManager$1:a	Lcom/tencent/mobileqq/data/HotChatItemData;
    //   124: getfield 73	com/tencent/mobileqq/data/HotChatItemData:mHotChatCode	Ljava/lang/String;
    //   127: aastore
    //   128: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   131: goto +55 -> 186
    //   134: aload_3
    //   135: astore_2
    //   136: aload_3
    //   137: astore_1
    //   138: aload_3
    //   139: aload_0
    //   140: getfield 16	com/tencent/mobileqq/app/HotChatCenterManager$1:a	Lcom/tencent/mobileqq/data/HotChatItemData;
    //   143: invokevirtual 80	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   146: pop
    //   147: aload_3
    //   148: astore_2
    //   149: aload_3
    //   150: astore_1
    //   151: invokestatic 35	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   154: ifeq +32 -> 186
    //   157: aload_3
    //   158: astore_2
    //   159: aload_3
    //   160: astore_1
    //   161: ldc 37
    //   163: iconst_2
    //   164: iconst_2
    //   165: anewarray 4	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: ldc 82
    //   172: aastore
    //   173: dup
    //   174: iconst_1
    //   175: aload_0
    //   176: getfield 16	com/tencent/mobileqq/app/HotChatCenterManager$1:a	Lcom/tencent/mobileqq/data/HotChatItemData;
    //   179: getfield 73	com/tencent/mobileqq/data/HotChatItemData:mHotChatCode	Ljava/lang/String;
    //   182: aastore
    //   183: invokestatic 76	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   186: aload_3
    //   187: ifnull +34 -> 221
    //   190: aload_3
    //   191: astore_1
    //   192: goto +25 -> 217
    //   195: astore_1
    //   196: goto +26 -> 222
    //   199: astore_3
    //   200: aload_1
    //   201: astore_2
    //   202: ldc 37
    //   204: iconst_1
    //   205: aload_3
    //   206: iconst_0
    //   207: anewarray 4	java/lang/Object
    //   210: invokestatic 86	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   213: aload_1
    //   214: ifnull +7 -> 221
    //   217: aload_1
    //   218: invokevirtual 89	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   221: return
    //   222: aload_2
    //   223: ifnull +7 -> 230
    //   226: aload_2
    //   227: invokevirtual 89	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   230: aload_1
    //   231: athrow
    //   232: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	1
    //   9	183	1	localObject1	Object
    //   195	36	1	localObject2	Object
    //   6	221	2	localObject3	Object
    //   4	187	3	localEntityManager	com.tencent.mobileqq.persistence.EntityManager
    //   199	7	3	localThrowable	java.lang.Throwable
    //   1	51	4	localObject4	Object
    //   17	38	5	localQQAppInterface	QQAppInterface
    // Exception table:
    //   from	to	target	type
    //   10	19	195	finally
    //   29	35	195	finally
    //   40	48	195	finally
    //   54	63	195	finally
    //   67	80	195	finally
    //   84	92	195	finally
    //   96	102	195	finally
    //   106	131	195	finally
    //   138	147	195	finally
    //   151	157	195	finally
    //   161	186	195	finally
    //   202	213	195	finally
    //   10	19	199	java/lang/Throwable
    //   29	35	199	java/lang/Throwable
    //   40	48	199	java/lang/Throwable
    //   54	63	199	java/lang/Throwable
    //   67	80	199	java/lang/Throwable
    //   84	92	199	java/lang/Throwable
    //   96	102	199	java/lang/Throwable
    //   106	131	199	java/lang/Throwable
    //   138	147	199	java/lang/Throwable
    //   151	157	199	java/lang/Throwable
    //   161	186	199	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.HotChatCenterManager.1
 * JD-Core Version:    0.7.0.1
 */