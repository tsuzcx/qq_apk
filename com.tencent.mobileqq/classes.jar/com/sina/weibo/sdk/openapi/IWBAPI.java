package com.sina.weibo.sdk.openapi;

import android.content.Context;
import android.content.Intent;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.WbAuthListener;
import com.sina.weibo.sdk.share.WbShareCallback;

public abstract interface IWBAPI
{
  public abstract void authorize(WbAuthListener paramWbAuthListener);
  
  public abstract void authorizeCallback(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void authorizeClient(WbAuthListener paramWbAuthListener);
  
  public abstract void authorizeWeb(WbAuthListener paramWbAuthListener);
  
  public abstract void doResultIntent(Intent paramIntent, WbShareCallback paramWbShareCallback);
  
  public abstract boolean isWBAppInstalled();
  
  public abstract boolean isWBAppSupportMultipleImage();
  
  public abstract void registerApp(Context paramContext, AuthInfo paramAuthInfo);
  
  public abstract void setLoggerEnable(boolean paramBoolean);
  
  public abstract void shareMessage(WeiboMultiMessage paramWeiboMultiMessage, boolean paramBoolean);
  
  public abstract void shareStory(StoryMessage paramStoryMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.openapi.IWBAPI
 * JD-Core Version:    0.7.0.1
 */