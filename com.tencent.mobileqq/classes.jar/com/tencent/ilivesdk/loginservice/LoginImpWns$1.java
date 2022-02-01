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
    paramString = this.this$0;
    paramString.loginInfo = null;
    paramString.handleCallback(this.val$loginCallback, paramInt, "鉴权失败", null);
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject1 = LoginReply.a(paramArrayOfByte);
      paramArrayOfByte = new LoginInfo();
      paramArrayOfByte.openId = this.this$0.accountId;
      paramArrayOfByte.access_token = this.this$0.authKey;
      paramArrayOfByte.businessUid = this.this$0.accountId;
      Object localObject2 = ((LoginReply)localObject1).jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoAccountBaseInfo;
      String str = ((AccountBaseInfo)localObject2).jdField_a_of_type_JavaLangString;
      if (!TextUtils.isEmpty(str)) {
        paramArrayOfByte.openId = str;
      }
      paramArrayOfByte.uid = ((AccountBaseInfo)localObject2).jdField_a_of_type_Long;
      paramArrayOfByte.tinyid = ((AccountBaseInfo)localObject2).b;
      paramArrayOfByte.loginType = this.this$0.mLoginType;
      localObject2 = ((LoginReply)localObject1).jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoTicketInfo;
      this.this$0.lastLoginTime = (TimeUtil.getCurrentMillis() / 1000L);
      paramArrayOfByte.a2 = HexUtil.hexStr2Bytes(((TicketInfo)localObject2).jdField_a_of_type_JavaLangString);
      this.this$0.a2ExpireTime = ((TicketInfo)localObject2).jdField_a_of_type_Int;
      paramArrayOfByte.configData = this.this$0.wrapConfigJson(((LoginReply)localObject1).jdField_a_of_type_ComTencentIlivesdkLoginserviceProtoNanoConfigKeyValue);
      localObject1 = this.this$0.loginServiceAdapter.getLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("lastLoginTime=");
      ((StringBuilder)localObject2).append(this.this$0.lastLoginTime);
      ((StringBuilder)localObject2).append("a2ExpireTime=");
      ((StringBuilder)localObject2).append(this.this$0.a2ExpireTime);
      ((StringBuilder)localObject2).append(", loginInfo=");
      ((StringBuilder)localObject2).append(paramArrayOfByte.toString());
      ((LogInterface)localObject1).v("LoginImpl", ((StringBuilder)localObject2).toString(), new Object[0]);
      this.this$0.loginInfo = paramArrayOfByte;
      this.this$0.handleCallback(this.val$loginCallback, 0, null, paramArrayOfByte.clone());
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      this.this$0.handleCallback(this.val$loginCallback, -1, paramArrayOfByte.getLocalizedMessage(), null);
      paramArrayOfByte.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.LoginImpWns.1
 * JD-Core Version:    0.7.0.1
 */