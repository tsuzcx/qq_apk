package com.tencent.mobileqq.activity.aio;

import abws;
import aepa;
import aepb;
import android.os.Build;
import azri;
import bdnm;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AIOTimeReporter$1
  implements Runnable
{
  public AIOTimeReporter$1(aepb paramaepb) {}
  
  public void run()
  {
    Object localObject = aepa.a();
    aepb.a(this.this$0, ((aepa)localObject).a());
    if (bdnm.a <= 0L)
    {
      aepb.a(this.this$0);
      return;
    }
    String str = "";
    switch (aepb.a(this.this$0))
    {
    default: 
      return;
    case 1: 
      switch (((aepa)localObject).a)
      {
      default: 
        if (abws.a().a())
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("hcState", String.valueOf(abws.a().a()));
          ((HashMap)localObject).put("model", Build.MODEL);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      azri.a(BaseApplication.getContext()).a(null, str, true, bdnm.a, 0L, (HashMap)localObject, "");
      if (QLog.isDevelopLevel()) {
        QLog.d(this.this$0.a, 4, "reportAIOTime: " + str + " cost : " + bdnm.a);
      }
      aepb.a(this.this$0);
      return;
      if (!aepb.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = aepb.a();
        break;
      }
      str = aepb.b();
      break;
      if (!aepb.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = aepb.c();
        break;
      }
      str = aepb.d();
      break;
      switch (((aepa)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!aepb.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = aepb.e();
        }
        else
        {
          str = aepb.f();
          continue;
          if (!aepb.a(this.this$0).equalsIgnoreCase("0")) {
            str = aepb.g();
          } else {
            str = aepb.h();
          }
        }
      }
      switch (((aepa)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!aepb.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = aepb.i();
        }
        else
        {
          str = aepb.j();
          continue;
          if (!aepb.a(this.this$0).equalsIgnoreCase("0")) {
            str = aepb.k();
          } else {
            str = aepb.l();
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