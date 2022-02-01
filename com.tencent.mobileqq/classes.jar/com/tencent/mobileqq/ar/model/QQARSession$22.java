package com.tencent.mobileqq.ar.model;

import apiv;
import apof;
import apse;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$22
  implements Runnable
{
  public QQARSession$22(apse paramapse, int paramInt) {}
  
  public void run()
  {
    if (apse.a(this.this$0) == null) {
      QLog.d("AREngine_QQARSession", 1, "onARAnimationComplete mCurARResourceInfo is null!");
    }
    for (;;)
    {
      return;
      if (this.a == 0)
      {
        if (apse.a(this.this$0).d()) {
          break label289;
        }
        if ((!apse.a(this.this$0).h()) && (!apse.a(this.this$0).g()) && (!apse.a(this.this$0).k())) {
          break label191;
        }
        if ((!apse.a(this.this$0).j()) || ((apse.a(this.this$0).g()) && (apse.a(this.this$0).j()))) {
          apse.c(this.this$0, true);
        }
      }
      label289:
      while ((apse.b(this.this$0)) && (this.this$0.a == 2) && (apse.a(this.this$0) != null))
      {
        apiv localapiv = new apiv(apse.a(this.this$0));
        apse.a(this.this$0).a(1, localapiv, this.a);
        return;
        label191:
        if (!apse.a(this.this$0).j())
        {
          if (apse.a(this.this$0) == 1L)
          {
            this.this$0.b(1L);
            apse.b(this.this$0);
          }
          for (;;)
          {
            this.this$0.k();
            break;
            if (apse.a(this.this$0) == 2L) {
              this.this$0.m();
            } else if (apse.a(this.this$0) == 2048L) {
              this.this$0.o();
            }
          }
          if ((apse.a(this.this$0).g()) && (apse.a(this.this$0).j())) {
            apse.c(this.this$0, true);
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