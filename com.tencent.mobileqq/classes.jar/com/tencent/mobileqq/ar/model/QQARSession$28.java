package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.arengine.ARLocalControl;
import com.tencent.qphone.base.util.QLog;

class QQARSession$28
  implements Runnable
{
  QQARSession$28(QQARSession paramQQARSession) {}
  
  public void run()
  {
    if ((this.this$0.a == 2) && (QQARSession.a(this.this$0)))
    {
      if (this.this$0.z())
      {
        this.this$0.y();
        QQARSession.c(this.this$0, 0L);
        QQARSession.a(this.this$0, null);
        QQARSession.b(this.this$0, null);
      }
      this.this$0.a(5L);
      QQARSession.o(this.this$0);
      QQARSession localQQARSession = this.this$0;
      localQQARSession.j = false;
      if (localQQARSession.h != null) {
        this.this$0.h.a(true, QQARSession.p(this.this$0), QQARSession.q(this.this$0));
      }
      QQARSession.a(this.this$0, 1);
      this.this$0.k = true;
      return;
    }
    QLog.d("AREngine_QQARSession", 1, String.format("enterIntoCertainWorkStatus with error status so return", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.28
 * JD-Core Version:    0.7.0.1
 */