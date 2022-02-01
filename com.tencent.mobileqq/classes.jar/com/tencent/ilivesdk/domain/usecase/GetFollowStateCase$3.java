package com.tencent.ilivesdk.domain.usecase;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.domain.model.AnchorUidInfo;
import com.tencent.ilivesdk.minicardservice_interface.OnQueryFollowCallback;
import com.tencent.ilivesdk.minicardservice_interface.model.QueryFollowRspModel;

class GetFollowStateCase$3
  implements OnQueryFollowCallback
{
  GetFollowStateCase$3(GetFollowStateCase paramGetFollowStateCase, AnchorUidInfo paramAnchorUidInfo) {}
  
  public void onQueryFollowFail(String paramString)
  {
    GetFollowStateCase.access$300(this.this$0).e("AudAnchorInfoModule", "onQueryFollowFail:" + paramString, new Object[0]);
  }
  
  public void onQueryFollowSuccess(QueryFollowRspModel paramQueryFollowRspModel)
  {
    GetFollowStateCase.access$300(this.this$0).i("AudAnchorInfoModule", "onFollowUserSuccess targetUid:" + this.val$targetUid.toString() + " isFollow:" + paramQueryFollowRspModel.isFans + " ret:" + paramQueryFollowRspModel.ret, new Object[0]);
    if (paramQueryFollowRspModel.ret != 0) {
      return;
    }
    GetFollowStateCase.access$400(this.this$0, Boolean.valueOf(paramQueryFollowRspModel.isFans));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.usecase.GetFollowStateCase.3
 * JD-Core Version:    0.7.0.1
 */