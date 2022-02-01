package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ListenTogetherTheme.AIOMusicSkin;
import mqq.os.MqqHandler;

class BaseChatPie$13$1
  implements Runnable
{
  BaseChatPie$13$1(BaseChatPie.13 param13) {}
  
  public void run()
  {
    if (AIOMusicSkin.a().du_()) {
      return;
    }
    this.a.this$0.ah.H.d = false;
    if (ChatBackground.a(this.a.this$0.e, this.a.this$0.d.getCurrentAccountUin(), this.a.this$0.ah.b, true, 7, this.a.this$0.ah.H)) {
      this.a.this$0.m.sendMessage(this.a.this$0.m.obtainMessage(60, this.a.this$0.ah.H.c));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.13.1
 * JD-Core Version:    0.7.0.1
 */