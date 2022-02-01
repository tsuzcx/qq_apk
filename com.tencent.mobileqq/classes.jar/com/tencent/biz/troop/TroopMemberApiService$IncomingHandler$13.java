package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.common.api.ITweetTopicEntranceShouldShowActionUtil;
import com.tencent.mobileqq.kandian.repo.account.IUserLevelCallBack;
import com.tencent.mobileqq.kandian.repo.account.UserLevelInfo;
import com.tencent.mobileqq.qroute.QRoute;

class TroopMemberApiService$IncomingHandler$13
  implements IUserLevelCallBack
{
  TroopMemberApiService$IncomingHandler$13(TroopMemberApiService.IncomingHandler paramIncomingHandler, Bundle paramBundle) {}
  
  public void a(UserLevelInfo paramUserLevelInfo)
  {
    if (paramUserLevelInfo.dailyTopicNum > 0L)
    {
      TroopMemberApiService.IncomingHandler.a(this.b, 160, this.a, 1, "success");
      ((ITweetTopicEntranceShouldShowActionUtil)QRoute.api(ITweetTopicEntranceShouldShowActionUtil.class)).doShowEntranceReport();
      return;
    }
    TroopMemberApiService.IncomingHandler.a(this.b, 160, this.a, 2, HardCodeUtil.a(2131905680));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.13
 * JD-Core Version:    0.7.0.1
 */