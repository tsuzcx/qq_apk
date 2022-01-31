package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;

public class BaseChatPie$1
  implements Runnable
{
  BaseChatPie$1(BaseChatPie paramBaseChatPie) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.a, 2, "mRunOnShow 800 hasDestory=" + this.this$0.N);
    }
    if ((this.this$0.A) || (this.this$0.N))
    {
      QLog.i(this.this$0.a, 1, "onShowFirst return|3 hasDestory:" + this.this$0.N);
      return;
    }
    this.this$0.n(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.1
 * JD-Core Version:    0.7.0.1
 */