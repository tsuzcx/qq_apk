package com.tencent.ilivesdk.domain.usecase;

import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.domain.model.AnchorUidInfo;
import com.tencent.ilivesdk.minicardservice_interface.OnFollowUserCallback;
import com.tencent.ilivesdk.minicardservice_interface.model.FollowUserRspModel;

class RequestFollowCase$1
  implements OnFollowUserCallback
{
  RequestFollowCase$1(RequestFollowCase paramRequestFollowCase, AnchorUidInfo paramAnchorUidInfo, boolean paramBoolean) {}
  
  public void onFollowUserFail(String paramString)
  {
    LogInterface localLogInterface = RequestFollowCase.access$500(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onQueryFollowSuccess--onFollowUserFail--errMsg=");
    localStringBuilder.append(paramString);
    localLogInterface.i("RequestFollowCase", localStringBuilder.toString(), new Object[0]);
    RequestFollowCase.access$600(this.this$0, new RequestFollowCase.ResponseValue(true, false));
  }
  
  public void onFollowUserSuccess(FollowUserRspModel paramFollowUserRspModel)
  {
    LogInterface localLogInterface = RequestFollowCase.access$000(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFollowUserSuccess uin:");
    localStringBuilder.append(this.val$userUid.toString());
    localStringBuilder.append(" ret:");
    localStringBuilder.append(paramFollowUserRspModel.ret);
    localLogInterface.i("MiniCardCreateProcessor", localStringBuilder.toString(), new Object[0]);
    if (paramFollowUserRspModel.ret != 0L)
    {
      localLogInterface = RequestFollowCase.access$100(this.this$0);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onQueryFollowSuccess--onFollowUserFail--errMsg=");
      localStringBuilder.append(paramFollowUserRspModel.msg);
      localLogInterface.i("RequestFollowCase", localStringBuilder.toString(), new Object[0]);
      RequestFollowCase.access$200(this.this$0, new RequestFollowCase.ResponseValue(true, false));
      return;
    }
    localLogInterface = RequestFollowCase.access$300(this.this$0);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onQueryFollowSuccess--onFollowUserSuccess--intentFollow=");
    localStringBuilder.append(this.val$intentFollow);
    localLogInterface.i("RequestFollowCase", localStringBuilder.toString(), new Object[0]);
    RequestFollowCase.access$400(this.this$0, new RequestFollowCase.ResponseValue(false, paramFollowUserRspModel.isFans));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.usecase.RequestFollowCase.1
 * JD-Core Version:    0.7.0.1
 */