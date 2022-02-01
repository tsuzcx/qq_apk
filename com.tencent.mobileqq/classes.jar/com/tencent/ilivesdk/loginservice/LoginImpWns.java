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
    localLoginRequest.jdField_b_of_type_JavaLangString = this.accountId;
    localLoginRequest.jdField_a_of_type_Int = Integer.parseInt(this.clientType);
    if (this.authAppId == null) {}
    for (Object localObject = "";; localObject = this.authAppId)
    {
      localLoginRequest.d = ((String)localObject);
      localLoginRequest.c = this.authKey;
      localLoginRequest.jdField_a_of_type_JavaLangString = this.deviceId;
      localLoginRequest.jdField_b_of_type_Int = Integer.parseInt(this.versionCode);
      localLoginRequest.e = getExtData();
      localObject = MessageNano.toByteArray(localLoginRequest);
      this.loginServiceAdapter.getChannel().sendWithTRpc("ilive-login_svr-login_svr", "Login", (byte[])localObject, new LoginImpWns.1(this, paramLoginCallback));
      return;
    }
  }
  
  protected String wrapConfigJson(ConfigKeyValue paramConfigKeyValue)
  {
    localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    try
    {
      localJSONObject1.put("items", localJSONArray);
      int i = 0;
      while (i < paramConfigKeyValue.a.length)
      {
        KeyValueItem localKeyValueItem = paramConfigKeyValue.a[i];
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("key", localKeyValueItem.jdField_a_of_type_JavaLangString);
        localJSONObject2.put("value", localKeyValueItem.jdField_b_of_type_JavaLangString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.loginservice.LoginImpWns
 * JD-Core Version:    0.7.0.1
 */