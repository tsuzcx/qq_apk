package com.sina.weibo.sdk.auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.c.a.a;
import com.sina.weibo.sdk.c.c;
import com.sina.weibo.sdk.c.e;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.net.h;
import com.sina.weibo.sdk.web.WebActivity;
import java.lang.ref.WeakReference;

public final class a
{
  public WeakReference<Activity> g;
  public WbAuthListener h;
  
  public a(Activity paramActivity)
  {
    this.g = new WeakReference(paramActivity);
  }
  
  public final void d()
  {
    c.a("WBSsoTag", "startClientAuth()");
    try
    {
      Context localContext = (Context)this.g.get();
      Object localObject1 = com.sina.weibo.sdk.c.a.c(localContext);
      Intent localIntent = new Intent();
      localIntent.setClassName(((a.a)localObject1).packageName, ((a.a)localObject1).am);
      localObject1 = com.sina.weibo.sdk.a.a();
      localIntent.putExtra("appKey", ((AuthInfo)localObject1).getAppKey());
      localIntent.putExtra("redirectUri", ((AuthInfo)localObject1).getRedirectUrl());
      localIntent.putExtra("scope", ((AuthInfo)localObject1).getScope());
      localIntent.putExtra("packagename", ((AuthInfo)localObject1).getPackageName());
      localIntent.putExtra("key_hash", ((AuthInfo)localObject1).getHash());
      localIntent.putExtra("_weibo_command_type", 3);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(System.currentTimeMillis());
      localIntent.putExtra("_weibo_transaction", ((StringBuilder)localObject2).toString());
      localObject2 = (Activity)this.g.get();
      if (localObject2 == null)
      {
        this.h.onError(new UiError(-1, "activity is null", ""));
        return;
      }
      if (com.sina.weibo.sdk.c.a.a(localContext, localIntent))
      {
        localIntent.putExtra("aid", e.f((Context)localObject2, ((AuthInfo)localObject1).getAppKey()));
        ((Activity)localObject2).startActivityForResult(localIntent, 32973);
        c.a("WBSsoTag", "start SsoActivity ");
        return;
      }
      this.h.onError(new UiError(-2, "your app is illegal", ""));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      c.b("WBSsoTag", localException.getMessage());
      this.h.onError(new UiError(-3, "occur exception", localException.getMessage()));
    }
  }
  
  public final void e()
  {
    Activity localActivity = (Activity)this.g.get();
    Object localObject2 = new h();
    Object localObject1 = com.sina.weibo.sdk.a.a();
    if (localObject1 == null) {
      return;
    }
    ((h)localObject2).put("client_id", ((AuthInfo)localObject1).getAppKey());
    ((h)localObject2).put("redirect_uri", ((AuthInfo)localObject1).getRedirectUrl());
    ((h)localObject2).put("scope", ((AuthInfo)localObject1).getScope());
    ((h)localObject2).put("packagename", ((AuthInfo)localObject1).getPackageName());
    ((h)localObject2).put("key_hash", ((AuthInfo)localObject1).getHash());
    ((h)localObject2).put("response_type", "code");
    ((h)localObject2).put("version", "0041005000");
    ((h)localObject2).put("luicode", "10000360");
    Object localObject3 = new StringBuilder("OP_");
    ((StringBuilder)localObject3).append(((AuthInfo)localObject1).getAppKey());
    ((h)localObject2).put("lfid", ((StringBuilder)localObject3).toString());
    localObject3 = AccessTokenHelper.readAccessToken(localActivity);
    Object localObject4;
    if (localObject3 != null)
    {
      localObject4 = ((Oauth2AccessToken)localObject3).getAccessToken();
      if (!TextUtils.isEmpty(((Oauth2AccessToken)localObject3).getAccessToken()))
      {
        ((h)localObject2).put("trans_token", (String)localObject4);
        ((h)localObject2).put("trans_access_token", (String)localObject4);
      }
    }
    localObject3 = e.f(localActivity, ((AuthInfo)localObject1).getAppKey());
    if (!TextUtils.isEmpty((CharSequence)localObject3)) {
      ((h)localObject2).put("aid", (String)localObject3);
    }
    localObject3 = new StringBuilder("https://open.weibo.cn/oauth2/authorize?");
    ((StringBuilder)localObject3).append(((h)localObject2).k());
    localObject2 = ((StringBuilder)localObject3).toString();
    if (this.h != null)
    {
      localObject3 = b.f();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(System.currentTimeMillis());
      localObject4 = ((StringBuilder)localObject4).toString();
      ((b)localObject3).a((String)localObject4, this.h);
      localObject3 = new Intent(localActivity, WebActivity.class);
      localObject1 = new com.sina.weibo.sdk.web.b.a((AuthInfo)localObject1, (String)localObject2, (String)localObject4);
      localObject2 = new Bundle();
      ((com.sina.weibo.sdk.web.b.a)localObject1).writeToBundle((Bundle)localObject2);
      ((Intent)localObject3).putExtras((Bundle)localObject2);
      localActivity.startActivity((Intent)localObject3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.auth.a
 * JD-Core Version:    0.7.0.1
 */