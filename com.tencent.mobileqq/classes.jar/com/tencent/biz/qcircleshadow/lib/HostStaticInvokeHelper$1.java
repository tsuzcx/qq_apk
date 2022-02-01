package com.tencent.biz.qcircleshadow.lib;

import com.tencent.mobileqq.observer.LoginVerifyObserver;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.tempapi.interfaces.AccountIdentityCallBack;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.AuthTips;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;

final class HostStaticInvokeHelper$1
  extends LoginVerifyObserver
{
  HostStaticInvokeHelper$1(AccountIdentityCallBack paramAccountIdentityCallBack) {}
  
  public void getAccountIdentitySuccess(cmd0x9ae.RspBody paramRspBody)
  {
    if (paramRspBody != null)
    {
      boolean bool = paramRspBody.bool_has_been_authenticated.get();
      paramRspBody = paramRspBody.msg_auth_tips.string_tips_action_url.get();
      this.val$callBack.onSuccess(bool, paramRspBody);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper.1
 * JD-Core Version:    0.7.0.1
 */