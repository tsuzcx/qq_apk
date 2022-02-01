package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;

class QQARSession$24
  implements Runnable
{
  QQARSession$24(QQARSession paramQQARSession, int paramInt) {}
  
  public void run()
  {
    if (!QQARSession.l(this.this$0).d())
    {
      if (QQARSession.l(this.this$0).j()) {
        QQARSession.m(this.this$0);
      }
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
    if ((QQARSession.b(this.this$0)) && (this.this$0.a == 2) && (QQARSession.h(this.this$0) != null))
    {
      ARTarget localARTarget = new ARTarget(QQARSession.l(this.this$0));
      QQARSession.h(this.this$0).a(3, localARTarget, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.24
 * JD-Core Version:    0.7.0.1
 */