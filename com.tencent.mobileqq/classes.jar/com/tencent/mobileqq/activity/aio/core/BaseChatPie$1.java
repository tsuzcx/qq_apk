package com.tencent.mobileqq.activity.aio.core;

import com.tencent.qphone.base.util.QLog;

class BaseChatPie$1
  implements Runnable
{
  BaseChatPie$1(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.tag, 2, "mRunOnShow 800 hasDestory=" + this.this$0.hasDestory);
    }
    if ((this.this$0.onShowDone) || (this.this$0.hasDestory))
    {
      QLog.i(this.this$0.tag, 1, "onShowFirst return|3 hasDestory:" + this.this$0.hasDestory);
      return;
    }
    this.this$0.onShowFirst(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.1
 * JD-Core Version:    0.7.0.1
 */