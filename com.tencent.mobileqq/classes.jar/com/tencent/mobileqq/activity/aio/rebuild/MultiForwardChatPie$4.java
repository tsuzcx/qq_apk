package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.qphone.base.util.QLog;

class MultiForwardChatPie$4
  implements Runnable
{
  MultiForwardChatPie$4(MultiForwardChatPie paramMultiForwardChatPie) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.b, 2, "mRunOnShow 800 hasDestory=" + this.this$0.I);
    }
    if ((this.this$0.w) || (this.this$0.I))
    {
      QLog.i(this.this$0.b, 1, "onShowFirst return|3 hasDestory:" + this.this$0.I);
      return;
    }
    MultiForwardChatPie.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.4
 * JD-Core Version:    0.7.0.1
 */