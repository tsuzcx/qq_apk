package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager;
import com.tencent.qphone.base.util.QLog;

class QQARSession$12
  implements Runnable
{
  QQARSession$12(QQARSession paramQQARSession) {}
  
  public void run()
  {
    QLog.i("AREngine_QQARSession", 1, "processMIGCloudObjectClassifyResult. download resource timeout.");
    QQARSession.a(this.this$0).b();
    this.this$0.b(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.12
 * JD-Core Version:    0.7.0.1
 */