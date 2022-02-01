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
    int i = AIOTimeReporter.a(this.this$0);
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        i = ((AIOReporterGetDeviceInfo)localObject).a;
        if (i != 0)
        {
          if (i == 1) {
            if (!AIOTimeReporter.a(this.this$0).equalsIgnoreCase("0")) {
              str = AIOTimeReporter.k();
            } else {
              str = AIOTimeReporter.l();
            }
          }
        }
        else if (!AIOTimeReporter.a(this.this$0).equalsIgnoreCase("0")) {
          str = AIOTimeReporter.i();
        } else {
          str = AIOTimeReporter.j();
        }
      }
      else
      {
        i = ((AIOReporterGetDeviceInfo)localObject).a;
        if (i != 0)
        {
          if (i == 1) {
            if (!AIOTimeReporter.a(this.this$0).equalsIgnoreCase("0")) {
              str = AIOTimeReporter.g();
            } else {
              str = AIOTimeReporter.h();
            }
          }
        }
        else if (!AIOTimeReporter.a(this.this$0).equalsIgnoreCase("0")) {
          str = AIOTimeReporter.e();
        } else {
          str = AIOTimeReporter.f();
        }
      }
    }
    else
    {
      i = ((AIOReporterGetDeviceInfo)localObject).a;
      if (i != 0)
      {
        if (i == 1) {
          if (!AIOTimeReporter.a(this.this$0).equalsIgnoreCase("0")) {
            str = AIOTimeReporter.c();
          } else {
            str = AIOTimeReporter.d();
          }
        }
      }
      else if (!AIOTimeReporter.a(this.this$0).equalsIgnoreCase("0")) {
        str = AIOTimeReporter.a();
      } else {
        str = AIOTimeReporter.b();
      }
    }
    localObject = null;
    if (HardCoderManager.a().a())
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("hcState", String.valueOf(HardCoderManager.a().a()));
      ((HashMap)localObject).put("model", Build.MODEL);
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, StartupTracker.a, 0L, (HashMap)localObject, "");
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportAIOTime: ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" cost : ");
      ((StringBuilder)localObject).append(StartupTracker.a);
      QLog.d("Q.aio.AIOTimeReporter", 4, ((StringBuilder)localObject).toString());
    }
    AIOTimeReporter.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTimeReporter.1
 * JD-Core Version:    0.7.0.1
 */