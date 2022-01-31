package com.tencent.mobileqq.app.message;

import ajtg;
import akab;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import java.util.ArrayList;

public class BaseMessageManagerForTroopAndDisc$2
  implements Runnable
{
  public BaseMessageManagerForTroopAndDisc$2(akab paramakab, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = (ajtg)this.this$0.a.a(20);
    if (localObject != null)
    {
      localObject = ((ajtg)localObject).a();
      if (localObject != null) {
        ((TroopBatchAddFriendMgr)localObject).a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.BaseMessageManagerForTroopAndDisc.2
 * JD-Core Version:    0.7.0.1
 */