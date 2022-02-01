package com.sina.weibo.sdk.openapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AccessTokenHelper;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.c.a.a;
import com.sina.weibo.sdk.c.b;
import com.sina.weibo.sdk.c.c;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.share.ShareStoryActivity;
import com.sina.weibo.sdk.share.ShareTransActivity;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.f;
import com.sina.weibo.sdk.web.b.d;
import java.lang.ref.WeakReference;

public final class a
  implements IWBAPI
{
  private Context mContext;
  private com.sina.weibo.sdk.auth.a t;
  private f u;
  
  public a(Context paramContext)
  {
    this.mContext = paramContext;
    this.t = new com.sina.weibo.sdk.auth.a((Activity)this.mContext);
    this.u = new f((Activity)this.mContext);
  }
  
  public final void authorize(WbAuthListener paramWbAuthListener)
  {
    com.sina.weibo.sdk.auth.a locala = this.t;
    c.a("WBSsoTag", "authorize()");
    if (paramWbAuthListener != null)
    {
      locala.h = paramWbAuthListener;
      paramWbAuthListener = (Context)locala.g.get();
      if (com.sina.weibo.sdk.a.a(paramWbAuthListener))
      {
        int i;
        if (com.sina.weibo.sdk.c.a.c(paramWbAuthListener) != null) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          locala.d();
          return;
        }
      }
      locala.e();
      return;
    }
    throw new RuntimeException("listener can not be null.");
  }
  
  public final void authorizeCallback(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.sina.weibo.sdk.auth.a locala = this.t;
    c.a("WBSsoTag", "authorizeCallback()");
    if (locala.h != null) {
      if (32973 == paramInt1)
      {
        if (paramInt2 == -1)
        {
          if (paramIntent != null)
          {
            String str1 = paramIntent.getStringExtra("error");
            String str2 = paramIntent.getStringExtra("error_type");
            String str3 = paramIntent.getStringExtra("error_description");
            if ((TextUtils.isEmpty(str1)) && (TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3)))
            {
              paramIntent = Oauth2AccessToken.parseAccessToken(paramIntent.getExtras());
              if (paramIntent != null)
              {
                AccessTokenHelper.writeAccessToken((Activity)locala.g.get(), paramIntent);
                locala.h.onComplete(paramIntent);
                return;
              }
              locala.h.onError(new UiError(-4, "oauth2AccessToken is null", "oauth2AccessToken is null"));
              return;
            }
            if ((!"access_denied".equals(str1)) && (!"OAuthAccessDeniedException".equals(str1)))
            {
              locala.h.onError(new UiError(-5, str2, str3));
              return;
            }
            locala.h.onCancel();
          }
        }
        else
        {
          if (paramInt2 == 0)
          {
            locala.h.onCancel();
            return;
          }
          locala.h.onError(new UiError(-6, "result code is error", "result code is error"));
        }
      }
      else {
        locala.h.onError(new UiError(-7, "request code is error", "requestCode is error"));
      }
    }
  }
  
  public final void authorizeClient(WbAuthListener paramWbAuthListener)
  {
    com.sina.weibo.sdk.auth.a locala = this.t;
    c.a("WBSsoTag", "authorizeClient()");
    if (paramWbAuthListener != null)
    {
      locala.h = paramWbAuthListener;
      locala.d();
      return;
    }
    throw new RuntimeException("listener can not be null.");
  }
  
  public final void authorizeWeb(WbAuthListener paramWbAuthListener)
  {
    com.sina.weibo.sdk.auth.a locala = this.t;
    c.a("WBSsoTag", "authorizeWeb()");
    if (paramWbAuthListener != null)
    {
      locala.h = paramWbAuthListener;
      locala.e();
      return;
    }
    throw new RuntimeException("listener can not be null.");
  }
  
  public final void doResultIntent(Intent paramIntent, WbShareCallback paramWbShareCallback)
  {
    if ((paramIntent != null) && (paramWbShareCallback != null))
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null) {
        try
        {
          int i = paramIntent.getInt("_weibo_resp_errcode", -1);
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2) {
                return;
              }
              paramWbShareCallback.onError(new UiError(i, paramIntent.getString("_weibo_resp_errstr"), "error from weibo client!"));
              return;
            }
            paramWbShareCallback.onCancel();
            return;
          }
          paramWbShareCallback.onComplete();
          return;
        }
        catch (Exception paramIntent)
        {
          paramWbShareCallback.onError(new UiError(-1, paramIntent.getMessage(), paramIntent.getMessage()));
        }
      }
    }
  }
  
  public final boolean isWBAppInstalled()
  {
    return com.sina.weibo.sdk.a.a(this.mContext);
  }
  
  public final boolean isWBAppSupportMultipleImage()
  {
    return com.sina.weibo.sdk.a.b(this.mContext);
  }
  
  public final void registerApp(Context paramContext, AuthInfo paramAuthInfo)
  {
    com.sina.weibo.sdk.a.a(paramContext, paramAuthInfo);
  }
  
  public final void setLoggerEnable(boolean paramBoolean)
  {
    c.setLoggerEnable(paramBoolean);
  }
  
  public final void shareMessage(WeiboMultiMessage paramWeiboMultiMessage, boolean paramBoolean)
  {
    Object localObject1 = this.u;
    Object localObject2 = (Context)((f)localObject1).g.get();
    if ((localObject2 != null) && ((com.sina.weibo.sdk.a.a((Context)localObject2)) || (!paramBoolean)))
    {
      if (paramBoolean)
      {
        ((f)localObject1).b(paramWeiboMultiMessage);
        return;
      }
      Object localObject3 = com.sina.weibo.sdk.c.a.c((Context)localObject2);
      if ((com.sina.weibo.sdk.a.a((Context)localObject2)) && (localObject3 != null))
      {
        localObject2 = com.sina.weibo.sdk.c.a.c((Context)localObject2);
        int i;
        if ((localObject2 != null) && (((a.a)localObject2).an > 10000)) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          ((f)localObject1).b(paramWeiboMultiMessage);
          return;
        }
      }
      localObject1 = (Activity)((f)localObject1).g.get();
      if (localObject1 != null)
      {
        localObject2 = com.sina.weibo.sdk.a.a();
        if (localObject2 != null)
        {
          localObject2 = new d((AuthInfo)localObject2);
          ((d)localObject2).setContext((Context)localObject1);
          ((d)localObject2).aK = paramWeiboMultiMessage;
          ((d)localObject2).packageName = ((Activity)localObject1).getPackageName();
          paramWeiboMultiMessage = AccessTokenHelper.readAccessToken((Context)localObject1);
          if (paramWeiboMultiMessage != null)
          {
            localObject3 = paramWeiboMultiMessage.getAccessToken();
            if (!TextUtils.isEmpty(paramWeiboMultiMessage.getAccessToken())) {
              ((d)localObject2).ak = ((String)localObject3);
            }
          }
          paramWeiboMultiMessage = new Bundle();
          ((d)localObject2).writeToBundle(paramWeiboMultiMessage);
          localObject2 = new Intent((Context)localObject1, ShareTransActivity.class);
          ((Intent)localObject2).putExtra("start_flag", 0);
          ((Intent)localObject2).putExtra("start_web_activity", "com.sina.weibo.sdk.web.WebActivity");
          ((Intent)localObject2).putExtras(paramWeiboMultiMessage);
          ((Activity)localObject1).startActivityForResult((Intent)localObject2, 10001);
        }
      }
    }
  }
  
  public final void shareStory(StoryMessage paramStoryMessage)
  {
    Activity localActivity = (Activity)this.u.g.get();
    Object localObject;
    Uri localUri;
    if (localActivity != null)
    {
      localObject = paramStoryMessage.getImageUri();
      localUri = paramStoryMessage.getVideoUri();
      if (localObject == null) {}
    }
    try
    {
      if (!b.a(localActivity, (Uri)localObject))
      {
        if ((localUri == null) || (!b.b(localActivity, localUri))) {}
      }
      else
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("_weibo_message_stroy", paramStoryMessage);
        ((Intent)localObject).putExtra("start_flag", 0);
        ((Intent)localObject).setClass(localActivity, ShareStoryActivity.class);
        localActivity.startActivityForResult((Intent)localObject, 10001);
        return;
      }
      throw new IllegalStateException("File only can be Image or Video. ");
    }
    catch (Exception paramStoryMessage)
    {
      label113:
      break label113;
    }
    paramStoryMessage.printStackTrace();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.openapi.a
 * JD-Core Version:    0.7.0.1
 */