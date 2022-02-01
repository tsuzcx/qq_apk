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
    if (QQARSession.a(this.this$0) == null)
    {
      QLog.d("AREngine_QQARSession", 1, "onARAnimationComplete mCurARResourceInfo is null!");
      return;
    }
    if (this.a == 0) {
      if (!QQARSession.a(this.this$0).d())
      {
        if ((!QQARSession.a(this.this$0).h()) && (!QQARSession.a(this.this$0).g()) && (!QQARSession.a(this.this$0).k()))
        {
          if (!QQARSession.a(this.this$0).j())
          {
            if (QQARSession.a(this.this$0) == 1L)
            {
              this.this$0.b(1L);
              QQARSession.b(this.this$0);
            }
            else if (QQARSession.a(this.this$0) == 2L)
            {
              this.this$0.o();
            }
            else if (QQARSession.a(this.this$0) == 2048L)
            {
              this.this$0.q();
            }
            this.this$0.m();
          }
        }
        else
        {
          QQARSession.a(this.this$0).j();
          if ((QQARSession.a(this.this$0).g()) && (QQARSession.a(this.this$0).j())) {
            QQARSession.c(this.this$0, true);
          }
        }
      }
      else if ((QQARSession.a(this.this$0).g()) && (QQARSession.a(this.this$0).j())) {
        QQARSession.c(this.this$0, true);
      }
    }
    if ((QQARSession.b(this.this$0)) && (this.this$0.a == 2) && (QQARSession.a(this.this$0) != null))
    {
      ARTarget localARTarget = new ARTarget(QQARSession.a(this.this$0));
      QQARSession.a(this.this$0).a(1, localARTarget, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.22
 * JD-Core Version:    0.7.0.1
 */