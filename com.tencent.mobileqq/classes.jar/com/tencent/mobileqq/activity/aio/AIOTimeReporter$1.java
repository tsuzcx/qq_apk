package com.tencent.mobileqq.activity.aio;

import android.os.Build;
import com.tencent.mm.hardcoder.HardCoderManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AIOTimeReporter$1
  implements Runnable
{
  AIOTimeReporter$1(AIOTimeReporter paramAIOTimeReporter) {}
  
  public void run()
  {
    Object localObject = AIOReporterGetDeviceInfo.a();
    AIOTimeReporter.a(this.this$0, ((AIOReporterGetDeviceInfo)localObject).a());
    if (StartupTracker.a <= 0L)
    {
      AIOTimeReporter.a(this.this$0);
      return;
    }
    String str = "";
    switch (AIOTimeReporter.a(this.this$0))
    {
    default: 
      return;
    case 1: 
      switch (((AIOReporterGetDeviceInfo)localObject).a)
      {
      default: 
        if (HardCoderManager.a().a())
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("hcState", String.valueOf(HardCoderManager.a().a()));
          ((HashMap)localObject).put("model", Build.MODEL);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, StartupTracker.a, 0L, (HashMap)localObject, "");
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.aio.AIOTimeReporter", 4, "reportAIOTime: " + str + " cost : " + StartupTracker.a);
      }
      AIOTimeReporter.a(this.this$0);
      return;
      if (!AIOTimeReporter.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = AIOTimeReporter.a();
        break;
      }
      str = AIOTimeReporter.b();
      break;
      if (!AIOTimeReporter.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = AIOTimeReporter.c();
        break;
      }
      str = AIOTimeReporter.d();
      break;
      switch (((AIOReporterGetDeviceInfo)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!AIOTimeReporter.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = AIOTimeReporter.e();
        }
        else
        {
          str = AIOTimeReporter.f();
          continue;
          if (!AIOTimeReporter.a(this.this$0).equalsIgnoreCase("0")) {
            str = AIOTimeReporter.g();
          } else {
            str = AIOTimeReporter.h();
          }
        }
      }
      switch (((AIOReporterGetDeviceInfo)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!AIOTimeReporter.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = AIOTimeReporter.i();
        }
        else
        {
          str = AIOTimeReporter.j();
          continue;
          if (!AIOTimeReporter.a(this.this$0).equalsIgnoreCase("0")) {
            str = AIOTimeReporter.k();
          } else {
            str = AIOTimeReporter.l();
          }
        }
      }
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTimeReporter.1
 * JD-Core Version:    0.7.0.1
 */