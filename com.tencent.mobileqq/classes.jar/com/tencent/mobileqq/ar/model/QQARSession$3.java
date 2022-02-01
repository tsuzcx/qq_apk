package com.tencent.mobileqq.ar.model;

import com.tencent.qphone.base.util.QLog;

class QQARSession$3
  implements Runnable
{
  QQARSession$3(QQARSession paramQQARSession) {}
  
  public void run()
  {
    this.this$0.f();
    QLog.i("AREngine_QQARSession", 1, "stop end. mCurEngineState = " + this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.3
 * JD-Core Version:    0.7.0.1
 */