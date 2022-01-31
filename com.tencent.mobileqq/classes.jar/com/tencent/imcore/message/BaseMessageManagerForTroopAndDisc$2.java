package com.tencent.imcore.message;

import absl;
import amdu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import java.util.ArrayList;

public class BaseMessageManagerForTroopAndDisc$2
  implements Runnable
{
  public BaseMessageManagerForTroopAndDisc$2(absl paramabsl, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = (amdu)this.this$0.a.a(20);
    if (localObject != null)
    {
      localObject = ((amdu)localObject).a();
      if (localObject != null) {
        ((TroopBatchAddFriendMgr)localObject).a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManagerForTroopAndDisc.2
 * JD-Core Version:    0.7.0.1
 */