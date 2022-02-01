package com.tencent.imcore.message;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import java.util.ArrayList;

class BaseMessageManagerForTroopAndDisc$2
  implements Runnable
{
  BaseMessageManagerForTroopAndDisc$2(BaseMessageManagerForTroopAndDisc paramBaseMessageManagerForTroopAndDisc, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = (TroopHandler)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localObject != null)
    {
      localObject = ((TroopHandler)localObject).a();
      if (localObject != null) {
        ((TroopBatchAddFriendMgr)localObject).a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.2
 * JD-Core Version:    0.7.0.1
 */