package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;

class FriendChatPie$10
  implements Runnable
{
  FriendChatPie$10(FriendChatPie paramFriendChatPie, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.a.sendFailCode == 41)
    {
      QQToast.makeText(this.this$0.d.getApp(), 2131888892, 0).show();
      return;
    }
    QQToast.makeText(this.this$0.d.getApp(), 2131916787, 0).show();
    VasWebviewUtil.a(this.this$0.d.getCurrentUin(), "Stick", "Send", "1", 0, 6, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.10
 * JD-Core Version:    0.7.0.1
 */