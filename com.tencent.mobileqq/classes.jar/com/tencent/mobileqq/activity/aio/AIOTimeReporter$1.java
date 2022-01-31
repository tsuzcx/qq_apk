package com.tencent.mobileqq.activity.aio;

import absd;
import aekl;
import aekm;
import android.os.Build;
import azmz;
import bdjd;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AIOTimeReporter$1
  implements Runnable
{
  public AIOTimeReporter$1(aekm paramaekm) {}
  
  public void run()
  {
    Object localObject = aekl.a();
    aekm.a(this.this$0, ((aekl)localObject).a());
    if (bdjd.a <= 0L)
    {
      aekm.a(this.this$0);
      return;
    }
    String str = "";
    switch (aekm.a(this.this$0))
    {
    default: 
      return;
    case 1: 
      switch (((aekl)localObject).a)
      {
      default: 
        if (absd.a().a())
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("hcState", String.valueOf(absd.a().a()));
          ((HashMap)localObject).put("model", Build.MODEL);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      azmz.a(BaseApplication.getContext()).a(null, str, true, bdjd.a, 0L, (HashMap)localObject, "");
      if (QLog.isDevelopLevel()) {
        QLog.d(this.this$0.a, 4, "reportAIOTime: " + str + " cost : " + bdjd.a);
      }
      aekm.a(this.this$0);
      return;
      if (!aekm.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = aekm.a();
        break;
      }
      str = aekm.b();
      break;
      if (!aekm.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = aekm.c();
        break;
      }
      str = aekm.d();
      break;
      switch (((aekl)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!aekm.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = aekm.e();
        }
        else
        {
          str = aekm.f();
          continue;
          if (!aekm.a(this.this$0).equalsIgnoreCase("0")) {
            str = aekm.g();
          } else {
            str = aekm.h();
          }
        }
      }
      switch (((aekl)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!aekm.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = aekm.i();
        }
        else
        {
          str = aekm.j();
          continue;
          if (!aekm.a(this.this$0).equalsIgnoreCase("0")) {
            str = aekm.k();
          } else {
            str = aekm.l();
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