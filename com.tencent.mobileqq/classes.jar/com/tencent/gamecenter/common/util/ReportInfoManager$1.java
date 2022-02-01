package com.tencent.gamecenter.common.util;

import android.os.Handler;
import android.os.Message;

class ReportInfoManager$1
  extends Handler
{
  ReportInfoManager$1(ReportInfoManager paramReportInfoManager, long paramLong) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage == null) {
      return;
    }
    if (paramMessage.what != 2) {
      return;
    }
    TrafficStatistics.a("post report", this.a, (short)1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ReportInfoManager.1
 * JD-Core Version:    0.7.0.1
 */