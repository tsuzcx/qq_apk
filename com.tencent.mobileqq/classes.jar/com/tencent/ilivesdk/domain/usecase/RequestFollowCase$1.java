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
    RequestFollowCase.access$600(this.this$0).i("RequestFollowCase", "onQueryFollowSuccess--onFollowUserFail--errMsg=" + paramString, new Object[0]);
    RequestFollowCase.access$700(this.this$0, new RequestFollowCase.ResponseValue(true, false));
  }
  
  public void onFollowUserSuccess(FollowUserRspModel paramFollowUserRspModel)
  {
    RequestFollowCase.access$000(this.this$0).i("MiniCardCreateProcessor", "onFollowUserSuccess uin:" + this.val$userUid.toString() + " ret:" + paramFollowUserRspModel.ret, new Object[0]);
    if (paramFollowUserRspModel.ret != 0L)
    {
      RequestFollowCase.access$100(this.this$0).i("RequestFollowCase", "onQueryFollowSuccess--onFollowUserFail--errMsg=" + paramFollowUserRspModel.msg, new Object[0]);
      RequestFollowCase.access$200(this.this$0, new RequestFollowCase.ResponseValue(true, false));
      return;
    }
    RequestFollowCase.access$300(this.this$0).i("RequestFollowCase", "onQueryFollowSuccess--onFollowUserSuccess--intentFollow=" + this.val$intentFollow, new Object[0]);
    RequestFollowCase.access$402(this.this$0, this.val$intentFollow);
    RequestFollowCase.access$500(this.this$0, new RequestFollowCase.ResponseValue(false, true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.domain.usecase.RequestFollowCase.1
 * JD-Core Version:    0.7.0.1
 */