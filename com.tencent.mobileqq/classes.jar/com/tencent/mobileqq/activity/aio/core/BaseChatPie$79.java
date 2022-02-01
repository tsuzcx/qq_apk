package com.tencent.mobileqq.activity.aio.core;

import anvk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import mqq.os.MqqHandler;

class BaseChatPie$79
  implements Runnable
{
  BaseChatPie$79(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    ((anvk)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c();
    this.this$0.uiHandler.sendMessage(this.this$0.uiHandler.obtainMessage(64));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.79
 * JD-Core Version:    0.7.0.1
 */