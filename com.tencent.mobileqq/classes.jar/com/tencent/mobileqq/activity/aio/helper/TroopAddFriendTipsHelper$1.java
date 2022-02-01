package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.QLog;

class TroopAddFriendTipsHelper$1
  implements Runnable
{
  TroopAddFriendTipsHelper$1(TroopAddFriendTipsHelper paramTroopAddFriendTipsHelper, String paramString) {}
  
  public void run()
  {
    TroopHandler localTroopHandler = (TroopHandler)TroopAddFriendTipsHelper.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = localTroopHandler.a();
    localTroopBatchAddFriendMgr.a(this.a, 0);
    localTroopBatchAddFriendMgr.a(this.a, null, 1);
    localTroopBatchAddFriendMgr.e(this.a);
    long l1 = TroopUtils.a(TroopAddFriendTipsHelper.a(this.this$0), this.a);
    if (l1 <= 0L) {
      TroopUtils.a(TroopAddFriendTipsHelper.a(this.this$0), this.a, 5L);
    }
    long l2;
    do
    {
      return;
      l2 = NetConnInfoCenter.getServerTime() - l1;
      if (l2 > 0L) {
        localTroopHandler.c(this.a, 1, 0);
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopAddFriendTipsHelper", 2, "check recommend gray time " + l2 + " " + l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.1
 * JD-Core Version:    0.7.0.1
 */