package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import java.util.Iterator;
import java.util.List;

final class TroopGiftMsgItemBuilder$8
  implements Runnable
{
  TroopGiftMsgItemBuilder$8(EntityManager paramEntityManager) {}
  
  public void run()
  {
    EntityTransaction localEntityTransaction = this.a.getTransaction();
    try
    {
      try
      {
        localEntityTransaction.begin();
        Iterator localIterator = TroopGiftMsgItemBuilder.a.iterator();
        while (localIterator.hasNext())
        {
          MessageForTroopGift localMessageForTroopGift = (MessageForTroopGift)localIterator.next();
          this.a.update(localMessageForTroopGift);
        }
      }
      finally
      {
        localEntityTransaction.end();
      }
    }
    catch (Exception localException)
    {
      label66:
      break label66;
    }
    localEntityTransaction.end();
    TroopGiftMsgItemBuilder.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */