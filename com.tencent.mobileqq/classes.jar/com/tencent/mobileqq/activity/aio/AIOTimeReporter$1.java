package com.tencent.mobileqq.activity.aio;

import acjp;
import aewv;
import aeww;
import android.os.Build;
import bfzg;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AIOTimeReporter$1
  implements Runnable
{
  public AIOTimeReporter$1(aeww paramaeww) {}
  
  public void run()
  {
    Object localObject = aewv.a();
    aeww.a(this.this$0, ((aewv)localObject).a());
    if (bfzg.a <= 0L)
    {
      aeww.a(this.this$0);
      return;
    }
    String str = "";
    switch (aeww.a(this.this$0))
    {
    default: 
      return;
    case 1: 
      switch (((aewv)localObject).a)
      {
      default: 
        if (acjp.a().a())
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("hcState", String.valueOf(acjp.a().a()));
          ((HashMap)localObject).put("model", Build.MODEL);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, bfzg.a, 0L, (HashMap)localObject, "");
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.aio.AIOTimeReporter", 4, "reportAIOTime: " + str + " cost : " + bfzg.a);
      }
      aeww.a(this.this$0);
      return;
      if (!aeww.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = aeww.a();
        break;
      }
      str = aeww.b();
      break;
      if (!aeww.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = aeww.c();
        break;
      }
      str = aeww.d();
      break;
      switch (((aewv)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!aeww.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = aeww.e();
        }
        else
        {
          str = aeww.f();
          continue;
          if (!aeww.a(this.this$0).equalsIgnoreCase("0")) {
            str = aeww.g();
          } else {
            str = aeww.h();
          }
        }
      }
      switch (((aewv)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!aeww.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = aeww.i();
        }
        else
        {
          str = aeww.j();
          continue;
          if (!aeww.a(this.this$0).equalsIgnoreCase("0")) {
            str = aeww.k();
          } else {
            str = aeww.l();
          }
        }
      }
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTimeReporter.1
 * JD-Core Version:    0.7.0.1
 */