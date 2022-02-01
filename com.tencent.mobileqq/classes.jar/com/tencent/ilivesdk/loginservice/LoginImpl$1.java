package com.tencent.ilivesdk.loginservice;

import android.text.TextUtils;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.login.LoginCallback;
import com.tencent.falco.base.libapi.login.LoginInfo;
import com.tencent.falco.base.libapi.login.LoginServiceAdapter;
import com.tencent.falco.utils.HexUtil;
import com.tencent.falco.utils.TimeUtil;
import java.net.SocketTimeoutException;
import java.net.URL;
import org.json.JSONObject;

class LoginImpl$1
  implements Runnable
{
  LoginImpl$1(LoginImpl paramLoginImpl, LoginCallback paramLoginCallback) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        if (!this.this$0.isTestEnv) {
          break label544;
        }
        localObject1 = "https://test.ilive.qq.com/cgi-bin/core/platform_login/user_login";
        localObject1 = new URL((String)localObject1);
        localObject1 = new JSONObject(new String(this.this$0.request((URL)localObject1, null)));
        int i = ((JSONObject)localObject1).getInt("retcode");
        localObject2 = this.this$0.loginServiceAdapter.getLog();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("retCode = ");
        localStringBuilder.append(i);
        ((LogInterface)localObject2).i("LoginImpl", localStringBuilder.toString(), new Object[0]);
        if (i != 0)
        {
          this.this$0.loginInfo = null;
          this.this$0.handleCallback(this.val$loginCallback, ((JSONObject)localObject1).getInt("retcode"), "鉴权失败", null);
          return;
        }
        localObject1 = ((JSONObject)localObject1).getJSONObject("result");
        this.this$0.loginInfo = new LoginInfo();
        this.this$0.loginInfo.openId = this.this$0.accountId;
        this.this$0.loginInfo.access_token = this.this$0.authKey;
        this.this$0.loginInfo.businessUid = this.this$0.accountId;
        localObject2 = ((JSONObject)localObject1).getString("openid");
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          this.this$0.loginInfo.openId = ((String)localObject2);
        }
        this.this$0.loginInfo.uid = ((JSONObject)localObject1).optLong("uid", 0L);
      }
      catch (Exception localException1)
      {
        Object localObject1;
        Object localObject2;
        this.this$0.handleLoginError(this.val$loginCallback, -1, localException1, "请求错误");
        return;
      }
      catch (SocketTimeoutException localSocketTimeoutException)
      {
        this.this$0.handleLoginError(this.val$loginCallback, -2, localSocketTimeoutException, "请求超时");
        return;
      }
      try
      {
        this.this$0.loginInfo.tinyid = Long.valueOf(((JSONObject)localObject1).optString("tiny_id")).longValue();
      }
      catch (Exception localException2)
      {
        continue;
      }
      this.this$0.loginInfo.tinyid = 0L;
      this.this$0.loginInfo.a2 = HexUtil.hexStr2Bytes(((JSONObject)localObject1).optString("a2", ""));
      this.this$0.loginInfo.loginType = this.this$0.mLoginType;
      this.this$0.loginInfo.configData = ((JSONObject)localObject1).optString("config");
      this.this$0.lastLoginTime = (TimeUtil.getCurrentMillis() / 1000L);
      TimeUtil.setServerUTCTime(((JSONObject)localObject1).optLong("timestamp"));
      this.this$0.a2ExpireTime = ((JSONObject)localObject1).optInt("a2_expire_time");
      localObject1 = this.this$0.loginServiceAdapter.getLog();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("lastLoginTime=");
      ((StringBuilder)localObject2).append(this.this$0.lastLoginTime);
      ((StringBuilder)localObject2).append("a2ExpireTime=");
      ((StringBuilder)localObject2).append(this.this$0.a2ExpireTime);
      ((StringBuilder)localObject2).append(", loginInfo=");
      ((StringBuilder)localObject2).append(this.this$0.loginInfo.toString());
      ((LogInterface)localObject1).i("LoginImpl", ((StringBuilder)localObject2).toString(), new Object[0]);
      this.this$0.handleCallback(this.val$loginCallback, 0, null, this.this$0.loginInfo.clone());
      return;
      label544:
      String str = "https://ilive.qq.com/cgi-bin/core/platform_login/user_login";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.LoginImpl.1
 * JD-Core Version:    0.7.0.1
 */