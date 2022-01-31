package com.tencent.mobileqq.activity.aio.item;

import aukn;

public final class TroopGiftMsgItemBuilder$7
  implements Runnable
{
  public TroopGiftMsgItemBuilder$7(aukn paramaukn) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 12	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$7:a	Laukn;
    //   4: invokevirtual 24	aukn:a	()Laukp;
    //   7: astore_1
    //   8: aload_1
    //   9: invokevirtual 28	aukp:a	()V
    //   12: getstatic 33	aedl:a	Ljava/util/List;
    //   15: invokeinterface 39 1 0
    //   20: astore_2
    //   21: aload_2
    //   22: invokeinterface 45 1 0
    //   27: ifeq +39 -> 66
    //   30: aload_2
    //   31: invokeinterface 49 1 0
    //   36: checkcast 51	com/tencent/mobileqq/data/MessageForTroopGift
    //   39: astore_3
    //   40: aload_0
    //   41: getfield 12	com/tencent/mobileqq/activity/aio/item/TroopGiftMsgItemBuilder$7:a	Laukn;
    //   44: aload_3
    //   45: invokevirtual 54	aukn:a	(Laukm;)Z
    //   48: pop
    //   49: goto -28 -> 21
    //   52: astore_2
    //   53: aload_1
    //   54: invokevirtual 57	aukp:b	()V
    //   57: getstatic 33	aedl:a	Ljava/util/List;
    //   60: invokeinterface 60 1 0
    //   65: return
    //   66: aload_1
    //   67: invokevirtual 63	aukp:c	()V
    //   70: aload_1
    //   71: invokevirtual 57	aukp:b	()V
    //   74: goto -17 -> 57
    //   77: astore_2
    //   78: aload_1
    //   79: invokevirtual 57	aukp:b	()V
    //   82: aload_2
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	7
    //   7	72	1	localaukp	aukp
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */