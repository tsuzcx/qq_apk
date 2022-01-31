package com.tencent.mobileqq.activity.aio;

import aabk;
import actf;
import actg;
import android.os.Build;
import axrl;
import bbjv;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AIOTimeReporter$1
  implements Runnable
{
  public AIOTimeReporter$1(actg paramactg) {}
  
  public void run()
  {
    Object localObject = actf.a();
    actg.a(this.this$0, ((actf)localObject).a());
    if (bbjv.a <= 0L)
    {
      actg.a(this.this$0);
      return;
    }
    String str = "";
    switch (actg.a(this.this$0))
    {
    default: 
      return;
    case 1: 
      switch (((actf)localObject).a)
      {
      default: 
        if (aabk.a().a())
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("hcState", String.valueOf(aabk.a().a()));
          ((HashMap)localObject).put("model", Build.MODEL);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      axrl.a(BaseApplication.getContext()).a(null, str, true, bbjv.a, 0L, (HashMap)localObject, "");
      if (QLog.isDevelopLevel()) {
        QLog.d(this.this$0.a, 4, "reportAIOTime: " + str + " cost : " + bbjv.a);
      }
      actg.a(this.this$0);
      return;
      if (!actg.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = actg.a();
        break;
      }
      str = actg.b();
      break;
      if (!actg.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = actg.c();
        break;
      }
      str = actg.d();
      break;
      switch (((actf)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!actg.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = actg.e();
        }
        else
        {
          str = actg.f();
          continue;
          if (!actg.a(this.this$0).equalsIgnoreCase("0")) {
            str = actg.g();
          } else {
            str = actg.h();
          }
        }
      }
      switch (((actf)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!actg.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = actg.i();
        }
        else
        {
          str = actg.j();
          continue;
          if (!actg.a(this.this$0).equalsIgnoreCase("0")) {
            str = actg.k();
          } else {
            str = actg.l();
          }
        }
      }
      localObject = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AIOTimeReporter.1
 * JD-Core Version:    0.7.0.1
 */