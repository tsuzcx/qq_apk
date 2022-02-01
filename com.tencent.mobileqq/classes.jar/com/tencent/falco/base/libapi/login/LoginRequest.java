package com.tencent.falco.base.libapi.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class LoginRequest
{
  public String appid;
  public String customExtData;
  public String id;
  public boolean initOpenSDK = false;
  public LoginType loginType;
  public String token;
  
  public static LoginRequest getFromSp(Context paramContext)
  {
    LoginRequest localLoginRequest = new LoginRequest();
    paramContext = PreferenceManager.getDefaultSharedPreferences(paramContext);
    localLoginRequest.appid = paramContext.getString("appid", "");
    localLoginRequest.id = paramContext.getString("id", "");
    localLoginRequest.token = paramContext.getString("token", "");
    localLoginRequest.loginType = LoginType.values()[paramContext.getInt("lt", 0)];
    localLoginRequest.customExtData = paramContext.getString("customExtData", "");
    return localLoginRequest;
  }
  
  public void flushToSp(Context paramContext)
  {
    PreferenceManager.getDefaultSharedPreferences(paramContext).edit().putString("appid", this.appid).putString("id", this.id).putString("token", this.token).putInt("lt", this.loginType.ordinal()).putString("customExtData", this.customExtData).commit();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LoginRequest{, loginType=");
    localStringBuilder.append(this.loginType);
    localStringBuilder.append(", appid='");
    localStringBuilder.append(this.appid);
    localStringBuilder.append('\'');
    localStringBuilder.append(", initOpenSDK=");
    localStringBuilder.append(this.initOpenSDK);
    localStringBuilder.append(", customExtData='");
    localStringBuilder.append(this.customExtData);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.login.LoginRequest
 * JD-Core Version:    0.7.0.1
 */