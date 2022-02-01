package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.recommend.api.ITroopRecommendHandler;
import com.tencent.mobileqq.troop.troopfriend.api.ITroopBatchAddFriendService;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.mobileqq.utils.TroopRecommendUtils;
import com.tencent.qphone.base.util.QLog;

class TroopAddFriendTipsHelper$1
  implements Runnable
{
  TroopAddFriendTipsHelper$1(TroopAddFriendTipsHelper paramTroopAddFriendTipsHelper, String paramString) {}
  
  public void run()
  {
    Object localObject = ((ITroopBatchAddFriendService)TroopAddFriendTipsHelper.a(this.this$0).getRuntimeService(ITroopBatchAddFriendService.class, "")).getTroopBatchAddFriendMgr();
    ((TroopBatchAddFriendMgr)localObject).a(this.a, 0);
    ((TroopBatchAddFriendMgr)localObject).a(this.a, null, 1);
    ((TroopBatchAddFriendMgr)localObject).e(this.a);
    long l1 = TroopRecommendUtils.c(TroopAddFriendTipsHelper.a(this.this$0), this.a);
    if (l1 <= 0L)
    {
      TroopRecommendUtils.b(TroopAddFriendTipsHelper.a(this.this$0), this.a, 5L);
      return;
    }
    long l2 = NetConnInfoCenter.getServerTime() - l1;
    if (l2 > 0L) {
      ((ITroopRecommendHandler)TroopAddFriendTipsHelper.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.TROOP_RECOMMEND_HANDLER)).a(this.a, 1, 0);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("check recommend gray time ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(l1);
      QLog.i("TroopAddFriendTipsHelper", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.1
 * JD-Core Version:    0.7.0.1
 */