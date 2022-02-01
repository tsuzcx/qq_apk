package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import java.util.ArrayList;

class TroopAddFriendTipsHelper$2
  implements Runnable
{
  TroopAddFriendTipsHelper$2(TroopAddFriendTipsHelper paramTroopAddFriendTipsHelper, String paramString1, String paramString2) {}
  
  public void run()
  {
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((TroopHandler)TroopAddFriendTipsHelper.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.a);
    localTroopBatchAddFriendMgr.a(this.b, localArrayList, 4);
    localTroopBatchAddFriendMgr.d(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.2
 * JD-Core Version:    0.7.0.1
 */