package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;

class TroopAddFriendTipsHelper$NewMsgRunnable
  implements Runnable
{
  private volatile String a;
  
  private TroopAddFriendTipsHelper$NewMsgRunnable(TroopAddFriendTipsHelper paramTroopAddFriendTipsHelper) {}
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void run()
  {
    ((ITroopBatchAddFriendService)TroopAddFriendTipsHelper.a(this.this$0).getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr().a(this.a, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.NewMsgRunnable
 * JD-Core Version:    0.7.0.1
 */