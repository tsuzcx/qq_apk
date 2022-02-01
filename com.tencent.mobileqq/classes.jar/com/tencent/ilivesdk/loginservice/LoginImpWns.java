package com.tencent.ilivesdk.loginservice;

import com.google.protobuf.nano.MessageNano;
import com.tencent.falco.base.libapi.channel.ChannelInterface;
import com.tencent.falco.base.libapi.login.LoginCallback;
import com.tencent.falco.base.libapi.login.LoginServiceAdapter;
import com.tencent.ilivesdk.loginservice.proto.nano.ConfigKeyValue;
import com.tencent.ilivesdk.loginservice.proto.nano.KeyValueItem;
import com.tencent.ilivesdk.loginservice.proto.nano.LoginRequest;
import org.json.JSONArray;
import org.json.JSONObject;

public class LoginImpWns
  extends LoginImpl
{
  public LoginImpWns(LoginServiceAdapter paramLoginServiceAdapter)
  {
    super(paramLoginServiceAdapter);
  }
  
  public void doLogin(LoginCallback paramLoginCallback)
  {
    LoginRequest localLoginRequest = new LoginRequest();
    localLoginRequest.d = this.accountId;
    localLoginRequest.a = Integer.parseInt(this.clientType);
    if (this.authAppId == null) {
      localObject = "";
    } else {
      localObject = this.authAppId;
    }
    localLoginRequest.f = ((String)localObject);
    localLoginRequest.e = this.authKey;
    localLoginRequest.c = this.deviceId;
    localLoginRequest.b = Integer.parseInt(this.versionCode);
    localLoginRequest.g = getExtData();
    Object localObject = MessageNano.toByteArray(localLoginRequest);
    this.loginServiceAdapter.getChannel().sendWithTRpc("ilive-login_svr-login_svr", "Login", (byte[])localObject, new LoginImpWns.1(this, paramLoginCallback));
  }
  
  protected String wrapConfigJson(ConfigKeyValue paramConfigKeyValue)
  {
    localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONObject1.put("items", localJSONArray);
      int i = 0;
      while (i < paramConfigKeyValue.b.length)
      {
        KeyValueItem localKeyValueItem = paramConfigKeyValue.b[i];
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("key", localKeyValueItem.a);
        localJSONObject2.put("value", localKeyValueItem.b);
        localJSONArray.put(localJSONObject2);
        i += 1;
      }
      return localJSONObject1.toString();
    }
    catch (Exception paramConfigKeyValue)
    {
      paramConfigKeyValue.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.LoginImpWns
 * JD-Core Version:    0.7.0.1
 */