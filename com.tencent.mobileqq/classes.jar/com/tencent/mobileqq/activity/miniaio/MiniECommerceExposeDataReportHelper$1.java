package com.tencent.mobileqq.activity.miniaio;

import agwg;
import ajiy;
import ajjs;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class MiniECommerceExposeDataReportHelper$1
  implements Runnable
{
  public MiniECommerceExposeDataReportHelper$1(ajiy paramajiy) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ECommerceExposeDataReportHelper", 2, "mRunOnShow 800");
    }
    ajiy.a(this.this$0, true);
    ThreadManager.getUIHandler().removeCallbacks(ajiy.a(this.this$0));
    ajiy.a(this.this$0).a(ajiy.a(this.this$0).a, ajiy.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniECommerceExposeDataReportHelper.1
 * JD-Core Version:    0.7.0.1
 */