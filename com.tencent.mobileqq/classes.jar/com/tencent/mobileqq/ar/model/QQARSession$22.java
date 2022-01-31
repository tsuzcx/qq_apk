package com.tencent.mobileqq.ar.model;

import amwo;
import anby;
import anfx;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$22
  implements Runnable
{
  public QQARSession$22(anfx paramanfx, int paramInt) {}
  
  public void run()
  {
    if (anfx.a(this.this$0) == null) {
      QLog.d("AREngine_QQARSession", 1, "onARAnimationComplete mCurARResourceInfo is null!");
    }
    for (;;)
    {
      return;
      if (this.a == 0)
      {
        if (anfx.a(this.this$0).d()) {
          break label289;
        }
        if ((!anfx.a(this.this$0).h()) && (!anfx.a(this.this$0).g()) && (!anfx.a(this.this$0).k())) {
          break label191;
        }
        if ((!anfx.a(this.this$0).j()) || ((anfx.a(this.this$0).g()) && (anfx.a(this.this$0).j()))) {
          anfx.c(this.this$0, true);
        }
      }
      label289:
      while ((anfx.b(this.this$0)) && (this.this$0.a == 2) && (anfx.a(this.this$0) != null))
      {
        amwo localamwo = new amwo(anfx.a(this.this$0));
        anfx.a(this.this$0).a(1, localamwo, this.a);
        return;
        label191:
        if (!anfx.a(this.this$0).j())
        {
          if (anfx.a(this.this$0) == 1L)
          {
            this.this$0.b(1L);
            anfx.b(this.this$0);
          }
          for (;;)
          {
            this.this$0.k();
            break;
            if (anfx.a(this.this$0) == 2L) {
              this.this$0.m();
            } else if (anfx.a(this.this$0) == 2048L) {
              this.this$0.o();
            }
          }
          if ((anfx.a(this.this$0).g()) && (anfx.a(this.this$0).j())) {
            anfx.c(this.this$0, true);
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