package com.tencent.mobileqq.activity.aio.core.input;

import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class MessageSignal$1
  implements Runnable
{
  MessageSignal$1(MessageSignal paramMessageSignal) {}
  
  public void run()
  {
    int i = this.this$0.d();
    if ((MessageSignal.a(this.this$0) == i) && (MessageSignal.b(this.this$0) != 1))
    {
      MessageSignal.c(this.this$0);
    }
    else
    {
      MessageSignal.a(this.this$0, i);
      MessageSignal.b(this.this$0, 0);
    }
    if (MessageSignal.d(this.this$0) <= MessageSignal.e(this.this$0))
    {
      MessageSignal.a(this.this$0).a().sendMsgSignal();
      MessageSignal.f(this.this$0);
      ThreadManager.getSubThreadHandler().postDelayed(MessageSignal.a(this.this$0), 2000L);
      return;
    }
    MessageSignal.a(this.this$0, false);
    MessageSignal.c(this.this$0, 50);
    MessageSignal.b(this.this$0, 0);
    MessageSignal.d(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.input.MessageSignal.1
 * JD-Core Version:    0.7.0.1
 */