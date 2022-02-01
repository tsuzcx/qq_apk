package com.tencent.mobileqq.activity;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import tencent.im.login.GatewayVerify.PicVerifyInfo;
import tencent.im.login.GatewayVerify.ReqBindPhoneLogin;
import tencent.im.login.GatewayVerify.ReqBody;
import tencent.im.login.GatewayVerify.ReqCmd17;
import tencent.im.login.GatewayVerify.ReqPhoneSmsExtendLogin;

class LoginPhoneNumActivity$1
  extends MqqHandler
{
  LoginPhoneNumActivity$1(LoginPhoneNumActivity paramLoginPhoneNumActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2016: 
      QLog.d("LoginPhoneNumActivity", 1, "fangshuiqiang ticket return");
      Object localObject = (Bundle)paramMessage.obj;
      paramMessage = ((Bundle)localObject).getString("ticket", "");
      String str = ((Bundle)localObject).getString("randstr", "");
      localObject = ((Bundle)localObject).getString("appid", "0");
      GatewayVerify.ReqBody localReqBody = new GatewayVerify.ReqBody();
      localReqBody.msg_req_bind_phone_login.msg_pic_verify_info.bytes_verify_sig.set(ByteStringMicro.copyFromUtf8(paramMessage));
      localReqBody.msg_req_bind_phone_login.msg_pic_verify_info.bytes_rand_key.set(ByteStringMicro.copyFromUtf8(str));
      localReqBody.msg_req_bind_phone_login.msg_pic_verify_info.uint64_appid.set(Long.parseLong((String)localObject));
      localReqBody.msg_req_bind_phone_login.msg_pic_verify_info.setHasFlag(true);
      localReqBody.msg_req_bind_phone_login.setHasFlag(true);
      localReqBody.msg_req_cmd_17.msg_req_phone_sms_extend_login.uint32_support_flag.set(1);
      localReqBody.msg_req_cmd_17.msg_req_phone_sms_extend_login.setHasFlag(true);
      localReqBody.msg_req_cmd_17.str_mobile_phone.set(this.a.phoneNum);
      localReqBody.msg_req_cmd_17.uint32_country_code.set(Integer.parseInt(this.a.countryCode));
      localReqBody.msg_req_cmd_17.setHasFlag(true);
      localReqBody.setHasFlag(true);
      LoginPhoneNumActivity.access$002(this.a, localReqBody.toByteArray());
      LoginPhoneNumActivity.access$100(this.a);
      return;
    case 2015: 
      this.a.finish();
      return;
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginPhoneNumActivity.1
 * JD-Core Version:    0.7.0.1
 */