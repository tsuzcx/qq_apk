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
    AIOTimeReporter.a(this.this$0, ((AIOReporterGetDeviceInfo)localObject).b());
    if (StartupTracker.b <= 0L)
    {
      AIOTimeReporter.a(this.this$0);
      return;
    }
    String str = "";
    int i = AIOTimeReporter.b(this.this$0);
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
            if (!AIOTimeReporter.c(this.this$0).equalsIgnoreCase("0")) {
              str = AIOTimeReporter.l();
            } else {
              str = AIOTimeReporter.m();
            }
          }
        }
        else if (!AIOTimeReporter.c(this.this$0).equalsIgnoreCase("0")) {
          str = AIOTimeReporter.j();
        } else {
          str = AIOTimeReporter.k();
        }
      }
      else
      {
        i = ((AIOReporterGetDeviceInfo)localObject).a;
        if (i != 0)
        {
          if (i == 1) {
            if (!AIOTimeReporter.c(this.this$0).equalsIgnoreCase("0")) {
              str = AIOTimeReporter.h();
            } else {
              str = AIOTimeReporter.i();
            }
          }
        }
        else if (!AIOTimeReporter.c(this.this$0).equalsIgnoreCase("0")) {
          str = AIOTimeReporter.f();
        } else {
          str = AIOTimeReporter.g();
        }
      }
    }
    else
    {
      i = ((AIOReporterGetDeviceInfo)localObject).a;
      if (i != 0)
      {
        if (i == 1) {
          if (!AIOTimeReporter.c(this.this$0).equalsIgnoreCase("0")) {
            str = AIOTimeReporter.d();
          } else {
            str = AIOTimeReporter.e();
          }
        }
      }
      else if (!AIOTimeReporter.c(this.this$0).equalsIgnoreCase("0")) {
        str = AIOTimeReporter.b();
      } else {
        str = AIOTimeReporter.c();
      }
    }
    localObject = null;
    if (HardCoderManager.getInstance().isSupported())
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("hcState", String.valueOf(HardCoderManager.getInstance().getState()));
      ((HashMap)localObject).put("model", Build.MODEL);
    }
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, StartupTracker.b, 0L, (HashMap)localObject, "");
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportAIOTime: ");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" cost : ");
      ((StringBuilder)localObject).append(StartupTracker.b);
      QLog.d("Q.aio.AIOTimeReporter", 4, ((StringBuilder)localObject).toString());
    }
    AIOTimeReporter.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTimeReporter.1
 * JD-Core Version:    0.7.0.1
 */