package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.ARTarget;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;

class QQARSession$21
  implements Runnable
{
  QQARSession$21(QQARSession paramQQARSession, int paramInt) {}
  
  public void run()
  {
    if ((QQARSession.b(this.this$0)) && (this.this$0.a == 2) && (QQARSession.a(this.this$0) != null))
    {
      ARTarget localARTarget = new ARTarget(QQARSession.a(this.this$0));
      QQARSession.a(this.this$0).a(0, localARTarget, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.21
 * JD-Core Version:    0.7.0.1
 */