package com.tencent.mobileqq.ar.model;

import com.tencent.qphone.base.util.QLog;

class QQARSession$4
  implements Runnable
{
  QQARSession$4(QQARSession paramQQARSession) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uninit run. mIsInited = ");
    ((StringBuilder)localObject).append(QQARSession.b(this.this$0));
    QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
    QQARSession.a(this.this$0);
    localObject = this.this$0;
    ((QQARSession)localObject).a = 5;
    QQARSession.a((QQARSession)localObject, false);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("uninit end. mIsInited = ");
    ((StringBuilder)localObject).append(QQARSession.b(this.this$0));
    QLog.i("AREngine_QQARSession", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.4
 * JD-Core Version:    0.7.0.1
 */