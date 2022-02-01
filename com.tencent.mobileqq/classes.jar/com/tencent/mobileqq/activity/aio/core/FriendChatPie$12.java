package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;

class FriendChatPie$12
  implements Runnable
{
  FriendChatPie$12(FriendChatPie paramFriendChatPie, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.a.sendFailCode == 41)
    {
      QQToast.a(this.this$0.a.getApp(), 2131692004, 0).a();
      return;
    }
    QQToast.a(this.this$0.a.getApp(), 2131719517, 0).a();
    VasWebviewUtil.reportCommercialDrainage(this.this$0.a.getCurrentUin(), "Stick", "Send", "1", 0, 6, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.12
 * JD-Core Version:    0.7.0.1
 */