package com.sina.weibo.sdk.share;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ShareChatActivity$1
  extends Handler
{
  ShareChatActivity$1(ShareChatActivity paramShareChatActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    ShareChatActivity.a(this.z);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.share.ShareChatActivity.1
 * JD-Core Version:    0.7.0.1
 */