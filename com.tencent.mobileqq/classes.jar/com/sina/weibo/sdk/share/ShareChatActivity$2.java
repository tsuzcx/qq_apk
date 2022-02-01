package com.sina.weibo.sdk.share;

import android.widget.FrameLayout;
import com.sina.weibo.sdk.api.ChatObject;
import com.sina.weibo.sdk.net.c;

final class ShareChatActivity$2
  implements c<String>
{
  ShareChatActivity$2(ShareChatActivity paramShareChatActivity, ChatObject paramChatObject) {}
  
  public final void onError(Throwable paramThrowable)
  {
    ShareChatActivity.b(this.z).setVisibility(4);
    ShareChatActivity.a(this.z, paramThrowable.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.share.ShareChatActivity.2
 * JD-Core Version:    0.7.0.1
 */