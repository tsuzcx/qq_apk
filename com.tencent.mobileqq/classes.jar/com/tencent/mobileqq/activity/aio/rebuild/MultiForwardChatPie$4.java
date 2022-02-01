package com.tencent.mobileqq.activity.aio.rebuild;

import ahia;
import com.tencent.qphone.base.util.QLog;

public class MultiForwardChatPie$4
  implements Runnable
{
  public MultiForwardChatPie$4(ahia paramahia) {}
  
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
    ahia.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.4
 * JD-Core Version:    0.7.0.1
 */