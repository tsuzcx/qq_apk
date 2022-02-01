package com.sina.weibo.sdk.b;

import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.net.a;
import com.sina.weibo.sdk.net.b;
import com.sina.weibo.sdk.net.d;
import com.sina.weibo.sdk.net.e.a;

public final class f
  extends c<Void, Void, String>
{
  private com.sina.weibo.sdk.net.c<String> ah;
  private Throwable ai;
  private Oauth2AccessToken al;
  private String appKey;
  
  public f(String paramString, Oauth2AccessToken paramOauth2AccessToken, com.sina.weibo.sdk.net.c<String> paramc)
  {
    this.appKey = paramString;
    this.al = paramOauth2AccessToken;
    this.ah = paramc;
  }
  
  private String q()
  {
    try
    {
      Object localObject = new e.a();
      ((e.a)localObject).url = "https://api.weibo.com/oauth2/access_token";
      localObject = ((e.a)localObject).b("client_id", this.appKey).b("appKey", this.appKey).b("grant_type", "refresh_token").b("refresh_token", this.al.getRefreshToken()).i();
      localObject = new b().a((d)localObject).j();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      this.ai = localThrowable;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.b.f
 * JD-Core Version:    0.7.0.1
 */