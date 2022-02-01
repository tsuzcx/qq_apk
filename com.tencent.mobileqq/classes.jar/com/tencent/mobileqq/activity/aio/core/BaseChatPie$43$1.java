package com.tencent.mobileqq.activity.aio.core;

import android.os.Message;
import mqq.os.MqqHandler;

class BaseChatPie$43$1
  implements Runnable
{
  BaseChatPie$43$1(BaseChatPie.43 param43) {}
  
  public void run()
  {
    CharSequence localCharSequence = this.this$1.this$0.chatPieHelper.a(this.this$1.val$intent, this.this$1.val$message);
    this.this$1.this$0.uiHandler.obtainMessage(95, localCharSequence).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.43.1
 * JD-Core Version:    0.7.0.1
 */