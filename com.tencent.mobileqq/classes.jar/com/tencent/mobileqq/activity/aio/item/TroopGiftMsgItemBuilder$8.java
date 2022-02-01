package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.persistence.EntityManager;

public final class TroopGiftMsgItemBuilder$8
  implements Runnable
{
  public TroopGiftMsgItemBuilder$8(EntityManager paramEntityManager) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$8:a	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   4: invokevirtual 25	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   7: astore_1
    //   8: aload_1
    //   9: invokevirtual 30	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   12: getstatic 35	ahmb:a	Ljava/util/List;
    //   15: invokeinterface 41 1 0
    //   20: astore_2
    //   21: aload_2
    //   22: invokeinterface 47 1 0
    //   27: ifeq +39 -> 66
    //   30: aload_2
    //   31: invokeinterface 51 1 0
    //   36: checkcast 53	com/tencent/mobileqq/data/MessageForTroopGift
    //   39: astore_3
    //   40: aload_0
    //   41: getfield 12	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$8:a	Lcom/tencent/mobileqq/persistence/EntityManager;
    //   44: aload_3
    //   45: invokevirtual 57	com/tencent/mobileqq/persistence/EntityManager:update	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   48: pop
    //   49: goto -28 -> 21
    //   52: astore_2
    //   53: aload_1
    //   54: invokevirtual 60	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   57: getstatic 35	ahmb:a	Ljava/util/List;
    //   60: invokeinterface 63 1 0
    //   65: return
    //   66: aload_1
    //   67: invokevirtual 66	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   70: aload_1
    //   71: invokevirtual 60	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   74: goto -17 -> 57
    //   77: astore_2
    //   78: aload_1
    //   79: invokevirtual 60	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   82: aload_2
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	8
    //   7	72	1	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   20	11	2	localIterator	java.util.Iterator
    //   52	1	2	localException	java.lang.Exception
    //   77	6	2	localObject	Object
    //   39	6	3	localMessageForTroopGift	com.tencent.mobileqq.data.MessageForTroopGift
    // Exception table:
    //   from	to	target	type
    //   8	21	52	java/lang/Exception
    //   21	49	52	java/lang/Exception
    //   66	70	52	java/lang/Exception
    //   8	21	77	finally
    //   21	49	77	finally
    //   66	70	77	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */