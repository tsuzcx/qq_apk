package com.tencent.mobileqq.ar.model;

import amrz;
import amxp;
import anbo;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$22
  implements Runnable
{
  public QQARSession$22(anbo paramanbo, int paramInt) {}
  
  public void run()
  {
    if (anbo.a(this.this$0) == null) {
      QLog.d("AREngine_QQARSession", 1, "onARAnimationComplete mCurARResourceInfo is null!");
    }
    for (;;)
    {
      return;
      if (this.a == 0)
      {
        if (anbo.a(this.this$0).d()) {
          break label289;
        }
        if ((!anbo.a(this.this$0).h()) && (!anbo.a(this.this$0).g()) && (!anbo.a(this.this$0).k())) {
          break label191;
        }
        if ((!anbo.a(this.this$0).j()) || ((anbo.a(this.this$0).g()) && (anbo.a(this.this$0).j()))) {
          anbo.c(this.this$0, true);
        }
      }
      label289:
      while ((anbo.b(this.this$0)) && (this.this$0.a == 2) && (anbo.a(this.this$0) != null))
      {
        amrz localamrz = new amrz(anbo.a(this.this$0));
        anbo.a(this.this$0).a(1, localamrz, this.a);
        return;
        label191:
        if (!anbo.a(this.this$0).j())
        {
          if (anbo.a(this.this$0) == 1L)
          {
            this.this$0.b(1L);
            anbo.b(this.this$0);
          }
          for (;;)
          {
            this.this$0.k();
            break;
            if (anbo.a(this.this$0) == 2L) {
              this.this$0.m();
            } else if (anbo.a(this.this$0) == 2048L) {
              this.this$0.o();
            }
          }
          if ((anbo.a(this.this$0).g()) && (anbo.a(this.this$0).j())) {
            anbo.c(this.this$0, true);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.22
 * JD-Core Version:    0.7.0.1
 */