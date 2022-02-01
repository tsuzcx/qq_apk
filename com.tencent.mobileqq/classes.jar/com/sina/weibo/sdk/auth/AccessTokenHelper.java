package com.sina.weibo.sdk.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.sina.weibo.sdk.b.b;
import com.sina.weibo.sdk.b.b.a;
import com.sina.weibo.sdk.b.f;

public class AccessTokenHelper
{
  private static final String PREFERENCES_NAME = "com_weibo_sdk_android";
  
  public static void clearAccessToken(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    paramContext = paramContext.getSharedPreferences("com_weibo_sdk_android", 0).edit();
    paramContext.clear();
    paramContext.apply();
  }
  
  public static Oauth2AccessToken readAccessToken(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Oauth2AccessToken localOauth2AccessToken = new Oauth2AccessToken();
    paramContext = paramContext.getSharedPreferences("com_weibo_sdk_android", 0);
    localOauth2AccessToken.setUid(paramContext.getString("uid", ""));
    localOauth2AccessToken.setScreenName(paramContext.getString("userName", ""));
    localOauth2AccessToken.setAccessToken(paramContext.getString("access_token", ""));
    localOauth2AccessToken.setRefreshToken(paramContext.getString("refresh_token", ""));
    localOauth2AccessToken.setExpiresTime(paramContext.getLong("expires_in", 0L));
    return localOauth2AccessToken;
  }
  
  public static void refreshAccessToken(Context paramContext, String paramString)
  {
    Oauth2AccessToken localOauth2AccessToken = readAccessToken(paramContext);
    if (localOauth2AccessToken != null)
    {
      paramContext = new f(paramString, localOauth2AccessToken, new AccessTokenHelper.1(paramContext));
      b.a.n().a(paramContext);
    }
  }
  
  public static void writeAccessToken(Context paramContext, Oauth2AccessToken paramOauth2AccessToken)
  {
    if ((paramContext != null) && (paramOauth2AccessToken != null))
    {
      if (TextUtils.isEmpty(paramOauth2AccessToken.getAccessToken())) {
        return;
      }
      paramContext = paramContext.getSharedPreferences("com_weibo_sdk_android", 0).edit();
      paramContext.putString("uid", paramOauth2AccessToken.getUid());
      paramContext.putString("userName", paramOauth2AccessToken.getScreenName());
      paramContext.putString("access_token", paramOauth2AccessToken.getAccessToken());
      paramContext.putString("refresh_token", paramOauth2AccessToken.getRefreshToken());
      paramContext.putLong("expires_in", paramOauth2AccessToken.getExpiresTime());
      paramContext.apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.auth.AccessTokenHelper
 * JD-Core Version:    0.7.0.1
 */