package com.tencent.mobileqq.ar.model;

import andc;
import anfx;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$13
  implements Runnable
{
  public QQARSession$13(anfx paramanfx) {}
  
  public void run()
  {
    QLog.i("AREngine_QQARSession", 1, "processCloudSceneRecogResult. download resource timeout.");
    anfx.a(this.this$0).b();
    this.this$0.c(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.13
 * JD-Core Version:    0.7.0.1
 */