package com.tencent.mobileqq.activity.aio;

import aciq;
import acir;
import android.os.Build;
import awrn;
import baio;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import zrr;

public class AIOTimeReporter$1
  implements Runnable
{
  public AIOTimeReporter$1(acir paramacir) {}
  
  public void run()
  {
    Object localObject = aciq.a();
    acir.a(this.this$0, ((aciq)localObject).a());
    if (baio.a <= 0L)
    {
      acir.a(this.this$0);
      return;
    }
    String str = "";
    switch (acir.a(this.this$0))
    {
    default: 
      return;
    case 1: 
      switch (((aciq)localObject).a)
      {
      default: 
        if (zrr.a().a())
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("hcState", String.valueOf(zrr.a().a()));
          ((HashMap)localObject).put("model", Build.MODEL);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      awrn.a(BaseApplication.getContext()).a(null, str, true, baio.a, 0L, (HashMap)localObject, "");
      if (QLog.isDevelopLevel()) {
        QLog.d(this.this$0.a, 4, "reportAIOTime: " + str + " cost : " + baio.a);
      }
      acir.a(this.this$0);
      return;
      if (!acir.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = acir.a();
        break;
      }
      str = acir.b();
      break;
      if (!acir.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = acir.c();
        break;
      }
      str = acir.d();
      break;
      switch (((aciq)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!acir.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = acir.e();
        }
        else
        {
          str = acir.f();
          continue;
          if (!acir.a(this.this$0).equalsIgnoreCase("0")) {
            str = acir.g();
          } else {
            str = acir.h();
          }
        }
      }
      switch (((aciq)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!acir.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = acir.i();
        }
        else
        {
          str = acir.j();
          continue;
          if (!acir.a(this.this$0).equalsIgnoreCase("0")) {
            str = acir.k();
          } else {
            str = acir.l();
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