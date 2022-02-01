package com.tencent.mobileqq.activity.aio;

import admw;
import ageb;
import agec;
import android.os.Build;
import bdmc;
import bhsq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AIOTimeReporter$1
  implements Runnable
{
  public AIOTimeReporter$1(agec paramagec) {}
  
  public void run()
  {
    Object localObject = ageb.a();
    agec.a(this.this$0, ((ageb)localObject).a());
    if (bhsq.a <= 0L)
    {
      agec.a(this.this$0);
      return;
    }
    String str = "";
    switch (agec.a(this.this$0))
    {
    default: 
      return;
    case 1: 
      switch (((ageb)localObject).a)
      {
      default: 
        if (admw.a().a())
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("hcState", String.valueOf(admw.a().a()));
          ((HashMap)localObject).put("model", Build.MODEL);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      bdmc.a(BaseApplication.getContext()).a(null, str, true, bhsq.a, 0L, (HashMap)localObject, "");
      if (QLog.isDevelopLevel()) {
        QLog.d("Q.aio.AIOTimeReporter", 4, "reportAIOTime: " + str + " cost : " + bhsq.a);
      }
      agec.a(this.this$0);
      return;
      if (!agec.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = agec.a();
        break;
      }
      str = agec.b();
      break;
      if (!agec.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = agec.c();
        break;
      }
      str = agec.d();
      break;
      switch (((ageb)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!agec.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = agec.e();
        }
        else
        {
          str = agec.f();
          continue;
          if (!agec.a(this.this$0).equalsIgnoreCase("0")) {
            str = agec.g();
          } else {
            str = agec.h();
          }
        }
      }
      switch (((ageb)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!agec.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = agec.i();
        }
        else
        {
          str = agec.j();
          continue;
          if (!agec.a(this.this$0).equalsIgnoreCase("0")) {
            str = agec.k();
          } else {
            str = agec.l();
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