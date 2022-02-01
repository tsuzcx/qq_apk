package com.tencent.mobileqq.activity.aio;

import addy;
import afuj;
import afuk;
import android.os.Build;
import bctj;
import bgso;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AIOTimeReporter$1
  implements Runnable
{
  public AIOTimeReporter$1(afuk paramafuk) {}
  
  public void run()
  {
    Object localObject = afuj.a();
    afuk.a(this.this$0, ((afuj)localObject).a());
    if (bgso.a <= 0L)
    {
      afuk.a(this.this$0);
      return;
    }
    String str = "";
    switch (afuk.a(this.this$0))
    {
    default: 
      return;
    case 1: 
      switch (((afuj)localObject).a)
      {
      default: 
        if (addy.a().a())
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("hcState", String.valueOf(addy.a().a()));
          ((HashMap)localObject).put("model", Build.MODEL);
        }
        break;
      }
      break;
    }
    for (;;)
    {
      bctj.a(BaseApplication.getContext()).a(null, str, true, bgso.a, 0L, (HashMap)localObject, "");
      if (QLog.isDevelopLevel()) {
        QLog.d(this.this$0.a, 4, "reportAIOTime: " + str + " cost : " + bgso.a);
      }
      afuk.a(this.this$0);
      return;
      if (!afuk.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = afuk.a();
        break;
      }
      str = afuk.b();
      break;
      if (!afuk.a(this.this$0).equalsIgnoreCase("0"))
      {
        str = afuk.c();
        break;
      }
      str = afuk.d();
      break;
      switch (((afuj)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!afuk.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = afuk.e();
        }
        else
        {
          str = afuk.f();
          continue;
          if (!afuk.a(this.this$0).equalsIgnoreCase("0")) {
            str = afuk.g();
          } else {
            str = afuk.h();
          }
        }
      }
      switch (((afuj)localObject).a)
      {
      }
      for (;;)
      {
        break;
        if (!afuk.a(this.this$0).equalsIgnoreCase("0"))
        {
          str = afuk.i();
        }
        else
        {
          str = afuk.j();
          continue;
          if (!afuk.a(this.this$0).equalsIgnoreCase("0")) {
            str = afuk.k();
          } else {
            str = afuk.l();
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