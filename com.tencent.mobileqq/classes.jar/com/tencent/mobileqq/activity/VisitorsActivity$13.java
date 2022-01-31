package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import atyt;
import com.tencent.qphone.base.util.QLog;

class VisitorsActivity$13
  implements Runnable
{
  VisitorsActivity$13(VisitorsActivity paramVisitorsActivity) {}
  
  public void run()
  {
    if (this.this$0.isFinishing())
    {
      QLog.d("VisitorsActivity", 1, "doPraiseMallEntryAnim run isFinishing return");
      return;
    }
    atyt.a(this.this$0.app);
    Message localMessage = this.this$0.a.obtainMessage(13, 0, 0);
    this.this$0.a.sendMessageDelayed(localMessage, 100L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.13
 * JD-Core Version:    0.7.0.1
 */