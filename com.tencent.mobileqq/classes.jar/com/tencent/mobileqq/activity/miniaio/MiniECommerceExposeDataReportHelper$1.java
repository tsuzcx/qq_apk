package com.tencent.mobileqq.activity.miniaio;

import aeyd;
import aiei;
import aifb;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class MiniECommerceExposeDataReportHelper$1
  implements Runnable
{
  public MiniECommerceExposeDataReportHelper$1(aiei paramaiei) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ECommerceExposeDataReportHelper", 2, "mRunOnShow 800");
    }
    aiei.a(this.this$0, true);
    ThreadManager.getUIHandler().removeCallbacks(aiei.a(this.this$0));
    aiei.a(this.this$0).a(aiei.a(this.this$0).a, aiei.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniECommerceExposeDataReportHelper.1
 * JD-Core Version:    0.7.0.1
 */