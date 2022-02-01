package com.tencent.mobileqq.ar.model;

import com.tencent.qphone.base.util.QLog;

class QQARSession$27
  implements Runnable
{
  QQARSession$27(QQARSession paramQQARSession) {}
  
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
      this.this$0.j = false;
      return;
    }
    QLog.d("AREngine_QQARSession", 1, String.format("enterIntoCertainWorkStatus with error status so return", new Object[0]));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.27
 * JD-Core Version:    0.7.0.1
 */