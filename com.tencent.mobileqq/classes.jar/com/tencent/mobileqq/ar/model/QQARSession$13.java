package com.tencent.mobileqq.ar.model;

import appj;
import apse;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$13
  implements Runnable
{
  public QQARSession$13(apse paramapse) {}
  
  public void run()
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult. download resource timeout.");
    apse.a(this.this$0).b();
    this.this$0.c(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.13
 * JD-Core Version:    0.7.0.1
 */