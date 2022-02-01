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
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    TrafficStatistics.a("post report", this.jdField_a_of_type_Long, (short)1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.ReportInfoManager.1
 * JD-Core Version:    0.7.0.1
 */