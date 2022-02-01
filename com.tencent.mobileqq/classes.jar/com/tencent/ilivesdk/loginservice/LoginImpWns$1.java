package com.tencent.ilivesdk.loginservice;

import android.text.TextUtils;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginCallback;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceAdapter;
import com.tencent.falco.utils.HexUtil;
import com.tencent.falco.utils.TimeUtil;
import com.tencent.ilivesdk.loginservice.proto.nano.AccountBaseInfo;
import com.tencent.ilivesdk.loginservice.proto.nano.LoginReply;
import com.tencent.ilivesdk.loginservice.proto.nano.TicketInfo;

class LoginImpWns$1
  implements ChannelCallback
{
  LoginImpWns$1(LoginImpWns paramLoginImpWns, LoginCallback paramLoginCallback) {}
  
  public void onError(boolean paramBoolean, int paramInt, String paramString)
  {
    this.this$0.loginInfo = null;
    this.this$0.handleCallback(this.val$loginCallback, paramInt, "鉴权失败", null);
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = LoginReply.a(paramArrayOfByte);
      LoginInfo localLoginInfo = new LoginInfo();
      localLoginInfo.openId = this.this$0.accountId;
      localLoginInfo.access_token = this.this$0.authKey;
      localLoginInfo.businessUid = this.this$0.accountId;
      Object localObject = paramArrayOfByte.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoAccountBaseInfo;
      String str = ((AccountBaseInfo)localObject).jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(str)) {
        localLoginInfo.openId = str;
      }
      localLoginInfo.uid = ((AccountBaseInfo)localObject).jdField_a_of_type_Long;
      localLoginInfo.tinyid = ((AccountBaseInfo)localObject).b;
      localLoginInfo.loginType = this.this$0.mLoginType;
      localObject = paramArrayOfByte.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoTicketInfo;
      this.this$0.lastLoginTime = (TimeUtil.getCurrentMillis() / 1000L);
      localLoginInfo.a2 = HexUtil.hexStr2Bytes(((TicketInfo)localObject).jdField_a_of_type_JavaLangString);
      this.this$0.a2ExpireTime = ((TicketInfo)localObject).jdField_a_of_type_Int;
      localLoginInfo.configData = this.this$0.wrapConfigJson(paramArrayOfByte.jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue);
      this.this$0.loginServiceAdapter.getLog().v("LoginImpl", "lastLoginTime=" + this.this$0.lastLoginTime + "a2ExpireTime=" + this.this$0.a2ExpireTime + ", loginInfo=" + localLoginInfo.toString(), new Object[0]);
      this.this$0.loginInfo = localLoginInfo;
      this.this$0.handleCallback(this.val$loginCallback, 0, null, localLoginInfo.clone());
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      this.this$0.handleCallback(this.val$loginCallback, -1, paramArrayOfByte.getLocalizedMessage(), null);
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.LoginImpWns.1
 * JD-Core Version:    0.7.0.1
 */