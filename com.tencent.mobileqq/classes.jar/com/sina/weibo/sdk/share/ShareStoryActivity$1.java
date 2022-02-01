package com.sina.weibo.sdk.share;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ShareStoryActivity$1
  extends Handler
{
  ShareStoryActivity$1(ShareStoryActivity paramShareStoryActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    ShareStoryActivity.a(this.C, "cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.share.ShareStoryActivity.1
 * JD-Core Version:    0.7.0.1
 */