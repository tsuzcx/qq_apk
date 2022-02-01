package com.tencent.mobileqq.activity.aio;

import aczy;
import afog;
import afoh;
import android.os.Build;
import bhhy;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AIOTimeReporter$1
  implements Runnable
{
  public AIOTimeReporter$1(afoh paramafoh) {}
  
  public void run()
  {
    Object localObject = afog.a();
    afoh.a(this.this$0, ((afog)localObject).a());
    if (bhhy.a <= 0L)
    {
      afoh.a(this.this$0);
      return;
    }
    String str = "";
    switch (afoh.a(this.this$0))
    {
    default: 
      return;
    case 1: 
      switch (((afog)localObject).a)
      {
      default: 
        if (aczy.a().a())
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("hcState", String.valueOf(aczy.a().a()));
          ((HashMap)localObject).put("model", Build.MODEL);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, bhhy.a, 0L, (HashMap)localObject, "");
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.aio.AIOTimeReporter", 4, "reportAIOTime: " + str + " cost : " + bhhy.a);
      }
      afoh.a(this.this$0);
      return;
      if (!afoh.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = afoh.a();
        break;
      }
      str = afoh.b();
      break;
      if (!afoh.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = afoh.c();
        break;
      }
      str = afoh.d();
      break;
      switch (((afog)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!afoh.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = afoh.e();
        }
        else
        {
          str = afoh.f();
          continue;
          if (!afoh.a(this.this$0).equalsIgnoreCase("0")) {
            str = afoh.g();
          } else {
            str = afoh.h();
          }
        }
      }
      switch (((afog)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!afoh.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = afoh.i();
        }
        else
        {
          str = afoh.j();
          continue;
          if (!afoh.a(this.this$0).equalsIgnoreCase("0")) {
            str = afoh.k();
          } else {
            str = afoh.l();
          }
        }
      }
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTimeReporter.1
 * JD-Core Version:    0.7.0.1
 */