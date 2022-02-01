package com.tencent.mobileqq.activity.aio.core;

import afiw;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;

public class FriendChatPie$2
  implements Runnable
{
  public FriendChatPie$2(afiw paramafiw) {}
  
  public void run()
  {
    if (this.this$0.app.getMessageFacade().getLastMessage(this.this$0.mActivity.getIntent().getStringExtra("uin"), this.this$0.mActivity.getIntent().getIntExtra("uintype", 0)).time < afiw.a(this.this$0)) {
      VipUtils.a(this.this$0.app, "chat_history", "FriendAIO", "SilentCare", 0, 0, new String[] { this.this$0.mActivity.getIntent().getStringExtra("uin") });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.FriendChatPie.2
 * JD-Core Version:    0.7.0.1
 */