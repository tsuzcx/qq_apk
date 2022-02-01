package com.tencent.mobileqq.activity.miniaio;

import com.tencent.mobileqq.activity.aio.messageexpose.AIOMessageRecordExposeLogic;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class MiniECommerceExposeDataReportHelper$1
  implements Runnable
{
  MiniECommerceExposeDataReportHelper$1(MiniECommerceExposeDataReportHelper paramMiniECommerceExposeDataReportHelper) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ECommerceExposeDataReportHelper", 2, "mRunOnShow 800");
    }
    MiniECommerceExposeDataReportHelper.a(this.this$0, true);
    ThreadManager.getUIHandler().removeCallbacks(MiniECommerceExposeDataReportHelper.a(this.this$0));
    MiniECommerceExposeDataReportHelper.a(this.this$0).a(MiniECommerceExposeDataReportHelper.a(this.this$0).a, MiniECommerceExposeDataReportHelper.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniECommerceExposeDataReportHelper.1
 * JD-Core Version:    0.7.0.1
 */