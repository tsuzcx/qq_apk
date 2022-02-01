package com.sina.weibo.sdk.auth;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class Oauth2AccessToken
{
  protected static final String KEY_ACCESS_TOKEN = "access_token";
  protected static final String KEY_EXPIRES_IN = "expires_in";
  protected static final String KEY_REFRESH_TOKEN = "refresh_token";
  protected static final String KEY_SCREEN_NAME = "userName";
  protected static final String KEY_UID = "uid";
  private String mAccessToken;
  private long mExpiresTime;
  private String mRefreshToken;
  private String mScreenName;
  private String mUid;
  
  public static Oauth2AccessToken parseAccessToken(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      Oauth2AccessToken localOauth2AccessToken = new Oauth2AccessToken();
      localOauth2AccessToken.setUid(paramBundle.getString("uid"));
      localOauth2AccessToken.setScreenName(paramBundle.getString("userName"));
      localOauth2AccessToken.setAccessToken(paramBundle.getString("access_token"));
      localOauth2AccessToken.setRefreshToken(paramBundle.getString("refresh_token"));
      localOauth2AccessToken.setExpiresTime(Long.parseLong(paramBundle.getString("expires_in")) * 1000L);
      return localOauth2AccessToken;
    }
    return null;
  }
  
  public static Oauth2AccessToken parseAccessToken(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        Oauth2AccessToken localOauth2AccessToken = new Oauth2AccessToken();
        localOauth2AccessToken.setUid(paramString.optString("uid"));
        localOauth2AccessToken.setScreenName(paramString.optString("userName"));
        localOauth2AccessToken.setAccessToken(paramString.optString("access_token"));
        localOauth2AccessToken.setExpiresTime(Long.parseLong(paramString.getString("expires_in")) * 1000L);
        localOauth2AccessToken.setRefreshToken(paramString.optString("refresh_token"));
        return localOauth2AccessToken;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public String getAccessToken()
  {
    return this.mAccessToken;
  }
  
  public long getExpiresTime()
  {
    return this.mExpiresTime;
  }
  
  public String getRefreshToken()
  {
    return this.mRefreshToken;
  }
  
  public String getScreenName()
  {
    return this.mScreenName;
  }
  
  public String getUid()
  {
    return this.mUid;
  }
  
  public boolean isSessionValid()
  {
    return (!TextUtils.isEmpty(this.mAccessToken)) && (this.mExpiresTime > 0L);
  }
  
  protected void setAccessToken(String paramString)
  {
    this.mAccessToken = paramString;
  }
  
  protected void setExpiresTime(long paramLong)
  {
    this.mExpiresTime = paramLong;
  }
  
  protected void setRefreshToken(String paramString)
  {
    this.mRefreshToken = paramString;
  }
  
  public void setScreenName(String paramString)
  {
    this.mScreenName = paramString;
  }
  
  protected void setUid(String paramString)
  {
    this.mUid = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.auth.Oauth2AccessToken
 * JD-Core Version:    0.7.0.1
 */