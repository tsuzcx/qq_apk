package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager;
import com.tencent.qphone.base.util.QLog;

class QQARSession$11
  implements Runnable
{
  QQARSession$11(QQARSession paramQQARSession) {}
  
  public void run()
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudObjectClassifyResult. download resource timeout.");
    QQARSession.g(this.this$0).c();
    this.this$0.b(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.11
 * JD-Core Version:    0.7.0.1
 */