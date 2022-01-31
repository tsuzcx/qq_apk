package com.tencent.mobileqq.activity.aio.helper;

import adjl;
import akhp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;

public class TroopAddFriendTipsHelper$1
  implements Runnable
{
  public TroopAddFriendTipsHelper$1(adjl paramadjl, String paramString) {}
  
  public void run()
  {
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((akhp)adjl.a(this.this$0).a(20)).a();
    localTroopBatchAddFriendMgr.c(this.a);
    localTroopBatchAddFriendMgr.a(this.a, null, 1);
    localTroopBatchAddFriendMgr.f(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.1
 * JD-Core Version:    0.7.0.1
 */