package com.tencent.mobileqq.activity.aio.rebuild;

import agnz;
import com.tencent.qphone.base.util.QLog;

public class MultiForwardChatPie$4
  implements Runnable
{
  public MultiForwardChatPie$4(agnz paramagnz) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.a, 2, "mRunOnShow 800 hasDestory=" + this.this$0.N);
    }
    if ((agnz.a(this.this$0)) || (this.this$0.N))
    {
      QLog.i(this.this$0.a, 1, "onShowFirst return|3 hasDestory:" + this.this$0.N);
      return;
    }
    agnz.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.4
 * JD-Core Version:    0.7.0.1
 */