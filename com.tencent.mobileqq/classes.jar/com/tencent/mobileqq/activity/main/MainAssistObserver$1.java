package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.message.unread.api.IGuildUnreadCntService;

class MainAssistObserver$1
  implements Runnable
{
  MainAssistObserver$1(MainAssistObserver paramMainAssistObserver) {}
  
  public void run()
  {
    ((IGuildUnreadCntService)this.this$0.a.app.getRuntimeService(IGuildUnreadCntService.class, "")).addObserver(MainAssistObserver.a(this.this$0));
    this.this$0.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.1
 * JD-Core Version:    0.7.0.1
 */