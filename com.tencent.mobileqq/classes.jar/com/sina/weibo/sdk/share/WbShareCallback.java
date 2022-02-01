package com.sina.weibo.sdk.share;

import com.sina.weibo.sdk.common.UiError;

public abstract interface WbShareCallback
{
  public abstract void onCancel();
  
  public abstract void onComplete();
  
  public abstract void onError(UiError paramUiError);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.sina.weibo.sdk.share.WbShareCallback
 * JD-Core Version:    0.7.0.1
 */