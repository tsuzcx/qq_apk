package com.tencent.mobileqq.activity.aio.rebuild;

import agso;
import com.tencent.qphone.base.util.QLog;

public class MultiForwardChatPie$4
  implements Runnable
{
  public MultiForwardChatPie$4(agso paramagso) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.a, 2, "mRunOnShow 800 hasDestory=" + this.this$0.N);
    }
    if ((agso.a(this.this$0)) || (this.this$0.N))
    {
      QLog.i(this.this$0.a, 1, "onShowFirst return|3 hasDestory:" + this.this$0.N);
      return;
    }
    agso.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.4
 * JD-Core Version:    0.7.0.1
 */