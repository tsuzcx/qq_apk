package com.tencent.biz.pubaccount.readinjoy.handlers;

import com.tencent.qphone.base.util.QLog;
import qcr;
import qcw;

public class FrameworkHandler$5
  implements Runnable
{
  public FrameworkHandler$5(qcw paramqcw) {}
  
  public void run()
  {
    if (qcr.a(this.this$0.b()))
    {
      this.this$0.a(true, 1);
      QLog.i("FrameworkHandler", 1, "[handleDailyJumpToRecommendChannel], backToTop refresh, channelID = " + this.this$0.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.5
 * JD-Core Version:    0.7.0.1
 */