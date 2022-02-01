package com.tencent.mobileqq.antiphing;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class AntiphishingUrlConfig$1
  extends Handler
{
  AntiphishingUrlConfig$1(AntiphishingUrlConfig paramAntiphishingUrlConfig, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == AntiphishingUrlConfig.a(this.a))
    {
      QLog.d(AntiphishingUrlConfig.a(this.a), 4, "Receive Message!");
      this.a.a();
    }
    for (;;)
    {
      try
      {
        ReportController.b(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", "config", 0, 1, "", "", "", "");
        return;
      }
      catch (Exception paramMessage) {}
      if (paramMessage.what == AntiphishingUrlConfig.b(this.a))
      {
        QLog.d(AntiphishingUrlConfig.a(this.a), 4, "Receive Message!");
        try
        {
          ReportController.b(null, "P_CliOper", "Safe_Antiphishing", "", "AlertDialog", "config", 0, 0, "", "", "", "");
          return;
        }
        catch (Exception paramMessage) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.antiphing.AntiphishingUrlConfig.1
 * JD-Core Version:    0.7.0.1
 */