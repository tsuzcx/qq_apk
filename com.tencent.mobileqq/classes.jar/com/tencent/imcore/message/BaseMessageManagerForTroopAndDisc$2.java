package com.tencent.imcore.message;

import acmd;
import aoep;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import java.util.ArrayList;

public class BaseMessageManagerForTroopAndDisc$2
  implements Runnable
{
  public BaseMessageManagerForTroopAndDisc$2(acmd paramacmd, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = (aoep)this.this$0.a.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    if (localObject != null)
    {
      localObject = ((aoep)localObject).a();
      if (localObject != null) {
        ((TroopBatchAddFriendMgr)localObject).a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.2
 * JD-Core Version:    0.7.0.1
 */