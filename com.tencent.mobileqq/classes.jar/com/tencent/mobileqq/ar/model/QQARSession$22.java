package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;
import com.tencent.qphone.base.util.QLog;

class QQARSession$22
  implements Runnable
{
  QQARSession$22(QQARSession paramQQARSession, int paramInt) {}
  
  public void run()
  {
    if (QQARSession.a(this.this$0) == null) {
      QLog.d("AREngine_QQARSession", 1, "onARAnimationComplete mCurARResourceInfo is null!");
    }
    for (;;)
    {
      return;
      if (this.a == 0)
      {
        if (QQARSession.a(this.this$0).d()) {
          break label289;
        }
        if ((!QQARSession.a(this.this$0).h()) && (!QQARSession.a(this.this$0).g()) && (!QQARSession.a(this.this$0).k())) {
          break label191;
        }
        if ((!QQARSession.a(this.this$0).j()) || ((QQARSession.a(this.this$0).g()) && (QQARSession.a(this.this$0).j()))) {
          QQARSession.c(this.this$0, true);
        }
      }
      label289:
      while ((QQARSession.b(this.this$0)) && (this.this$0.a == 2) && (QQARSession.a(this.this$0) != null))
      {
        ARTarget localARTarget = new ARTarget(QQARSession.a(this.this$0));
        QQARSession.a(this.this$0).a(1, localARTarget, this.a);
        return;
        label191:
        if (!QQARSession.a(this.this$0).j())
        {
          if (QQARSession.a(this.this$0) == 1L)
          {
            this.this$0.b(1L);
            QQARSession.b(this.this$0);
          }
          for (;;)
          {
            this.this$0.m();
            break;
            if (QQARSession.a(this.this$0) == 2L) {
              this.this$0.o();
            } else if (QQARSession.a(this.this$0) == 2048L) {
              this.this$0.q();
            }
          }
          if ((QQARSession.a(this.this$0).g()) && (QQARSession.a(this.this$0).j())) {
            QQARSession.c(this.this$0, true);
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