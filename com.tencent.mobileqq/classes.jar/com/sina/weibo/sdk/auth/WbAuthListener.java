package com.sina.weibo.sdk.auth;

import com.sina.weibo.sdk.common.UiError;

public abstract interface WbAuthListener
{
  public abstract void onCancel();
  
  public abstract void onComplete(Oauth2AccessToken paramOauth2AccessToken);
  
  public abstract void onError(UiError paramUiError);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.auth.WbAuthListener
 * JD-Core Version:    0.7.0.1
 */