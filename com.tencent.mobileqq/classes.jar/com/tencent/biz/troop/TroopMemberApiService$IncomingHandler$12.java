package com.tencent.biz.troop;

import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule.UserLevelCallBack;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelRequestModule.UserLevelInfo;
import com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction.TweetTopicEntranceShouldShowAction;
import com.tencent.biz.pubaccount.readinjoy.plugin.jsMethodAction.TweetTopicEntranceShouldShowAction.Companion;
import com.tencent.mobileqq.app.HardCodeUtil;

class TroopMemberApiService$IncomingHandler$12
  implements RIJUserLevelModule.UserLevelCallBack
{
  TroopMemberApiService$IncomingHandler$12(TroopMemberApiService.IncomingHandler paramIncomingHandler, Bundle paramBundle) {}
  
  public void a(RIJUserLevelRequestModule.UserLevelInfo paramUserLevelInfo)
  {
    if (paramUserLevelInfo.dailyTopicNum > 0L)
    {
      TroopMemberApiService.IncomingHandler.a(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler, 160, this.jdField_a_of_type_AndroidOsBundle, 1, "success");
      TweetTopicEntranceShouldShowAction.a.a();
      return;
    }
    TroopMemberApiService.IncomingHandler.a(this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiService$IncomingHandler, 160, this.jdField_a_of_type_AndroidOsBundle, 2, HardCodeUtil.a(2131707843));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.TroopMemberApiService.IncomingHandler.12
 * JD-Core Version:    0.7.0.1
 */