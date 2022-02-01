package com.tencent.mobileqq.activity.aio.core;

import agab;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.mobileqq.widget.QQToast;

public class FriendChatPie$12
  implements Runnable
{
  public FriendChatPie$12(agab paramagab, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.a.sendFailCode == 41)
    {
      QQToast.a(this.this$0.app.getApp(), 2131691879, 0).a();
      return;
    }
    QQToast.a(this.this$0.app.getApp(), 2131718982, 0).a();
    VasWebviewUtil.reportCommercialDrainage(this.this$0.app.getCurrentUin(), "Stick", "Send", "1", 0, 6, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.12
 * JD-Core Version:    0.7.0.1
 */