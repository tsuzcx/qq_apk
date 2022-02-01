package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;

class TroopAddFriendTipsHelper$3
  implements Runnable
{
  TroopAddFriendTipsHelper$3(TroopAddFriendTipsHelper paramTroopAddFriendTipsHelper, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    ITroopBatchAddFriendService localITroopBatchAddFriendService = (ITroopBatchAddFriendService)TroopAddFriendTipsHelper.a(this.this$0).getRuntimeService(ITroopBatchAddFriendService.class, "");
    if (this.a)
    {
      localITroopBatchAddFriendService.getTroopBatchAddFriendMgr().o(this.b);
      return;
    }
    localITroopBatchAddFriendService.getTroopBatchAddFriendMgr().n(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.3
 * JD-Core Version:    0.7.0.1
 */