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
      Object localObject = com.sina.weibo.sdk.c.a.c(localContext);
      Intent localIntent = new Intent();
      localIntent.setClassName(((a.a)localObject).packageName, ((a.a)localObject).am);
      localObject = com.sina.weibo.sdk.a.a();
      localIntent.putExtra("appKey", ((AuthInfo)localObject).getAppKey());
      localIntent.putExtra("redirectUri", ((AuthInfo)localObject).getRedirectUrl());
      localIntent.putExtra("scope", ((AuthInfo)localObject).getScope());
      localIntent.putExtra("packagename", ((AuthInfo)localObject).getPackageName());
      localIntent.putExtra("key_hash", ((AuthInfo)localObject).getHash());
      localIntent.putExtra("_weibo_command_type", 3);
      localIntent.putExtra("_weibo_transaction", System.currentTimeMillis());
      Activity localActivity = (Activity)this.g.get();
      if (localActivity == null)
      {
        this.h.onError(new UiError(-1, "activity is null", ""));
        return;
      }
      if (com.sina.weibo.sdk.c.a.a(localContext, localIntent))
      {
        localIntent.putExtra("aid", e.f(localActivity, ((AuthInfo)localObject).getAppKey()));
        localActivity.startActivityForResult(localIntent, 32973);
        c.a("WBSsoTag", "start SsoActivity ");
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      c.b("WBSsoTag", localException.getMessage());
      this.h.onError(new UiError(-3, "occur exception", localException.getMessage()));
      return;
    }
    this.h.onError(new UiError(-2, "your app is illegal", ""));
  }
  
  public final void e()
  {
    Activity localActivity = (Activity)this.g.get();
    Object localObject2 = new h();
    Object localObject1 = com.sina.weibo.sdk.a.a();
    if (localObject1 == null) {}
    do
    {
      return;
      ((h)localObject2).put("client_id", ((AuthInfo)localObject1).getAppKey());
      ((h)localObject2).put("redirect_uri", ((AuthInfo)localObject1).getRedirectUrl());
      ((h)localObject2).put("scope", ((AuthInfo)localObject1).getScope());
      ((h)localObject2).put("packagename", ((AuthInfo)localObject1).getPackageName());
      ((h)localObject2).put("key_hash", ((AuthInfo)localObject1).getHash());
      ((h)localObject2).put("response_type", "code");
      ((h)localObject2).put("version", "0041005000");
      ((h)localObject2).put("luicode", "10000360");
      ((h)localObject2).put("lfid", "OP_" + ((AuthInfo)localObject1).getAppKey());
      localObject3 = AccessTokenHelper.readAccessToken(localActivity);
      if (localObject3 != null)
      {
        str = ((Oauth2AccessToken)localObject3).getAccessToken();
        if (!TextUtils.isEmpty(((Oauth2AccessToken)localObject3).getAccessToken()))
        {
          ((h)localObject2).put("trans_token", str);
          ((h)localObject2).put("trans_access_token", str);
        }
      }
      localObject3 = e.f(localActivity, ((AuthInfo)localObject1).getAppKey());
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        ((h)localObject2).put("aid", (String)localObject3);
      }
      localObject3 = "https://open.weibo.cn/oauth2/authorize?" + ((h)localObject2).k();
    } while (this.h == null);
    localObject2 = b.f();
    String str = System.currentTimeMillis();
    ((b)localObject2).a(str, this.h);
    localObject2 = new Intent(localActivity, WebActivity.class);
    localObject1 = new com.sina.weibo.sdk.web.b.a((AuthInfo)localObject1, (String)localObject3, str);
    Object localObject3 = new Bundle();
    ((com.sina.weibo.sdk.web.b.a)localObject1).writeToBundle((Bundle)localObject3);
    ((Intent)localObject2).putExtras((Bundle)localObject3);
    localActivity.startActivity((Intent)localObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.auth.a
 * JD-Core Version:    0.7.0.1
 */