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
    if (paramWbAuthListener == null) {
      throw new RuntimeException("listener can not be null.");
    }
    locala.h = paramWbAuthListener;
    paramWbAuthListener = (Context)locala.g.get();
    if (com.sina.weibo.sdk.a.a(paramWbAuthListener))
    {
      if (com.sina.weibo.sdk.c.a.c(paramWbAuthListener) != null) {}
      for (int i = 1; i != 0; i = 0)
      {
        locala.d();
        return;
      }
    }
    locala.e();
  }
  
  public final void authorizeCallback(int paramInt1, int paramInt2, Intent paramIntent)
  {
    com.sina.weibo.sdk.auth.a locala = this.t;
    c.a("WBSsoTag", "authorizeCallback()");
    String str1;
    String str2;
    String str3;
    if (locala.h != null)
    {
      if (32973 != paramInt1) {
        break label241;
      }
      if (paramInt2 != -1) {
        break label202;
      }
      if (paramIntent != null)
      {
        str1 = paramIntent.getStringExtra("error");
        str2 = paramIntent.getStringExtra("error_type");
        str3 = paramIntent.getStringExtra("error_description");
        if ((!TextUtils.isEmpty(str1)) || (!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3))) {
          break label147;
        }
        paramIntent = Oauth2AccessToken.parseAccessToken(paramIntent.getExtras());
        if (paramIntent == null) {
          break label123;
        }
        AccessTokenHelper.writeAccessToken((Activity)locala.g.get(), paramIntent);
        locala.h.onComplete(paramIntent);
      }
    }
    return;
    label123:
    locala.h.onError(new UiError(-4, "oauth2AccessToken is null", "oauth2AccessToken is null"));
    return;
    label147:
    if (("access_denied".equals(str1)) || ("OAuthAccessDeniedException".equals(str1)))
    {
      locala.h.onCancel();
      return;
    }
    locala.h.onError(new UiError(-5, str2, str3));
    return;
    label202:
    if (paramInt2 == 0)
    {
      locala.h.onCancel();
      return;
    }
    locala.h.onError(new UiError(-6, "result code is error", "result code is error"));
    return;
    label241:
    locala.h.onError(new UiError(-7, "request code is error", "requestCode is error"));
  }
  
  public final void authorizeClient(WbAuthListener paramWbAuthListener)
  {
    com.sina.weibo.sdk.auth.a locala = this.t;
    c.a("WBSsoTag", "authorizeClient()");
    if (paramWbAuthListener == null) {
      throw new RuntimeException("listener can not be null.");
    }
    locala.h = paramWbAuthListener;
    locala.d();
  }
  
  public final void authorizeWeb(WbAuthListener paramWbAuthListener)
  {
    com.sina.weibo.sdk.auth.a locala = this.t;
    c.a("WBSsoTag", "authorizeWeb()");
    if (paramWbAuthListener == null) {
      throw new RuntimeException("listener can not be null.");
    }
    locala.h = paramWbAuthListener;
    locala.e();
  }
  
  public final void doResultIntent(Intent paramIntent, WbShareCallback paramWbShareCallback)
  {
    if ((paramIntent != null) && (paramWbShareCallback != null))
    {
      paramIntent = paramIntent.getExtras();
      if (paramIntent != null)
      {
        int i;
        try
        {
          i = paramIntent.getInt("_weibo_resp_errcode", -1);
          switch (i)
          {
          case 0: 
            paramWbShareCallback.onComplete();
            return;
          }
        }
        catch (Exception paramIntent)
        {
          paramWbShareCallback.onError(new UiError(-1, paramIntent.getMessage(), paramIntent.getMessage()));
          return;
        }
        paramWbShareCallback.onCancel();
        return;
        paramWbShareCallback.onError(new UiError(i, paramIntent.getString("_weibo_resp_errstr"), "error from weibo client!"));
        return;
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
      if (!paramBoolean) {
        break label47;
      }
      ((f)localObject1).b(paramWeiboMultiMessage);
    }
    label47:
    Object localObject3;
    do
    {
      do
      {
        return;
        localObject3 = com.sina.weibo.sdk.c.a.c((Context)localObject2);
        if ((com.sina.weibo.sdk.a.a((Context)localObject2)) && (localObject3 != null))
        {
          localObject2 = com.sina.weibo.sdk.c.a.c((Context)localObject2);
          int i;
          if (localObject2 != null) {
            if (((a.a)localObject2).an > 10000) {
              i = 1;
            }
          }
          while (i != 0)
          {
            ((f)localObject1).b(paramWeiboMultiMessage);
            return;
            i = 0;
            continue;
            i = 0;
          }
        }
        localObject1 = (Activity)((f)localObject1).g.get();
      } while (localObject1 == null);
      localObject2 = com.sina.weibo.sdk.a.a();
    } while (localObject2 == null);
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
  
  public final void shareStory(StoryMessage paramStoryMessage)
  {
    Activity localActivity = (Activity)this.u.g.get();
    if (localActivity != null)
    {
      Object localObject = paramStoryMessage.getImageUri();
      Uri localUri = paramStoryMessage.getVideoUri();
      if (localObject != null) {}
      try
      {
        if ((b.a(localActivity, (Uri)localObject)) || ((localUri != null) && (b.b(localActivity, localUri))))
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
        paramStoryMessage.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.openapi.a
 * JD-Core Version:    0.7.0.1
 */