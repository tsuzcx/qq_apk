package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.arengine.ARMarkerResourceManager;
import com.tencent.qphone.base.util.QLog;

class QQARSession$13
  implements Runnable
{
  QQARSession$13(QQARSession paramQQARSession) {}
  
  public void run()
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult. download resource timeout.");
    QQARSession.g(this.this$0).c();
    this.this$0.c(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.13
 * JD-Core Version:    0.7.0.1
 */