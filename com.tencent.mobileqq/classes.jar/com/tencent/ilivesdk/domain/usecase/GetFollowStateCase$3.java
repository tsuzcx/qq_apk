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
    LogInterface localLogInterface = GetFollowStateCase.access$300(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onQueryFollowFail:");
    localStringBuilder.append(paramString);
    localLogInterface.e("AudAnchorInfoModule", localStringBuilder.toString(), new Object[0]);
  }
  
  public void onQueryFollowSuccess(QueryFollowRspModel paramQueryFollowRspModel)
  {
    LogInterface localLogInterface = GetFollowStateCase.access$300(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFollowUserSuccess targetUid:");
    localStringBuilder.append(this.val$targetUid.toString());
    localStringBuilder.append(" isFollow:");
    localStringBuilder.append(paramQueryFollowRspModel.isFans);
    localStringBuilder.append(" ret:");
    localStringBuilder.append(paramQueryFollowRspModel.ret);
    localLogInterface.i("AudAnchorInfoModule", localStringBuilder.toString(), new Object[0]);
    if (paramQueryFollowRspModel.ret != 0) {
      return;
    }
    GetFollowStateCase.access$400(this.this$0, Boolean.valueOf(paramQueryFollowRspModel.isFans));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.usecase.GetFollowStateCase.3
 * JD-Core Version:    0.7.0.1
 */