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
    if (QQARSession.l(this.this$0) == null)
    {
      QLog.d("AREngine_QQARSession", 1, "onARAnimationComplete mCurARResourceInfo is null!");
      return;
    }
    if (this.a == 0) {
      if (!QQARSession.l(this.this$0).d())
      {
        if ((!QQARSession.l(this.this$0).h()) && (!QQARSession.l(this.this$0).g()) && (!QQARSession.l(this.this$0).k()))
        {
          if (!QQARSession.l(this.this$0).j())
          {
            if (QQARSession.n(this.this$0) == 1L)
            {
              this.this$0.b(1L);
              QQARSession.j(this.this$0);
            }
            else if (QQARSession.n(this.this$0) == 2L)
            {
              this.this$0.B();
            }
            else if (QQARSession.n(this.this$0) == 2048L)
            {
              this.this$0.D();
            }
            this.this$0.x();
          }
        }
        else
        {
          QQARSession.l(this.this$0).j();
          if ((QQARSession.l(this.this$0).g()) && (QQARSession.l(this.this$0).j())) {
            QQARSession.e(this.this$0, true);
          }
        }
      }
      else if ((QQARSession.l(this.this$0).g()) && (QQARSession.l(this.this$0).j())) {
        QQARSession.e(this.this$0, true);
      }
    }
    if ((QQARSession.b(this.this$0)) && (this.this$0.a == 2) && (QQARSession.h(this.this$0) != null))
    {
      ARTarget localARTarget = new ARTarget(QQARSession.l(this.this$0));
      QQARSession.h(this.this$0).a(1, localARTarget, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.22
 * JD-Core Version:    0.7.0.1
 */