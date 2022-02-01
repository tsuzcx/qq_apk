package com.tencent.biz.pubaccount.readinjoy.handlers;

import com.tencent.biz.pubaccount.readinjoy.guidingchannel.ReadInJoyChannelGuidingManager;
import com.tencent.qphone.base.util.QLog;

class FrameworkHandler$6
  implements Runnable
{
  FrameworkHandler$6(FrameworkHandler paramFrameworkHandler) {}
  
  public void run()
  {
    if (ReadInJoyChannelGuidingManager.a(this.this$0.b()))
    {
      this.this$0.a(true, 1);
      QLog.i("FrameworkHandler", 1, "[handleDailyJumpToRecommendChannel], backToTop refresh, channelID = " + this.this$0.b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.handlers.FrameworkHandler.6
 * JD-Core Version:    0.7.0.1
 */