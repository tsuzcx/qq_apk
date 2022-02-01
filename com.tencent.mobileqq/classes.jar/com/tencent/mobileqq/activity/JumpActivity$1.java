package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.parser.JumpActivityHelper;
import com.tencent.mobileqq.app.parser.tempapi.IQJumpApi;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.observer.WtloginObserver;
import oicq.wlogin_sdk.devicelock.DevlockInfo;
import oicq.wlogin_sdk.request.WUserSigInfo;
import oicq.wlogin_sdk.tools.ErrMsg;

class JumpActivity$1
  extends WtloginObserver
{
  JumpActivity$1(JumpActivity paramJumpActivity) {}
  
  public void onCheckDevLockStatus(WUserSigInfo paramWUserSigInfo, DevlockInfo paramDevlockInfo, int paramInt, ErrMsg paramErrMsg)
  {
    if (paramDevlockInfo != null) {
      ((IQJumpApi)QRoute.api(IQJumpApi.class)).devlockUpdate(paramDevlockInfo.TransferInfo);
    }
    paramWUserSigInfo = this.a;
    if (paramInt != 0) {
      paramDevlockInfo = null;
    }
    JumpActivityHelper.a(paramWUserSigInfo, paramDevlockInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JumpActivity.1
 * JD-Core Version:    0.7.0.1
 */