package com.tencent.mobileqq.ar.model;

import aovf;
import apap;
import apeo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$22
  implements Runnable
{
  public QQARSession$22(apeo paramapeo, int paramInt) {}
  
  public void run()
  {
    if (apeo.a(this.this$0) == null) {
      QLog.d("AREngine_QQARSession", 1, "onARAnimationComplete mCurARResourceInfo is null!");
    }
    for (;;)
    {
      return;
      if (this.a == 0)
      {
        if (apeo.a(this.this$0).d()) {
          break label289;
        }
        if ((!apeo.a(this.this$0).h()) && (!apeo.a(this.this$0).g()) && (!apeo.a(this.this$0).k())) {
          break label191;
        }
        if ((!apeo.a(this.this$0).j()) || ((apeo.a(this.this$0).g()) && (apeo.a(this.this$0).j()))) {
          apeo.c(this.this$0, true);
        }
      }
      label289:
      while ((apeo.b(this.this$0)) && (this.this$0.a == 2) && (apeo.a(this.this$0) != null))
      {
        aovf localaovf = new aovf(apeo.a(this.this$0));
        apeo.a(this.this$0).a(1, localaovf, this.a);
        return;
        label191:
        if (!apeo.a(this.this$0).j())
        {
          if (apeo.a(this.this$0) == 1L)
          {
            this.this$0.b(1L);
            apeo.b(this.this$0);
          }
          for (;;)
          {
            this.this$0.k();
            break;
            if (apeo.a(this.this$0) == 2L) {
              this.this$0.m();
            } else if (apeo.a(this.this$0) == 2048L) {
              this.this$0.o();
            }
          }
          if ((apeo.a(this.this$0).g()) && (apeo.a(this.this$0).j())) {
            apeo.c(this.this$0, true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.22
 * JD-Core Version:    0.7.0.1
 */