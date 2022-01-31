package com.tencent.mobileqq.ar.model;

import albj;
import algz;
import alky;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$22
  implements Runnable
{
  public QQARSession$22(alky paramalky, int paramInt) {}
  
  public void run()
  {
    if (alky.a(this.this$0) == null) {
      QLog.d("AREngine_QQARSession", 1, "onARAnimationComplete mCurARResourceInfo is null!");
    }
    for (;;)
    {
      return;
      if (this.a == 0)
      {
        if (alky.a(this.this$0).d()) {
          break label289;
        }
        if ((!alky.a(this.this$0).h()) && (!alky.a(this.this$0).g()) && (!alky.a(this.this$0).k())) {
          break label191;
        }
        if ((!alky.a(this.this$0).j()) || ((alky.a(this.this$0).g()) && (alky.a(this.this$0).j()))) {
          alky.c(this.this$0, true);
        }
      }
      label289:
      while ((alky.b(this.this$0)) && (this.this$0.a == 2) && (alky.a(this.this$0) != null))
      {
        albj localalbj = new albj(alky.a(this.this$0));
        alky.a(this.this$0).a(1, localalbj, this.a);
        return;
        label191:
        if (!alky.a(this.this$0).j())
        {
          if (alky.a(this.this$0) == 1L)
          {
            this.this$0.b(1L);
            alky.b(this.this$0);
          }
          for (;;)
          {
            this.this$0.k();
            break;
            if (alky.a(this.this$0) == 2L) {
              this.this$0.m();
            } else if (alky.a(this.this$0) == 2048L) {
              this.this$0.o();
            }
          }
          if ((alky.a(this.this$0).g()) && (alky.a(this.this$0).j())) {
            alky.c(this.this$0, true);
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