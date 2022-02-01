package com.tencent.mobileqq.activity.aio.rebuild;

import aimn;
import com.tencent.qphone.base.util.QLog;

public class MultiForwardChatPie$4
  implements Runnable
{
  public MultiForwardChatPie$4(aimn paramaimn) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.a, 2, "mRunOnShow 800 hasDestory=" + this.this$0.M);
    }
    if ((aimn.a(this.this$0)) || (this.this$0.M))
    {
      QLog.i(this.this$0.a, 1, "onShowFirst return|3 hasDestory:" + this.this$0.M);
      return;
    }
    aimn.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.4
 * JD-Core Version:    0.7.0.1
 */