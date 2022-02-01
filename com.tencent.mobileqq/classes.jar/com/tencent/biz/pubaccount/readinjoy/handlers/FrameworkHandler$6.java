package com.tencent.biz.pubaccount.readinjoy.handlers;

import com.tencent.qphone.base.util.QLog;
import pru;
import prz;

public class FrameworkHandler$6
  implements Runnable
{
  public FrameworkHandler$6(prz paramprz) {}
  
  public void run()
  {
    if (pru.a(this.this$0.b()))
    {
      this.this$0.a(true, 1);
      QLog.i("FrameworkHandler", 1, "[handleDailyJumpToRecommendChannel], backToTop refresh, channelID = " + this.this$0.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.6
 * JD-Core Version:    0.7.0.1
 */