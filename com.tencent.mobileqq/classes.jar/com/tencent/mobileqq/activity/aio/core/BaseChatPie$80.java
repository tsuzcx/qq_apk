package com.tencent.mobileqq.activity.aio.core;

import amsw;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.os.MqqHandler;

class BaseChatPie$80
  implements Runnable
{
  BaseChatPie$80(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    ((amsw)this.this$0.app.getManager(51)).c();
    this.this$0.uiHandler.sendMessage(this.this$0.uiHandler.obtainMessage(64));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.80
 * JD-Core Version:    0.7.0.1
 */