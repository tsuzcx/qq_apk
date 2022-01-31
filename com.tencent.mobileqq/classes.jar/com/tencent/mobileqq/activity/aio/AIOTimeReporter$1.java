package com.tencent.mobileqq.activity.aio;

import aabg;
import actb;
import actc;
import android.os.Build;
import axrn;
import bbkj;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AIOTimeReporter$1
  implements Runnable
{
  public AIOTimeReporter$1(actc paramactc) {}
  
  public void run()
  {
    Object localObject = actb.a();
    actc.a(this.this$0, ((actb)localObject).a());
    if (bbkj.a <= 0L)
    {
      actc.a(this.this$0);
      return;
    }
    String str = "";
    switch (actc.a(this.this$0))
    {
    default: 
      return;
    case 1: 
      switch (((actb)localObject).a)
      {
      default: 
        if (aabg.a().a())
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("hcState", String.valueOf(aabg.a().a()));
          ((HashMap)localObject).put("model", Build.MODEL);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      axrn.a(BaseApplication.getContext()).a(null, str, true, bbkj.a, 0L, (HashMap)localObject, "");
      if (QLog.isDevelopLevel()) {
        QLog.d(this.this$0.a, 4, "reportAIOTime: " + str + " cost : " + bbkj.a);
      }
      actc.a(this.this$0);
      return;
      if (!actc.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = actc.a();
        break;
      }
      str = actc.b();
      break;
      if (!actc.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = actc.c();
        break;
      }
      str = actc.d();
      break;
      switch (((actb)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!actc.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = actc.e();
        }
        else
        {
          str = actc.f();
          continue;
          if (!actc.a(this.this$0).equalsIgnoreCase("0")) {
            str = actc.g();
          } else {
            str = actc.h();
          }
        }
      }
      switch (((actb)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!actc.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = actc.i();
        }
        else
        {
          str = actc.j();
          continue;
          if (!actc.a(this.this$0).equalsIgnoreCase("0")) {
            str = actc.k();
          } else {
            str = actc.l();
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